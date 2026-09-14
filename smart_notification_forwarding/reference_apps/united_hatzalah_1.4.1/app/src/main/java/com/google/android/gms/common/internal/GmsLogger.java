package com.google.android.gms.common.internal;

import android.util.Log;

/* loaded from: classes.dex */
public final class GmsLogger {
    private final String zza;
    private final String zzb;

    public GmsLogger(String str) {
        this(str, null);
    }

    private final String zza(String str) {
        String str2 = this.zzb;
        if (str2 == null) {
            return str;
        }
        return str2.concat(str);
    }

    private final String zzb(String str, Object... objArr) {
        String str2 = this.zzb;
        String format = String.format(str, objArr);
        if (str2 == null) {
            return format;
        }
        return str2.concat(format);
    }

    public boolean canLog(int i) {
        return Log.isLoggable(this.zza, i);
    }

    public boolean canLogPii() {
        return false;
    }

    public void d(String str, String str2) {
        if (canLog(3)) {
            zza(str2);
        }
    }

    public void e(String str, String str2) {
        if (canLog(6)) {
            Log.e(str, zza(str2));
        }
    }

    public void efmt(String str, String str2, Object... objArr) {
        if (canLog(6)) {
            Log.e(str, zzb(str2, objArr));
        }
    }

    public void i(String str, String str2) {
        if (canLog(4)) {
            zza(str2);
        }
    }

    public void pii(String str, String str2) {
    }

    public void v(String str, String str2) {
        if (canLog(2)) {
            zza(str2);
        }
    }

    public void w(String str, String str2) {
        if (canLog(5)) {
            zza(str2);
        }
    }

    public void wfmt(String str, String str2, Object... objArr) {
        if (canLog(5)) {
            zzb(str2, objArr);
        }
    }

    public void wtf(String str, String str2, Throwable th) {
        if (canLog(7)) {
            Log.e(str, zza(str2), th);
            Log.wtf(str, zza(str2), th);
        }
    }

    public GmsLogger(String str, String str2) {
        Preconditions.checkNotNull(str, "log tag cannot be null");
        Preconditions.checkArgument(str.length() <= 23, "tag \"%s\" is longer than the %d character maximum", str, 23);
        this.zza = str;
        this.zzb = (str2 == null || str2.length() <= 0) ? null : str2;
    }

    public void pii(String str, String str2, Throwable th) {
    }

    public void d(String str, String str2, Throwable th) {
        if (canLog(3)) {
            zza(str2);
        }
    }

    public void e(String str, String str2, Throwable th) {
        if (canLog(6)) {
            Log.e(str, zza(str2), th);
        }
    }

    public void i(String str, String str2, Throwable th) {
        if (canLog(4)) {
            zza(str2);
        }
    }

    public void v(String str, String str2, Throwable th) {
        if (canLog(2)) {
            zza(str2);
        }
    }

    public void w(String str, String str2, Throwable th) {
        if (canLog(5)) {
            zza(str2);
        }
    }
}
