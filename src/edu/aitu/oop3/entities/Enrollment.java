package edu.aitu.oop3.entities;
public class Enrollment {
    private int id;
    private int userId;
    private int courseId;
    public Enrollment(int userId, int courseId) { this.userId = userId; this.courseId = courseId; }
}