package edu.aitu.oop3;

import edu.aitu.oop3.db.DatabaseConnection;
import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("--- LMS Online Learning Platform (Endterm) ---");

            while (true) {
                System.out.println("\n1. Enroll in a Course      | 2. Open a Lesson (Factory Demo)");
                System.out.println("3. Mark Lesson Completed   | 4. View Course Progress");
                System.out.println("5. List All Courses (Page) | 0. Exit");
                System.out.print("> ");

                int choice = scanner.nextInt();
                if (choice == 0) break;

                switch (choice) {
                    case 1:
                        enrollUserInCourse(conn, scanner);
                        break;
                    case 2:
                        System.out.println("[Factory] Creating Video Lesson from DB data...");
                        break;
                    case 3:
                        markAsCompleted(conn, scanner);
                        break;
                    case 4:
                        viewProgress(conn, scanner);
                        break;
                    case 5:
                        listCoursesPaged(conn);
                        break;
                    default:
                        System.out.println("Invalid option.");
                }
            }
        } catch (SQLException e) {
            System.err.println("Database Error: " + e.getMessage());
        }
    }

    private static void listCoursesPaged(Connection conn) throws SQLException {
        String sql = "SELECT title FROM courses LIMIT 5 OFFSET 0";
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            System.out.println("\n--- Course List (Page 1) ---");
            while (rs.next()) {
                System.out.println("- " + rs.getString("title"));
            }
        }
    }

    private static void enrollUserInCourse(Connection conn, Scanner sc) throws SQLException {
        System.out.print("Enter User ID: ");
        int uId = sc.nextInt();
        System.out.print("Enter Course ID: ");
        int cId = sc.nextInt();

        String sql = "INSERT INTO enrollments (user_id, course_id) VALUES (?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, uId);
            pstmt.setInt(2, cId);
            pstmt.executeUpdate();
            System.out.println("Successfully enrolled!");
        }
    }

    private static void markAsCompleted(Connection conn, Scanner sc) {
        System.out.print("Enter Enrollment ID to mark as completed: ");
        int enrollmentId = sc.nextInt();

        String sql = "UPDATE enrollments SET is_completed = true WHERE id = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, enrollmentId);
            int rows = pstmt.executeUpdate();

            if (rows > 0) {
                System.out.println("Status updated! Course marked as completed.");
            } else {
                System.out.println("Enrollment ID not found.");
            }
        } catch (SQLException e) {
            System.out.println("Error updating status: " + e.getMessage());
        }
    }
    private static void viewProgress(Connection conn, Scanner sc) {
        System.out.print("Enter User ID to view progress: ");
        int userId = sc.nextInt();

        String sql = "SELECT c.title, e.is_completed FROM enrollments e " +
                "JOIN courses c ON e.course_id = c.id WHERE e.user_id = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, userId);
            ResultSet rs = pstmt.executeQuery();

            System.out.println("\n--- Your Progress ---");
            boolean hasData = false;
            while (rs.next()) {
                hasData = true;
                String status = rs.getBoolean("is_completed") ? "[COMPLETED]" : "[IN PROGRESS]";
                System.out.println(rs.getString("title") + " - " + status);
            }
            if (!hasData) System.out.println("No enrollments found for this user.");

        } catch (SQLException e) {
            System.out.println("Error fetching progress: " + e.getMessage());
        }
    }
    
}