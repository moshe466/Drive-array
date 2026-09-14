package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public final class zzcav implements zzdxg<zzcar> {
    private final zzdxp<zzbra> zzerj;
    private final zzdxp<zzbqa> zzerq;
    private final zzdxp<zzbpm> zzesd;
    private final zzdxp<zzboq> zzesg;
    private final zzdxp<zzbqj> zzesu;

    public zzcav(zzdxp<zzboq> zzdxpVar, zzdxp<zzbpm> zzdxpVar2, zzdxp<zzbqa> zzdxpVar3, zzdxp<zzbqj> zzdxpVar4, zzdxp<zzbra> zzdxpVar5) {
        this.zzesg = zzdxpVar;
        this.zzesd = zzdxpVar2;
        this.zzerq = zzdxpVar3;
        this.zzesu = zzdxpVar4;
        this.zzerj = zzdxpVar5;
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return new zzcar(this.zzesg.get(), this.zzesd.get(), this.zzerq.get(), this.zzesu.get(), this.zzerj.get());
    }
}
