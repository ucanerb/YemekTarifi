package com.caner.mapper;

import com.caner.dto.request.NewCreateUserRequestDto;
import com.caner.dto.request.ToAuthPasswordChangeDto;
import com.caner.dto.request.UpdateEmailOrUsernameRequestDto;
import com.caner.dto.request.UserProfileUpdateRequestDto;
import com.caner.dto.response.UserProfileResponseDto;
import com.caner.repository.entity.UserProfile;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-30T23:26:53+0300",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.5.1.jar, environment: Java 18.0.2 (Amazon.com Inc.)"
)
@Component
public class IUserProfileMapperImpl implements IUserProfileMapper {

    @Override
    public UserProfile fromDtoToUserProfile(NewCreateUserRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        UserProfile.UserProfileBuilder<?, ?> userProfile = UserProfile.builder();

        userProfile.authId( dto.getAuthId() );
        userProfile.email( dto.getEmail() );
        userProfile.password( dto.getPassword() );
        userProfile.username( dto.getUsername() );

        return userProfile.build();
    }

    @Override
    public UserProfileResponseDto fromUserProfileToDto(UserProfile userProfile) {
        if ( userProfile == null ) {
            return null;
        }

        UserProfileResponseDto.UserProfileResponseDtoBuilder userProfileResponseDto = UserProfileResponseDto.builder();

        userProfileResponseDto.authId( userProfile.getAuthId() );
        userProfileResponseDto.name( userProfile.getName() );
        userProfileResponseDto.surname( userProfile.getSurname() );
        userProfileResponseDto.email( userProfile.getEmail() );
        userProfileResponseDto.password( userProfile.getPassword() );
        userProfileResponseDto.username( userProfile.getUsername() );
        userProfileResponseDto.city( userProfile.getCity() );
        userProfileResponseDto.town( userProfile.getTown() );
        userProfileResponseDto.district( userProfile.getDistrict() );
        userProfileResponseDto.street( userProfile.getStreet() );
        userProfileResponseDto.avatar( userProfile.getAvatar() );

        return userProfileResponseDto.build();
    }

    @Override
    public UserProfile updateFromDtoToUserProfile(UserProfileUpdateRequestDto dto, UserProfile userProfile) {
        if ( dto == null ) {
            return userProfile;
        }

        if ( dto.getEmail() != null ) {
            userProfile.setEmail( dto.getEmail() );
        }
        if ( dto.getUsername() != null ) {
            userProfile.setUsername( dto.getUsername() );
        }
        if ( dto.getAvatar() != null ) {
            userProfile.setAvatar( dto.getAvatar() );
        }

        return userProfile;
    }

    @Override
    public UpdateEmailOrUsernameRequestDto toUpdateUsernameEmail(UserProfileUpdateRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        UpdateEmailOrUsernameRequestDto.UpdateEmailOrUsernameRequestDtoBuilder updateEmailOrUsernameRequestDto = UpdateEmailOrUsernameRequestDto.builder();

        updateEmailOrUsernameRequestDto.username( dto.getUsername() );
        updateEmailOrUsernameRequestDto.email( dto.getEmail() );

        return updateEmailOrUsernameRequestDto.build();
    }

    @Override
    public ToAuthPasswordChangeDto fromUserProfileToAuthPasswordChangeDto(UserProfile userProfile) {
        if ( userProfile == null ) {
            return null;
        }

        ToAuthPasswordChangeDto.ToAuthPasswordChangeDtoBuilder toAuthPasswordChangeDto = ToAuthPasswordChangeDto.builder();

        toAuthPasswordChangeDto.authId( userProfile.getAuthId() );
        toAuthPasswordChangeDto.password( userProfile.getPassword() );

        return toAuthPasswordChangeDto.build();
    }

    @Override
    public UserProfileResponseDto fromUserProfileToResponseDto(UserProfile userProfile) {
        if ( userProfile == null ) {
            return null;
        }

        UserProfileResponseDto.UserProfileResponseDtoBuilder userProfileResponseDto = UserProfileResponseDto.builder();

        userProfileResponseDto.userId( userProfile.getId() );
        userProfileResponseDto.authId( userProfile.getAuthId() );
        userProfileResponseDto.name( userProfile.getName() );
        userProfileResponseDto.surname( userProfile.getSurname() );
        userProfileResponseDto.email( userProfile.getEmail() );
        userProfileResponseDto.password( userProfile.getPassword() );
        userProfileResponseDto.username( userProfile.getUsername() );
        userProfileResponseDto.city( userProfile.getCity() );
        userProfileResponseDto.town( userProfile.getTown() );
        userProfileResponseDto.district( userProfile.getDistrict() );
        userProfileResponseDto.street( userProfile.getStreet() );
        userProfileResponseDto.avatar( userProfile.getAvatar() );

        return userProfileResponseDto.build();
    }
}
