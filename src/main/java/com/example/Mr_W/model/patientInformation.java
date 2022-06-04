package com.example.Mr_W.model;

import java.util.List;

public class patientInformation {
    String id;
    patient patient;
    List<medicine> medicineList;
    registration registration;
    expense payList;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public patient getPatient() {
        return patient;
    }

    public void setPatient(patient patient) {
        this.patient = patient;
    }

    public List<medicine> getMedicineList() {
        return medicineList;
    }

    public void setMedicineList(List<medicine> medicineList) {
        this.medicineList = medicineList;
    }

    public registration getRegistration() {
        return registration;
    }

    public void setRegistration(registration registration) {
        this.registration = registration;
    }

    public expense getPayList() {
        return payList;
    }

    public void setPayList(expense payList) {
        this.payList = payList;
    }
}
