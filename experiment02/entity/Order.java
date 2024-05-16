package com.experiments.experiment02.entity;

import java.util.List;

public class Order {
    private User user;
    private List<Item> items;
    private double totalCost;

    public Order(User user, List<Item> items, double totalCost) {
        this.user = user;
        this.items = items;
        this.totalCost = totalCost;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double sumcost) {
        totalCost = sumcost;
    }

}
