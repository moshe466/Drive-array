package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
final /* synthetic */ class zzcke implements Runnable {
    private final zzccd zzfzn;

    private zzcke(zzccd zzccdVar) {
        this.zzfzn = zzccdVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Runnable a(zzccd zzccdVar) {
        return new zzcke(zzccdVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzfzn.zzakx();
    }
}
