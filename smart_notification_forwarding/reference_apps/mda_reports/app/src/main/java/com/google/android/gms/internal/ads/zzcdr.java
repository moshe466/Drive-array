package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public final class zzcdr implements zzdxg<zzcds> {
    private final zzdxp<zzcdv> zzekn;

    private zzcdr(zzdxp<zzcdv> zzdxpVar) {
        this.zzekn = zzdxpVar;
    }

    public static zzcdr zzz(zzdxp<zzcdv> zzdxpVar) {
        return new zzcdr(zzdxpVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return new zzcds(this.zzekn.get());
    }
}
