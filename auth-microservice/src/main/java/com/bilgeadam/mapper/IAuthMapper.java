package com.bilgeadam.mapper;

import com.bilgeadam.dto.request.CreateProfileRequestDto;
import com.bilgeadam.dto.request.RegisterRequestDto;
import com.bilgeadam.dto.response.LoginResponseDto;
import com.bilgeadam.dto.response.RegisterResponseDto;
import com.bilgeadam.repository.entity.Auth;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface IAuthMapper {

    IAuthMapper INSTANCE = Mappers.getMapper(IAuthMapper.class);

    Auth fromRequestToAuth(final RegisterRequestDto dto);

    LoginResponseDto fromAuthToLoginResponseDto(final Auth auth);

    RegisterResponseDto fromAuthToRegisterResponse(final  Auth auth);


    @Mappings({
            @Mapping(source = "id", target = "authid")
    })
    CreateProfileRequestDto fromAuth(final Auth auth);

}