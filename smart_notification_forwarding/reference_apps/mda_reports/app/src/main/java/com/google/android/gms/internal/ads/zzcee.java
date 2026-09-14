package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.doubleclick.AppEventListener;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class zzcee {
    public static Set<zzbsu<zzbph>> zza(zzceo zzceoVar, Executor executor) {
        return zzc(zzceoVar, executor);
    }

    public static Set<zzbsu<AppEventListener>> zzb(zzceo zzceoVar, Executor executor) {
        return zzc(zzceoVar, executor);
    }

    public static Set<zzbsu<zzbqb>> zzc(zzceo zzceoVar, Executor executor) {
        return zzc(zzceoVar, executor);
    }

    private static <T> Set<zzbsu<T>> zzc(T t, Executor executor) {
        return zzabc.zzctx.get().booleanValue() ? Collections.singleton(new zzbsu(t, executor)) : Collections.emptySet();
    }

    public static Set<zzbsu<zzbow>> zzd(zzceo zzceoVar, Executor executor) {
        return zzc(zzceoVar, executor);
    }

    public static Set<zzbsu<zzbov>> zze(zzceo zzceoVar, Executor executor) {
        return zzc(zzceoVar, executor);
    }

    public static Set<zzbsu<zzbpe>> zzf(zzceo zzceoVar, Executor executor) {
        return zzc(zzceoVar, executor);
    }

    public static Set<zzbsu<zzty>> zzg(zzceo zzceoVar, Executor executor) {
        return zzc(zzceoVar, executor);
    }

    public static Set<zzbsu<zzdcx>> zzh(zzceo zzceoVar, Executor executor) {
        return zzc(zzceoVar, executor);
    }

    public static Set<zzbsu<zzbqx>> zzi(zzceo zzceoVar, Executor executor) {
        return zzc(zzceoVar, executor);
    }
}
