package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;

/* loaded from: classes.dex */
public final class zzbfu extends zzgc implements zzbfs {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbfu(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.measurement.IMeasurementManager");
    }

    @Override // com.google.android.gms.internal.ads.zzbfs
    public final void zza(IObjectWrapper iObjectWrapper, zzbfq zzbfqVar) {
        Parcel c = c();
        zzge.zza(c, iObjectWrapper);
        zzge.zza(c, zzbfqVar);
        b(2, c);
    }
}
