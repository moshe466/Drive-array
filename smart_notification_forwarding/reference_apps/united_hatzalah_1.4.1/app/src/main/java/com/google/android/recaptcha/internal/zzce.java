package com.google.android.recaptcha.internal;

/* loaded from: classes.dex */
public final class zzce extends Exception {
    private final Throwable zza;
    private final zztd zzb;
    private final int zzc;
    private final int zzd;

    public zzce(int i, int i3, Throwable th) {
        this.zzc = i;
        this.zzd = i3;
        this.zza = th;
        zztd zzf = zzte.zzf();
        zzf.zzq(i3);
        zzf.zzr(i);
        this.zzb = zzf;
    }

    @Override // java.lang.Throwable
    public final Throwable getCause() {
        return this.zza;
    }

    public final zztd zza() {
        return this.zzb;
    }

    public final int zzb() {
        return this.zzd;
    }
}
