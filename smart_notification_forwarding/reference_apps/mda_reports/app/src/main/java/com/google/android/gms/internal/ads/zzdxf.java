package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public final class zzdxf<T> implements zzdxa<T>, zzdxg<T> {
    private static final zzdxf<Object> zziac = new zzdxf<>(null);
    private final T zzduw;

    private zzdxf(T t) {
        this.zzduw = t;
    }

    public static <T> zzdxg<T> zzbe(T t) {
        return new zzdxf(zzdxm.zza(t, "instance cannot be null"));
    }

    public static <T> zzdxg<T> zzbf(T t) {
        return t == null ? zziac : new zzdxf(t);
    }

    @Override // com.google.android.gms.internal.ads.zzdxa, com.google.android.gms.internal.ads.zzdxp
    public final T get() {
        return this.zzduw;
    }
}
