package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzbmu implements zzdgt<zzbmd> {
    private final /* synthetic */ zzdgt zzfgc;
    private final /* synthetic */ zzbmo zzfgd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbmu(zzbmo zzbmoVar, zzdgt zzdgtVar) {
        this.zzfgd = zzbmoVar;
        this.zzfgc = zzdgtVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdgt
    public final /* synthetic */ void onSuccess(zzbmd zzbmdVar) {
        this.zzfgd.zzagu();
        this.zzfgc.onSuccess(zzbmdVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdgt
    public final void zzb(Throwable th) {
        this.zzfgd.zzagu();
        this.zzfgc.zzb(th);
    }
}
