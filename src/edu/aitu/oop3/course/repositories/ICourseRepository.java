package edu.aitu.oop3.course.repositories;

import edu.aitu.oop3.course.models.Course;
import java.util.List;

public interface ICourseRepository {
    void add(Course course);
    Course findById(int id);
    List<Course> findAll();

    void addEnrollment(int userId, int courseId);
    boolean isEnrolled(int userId, int courseId);
}