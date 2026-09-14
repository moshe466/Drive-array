package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public final class zzblh implements zzdxg<zzcio<zzbkk>> {
    private final zzdxp<zzcna<zzbkk, zzdac, zzcjy>> zzepq;
    private final zzdxp<Boolean> zzewt;
    private final zzdxp<zzclj> zzewv;

    public zzblh(zzdxp<Boolean> zzdxpVar, zzdxp<zzclj> zzdxpVar2, zzdxp<zzcna<zzbkk, zzdac, zzcjy>> zzdxpVar3) {
        this.zzewt = zzdxpVar;
        this.zzewv = zzdxpVar2;
        this.zzepq = zzdxpVar3;
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        boolean booleanValue = this.zzewt.get().booleanValue();
        zzcio zzcioVar = (zzclj) this.zzewv.get();
        zzcio zzcioVar2 = (zzcna) this.zzepq.get();
        if (!booleanValue) {
            zzcioVar = zzcioVar2;
        }
        return (zzcio) zzdxm.zza(zzcioVar, "Cannot return null from a non-@Nullable @Provides method");
    }
}
