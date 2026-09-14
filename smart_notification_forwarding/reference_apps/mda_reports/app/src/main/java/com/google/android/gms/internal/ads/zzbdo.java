package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
final class zzbdo implements com.google.android.gms.ads.internal.overlay.zzo {
    private com.google.android.gms.ads.internal.overlay.zzo zzdhq;
    private zzbdi zzeey;

    public zzbdo(zzbdi zzbdiVar, com.google.android.gms.ads.internal.overlay.zzo zzoVar) {
        this.zzeey = zzbdiVar;
        this.zzdhq = zzoVar;
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzo
    public final void onPause() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzo
    public final void onResume() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzo
    public final void zzte() {
        this.zzdhq.zzte();
        this.zzeey.zzzt();
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzo
    public final void zztf() {
        this.zzdhq.zztf();
        this.zzeey.zztr();
    }
}
