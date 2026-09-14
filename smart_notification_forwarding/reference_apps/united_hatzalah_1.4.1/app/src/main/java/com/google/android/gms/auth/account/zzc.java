package com.google.android.gms.auth.account;

import android.accounts.Account;
import android.os.IBinder;
import android.os.Parcel;

/* loaded from: classes.dex */
public final class zzc extends com.google.android.gms.internal.auth.zza implements zze {
    public zzc(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.auth.account.IWorkAccountService");
    }

    @Override // com.google.android.gms.auth.account.zze
    public final void zzd(zzb zzbVar, String str) {
        Parcel zza = zza();
        com.google.android.gms.internal.auth.zzc.zze(zza, zzbVar);
        zza.writeString(str);
        zzc(2, zza);
    }

    @Override // com.google.android.gms.auth.account.zze
    public final void zze(zzb zzbVar, Account account) {
        Parcel zza = zza();
        com.google.android.gms.internal.auth.zzc.zze(zza, zzbVar);
        com.google.android.gms.internal.auth.zzc.zzd(zza, account);
        zzc(3, zza);
    }

    @Override // com.google.android.gms.auth.account.zze
    public final void zzf(boolean z3) {
        Parcel zza = zza();
        com.google.android.gms.internal.auth.zzc.zzc(zza, z3);
        zzc(1, zza);
    }
}
