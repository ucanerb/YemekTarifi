package com.caner.mapper;

import com.caner.dto.request.NewCreateUserRequestDto;
import com.caner.dto.request.RegisterRequestDto;
import com.caner.dto.request.UpdateEmailOrUsernameRequestDto;
import com.caner.dto.response.RegisterResponseDto;
import com.caner.repository.entity.Auth;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IUserMapper {
    IUserMapper INSTANCE = Mappers.getMapper(IUserMapper.class);

    Auth fromRequestDtoToUser(final RegisterRequestDto dto);
    @Mapping(source = "id", target = "authId")
    NewCreateUserRequestDto fromAuthToNewCreateUserDto(final Auth auth);



    RegisterResponseDto fromAuthToResponseDto(final Auth auth);


    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateUsernameOrEmail(UpdateEmailOrUsernameRequestDto dto, @MappingTarget Auth auth);
}