package com.google.android.gms.internal.location;

import android.os.Parcel;

/* loaded from: classes.dex */
public abstract class zzq extends zzb implements zzr {
    public zzq() {
        super("com.google.android.gms.location.internal.IFusedLocationProviderCallback");
    }

    @Override // com.google.android.gms.internal.location.zzb
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i3) {
        if (i != 1) {
            if (i != 2) {
                return false;
            }
            zze();
        } else {
            zzl zzlVar = (zzl) zzc.zza(parcel, zzl.CREATOR);
            zzc.zzd(parcel);
            zzd(zzlVar);
        }
        return true;
    }
}
