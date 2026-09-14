package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
final class zzbam implements Runnable {
    private final /* synthetic */ zzbai zzdyo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbam(zzbai zzbaiVar) {
        this.zzdyo = zzbaiVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzdyo.zzd("surfaceDestroyed", new String[0]);
    }
}
