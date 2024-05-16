package com.experiments.experiment06;

public class OverweightException extends Exception{
    private int shipId;
    private double overweight;

    public OverweightException(int shipId, double overweight) {
        this.shipId = shipId;
        this.overweight = overweight;
    }

    public String getMessage() {
        return "Ship ID: " + shipId + ", Overweight: " + overweight;
    }
}
