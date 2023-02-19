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
    COMPANY_NOT_CREATED(1100,"Şirket kaydedilmedi",HttpStatus.BAD_REQUEST),

    DUPLICATE_EMAIL_ERROR(1116,"Girdiginiz E-mail kullanilmakta.",HttpStatus.BAD_REQUEST);


    int code;
    String message;
    HttpStatus httpStatus;
}
