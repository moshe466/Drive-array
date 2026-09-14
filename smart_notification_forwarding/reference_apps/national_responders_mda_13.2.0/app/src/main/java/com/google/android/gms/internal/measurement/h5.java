package com.google.android.gms.internal.measurement;

import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class h5<E> extends t4<E> {

    /* renamed from: h, reason: collision with root package name */
    private final transient E f5370h;

    /* renamed from: i, reason: collision with root package name */
    private transient int f5371i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h5(E e10) {
        this.f5370h = (E) n3.b(e10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h5(E e10, int i10) {
        this.f5370h = e10;
        this.f5371i = i10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.k4
    public final int c(Object[] objArr, int i10) {
        objArr[i10] = this.f5370h;
        return i10 + 1;
    }

    @Override // com.google.android.gms.internal.measurement.k4, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        return this.f5370h.equals(obj);
    }

    @Override // com.google.android.gms.internal.measurement.k4
    /* renamed from: f */
    public final k5<E> iterator() {
        return new y4(this.f5370h);
    }

    @Override // com.google.android.gms.internal.measurement.t4, java.util.Collection, java.util.Set
    public final int hashCode() {
        int i10 = this.f5371i;
        if (i10 != 0) {
            return i10;
        }
        int hashCode = this.f5370h.hashCode();
        this.f5371i = hashCode;
        return hashCode;
    }

    @Override // com.google.android.gms.internal.measurement.t4, com.google.android.gms.internal.measurement.k4, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final /* synthetic */ Iterator iterator() {
        return iterator();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.k4
    public final boolean t() {
        return false;
    }

    @Override // java.util.AbstractCollection
    public final String toString() {
        String obj = this.f5370h.toString();
        StringBuilder sb2 = new StringBuilder(String.valueOf(obj).length() + 2);
        sb2.append('[');
        sb2.append(obj);
        sb2.append(']');
        return sb2.toString();
    }

    @Override // com.google.android.gms.internal.measurement.t4
    final boolean v() {
        return this.f5371i != 0;
    }

    @Override // com.google.android.gms.internal.measurement.t4
    final o4<E> w() {
        return o4.v(this.f5370h);
    }
}
