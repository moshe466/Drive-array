package com.groboot.mdaemergency.models;

import java.util.ArrayList;

/* loaded from: classes.dex */
public class DeliveryReportBarcodes {
    public ArrayList<String> barcodes = new ArrayList<>();
    public String caption;

    public DeliveryReportBarcodes(String str) {
        this.caption = str;
    }
}
