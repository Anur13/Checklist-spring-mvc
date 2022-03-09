package com.andrew.exception;

public class DuplicateUserException extends RuntimeException {
    public DuplicateUserException(String message, Throwable cause) {
        super(message, cause);
    }

    public DuplicateUserException() {
        super("User is already registered.");
    }
}
