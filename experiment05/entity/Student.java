package com.experiments.experiment05.entity;

public class Student {
    private String id;
    private String name;
    private int grade;
    private Teacher advisor;

    public Student(String id, String name, int grade, Teacher advisor) {
        this.id = id;
        this.name = name;
        this.grade = grade;
        this.advisor = advisor;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public Teacher getAdvisor() {
        return advisor;
    }

    public void setAdvisor(Teacher advisor) {
        this.advisor = advisor;
    }
}