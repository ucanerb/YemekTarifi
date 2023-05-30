package com.caner.mapper;

import com.caner.dto.request.NewCreateUserRequestDto;
import com.caner.dto.request.RegisterRequestDto;
import com.caner.dto.request.UpdateEmailOrUsernameRequestDto;
import com.caner.dto.response.RegisterResponseDto;
import com.caner.repository.entity.Auth;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-27T17:05:25+0300",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.5.1.jar, environment: Java 18.0.2 (Amazon.com Inc.)"
)
@Component
public class IUserMapperImpl implements IUserMapper {

    @Override
    public Auth fromRequestDtoToUser(RegisterRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        Auth.AuthBuilder<?, ?> auth = Auth.builder();

        auth.email( dto.getEmail() );
        auth.password( dto.getPassword() );
        auth.username( dto.getUsername() );

        return auth.build();
    }

    @Override
    public NewCreateUserRequestDto fromAuthToNewCreateUserDto(Auth auth) {
        if ( auth == null ) {
            return null;
        }

        NewCreateUserRequestDto.NewCreateUserRequestDtoBuilder newCreateUserRequestDto = NewCreateUserRequestDto.builder();

        newCreateUserRequestDto.authId( auth.getId() );
        newCreateUserRequestDto.username( auth.getUsername() );
        newCreateUserRequestDto.email( auth.getEmail() );
        newCreateUserRequestDto.password( auth.getPassword() );

        return newCreateUserRequestDto.build();
    }

    @Override
    public RegisterResponseDto fromAuthToResponseDto(Auth auth) {
        if ( auth == null ) {
            return null;
        }

        RegisterResponseDto.RegisterResponseDtoBuilder registerResponseDto = RegisterResponseDto.builder();

        registerResponseDto.id( auth.getId() );
        registerResponseDto.username( auth.getUsername() );

        return registerResponseDto.build();
    }

    @Override
    public void updateUsernameOrEmail(UpdateEmailOrUsernameRequestDto dto, Auth auth) {
        if ( dto == null ) {
            return;
        }

        if ( dto.getEmail() != null ) {
            auth.setEmail( dto.getEmail() );
        }
        if ( dto.getUsername() != null ) {
            auth.setUsername( dto.getUsername() );
        }
    }
}
