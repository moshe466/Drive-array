package com.groboot.mdaemergency.models;

/* loaded from: classes.dex */
public class MdaLocation {
    private int Accuracy;
    private String City;
    private float Lat;
    private float Lon;
    private int Number;
    private int Status;
    private String Street;
    private String Token;

    public int getAccuracy() {
        return this.Accuracy;
    }

    public String getCity() {
        return this.City;
    }

    public float getLat() {
        return this.Lat;
    }

    public float getLon() {
        return this.Lon;
    }

    public int getNumber() {
        return this.Number;
    }

    public int getStatus() {
        return this.Status;
    }

    public String getStreet() {
        return this.Street;
    }

    public String getToken() {
        return this.Token;
    }

    public void setAccuracy(int i10) {
        this.Accuracy = i10;
    }

    public void setCity(String str) {
        this.City = str;
    }

    public void setLat(float f10) {
        this.Lat = f10;
    }

    public void setLon(float f10) {
        this.Lon = f10;
    }

    public void setNumber(int i10) {
        this.Number = i10;
    }

    public void setStatus(int i10) {
        this.Status = i10;
    }

    public void setStreet(String str) {
        this.Street = str;
    }

    public void setToken(String str) {
        this.Token = str;
    }
}
