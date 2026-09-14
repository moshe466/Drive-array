package com.google.crypto.tink.shaded.protobuf;

import F0.AbstractC0008a;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.RandomAccess;

/* loaded from: classes.dex */
public final class Z extends AbstractC0330b implements RandomAccess {

    /* renamed from: d, reason: collision with root package name */
    public static final Z f4078d;

    /* renamed from: b, reason: collision with root package name */
    public Object[] f4079b;

    /* renamed from: c, reason: collision with root package name */
    public int f4080c;

    static {
        Z z3 = new Z(new Object[0], 0);
        f4078d = z3;
        z3.f4085a = false;
    }

    public Z(Object[] objArr, int i) {
        this.f4079b = objArr;
        this.f4080c = i;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.A
    public final A a(int i) {
        if (i >= this.f4080c) {
            return new Z(Arrays.copyOf(this.f4079b, i), this.f4080c);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0330b, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        d();
        int i = this.f4080c;
        Object[] objArr = this.f4079b;
        if (i == objArr.length) {
            this.f4079b = Arrays.copyOf(objArr, ((i * 3) / 2) + 1);
        }
        Object[] objArr2 = this.f4079b;
        int i3 = this.f4080c;
        this.f4080c = i3 + 1;
        objArr2[i3] = obj;
        ((AbstractList) this).modCount++;
        return true;
    }

    public final void g(int i) {
        if (i >= 0 && i < this.f4080c) {
            return;
        }
        StringBuilder w3 = AbstractC0008a.w(i, "Index:", ", Size:");
        w3.append(this.f4080c);
        throw new IndexOutOfBoundsException(w3.toString());
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i) {
        g(i);
        return this.f4079b[i];
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0330b, java.util.AbstractList, java.util.List
    public final Object remove(int i) {
        d();
        g(i);
        Object[] objArr = this.f4079b;
        Object obj = objArr[i];
        if (i < this.f4080c - 1) {
            System.arraycopy(objArr, i + 1, objArr, i, (r2 - i) - 1);
        }
        this.f4080c--;
        ((AbstractList) this).modCount++;
        return obj;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i, Object obj) {
        d();
        g(i);
        Object[] objArr = this.f4079b;
        Object obj2 = objArr[i];
        objArr[i] = obj;
        ((AbstractList) this).modCount++;
        return obj2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f4080c;
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i, Object obj) {
        int i3;
        d();
        if (i >= 0 && i <= (i3 = this.f4080c)) {
            Object[] objArr = this.f4079b;
            if (i3 < objArr.length) {
                System.arraycopy(objArr, i, objArr, i + 1, i3 - i);
            } else {
                Object[] objArr2 = new Object[AbstractC0008a.e(i3, 3, 2, 1)];
                System.arraycopy(objArr, 0, objArr2, 0, i);
                System.arraycopy(this.f4079b, i, objArr2, i + 1, this.f4080c - i);
                this.f4079b = objArr2;
            }
            this.f4079b[i] = obj;
            this.f4080c++;
            ((AbstractList) this).modCount++;
            return;
        }
        StringBuilder w3 = AbstractC0008a.w(i, "Index:", ", Size:");
        w3.append(this.f4080c);
        throw new IndexOutOfBoundsException(w3.toString());
    }
}
