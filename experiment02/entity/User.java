package com.experiments.experiment02.entity;

public class User {
    private String name;
    private double balance;
    private String address;
    public User(String name, double balance, String address){
        this.name = name;
        this.balance = balance;
        this.address = address;
    }
    public void setName(String s){
        name = s;
    }
    public String getName(){
        return name;
    }
    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
}
