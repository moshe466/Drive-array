package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public final class zzdax {
    private zzdaw zzgnh = null;
    private zzdaw zzgni = null;
    private zzdaw zzgnj = null;
    private zzdaw zzgnk = null;
    private zzdaw zzgnl = null;
    private zzdaw zzgnm = null;
    private zzdaw zzgnn = null;
    private zzdaw zzgno = null;

    public final void onAdClosed() {
        zzdaw zzdawVar = this.zzgnk;
        if (zzdawVar != null) {
            zzdawVar.execute();
        }
    }

    public final void zza(zzdaw zzdawVar) {
        this.zzgnk = zzdawVar;
    }
}
