package com.google.android.gms.internal.p001authapiphone;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.common.api.internal.IStatusCallback;

/* loaded from: classes.dex */
public final class zzh extends zza implements IInterface {
    public zzh(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.auth.api.phone.internal.ISmsRetrieverApiService");
    }

    public final void zzc(zze zzeVar) {
        Parcel zza = zza();
        zzc.zzc(zza, zzeVar);
        zzb(4, zza);
    }

    public final void zzd(String str, zzg zzgVar) {
        Parcel zza = zza();
        zza.writeString(str);
        zzc.zzc(zza, zzgVar);
        zzb(5, zza);
    }

    public final void zze(IStatusCallback iStatusCallback) {
        Parcel zza = zza();
        zzc.zzc(zza, iStatusCallback);
        zzb(3, zza);
    }

    public final void zzf(IStatusCallback iStatusCallback) {
        Parcel zza = zza();
        zzc.zzc(zza, iStatusCallback);
        zzb(6, zza);
    }

    public final void zzg(zzj zzjVar) {
        Parcel zza = zza();
        zzc.zzc(zza, zzjVar);
        zzb(1, zza);
    }

    public final void zzh(String str, zzj zzjVar) {
        Parcel zza = zza();
        zza.writeString(str);
        zzc.zzc(zza, zzjVar);
        zzb(2, zza);
    }
}
