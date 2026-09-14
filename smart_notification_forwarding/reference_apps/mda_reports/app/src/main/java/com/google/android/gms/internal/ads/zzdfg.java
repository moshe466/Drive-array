package com.google.android.gms.internal.ads;

import java.util.Map;

/* loaded from: classes.dex */
final class zzdfg<K, V> extends zzdfb<Map.Entry<K, V>> {
    private final transient int size;
    private final transient zzdey<K, V> zzguv;
    private final transient Object[] zzguw;
    private final transient int zzgux = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdfg(zzdey<K, V> zzdeyVar, Object[] objArr, int i, int i2) {
        this.zzguv = zzdeyVar;
        this.zzguw = objArr;
        this.size = i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzdet
    public final int a(Object[] objArr, int i) {
        return zzarb().a(objArr, i);
    }

    @Override // com.google.android.gms.internal.ads.zzdet, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            if (value != null && value.equals(this.zzguv.get(key))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzdfb
    final zzdeu<Map.Entry<K, V>> e() {
        return new zzdfj(this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.size;
    }

    @Override // com.google.android.gms.internal.ads.zzdfb, com.google.android.gms.internal.ads.zzdet, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* renamed from: zzaqx */
    public final zzdfp<Map.Entry<K, V>> iterator() {
        return (zzdfp) zzarb().iterator();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzdet
    public final boolean zzarc() {
        return true;
    }
}
