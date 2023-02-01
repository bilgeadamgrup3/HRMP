package com.bilgeadam.service;

import com.bilgeadam.dto.request.CreateProfileRequestDto;
import com.bilgeadam.dto.request.DoLoginRequestDto;
import com.bilgeadam.dto.request.RegisterRequestDto;
import com.bilgeadam.dto.response.RegisterResponseDto;
import com.bilgeadam.exception.AuthMicroserviceException;
import com.bilgeadam.exception.ErrorType;
import com.bilgeadam.manager.IUserProfileManager;
import com.bilgeadam.mapper.IAuthMapper;
import com.bilgeadam.repository.IAuthRepository;
import com.bilgeadam.repository.entity.Auth;
import com.bilgeadam.utility.JwtTokenManager;
import com.bilgeadam.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService extends ServiceManager<Auth,Long> {
    private final IAuthRepository repository;
    /**
     * DİKKAT!!!!!
     * kullanmak istediğiniz interface, services, component gibi sınıflardan nesne türetmeke için 2 yolunuz va r
     * @Autowired ile işaretlemek ya da Constructor Injection ile kullanmak.
     */
    private final IUserProfileManager userProfileManager;
    private final JwtTokenManager jwtTokenManager;
    //private final CreateUserProducer createUserProducer;  CreateUserProducer createUserProducer
    public AuthService(IAuthRepository repository, IUserProfileManager userProfileManager,
                       JwtTokenManager jwtTokenManager){
        super(repository);
        this.repository=repository;
        this.userProfileManager = userProfileManager;
        this.jwtTokenManager = jwtTokenManager;
        //this.createUserProducer = createUserProducer;
    }

    /**
     * DİKKAT!!! bu save method u ServiceManager methosunun
     * overload edilmiş halidir. DTO ile işlem yapar.
     *
     * @param dto
     * @return
     */
    public RegisterResponseDto save(RegisterRequestDto dto){
        /**
         * Eğer şifre ile ikinci şifre uyuşmuyor ise, direkt false
         * dönülmesi mantıklıdır.
         */
        if(!dto.getPassword().equals(dto.getRepassword()))
            throw  new AuthMicroserviceException(ErrorType.REGISTER_REPASSWORD_ERROR);
        /**
         * Burada elle dönüşüm yerine Mapper kullanmak daha
         * doğru olacaktır.
         */
        /* Elle dönüşüm işlemi
        save(
                Auth.builder()
                        .email(dto.getEmail())
                        .username(dto.getUsername())
                        .password(dto.getPassword())
                        .build()
        );
         */
        if(repository.findOptionalByUsername(dto.getUsername()).isPresent())
            throw new AuthMicroserviceException(ErrorType.REGISTER_KULLANICIADI_KAYITLI);

        Auth auth = save(IAuthMapper.INSTANCE.fromRegisterRequestDto(dto));
        createUserProducer.converdAndSendMessageCreateUser(CreateUser.builder()
                .authid(auth.getId())
                .username(auth.getUsername())
                .email(auth.getEmail())
                .build());
//        userProfileManager.createProfile(CreateProfileRequestDto.builder()
//                        .token("")
//                        .authid(auth.getId())
//                        .username(auth.getUsername())
//                        .email(auth.getEmail())
//                .build());
        RegisterResponseDto result = IAuthMapper.INSTANCE.fromAuth(auth);
        result.setRegisterstate(100);
        result.setContent(auth.getEmail()+" ile başarı şekilde kayıt oldunuz.");
        return  result;

    }

    public String doLogin(DoLoginRequestDto dto){
        Optional<Auth> auth = repository.findOptionalByUsernameAndPassword(dto.getUsername(), dto.getPassword());
        if(auth.isEmpty())
            throw  new AuthMicroserviceException(ErrorType.LOGIN_ERROR);
        /**
         * Login olan kişiler için özel bir token üretmek mantıklıdır.
         */
        Optional<String> token = jwtTokenManager.createToken(auth.get().getId());
        if(token.isEmpty())
            throw new AuthMicroserviceException(ErrorType.JWT_TOKEN_CREATE_ERROR);
        return token.get();
    }
}
