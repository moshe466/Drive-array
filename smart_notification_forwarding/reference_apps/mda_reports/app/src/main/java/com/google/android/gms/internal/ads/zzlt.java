package com.google.android.gms.internal.ads;

import java.io.IOException;

/* loaded from: classes.dex */
final class zzlt implements Runnable {
    private final /* synthetic */ zzlp zzbat;
    private final /* synthetic */ IOException zzbau;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzlt(zzlp zzlpVar, IOException iOException) {
        this.zzbat = zzlpVar;
        this.zzbau = iOException;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzma zzmaVar;
        zzmaVar = this.zzbat.zzazt;
        zzmaVar.zzb(this.zzbau);
    }
}
