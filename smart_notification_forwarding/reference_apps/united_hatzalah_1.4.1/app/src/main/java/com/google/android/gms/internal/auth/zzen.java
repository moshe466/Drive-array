package com.google.android.gms.internal.auth;

/* loaded from: classes.dex */
final class zzen {
    private static final zzel zza = new zzem();
    private static final zzel zzb;

    static {
        zzel zzelVar = null;
        try {
            zzelVar = (zzel) Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
        }
        zzb = zzelVar;
    }

    public static zzel zza() {
        zzel zzelVar = zzb;
        if (zzelVar != null) {
            return zzelVar;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }

    public static zzel zzb() {
        return zza;
    }
}
