package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzlr implements Runnable {
    private final /* synthetic */ zzlp zzbat;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzlr(zzlp zzlpVar) {
        this.zzbat = zzlpVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z;
        zzmc zzmcVar;
        z = this.zzbat.zzaek;
        if (z) {
            return;
        }
        zzmcVar = this.zzbat.zzbae;
        zzmcVar.zza((zzmc) this.zzbat);
    }
}
