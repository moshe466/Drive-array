package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public final class zzof {
    public static boolean zzbh(String str) {
        return "audio".equals(zzbj(str));
    }

    public static boolean zzbi(String str) {
        return "video".equals(zzbj(str));
    }

    private static String zzbj(String str) {
        if (str == null) {
            return null;
        }
        int indexOf = str.indexOf(47);
        if (indexOf != -1) {
            return str.substring(0, indexOf);
        }
        String valueOf = String.valueOf(str);
        throw new IllegalArgumentException(valueOf.length() != 0 ? "Invalid mime type: ".concat(valueOf) : new String("Invalid mime type: "));
    }
}
