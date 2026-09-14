package com.groboot.mdaemergency.models;

import java.util.UUID;
import y8.k;

/* loaded from: classes.dex */
public final class SampleMovementReport {
    private int Amount = -1;
    public String Field1;
    public String Field2;
    private UUID PackageUID;

    public final int getAmount() {
        return this.Amount;
    }

    public final String getField1() {
        String str = this.Field1;
        if (str != null) {
            return str;
        }
        k.o("Field1");
        return null;
    }

    public final String getField2() {
        String str = this.Field2;
        if (str != null) {
            return str;
        }
        k.o("Field2");
        return null;
    }

    public final UUID getPackageUID() {
        return this.PackageUID;
    }

    public final void setAmount(int i10) {
        this.Amount = i10;
    }

    public final void setField1(String str) {
        k.e(str, "<set-?>");
        this.Field1 = str;
    }

    public final void setField2(String str) {
        k.e(str, "<set-?>");
        this.Field2 = str;
    }

    public final void setPackageUID(UUID uuid) {
        this.PackageUID = uuid;
    }
}
