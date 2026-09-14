package com.google.android.gms.internal.ads;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzdfk<E> extends zzdfb<E> {
    static final zzdfk<Object> a = new zzdfk<>(new Object[0], 0, null, 0, 0);
    private final transient int mask;
    private final transient int size;
    private final transient int zzafx;
    private final transient Object[] zzgvc;
    private final transient Object[] zzgvd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdfk(Object[] objArr, int i, Object[] objArr2, int i2, int i3) {
        this.zzgvc = objArr;
        this.zzgvd = objArr2;
        this.mask = i2;
        this.zzafx = i;
        this.size = i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzdet
    public final int a(Object[] objArr, int i) {
        System.arraycopy(this.zzgvc, 0, objArr, i, this.size);
        return i + this.size;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzdet
    public final Object[] a() {
        return this.zzgvc;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzdet
    public final int b() {
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzdet
    final int c() {
        return this.size;
    }

    @Override // com.google.android.gms.internal.ads.zzdet, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(@NullableDecl Object obj) {
        Object[] objArr = this.zzgvd;
        if (obj == null || objArr == null) {
            return false;
        }
        int a2 = zzdeq.a(obj == null ? 0 : obj.hashCode());
        while (true) {
            int i = a2 & this.mask;
            Object obj2 = objArr[i];
            if (obj2 == null) {
                return false;
            }
            if (obj2.equals(obj)) {
                return true;
            }
            a2 = i + 1;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdfb
    final boolean d() {
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzdfb
    final zzdeu<E> e() {
        return zzdeu.b(this.zzgvc, this.size);
    }

    @Override // com.google.android.gms.internal.ads.zzdfb, java.util.Collection, java.util.Set
    public final int hashCode() {
        return this.zzafx;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.size;
    }

    @Override // com.google.android.gms.internal.ads.zzdfb, com.google.android.gms.internal.ads.zzdet, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* renamed from: zzaqx */
    public final zzdfp<E> iterator() {
        return (zzdfp) zzarb().iterator();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzdet
    public final boolean zzarc() {
        return false;
    }
}
