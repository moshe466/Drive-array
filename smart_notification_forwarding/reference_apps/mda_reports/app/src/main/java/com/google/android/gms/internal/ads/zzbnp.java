package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public final class zzbnp implements zzdxg<zzbmg> {
    private final zzdxp<zzbpg> zzerw;
    private final zzdxp<zzbpw> zzesq;
    private final zzdxp<zzczt> zzfbo;
    private final zzdxp<zzczl> zzffb;
    private final zzdxp<zzcxq> zzfgw;
    private final zzdxp<zzbom> zzfgx;

    private zzbnp(zzdxp<zzczt> zzdxpVar, zzdxp<zzczl> zzdxpVar2, zzdxp<zzbpg> zzdxpVar3, zzdxp<zzbpw> zzdxpVar4, zzdxp<zzcxq> zzdxpVar5, zzdxp<zzbom> zzdxpVar6) {
        this.zzfbo = zzdxpVar;
        this.zzffb = zzdxpVar2;
        this.zzerw = zzdxpVar3;
        this.zzesq = zzdxpVar4;
        this.zzfgw = zzdxpVar5;
        this.zzfgx = zzdxpVar6;
    }

    public static zzbnp zzb(zzdxp<zzczt> zzdxpVar, zzdxp<zzczl> zzdxpVar2, zzdxp<zzbpg> zzdxpVar3, zzdxp<zzbpw> zzdxpVar4, zzdxp<zzcxq> zzdxpVar5, zzdxp<zzbom> zzdxpVar6) {
        return new zzbnp(zzdxpVar, zzdxpVar2, zzdxpVar3, zzdxpVar4, zzdxpVar5, zzdxpVar6);
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return new zzbmg(this.zzfbo.get(), this.zzffb.get(), this.zzerw.get(), this.zzesq.get(), this.zzfgw.get(), this.zzfgx.get());
    }
}
