package com.caner.service;

import com.caner.dto.request.LoginRequestDto;
import com.caner.dto.request.RegisterRequestDto;
import com.caner.dto.request.UpdateEmailOrUsernameRequestDto;
import com.caner.dto.response.RegisterResponseDto;
import com.caner.exception.AuthManagerException;
import com.caner.exception.ErrorType;
import com.caner.manager.IUserProfileManager;
import com.caner.mapper.IUserMapper;
import com.caner.repository.IAuthRepository;
import com.caner.repository.entity.Auth;
import com.caner.repository.enums.EStatus;
import com.caner.utility.JwtTokenProvider;
import com.caner.utility.ServiceManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class AuthService extends ServiceManager<Auth, Long> {

    private final IAuthRepository authRepository;
    private final IUserProfileManager userProfileManager;

    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    public AuthService(IAuthRepository authRepository,JwtTokenProvider jwtTokenProvider,PasswordEncoder passwordEncoder,IUserProfileManager userProfileManager) {
        super(authRepository);
        this.authRepository = authRepository;
        this.userProfileManager=userProfileManager;
        this.passwordEncoder=passwordEncoder;
        this.jwtTokenProvider=jwtTokenProvider;

    }


    public RegisterResponseDto register(RegisterRequestDto dto) {
        Auth auth = IUserMapper.INSTANCE.fromRequestDtoToUser(dto);
        if (dto.getPassword().equals(dto.getRepassword())) {
            auth.setPassword(passwordEncoder.encode(dto.getPassword()));
            save(auth);
          userProfileManager.createUser(IUserMapper.INSTANCE.fromAuthToNewCreateUserDto(auth));

        }else {
            throw new AuthManagerException(ErrorType.PASSWORD_ERROR);
        }

        RegisterResponseDto responseDto = IUserMapper.INSTANCE.fromAuthToResponseDto(auth);
        return responseDto;
    }

    public String login(LoginRequestDto dto){
        Optional<Auth> auth = authRepository.findOptionalByUsername(dto.getUsername());
        if (auth.isEmpty() || !passwordEncoder.matches(dto.getPassword(), auth.get().getPassword())){
            throw new AuthManagerException(ErrorType.LOGIN_ERROR);
        }
        auth.get().setStatus(EStatus.ACTIVE);
        return jwtTokenProvider.createToken(auth.get().getId())
                .orElseThrow(() -> {throw new AuthManagerException(ErrorType.TOKEN_NOT_CREATED);
                });
    }
    public Boolean update(UpdateEmailOrUsernameRequestDto dto){
        Optional<Auth> user = authRepository.findById(dto.getAuthId());
        if (user.isEmpty()){
            throw new AuthManagerException(ErrorType.USER_NOT_FOUND);
        }
        IUserMapper.INSTANCE.updateUsernameOrEmail(dto, user.get());
        update(user.get());
        return true;
    }

}
