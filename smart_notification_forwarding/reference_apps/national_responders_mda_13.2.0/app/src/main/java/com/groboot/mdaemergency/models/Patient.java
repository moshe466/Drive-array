package com.groboot.mdaemergency.models;

import java.util.List;

/* loaded from: classes.dex */
public class Patient {
    private List<Metric> Metrics;
    private String PatientAge;
    private String PatientFirstName;
    private String PatientID;
    private String PatientLastName;
    private List<Integer> Treatments;
    private int positionInList;

    public List<Metric> getMetrics() {
        return this.Metrics;
    }

    public String getPatientAge() {
        return this.PatientAge;
    }

    public String getPatientFirstName() {
        return this.PatientFirstName;
    }

    public String getPatientID() {
        return this.PatientID;
    }

    public String getPatientLastName() {
        return this.PatientLastName;
    }

    public int getPositionInList() {
        return this.positionInList;
    }

    public List<Integer> getTreatments() {
        return this.Treatments;
    }

    public void setMetrics(List<Metric> list) {
        this.Metrics = list;
    }

    public void setPatientAge(String str) {
        this.PatientAge = str;
    }

    public void setPatientFirstName(String str) {
        this.PatientFirstName = str;
    }

    public void setPatientID(String str) {
        this.PatientID = str;
    }

    public void setPatientLastName(String str) {
        this.PatientLastName = str;
    }

    public void setPositionInList(int i10) {
        this.positionInList = i10;
    }

    public void setTreatments(List<Integer> list) {
        this.Treatments = list;
    }
}
