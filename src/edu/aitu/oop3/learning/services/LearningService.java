package edu.aitu.oop3.learning.services;

import edu.aitu.oop3.learning.models.Enrollment;
import edu.aitu.oop3.learning.repositories.LearningRepository;
import edu.aitu.oop3.user.models.User;
import edu.aitu.oop3.course.models.Course;

public class LearningService {
    private final LearningRepository learningRepository;

    public LearningService(LearningRepository learningRepository) {
        this.learningRepository = learningRepository;
    }

    public void enrollUserInCourse(User user, Course course) {
        if (learningRepository.exists(user.getId(), course.getId())) {
            System.out.println("[LearningService] User " + user.getName() + " is already in " + course.getTitle());
            return;
        }

        Enrollment enrollment = new Enrollment(user.getId(), course.getId());
        learningRepository.addEnrollment(enrollment);
        System.out.println("[Service] Successfully enrolled " + user.getName() + " into " + course.getTitle());
    }
}