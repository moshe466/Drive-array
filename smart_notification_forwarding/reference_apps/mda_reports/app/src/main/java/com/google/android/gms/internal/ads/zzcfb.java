package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public class zzcfb extends Exception {
    private final int errorCode;

    public zzcfb(int i) {
        this.errorCode = i;
    }

    public zzcfb(String str, int i) {
        super(str);
        this.errorCode = i;
    }

    public zzcfb(String str, Throwable th, int i) {
        super(str, th);
        this.errorCode = 0;
    }

    public static int zzd(Throwable th) {
        if (th instanceof zzcfb) {
            return ((zzcfb) th).errorCode;
        }
        if (th instanceof zzaxf) {
            return ((zzaxf) th).getErrorCode();
        }
        return 0;
    }

    public final int getErrorCode() {
        return this.errorCode;
    }
}
