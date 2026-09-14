package com.groboot.mdaemergency.models;

import java.util.UUID;

/* loaded from: classes.dex */
public class DeliveryObject {
    public int EvacuationSite;
    public int EvacuationSiteType;
    public UUID PackageUID;
    public String QRcode;

    public DeliveryObject(String str, int i10, int i11, UUID uuid) {
        this.QRcode = str;
        this.EvacuationSite = i10;
        this.EvacuationSiteType = i11;
        this.PackageUID = uuid;
    }
}
