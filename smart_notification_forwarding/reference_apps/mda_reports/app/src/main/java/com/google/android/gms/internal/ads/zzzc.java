package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;
import android.os.Bundle;
import org.json.JSONObject;

/* loaded from: classes.dex */
public abstract class zzzc<T> {
    private final String zzcc;
    private final int zzcft;
    private final T zzcfu;

    private zzzc(int i, String str, T t) {
        this.zzcft = i;
        this.zzcc = str;
        this.zzcfu = t;
        zzve.zzox().zza(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzzc(int i, String str, Object obj, zzzb zzzbVar) {
        this(i, str, obj);
    }

    public static zzzc<Float> zza(int i, String str, float f) {
        return new zzzg(1, str, Float.valueOf(0.0f));
    }

    public static zzzc<Integer> zza(int i, String str, int i2) {
        return new zzze(1, str, Integer.valueOf(i2));
    }

    public static zzzc<Long> zza(int i, String str, long j) {
        return new zzzd(1, str, Long.valueOf(j));
    }

    public static zzzc<Boolean> zza(int i, String str, Boolean bool) {
        return new zzzb(i, str, bool);
    }

    public static zzzc<String> zza(int i, String str, String str2) {
        return new zzzf(1, str, str2);
    }

    public static zzzc<String> zzb(int i, String str) {
        zzzc<String> zza = zza(1, str, (String) null);
        zzve.zzox().zzc(zza);
        return zza;
    }

    public final String getKey() {
        return this.zzcc;
    }

    public final int getSource() {
        return this.zzcft;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract T zza(SharedPreferences sharedPreferences);

    public abstract T zza(Bundle bundle);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract T zza(JSONObject jSONObject);

    public abstract void zza(SharedPreferences.Editor editor, T t);

    public final T zzqf() {
        return this.zzcfu;
    }
}
