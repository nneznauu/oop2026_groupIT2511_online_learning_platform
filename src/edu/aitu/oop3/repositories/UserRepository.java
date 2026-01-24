package edu.aitu.oop3.repositories;

import edu.aitu.oop3.db.DatabaseConnection;
import edu.aitu.oop3.entities.User;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepository implements IUserRepository {
    @Override
    public boolean create(User user) {
        String sql = "INSERT INTO users(name, email, role) VALUES(?,?,?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement st = conn.prepareStatement(sql)) {
            st.setString(1, user.getName());
            st.setString(2, user.getEmail());
            st.setString(3, user.getRole());
            return st.executeUpdate() > 0;
        } catch (SQLException e) { return false; }
    }

    @Override
    public List<User> findAll() {
        List<User> list = new ArrayList<>();
        try (Connection conn = DatabaseConnection.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery("SELECT * FROM users")) {
            while (rs.next()) {
                list.add(new User(rs.getInt("id"), rs.getString("name"), rs.getString("email"), rs.getString("role")));
            }
        } catch (SQLException e) { System.out.println(e.getMessage()); }
        return list;
    }

    @Override
    public User findById(int id) {
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement st = conn.prepareStatement("SELECT * FROM users WHERE id=?")) {
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) return new User(rs.getInt("id"), rs.getString("name"), rs.getString("email"), rs.getString("role"));
        } catch (SQLException e) { }
        return null;
    }
}