package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
final class zzbap implements Runnable {
    private final /* synthetic */ zzbai zzdyo;
    private final /* synthetic */ boolean zzdyr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbap(zzbai zzbaiVar, boolean z) {
        this.zzdyo = zzbaiVar;
        this.zzdyr = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzdyo.zzd("windowVisibilityChanged", "isVisible", String.valueOf(this.zzdyr));
    }
}
