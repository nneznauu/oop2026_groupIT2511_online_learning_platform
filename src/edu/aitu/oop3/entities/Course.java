package edu.aitu.oop3.entities;

import java.util.ArrayList;
import java.util.List;

public class Course {
    private int id;
    private String title;
    private String description;
    private boolean isArchived;
    private List<String> tags;

    private Course(Builder builder) {
        this.id = builder.id;
        this.title = builder.title;
        this.description = builder.description;
        this.isArchived = builder.isArchived;
        this.tags = builder.tags;
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public boolean isArchived() { return isArchived; }
    public List<String> getTags() { return tags; }

    public static class Builder {
        private int id;
        private final String title;
        private String description = "No description provided";
        private boolean isArchived = false;
        private List<String> tags = new ArrayList<>();

        public Builder(String title) {
            this.title = title;
        }

        public Builder id(int id) {
            this.id = id;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder isArchived(boolean isArchived) {
            this.isArchived = isArchived;
            return this;
        }

        public Builder addTag(String tag) {
            this.tags.add(tag);
            return this;
        }

        public Course build() {
            return new Course(this);
        }
    }

    @Override
    public String toString() {
        return "Course [ID=" + id + ", Title=" + title + ", Tags=" + tags + "]";
    }
}