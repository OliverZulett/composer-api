package com.milankas.training.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class PasswordExistingException extends Exception{

    private static final long serialVersionUID = 1L;

    public PasswordExistingException(String message) {
        super(message);
    }

}
