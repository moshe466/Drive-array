package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [V] */
/* loaded from: classes.dex */
public final class zzdhu<V> extends zzdha<V> {
    private final Callable<V> zzgwq;
    private final /* synthetic */ zzdhs zzgxo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdhu(zzdhs zzdhsVar, Callable<V> callable) {
        this.zzgxo = zzdhsVar;
        this.zzgwq = (Callable) zzdei.checkNotNull(callable);
    }

    @Override // com.google.android.gms.internal.ads.zzdha
    final void a(V v, Throwable th) {
        if (th == null) {
            this.zzgxo.set(v);
        } else {
            this.zzgxo.setException(th);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdha
    final boolean b() {
        return this.zzgxo.isDone();
    }

    @Override // com.google.android.gms.internal.ads.zzdha
    final V c() {
        return this.zzgwq.call();
    }

    @Override // com.google.android.gms.internal.ads.zzdha
    final String d() {
        return this.zzgwq.toString();
    }
}
