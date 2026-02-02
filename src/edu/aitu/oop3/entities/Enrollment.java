package edu.aitu.oop3.entities;

public class Enrollment {
    private int userId;
    private int courseId;

    public Enrollment() {
    }

    public Enrollment(int userId, int courseId) {
        this.userId = userId;
        this.courseId = courseId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }
}