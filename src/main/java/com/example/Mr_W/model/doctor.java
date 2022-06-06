package com.example.Mr_W.model;

public class doctor {
    String id;
    String name;
    String telephone;
    String courses;
    String room;
    String time;
    public doctor(){}
    public doctor(String id,String name, String telephone, String courses, String room, String time){
        this.courses=courses;
        this.id=id;
        this.name=name;
        this.room=room;
        this.time=time;
        this.telephone=telephone;
    }
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getCourses() {
        return courses;
    }

    public String getRoom() {
        return room;
    }

    public String getTime() {
        return time;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setCourses(String courses) {
        this.courses = courses;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
