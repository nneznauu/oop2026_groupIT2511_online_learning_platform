package edu.aitu.oop3;

import edu.aitu.oop3.entities.*;
import edu.aitu.oop3.exceptions.*;
import edu.aitu.oop3.repositories.*;
import edu.aitu.oop3.repositories.interfaces.*;
import edu.aitu.oop3.services.LearningService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        IUserRepository userRepo = new UserRepository();
        ICourseRepository courseRepo = new CourseRepository();
        ILessonRepository lessonRepo = new LessonRepository();
        LearningService learningService = new LearningService(courseRepo, lessonRepo, userRepo);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- ONLINE LEARNING PLATFORM ---");
            System.out.println("1. Enroll in a Course      | 2. Open a Lesson");
            System.out.println("3. Mark Lesson Completed   | 4. View Course Progress");
            System.out.println("5. List All Courses        | 0. Exit");
            System.out.print("> ");

            String choice = scanner.nextLine();

            try {
                switch (choice) {
                    case "1":
                        System.out.print("Enter User ID: ");
                        int uId1 = Integer.parseInt(scanner.nextLine());
                        System.out.print("Enter Course ID to enroll: ");
                        int cId1 = Integer.parseInt(scanner.nextLine());
                        learningService.enrollInCourse(uId1, cId1);
                        break;

                    case "2":
                        System.out.print("Enter User ID: ");
                        int uId2 = Integer.parseInt(scanner.nextLine());
                        System.out.print("Enter Lesson ID to open: ");
                        int lId2 = Integer.parseInt(scanner.nextLine());
                        learningService.openLesson(uId2, lId2);
                        break;

                    case "3":
                        System.out.print("Enter User ID: ");
                        int uId3 = Integer.parseInt(scanner.nextLine());
                        System.out.print("Enter Lesson ID to complete: ");
                        int lId3 = Integer.parseInt(scanner.nextLine());
                        learningService.markLessonAsCompleted(uId3, lId3);
                        break;

                    case "4":
                        System.out.print("Enter User ID: ");
                        int uId4 = Integer.parseInt(scanner.nextLine());
                        System.out.print("Enter Course ID: ");
                        int cId4 = Integer.parseInt(scanner.nextLine());
                        learningService.viewCourseProgress(uId4, cId4);
                        break;

                    case "5":
                        System.out.println("\n--- Available Courses ---");
                        for (Course c : courseRepo.findAll()) {
                            String status = c.isArchived() ? "[ARCHIVED]" : "[ACTIVE]";
                            System.out.println("ID: " + c.getId() + " | " + c.getTitle() + " " + status);
                        }
                        break;

                    case "0":
                        System.out.println("Exiting application. Goodbye!");
                        return;

                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Please enter a valid numeric ID.");
            } catch (CourseArchivedException | UserNotEnrolledException | LessonNotFoundException e) {
                System.err.println("Business Logic Error: " + e.getMessage());
            } catch (Exception e) {
                System.err.println("Unexpected system error occurred.");
                e.printStackTrace();
            }
        }
    }
}