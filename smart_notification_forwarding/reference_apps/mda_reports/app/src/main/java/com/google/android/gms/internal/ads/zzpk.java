package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzpk implements Runnable {
    private final /* synthetic */ zzpg zzbjg;
    private final /* synthetic */ int zzbjm;
    private final /* synthetic */ long zzbjn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzpk(zzpg zzpgVar, int i, long j) {
        this.zzbjg = zzpgVar;
        this.zzbjm = i;
        this.zzbjn = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzpd zzpdVar;
        zzpdVar = this.zzbjg.zzbjh;
        zzpdVar.zze(this.zzbjm, this.zzbjn);
    }
}
