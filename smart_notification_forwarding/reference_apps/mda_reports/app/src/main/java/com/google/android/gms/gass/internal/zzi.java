package com.google.android.gms.gass.internal;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.internal.ads.zzgc;
import com.google.android.gms.internal.ads.zzge;

/* loaded from: classes.dex */
public final class zzi extends zzgc implements zzg {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzi(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.gass.internal.IGassService");
    }

    @Override // com.google.android.gms.gass.internal.zzg
    public final zze zza(zzc zzcVar) {
        Parcel c = c();
        zzge.zza(c, zzcVar);
        Parcel a = a(1, c);
        zze zzeVar = (zze) zzge.zza(a, zze.CREATOR);
        a.recycle();
        return zzeVar;
    }

    @Override // com.google.android.gms.gass.internal.zzg
    public final zzo zza(zzm zzmVar) {
        Parcel c = c();
        zzge.zza(c, zzmVar);
        Parcel a = a(3, c);
        zzo zzoVar = (zzo) zzge.zza(a, zzo.CREATOR);
        a.recycle();
        return zzoVar;
    }

    @Override // com.google.android.gms.gass.internal.zzg
    public final void zza(zzb zzbVar) {
        Parcel c = c();
        zzge.zza(c, zzbVar);
        b(2, c);
    }
}
