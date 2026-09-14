package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public final class zzcoc implements zzdxg<zzcnz> {
    private final zzdxp<zzcka> zzgbd;

    private zzcoc(zzdxp<zzcka> zzdxpVar) {
        this.zzgbd = zzdxpVar;
    }

    public static zzcoc zzag(zzdxp<zzcka> zzdxpVar) {
        return new zzcoc(zzdxpVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return new zzcnz(this.zzgbd.get());
    }
}
