package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public final class zzbge implements zzdxg<zzcis<zzdac, zzcjy>> {
    private final zzbga zzejr;
    private final zzdxp<zzcka> zzejs;

    public zzbge(zzbga zzbgaVar, zzdxp<zzcka> zzdxpVar) {
        this.zzejr = zzbgaVar;
        this.zzejs = zzdxpVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return (zzcis) zzdxm.zza(new zzcks(this.zzejs.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
