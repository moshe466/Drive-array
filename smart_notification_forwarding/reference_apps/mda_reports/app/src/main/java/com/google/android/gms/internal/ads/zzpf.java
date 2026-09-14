package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzpf implements Runnable {
    private final /* synthetic */ zzit zzahe;
    private final /* synthetic */ zzpg zzbjg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzpf(zzpg zzpgVar, zzit zzitVar) {
        this.zzbjg = zzpgVar;
        this.zzahe = zzitVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzpd zzpdVar;
        zzpdVar = this.zzbjg.zzbjh;
        zzpdVar.zze(this.zzahe);
    }
}
