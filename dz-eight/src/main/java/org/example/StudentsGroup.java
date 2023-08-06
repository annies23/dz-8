package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentsGroup {
    private Student groupLead;
    private List<Student> students;
    private List<String> tasks;
    Map<String, List<Student>> completedTasks = new HashMap<>();

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
        if (student.equals(groupLead)) {
            System.out.println("Група не може існувати без старости.");
        } else {
            System.out.println("Видалений студент: " + student.getStudentName() + " " + student.getStudentSurname());
            students.remove(student);
        }
    }

    public List<String> getTasks() {
        return new ArrayList<>(tasks);
    }

    public void addNewTask(String task) {
        tasks.add(task);
    }

    public void markTaskAsCompleted(String task, Student student) {
        if (tasks.contains(task) && students.contains(student)) {
            List<Student> taskCompletedByStudents = completedTasks.getOrDefault(task, new ArrayList<>());
            taskCompletedByStudents.add(student);
            completedTasks.put(task, taskCompletedByStudents);
            System.out.println(student.getStudentName() + " " + student.getStudentSurname() + " виконав(-ла) завдання: " + task);
        } else {
            System.out.println("Студент не виконав(-ла) завдання або невірно вказані дані");
        }
    }

    public List<Student> getStudentsWhoCompletedTask(String task) {
        return completedTasks.getOrDefault(task, new ArrayList<>());
    }
}

