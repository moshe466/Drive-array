package com.google.android.gms.internal.auth;

/* loaded from: classes.dex */
final class zzer implements zzfu {
    private static final zzer zza = new zzer();

    private zzer() {
    }

    public static zzer zza() {
        return zza;
    }

    @Override // com.google.android.gms.internal.auth.zzfu
    public final zzft zzb(Class cls) {
        if (zzeu.class.isAssignableFrom(cls)) {
            try {
                return (zzft) zzeu.zza(cls.asSubclass(zzeu.class)).zzi(3, null, null);
            } catch (Exception e4) {
                throw new RuntimeException("Unable to get message info for ".concat(cls.getName()), e4);
            }
        }
        throw new IllegalArgumentException("Unsupported message type: ".concat(cls.getName()));
    }

    @Override // com.google.android.gms.internal.auth.zzfu
    public final boolean zzc(Class cls) {
        return zzeu.class.isAssignableFrom(cls);
    }
}
