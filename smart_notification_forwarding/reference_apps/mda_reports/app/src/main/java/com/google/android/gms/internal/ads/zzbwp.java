package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public final class zzbwp implements zzdxg<zzbwq> {
    private final zzdxp<zzbwi> zzfly;

    private zzbwp(zzdxp<zzbwi> zzdxpVar) {
        this.zzfly = zzdxpVar;
    }

    public static zzbwp zzx(zzdxp<zzbwi> zzdxpVar) {
        return new zzbwp(zzdxpVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return new zzbwq(this.zzfly.get());
    }
}
