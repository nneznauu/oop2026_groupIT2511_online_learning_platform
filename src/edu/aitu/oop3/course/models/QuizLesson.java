package edu.aitu.oop3.course.models;

public class QuizLesson implements LessonContent {
    @Override
    public String getDetails() {
        return "[QUIZ LESSON] Loading interactive test questions and answer options...";
    }
}