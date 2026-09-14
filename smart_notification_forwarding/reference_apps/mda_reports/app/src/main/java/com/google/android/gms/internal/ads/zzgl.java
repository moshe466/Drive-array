package com.google.android.gms.internal.ads;

import java.io.IOException;

/* loaded from: classes.dex */
public final class zzgl extends Exception {
    private final int type;
    private final int zzacl;

    private zzgl(int i, String str, Throwable th, int i2) {
        super(null, th);
        this.type = i;
        this.zzacl = i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzgl a(RuntimeException runtimeException) {
        return new zzgl(2, null, runtimeException, -1);
    }

    public static zzgl zza(IOException iOException) {
        return new zzgl(0, null, iOException, -1);
    }

    public static zzgl zza(Exception exc, int i) {
        return new zzgl(1, null, exc, i);
    }
}
