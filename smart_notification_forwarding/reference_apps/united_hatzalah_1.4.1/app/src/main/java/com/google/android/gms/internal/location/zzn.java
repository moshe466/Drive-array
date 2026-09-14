package com.google.android.gms.internal.location;

import android.os.Parcel;
import com.google.android.gms.common.api.Status;

/* loaded from: classes.dex */
public abstract class zzn extends zzb implements zzo {
    public zzn() {
        super("com.google.android.gms.location.internal.IBooleanStatusCallback");
    }

    @Override // com.google.android.gms.internal.location.zzb
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i3) {
        boolean z3 = false;
        if (i != 1) {
            return false;
        }
        Status status = (Status) zzc.zza(parcel, Status.CREATOR);
        if (parcel.readInt() != 0) {
            z3 = true;
        }
        zzc.zzd(parcel);
        zzb(status, z3);
        return true;
    }
}
