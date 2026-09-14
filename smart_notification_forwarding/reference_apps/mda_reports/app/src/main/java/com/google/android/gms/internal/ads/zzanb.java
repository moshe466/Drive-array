package com.google.android.gms.internal.ads;

import android.os.Parcel;

/* loaded from: classes.dex */
public abstract class zzanb extends zzgb implements zzanc {
    public zzanb() {
        super("com.google.android.gms.ads.internal.mediation.client.rtb.INativeCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzgb
    protected final boolean a(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i == 1) {
            zza(zzalu.zzac(parcel.readStrongBinder()));
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
