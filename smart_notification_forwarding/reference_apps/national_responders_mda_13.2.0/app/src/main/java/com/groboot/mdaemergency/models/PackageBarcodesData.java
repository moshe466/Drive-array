package com.groboot.mdaemergency.models;

import java.util.Hashtable;
import y8.k;

/* loaded from: classes.dex */
public final class PackageBarcodesData {
    private Hashtable<Integer, String> EvacuationSites = new Hashtable<>();
    private Hashtable<String, String> Barcodes = new Hashtable<>();

    public final Hashtable<String, String> getBarcodes() {
        return this.Barcodes;
    }

    public final Hashtable<Integer, String> getEvacuationSites() {
        return this.EvacuationSites;
    }

    public final void setBarcodes(Hashtable<String, String> hashtable) {
        k.e(hashtable, "<set-?>");
        this.Barcodes = hashtable;
    }

    public final void setEvacuationSites(Hashtable<Integer, String> hashtable) {
        k.e(hashtable, "<set-?>");
        this.EvacuationSites = hashtable;
    }
}
