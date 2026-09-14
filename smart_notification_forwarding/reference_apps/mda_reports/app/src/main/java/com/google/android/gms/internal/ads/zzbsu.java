package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class zzbsu<T> {
    public Executor executor;
    public T zzfir;

    public zzbsu(T t, Executor executor) {
        this.zzfir = t;
        this.executor = executor;
    }

    public static <T> zzbsu<T> zzb(T t, Executor executor) {
        return new zzbsu<>(t, executor);
    }
}
