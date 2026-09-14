package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public final class zzciq {
    private zzbpd zzfjm;
    private zzczl zzfjn;

    public zzciq(zzczl zzczlVar) {
        this.zzfjn = zzczlVar;
    }

    public final void zza(zzbpd zzbpdVar) {
        this.zzfjm = zzbpdVar;
    }

    public final void zzamd() {
        zzbpd zzbpdVar = this.zzfjm;
        if (zzbpdVar != null && this.zzfjn.zzglz == 2) {
            zzbpdVar.onAdImpression();
        }
    }
}
