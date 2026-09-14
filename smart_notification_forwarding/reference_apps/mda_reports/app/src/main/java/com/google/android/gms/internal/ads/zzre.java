package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes.dex */
public abstract class zzre extends zzgb implements zzrf {
    public zzre() {
        super("com.google.android.gms.ads.internal.appopen.client.IAppOpenAd");
    }

    @Override // com.google.android.gms.internal.ads.zzgb
    protected final boolean a(int i, Parcel parcel, Parcel parcel2, int i2) {
        zzrl zzrnVar;
        if (i == 2) {
            zzvu zzdm = zzdm();
            parcel2.writeNoException();
            zzge.zza(parcel2, zzdm);
            return true;
        }
        if (i != 3) {
            return false;
        }
        IBinder readStrongBinder = parcel.readStrongBinder();
        if (readStrongBinder == null) {
            zzrnVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.appopen.client.IAppOpenAdPresentationCallback");
            zzrnVar = queryLocalInterface instanceof zzrl ? (zzrl) queryLocalInterface : new zzrn(readStrongBinder);
        }
        zza(zzrnVar);
        parcel2.writeNoException();
        return true;
    }
}
