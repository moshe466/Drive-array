package com.google.android.gms.internal.ads;

import android.content.Context;

/* loaded from: classes.dex */
public final class zzbnw implements zzbqx {
    private final zzazb zzbli;
    private final zzavu zzdrk;
    private final zzceq zzfas;
    private final zzczu zzfgl;
    private final Context zzyv;

    public zzbnw(Context context, zzczu zzczuVar, zzazb zzazbVar, zzavu zzavuVar, zzceq zzceqVar) {
        this.zzyv = context;
        this.zzfgl = zzczuVar;
        this.zzbli = zzazbVar;
        this.zzdrk = zzavuVar;
        this.zzfas = zzceqVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbqx
    public final void zzb(zzaqk zzaqkVar) {
        if (((Boolean) zzve.zzoy().zzd(zzzn.zzcmr)).booleanValue()) {
            com.google.android.gms.ads.internal.zzq.zzky().zza(this.zzyv, this.zzbli, this.zzfgl.zzgmm, this.zzdrk.zzwa());
        }
        this.zzfas.zzall();
    }

    @Override // com.google.android.gms.internal.ads.zzbqx
    public final void zzb(zzczt zzcztVar) {
    }
}
