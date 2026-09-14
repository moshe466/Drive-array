package com.groboot.mdaemergency.models;

import java.util.List;

/* loaded from: classes.dex */
public class ReportEvent {
    private String ArriveTime;
    private String CallCode;
    private String CallCodeDesc;
    private String DepartureTime;
    private String EventID;
    private String EventTime;
    private String FinishTime;
    private double Lat;
    private double Lon;
    private String MedicCode;
    private String MedicCodeDesc;
    private String PatientAge;
    private String PatientFirstName;
    private String PatientID;
    private String PatientLastName;
    private List<Patient> Patients;
    public boolean hasFilledReport;
    public String htmlData;
    private String title;
    private String City = "";
    private String Street = "";
    private String Number = "";
    private String Floor = "";
    private String Entrance = "";
    private String Apartment = "";

    /* loaded from: classes.dex */
    public static class ReportEventToSend {
        public String ArriveTime;
        public String DepartureTime;
        public String FinishTime;
        public List<Patient> Patients;
    }

    public String getAddress() {
        return this.City + " " + this.Street + " " + this.Number;
    }

    public String getApartment() {
        return this.Apartment;
    }

    public String getArriveTime() {
        return this.ArriveTime;
    }

    public String getCallCode() {
        return this.CallCode;
    }

    public String getCallCodeDec() {
        return this.CallCodeDesc;
    }

    public String getCallCodeDesc() {
        return this.CallCodeDesc;
    }

    public String getCity() {
        return this.City;
    }

    public String getDepartureTime() {
        return this.DepartureTime;
    }

    public String getEntrance() {
        return this.Entrance;
    }

    public String getEventID() {
        return this.EventID;
    }

    public String getEventTime() {
        return this.EventTime;
    }

    public String getFinishTime() {
        return this.FinishTime;
    }

    public String getFloor() {
        return this.Floor;
    }

    public CharSequence getFullAddress() {
        return getAddress() + " " + this.Entrance + this.Floor + this.Apartment;
    }

    public double getLat() {
        return this.Lat;
    }

    public double getLon() {
        return this.Lon;
    }

    public String getMedicCode() {
        return this.MedicCode;
    }

    public String getMedicCodeDesc() {
        return this.MedicCodeDesc;
    }

    public String getNumber() {
        return this.Number;
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

    public List<Patient> getPatients() {
        return this.Patients;
    }

    public String getStreet() {
        return this.Street;
    }

    public String getTitle() {
        return this.title;
    }

    public void setApartment(String str) {
        this.Apartment = str;
    }

    public void setArriveTime(String str) {
        this.ArriveTime = str;
    }

    public void setCallCode(String str) {
        this.CallCode = str;
    }

    public void setCallCodeDec(String str) {
        this.CallCodeDesc = str;
    }

    public void setCallCodeDesc(String str) {
        this.CallCodeDesc = str;
    }

    public void setCity(String str) {
        this.City = str;
    }

    public void setDepartureTime(String str) {
        this.DepartureTime = str;
    }

    public void setEntrance(String str) {
        this.Entrance = str;
    }

    public void setEventID(String str) {
        this.EventID = str;
    }

    public void setEventTime(String str) {
        this.EventTime = str;
    }

    public void setFinishTime(String str) {
        this.FinishTime = str;
    }

    public void setFloor(String str) {
        this.Floor = str;
    }

    public void setLat(double d10) {
        this.Lat = d10;
    }

    public void setLon(double d10) {
        this.Lon = d10;
    }

    public void setMedicCode(String str) {
        this.MedicCode = str;
    }

    public void setMedicCodeDesc(String str) {
        this.MedicCodeDesc = str;
    }

    public void setNumber(String str) {
        this.Number = str;
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

    public void setPatients(List<Patient> list) {
        this.Patients = list;
    }

    public void setStreet(String str) {
        this.Street = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }
}
