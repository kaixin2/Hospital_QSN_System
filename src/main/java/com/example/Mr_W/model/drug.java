package com.example.Mr_W.model;

public class drug {
    String id;
    String name;
    double drugCost;

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDrugCost(double drugCost) {
        this.drugCost = drugCost;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getDrugCost() {
        return drugCost;
    }
}
