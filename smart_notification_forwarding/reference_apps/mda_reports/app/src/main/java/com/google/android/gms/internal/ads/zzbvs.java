package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbod;

/* loaded from: classes.dex */
public final class zzbvs implements zzdxg<zzbmi<zzbkk>> {
    private final zzdxp<zzbqp> zzfhe;
    private final zzdxp<zzbfx> zzfkr;
    private final zzdxp<zzbod.zza> zzfks;
    private final zzdxp<zzbrm> zzfkt;
    private final zzdxp<zzbvi> zzfku;

    public zzbvs(zzdxp<zzbfx> zzdxpVar, zzdxp<zzbod.zza> zzdxpVar2, zzdxp<zzbrm> zzdxpVar3, zzdxp<zzbvi> zzdxpVar4, zzdxp<zzbqp> zzdxpVar5) {
        this.zzfkr = zzdxpVar;
        this.zzfks = zzdxpVar2;
        this.zzfkt = zzdxpVar3;
        this.zzfku = zzdxpVar4;
        this.zzfhe = zzdxpVar5;
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        zzbfx zzbfxVar = this.zzfkr.get();
        zzbod.zza zzaVar = this.zzfks.get();
        zzbrm zzbrmVar = this.zzfkt.get();
        return (zzbmi) zzdxm.zza(zzbfxVar.zzach().zzc(zzaVar.zzahh()).zzc(zzbrmVar).zzb(this.zzfku.get()).zza(new zzcns(null)).zza(new zzbma(this.zzfhe.get())).zzb(new zzbkf(null)).zzaee().zzaed(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
