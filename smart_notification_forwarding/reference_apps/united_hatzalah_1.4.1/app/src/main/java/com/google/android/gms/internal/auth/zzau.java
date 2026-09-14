package com.google.android.gms.internal.auth;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes.dex */
public final class zzau extends zza implements IInterface {
    public zzau(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.auth.api.accounttransfer.internal.IAccountTransferService");
    }

    public final void zzd(zzat zzatVar, zzaq zzaqVar) {
        Parcel zza = zza();
        zzc.zze(zza, zzatVar);
        zzc.zzd(zza, zzaqVar);
        zzc(7, zza);
    }

    public final void zze(zzat zzatVar, zzbb zzbbVar) {
        Parcel zza = zza();
        zzc.zze(zza, zzatVar);
        zzc.zzd(zza, zzbbVar);
        zzc(8, zza);
    }

    public final void zzf(zzat zzatVar, zzav zzavVar) {
        Parcel zza = zza();
        zzc.zze(zza, zzatVar);
        zzc.zzd(zza, zzavVar);
        zzc(9, zza);
    }

    public final void zzg(zzat zzatVar, zzax zzaxVar) {
        Parcel zza = zza();
        zzc.zze(zza, zzatVar);
        zzc.zzd(zza, zzaxVar);
        zzc(6, zza);
    }

    public final void zzh(zzat zzatVar, zzaz zzazVar) {
        Parcel zza = zza();
        zzc.zze(zza, zzatVar);
        zzc.zzd(zza, zzazVar);
        zzc(5, zza);
    }
}
