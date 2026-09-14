package com.google.android.gms.internal.ads;

import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;

/* loaded from: classes.dex */
public abstract class zzamv extends zzgb implements zzamw {
    public zzamv() {
        super("com.google.android.gms.ads.internal.mediation.client.rtb.IBannerCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzgb
    protected final boolean a(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i == 1) {
            zzx(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
        } else {
            if (i != 2) {
                return false;
            }
            zzdl(parcel.readString());
        }
        parcel2.writeNoException();
        return true;
    }
}
