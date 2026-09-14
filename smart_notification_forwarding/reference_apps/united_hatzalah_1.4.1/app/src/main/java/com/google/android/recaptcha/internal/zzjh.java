package com.google.android.recaptcha.internal;

import F0.AbstractC0008a;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import org.apache.tika.utils.StringUtils;

/* loaded from: classes.dex */
public final class zzjh {
    private boolean zza;
    private long zzb;
    private long zzc;

    public static zzjh zzb() {
        zzjh zzjhVar = new zzjh();
        zzjhVar.zze();
        return zzjhVar;
    }

    public static zzjh zzc() {
        return new zzjh();
    }

    private final long zzg() {
        if (this.zza) {
            return (System.nanoTime() - this.zzc) + this.zzb;
        }
        return this.zzb;
    }

    public final String toString() {
        String str;
        long zzg = zzg();
        TimeUnit timeUnit = TimeUnit.DAYS;
        TimeUnit timeUnit2 = TimeUnit.NANOSECONDS;
        if (timeUnit.convert(zzg, timeUnit2) <= 0) {
            timeUnit = TimeUnit.HOURS;
            if (timeUnit.convert(zzg, timeUnit2) <= 0) {
                timeUnit = TimeUnit.MINUTES;
                if (timeUnit.convert(zzg, timeUnit2) <= 0) {
                    timeUnit = TimeUnit.SECONDS;
                    if (timeUnit.convert(zzg, timeUnit2) <= 0) {
                        timeUnit = TimeUnit.MILLISECONDS;
                        if (timeUnit.convert(zzg, timeUnit2) <= 0) {
                            timeUnit = TimeUnit.MICROSECONDS;
                            if (timeUnit.convert(zzg, timeUnit2) <= 0) {
                                timeUnit = timeUnit2;
                            }
                        }
                    }
                }
            }
        }
        String format = String.format(Locale.ROOT, "%.4g", Double.valueOf(zzg / timeUnit2.convert(1L, timeUnit)));
        switch (zzjg.zza[timeUnit.ordinal()]) {
            case 1:
                str = "ns";
                break;
            case 2:
                str = "μs";
                break;
            case 3:
                str = "ms";
                break;
            case 4:
                str = "s";
                break;
            case 5:
                str = "min";
                break;
            case 6:
                str = "h";
                break;
            case 7:
                str = "d";
                break;
            default:
                throw new AssertionError();
        }
        return AbstractC0008a.o(format, StringUtils.SPACE, str);
    }

    public final long zza(TimeUnit timeUnit) {
        return timeUnit.convert(zzg(), TimeUnit.NANOSECONDS);
    }

    public final zzjh zzd() {
        this.zzb = 0L;
        this.zza = false;
        return this;
    }

    public final zzjh zze() {
        zzjf.zze(!this.zza, "This stopwatch is already running.");
        this.zza = true;
        this.zzc = System.nanoTime();
        return this;
    }

    public final zzjh zzf() {
        long nanoTime = System.nanoTime();
        zzjf.zze(this.zza, "This stopwatch is already stopped.");
        this.zza = false;
        this.zzb = (nanoTime - this.zzc) + this.zzb;
        return this;
    }
}
