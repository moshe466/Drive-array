package com.groboot.mdaemergency.models;

import y8.k;

/* loaded from: classes.dex */
public final class EligibilityCheck {
    private String id;
    private String phone;
    private String qrCode;
    private int yearsOfBirth;

    public EligibilityCheck(String str) {
        k.e(str, "qrCode");
        this.id = "";
        this.yearsOfBirth = -1;
        this.phone = "";
        this.qrCode = str;
    }

    public EligibilityCheck(String str, int i10, String str2) {
        k.e(str, "id");
        k.e(str2, "phone");
        this.id = "";
        this.yearsOfBirth = -1;
        this.phone = "";
        this.id = str;
        this.yearsOfBirth = i10;
        this.phone = str2;
    }

    public final String getId() {
        return this.id;
    }

    public final String getPhone() {
        return this.phone;
    }

    public final String getQrCode() {
        return this.qrCode;
    }

    public final int getYearsOfBirth() {
        return this.yearsOfBirth;
    }

    public final void setId(String str) {
        k.e(str, "<set-?>");
        this.id = str;
    }

    public final void setPhone(String str) {
        k.e(str, "<set-?>");
        this.phone = str;
    }

    public final void setQrCode(String str) {
        this.qrCode = str;
    }

    public final void setYearsOfBirth(int i10) {
        this.yearsOfBirth = i10;
    }
}
