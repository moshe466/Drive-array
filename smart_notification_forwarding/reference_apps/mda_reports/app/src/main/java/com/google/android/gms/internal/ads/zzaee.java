package com.google.android.gms.internal.ads;

import android.os.Parcel;

/* loaded from: classes.dex */
public abstract class zzaee extends zzgb implements zzaeb {
    public zzaee() {
        super("com.google.android.gms.ads.internal.formats.client.IUnconfirmedClickListener");
    }

    @Override // com.google.android.gms.internal.ads.zzgb
    protected final boolean a(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i == 1) {
            onUnconfirmedClickReceived(parcel.readString());
        } else {
            if (i != 2) {
                return false;
            }
            onUnconfirmedClickCancelled();
        }
        parcel2.writeNoException();
        return true;
    }
}
