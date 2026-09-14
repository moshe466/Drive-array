package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;

/* loaded from: classes.dex */
public final class zzri extends zzgc implements zzrg {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzri(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.appopen.client.IAppOpenAdLoadCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzrg
    public final void onAppOpenAdFailedToLoad(int i) {
        Parcel c = c();
        c.writeInt(i);
        b(2, c);
    }

    @Override // com.google.android.gms.internal.ads.zzrg
    public final void zza(zzrf zzrfVar) {
        Parcel c = c();
        zzge.zza(c, zzrfVar);
        b(1, c);
    }
}
