package com.google.android.gms.common.config;

import android.os.Binder;
import android.os.StrictMode;

/* loaded from: classes.dex */
public abstract class GservicesValue<T> {
    private static final Object zzc = new Object();
    protected final String zza;
    protected final Object zzb;
    private Object zzd = null;

    public GservicesValue(String str, Object obj) {
        this.zza = str;
        this.zzb = obj;
    }

    public static boolean isInitialized() {
        synchronized (zzc) {
        }
        return false;
    }

    public static GservicesValue<Float> value(String str, Float f4) {
        return new zzd(str, f4);
    }

    public final T get() {
        T t3;
        T t4 = (T) this.zzd;
        if (t4 != null) {
            return t4;
        }
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        Object obj = zzc;
        synchronized (obj) {
        }
        synchronized (obj) {
            try {
            } finally {
                StrictMode.setThreadPolicy(allowThreadDiskReads);
            }
        }
        try {
            t3 = (T) zza(this.zza);
        } catch (SecurityException unused) {
            long clearCallingIdentity = Binder.clearCallingIdentity();
            try {
                t3 = (T) zza(this.zza);
            } finally {
                Binder.restoreCallingIdentity(clearCallingIdentity);
            }
        }
        return t3;
    }

    @Deprecated
    public final T getBinderSafe() {
        return get();
    }

    public void override(T t3) {
        this.zzd = t3;
        Object obj = zzc;
        synchronized (obj) {
            synchronized (obj) {
            }
        }
    }

    public void resetOverride() {
        this.zzd = null;
    }

    public abstract Object zza(String str);

    public static GservicesValue<Integer> value(String str, Integer num) {
        return new zzc(str, num);
    }

    public static GservicesValue<Long> value(String str, Long l3) {
        return new zzb(str, l3);
    }

    public static GservicesValue<String> value(String str, String str2) {
        return new zze(str, str2);
    }

    public static GservicesValue<Boolean> value(String str, boolean z3) {
        return new zza(str, Boolean.valueOf(z3));
    }
}
