package edu.aitu.oop3.entities;

public class Course {
    private int id;
    private String title;
    private String description;
    private int instructorId;

    public Course(String title, String description, int instructorId) {
        this.title = title;
        this.description = description;
        this.instructorId = instructorId;
    }

    public Course(int id, String title, String description, int instructorId) {
        this(title, description, instructorId);
        this.id = id;
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public int getInstructorId() { return instructorId; }

    @Override
    public String toString() {
        return String.format("Course[ID: %d, Title: %s, Instructor ID: %d]", id, title, instructorId);
    }
}