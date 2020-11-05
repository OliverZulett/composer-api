package com.milankascomposer.composerapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.net.ConnectException;

@ControllerAdvice
public class ExceptionsHandlerController {

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ResponseBody
    public ErrorDetails resourceNotFoundExceptionHandler(ResourceNotFoundException ex) {
        return new ErrorDetails("Item not found", ex.getMessage());
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorDetails illegalArgumentExceptionHandler(IllegalArgumentException ex) {
        return new ErrorDetails("Invalid param in uri request", ex.getMessage());
    }

    @ExceptionHandler(ConnectException.class)
    @ResponseStatus(value = HttpStatus.SERVICE_UNAVAILABLE)
    @ResponseBody
    public ErrorDetails connectExceptionHandler(ConnectException ex) {
        return new ErrorDetails("Service unavailable", ex.getMessage());
    }

}
