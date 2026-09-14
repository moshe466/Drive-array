package com.google.android.recaptcha.internal;

import java.io.IOException;

/* loaded from: classes.dex */
public class zznn extends IOException {
    private boolean zza;

    public zznn(IOException iOException) {
        super(iOException.getMessage(), iOException);
    }

    public final void zza() {
        this.zza = true;
    }

    public final boolean zzb() {
        return this.zza;
    }

    public zznn(String str) {
        super(str);
    }
}
