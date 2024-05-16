package com.experiments.experiment03;

import java.util.List;
import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        List<Workable> employees  = new ArrayList<>();
        Manager manager = new Manager("经理", 5000, 2);
        Seller seller = new Seller("销售员", 3000, 20000, 0.15);
        employees.add(manager);
        employees.add(seller);

        double totalsalary = SalaryService.getTotalSalaries(employees);
        System.out.println("经理的工资为：" + manager.calculateSalary());
        System.out.println("销售员的工资为：" + seller.calculateSalary());
        System.out.println("总工资为：" + totalsalary);

    }
}
