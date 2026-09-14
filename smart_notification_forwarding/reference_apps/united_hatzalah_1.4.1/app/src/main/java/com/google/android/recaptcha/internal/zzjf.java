package com.google.android.recaptcha.internal;

/* loaded from: classes.dex */
public final class zzjf {
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

    public static void zzc(boolean z3, String str, char c4) {
        if (z3) {
        } else {
            throw new IllegalArgumentException(zzji.zza(str, Character.valueOf(c4)));
        }
    }

    public static void zzd(int i, int i3, int i4) {
        String zzf;
        if (i >= 0 && i3 >= i && i3 <= i4) {
            return;
        }
        if (i >= 0 && i <= i4) {
            if (i3 >= 0 && i3 <= i4) {
                zzf = zzji.zza("end index (%s) must not be less than start index (%s)", Integer.valueOf(i3), Integer.valueOf(i));
            } else {
                zzf = zzf(i3, i4, "end index");
            }
        } else {
            zzf = zzf(i, i4, "start index");
        }
        throw new IndexOutOfBoundsException(zzf);
    }

    public static void zze(boolean z3, Object obj) {
        if (z3) {
        } else {
            throw new IllegalStateException((String) obj);
        }
    }

    private static String zzf(int i, int i3, String str) {
        if (i < 0) {
            return zzji.zza("%s (%s) must not be negative", str, Integer.valueOf(i));
        }
        return zzji.zza("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i), Integer.valueOf(i3));
    }
}
