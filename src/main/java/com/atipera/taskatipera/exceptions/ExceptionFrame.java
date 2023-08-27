package com.atipera.taskatipera.exceptions;

import org.springframework.http.HttpStatusCode;

public interface ExceptionFrame {
    HttpStatusCode getStatusCode();
    String getMessage();
}
