package edu.aitu.oop3.entities;

public class Lesson {
    private int id;
    private int courseId;
    private String title;

    public Lesson() {
    }

    public Lesson(int id, int courseId, String title) {
        this.id = id;
        this.courseId = courseId;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}