package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
final /* synthetic */ class zzcjb implements Runnable {
    private final zzbdi zzehp;

    private zzcjb(zzbdi zzbdiVar) {
        this.zzehp = zzbdiVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Runnable a(zzbdi zzbdiVar) {
        return new zzcjb(zzbdiVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzehp.zzaan();
    }
}
