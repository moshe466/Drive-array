package com.google.android.gms.internal.measurement;

import java.io.Serializable;

/* loaded from: classes.dex */
public abstract class zzcy<T> implements Serializable {
    public static <T> zzcy<T> zza(T t) {
        return new zzda(zzcx.zza(t));
    }

    public static <T> zzcy<T> zzc() {
        return zzcw.a;
    }

    public abstract boolean zza();

    public abstract T zzb();
}
