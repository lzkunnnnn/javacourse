package com.experiments.experiment06;

import java.util.List;

public class Test {
    public static final List<Container> containers = create();
    public static List<Container> create(){
        List<Container> containers = List.of(new Container(001, 50.0), new Container(002, 30.0));
        return containers;
    }
    public static void test1(){

        Ship ship = new Ship(111,70.0);
        try{
            Ship s = Service.load(ship, containers);
            System.out.println("装载成功");
        } catch (OverweightException e){
            System.out.println("货船超重 " + e.getMessage());
        }
    }
    public static void test2(){
        Ship ship = new Ship(111,90.0);
        try{
            Ship s = Service.load(ship, containers);
            System.out.println("装载成功");
        } catch (OverweightException e){
            System.out.println("货船超重 " + e.getMessage());
        }
    }
    public static void main(String[] args) {
        // test1();
         test2();
    }
}
