package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
final class zzcld extends zzanb {
    private zzcip<zzani, zzcjy> zzfyr;
    private final /* synthetic */ zzclb zzfzy;

    private zzcld(zzclb zzclbVar, zzcip<zzani, zzcjy> zzcipVar) {
        this.zzfzy = zzclbVar;
        this.zzfyr = zzcipVar;
    }

    @Override // com.google.android.gms.internal.ads.zzanc
    public final void zza(zzalr zzalrVar) {
        zzclb.a(this.zzfzy, zzalrVar);
        this.zzfyr.zzfyf.onAdLoaded();
    }

    @Override // com.google.android.gms.internal.ads.zzanc
    public final void zzdl(String str) {
        this.zzfyr.zzfyf.onAdFailedToLoad(0);
    }
}
