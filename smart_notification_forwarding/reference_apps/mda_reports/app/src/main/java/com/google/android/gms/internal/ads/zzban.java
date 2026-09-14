package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
final class zzban implements Runnable {
    private final /* synthetic */ zzbai zzdyo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzban(zzbai zzbaiVar) {
        this.zzdyo = zzbaiVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzdyo.zzd("surfaceCreated", new String[0]);
    }
}
