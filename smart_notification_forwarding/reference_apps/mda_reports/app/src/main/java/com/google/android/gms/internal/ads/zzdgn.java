package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class zzdgn<V> extends zzdgw<V> {
    public static <V> zzdgn<V> zze(zzdhe<V> zzdheVar) {
        return zzdheVar instanceof zzdgn ? (zzdgn) zzdheVar : new zzdgp(zzdheVar);
    }

    public final zzdgn<V> zza(long j, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        return (zzdgn) zzdgs.zza(this, j, timeUnit, scheduledExecutorService);
    }

    public final <T> zzdgn<T> zza(zzded<? super V, T> zzdedVar, Executor executor) {
        zzdei.checkNotNull(zzdedVar);
        zzdfw zzdfwVar = new zzdfw(this, zzdedVar);
        addListener(zzdfwVar, zzdhg.a(executor, zzdfwVar));
        return zzdfwVar;
    }

    public final <X extends Throwable> zzdgn<V> zza(Class<X> cls, zzded<? super X, ? extends V> zzdedVar, Executor executor) {
        zzdft zzdftVar = new zzdft(this, cls, zzdedVar);
        addListener(zzdftVar, zzdhg.a(executor, zzdftVar));
        return zzdftVar;
    }
}
