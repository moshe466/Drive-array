package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzpi implements Runnable {
    private final /* synthetic */ String zzahi;
    private final /* synthetic */ long zzahj;
    private final /* synthetic */ long zzahk;
    private final /* synthetic */ zzpg zzbjg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzpi(zzpg zzpgVar, String str, long j, long j2) {
        this.zzbjg = zzpgVar;
        this.zzahi = str;
        this.zzahj = j;
        this.zzahk = j2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzpd zzpdVar;
        zzpdVar = this.zzbjg.zzbjh;
        zzpdVar.zzd(this.zzahi, this.zzahj, this.zzahk);
    }
}
