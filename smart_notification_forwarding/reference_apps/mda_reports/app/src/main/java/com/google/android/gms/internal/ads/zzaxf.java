package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public final class zzaxf extends Exception {
    private final int errorCode;

    public zzaxf(String str, int i) {
        super(str);
        this.errorCode = i;
    }

    public final int getErrorCode() {
        return this.errorCode;
    }
}
