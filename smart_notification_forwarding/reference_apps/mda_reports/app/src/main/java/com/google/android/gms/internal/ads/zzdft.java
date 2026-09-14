package com.google.android.gms.internal.ads;

import java.lang.Throwable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* loaded from: classes.dex */
final class zzdft<V, X extends Throwable> extends zzdfr<V, X, zzded<? super X, ? extends V>, V> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdft(zzdhe<? extends V> zzdheVar, Class<X> cls, zzded<? super X, ? extends V> zzdedVar) {
        super(zzdheVar, cls, zzdedVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdfr
    @NullableDecl
    final /* synthetic */ Object a(Object obj, Throwable th) {
        return ((zzded) obj).apply(th);
    }

    @Override // com.google.android.gms.internal.ads.zzdfr
    final void a(@NullableDecl V v) {
        set(v);
    }
}
