package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
final /* synthetic */ class zzcau implements com.google.android.gms.ads.internal.overlay.zzt {
    private final zzbpm zzfqr;

    private zzcau(zzbpm zzbpmVar) {
        this.zzfqr = zzbpmVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static com.google.android.gms.ads.internal.overlay.zzt a(zzbpm zzbpmVar) {
        return new zzcau(zzbpmVar);
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzt
    public final void zztv() {
        this.zzfqr.onAdLeftApplication();
    }
}
