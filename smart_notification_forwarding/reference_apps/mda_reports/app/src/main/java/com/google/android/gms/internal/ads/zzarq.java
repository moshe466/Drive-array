package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;

/* loaded from: classes.dex */
public final class zzarq extends zzgc implements zzaro {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzarq(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.reward.client.IRewardedVideoAdListener");
    }

    @Override // com.google.android.gms.internal.ads.zzaro
    public final void onRewardedVideoAdClosed() {
        b(4, c());
    }

    @Override // com.google.android.gms.internal.ads.zzaro
    public final void onRewardedVideoAdFailedToLoad(int i) {
        Parcel c = c();
        c.writeInt(i);
        b(7, c);
    }

    @Override // com.google.android.gms.internal.ads.zzaro
    public final void onRewardedVideoAdLeftApplication() {
        b(6, c());
    }

    @Override // com.google.android.gms.internal.ads.zzaro
    public final void onRewardedVideoAdLoaded() {
        b(1, c());
    }

    @Override // com.google.android.gms.internal.ads.zzaro
    public final void onRewardedVideoAdOpened() {
        b(2, c());
    }

    @Override // com.google.android.gms.internal.ads.zzaro
    public final void onRewardedVideoCompleted() {
        b(8, c());
    }

    @Override // com.google.android.gms.internal.ads.zzaro
    public final void onRewardedVideoStarted() {
        b(3, c());
    }

    @Override // com.google.android.gms.internal.ads.zzaro
    public final void zza(zzare zzareVar) {
        Parcel c = c();
        zzge.zza(c, zzareVar);
        b(5, c);
    }
}
