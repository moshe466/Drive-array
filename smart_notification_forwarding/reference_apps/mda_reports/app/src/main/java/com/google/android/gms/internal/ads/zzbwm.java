package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
final /* synthetic */ class zzbwm implements Runnable {
    private final zzbxa zzflr;

    private zzbwm(zzbxa zzbxaVar) {
        this.zzflr = zzbxaVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Runnable a(zzbxa zzbxaVar) {
        return new zzbwm(zzbxaVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzflr.zzaiq();
    }
}
