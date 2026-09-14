package com.google.android.gms.gass;

/* loaded from: classes.dex */
public class AdShieldError {
    public static final int ADSHIELD_ERROR_INVALID_PROGRAM = 1;
    public static final int ADSHIELD_ERROR_LAST_CRASH = 5;
    public static final int ADSHIELD_ERROR_VM_CLASS = 2;
    public static final int ADSHIELD_ERROR_VM_INIT = 4;
    public static final int ADSHIELD_ERROR_VM_INSTANCE = 3;
    private final int errorCode;
    private final String zzcxy;

    public AdShieldError(int i, String str) {
        this.errorCode = i;
        this.zzcxy = str;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public String getErrorMessage() {
        return this.zzcxy;
    }
}
