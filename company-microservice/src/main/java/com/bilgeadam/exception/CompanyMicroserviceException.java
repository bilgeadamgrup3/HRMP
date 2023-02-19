package com.bilgeadam.exception;


import lombok.Getter;

@Getter
public class CompanyMicroserviceException extends RuntimeException{
    private final ErrorType errorType;

    public CompanyMicroserviceException(ErrorType errorType){
        super(errorType.getMessage());
        this.errorType = errorType;
    }

    public CompanyMicroserviceException(ErrorType errorType, String message){
        super(message);
        this.errorType = errorType;
    }
}
