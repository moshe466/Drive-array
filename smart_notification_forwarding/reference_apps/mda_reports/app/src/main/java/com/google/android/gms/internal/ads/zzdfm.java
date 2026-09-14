package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzdfm<E> extends zzdfb<E> {
    private final transient E zzgve;
    private transient int zzgvf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdfm(E e) {
        this.zzgve = (E) zzdei.checkNotNull(e);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdfm(E e, int i) {
        this.zzgve = e;
        this.zzgvf = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzdet
    public final int a(Object[] objArr, int i) {
        objArr[i] = this.zzgve;
        return i + 1;
    }

    @Override // com.google.android.gms.internal.ads.zzdet, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        return this.zzgve.equals(obj);
    }

    @Override // com.google.android.gms.internal.ads.zzdfb
    final boolean d() {
        return this.zzgvf != 0;
    }

    @Override // com.google.android.gms.internal.ads.zzdfb
    final zzdeu<E> e() {
        return zzdeu.zzaf(this.zzgve);
    }

    @Override // com.google.android.gms.internal.ads.zzdfb, java.util.Collection, java.util.Set
    public final int hashCode() {
        int i = this.zzgvf;
        if (i != 0) {
            return i;
        }
        int hashCode = this.zzgve.hashCode();
        this.zzgvf = hashCode;
        return hashCode;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return 1;
    }

    @Override // java.util.AbstractCollection
    public final String toString() {
        String obj = this.zzgve.toString();
        StringBuilder sb = new StringBuilder(String.valueOf(obj).length() + 2);
        sb.append('[');
        sb.append(obj);
        sb.append(']');
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzdfb, com.google.android.gms.internal.ads.zzdet, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* renamed from: zzaqx */
    public final zzdfp<E> iterator() {
        return new zzdfd(this.zzgve);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzdet
    public final boolean zzarc() {
        return false;
    }
}
