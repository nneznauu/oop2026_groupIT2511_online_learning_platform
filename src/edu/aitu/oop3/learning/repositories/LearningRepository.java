package edu.aitu.oop3.learning.repositories;

import edu.aitu.oop3.learning.models.Enrollment;
import java.util.ArrayList;
import java.util.List;

public class LearningRepository {
    private final List<Enrollment> enrollments = new ArrayList<>();

    public void addEnrollment(Enrollment enrollment) {
        enrollments.add(enrollment);
        System.out.println("[DB] Enrollment record created for User ID: " + enrollment.getUserId());
    }

    public boolean exists(int userId, int courseId) {
        return enrollments.stream()
                .anyMatch(e -> e.getUserId() == userId && e.getCourseId() == courseId);
    }
}