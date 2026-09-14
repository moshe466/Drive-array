package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;

/* loaded from: classes.dex */
public final class zzasq extends zzgc implements zzaso {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzasq(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.rewarded.client.IRewardedAdLoadCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzaso
    public final void onRewardedAdFailedToLoad(int i) {
        Parcel c = c();
        c.writeInt(i);
        b(2, c);
    }

    @Override // com.google.android.gms.internal.ads.zzaso
    public final void onRewardedAdLoaded() {
        b(1, c());
    }
}
