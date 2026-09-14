package com.groboot.mdaemergency.models;

import java.util.ArrayList;
import java.util.UUID;

/* loaded from: classes.dex */
public class CoronaBarcodesAction {
    public static final int ACTION_COLLECT = 1;
    public static final int ACTION_DELIVERY = 2;
    public static final int ACTION_SITE = 3;
    public static final int SOURCE_TYPE_FRIDGE = 2;
    public static final int SOURCE_TYPE_STATION = 1;
    public int actionType;
    public boolean askToCancel;
    public boolean askToSending;
    public EvacuationSite evacuationSite;
    public boolean sending;
    public int sourceType;
    public ArrayList<CoronaBarcode> barcodes = new ArrayList<>();
    public UUID PackageUID = UUID.randomUUID();

    public void cancel() {
        this.barcodes = new ArrayList<>();
        this.evacuationSite = null;
    }
}
