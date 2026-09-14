package com.google.android.gms.internal.ads;

import android.os.Parcel;

/* loaded from: classes.dex */
public abstract class zzahf extends zzgb implements zzahg {
    public zzahf() {
        super("com.google.android.gms.ads.internal.instream.client.IInstreamAdCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzgb
    protected final boolean a(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i == 1) {
            zzrv();
        } else {
            if (i != 2) {
                return false;
            }
            zzcn(parcel.readInt());
        }
        parcel2.writeNoException();
        return true;
    }
}
