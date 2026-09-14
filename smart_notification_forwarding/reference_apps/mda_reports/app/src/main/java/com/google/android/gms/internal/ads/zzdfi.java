package com.google.android.gms.internal.ads;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* loaded from: classes.dex */
final class zzdfi<K> extends zzdfb<K> {
    private final transient zzdeu<K> zzguj;
    private final transient zzdey<K, ?> zzguv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdfi(zzdey<K, ?> zzdeyVar, zzdeu<K> zzdeuVar) {
        this.zzguv = zzdeyVar;
        this.zzguj = zzdeuVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzdet
    public final int a(Object[] objArr, int i) {
        return zzarb().a(objArr, i);
    }

    @Override // com.google.android.gms.internal.ads.zzdet, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(@NullableDecl Object obj) {
        return this.zzguv.get(obj) != null;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.zzguv.size();
    }

    @Override // com.google.android.gms.internal.ads.zzdfb, com.google.android.gms.internal.ads.zzdet, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* renamed from: zzaqx */
    public final zzdfp<K> iterator() {
        return (zzdfp) zzarb().iterator();
    }

    @Override // com.google.android.gms.internal.ads.zzdfb, com.google.android.gms.internal.ads.zzdet
    public final zzdeu<K> zzarb() {
        return this.zzguj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzdet
    public final boolean zzarc() {
        return true;
    }
}
