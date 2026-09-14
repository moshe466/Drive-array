package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;

/* loaded from: classes.dex */
public final class zzamz extends zzgc implements zzamx {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzamz(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.rtb.IInterstitialCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzamx
    public final void zzdl(String str) {
        Parcel c = c();
        c.writeString(str);
        b(3, c);
    }

    @Override // com.google.android.gms.internal.ads.zzamx
    public final void zztb() {
        b(2, c());
    }
}
