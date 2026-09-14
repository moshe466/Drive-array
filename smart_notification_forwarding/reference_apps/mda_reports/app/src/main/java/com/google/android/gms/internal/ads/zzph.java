package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzph implements Runnable {
    private final /* synthetic */ zzgw zzahh;
    private final /* synthetic */ zzpg zzbjg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzph(zzpg zzpgVar, zzgw zzgwVar) {
        this.zzbjg = zzpgVar;
        this.zzahh = zzgwVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzpd zzpdVar;
        zzpdVar = this.zzbjg.zzbjh;
        zzpdVar.zzk(this.zzahh);
    }
}
