package com.google.android.recaptcha.internal;

import java.math.BigInteger;

/* loaded from: classes.dex */
public final class zzhv {
    private static final zzhu zza;
    private final zzhu zzb;
    private long zzc;

    static {
        long pow = (long) Math.pow(2.0d, 32.0d);
        zza = new zzhu(11L, 20919936621L ^ pow, (long) Math.pow(2.0d, 48.0d));
    }

    public zzhv(long j2, long j3, zzhu zzhuVar) {
        this.zzb = zzhuVar;
        this.zzc = Math.abs(j2);
    }

    public final long zza() {
        zzhu zzhuVar = this.zzb;
        long longValue = (BigInteger.valueOf(zzhuVar.zzb()).multiply(BigInteger.valueOf(this.zzc)).mod(BigInteger.valueOf(zzhuVar.zza())).longValue() + 11) % this.zzb.zza();
        this.zzc = longValue;
        return longValue % 255;
    }
}
