package com.caner.mapper;

import com.caner.dto.request.NewCreateUserRequestDto;
import com.caner.dto.request.ToAuthPasswordChangeDto;
import com.caner.dto.request.UpdateEmailOrUsernameRequestDto;
import com.caner.dto.request.UserProfileUpdateRequestDto;
import com.caner.dto.response.UserProfileResponseDto;
import com.caner.repository.entity.UserProfile;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IUserProfileMapper {

    IUserProfileMapper INSTANCE = Mappers.getMapper(IUserProfileMapper.class);

    UserProfile fromDtoToUserProfile(final NewCreateUserRequestDto dto);
    UserProfileResponseDto fromUserProfileToDto(final UserProfile userProfile);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    UserProfile updateFromDtoToUserProfile(UserProfileUpdateRequestDto dto, @MappingTarget UserProfile userProfile);

    UpdateEmailOrUsernameRequestDto toUpdateUsernameEmail(final UserProfileUpdateRequestDto dto);
    ToAuthPasswordChangeDto fromUserProfileToAuthPasswordChangeDto(final UserProfile userProfile);

    @Mapping(source = "id", target = "userId")
    UserProfileResponseDto fromUserProfileToResponseDto(final UserProfile userProfile);

    /*

    UserProfile fromRegisterModelToUserProfile(final RegisterModel registerModel);

    RegisterElasticModel fromUserProfileToElasticModel(final UserProfile userProfile);



    Follow fromCreateFollowDtoToFollow(final String followId, final String userId);


    @Mapping(source = "id", target = "userId")
    UserProfileResponseDto fromUserProfileToResponseDto(final UserProfile userProfile);

 */
}
