package com.google.android.gms.ads.mediation;

/* loaded from: classes.dex */
public final class VersionInfo {
    private final int zzejc;
    private final int zzejd;
    private final int zzeje;

    public VersionInfo(int i, int i2, int i3) {
        this.zzejc = i;
        this.zzejd = i2;
        this.zzeje = i3;
    }

    public final int getMajorVersion() {
        return this.zzejc;
    }

    public final int getMicroVersion() {
        return this.zzeje;
    }

    public final int getMinorVersion() {
        return this.zzejd;
    }
}
