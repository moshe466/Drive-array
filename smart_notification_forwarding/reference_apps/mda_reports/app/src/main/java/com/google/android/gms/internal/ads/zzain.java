package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
final class zzain implements Runnable {
    private final /* synthetic */ zzaih zzcze;
    private final /* synthetic */ String zzczg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzain(zzaih zzaihVar, String str) {
        this.zzcze = zzaihVar;
        this.zzczg = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzbdi zzbdiVar;
        zzbdiVar = this.zzcze.zzcza;
        zzbdiVar.loadUrl(this.zzczg);
    }
}
