package edu.aitu.oop3.exceptions;

public class UserNotEnrolledException extends Exception {

    public UserNotEnrolledException(String message) {
        super(message);
    }

    public UserNotEnrolledException(String message, Throwable cause) {
        super(message, cause);
    }
}
