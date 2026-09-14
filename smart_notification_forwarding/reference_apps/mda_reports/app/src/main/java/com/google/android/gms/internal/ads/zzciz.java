package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
final /* synthetic */ class zzciz implements zzbme {
    private final zzbdi zzehp;

    private zzciz(zzbdi zzbdiVar) {
        this.zzehp = zzbdiVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzbme a(zzbdi zzbdiVar) {
        return new zzciz(zzbdiVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbme
    public final zzxb getVideoController() {
        return this.zzehp.zzyl();
    }
}
