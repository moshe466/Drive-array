package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
final /* synthetic */ class zzcmk implements Runnable {
    private final zzccd zzfzn;

    private zzcmk(zzccd zzccdVar) {
        this.zzfzn = zzccdVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Runnable a(zzccd zzccdVar) {
        return new zzcmk(zzccdVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzfzn.zzakx();
    }
}
