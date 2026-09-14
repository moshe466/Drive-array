package com.google.android.gms.internal.auth;

/* loaded from: classes.dex */
final class zzgc {
    private static final zzgb zza;
    private static final zzgb zzb;

    static {
        zzgb zzgbVar = null;
        try {
            zzgbVar = (zzgb) Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
        }
        zza = zzgbVar;
        zzb = new zzgb();
    }

    public static zzgb zza() {
        return zza;
    }

    public static zzgb zzb() {
        return zzb;
    }
}
