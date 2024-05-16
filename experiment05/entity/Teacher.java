package com.experiments.experiment05.entity;

public class Teacher {
    private String id;
    private String name;
    private College college;

    public Teacher(String id, String name, College college) {
        this.id = id;
        this.name = name;
        this.college = college;
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

    public College getCollege() {
        return college;
    }

    public void setCollege(College college) {
        this.college = college;
    }
}
