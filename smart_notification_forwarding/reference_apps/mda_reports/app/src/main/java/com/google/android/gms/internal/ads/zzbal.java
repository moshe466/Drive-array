package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
final /* synthetic */ class zzbal implements Runnable {
    private final zzbag zzdyn;

    private zzbal(zzbag zzbagVar) {
        this.zzdyn = zzbagVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Runnable a(zzbag zzbagVar) {
        return new zzbal(zzbagVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzdyn.stop();
    }
}
