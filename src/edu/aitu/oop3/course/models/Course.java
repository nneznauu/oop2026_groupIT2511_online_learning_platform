package edu.aitu.oop3.course.models;

import java.util.ArrayList;
import java.util.List;

public class Course {
    private final int id;
    private final String title;
    private final List<LessonContent> lessons;

    private Course(Builder builder) {
        this.id = builder.id;
        this.title = builder.title;
        this.lessons = builder.lessons;
    }

    private boolean isArchived = false;

    public boolean isArchived() {
        return isArchived;
    }

    public void setArchived(boolean archived) {
        this.isArchived = archived;
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public List<LessonContent> getLessons() { return lessons; }

    @Override
    public String toString() {
        return "Course: " + title + " (Lessons: " + lessons.size() + ")";
    }

    public static class Builder {
        private int id;
        private String title;
        private final List<LessonContent> lessons = new ArrayList<>();

        public Builder setId(int id) {
            this.id = id;
            return this;
        }

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder addLesson(LessonContent lesson) {
            this.lessons.add(lesson);
            return this;
        }

        public Course build() {
            if (title == null || title.isEmpty()) {
                throw new IllegalStateException("Course title cannot be empty!");
            }
            return new Course(this);
        }
    }
}