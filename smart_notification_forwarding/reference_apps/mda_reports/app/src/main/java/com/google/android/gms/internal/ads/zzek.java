package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzek implements Runnable {
    private final /* synthetic */ zzei zzyc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzek(zzei zzeiVar) {
        this.zzyc = zzeiVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzyc.zzch();
    }
}
