package com.google.android.gms.common;

import android.util.Log;

/* loaded from: classes.dex */
public class zzy {
    private static final zzy zze = new zzy(true, 3, 1, null, null, -1);
    final boolean zza;
    final String zzb;
    final Throwable zzc;
    final int zzd;

    private zzy(boolean z3, int i, int i3, String str, Throwable th, long j2) {
        this.zza = z3;
        this.zzd = i;
        this.zzb = str;
        this.zzc = th;
    }

    @Deprecated
    public static zzy zzb() {
        return zze;
    }

    public static zzy zzc(String str) {
        return new zzy(false, 1, 5, str, null, -1L);
    }

    public static zzy zzd(String str, Throwable th) {
        return new zzy(false, 1, 5, str, th, -1L);
    }

    public static zzy zzf(int i, long j2) {
        return new zzy(true, i, 1, null, null, j2);
    }

    public static zzy zzg(int i, int i3, String str, Throwable th) {
        return new zzy(false, i, i3, str, th, -1L);
    }

    public String zza() {
        return this.zzb;
    }

    public final void zze() {
        if (!this.zza && Log.isLoggable("GoogleCertificatesRslt", 3)) {
            if (this.zzc != null) {
                zza();
            } else {
                zza();
            }
        }
    }

    public /* synthetic */ zzy(boolean z3, int i, int i3, String str, Throwable th, long j2, byte[] bArr) {
        this(false, 1, 5, null, null, -1L);
    }
}
