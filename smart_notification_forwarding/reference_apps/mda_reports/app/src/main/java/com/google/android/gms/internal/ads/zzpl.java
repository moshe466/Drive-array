package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzpl implements Runnable {
    private final /* synthetic */ zzit zzahl;
    private final /* synthetic */ zzpg zzbjg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzpl(zzpg zzpgVar, zzit zzitVar) {
        this.zzbjg = zzpgVar;
        this.zzahl = zzitVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzpd zzpdVar;
        this.zzahl.zzge();
        zzpdVar = this.zzbjg.zzbjh;
        zzpdVar.zzf(this.zzahl);
    }
}
