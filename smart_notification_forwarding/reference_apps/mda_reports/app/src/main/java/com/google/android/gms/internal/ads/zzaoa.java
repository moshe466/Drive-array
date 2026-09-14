package com.google.android.gms.internal.ads;

import android.app.Activity;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;

/* loaded from: classes.dex */
final class zzaoa implements Runnable {
    private final /* synthetic */ zzany zzdew;
    private final /* synthetic */ AdOverlayInfoParcel zzdfe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaoa(zzany zzanyVar, AdOverlayInfoParcel adOverlayInfoParcel) {
        this.zzdew = zzanyVar;
        this.zzdfe = adOverlayInfoParcel;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Activity activity;
        com.google.android.gms.ads.internal.zzq.zzkp();
        activity = this.zzdew.zzdex;
        com.google.android.gms.ads.internal.overlay.zzn.zza(activity, this.zzdfe, true);
    }
}
