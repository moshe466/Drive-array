package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
final class zzdhi implements Runnable {
    private final /* synthetic */ Runnable zzgxf;
    private final /* synthetic */ zzdhf zzgxg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdhi(zzdhf zzdhfVar, Runnable runnable) {
        this.zzgxg = zzdhfVar;
        this.zzgxf = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzgxg.a = false;
        this.zzgxf.run();
    }
}
