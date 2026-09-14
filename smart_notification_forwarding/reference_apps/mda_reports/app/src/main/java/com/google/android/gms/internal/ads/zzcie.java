package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public final class zzcie implements zzdxg<zzcib> {
    private final zzdxp<zzchz> zzfxr;

    private zzcie(zzdxp<zzchz> zzdxpVar) {
        this.zzfxr = zzdxpVar;
    }

    public static zzcie zzae(zzdxp<zzchz> zzdxpVar) {
        return new zzcie(zzdxpVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return new zzcib(this.zzfxr.get());
    }
}
