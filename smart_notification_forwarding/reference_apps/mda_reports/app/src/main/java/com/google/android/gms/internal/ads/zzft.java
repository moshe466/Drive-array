package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzft implements Runnable {
    private final /* synthetic */ zzfu zzaab;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzft(zzfu zzfuVar) {
        this.zzaab = zzfuVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzaab.zzcr();
    }
}
