package com.google.android.gms.internal.ads;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzdfx<I, O> extends zzdfu<I, O, zzdgf<? super I, ? extends O>, zzdhe<? extends O>> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdfx(zzdhe<? extends I> zzdheVar, zzdgf<? super I, ? extends O> zzdgfVar) {
        super(zzdheVar, zzdgfVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdfu
    final /* synthetic */ Object a(Object obj, @NullableDecl Object obj2) {
        zzdgf zzdgfVar = (zzdgf) obj;
        zzdhe<O> zzf = zzdgfVar.zzf(obj2);
        zzdei.zza(zzf, "AsyncFunction.apply returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", zzdgfVar);
        return zzf;
    }

    @Override // com.google.android.gms.internal.ads.zzdfu
    final /* synthetic */ void a(Object obj) {
        a((zzdhe) obj);
    }
}
