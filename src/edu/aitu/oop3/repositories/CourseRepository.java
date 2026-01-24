package edu.aitu.oop3.repositories;
import edu.aitu.oop3.db.DatabaseConnection;
import edu.aitu.oop3.entities.Course;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CourseRepository implements ICourseRepository {
    @Override
    public boolean create(Course course) {
        String sql = "INSERT INTO courses(title, description, instructor_id) VALUES(?,?,?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement st = conn.prepareStatement(sql)) {
            st.setString(1, course.getTitle());
            st.setString(2, course.getDescription());
            st.setInt(3, course.getInstructorId());
            return st.executeUpdate() > 0;
        } catch (SQLException e) { return false; }
    }

    @Override
    public List<Course> findAll() {
        List<Course> list = new ArrayList<>();
        try (Connection conn = DatabaseConnection.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery("SELECT * FROM courses")) {
            while (rs.next()) {
                list.add(new Course(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("description"),
                        rs.getInt("instructor_id")
                ));
            }
        } catch (SQLException e) { System.err.println("Error fetching courses: " + e.getMessage()); }
        return list;
    }
}