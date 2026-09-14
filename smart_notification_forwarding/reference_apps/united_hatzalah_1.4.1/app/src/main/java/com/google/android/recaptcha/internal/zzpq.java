package com.google.android.recaptcha.internal;

import sun.misc.Unsafe;

/* loaded from: classes.dex */
final class zzpq extends zzpr {
    public zzpq(Unsafe unsafe) {
        super(unsafe);
    }

    @Override // com.google.android.recaptcha.internal.zzpr
    public final double zza(Object obj, long j2) {
        return Double.longBitsToDouble(this.zza.getLong(obj, j2));
    }

    @Override // com.google.android.recaptcha.internal.zzpr
    public final float zzb(Object obj, long j2) {
        return Float.intBitsToFloat(this.zza.getInt(obj, j2));
    }

    @Override // com.google.android.recaptcha.internal.zzpr
    public final void zzc(Object obj, long j2, boolean z3) {
        if (zzps.zzb) {
            zzps.zzD(obj, j2, r3 ? (byte) 1 : (byte) 0);
        } else {
            zzps.zzE(obj, j2, r3 ? (byte) 1 : (byte) 0);
        }
    }

    @Override // com.google.android.recaptcha.internal.zzpr
    public final void zzd(Object obj, long j2, byte b4) {
        if (zzps.zzb) {
            zzps.zzD(obj, j2, b4);
        } else {
            zzps.zzE(obj, j2, b4);
        }
    }

    @Override // com.google.android.recaptcha.internal.zzpr
    public final void zze(Object obj, long j2, double d2) {
        this.zza.putLong(obj, j2, Double.doubleToLongBits(d2));
    }

    @Override // com.google.android.recaptcha.internal.zzpr
    public final void zzf(Object obj, long j2, float f4) {
        this.zza.putInt(obj, j2, Float.floatToIntBits(f4));
    }

    @Override // com.google.android.recaptcha.internal.zzpr
    public final boolean zzg(Object obj, long j2) {
        if (zzps.zzb) {
            return zzps.zzt(obj, j2);
        }
        return zzps.zzu(obj, j2);
    }
}
