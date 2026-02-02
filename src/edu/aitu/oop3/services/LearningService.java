package edu.aitu.oop3.services;
import edu.aitu.oop3.entities.*;
import edu.aitu.oop3.exceptions.*;
import edu.aitu.oop3.repositories.interfaces.*;

import java.util.List;

public class LearningService {
    private final ICourseRepository courseRepo;
    private final ILessonRepository lessonRepo;
    private final IUserRepository userRepo;

    public LearningService(ICourseRepository courseRepo, ILessonRepository lessonRepo, IUserRepository userRepo) {
        this.courseRepo = courseRepo;
        this.lessonRepo = lessonRepo;
        this.userRepo = userRepo;
    }

    public void enrollInCourse(int userId, int courseId) throws CourseArchivedException {
        Course course = courseRepo.findById(courseId);
        if (course == null) {
            System.out.println("Course with ID " + courseId + " not found.");
            return;
        }

        if (course.isArchived()) {
            throw new CourseArchivedException("Error: Course '" + course.getTitle() + "' is archived. Enrollment is not possible.");
        }

        courseRepo.addEnrollment(userId, courseId);
        System.out.println("User successfully enrolled in course: " + course.getTitle());
    }

    public void openLesson(int userId, int lessonId) throws UserNotEnrolledException, LessonNotFoundException {
        Lesson lesson = lessonRepo.findById(lessonId);
        if (lesson == null) {
            throw new LessonNotFoundException("Error: Lesson with ID " + lessonId + " not found in the database.");
        }

        boolean isEnrolled = courseRepo.isEnrolled(userId, lesson.getCourseId());
        if (!isEnrolled) {
            throw new UserNotEnrolledException("Access denied: You are not enrolled in the course for lesson '" + lesson.getTitle() + "'.");
        }

        System.out.println("Lesson opened: " + lesson.getTitle());
        System.out.println("Loading lesson content...");
    }

    public void markLessonAsCompleted(int userId, int lessonId) {
        lessonRepo.updateProgress(userId, lessonId, true);
        System.out.println("Success: Lesson #" + lessonId + " marked as completed.");
    }

    public void viewCourseProgress(int userId, int courseId) {
        Course course = courseRepo.findById(courseId);
        if (course == null) {
            System.out.println("Course not found.");
            return;
        }

        double percentage = lessonRepo.calculateProgress(userId, courseId);
        System.out.println("Your progress for course '" + course.getTitle() + "': " + percentage + "%");
    }
}