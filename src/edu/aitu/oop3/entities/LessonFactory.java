package edu.aitu.oop3.entities;

public class LessonFactory {
    public static LessonContent createLesson(String type) {
        if (type == null || type.isEmpty()) {
            return null;
        }

        return switch (type.toLowerCase()) {
            case "video" -> new VideoLesson();
            case "text" -> new TextLesson();
            case "quiz" -> new QuizLesson();
            default -> throw new IllegalArgumentException("Unknown lesson type: " + type);
        };
    }
}