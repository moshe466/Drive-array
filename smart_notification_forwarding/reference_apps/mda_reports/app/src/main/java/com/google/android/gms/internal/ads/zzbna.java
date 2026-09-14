package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public final class zzbna implements zzdxg<zzbmx> {
    private final zzdxp<zzbpm> zzesd;

    private zzbna(zzdxp<zzbpm> zzdxpVar) {
        this.zzesd = zzdxpVar;
    }

    public static zzbna zze(zzdxp<zzbpm> zzdxpVar) {
        return new zzbna(zzdxpVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return new zzbmx(this.zzesd.get());
    }
}
