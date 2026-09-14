package com.google.android.gms.internal.ads;

import android.os.Parcel;

/* loaded from: classes.dex */
public abstract class zzaum extends zzgb implements zzaun {
    public zzaum() {
        super("com.google.android.gms.ads.internal.signals.ISignalCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzgb
    protected final boolean a(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i == 1) {
            zzk(parcel.readString(), parcel.readString());
        } else {
            if (i != 2) {
                return false;
            }
            onError(parcel.readString());
        }
        parcel2.writeNoException();
        return true;
    }
}
