package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
final class zzdqd {
    private static final Class<?> zzhho = zzhe("libcore.io.Memory");
    private static final boolean zzhhp;

    static {
        zzhhp = zzhe("org.robolectric.Robolectric") != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a() {
        return (zzhho == null || zzhhp) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Class<?> b() {
        return zzhho;
    }

    private static <T> Class<T> zzhe(String str) {
        try {
            return (Class<T>) Class.forName(str);
        } catch (Throwable unused) {
            return null;
        }
    }
}
