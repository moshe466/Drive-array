package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdgy;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* loaded from: classes.dex */
public final class zzdgs extends zzdgz {
    @SafeVarargs
    public static <V> zzdgx<V> zza(zzdhe<? extends V>... zzdheVarArr) {
        return new zzdgx<>(false, zzdeu.zzb(zzdheVarArr), null);
    }

    public static <O> zzdhe<O> zza(zzdgd<O> zzdgdVar, Executor executor) {
        zzdhs zzdhsVar = new zzdhs(zzdgdVar);
        executor.execute(zzdhsVar);
        return zzdhsVar;
    }

    public static <V> zzdhe<V> zza(zzdhe<V> zzdheVar, long j, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        return zzdheVar.isDone() ? zzdheVar : zzdho.a(zzdheVar, j, timeUnit, scheduledExecutorService);
    }

    public static <V> void zza(zzdhe<V> zzdheVar, zzdgt<? super V> zzdgtVar, Executor executor) {
        zzdei.checkNotNull(zzdgtVar);
        zzdheVar.addListener(new zzdgu(zzdheVar, zzdgtVar), executor);
    }

    public static <V> zzdhe<V> zzaj(@NullableDecl V v) {
        return v == null ? (zzdhe<V>) zzdgy.a : new zzdgy(v);
    }

    @SafeVarargs
    public static <V> zzdgx<V> zzb(zzdhe<? extends V>... zzdheVarArr) {
        return new zzdgx<>(true, zzdeu.zzb(zzdheVarArr), null);
    }

    public static <I, O> zzdhe<O> zzb(zzdhe<I> zzdheVar, zzded<? super I, ? extends O> zzdedVar, Executor executor) {
        return zzdfu.a(zzdheVar, zzdedVar, executor);
    }

    public static <I, O> zzdhe<O> zzb(zzdhe<I> zzdheVar, zzdgf<? super I, ? extends O> zzdgfVar, Executor executor) {
        return zzdfu.a(zzdheVar, zzdgfVar, executor);
    }

    public static <V, X extends Throwable> zzdhe<V> zzb(zzdhe<? extends V> zzdheVar, Class<X> cls, zzdgf<? super X, ? extends V> zzdgfVar, Executor executor) {
        return zzdfr.a(zzdheVar, cls, zzdgfVar, executor);
    }

    public static <V> V zzb(Future<V> future) {
        if (future.isDone()) {
            return (V) zzdhw.zza(future);
        }
        throw new IllegalStateException(zzdek.zzb("Future was expected to be done: %s", future));
    }

    public static <V> V zzc(Future<V> future) {
        zzdei.checkNotNull(future);
        try {
            return (V) zzdhw.zza(future);
        } catch (ExecutionException e) {
            Throwable cause = e.getCause();
            if (cause instanceof Error) {
                throw new zzdgk((Error) cause);
            }
            throw new zzdht(cause);
        }
    }

    public static <V> zzdhe<List<V>> zzg(Iterable<? extends zzdhe<? extends V>> iterable) {
        return new zzdgh(zzdeu.zzf(iterable), true);
    }

    public static <V> zzdgx<V> zzh(Iterable<? extends zzdhe<? extends V>> iterable) {
        return new zzdgx<>(false, zzdeu.zzf(iterable), null);
    }

    public static <V> zzdgx<V> zzi(Iterable<? extends zzdhe<? extends V>> iterable) {
        return new zzdgx<>(true, zzdeu.zzf(iterable), null);
    }

    public static <V> zzdhe<V> zzk(Throwable th) {
        zzdei.checkNotNull(th);
        return new zzdgy.zza(th);
    }
}
