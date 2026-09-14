package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;

/* loaded from: classes.dex */
public final class zzo extends com.google.android.gms.internal.common.zza implements zzm {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzo(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.IGoogleCertificatesApi");
    }

    @Override // com.google.android.gms.common.internal.zzm
    public final boolean zza(com.google.android.gms.common.zzk zzkVar, IObjectWrapper iObjectWrapper) {
        Parcel zza = zza();
        com.google.android.gms.internal.common.zzc.zza(zza, zzkVar);
        com.google.android.gms.internal.common.zzc.zza(zza, iObjectWrapper);
        Parcel a = a(5, zza);
        boolean zza2 = com.google.android.gms.internal.common.zzc.zza(a);
        a.recycle();
        return zza2;
    }
}
