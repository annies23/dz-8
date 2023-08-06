package org.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Student student1 = new Student(1, "Емілі", "Вотсон");
        Student student2 = new Student(2, "Гарі", "Стайлз");
        Student student3 = new Student(3, "Марго", "Роббі");
        Student groupLead = new Student(4, "Сем", "Сміт");

        StudentsGroup group = new StudentsGroup(groupLead);

        group.addStudent(student1);
        group.addStudent(student2);
        group.addStudent(student3);
        group.addStudent(groupLead);

        group.addNewTask("Вивчити інкапсуляцію");
        group.addNewTask("Вивчити поліморфізм");

        System.out.println("Студенти: ");
        for (Student student : group.getStudents()) {
            System.out.println(student.getStudentName() + " " + student.getStudentSurname());
        }

        System.out.println("Завдання: ");
        for (String task : group.getTasks()) {
            System.out.println(task);
        }

        String task = "Вивчити інкапсуляцію";
        group.markTaskAsCompleted(task, student1);

        String task2 = "Вивчити абстракцію";
        group.markTaskAsCompleted(task2, student1);

        String task3 = "Вивчити інкапсуляцію";
        group.markTaskAsCompleted(task3, student2);

        List<Student> studentsCompletedTask = group.getStudentsWhoCompletedTask(task);
        for (Student student : studentsCompletedTask) {
            System.out.println(student.getStudentName() + " " + student.getStudentSurname());
        }

        group.removeStudent(student3);
        System.out.println("Студенти: ");
        for (Student student : group.getStudents()) {
            System.out.println(student.getStudentName() + " " + student.getStudentSurname());}
    }
}