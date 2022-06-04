package com.example.Mr_W.model;

public class medicine {
    String id;
    drug drug;
    double cost;
    int num;

    public void setCost(Double cost) {
		this.cost=cost;
	}
    
    public double getCost() {
		return cost;
	}
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public drug getDrug() {
        return drug;
    }

    public void setDrug(drug drug) {
        this.drug = drug;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
