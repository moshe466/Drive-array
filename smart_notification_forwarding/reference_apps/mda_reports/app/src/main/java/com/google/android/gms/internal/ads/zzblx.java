package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public final class zzblx implements zzdxg<zzbly> {
    private final zzdxp<zzczl> zzfbp;
    private final zzdxp<zzbpd> zzfff;
    private final zzdxp<zzbqf> zzffg;

    private zzblx(zzdxp<zzczl> zzdxpVar, zzdxp<zzbpd> zzdxpVar2, zzdxp<zzbqf> zzdxpVar3) {
        this.zzfbp = zzdxpVar;
        this.zzfff = zzdxpVar2;
        this.zzffg = zzdxpVar3;
    }

    public static zzblx zzf(zzdxp<zzczl> zzdxpVar, zzdxp<zzbpd> zzdxpVar2, zzdxp<zzbqf> zzdxpVar3) {
        return new zzblx(zzdxpVar, zzdxpVar2, zzdxpVar3);
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return new zzbly(this.zzfbp.get(), this.zzfff.get(), this.zzffg.get());
    }
}
