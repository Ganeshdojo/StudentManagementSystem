//package services;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.List;
//
//import model.Student;
//
//public class StudentServices {
//
////    Scanner scanner = new Scanner(System.in);
//    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//    List<Student> students = new ArrayList<>();
//    int id = 520;
//
//    public void addStudent() throws IOException {
//        String name, grade;
//        int age, marks;
//
//        System.out.println("--- Add New Student ---");
//
//        System.out.println("Enter Student Name: ");
//        name = bf.readLine();
//        System.out.println("Enter Student Age: ");
//        age = Integer.parseInt(bf.readLine());
//        System.out.println("Enter Student Grade: ");
//        grade = bf.readLine();
//        System.out.println("Enter Student marks: ");
//        marks = Integer.parseInt(bf.readLine());
//
//        setID();
//        Student student = new Student(id, name, age, grade, marks);
//
//
//        System.out.println("Student add successfully with ID: " + id);
//        students.add(student);
//    }
//
//    public void getAllStudents(){
//
//        System.out.println("--- All Students ---");
//        System.out.println("ID    | Name  | Age | Grade | Marks");
//        System.out.println("-----------------------------------");
//
//        for( Student student : students){
//            System.out.printf("%-6d| %-6s| %-4d| %-6s| %-5d\n", student.getId(), student.getName(), student.getAge(), student.getGrade(), student.getMarks());
//
//        }
//    }
//
//    public Student getById(int id){
//        Student temp = null;
//
//        for(Student student : students){
//            if(student.getId() == id){
//                return student; // Found, return immediately
//            }
//        }
//        System.out.println("Student with this ID does not exist.");
//        return null;
//    }
//
//    public void getStudentByID() throws IOException {
//        System.out.println("--- Search Student ---");
//        System.out.println("Enter Student ID to search: ");
//        id = Integer.parseInt(bf.readLine());
//        System.out.println(getById(id));
//    }
//
//    public void updateMarks() throws IOException {
//        int updatedMarks;
//
//        System.out.println("Enter student Id to update: ");
//        id = Integer.parseInt(bf.readLine());
//        Student student = getById(id);
//
//        System.out.println("Enter new Marks: ");
//        updatedMarks = Integer.parseInt(bf.readLine());
//        student.setMarks(updatedMarks);
//        System.out.println("Marks updated successfully!");
//    }
//
//    public void deleteStudent() throws IOException {
//        System.out.println("--- Delete Student ---");
//        System.out.println("Enter student ID to delete: ");
//
//        id = Integer.parseInt(bf.readLine());
//        Student student = getById(id);
//        students.remove(student);
//        System.out.println("Student with ID " + id + " deleted!");
//    }
//
//    public void setID(){
//        id++;
//    }
//
//
//}




package services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import model.Student;

public class StudentServices {

    private BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    private List<Student> students = new ArrayList<>();
    private int generatedId = 520; // separate from user input

    public void addStudent() throws IOException {
        String name, grade;
        int age, marks;

        System.out.println("--- Add New Student ---");

        System.out.print("Enter Student Name: ");
        name = bf.readLine();

        System.out.print("Enter Student Age: ");
        age = Integer.parseInt(bf.readLine());

        System.out.print("Enter Student Grade: ");
        grade = bf.readLine();

        System.out.print("Enter Student Marks: ");
        marks = Integer.parseInt(bf.readLine());

        // increment ID before use
        generatedId++;
        Student student = new Student(generatedId, name, age, grade, marks);
        students.add(student);

        System.out.println("Student added successfully with ID: " + generatedId);
    }

    public void getAllStudents() {
        System.out.println("--- All Students ---");
        System.out.printf("%-6s| %-10s| %-4s| %-6s| %-5s\n", "ID", "Name", "Age", "Grade", "Marks");
        System.out.println("---------------------------------------------");

        if (students.isEmpty()) {
            System.out.println("No students to show.");
        } else {
            for (Student student : students) {
                System.out.printf("%-6d| %-10s| %-4d| %-6s| %-5d\n",
                        student.getId(), student.getName(), student.getAge(),
                        student.getGrade(), student.getMarks());
            }
        }
    }

    public Student getById(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        System.out.println("Student with ID " + id + " does not exist.");
        return null;
    }

    public void getStudentByID() throws IOException {
        System.out.println("--- Search Student ---");
        System.out.print("Enter Student ID to search: ");
        int inputId = Integer.parseInt(bf.readLine());

        Student student = getById(inputId);
        if (student != null) {
            System.out.println(student);
        }
    }

    public void updateMarks() throws IOException {
        System.out.println("--- Update Marks ---");
        System.out.print("Enter student ID to update: ");
        int inputId = Integer.parseInt(bf.readLine());

        Student student = getById(inputId);
        if (student != null) {
            System.out.print("Enter new Marks: ");
            int updatedMarks = Integer.parseInt(bf.readLine());
            student.setMarks(updatedMarks);
            System.out.println("Marks updated successfully!");
        }
    }

    public void deleteStudent() throws IOException {
        System.out.println("--- Delete Student ---");
        System.out.print("Enter student ID to delete: ");
        int inputId = Integer.parseInt(bf.readLine());

        Student student = getById(inputId);
        if (student != null) {
            students.remove(student);
            System.out.println("Student with ID " + inputId + " deleted!");
        }
    }
}
