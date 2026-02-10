package edu.aitu.oop3.learning.models;

import java.time.LocalDateTime;

public class Enrollment {
    private final int userId;
    private final int courseId;
    private final LocalDateTime enrollmentDate;

    public Enrollment(int userId, int courseId) {
        this.userId = userId;
        this.courseId = courseId;
        this.enrollmentDate = LocalDateTime.now();
    }

    public int getUserId() { return userId; }
    public int getCourseId() { return courseId; }
    public LocalDateTime getEnrollmentDate() { return enrollmentDate; }

    @Override
    public String toString() {
        return "Enrollment: User " + userId + " joined Course " + courseId + " at " + enrollmentDate;
    }
}