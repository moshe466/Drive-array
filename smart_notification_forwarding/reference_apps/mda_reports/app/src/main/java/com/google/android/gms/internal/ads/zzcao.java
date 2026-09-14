package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzcao implements zzdgt<zzbdi> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcao(zzcaj zzcajVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzdgt
    public final /* synthetic */ void onSuccess(zzbdi zzbdiVar) {
        zzbdiVar.destroy();
    }

    @Override // com.google.android.gms.internal.ads.zzdgt
    public final void zzb(Throwable th) {
    }
}
