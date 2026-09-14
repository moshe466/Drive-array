package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
final class zzdsz {
    private static final zzdsx zzhou = zzbbf();
    private static final zzdsx zzhov = new zzdta();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzdsx a() {
        return zzhou;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzdsx b() {
        return zzhov;
    }

    private static zzdsx zzbbf() {
        try {
            return (zzdsx) Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
