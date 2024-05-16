package com.experiments.experiment01;

import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[10];
        for(int i = 0; i < arr.length; i ++){
            arr[i] = sc.nextInt();
        }
        sort(arr);
    }
    public static void sort(int[] array){
        for(int i = 0; i < array.length - 1; i ++){
            for(int j = i + 1; j < array.length; j ++){
                if(array[i] > array[j]){
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        for(int i = 0; i < array.length; i ++){
            System.out.print(array[i] + " ");
        }
    }
}
