package com.google.android.gms.internal.measurement;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.RandomAccess;

/* loaded from: classes.dex */
final class k9<E> extends x5<E> implements RandomAccess {

    /* renamed from: i, reason: collision with root package name */
    private static final k9<Object> f5430i;

    /* renamed from: g, reason: collision with root package name */
    private E[] f5431g;

    /* renamed from: h, reason: collision with root package name */
    private int f5432h;

    static {
        k9<Object> k9Var = new k9<>(new Object[0], 0);
        f5430i = k9Var;
        k9Var.n();
    }

    private k9(E[] eArr, int i10) {
        this.f5431g = eArr;
        this.f5432h = i10;
    }

    private final void f(int i10) {
        if (i10 < 0 || i10 >= this.f5432h) {
            throw new IndexOutOfBoundsException(g(i10));
        }
    }

    private final String g(int i10) {
        int i11 = this.f5432h;
        StringBuilder sb2 = new StringBuilder(35);
        sb2.append("Index:");
        sb2.append(i10);
        sb2.append(", Size:");
        sb2.append(i11);
        return sb2.toString();
    }

    public static <E> k9<E> j() {
        return (k9<E>) f5430i;
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i10, E e10) {
        int i11;
        c();
        if (i10 < 0 || i10 > (i11 = this.f5432h)) {
            throw new IndexOutOfBoundsException(g(i10));
        }
        E[] eArr = this.f5431g;
        if (i11 < eArr.length) {
            System.arraycopy(eArr, i10, eArr, i10 + 1, i11 - i10);
        } else {
            E[] eArr2 = (E[]) new Object[((i11 * 3) / 2) + 1];
            System.arraycopy(eArr, 0, eArr2, 0, i10);
            System.arraycopy(this.f5431g, i10, eArr2, i10 + 1, this.f5432h - i10);
            this.f5431g = eArr2;
        }
        this.f5431g[i10] = e10;
        this.f5432h++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.measurement.x5, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(E e10) {
        c();
        int i10 = this.f5432h;
        E[] eArr = this.f5431g;
        if (i10 == eArr.length) {
            this.f5431g = (E[]) Arrays.copyOf(eArr, ((i10 * 3) / 2) + 1);
        }
        E[] eArr2 = this.f5431g;
        int i11 = this.f5432h;
        this.f5432h = i11 + 1;
        eArr2[i11] = e10;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.u7
    public final /* synthetic */ u7 b(int i10) {
        if (i10 >= this.f5432h) {
            return new k9(Arrays.copyOf(this.f5431g, i10), this.f5432h);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.AbstractList, java.util.List
    public final E get(int i10) {
        f(i10);
        return this.f5431g[i10];
    }

    @Override // com.google.android.gms.internal.measurement.x5, java.util.AbstractList, java.util.List
    public final E remove(int i10) {
        c();
        f(i10);
        E[] eArr = this.f5431g;
        E e10 = eArr[i10];
        if (i10 < this.f5432h - 1) {
            System.arraycopy(eArr, i10 + 1, eArr, i10, (r2 - i10) - 1);
        }
        this.f5432h--;
        ((AbstractList) this).modCount++;
        return e10;
    }

    @Override // java.util.AbstractList, java.util.List
    public final E set(int i10, E e10) {
        c();
        f(i10);
        E[] eArr = this.f5431g;
        E e11 = eArr[i10];
        eArr[i10] = e10;
        ((AbstractList) this).modCount++;
        return e11;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f5432h;
    }
}
