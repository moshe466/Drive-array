package com.google.android.gms.internal.ads;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

/* loaded from: classes.dex */
public final class zzas {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(long j) {
        return zzq().format(new Date(j));
    }

    public static zzd zzb(zzo zzoVar) {
        long j;
        long j2;
        boolean z;
        long j3;
        long j4;
        long currentTimeMillis = System.currentTimeMillis();
        Map<String, String> map = zzoVar.zzab;
        String str = map.get("Date");
        long zzf = str != null ? zzf(str) : 0L;
        String str2 = map.get("Cache-Control");
        int i = 0;
        if (str2 != null) {
            String[] split = str2.split(",", 0);
            j = 0;
            int i2 = 0;
            j2 = 0;
            while (i < split.length) {
                String trim = split[i].trim();
                if (trim.equals("no-cache") || trim.equals("no-store")) {
                    return null;
                }
                if (trim.startsWith("max-age=")) {
                    try {
                        j = Long.parseLong(trim.substring(8));
                    } catch (Exception unused) {
                    }
                } else if (trim.startsWith("stale-while-revalidate=")) {
                    j2 = Long.parseLong(trim.substring(23));
                } else if (trim.equals("must-revalidate") || trim.equals("proxy-revalidate")) {
                    i2 = 1;
                }
                i++;
            }
            i = i2;
            z = true;
        } else {
            j = 0;
            j2 = 0;
            z = false;
        }
        String str3 = map.get("Expires");
        long zzf2 = str3 != null ? zzf(str3) : 0L;
        String str4 = map.get("Last-Modified");
        long zzf3 = str4 != null ? zzf(str4) : 0L;
        String str5 = map.get("ETag");
        if (z) {
            j3 = currentTimeMillis + (j * 1000);
            if (i == 0) {
                Long.signum(j2);
                j4 = (j2 * 1000) + j3;
            }
            j4 = j3;
        } else if (zzf <= 0 || zzf2 < zzf) {
            j3 = 0;
            j4 = j3;
        } else {
            j4 = (zzf2 - zzf) + currentTimeMillis;
            j3 = j4;
        }
        zzd zzdVar = new zzd();
        zzdVar.data = zzoVar.data;
        zzdVar.zzg = str5;
        zzdVar.zzk = j3;
        zzdVar.zzj = j4;
        zzdVar.zzh = zzf;
        zzdVar.zzi = zzf3;
        zzdVar.zzl = map;
        zzdVar.zzm = zzoVar.allHeaders;
        return zzdVar;
    }

    private static long zzf(String str) {
        try {
            return zzq().parse(str).getTime();
        } catch (ParseException e) {
            zzag.zza(e, "Unable to parse dateStr: %s, falling back to 0", str);
            return 0L;
        }
    }

    private static SimpleDateFormat zzq() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz", Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        return simpleDateFormat;
    }
}
