package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;

/* loaded from: classes.dex */
public final class zzsc extends zzgc implements zzsd {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzsc(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.cache.ICacheService");
    }

    @Override // com.google.android.gms.internal.ads.zzsd
    public final zzrx zza(zzry zzryVar) {
        Parcel c = c();
        zzge.zza(c, zzryVar);
        Parcel a = a(1, c);
        zzrx zzrxVar = (zzrx) zzge.zza(a, zzrx.CREATOR);
        a.recycle();
        return zzrxVar;
    }
}
