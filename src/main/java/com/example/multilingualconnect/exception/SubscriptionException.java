package com.example.multilingualconnect.exception;

public class SubscriptionException extends RuntimeException {
    private final int statusCode;
    private final String errorMessage;

    public SubscriptionException(int statusCode, String errorMessage) {
        super(errorMessage);
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
