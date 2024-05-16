package com.experiments.experiment06;

import java.util.ArrayList;
import java.util.List;

public class Ship {
    private Integer id;
    private List<Container> containers;
    private Double totalWeight;

    public Ship(Integer id, List<Container> containers, Double totalWeight) {
        this.id = id;
        this.containers = containers;
        this.totalWeight = totalWeight;
    }

    public Ship(Integer id, Double totalWeight){
        this.id = id;
        this.totalWeight = totalWeight;
        this.containers = new ArrayList<>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Container> getContainers() {
        return containers;
    }

    public void setContainers(List<Container> containers) {
        this.containers = containers;
    }

    public Double getTotalWeight() {
        return totalWeight;
    }

    public void setTotalWeight(Double totalWeight) {
        this.totalWeight = totalWeight;
    }
}
