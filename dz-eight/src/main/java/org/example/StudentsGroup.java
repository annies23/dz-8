package org.example;

import java.util.ArrayList;
import java.util.List;

public class StudentsGroup {
    private Student groupLead;
    private List<Student> students;
    private List<String> tasks;

    public StudentsGroup(Student groupLead) {
        this.groupLead = groupLead;
        this.students = new ArrayList<>();
        this.tasks = new ArrayList<>();
    }

    public Student getGroupLead() {

        return groupLead;
    }

    public void changeGroupLead(Student newLead) {
        this.groupLead = newLead;
    }

    public List<Student> getStudents() {
        return new ArrayList<>(students);
    }

    public void addStudent(Student student) {
        students.add(student);
    }
    public void removeStudent(Student student) {
        System.out.println("Видалений студент: " + student.getStudentName() + " " + student.getStudentSurname());
        students.remove(student);
    }

    public List<String> getTasks() {
        return new ArrayList<>(tasks);
    }

    public void addNewTask(String task) {
        tasks.add(task);
    }

    public void markTaskAsCompleted(String task, Student student) {
        if (tasks.contains(task) && students.contains(student)) {
            System.out.println(student.getStudentName() + " " + student.getStudentSurname() + " виконав(-ла) завдання: " + task);
        } else {
            System.out.println("Студент не виконав(-ла) завдання або невірно вказані дані");
        }
    }
}
