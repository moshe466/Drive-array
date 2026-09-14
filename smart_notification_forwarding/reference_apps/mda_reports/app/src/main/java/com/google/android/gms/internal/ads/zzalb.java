package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes.dex */
public abstract class zzalb extends zzgb implements zzalc {
    public zzalb() {
        super("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
    }

    public static zzalc zzaa(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
        return queryLocalInterface instanceof zzalc ? (zzalc) queryLocalInterface : new zzale(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzgb
    protected final boolean a(int i, Parcel parcel, Parcel parcel2, int i2) {
        IInterface zzde;
        if (i == 1) {
            zzde = zzde(parcel.readString());
        } else {
            if (i == 2) {
                boolean zzdf = zzdf(parcel.readString());
                parcel2.writeNoException();
                zzge.writeBoolean(parcel2, zzdf);
                return true;
            }
            if (i != 3) {
                return false;
            }
            zzde = zzdi(parcel.readString());
        }
        parcel2.writeNoException();
        zzge.zza(parcel2, zzde);
        return true;
    }
}
