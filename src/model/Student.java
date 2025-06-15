package model;

public class Student {
    private int id, age, marks;
    private String name, grade;

    public Student(int id, String name, int age, String grade, int marks){
        this.id = id;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.marks = marks;
    }

    public Student(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String toString() {
        return """
        ID    : %d
        Name  : %s
        Age   : %d
        Grade : %s
        Marks : %d
        """.formatted(id, name, age, grade, marks);
    }
}
