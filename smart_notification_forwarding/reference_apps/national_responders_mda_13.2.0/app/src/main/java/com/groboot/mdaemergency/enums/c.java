package com.groboot.mdaemergency.enums;

import il.org.mda.health.R;

/* loaded from: classes.dex */
public enum c {
    NONE,
    GpsNoPermission(R.string.messageGPSNoPermission),
    GpsNotEnabled(R.string.messageGPSDisable, "android.settings.LOCATION_SOURCE_SETTINGS"),
    GpsNotAvailable(R.string.looking_satellite_gps),
    InternetConnection(R.string.poor_data_comunication_try_again, "");

    private String action;
    private int resId;

    c() {
        this.resId = -1;
        this.action = null;
    }

    c(int i10) {
        this.resId = i10;
        this.action = null;
    }

    c(int i10, String str) {
        this.resId = i10;
        this.action = str;
    }

    public String getAction() {
        return this.action;
    }

    public int getResId() {
        return this.resId;
    }

    public boolean hasAction() {
        return this.action != null;
    }
}
