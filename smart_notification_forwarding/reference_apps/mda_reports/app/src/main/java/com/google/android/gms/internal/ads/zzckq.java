package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
final class zzckq extends zzana {
    private zzcip<zzani, zzcjy> zzfyr;

    private zzckq(zzckl zzcklVar, zzcip<zzani, zzcjy> zzcipVar) {
        this.zzfyr = zzcipVar;
    }

    @Override // com.google.android.gms.internal.ads.zzamx
    public final void zzdl(String str) {
        this.zzfyr.zzfyf.onAdFailedToLoad(0);
    }

    @Override // com.google.android.gms.internal.ads.zzamx
    public final void zztb() {
        this.zzfyr.zzfyf.onAdLoaded();
    }
}
