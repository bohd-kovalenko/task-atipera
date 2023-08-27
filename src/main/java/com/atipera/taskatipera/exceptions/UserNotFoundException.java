package com.atipera.taskatipera.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

@Getter
public class UserNotFoundException extends RuntimeException implements ExceptionFrame {
    private final HttpStatusCode statusCode = HttpStatus.NOT_FOUND;

    public UserNotFoundException(String message) {
        super(message);
    }
}
