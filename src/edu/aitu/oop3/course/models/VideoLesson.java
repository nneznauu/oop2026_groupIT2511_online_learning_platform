package edu.aitu.oop3.course.models;

public class VideoLesson implements LessonContent {
    @Override
    public String getDetails() {
        return "[VIDEO LENS] Streaming high-quality video content from Supabase Storage...";
    }
}