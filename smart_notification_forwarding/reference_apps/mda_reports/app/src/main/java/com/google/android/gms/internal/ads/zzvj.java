package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;

/* loaded from: classes.dex */
public final class zzvj extends zzgc implements zzvh {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzvj(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAdListener");
    }

    @Override // com.google.android.gms.internal.ads.zzvh
    public final void onAdClicked() {
        b(6, c());
    }

    @Override // com.google.android.gms.internal.ads.zzvh
    public final void onAdClosed() {
        b(1, c());
    }

    @Override // com.google.android.gms.internal.ads.zzvh
    public final void onAdFailedToLoad(int i) {
        Parcel c = c();
        c.writeInt(i);
        b(2, c);
    }

    @Override // com.google.android.gms.internal.ads.zzvh
    public final void onAdImpression() {
        b(7, c());
    }

    @Override // com.google.android.gms.internal.ads.zzvh
    public final void onAdLeftApplication() {
        b(3, c());
    }

    @Override // com.google.android.gms.internal.ads.zzvh
    public final void onAdLoaded() {
        b(4, c());
    }

    @Override // com.google.android.gms.internal.ads.zzvh
    public final void onAdOpened() {
        b(5, c());
    }
}
