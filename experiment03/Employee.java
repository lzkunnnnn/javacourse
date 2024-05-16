package com.experiments.experiment03;

public abstract class Employee implements Workable {
    private String name;
    private double basicSalary;
    public Employee(String name, double basicSalary) {
        this.name = name;
        this.basicSalary = basicSalary;
    }
    @Override
    public void updateName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public double getBasicSalary() {
        return basicSalary;
    }

    @Override
    public abstract double calculateSalary();

}
