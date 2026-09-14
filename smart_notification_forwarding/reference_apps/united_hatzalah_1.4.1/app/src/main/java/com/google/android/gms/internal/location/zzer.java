package com.google.android.gms.internal.location;

import F0.AbstractC0008a;

/* loaded from: classes.dex */
public final class zzer {
    public static void zza(boolean z3) {
        if (z3) {
        } else {
            throw new IllegalArgumentException();
        }
    }

    public static void zzb(boolean z3, Object obj) {
        if (z3) {
        } else {
            throw new IllegalArgumentException((String) obj);
        }
    }

    public static int zzc(int i, int i3, String str) {
        String zza;
        if (i >= 0 && i < i3) {
            return i;
        }
        if (i >= 0) {
            if (i3 < 0) {
                throw new IllegalArgumentException(AbstractC0008a.t(new StringBuilder(String.valueOf(i3).length() + 15), "negative size: ", i3));
            }
            zza = zzes.zza("%s (%s) must be less than size (%s)", "index", Integer.valueOf(i), Integer.valueOf(i3));
        } else {
            zza = zzes.zza("%s (%s) must not be negative", "index", Integer.valueOf(i));
        }
        throw new IndexOutOfBoundsException(zza);
    }

    public static int zzd(int i, int i3, String str) {
        if (i >= 0 && i <= i3) {
            return i;
        }
        throw new IndexOutOfBoundsException(zzf(i, i3, "index"));
    }

    public static void zze(int i, int i3, int i4) {
        String zzf;
        if (i >= 0 && i3 >= i && i3 <= i4) {
            return;
        }
        if (i >= 0 && i <= i4) {
            if (i3 >= 0 && i3 <= i4) {
                zzf = zzes.zza("end index (%s) must not be less than start index (%s)", Integer.valueOf(i3), Integer.valueOf(i));
            } else {
                zzf = zzf(i3, i4, "end index");
            }
        } else {
            zzf = zzf(i, i4, "start index");
        }
        throw new IndexOutOfBoundsException(zzf);
    }

    private static String zzf(int i, int i3, String str) {
        if (i < 0) {
            return zzes.zza("%s (%s) must not be negative", str, Integer.valueOf(i));
        }
        if (i3 >= 0) {
            return zzes.zza("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i), Integer.valueOf(i3));
        }
        throw new IllegalArgumentException(AbstractC0008a.t(new StringBuilder(String.valueOf(i3).length() + 15), "negative size: ", i3));
    }
}
