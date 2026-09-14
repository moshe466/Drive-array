package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
final class zzcfy implements zzdgt<zzczt> {
    private final /* synthetic */ zzcfv zzfvh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcfy(zzcfv zzcfvVar) {
        this.zzfvh = zzcfvVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdgt
    public final /* synthetic */ void onSuccess(zzczt zzcztVar) {
        zzbqs zzbqsVar;
        zzbqsVar = this.zzfvh.zzfvd;
        zzbqsVar.zzb(zzcztVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdgt
    public final void zzb(Throwable th) {
    }
}
