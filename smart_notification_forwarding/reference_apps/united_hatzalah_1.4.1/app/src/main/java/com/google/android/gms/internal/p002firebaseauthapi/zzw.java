package com.google.android.gms.internal.p002firebaseauthapi;

import e0.a;

/* loaded from: classes.dex */
public final class zzw {
    public static int zza(int i, int i3) {
        String zza;
        if (i >= 0 && i < i3) {
            return i;
        }
        if (i < 0) {
            zza = zzae.zza("%s (%s) must not be negative", "index", Integer.valueOf(i));
        } else if (i3 >= 0) {
            zza = zzae.zza("%s (%s) must be less than size (%s)", "index", Integer.valueOf(i), Integer.valueOf(i3));
        } else {
            throw new IllegalArgumentException(a.c(i3, "negative size: "));
        }
        throw new IndexOutOfBoundsException(zza);
    }

    public static int zzb(int i, int i3) {
        if (i < 0 || i > i3) {
            throw new IndexOutOfBoundsException(zzb(i, i3, "index"));
        }
        return i;
    }

    private static String zzb(int i, int i3, String str) {
        if (i < 0) {
            return zzae.zza("%s (%s) must not be negative", str, Integer.valueOf(i));
        }
        if (i3 >= 0) {
            return zzae.zza("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i), Integer.valueOf(i3));
        }
        throw new IllegalArgumentException(a.c(i3, "negative size: "));
    }

    public static int zza(int i, int i3, String str) {
        if (i < 0 || i > i3) {
            throw new IndexOutOfBoundsException(zzb(i, i3, str));
        }
        return i;
    }

    public static <T> T zza(T t3) {
        t3.getClass();
        return t3;
    }

    public static void zza(boolean z3, Object obj) {
        if (!z3) {
            throw new IllegalArgumentException(zzr.zza(obj));
        }
    }

    public static void zza(int i, int i3, int i4) {
        String zzb;
        if (i < 0 || i3 < i || i3 > i4) {
            if (i < 0 || i > i4) {
                zzb = zzb(i, i4, "start index");
            } else if (i3 >= 0 && i3 <= i4) {
                zzb = zzae.zza("end index (%s) must not be less than start index (%s)", Integer.valueOf(i3), Integer.valueOf(i));
            } else {
                zzb = zzb(i3, i4, "end index");
            }
            throw new IndexOutOfBoundsException(zzb);
        }
    }
}
