package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
final class zzdto {
    private static final zzdtm zzhpo = zzbbl();
    private static final zzdtm zzhpp = new zzdtl();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzdtm a() {
        return zzhpo;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzdtm b() {
        return zzhpp;
    }

    private static zzdtm zzbbl() {
        try {
            return (zzdtm) Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
