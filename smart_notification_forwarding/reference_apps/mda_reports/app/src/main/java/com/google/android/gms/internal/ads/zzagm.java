package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzagm implements Runnable {
    private final /* synthetic */ zzagh zzcyb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzagm(zzagh zzaghVar) {
        this.zzcyb = zzaghVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzcyb.disconnect();
    }
}
