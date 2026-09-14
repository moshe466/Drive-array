package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzcbz implements zzaon {
    private final /* synthetic */ zzcbp zzfrk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcbz(zzcbp zzcbpVar) {
        this.zzfrk = zzcbpVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaon
    public final void zza(int i, int i2, int i3, int i4) {
        zzbpm zzbpmVar;
        zzbpmVar = this.zzfrk.zzfgg;
        zzbpmVar.onAdOpened();
    }

    @Override // com.google.android.gms.internal.ads.zzaon
    public final void zzti() {
        zzbpm zzbpmVar;
        zzbpmVar = this.zzfrk.zzfgg;
        zzbpmVar.onAdClosed();
    }

    @Override // com.google.android.gms.internal.ads.zzaon
    public final void zztj() {
        zzbqw zzbqwVar;
        zzbqwVar = this.zzfrk.zzfrh;
        zzbqwVar.zzagj();
    }
}
