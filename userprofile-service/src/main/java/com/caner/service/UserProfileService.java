package com.caner.service;

import com.caner.dto.request.NewCreateUserRequestDto;
import com.caner.dto.request.PasswordChangeDto;
import com.caner.dto.request.UpdateEmailOrUsernameRequestDto;
import com.caner.dto.request.UserProfileUpdateRequestDto;
import com.caner.dto.response.UserProfileResponseDto;
import com.caner.exception.ErrorType;
import com.caner.exception.UserProfileManagerException;
import com.caner.manager.IAuthManager;
import com.caner.mapper.IUserProfileMapper;
import com.caner.repository.IUserProfileRepository;
import com.caner.repository.entity.UserProfile;
import com.caner.repository.enums.EStatus;
import com.caner.utility.JwtTokenProvider;
import com.caner.utility.ServiceManager;
import org.apache.catalina.User;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserProfileService extends ServiceManager<UserProfile, String> {
    private final IUserProfileRepository userProfileRepository;
    private final IAuthManager authManager;
    private final JwtTokenProvider jwtTokenProvider;
    private final PasswordEncoder passwordEncoder;

    public UserProfileService(IUserProfileRepository userProfileRepository,IAuthManager authManager, JwtTokenProvider jwtTokenProvider, PasswordEncoder passwordEncoder) {
        super(userProfileRepository);
        this.userProfileRepository = userProfileRepository;
        this.jwtTokenProvider = jwtTokenProvider;
        this.authManager=authManager;
        this.passwordEncoder = passwordEncoder;
    }

    //@Cacheable(value = "findAll")
    public List<UserProfile> findAll() {
        return userProfileRepository.findAll();
    }

    //@CacheEvict(value = "findAll",allEntries = true)
    public Boolean createUser(NewCreateUserRequestDto dto) {
        try {
            save(IUserProfileMapper.INSTANCE.fromDtoToUserProfile(dto));

            return true;
        } catch (Exception e) {
            throw new RuntimeException("Beklenmeyen bir hata oluştu.");
        }
    }

    public UserProfile update(UserProfileUpdateRequestDto dto) {
        Optional<Long> authId = jwtTokenProvider.getIdFromToken(dto.getToken());
        if (authId.isEmpty()) {
            throw new UserProfileManagerException(ErrorType.INVALID_TOKEN);
        }
        Optional<UserProfile> userProfile = userProfileRepository.findOptionalByAuthId(authId.get());
        if (userProfile.isEmpty()) {
            throw new UserProfileManagerException(ErrorType.USER_NOT_FOUND);
        }
        UpdateEmailOrUsernameRequestDto updateEmailOrUsernameRequestDto =
                IUserProfileMapper.INSTANCE.toUpdateUsernameEmail(dto);
        updateEmailOrUsernameRequestDto.setAuthId(authId.get());
        authManager.updateUsernameOrEmail(updateEmailOrUsernameRequestDto);
        update(IUserProfileMapper.INSTANCE.updateFromDtoToUserProfile(dto, userProfile.get()));
        return userProfile.get();
    }

    public Boolean delete(Long authId){
        Optional<UserProfile> userProfile = userProfileRepository.findOptionalByAuthId(authId);
        if (userProfile.isEmpty()) {
            throw new UserProfileManagerException(ErrorType.USER_NOT_FOUND);
        }
        userProfile.get().setStatus(EStatus.DELETED);
        update(userProfile.get());
        return true;
    }

    public UserProfileResponseDto findOptionalByUsernameIgnoreCase(String username){

        Optional<UserProfile> userProfile =  userProfileRepository.findOptionalByUsernameIgnoreCase(username);
        if (userProfile.isEmpty()){
            throw new UserProfileManagerException(ErrorType.USER_NOT_FOUND);
        }
        UserProfileResponseDto userProfile1 = IUserProfileMapper.INSTANCE.fromUserProfileToDto(userProfile.get());
        return userProfile1;
    }
    public boolean deleteUserById(Long authId){
        Optional<UserProfile> optionalUserProfile = userProfileRepository.findOptionalByAuthId(authId);
        if(optionalUserProfile.isPresent()){
            optionalUserProfile.get().setStatus(EStatus.DELETED);
            update(optionalUserProfile.get());
            return true;
        }
        throw new UserProfileManagerException(ErrorType.USER_NOT_FOUND);
    }

    //@CacheEvict(value = "find-by-username", allEntries = true)
    public Boolean passwordChange(PasswordChangeDto dto){
        Optional<Long> authId = jwtTokenProvider.getIdFromToken(dto.getToken());

        if (authId.isEmpty()){
            throw new UserProfileManagerException(ErrorType.INVALID_TOKEN);
        }
        Optional<UserProfile> userProfile = userProfileRepository.findOptionalByAuthId(authId.get());
        if (userProfile.isPresent()){
            if (passwordEncoder.matches(dto.getOldPassword(), userProfile.get().getPassword())){
                String newPass = dto.getNewPassword();
                userProfile.get().setPassword(passwordEncoder.encode(newPass));
               // cacheManager.getCache("findAll").clear();
                userProfileRepository.save(userProfile.get());
                authManager.passwordChange(IUserProfileMapper.INSTANCE.fromUserProfileToAuthPasswordChangeDto(userProfile.get()));
                return true;
            }else {
                throw new UserProfileManagerException(ErrorType.PASSWORD_ERROR);
            }
        }else {
            throw new UserProfileManagerException(ErrorType.USER_NOT_FOUND);
        }
    }
    public UserProfileResponseDto findByUserProfileDto(Long authId){
        Optional<UserProfile> userProfile = userProfileRepository.findOptionalByAuthId(authId);
        if (userProfile.isEmpty()){
            throw new UserProfileManagerException(ErrorType.USER_NOT_FOUND);

        }
        UserProfileResponseDto userProfileResponseDto = IUserProfileMapper.INSTANCE.fromUserProfileToResponseDto(userProfile.get());
        return userProfileResponseDto;

    }

}
