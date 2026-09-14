package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
final class zzdrj {
    private static final zzdri<?> zzhjm = new zzdrk();
    private static final zzdri<?> zzhjn = zzazj();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzdri<?> a() {
        return zzhjm;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzdri<?> b() {
        zzdri<?> zzdriVar = zzhjn;
        if (zzdriVar != null) {
            return zzdriVar;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }

    private static zzdri<?> zzazj() {
        try {
            return (zzdri) Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
