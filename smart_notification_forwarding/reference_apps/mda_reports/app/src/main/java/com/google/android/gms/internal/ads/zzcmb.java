package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
final class zzcmb extends zzang {
    private zzcip<zzani, zzcjy> zzfyr;

    private zzcmb(zzcma zzcmaVar, zzcip<zzani, zzcjy> zzcipVar) {
        this.zzfyr = zzcipVar;
    }

    @Override // com.google.android.gms.internal.ads.zzand
    public final void zzdl(String str) {
        this.zzfyr.zzfyf.onAdFailedToLoad(0);
    }

    @Override // com.google.android.gms.internal.ads.zzand
    public final void zztb() {
        this.zzfyr.zzfyf.onAdLoaded();
    }
}
