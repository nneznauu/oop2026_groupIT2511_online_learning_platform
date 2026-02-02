package edu.aitu.oop3.exceptions;

public class LessonNotFoundException extends Exception {

    public LessonNotFoundException(String message) {
        super(message);
    }

    public LessonNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}