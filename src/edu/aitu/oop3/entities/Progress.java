package edu.aitu.oop3.entities;

public class Progress {
    private int userId;
    private int lessonId;
    private boolean isCompleted;

    public Progress() {
    }

    public Progress(int userId, int lessonId, boolean isCompleted) {
        this.userId = userId;
        this.lessonId = lessonId;
        this.isCompleted = isCompleted;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getLessonId() {
        return lessonId;
    }

    public void setLessonId(int lessonId) {
        this.lessonId = lessonId;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }
}