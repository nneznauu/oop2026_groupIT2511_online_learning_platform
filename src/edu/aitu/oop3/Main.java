package edu.aitu.oop3;

import edu.aitu.oop3.config.PlatformConfig;
import edu.aitu.oop3.entities.*;
import edu.aitu.oop3.exceptions.*;
import edu.aitu.oop3.repositories.*;
import edu.aitu.oop3.repositories.interfaces.*;
import edu.aitu.oop3.services.LearningService;
import edu.aitu.oop3.utils.Page;
import edu.aitu.oop3.entities.LessonContent;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PlatformConfig config = PlatformConfig.getInstance();

        IUserRepository userRepo = new UserRepository();
        ICourseRepository courseRepo = new CourseRepository();
        ILessonRepository lessonRepo = new LessonRepository();
        LearningService learningService = new LearningService(courseRepo, lessonRepo, userRepo);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- " + config.getPlatformName() + " (v" + config.getVersion() + ") ---");
            System.out.println("1. Enroll in a Course      | 2. Open a Lesson (Factory Demo)");
            System.out.println("3. Mark Lesson Completed   | 4. View Course Progress");
            System.out.println("5. List All Courses (Page) | 0. Exit");
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
                        System.out.print("Enter Lesson ID to open: ");
                        int lId2 = Integer.parseInt(scanner.nextLine());
                        System.out.print("What type of lesson is this? (video/text/quiz): ");
                        String type = scanner.nextLine();
                        LessonContent content = LessonFactory.createLesson(type);

                        System.out.println("\nOpening Lesson #" + lId2);
                        System.out.println("Content details: " + content.getDetails());
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
                        List<Course> allCourses = courseRepo.findAll();
                        Page<Course> coursePage = new Page<>(allCourses, allCourses.size(), 1, 10);

                        System.out.println("\n--- Course Catalog (Paginated) ---");
                        coursePage.printPageDetails();
                        break;

                    case "0":
                        System.out.println("Exiting application. Goodbye!");
                        return;

                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Please enter a valid numeric ID.");
            } catch (Exception e) {
                System.err.println("Error: " + e.getMessage());
            }
        }
    }
}