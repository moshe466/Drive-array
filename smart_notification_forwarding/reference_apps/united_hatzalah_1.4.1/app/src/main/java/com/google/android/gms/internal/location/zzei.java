package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

@Deprecated
/* loaded from: classes.dex */
public final class zzei extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzei> CREATOR = new zzej();
    private final int zza;
    private final zzeg zzb;
    private final com.google.android.gms.location.zzz zzc;
    private final com.google.android.gms.location.zzw zzd;
    private final PendingIntent zze;
    private final zzr zzf;
    private final String zzg;

    public zzei(int i, zzeg zzegVar, IBinder iBinder, IBinder iBinder2, PendingIntent pendingIntent, IBinder iBinder3, String str) {
        com.google.android.gms.location.zzz zzzVar;
        com.google.android.gms.location.zzw zzwVar;
        this.zza = i;
        this.zzb = zzegVar;
        zzr zzrVar = null;
        if (iBinder != null) {
            zzzVar = com.google.android.gms.location.zzy.zzb(iBinder);
        } else {
            zzzVar = null;
        }
        this.zzc = zzzVar;
        this.zze = pendingIntent;
        if (iBinder2 != null) {
            zzwVar = com.google.android.gms.location.zzv.zzb(iBinder2);
        } else {
            zzwVar = null;
        }
        this.zzd = zzwVar;
        if (iBinder3 != null) {
            IInterface queryLocalInterface = iBinder3.queryLocalInterface("com.google.android.gms.location.internal.IFusedLocationProviderCallback");
            if (queryLocalInterface instanceof zzr) {
                zzrVar = (zzr) queryLocalInterface;
            } else {
                zzrVar = new zzp(iBinder3);
            }
        }
        this.zzf = zzrVar;
        this.zzg = str;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        IBinder asBinder;
        IBinder asBinder2;
        int i3 = this.zza;
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, i3);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzb, i, false);
        com.google.android.gms.location.zzz zzzVar = this.zzc;
        IBinder iBinder = null;
        if (zzzVar == null) {
            asBinder = null;
        } else {
            asBinder = zzzVar.asBinder();
        }
        SafeParcelWriter.writeIBinder(parcel, 3, asBinder, false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zze, i, false);
        com.google.android.gms.location.zzw zzwVar = this.zzd;
        if (zzwVar == null) {
            asBinder2 = null;
        } else {
            asBinder2 = zzwVar.asBinder();
        }
        SafeParcelWriter.writeIBinder(parcel, 5, asBinder2, false);
        zzr zzrVar = this.zzf;
        if (zzrVar != null) {
            iBinder = zzrVar.asBinder();
        }
        SafeParcelWriter.writeIBinder(parcel, 6, iBinder, false);
        SafeParcelWriter.writeString(parcel, 8, this.zzg, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
