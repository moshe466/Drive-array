package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class zzdgx<V> {
    private final boolean zzgwc;
    private final zzdeu<zzdhe<? extends V>> zzgww;

    private zzdgx(boolean z, zzdeu<zzdhe<? extends V>> zzdeuVar) {
        this.zzgwc = z;
        this.zzgww = zzdeuVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzdgx(boolean z, zzdeu zzdeuVar, zzdgv zzdgvVar) {
        this(z, zzdeuVar);
    }

    public final <C> zzdhe<C> zza(Callable<C> callable, Executor executor) {
        return new zzdgg(this.zzgww, this.zzgwc, executor, callable);
    }
}
