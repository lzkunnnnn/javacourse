package com.experiments.experiment01;

import java.util.Scanner;

public class Test3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int repeat = sc.nextInt();
        int a = sc.nextInt();
        double sum = 0;
        double res = 0;
        for(int i = 0; i < repeat; i ++){
            sum = sum + a * Math.pow(10, i);
            res = res + sum;
        }
        System.out.println(res);
    }
}
