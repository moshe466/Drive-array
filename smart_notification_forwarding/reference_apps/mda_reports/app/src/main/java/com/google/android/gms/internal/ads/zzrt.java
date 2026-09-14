package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzrt implements Runnable {
    private final /* synthetic */ zzrq zzbrh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzrt(zzrq zzrqVar) {
        this.zzbrh = zzrqVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzbrh.disconnect();
    }
}
