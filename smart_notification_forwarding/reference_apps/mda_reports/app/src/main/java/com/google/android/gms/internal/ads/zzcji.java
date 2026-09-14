package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
final /* synthetic */ class zzcji implements zzbme {
    private final zzdac zzfyp;

    private zzcji(zzdac zzdacVar) {
        this.zzfyp = zzdacVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzbme a(zzdac zzdacVar) {
        return new zzcji(zzdacVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbme
    public final zzxb getVideoController() {
        return this.zzfyp.getVideoController();
    }
}
