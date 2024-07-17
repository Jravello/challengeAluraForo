package com.alura.forochallengetopico.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
public class ErrorException extends RuntimeException{
    public ErrorException(String message){
        super(message);
    }

    public HttpStatus getStatus() {
        return HttpStatus.INTERNAL_SERVER_ERROR;
    }
}
