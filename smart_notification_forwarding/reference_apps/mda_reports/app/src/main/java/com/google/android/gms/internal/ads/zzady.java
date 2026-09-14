package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes.dex */
public abstract class zzady extends zzgb implements zzadv {
    public zzady() {
        super("com.google.android.gms.ads.internal.formats.client.IOnUnifiedNativeAdLoadedListener");
    }

    public static zzadv zzv(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.IOnUnifiedNativeAdLoadedListener");
        return queryLocalInterface instanceof zzadv ? (zzadv) queryLocalInterface : new zzadx(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzgb
    protected final boolean a(int i, Parcel parcel, Parcel parcel2, int i2) {
        zzaeg zzaeiVar;
        if (i != 1) {
            return false;
        }
        IBinder readStrongBinder = parcel.readStrongBinder();
        if (readStrongBinder == null) {
            zzaeiVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.IUnifiedNativeAd");
            zzaeiVar = queryLocalInterface instanceof zzaeg ? (zzaeg) queryLocalInterface : new zzaei(readStrongBinder);
        }
        zza(zzaeiVar);
        parcel2.writeNoException();
        return true;
    }
}
