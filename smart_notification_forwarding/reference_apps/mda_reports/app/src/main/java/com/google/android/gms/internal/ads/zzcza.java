package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public final class zzcza implements zzdxg<zzcyz> {
    private final zzdxp<zzczs> zzezj;
    private final zzdxp<String> zzgja;
    private final zzdxp<zzcyt> zzgjb;
    private final zzdxp<zzcxz> zzgjc;

    public zzcza(zzdxp<String> zzdxpVar, zzdxp<zzcyt> zzdxpVar2, zzdxp<zzcxz> zzdxpVar3, zzdxp<zzczs> zzdxpVar4) {
        this.zzgja = zzdxpVar;
        this.zzgjb = zzdxpVar2;
        this.zzgjc = zzdxpVar3;
        this.zzezj = zzdxpVar4;
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return new zzcyz(this.zzgja.get(), this.zzgjb.get(), this.zzgjc.get(), this.zzezj.get());
    }
}
