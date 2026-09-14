package androidx.datastore.preferences.protobuf;

import F0.AbstractC0008a;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.RandomAccess;

/* loaded from: classes.dex */
public final class P extends AbstractC0235b implements RandomAccess {

    /* renamed from: d, reason: collision with root package name */
    public static final P f3123d = new P(new Object[0], 0, false);

    /* renamed from: b, reason: collision with root package name */
    public Object[] f3124b;

    /* renamed from: c, reason: collision with root package name */
    public int f3125c;

    public P(Object[] objArr, int i, boolean z3) {
        this.f3154a = z3;
        this.f3124b = objArr;
        this.f3125c = i;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        d();
        int i = this.f3125c;
        Object[] objArr = this.f3124b;
        if (i == objArr.length) {
            this.f3124b = Arrays.copyOf(objArr, ((i * 3) / 2) + 1);
        }
        Object[] objArr2 = this.f3124b;
        int i3 = this.f3125c;
        this.f3125c = i3 + 1;
        objArr2[i3] = obj;
        ((AbstractList) this).modCount++;
        return true;
    }

    public final void g(int i) {
        if (i >= 0 && i < this.f3125c) {
            return;
        }
        StringBuilder w3 = AbstractC0008a.w(i, "Index:", ", Size:");
        w3.append(this.f3125c);
        throw new IndexOutOfBoundsException(w3.toString());
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i) {
        g(i);
        return this.f3124b[i];
    }

    public final P h(int i) {
        if (i >= this.f3125c) {
            return new P(Arrays.copyOf(this.f3124b, i), this.f3125c, true);
        }
        throw new IllegalArgumentException();
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0235b, java.util.AbstractList, java.util.List
    public final Object remove(int i) {
        d();
        g(i);
        Object[] objArr = this.f3124b;
        Object obj = objArr[i];
        if (i < this.f3125c - 1) {
            System.arraycopy(objArr, i + 1, objArr, i, (r2 - i) - 1);
        }
        this.f3125c--;
        ((AbstractList) this).modCount++;
        return obj;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i, Object obj) {
        d();
        g(i);
        Object[] objArr = this.f3124b;
        Object obj2 = objArr[i];
        objArr[i] = obj;
        ((AbstractList) this).modCount++;
        return obj2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f3125c;
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i, Object obj) {
        int i3;
        d();
        if (i >= 0 && i <= (i3 = this.f3125c)) {
            Object[] objArr = this.f3124b;
            if (i3 < objArr.length) {
                System.arraycopy(objArr, i, objArr, i + 1, i3 - i);
            } else {
                Object[] objArr2 = new Object[AbstractC0008a.e(i3, 3, 2, 1)];
                System.arraycopy(objArr, 0, objArr2, 0, i);
                System.arraycopy(this.f3124b, i, objArr2, i + 1, this.f3125c - i);
                this.f3124b = objArr2;
            }
            this.f3124b[i] = obj;
            this.f3125c++;
            ((AbstractList) this).modCount++;
            return;
        }
        StringBuilder w3 = AbstractC0008a.w(i, "Index:", ", Size:");
        w3.append(this.f3125c);
        throw new IndexOutOfBoundsException(w3.toString());
    }
}
