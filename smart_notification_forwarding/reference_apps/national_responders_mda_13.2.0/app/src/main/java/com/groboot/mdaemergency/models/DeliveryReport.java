package com.groboot.mdaemergency.models;

import java.util.ArrayList;

/* loaded from: classes.dex */
public class DeliveryReport {
    public int actionType;
    public ArrayList<DeliveryReportBarcodes> barcodes;
    public int barcodesCount;
    public String site;
    public int spaceEnd;
    public int spaceStart;
    public AppUser user;
}
