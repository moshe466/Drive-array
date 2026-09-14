package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzavr implements Runnable {
    private final /* synthetic */ zzavo zzdru;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzavr(zzavo zzavoVar) {
        this.zzdru = zzavoVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzdru.thread = Thread.currentThread();
        this.zzdru.zztu();
    }
}
