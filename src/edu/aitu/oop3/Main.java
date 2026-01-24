package edu.aitu.oop3;

import edu.aitu.oop3.entities.*;
import edu.aitu.oop3.repositories.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        IUserRepository userRepo = new UserRepository();
        ICourseRepository courseRepo = new CourseRepository();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- ONLINE LEARNING PLATFORM ---");
            System.out.println("1. Create User | 2. List Users | 3. Find User by ID");
            System.out.println("4. Create Course | 5. List Courses");
            System.out.println("6. Enrollment Flow | 7. DB Stats | 0. Exit");
            System.out.print("> ");

            String choice = scanner.nextLine();
            if (choice.equals("0")) break;

            try {
                switch (choice) {
                    case "1" -> {
                        System.out.print("Name: "); String n = scanner.nextLine();
                        System.out.print("Email: "); String e = scanner.nextLine();
                        userRepo.create(new User(n, e, "student"));
                    }
                    case "2" -> userRepo.findAll().forEach(System.out::println);
                    case "3" -> {
                        System.out.print("ID: ");
                        int id = Integer.parseInt(scanner.nextLine());
                        User u = userRepo.findById(id);
                        System.out.println(u != null ? u : "Not found.");
                    }
                    case "4" -> {
                        System.out.print("Title: "); String t = scanner.nextLine();
                        System.out.print("Description: "); String d = scanner.nextLine();
                        System.out.print("Instructor ID: ");
                        int i = Integer.parseInt(scanner.nextLine());
                        courseRepo.create(new Course(t, d, i));
                    }
                    case "5" -> courseRepo.findAll().forEach(System.out::println);
                    case "6" -> {
                        System.out.print("Student ID: "); int sid = Integer.parseInt(scanner.nextLine());
                        System.out.print("Course ID: "); int cid = Integer.parseInt(scanner.nextLine());
                        System.out.println("Flow: Enrollment for " + sid + " to " + cid);
                    }
                    case "7" -> System.out.println("Users: " + userRepo.findAll().size() + ", Courses: " + courseRepo.findAll().size());
                    default -> System.out.println("Unknown command.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}