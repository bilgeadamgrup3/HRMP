package com.bilgeadam.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum ErrorType {
    INTERNAL_ERROR(5100,"Sunucu Hatası", HttpStatus.INTERNAL_SERVER_ERROR),
    BAD_REQUEST(1100,"Parametre Hatası",HttpStatus.BAD_REQUEST),
    USER_NOT_FOUND(1111,"Boyle Bir kullanıcı bulunamadı",HttpStatus.BAD_REQUEST),
    LOGIN_ERROR(1112,"Kullanıcı adı veya şifre Hatalı",HttpStatus.BAD_REQUEST),
    WEBSITE_MANAGER_NOT_CREATED(1113,"WebsiteManager Olusturulamadi",HttpStatus.BAD_REQUEST),
    INVALID_TOKEN(1114,"Gecersiz Token?",HttpStatus.BAD_REQUEST),
    REGISTER_REPASSWORD_ERROR(1115,"Girilen sifreler uyusmuyor",HttpStatus.BAD_REQUEST),
    DUPLICATE_EMAIL_ERROR(1116,"Girdiginiz E-mail kullanilmakta.",HttpStatus.BAD_REQUEST);

    int code;
    String message;
    HttpStatus httpStatus;
}
