package edu.aitu.oop3.entities;

public class QuizLesson implements LessonContent {
    @Override
    public String getDetails() {
        return "[QUIZ LESSON] Loading interactive test questions and answer options...";
    }
}