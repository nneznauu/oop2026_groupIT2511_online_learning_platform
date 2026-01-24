package edu.aitu.oop3.repositories;
import edu.aitu.oop3.entities.Course;
import java.util.List;

public interface ICourseRepository {
    boolean create(Course course);
    List<Course> findAll();
}