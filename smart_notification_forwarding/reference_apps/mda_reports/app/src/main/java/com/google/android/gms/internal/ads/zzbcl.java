package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
final class zzbcl implements Runnable {
    private final /* synthetic */ zzbci zzeda;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbcl(zzbci zzbciVar) {
        this.zzeda = zzbciVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.google.android.gms.ads.internal.zzq.zzlm().zzb(this.zzeda);
    }
}
