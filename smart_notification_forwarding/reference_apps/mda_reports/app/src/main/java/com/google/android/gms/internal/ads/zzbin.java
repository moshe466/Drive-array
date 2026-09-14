package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public final class zzbin implements zzdxg<zzbio> {
    private final zzdxp<zzavu> zzemi;

    private zzbin(zzdxp<zzavu> zzdxpVar) {
        this.zzemi = zzdxpVar;
    }

    public static zzbin zza(zzdxp<zzavu> zzdxpVar) {
        return new zzbin(zzdxpVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return new zzbio(this.zzemi.get());
    }
}
