package com.experiments.experiment03;

import java.util.List;

public class SalaryService {
    public static double getTotalSalaries(List<Workable> employees) {
        double totalSalary = 0;
        for (Workable employee : employees) {
            totalSalary = totalSalary + employee.calculateSalary();
        }
        return totalSalary;
    }
}
