package com.google.android.gms.internal.common;

import F0.AbstractC0008a;

/* loaded from: classes.dex */
public final class zzr {
    public static void zza(boolean z3) {
        if (z3) {
        } else {
            throw new IllegalStateException();
        }
    }

    public static int zzb(int i, int i3, String str) {
        String zza;
        if (i >= 0 && i < i3) {
            return i;
        }
        if (i >= 0) {
            if (i3 < 0) {
                throw new IllegalArgumentException(AbstractC0008a.t(new StringBuilder(String.valueOf(i3).length() + 15), "negative size: ", i3));
            }
            zza = zzx.zza("%s (%s) must be less than size (%s)", "index", Integer.valueOf(i), Integer.valueOf(i3));
        } else {
            zza = zzx.zza("%s (%s) must not be negative", "index", Integer.valueOf(i));
        }
        throw new IndexOutOfBoundsException(zza);
    }

    public static int zzc(int i, int i3, String str) {
        if (i >= 0 && i <= i3) {
            return i;
        }
        throw new IndexOutOfBoundsException(zze(i, i3, "index"));
    }

    public static void zzd(int i, int i3, int i4) {
        String zze;
        if (i >= 0 && i3 >= i && i3 <= i4) {
            return;
        }
        if (i >= 0 && i <= i4) {
            if (i3 >= 0 && i3 <= i4) {
                zze = zzx.zza("end index (%s) must not be less than start index (%s)", Integer.valueOf(i3), Integer.valueOf(i));
            } else {
                zze = zze(i3, i4, "end index");
            }
        } else {
            zze = zze(i, i4, "start index");
        }
        throw new IndexOutOfBoundsException(zze);
    }

    private static String zze(int i, int i3, String str) {
        if (i < 0) {
            return zzx.zza("%s (%s) must not be negative", str, Integer.valueOf(i));
        }
        if (i3 >= 0) {
            return zzx.zza("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i), Integer.valueOf(i3));
        }
        throw new IllegalArgumentException(AbstractC0008a.t(new StringBuilder(String.valueOf(i3).length() + 15), "negative size: ", i3));
    }
}
