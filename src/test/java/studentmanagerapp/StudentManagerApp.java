package studentmanagerapp;

import java.util.ArrayList;
import java.util.Scanner;
import za.ac.tut.bl.StudentManager;
import za.ac.tut.entities.Student;

public class StudentManagerApp {

	public static void main(String[] args) {
        int option;
        String name;
        int age ;
        Student student;
        StudentManager sm = new StudentManager();

        option = displayOptions();

        while (option != 6) {
            switch (option) {
                case 1:
                    student = createStudent();
                    if (sm.add(student)) {
                        System.out.println("The student has been added");
                    } else {
                        System.out.println("The student was not added");
                    }
                    break;
                case 2:
                    student = createStudent();
                    if (sm.get(student) == null) {
                        System.out.println("The student was not found");
                    } else {
                        System.out.println("The student was found");
                    }
                    break;
                case 3:
                    ArrayList<Student> students = sm.getAll();
                    if (students == null || students.isEmpty()) {
                        System.out.println("The list is empty");
                    } else {
                        displayStudents(students);
                    }
                    break;
                case 4:
                    student = createStudent();
                    if (sm.delete(student)) {
                        System.out.println("The student has been deleted");
                    } else {
                        System.out.println("The student was not deleted");
                    }
                    break;
                case 5:
                    student = createStudent();
                    if (sm.update(student)) {
                        System.out.println("The student has been updated");
                    } else {
                        System.out.println("The student was not updated");
                    }
                    break;
                default:
                    System.out.println(option + " is invalid. Please re-enter.");
            }
            option = displayOptions();
        }
        System.out.println("\nGoodbye!!!");
    }

    private static int displayOptions() {
        int option;
        Scanner sc = new Scanner(System.in);

        System.out.print("Please select one of the following options:\n" +
                "1 - add student\n" +
                "2 - get student\n" +
                "3 - get all students\n" +
                "4 - delete student\n" +
                "5 - update student\n" +
                "6 - exit\n\n" +
                "Your option: ");
        option = sc.nextInt();
        return option;
    }

    private static Student createStudent() {
        String name;
        int age;
        Scanner sc = new Scanner(System.in);

        
        System.out.print("\nEnter your name: ");
        name = sc.next();
        System.out.print("Enter your age: ");
        age = sc.nextInt();
        Student student = new Student(name, age);
        return student;
    }

    private static void displayStudents(ArrayList<Student> students) {
        StringBuilder data = new StringBuilder();
        System.out.println("List of students");
        System.out.println("*******************");

        for (Student student : students) {
            String name = student.getName();
            		
            int age = student.getAge();
            data.append("Name: ").append(name).append("\nAge: ").append(age).append("\n\n");
        }
        System.out.println(data);
    }
}
