package com.google.android.gms.internal.ads;

import android.os.Parcel;

/* loaded from: classes.dex */
public abstract class zzana extends zzgb implements zzamx {
    public zzana() {
        super("com.google.android.gms.ads.internal.mediation.client.rtb.IInterstitialCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzgb
    protected final boolean a(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i == 2) {
            zztb();
        } else {
            if (i != 3) {
                return false;
            }
            zzdl(parcel.readString());
        }
        parcel2.writeNoException();
        return true;
    }
}
