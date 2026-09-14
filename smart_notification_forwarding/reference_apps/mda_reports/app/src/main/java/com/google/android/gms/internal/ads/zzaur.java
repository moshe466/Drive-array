package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;

/* loaded from: classes.dex */
public abstract class zzaur extends zzgb implements zzauo {
    public zzaur() {
        super("com.google.android.gms.ads.internal.signals.ISignalGenerator");
    }

    @Override // com.google.android.gms.internal.ads.zzgb
    protected final boolean a(int i, Parcel parcel, Parcel parcel2, int i2) {
        zzaun zzaupVar;
        if (i != 1) {
            return false;
        }
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
        zzauu zzauuVar = (zzauu) zzge.zza(parcel, zzauu.CREATOR);
        IBinder readStrongBinder = parcel.readStrongBinder();
        if (readStrongBinder == null) {
            zzaupVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.signals.ISignalCallback");
            zzaupVar = queryLocalInterface instanceof zzaun ? (zzaun) queryLocalInterface : new zzaup(readStrongBinder);
        }
        zza(asInterface, zzauuVar, zzaupVar);
        parcel2.writeNoException();
        return true;
    }
}
