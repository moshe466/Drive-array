package com.google.android.gms.internal.measurement;

/* loaded from: classes.dex */
final class zzgj {
    private static final zzgh zza = zzc();
    private static final zzgh zzb = new zzgk();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzgh a() {
        return zza;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzgh b() {
        return zzb;
    }

    private static zzgh zzc() {
        try {
            return (zzgh) Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
