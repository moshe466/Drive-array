package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public final class zzdsw<K, V> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static <K, V> int a(zzdsv<K, V> zzdsvVar, K k, V v) {
        return zzdrm.a(zzdsvVar.zzhoq, 1, k) + zzdrm.a(zzdsvVar.zzhos, 2, v);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <K, V> void a(zzdrb zzdrbVar, zzdsv<K, V> zzdsvVar, K k, V v) {
        zzdrm.a(zzdrbVar, zzdsvVar.zzhoq, 1, k);
        zzdrm.a(zzdrbVar, zzdsvVar.zzhos, 2, v);
    }
}
