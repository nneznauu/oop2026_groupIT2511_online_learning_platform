package edu.aitu.oop3.repositories;

import edu.aitu.oop3.db.DatabaseConnection;
import edu.aitu.oop3.entities.Lesson;
import edu.aitu.oop3.repositories.interfaces.ILessonRepository;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LessonRepository implements ILessonRepository {

    @Override
    public void add(Lesson lesson) {
        String sql = "INSERT INTO lessons (course_id, title) VALUES (?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement st = conn.prepareStatement(sql)) {
            st.setInt(1, lesson.getCourseId());
            st.setString(2, lesson.getTitle());
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Lesson findById(int id) {
        String sql = "SELECT * FROM lessons WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement st = conn.prepareStatement(sql)) {
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return new Lesson(rs.getInt("id"), rs.getInt("course_id"), rs.getString("title"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Lesson> findByCourseId(int courseId) {
        List<Lesson> lessons = new ArrayList<>();
        String sql = "SELECT * FROM lessons WHERE course_id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement st = conn.prepareStatement(sql)) {
            st.setInt(1, courseId);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                lessons.add(new Lesson(rs.getInt("id"), rs.getInt("course_id"), rs.getString("title")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lessons;
    }

    @Override
    public void updateProgress(int userId, int lessonId, boolean isCompleted) {
        String sql = "INSERT INTO progress (user_id, lesson_id, is_completed) VALUES (?, ?, ?) " +
                "ON CONFLICT (user_id, lesson_id) DO UPDATE SET is_completed = EXCLUDED.is_completed";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement st = conn.prepareStatement(sql)) {
            st.setInt(1, userId);
            st.setInt(2, lessonId);
            st.setBoolean(3, isCompleted);
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public double calculateProgress(int userId, int courseId) {
        String sql = "SELECT (COUNT(CASE WHEN p.is_completed THEN 1 END) * 100.0 / NULLIF(COUNT(l.id), 0)) " +
                "FROM lessons l " +
                "LEFT JOIN progress p ON l.id = p.lesson_id AND p.user_id = ? " +
                "WHERE l.course_id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement st = conn.prepareStatement(sql)) {
            st.setInt(1, userId);
            st.setInt(2, courseId);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return rs.getDouble(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0.0;
    }
}