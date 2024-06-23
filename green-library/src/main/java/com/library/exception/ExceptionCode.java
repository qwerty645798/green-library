package com.library.exception;

public enum ExceptionCode {
    UNABLE_TO_SEND_EMAIL("Unable to send email");

    private final String message;

    ExceptionCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}