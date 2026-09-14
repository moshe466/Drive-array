package com.google.android.gms.internal.ads;

import java.util.Set;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class zzcuf<T> implements zzdxg<zzcua<T>> {
    private final zzdxp<Executor> zzfcv;
    private final zzdxp<Set<zzcub<? extends zzcty<T>>>> zzghg;

    private zzcuf(zzdxp<Executor> zzdxpVar, zzdxp<Set<zzcub<? extends zzcty<T>>>> zzdxpVar2) {
        this.zzfcv = zzdxpVar;
        this.zzghg = zzdxpVar2;
    }

    public static <T> zzcuf<T> zzau(zzdxp<Executor> zzdxpVar, zzdxp<Set<zzcub<? extends zzcty<T>>>> zzdxpVar2) {
        return new zzcuf<>(zzdxpVar, zzdxpVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return new zzcua(this.zzfcv.get(), this.zzghg.get());
    }
}
