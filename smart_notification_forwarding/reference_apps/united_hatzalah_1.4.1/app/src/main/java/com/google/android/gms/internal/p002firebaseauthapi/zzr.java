package com.google.android.gms.internal.p002firebaseauthapi;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzr {
    private static final zzs zza = new zzu();

    public static zzl zza(String str) {
        zzw.zza(str);
        return zza.zza(str);
    }

    public static String zzb(String str) {
        if (zzd(str)) {
            return null;
        }
        return str;
    }

    public static String zzc(String str) {
        if (str == null) {
            return "";
        }
        return str;
    }

    public static boolean zzd(String str) {
        if (str != null && !str.isEmpty()) {
            return false;
        }
        return true;
    }

    public static String zza(String str, Object... objArr) {
        return zzae.zza(str, objArr);
    }

    public static String zza(Object obj) {
        return String.valueOf(obj);
    }
}
