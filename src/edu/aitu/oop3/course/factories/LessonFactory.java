package edu.aitu.oop3.course.factories;

import edu.aitu.oop3.course.models.LessonContent;

public class LessonFactory {
    public static LessonContent createLesson(String type, String title) {
        if (type == null || type.isEmpty()) {
            return null;
        }

        return switch (type.toLowerCase()) {
            case "video" -> (LessonContent) () -> "🎥 [Video Lesson] Title: " + title;
            case "text"  -> (LessonContent) () -> "📖 [Text Article] Title: " + title;
            case "quiz"  -> (LessonContent) () -> "📝 [Quiz] Title: " + title;
            default -> throw new IllegalArgumentException("Unknown lesson type: " + type);
        };
    }
}