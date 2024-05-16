package com.experiments.experiment03;

public class Manager extends Employee {
    private int level;

    public Manager(String name, double basicSalary, int level) {
        super(name, basicSalary);
        this.level = level;
    }

    @Override
    public double calculateSalary() {
        double salary = getBasicSalary() * level * 0.8;
        return salary;
    }
}
