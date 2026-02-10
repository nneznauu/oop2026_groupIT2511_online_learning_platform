package edu.aitu.oop3.course.repositories;

import edu.aitu.oop3.course.models.Course;
import java.util.ArrayList;
import java.util.List;

public class CourseRepository {
    private final List<Course> courses = new ArrayList<>();

    public void save(Course course) {
        courses.add(course);
        System.out.println("[DB] Course '" + course.getTitle() + "' with ID " + course.getId() + " has been saved.");
    }

    public List<Course> findAll() {
        return new ArrayList<>(courses);
    }
}