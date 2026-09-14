package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public final class zzbun implements com.google.android.gms.ads.internal.overlay.zzo {
    private final zzbqj zzfjf;
    private final zzbsq zzfjg;

    public zzbun(zzbqj zzbqjVar, zzbsq zzbsqVar) {
        this.zzfjf = zzbqjVar;
        this.zzfjg = zzbsqVar;
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzo
    public final void onPause() {
        this.zzfjf.onPause();
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzo
    public final void onResume() {
        this.zzfjf.onResume();
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzo
    public final void zzte() {
        this.zzfjf.zzte();
        this.zzfjg.onHide();
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzo
    public final void zztf() {
        this.zzfjf.zztf();
        this.zzfjg.zzahy();
    }
}
