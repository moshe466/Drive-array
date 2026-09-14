package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;

/* loaded from: classes.dex */
public abstract class zzaqh extends zzgb implements zzaqe {
    public zzaqh() {
        super("com.google.android.gms.ads.internal.request.INonagonStreamingResponseListener");
    }

    @Override // com.google.android.gms.internal.ads.zzgb
    protected final boolean a(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i == 1) {
            zzb((ParcelFileDescriptor) zzge.zza(parcel, ParcelFileDescriptor.CREATOR));
        } else {
            if (i != 2) {
                return false;
            }
            zza((zzaxc) zzge.zza(parcel, zzaxc.CREATOR));
        }
        parcel2.writeNoException();
        return true;
    }
}
