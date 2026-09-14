package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public final class zzczg implements zzdxg<zzczf> {
    private final zzdxp<zzczs> zzezj;
    private final zzdxp<zzcyt> zzgjb;
    private final zzdxp<zzcxz> zzgjc;

    public zzczg(zzdxp<zzcyt> zzdxpVar, zzdxp<zzcxz> zzdxpVar2, zzdxp<zzczs> zzdxpVar3) {
        this.zzgjb = zzdxpVar;
        this.zzgjc = zzdxpVar2;
        this.zzezj = zzdxpVar3;
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return new zzczf(this.zzgjb.get(), this.zzgjc.get(), this.zzezj.get());
    }
}
