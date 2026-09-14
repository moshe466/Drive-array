package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
final /* synthetic */ class zzcbe implements Runnable {
    private final zzbdi zzehp;

    private zzcbe(zzbdi zzbdiVar) {
        this.zzehp = zzbdiVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Runnable a(zzbdi zzbdiVar) {
        return new zzcbe(zzbdiVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzehp.destroy();
    }
}
