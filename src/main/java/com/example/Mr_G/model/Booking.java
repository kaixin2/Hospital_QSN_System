package com.example.Mr_G.model;

public class Booking {
    String id;
    String doctorId;
    String listId;
    String type;
    String pTime;
    String costs;
    String sign;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getDoctorId() {
        return doctorId;
    }
    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }
    public String getListId() {
        return listId;
    }
    public void setListId(String listId) {
        this.listId = listId;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getpTime() {
        return pTime;
    }
    public void setpTime(String pTime) {
        this.pTime = pTime;
    }
    public String getCosts() {
        return costs;
    }
    public void setCosts(String costs) {
        this.costs = costs;
    }
    public String getSign() {
        return sign;
    }
    public void setSign(String sign) {
        this.sign = sign;
    }
}
