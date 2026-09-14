package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzls implements Runnable {
    private final /* synthetic */ zzlp zzbat;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzls(zzlp zzlpVar) {
        this.zzbat = zzlpVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzbat.zzhl();
    }
}
