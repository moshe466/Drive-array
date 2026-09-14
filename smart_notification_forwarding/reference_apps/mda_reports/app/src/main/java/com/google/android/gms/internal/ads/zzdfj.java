package com.google.android.gms.internal.ads;

import java.util.AbstractMap;
import java.util.Map;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* loaded from: classes.dex */
final class zzdfj<K, V> extends zzdeu<Map.Entry<K, V>> {
    private final /* synthetic */ zzdfg zzgva;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdfj(zzdfg zzdfgVar) {
        this.zzgva = zzdfgVar;
    }

    @Override // java.util.List
    public final /* synthetic */ Object get(int i) {
        int i2;
        Object[] objArr;
        Object[] objArr2;
        i2 = this.zzgva.size;
        zzdei.zzs(i, i2);
        objArr = this.zzgva.zzguw;
        int i3 = i * 2;
        zzdfg zzdfgVar = this.zzgva;
        Object obj = objArr[i3];
        objArr2 = zzdfgVar.zzguw;
        return new AbstractMap.SimpleImmutableEntry(obj, objArr2[i3 + 1]);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        int i;
        i = this.zzgva.size;
        return i;
    }

    @Override // com.google.android.gms.internal.ads.zzdet
    public final boolean zzarc() {
        return true;
    }
}
