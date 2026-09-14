package com.google.android.gms.location;

import E.a;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import com.google.android.gms.internal.location.zzeo;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final class zzak {
    public static final /* synthetic */ int zza = 0;
    private static final DecimalFormat zzb;
    private static final DecimalFormat zzc;
    private static final StringBuilder zzd;

    static {
        Locale locale = Locale.ROOT;
        zzb = new DecimalFormat(".000000", DecimalFormatSymbols.getInstance(locale));
        DecimalFormat decimalFormat = new DecimalFormat(".##", DecimalFormatSymbols.getInstance(locale));
        zzc = decimalFormat;
        decimalFormat.setRoundingMode(RoundingMode.DOWN);
        zzd = new StringBuilder();
    }

    public static StringBuilder zza(Location location, StringBuilder sb) {
        boolean isFromMockProvider;
        String str;
        boolean z3;
        float f4;
        boolean z4;
        float f5;
        sb.ensureCapacity(100);
        String str2 = null;
        if (location == null) {
            sb.append((String) null);
            return sb;
        }
        sb.append("{");
        sb.append(location.getProvider());
        sb.append(", ");
        int i = Build.VERSION.SDK_INT;
        if (i >= 31) {
            isFromMockProvider = a.a(location);
        } else {
            isFromMockProvider = location.isFromMockProvider();
        }
        if (isFromMockProvider) {
            sb.append("mock, ");
        }
        DecimalFormat decimalFormat = zzb;
        sb.append(decimalFormat.format(location.getLatitude()));
        sb.append(",");
        sb.append(decimalFormat.format(location.getLongitude()));
        if (location.hasAccuracy()) {
            sb.append("±");
            sb.append(zzc.format(location.getAccuracy()));
            sb.append("m");
        }
        boolean z5 = false;
        float f6 = 0.0f;
        if (location.hasAltitude()) {
            sb.append(", alt=");
            DecimalFormat decimalFormat2 = zzc;
            sb.append(decimalFormat2.format(location.getAltitude()));
            if (i >= 26) {
                z4 = B.a.j(location);
            } else {
                Bundle extras = location.getExtras();
                if (extras != null && extras.containsKey(FusedLocationProviderClient.KEY_VERTICAL_ACCURACY)) {
                    z4 = true;
                } else {
                    z4 = false;
                }
            }
            if (z4) {
                sb.append("±");
                if (i >= 26) {
                    f5 = B.a.g(location);
                } else {
                    Bundle extras2 = location.getExtras();
                    if (extras2 == null) {
                        f5 = 0.0f;
                    } else {
                        f5 = extras2.getFloat(FusedLocationProviderClient.KEY_VERTICAL_ACCURACY, 0.0f);
                    }
                }
                sb.append(decimalFormat2.format(f5));
            }
            sb.append("m");
        }
        if (location.hasSpeed()) {
            sb.append(", spd=");
            DecimalFormat decimalFormat3 = zzc;
            sb.append(decimalFormat3.format(location.getSpeed()));
            if (i >= 26) {
                z3 = B.a.i(location);
            } else {
                Bundle extras3 = location.getExtras();
                if (extras3 != null && extras3.containsKey("speedAccuracy")) {
                    z3 = true;
                } else {
                    z3 = false;
                }
            }
            if (z3) {
                sb.append("±");
                if (i >= 26) {
                    f4 = B.a.f(location);
                } else {
                    Bundle extras4 = location.getExtras();
                    if (extras4 == null) {
                        f4 = 0.0f;
                    } else {
                        f4 = extras4.getFloat("speedAccuracy", 0.0f);
                    }
                }
                sb.append(decimalFormat3.format(f4));
            }
            sb.append("m/s");
        }
        if (location.hasBearing()) {
            sb.append(", brg=");
            DecimalFormat decimalFormat4 = zzc;
            sb.append(decimalFormat4.format(location.getBearing()));
            if (i >= 26) {
                z5 = B.a.h(location);
            } else {
                Bundle extras5 = location.getExtras();
                if (extras5 != null && extras5.containsKey("bearingAccuracy")) {
                    z5 = true;
                }
            }
            if (z5) {
                sb.append("±");
                if (i >= 26) {
                    f6 = B.a.c(location);
                } else {
                    Bundle extras6 = location.getExtras();
                    if (extras6 != null) {
                        f6 = extras6.getFloat("bearingAccuracy", 0.0f);
                    }
                }
                sb.append(decimalFormat4.format(f6));
            }
            sb.append("°");
        }
        Bundle extras7 = location.getExtras();
        if (extras7 != null) {
            str = extras7.getString("floorLabel");
        } else {
            str = null;
        }
        if (str != null) {
            sb.append(", fl=");
            sb.append(str);
        }
        Bundle extras8 = location.getExtras();
        if (extras8 != null) {
            str2 = extras8.getString("levelId");
        }
        if (str2 != null) {
            sb.append(", lv=");
            sb.append(str2);
        }
        long currentTimeMillis = System.currentTimeMillis() - SystemClock.elapsedRealtime();
        sb.append(", ert=");
        sb.append(zzeo.zza(TimeUnit.NANOSECONDS.toMillis(location.getElapsedRealtimeNanos()) + currentTimeMillis));
        sb.append('}');
        return sb;
    }
}
