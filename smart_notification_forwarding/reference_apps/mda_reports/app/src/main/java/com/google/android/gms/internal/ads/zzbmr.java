package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzbmr implements zzdgt<zzbmj> {
    private final /* synthetic */ zzdgt zzfgc;
    private final /* synthetic */ zzbmo zzfgd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbmr(zzbmo zzbmoVar, zzdgt zzdgtVar) {
        this.zzfgd = zzbmoVar;
        this.zzfgc = zzdgtVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdgt
    public final /* synthetic */ void onSuccess(zzbmj zzbmjVar) {
        this.zzfgd.zza(zzbmjVar.zzffu, this.zzfgc);
    }

    @Override // com.google.android.gms.internal.ads.zzdgt
    public final void zzb(Throwable th) {
        this.zzfgc.zzb(th);
        this.zzfgd.zzagu();
    }
}
