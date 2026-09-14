package com.groboot.mdaemergency.models;

import w6.l0;

/* loaded from: classes.dex */
public class CoronaBarcodePatient {
    public String BirthDate;
    public String HouseNum;
    public int IDType;
    public String IdNum;
    public String Location;
    public String PatientFirstName;
    public String PatientLastName;
    public String SubLocation;
    public String UnitCode;
    public int UnitType;
    public String barcode;
    public int hmo;
    public String hmoName;
    public String phoneNumber;
    public String sex;
    public String siteDescription;
    public String updateSampleTakenData;

    public String getFullName() {
        return (l0.a0(this.PatientFirstName) + " " + l0.a0(this.PatientLastName)).trim();
    }
}
