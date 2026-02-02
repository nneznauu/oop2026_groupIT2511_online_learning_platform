package edu.aitu.oop3.exceptions;

public class CourseArchivedException extends Exception {

    public CourseArchivedException(String message) {
        super(message);
    }

    public CourseArchivedException(String message, Throwable cause) {
        super(message, cause);
    }
}