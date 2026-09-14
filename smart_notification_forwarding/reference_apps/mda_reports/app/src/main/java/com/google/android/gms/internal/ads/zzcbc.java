package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public final class zzcbc implements zzdxg<zzcaz> {
    private final zzdxp<zzbpm> zzesd;
    private final zzdxp<zzczl> zzfbp;

    public zzcbc(zzdxp<zzbpm> zzdxpVar, zzdxp<zzczl> zzdxpVar2) {
        this.zzesd = zzdxpVar;
        this.zzfbp = zzdxpVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return new zzcaz(this.zzesd.get(), this.zzfbp.get());
    }
}
