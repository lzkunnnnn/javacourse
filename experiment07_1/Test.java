package com.experiments.experiment07_1;

public class Test {
    public static void main(String[] args) {
        MyThread tuzi=new MyThread();
        MyThread wugui=new MyThread();
        tuzi.setName("兔子");
        wugui.setName("乌龟");
        tuzi.start();
        wugui.start();
    }
}
