package edu.aitu.oop3.repositories.interfaces;

import edu.aitu.oop3.entities.Lesson;
import java.util.List;

public interface ILessonRepository {
    void add(Lesson lesson);
    Lesson findById(int id);
    List<Lesson> findByCourseId(int courseId);

    void updateProgress(int userId, int lessonId, boolean isCompleted);
    double calculateProgress(int userId, int courseId);
}