package app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import services.StudentServices;

public class MainApp {
    public static void main(String[] args) throws IOException {

        int choice = 0;

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StudentServices studService = new StudentServices();

        System.out.println("========================================");
        System.out.println("Welcome to the Student Management System");
        System.out.println("========================================");

        while(choice != 6) {
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student by ID");
            System.out.println("4. Update Student Marks");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");

            System.out.println("Enter Your Choice: ");
            choice = Integer.parseInt(bf.readLine());

            switch (choice) {
                case 1 -> studService.addStudent();
                case 2 -> studService.getAllStudents();
                case 3 -> studService.getStudentByID();
                case 4 -> studService.updateMarks();
                case 5 -> studService.deleteStudent();
                case 6 -> System.out.println("exiting");
                default -> System.out.println("Enter valid value");
            }
        }
        System.out.println("Exiting... You Gone Man...");
    }
}
