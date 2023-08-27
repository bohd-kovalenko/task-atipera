package com.atipera.taskatipera.exceptions.handlers;

import com.atipera.taskatipera.exceptions.UserNotFoundException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
@Slf4j
@RequiredArgsConstructor
public class MainExceptionHandler extends ResponseEntityExceptionHandler {
    private final ObjectMapper objectMapper;

    @ExceptionHandler(value = {UserNotFoundException.class})
    public ResponseEntity<ErrorResponseBody> handleUserNotFoundException(UserNotFoundException e) {
        log.error(String.format("Error message: %s, response status: %d ",
                e.getMessage(), e.getStatusCode().value()));
        return new ResponseEntity<>(new ErrorResponseBody(e), e.getStatusCode());
    }

    @SneakyThrows
    @Override
    protected ResponseEntity<Object> handleHttpMediaTypeNotAcceptable(HttpMediaTypeNotAcceptableException ex,
                                                                      HttpHeaders headers,
                                                                      HttpStatusCode status,
                                                                      WebRequest request) {
        log.error(String.format("Error message: %s, response status: %d ",
                ex.getMessage(), ex.getStatusCode().value()));
        return new ResponseEntity<>(objectMapper.writeValueAsString(new ErrorResponseBody(ex.getStatusCode().value(), ex.getMessage()))
                , ex.getStatusCode());
    }
}
