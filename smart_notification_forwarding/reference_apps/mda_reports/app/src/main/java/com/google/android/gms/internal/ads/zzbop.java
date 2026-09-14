package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public final class zzbop implements zzdxg<zzbom> {
    private final zzdxp<zzczl> zzffb;
    private final zzdxp<String> zzfhl;

    private zzbop(zzdxp<zzczl> zzdxpVar, zzdxp<String> zzdxpVar2) {
        this.zzffb = zzdxpVar;
        this.zzfhl = zzdxpVar2;
    }

    public static zzbop zzh(zzdxp<zzczl> zzdxpVar, zzdxp<String> zzdxpVar2) {
        return new zzbop(zzdxpVar, zzdxpVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return new zzbom(this.zzffb.get(), this.zzfhl.get());
    }
}
