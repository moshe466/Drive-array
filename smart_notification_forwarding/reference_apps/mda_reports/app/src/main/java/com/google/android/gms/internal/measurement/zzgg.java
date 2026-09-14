package com.google.android.gms.internal.measurement;

/* loaded from: classes.dex */
public final class zzgg<K, V> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static <K, V> int a(zzgf<K, V> zzgfVar, K k, V v) {
        return zzew.a(zzgfVar.zza, 1, k) + zzew.a(zzgfVar.zzc, 2, v);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <K, V> void a(zzen zzenVar, zzgf<K, V> zzgfVar, K k, V v) {
        zzew.a(zzenVar, zzgfVar.zza, 1, k);
        zzew.a(zzenVar, zzgfVar.zzc, 2, v);
    }
}
