package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
final /* synthetic */ class zzaiy implements Runnable {
    private final zzaif zzczv;

    private zzaiy(zzaif zzaifVar) {
        this.zzczv = zzaifVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Runnable a(zzaif zzaifVar) {
        return new zzaiy(zzaifVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzczv.destroy();
    }
}
