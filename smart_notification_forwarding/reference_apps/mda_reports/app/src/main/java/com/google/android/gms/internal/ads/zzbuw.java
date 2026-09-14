package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public final class zzbuw implements zzdxg<zzcio<zzbtu>> {
    private final zzdxp<zzdhd> zzfei;
    private final zzdxp<zzdcr> zzfet;
    private final zzdxp<zzckl> zzfeu;
    private final zzdxp<zzcmy> zzfev;

    public zzbuw(zzdxp<zzdcr> zzdxpVar, zzdxp<zzdhd> zzdxpVar2, zzdxp<zzckl> zzdxpVar3, zzdxp<zzcmy> zzdxpVar4) {
        this.zzfet = zzdxpVar;
        this.zzfei = zzdxpVar2;
        this.zzfeu = zzdxpVar3;
        this.zzfev = zzdxpVar4;
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return (zzcio) zzdxm.zza(new zzcna(this.zzfet.get(), this.zzfei.get(), this.zzfev.get(), this.zzfeu.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
