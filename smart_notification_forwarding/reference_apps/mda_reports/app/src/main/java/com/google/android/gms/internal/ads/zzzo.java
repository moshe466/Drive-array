package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzzo implements zzabo {
    private final /* synthetic */ zzzj zzcrh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzzo(zzzj zzzjVar) {
        this.zzcrh = zzzjVar;
    }

    @Override // com.google.android.gms.internal.ads.zzabo
    public final String get(String str, String str2) {
        SharedPreferences sharedPreferences;
        sharedPreferences = this.zzcrh.zzcgc;
        return sharedPreferences.getString(str, str2);
    }

    @Override // com.google.android.gms.internal.ads.zzabo
    public final Long getLong(String str, long j) {
        SharedPreferences sharedPreferences;
        SharedPreferences sharedPreferences2;
        try {
            sharedPreferences2 = this.zzcrh.zzcgc;
            return Long.valueOf(sharedPreferences2.getLong(str, j));
        } catch (ClassCastException unused) {
            sharedPreferences = this.zzcrh.zzcgc;
            return Long.valueOf(sharedPreferences.getInt(str, (int) j));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzabo
    public final Double zza(String str, double d) {
        SharedPreferences sharedPreferences;
        sharedPreferences = this.zzcrh.zzcgc;
        return Double.valueOf(sharedPreferences.getFloat(str, (float) d));
    }

    @Override // com.google.android.gms.internal.ads.zzabo
    public final Boolean zze(String str, boolean z) {
        SharedPreferences sharedPreferences;
        sharedPreferences = this.zzcrh.zzcgc;
        return Boolean.valueOf(sharedPreferences.getBoolean(str, z));
    }
}
