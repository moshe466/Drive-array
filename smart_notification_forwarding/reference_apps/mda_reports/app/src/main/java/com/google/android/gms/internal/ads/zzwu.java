package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes.dex */
public abstract class zzwu extends zzgb implements zzwr {
    public zzwu() {
        super("com.google.android.gms.ads.internal.client.IMuteThisAdReason");
    }

    public static zzwr zzg(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IMuteThisAdReason");
        return queryLocalInterface instanceof zzwr ? (zzwr) queryLocalInterface : new zzwt(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzgb
    protected final boolean a(int i, Parcel parcel, Parcel parcel2, int i2) {
        String description;
        if (i == 1) {
            description = getDescription();
        } else {
            if (i != 2) {
                return false;
            }
            description = zzph();
        }
        parcel2.writeNoException();
        parcel2.writeString(description);
        return true;
    }
}
