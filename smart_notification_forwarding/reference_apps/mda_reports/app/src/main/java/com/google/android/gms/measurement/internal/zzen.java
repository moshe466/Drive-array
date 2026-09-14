package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import java.util.Collection;

/* loaded from: classes.dex */
public abstract class zzen extends com.google.android.gms.internal.measurement.zzc implements zzeo {
    public zzen() {
        super("com.google.android.gms.measurement.internal.IMeasurementService");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:1:0x0000. Please report as an issue. */
    @Override // com.google.android.gms.internal.measurement.zzc
    protected final boolean a(int i, Parcel parcel, Parcel parcel2, int i2) {
        Collection zza;
        switch (i) {
            case 1:
                zza((zzan) com.google.android.gms.internal.measurement.zzb.zza(parcel, zzan.CREATOR), (zzm) com.google.android.gms.internal.measurement.zzb.zza(parcel, zzm.CREATOR));
                parcel2.writeNoException();
                return true;
            case 2:
                zza((zzkl) com.google.android.gms.internal.measurement.zzb.zza(parcel, zzkl.CREATOR), (zzm) com.google.android.gms.internal.measurement.zzb.zza(parcel, zzm.CREATOR));
                parcel2.writeNoException();
                return true;
            case 3:
            case 8:
            default:
                return false;
            case 4:
                zza((zzm) com.google.android.gms.internal.measurement.zzb.zza(parcel, zzm.CREATOR));
                parcel2.writeNoException();
                return true;
            case 5:
                zza((zzan) com.google.android.gms.internal.measurement.zzb.zza(parcel, zzan.CREATOR), parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 6:
                zzb((zzm) com.google.android.gms.internal.measurement.zzb.zza(parcel, zzm.CREATOR));
                parcel2.writeNoException();
                return true;
            case 7:
                zza = zza((zzm) com.google.android.gms.internal.measurement.zzb.zza(parcel, zzm.CREATOR), com.google.android.gms.internal.measurement.zzb.zza(parcel));
                parcel2.writeNoException();
                parcel2.writeTypedList(zza);
                return true;
            case 9:
                byte[] zza2 = zza((zzan) com.google.android.gms.internal.measurement.zzb.zza(parcel, zzan.CREATOR), parcel.readString());
                parcel2.writeNoException();
                parcel2.writeByteArray(zza2);
                return true;
            case 10:
                zza(parcel.readLong(), parcel.readString(), parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 11:
                String zzc = zzc((zzm) com.google.android.gms.internal.measurement.zzb.zza(parcel, zzm.CREATOR));
                parcel2.writeNoException();
                parcel2.writeString(zzc);
                return true;
            case 12:
                zza((zzv) com.google.android.gms.internal.measurement.zzb.zza(parcel, zzv.CREATOR), (zzm) com.google.android.gms.internal.measurement.zzb.zza(parcel, zzm.CREATOR));
                parcel2.writeNoException();
                return true;
            case 13:
                zza((zzv) com.google.android.gms.internal.measurement.zzb.zza(parcel, zzv.CREATOR));
                parcel2.writeNoException();
                return true;
            case 14:
                zza = zza(parcel.readString(), parcel.readString(), com.google.android.gms.internal.measurement.zzb.zza(parcel), (zzm) com.google.android.gms.internal.measurement.zzb.zza(parcel, zzm.CREATOR));
                parcel2.writeNoException();
                parcel2.writeTypedList(zza);
                return true;
            case 15:
                zza = zza(parcel.readString(), parcel.readString(), parcel.readString(), com.google.android.gms.internal.measurement.zzb.zza(parcel));
                parcel2.writeNoException();
                parcel2.writeTypedList(zza);
                return true;
            case 16:
                zza = zza(parcel.readString(), parcel.readString(), (zzm) com.google.android.gms.internal.measurement.zzb.zza(parcel, zzm.CREATOR));
                parcel2.writeNoException();
                parcel2.writeTypedList(zza);
                return true;
            case 17:
                zza = zza(parcel.readString(), parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                parcel2.writeTypedList(zza);
                return true;
            case 18:
                zzd((zzm) com.google.android.gms.internal.measurement.zzb.zza(parcel, zzm.CREATOR));
                parcel2.writeNoException();
                return true;
        }
    }
}
