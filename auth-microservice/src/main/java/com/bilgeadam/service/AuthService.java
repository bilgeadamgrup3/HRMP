package com.bilgeadam.service;


import com.bilgeadam.dto.request.LoginRequestDto;
import com.bilgeadam.dto.request.RegisterRequestDto;
import com.bilgeadam.dto.response.LoginResponseDto;
import com.bilgeadam.dto.response.RegisterResponseDto;
import com.bilgeadam.exception.AuthMicroserviceException;
import com.bilgeadam.exception.ErrorType;
import com.bilgeadam.manager.UserProfileManager;
import com.bilgeadam.mapper.IAuthMapper;
import com.bilgeadam.repository.AuthRepository;
import com.bilgeadam.repository.entity.Auth;
import com.bilgeadam.repository.entity.Roles;
import com.bilgeadam.utility.CodeGenerator;
import com.bilgeadam.utility.JwtTokenManager;
import com.bilgeadam.utility.ServiceManager;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class AuthService extends ServiceManager<Auth,Long> {

    private final AuthRepository authRepository;
    private final JwtTokenManager jwtTokenManager;
    private final UserProfileManager userProfileManager;

    public AuthService(AuthRepository authRepository, JwtTokenManager jwtTokenManager, UserProfileManager userProfileManager) {
        super(authRepository);
        this.authRepository = authRepository;
        this.jwtTokenManager = jwtTokenManager;
        this.userProfileManager = userProfileManager;
    }

    public LoginResponseDto login(LoginRequestDto dto) {

        Optional<Auth> auth = authRepository.findOptionalByEmailAndPassword(dto.getEmail(), dto.getPassword());
        if(auth.isEmpty()){
            throw new AuthMicroserviceException(ErrorType.LOGIN_ERROR);
        }
        LoginResponseDto loginResponseDto = IAuthMapper.INSTANCE.fromAuthToLoginResponseDto(auth.get());
        Optional<String> token = jwtTokenManager.createToken(auth.get().getId());
        if (token.isEmpty()){
            throw new AuthMicroserviceException(ErrorType.INVALID_TOKEN);
        }
        loginResponseDto.setToken(token.get());
        return loginResponseDto;
    }

    public RegisterResponseDto registerManager(RegisterRequestDto dto) {
        if(!dto.getPassword().equals(dto.getRePassword()))
            throw  new AuthMicroserviceException(ErrorType.REGISTER_REPASSWORD_ERROR);
        if(authRepository.findOptionalByEmail(dto.getEmail()).isPresent()){
            throw new AuthMicroserviceException(ErrorType.DUPLICATE_EMAIL_ERROR);
        }
        Auth auth = IAuthMapper.INSTANCE.fromRequestToAuth(dto);
        auth.setActivationCode(CodeGenerator.generateCode());
        auth.setRole(Roles.GENERAL_MANAGER);
        save(auth);
        userProfileManager.createProfile(IAuthMapper.INSTANCE.fromAuth(auth));
        return IAuthMapper.INSTANCE.fromAuthToLoginResponse(auth);
    }
}
