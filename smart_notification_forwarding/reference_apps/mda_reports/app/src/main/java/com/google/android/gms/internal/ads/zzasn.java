package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;

/* loaded from: classes.dex */
public final class zzasn extends zzgc implements zzasl {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzasn(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.rewarded.client.IRewardedAdCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzasl
    public final void onRewardedAdClosed() {
        b(2, c());
    }

    @Override // com.google.android.gms.internal.ads.zzasl
    public final void onRewardedAdFailedToShow(int i) {
        Parcel c = c();
        c.writeInt(i);
        b(4, c);
    }

    @Override // com.google.android.gms.internal.ads.zzasl
    public final void onRewardedAdOpened() {
        b(1, c());
    }

    @Override // com.google.android.gms.internal.ads.zzasl
    public final void zza(zzasf zzasfVar) {
        Parcel c = c();
        zzge.zza(c, zzasfVar);
        b(3, c);
    }
}
