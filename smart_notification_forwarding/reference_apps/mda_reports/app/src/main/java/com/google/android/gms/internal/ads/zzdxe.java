package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public final class zzdxe<T> implements zzdxg<T> {
    private zzdxp<T> zziab;

    public static <T> void zzax(zzdxp<T> zzdxpVar, zzdxp<T> zzdxpVar2) {
        zzdxm.checkNotNull(zzdxpVar2);
        zzdxe zzdxeVar = (zzdxe) zzdxpVar;
        if (zzdxeVar.zziab != null) {
            throw new IllegalStateException();
        }
        zzdxeVar.zziab = zzdxpVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final T get() {
        zzdxp<T> zzdxpVar = this.zziab;
        if (zzdxpVar != null) {
            return zzdxpVar.get();
        }
        throw new IllegalStateException();
    }
}
