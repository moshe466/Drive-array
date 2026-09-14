package com.google.android.gms.internal.ads;

import java.lang.Throwable;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzdfq<V, X extends Throwable> extends zzdfr<V, X, zzdgf<? super X, ? extends V>, zzdhe<? extends V>> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdfq(zzdhe<? extends V> zzdheVar, Class<X> cls, zzdgf<? super X, ? extends V> zzdgfVar) {
        super(zzdheVar, cls, zzdgfVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdfr
    final /* synthetic */ Object a(Object obj, Throwable th) {
        zzdgf zzdgfVar = (zzdgf) obj;
        zzdhe zzf = zzdgfVar.zzf(th);
        zzdei.zza(zzf, "AsyncFunction.apply returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", zzdgfVar);
        return zzf;
    }

    @Override // com.google.android.gms.internal.ads.zzdfr
    final /* synthetic */ void a(Object obj) {
        a((zzdhe) obj);
    }
}
