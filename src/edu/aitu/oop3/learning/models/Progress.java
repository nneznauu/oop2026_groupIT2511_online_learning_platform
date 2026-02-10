package edu.aitu.oop3.learning.models;

public class Progress {
    private final int userId;
    private final int courseId;
    private double completionPercentage;

    public Progress(int userId, int courseId) {
        this.userId = userId;
        this.courseId = courseId;
        this.completionPercentage = 0.0;
    }

    public void updateProgress(double percentage) {
        this.completionPercentage = percentage;
    }

    public double getCompletionPercentage() { return completionPercentage; }
}