package com.experiments.experiment01;

import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        int startyear, endyear;
        Scanner sc = new Scanner(System.in);
        startyear = sc.nextInt();
        endyear = sc.nextInt();
        for(int i = startyear; i <= endyear; i++){
            if (check(i) == true){
                System.out.print(i+" ");
            }
        }

    }
    public static boolean check(int x){
        if(x % 100 != 0){
            if(x % 4 == 0) return true;
            else return false;
        }
        else {
            if(x % 400 == 0) return true;
            else return false;
        }
    }
}
