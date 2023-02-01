package com.bilgeadam.exception;

import lombok.Getter;

@Getter
public class UserProfileException extends RuntimeException{

    private final ErrorType errorType;

    public UserProfileException(ErrorType errorType) {
        super(errorType.getMessage());
        this.errorType = errorType;
    }

    public UserProfileException(ErrorType errorType, String message) {
        super(message);
        this.errorType = errorType;
    }

}
