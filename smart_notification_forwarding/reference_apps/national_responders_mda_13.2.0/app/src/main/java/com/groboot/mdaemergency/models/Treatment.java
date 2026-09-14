package com.groboot.mdaemergency.models;

/* loaded from: classes.dex */
public class Treatment {
    private int TreatmentID;
    private String TreatmentValue;
    public boolean isSelected;

    public int getTreatmentID() {
        return this.TreatmentID;
    }

    public String getTreatmentValue() {
        return this.TreatmentValue;
    }

    public void setTreatmentID(int i10) {
        this.TreatmentID = i10;
    }

    public void setTreatmentValue(String str) {
        this.TreatmentValue = str;
    }
}
