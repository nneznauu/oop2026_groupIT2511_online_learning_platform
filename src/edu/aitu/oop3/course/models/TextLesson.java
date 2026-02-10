package edu.aitu.oop3.course.models;

public class TextLesson implements LessonContent {
    @Override
    public String getDetails() {
        return "[TEXT LESSON] Displaying academic article and theoretical materials...";
    }
}