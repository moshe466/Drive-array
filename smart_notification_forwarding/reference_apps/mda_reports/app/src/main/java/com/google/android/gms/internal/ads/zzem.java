package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzem implements Runnable {
    private final /* synthetic */ zzei zzyc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzem(zzei zzeiVar) {
        this.zzyc = zzeiVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzzn.initialize(this.zzyc.a);
    }
}
