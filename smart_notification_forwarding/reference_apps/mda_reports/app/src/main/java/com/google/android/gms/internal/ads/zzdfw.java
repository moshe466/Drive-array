package com.google.android.gms.internal.ads;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzdfw<I, O> extends zzdfu<I, O, zzded<? super I, ? extends O>, O> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdfw(zzdhe<? extends I> zzdheVar, zzded<? super I, ? extends O> zzdedVar) {
        super(zzdheVar, zzdedVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdfu
    @NullableDecl
    final /* synthetic */ Object a(Object obj, @NullableDecl Object obj2) {
        return ((zzded) obj).apply(obj2);
    }

    @Override // com.google.android.gms.internal.ads.zzdfu
    final void a(@NullableDecl O o) {
        set(o);
    }
}
