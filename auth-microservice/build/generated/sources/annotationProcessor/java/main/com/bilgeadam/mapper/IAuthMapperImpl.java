package com.bilgeadam.mapper;

import com.bilgeadam.dto.request.CreateProfileRequestDto;
import com.bilgeadam.dto.request.RegisterRequestDto;
import com.bilgeadam.dto.response.LoginResponseDto;
import com.bilgeadam.dto.response.RegisterResponseDto;
import com.bilgeadam.rabbitmq.model.NewCreateUserModel;
import com.bilgeadam.rabbitmq.model.UpdateUserProfileModel;
import com.bilgeadam.repository.entity.Auth;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-02-15T10:50:31+0300",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.5.1.jar, environment: Java 17.0.5 (Amazon.com Inc.)"
)
@Component
public class IAuthMapperImpl implements IAuthMapper {

    @Override
    public Auth fromRequestToAuth(RegisterRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        Auth.AuthBuilder auth = Auth.builder();

        auth.email( dto.getEmail() );
        auth.password( dto.getPassword() );
        auth.role( dto.getRole() );

        return auth.build();
    }

    @Override
    public LoginResponseDto fromAuthToLoginResponseDto(Auth auth) {
        if ( auth == null ) {
            return null;
        }

        LoginResponseDto.LoginResponseDtoBuilder loginResponseDto = LoginResponseDto.builder();

        loginResponseDto.token( auth.getToken() );

        return loginResponseDto.build();
    }

    @Override
    public RegisterResponseDto fromAuthToRegisterResponse(Auth auth) {
        if ( auth == null ) {
            return null;
        }

        RegisterResponseDto.RegisterResponseDtoBuilder registerResponseDto = RegisterResponseDto.builder();

        registerResponseDto.id( auth.getId() );
        registerResponseDto.email( auth.getEmail() );

        return registerResponseDto.build();
    }

    @Override
    public CreateProfileRequestDto fromAuth(Auth auth) {
        if ( auth == null ) {
            return null;
        }

        CreateProfileRequestDto.CreateProfileRequestDtoBuilder createProfileRequestDto = CreateProfileRequestDto.builder();

        createProfileRequestDto.authid( auth.getId() );
        createProfileRequestDto.email( auth.getEmail() );
        createProfileRequestDto.token( auth.getToken() );

        return createProfileRequestDto.build();
    }

    @Override
    public NewCreateUserModel toNewCreateUserModel(Auth auth) {
        if ( auth == null ) {
            return null;
        }

        NewCreateUserModel.NewCreateUserModelBuilder newCreateUserModel = NewCreateUserModel.builder();

        newCreateUserModel.authId( auth.getId() );
        newCreateUserModel.email( auth.getEmail() );

        return newCreateUserModel.build();
    }

    @Override
    public Auth toUserAuth(UpdateUserProfileModel model) {
        if ( model == null ) {
            return null;
        }

        Auth.AuthBuilder auth = Auth.builder();

        auth.email( model.getEmail() );
        auth.activationCode( model.getActivationCode() );

        return auth.build();
    }
}
