package com.groboot.mdaemergency.models;

import java.util.Date;

/* loaded from: classes.dex */
public class CoronaBarcode {
    public Kv HMO;
    public String barcode;
    public Date date;
    public boolean isSaved = false;

    public CoronaBarcode(String str, Date date) {
        this.barcode = str;
        this.date = date;
    }
}
