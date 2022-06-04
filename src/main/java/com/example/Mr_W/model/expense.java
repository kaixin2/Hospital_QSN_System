package com.example.Mr_W.model;

public class expense {
    String id;
    String payID;
    String goal;
    double cost;
    String sign;

    public void setGoal(String goal) {
    	this.goal=goal;
    }
    
    public String getGoal() {
		return goal;
	}
    
    public void SetCost(double cost) {
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

    public String getPayID() {
        return payID;
    }

    public void setPayID(String payID) {
        this.payID = payID;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }
}
