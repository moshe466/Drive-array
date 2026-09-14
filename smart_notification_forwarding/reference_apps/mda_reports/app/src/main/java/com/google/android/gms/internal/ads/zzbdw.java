package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
final class zzbdw implements Runnable {
    private final /* synthetic */ zzbdu zzefr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbdw(zzbdu zzbduVar) {
        this.zzefr = zzbduVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzbdi zzbdiVar;
        zzbdiVar = this.zzefr.zzefo;
        zzbdiVar.destroy();
    }
}
