package edu.aitu.oop3.repositories.interfaces;

import edu.aitu.oop3.entities.Course;
import java.util.List;

public interface ICourseRepository {
    void add(Course course);
    Course findById(int id);
    List<Course> findAll();

    void addEnrollment(int userId, int courseId);
    boolean isEnrolled(int userId, int courseId);
}