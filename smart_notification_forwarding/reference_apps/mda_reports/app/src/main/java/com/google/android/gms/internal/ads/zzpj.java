package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzpj implements Runnable {
    private final /* synthetic */ zzpg zzbjg;
    private final /* synthetic */ int zzbji;
    private final /* synthetic */ int zzbjj;
    private final /* synthetic */ int zzbjk;
    private final /* synthetic */ float zzbjl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzpj(zzpg zzpgVar, int i, int i2, int i3, float f) {
        this.zzbjg = zzpgVar;
        this.zzbji = i;
        this.zzbjj = i2;
        this.zzbjk = i3;
        this.zzbjl = f;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzpd zzpdVar;
        zzpdVar = this.zzbjg.zzbjh;
        zzpdVar.zza(this.zzbji, this.zzbjj, this.zzbjk, this.zzbjl);
    }
}
