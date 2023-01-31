package com.bilgeadam.exception;

import lombok.Getter;

@Getter
public class UserprofileExecption extends RuntimeException{

    private final ErrorType errorType;

    public UserprofileExecption(ErrorType errorType) {
        super(errorType.getMessage());
        this.errorType = errorType;
    }

    public UserprofileExecption(ErrorType errorType, String message) {
        super(message);
        this.errorType = errorType;
    }

}
