package com.google.android.gms.internal.location;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* loaded from: classes.dex */
public final class zzj extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzj> CREATOR = new zzk();
    final int zza;
    final zzh zzb;
    final com.google.android.gms.location.zzt zzc;
    final zzr zzd;

    public zzj(int i, zzh zzhVar, IBinder iBinder, IBinder iBinder2) {
        com.google.android.gms.location.zzt zzb;
        this.zza = i;
        this.zzb = zzhVar;
        zzr zzrVar = null;
        if (iBinder == null) {
            zzb = null;
        } else {
            zzb = com.google.android.gms.location.zzs.zzb(iBinder);
        }
        this.zzc = zzb;
        if (iBinder2 != null) {
            IInterface queryLocalInterface = iBinder2.queryLocalInterface("com.google.android.gms.location.internal.IFusedLocationProviderCallback");
            if (queryLocalInterface instanceof zzr) {
                zzrVar = (zzr) queryLocalInterface;
            } else {
                zzrVar = new zzp(iBinder2);
            }
        }
        this.zzd = zzrVar;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        IBinder asBinder;
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zza);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzb, i, false);
        com.google.android.gms.location.zzt zztVar = this.zzc;
        IBinder iBinder = null;
        if (zztVar == null) {
            asBinder = null;
        } else {
            asBinder = zztVar.asBinder();
        }
        SafeParcelWriter.writeIBinder(parcel, 3, asBinder, false);
        zzr zzrVar = this.zzd;
        if (zzrVar != null) {
            iBinder = zzrVar.asBinder();
        }
        SafeParcelWriter.writeIBinder(parcel, 4, iBinder, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
