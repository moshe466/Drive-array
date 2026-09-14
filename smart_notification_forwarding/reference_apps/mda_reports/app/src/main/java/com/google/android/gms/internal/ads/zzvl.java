package com.google.android.gms.internal.ads;

import android.os.Parcel;

/* loaded from: classes.dex */
public abstract class zzvl extends zzgb implements zzvm {
    public zzvl() {
        super("com.google.android.gms.ads.internal.client.IAdLoader");
    }

    @Override // com.google.android.gms.internal.ads.zzgb
    protected final boolean a(int i, Parcel parcel, Parcel parcel2, int i2) {
        String mediationAdapterClassName;
        if (i != 1) {
            if (i == 2) {
                mediationAdapterClassName = getMediationAdapterClassName();
            } else {
                if (i == 3) {
                    boolean isLoading = isLoading();
                    parcel2.writeNoException();
                    zzge.writeBoolean(parcel2, isLoading);
                    return true;
                }
                if (i == 4) {
                    mediationAdapterClassName = zzka();
                } else {
                    if (i != 5) {
                        return false;
                    }
                    zza((zzug) zzge.zza(parcel, zzug.CREATOR), parcel.readInt());
                }
            }
            parcel2.writeNoException();
            parcel2.writeString(mediationAdapterClassName);
            return true;
        }
        zzb((zzug) zzge.zza(parcel, zzug.CREATOR));
        parcel2.writeNoException();
        return true;
    }
}
