package com.google.android.gms.internal.auth;

import sun.misc.Unsafe;

/* loaded from: classes.dex */
final class zzhf extends zzhh {
    public zzhf(Unsafe unsafe) {
        super(unsafe);
    }

    @Override // com.google.android.gms.internal.auth.zzhh
    public final double zza(Object obj, long j2) {
        return Double.longBitsToDouble(zzj(obj, j2));
    }

    @Override // com.google.android.gms.internal.auth.zzhh
    public final float zzb(Object obj, long j2) {
        return Float.intBitsToFloat(zzi(obj, j2));
    }

    @Override // com.google.android.gms.internal.auth.zzhh
    public final void zzc(Object obj, long j2, boolean z3) {
        if (zzhi.zza) {
            zzhi.zzi(obj, j2, z3);
        } else {
            zzhi.zzj(obj, j2, z3);
        }
    }

    @Override // com.google.android.gms.internal.auth.zzhh
    public final void zzd(Object obj, long j2, double d2) {
        zzn(obj, j2, Double.doubleToLongBits(d2));
    }

    @Override // com.google.android.gms.internal.auth.zzhh
    public final void zze(Object obj, long j2, float f4) {
        zzm(obj, j2, Float.floatToIntBits(f4));
    }

    @Override // com.google.android.gms.internal.auth.zzhh
    public final boolean zzf(Object obj, long j2) {
        if (zzhi.zza) {
            return zzhi.zzq(obj, j2);
        }
        return zzhi.zzr(obj, j2);
    }
}
