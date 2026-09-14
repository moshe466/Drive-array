package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;

/* loaded from: classes.dex */
public final class zzf extends zza implements zzd {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzf(IBinder iBinder) {
        super(iBinder, "com.google.android.finsky.externalreferrer.IGetInstallReferrerService");
    }

    @Override // com.google.android.gms.internal.measurement.zzd
    public final Bundle zza(Bundle bundle) {
        Parcel c = c();
        zzb.zza(c, bundle);
        Parcel a = a(1, c);
        Bundle bundle2 = (Bundle) zzb.zza(a, Bundle.CREATOR);
        a.recycle();
        return bundle2;
    }
}
