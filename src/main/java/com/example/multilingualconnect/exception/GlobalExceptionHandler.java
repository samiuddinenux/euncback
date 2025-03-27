package com.example.multilingualconnect.controller;

import com.example.multilingualconnect.exception.SubscriptionException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(SubscriptionException.class)
    public ResponseEntity<Object> handleSubscriptionException(SubscriptionException ex) {
        // Create a structured error response with code and message
        ErrorResponse errorResponse = new ErrorResponse(
                ex.getStatusCode(),
                ex.getErrorMessage()
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.valueOf(ex.getStatusCode()));
    }

    // Error response structure
    public static class ErrorResponse {
        private int statusCode;
        private String errorMessage;

        public ErrorResponse(int statusCode, String errorMessage) {
            this.statusCode = statusCode;
            this.errorMessage = errorMessage;
        }

        public int getStatusCode() {
            return statusCode;
        }

        public String getErrorMessage() {
            return errorMessage;
        }
    }
}
