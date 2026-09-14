package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* JADX INFO: Add missing generic type declarations: [V] */
/* loaded from: classes.dex */
final class zzdgj<V> extends zzdgi<V> {
    private final /* synthetic */ zzdgg zzgwp;
    private final Callable<V> zzgwq;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzdgj(zzdgg zzdggVar, Callable<V> callable, Executor executor) {
        super(zzdggVar, executor);
        this.zzgwp = zzdggVar;
        this.zzgwq = (Callable) zzdei.checkNotNull(callable);
    }

    @Override // com.google.android.gms.internal.ads.zzdgi
    final void a(V v) {
        this.zzgwp.set(v);
    }

    @Override // com.google.android.gms.internal.ads.zzdha
    final V c() {
        this.a = false;
        return this.zzgwq.call();
    }

    @Override // com.google.android.gms.internal.ads.zzdha
    final String d() {
        return this.zzgwq.toString();
    }
}
