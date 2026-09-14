package com.google.android.recaptcha.internal;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* loaded from: classes.dex */
public final class zzqb {
    private static final ThreadLocal zza;

    static {
        zzph zzi = zzpj.zzi();
        zzi.zzf(-62135596800L);
        zzi.zze(0);
        zzph zzi2 = zzpj.zzi();
        zzi2.zzf(253402300799L);
        zzi2.zze(999999999);
        zzph zzi3 = zzpj.zzi();
        zzi3.zzf(0L);
        zzi3.zze(0);
        zza = new zzqa();
        zzd("now");
        zzd("getEpochSecond");
        zzd("getNano");
    }

    public static zzpj zza(zzpj zzpjVar) {
        long zzg = zzpjVar.zzg();
        boolean zze = zze(zzg);
        int zzf = zzpjVar.zzf();
        if (zze && zzf >= 0 && zzf < 1000000000) {
            return zzpjVar;
        }
        throw new IllegalArgumentException("Timestamp is not valid. See proto definition for valid values. Seconds (" + zzg + ") must be in range [-62,135,596,800, +253,402,300,799]. Nanos (" + zzf + ") must be in range [0, +999,999,999].");
    }

    public static zzpj zzb(long j2) {
        long j3 = j2 / 1000;
        if (zze(j3)) {
            int i = (int) ((j2 % 1000) * 1000000);
            if (i <= -1000000000 || i >= 1000000000) {
                j3 = zzkk.zza(j3, i / 1000000000);
                i %= 1000000000;
            }
            if (i < 0) {
                i += 1000000000;
                j3 = zzkk.zzb(j3, 1L);
            }
            zzph zzi = zzpj.zzi();
            zzi.zzf(j3);
            zzi.zze(i);
            zzpj zzpjVar = (zzpj) zzi.zzk();
            zza(zzpjVar);
            return zzpjVar;
        }
        throw new IllegalArgumentException("Timestamp is not valid. Input seconds is too large. Seconds (" + j3 + ") must be in range [-62,135,596,800, +253,402,300,799]. ");
    }

    public static String zzc(zzpj zzpjVar) {
        String format;
        zza(zzpjVar);
        long zzg = zzpjVar.zzg();
        int zzf = zzpjVar.zzf();
        StringBuilder sb = new StringBuilder();
        sb.append(((SimpleDateFormat) zza.get()).format(new Date(zzg * 1000)));
        if (zzf != 0) {
            sb.append(".");
            if (zzf % 1000000 == 0) {
                format = String.format(Locale.ENGLISH, "%1$03d", Integer.valueOf(zzf / 1000000));
            } else if (zzf % 1000 == 0) {
                format = String.format(Locale.ENGLISH, "%1$06d", Integer.valueOf(zzf / 1000));
            } else {
                format = String.format(Locale.ENGLISH, "%1$09d", Integer.valueOf(zzf));
            }
            sb.append(format);
        }
        sb.append("Z");
        return sb.toString();
    }

    private static Method zzd(String str) {
        try {
            return Class.forName("java.time.Instant").getMethod(str, null);
        } catch (Exception unused) {
            return null;
        }
    }

    private static boolean zze(long j2) {
        return j2 >= -62135596800L && j2 <= 253402300799L;
    }
}
