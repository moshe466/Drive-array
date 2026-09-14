package t2;

import F0.AbstractC0008a;
import java.util.Arrays;
import java.util.Iterator;
import java.util.RandomAccess;

/* loaded from: classes.dex */
public final class w extends AbstractC0701c implements RandomAccess {

    /* renamed from: a, reason: collision with root package name */
    public final Object[] f6484a;

    /* renamed from: b, reason: collision with root package name */
    public final int f6485b;

    /* renamed from: c, reason: collision with root package name */
    public int f6486c;

    /* renamed from: d, reason: collision with root package name */
    public int f6487d;

    public w(Object[] objArr, int i) {
        this.f6484a = objArr;
        if (i >= 0) {
            if (i <= objArr.length) {
                this.f6485b = objArr.length;
                this.f6487d = i;
                return;
            } else {
                StringBuilder w3 = AbstractC0008a.w(i, "ring buffer filled size: ", " cannot be larger than the buffer size: ");
                w3.append(objArr.length);
                throw new IllegalArgumentException(w3.toString().toString());
            }
        }
        throw new IllegalArgumentException(e0.a.c(i, "ring buffer filled size should not be negative but it is ").toString());
    }

    @Override // t2.AbstractC0701c
    public final int g() {
        return this.f6487d;
    }

    @Override // java.util.List
    public final Object get(int i) {
        int g3 = g();
        if (i >= 0 && i < g3) {
            return this.f6484a[(this.f6486c + i) % this.f6485b];
        }
        throw new IndexOutOfBoundsException(AbstractC0008a.k("index: ", i, g3, ", size: "));
    }

    public final void h(int i) {
        if (i >= 0) {
            if (i <= this.f6487d) {
                if (i > 0) {
                    int i3 = this.f6486c;
                    int i4 = this.f6485b;
                    int i5 = (i3 + i) % i4;
                    Object[] objArr = this.f6484a;
                    if (i3 > i5) {
                        AbstractC0705g.I(objArr, i3, i4);
                        AbstractC0705g.I(objArr, 0, i5);
                    } else {
                        AbstractC0705g.I(objArr, i3, i5);
                    }
                    this.f6486c = i5;
                    this.f6487d -= i;
                    return;
                }
                return;
            }
            StringBuilder w3 = AbstractC0008a.w(i, "n shouldn't be greater than the buffer size: n = ", ", size = ");
            w3.append(this.f6487d);
            throw new IllegalArgumentException(w3.toString().toString());
        }
        throw new IllegalArgumentException(e0.a.c(i, "n shouldn't be negative but it is ").toString());
    }

    @Override // t2.AbstractC0701c, java.util.List, java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        return new v(this);
    }

    @Override // t2.AbstractC0701c, java.util.List, java.util.Collection
    public final Object[] toArray() {
        return toArray(new Object[g()]);
    }

    @Override // t2.AbstractC0701c, java.util.List, java.util.Collection
    public final Object[] toArray(Object[] array) {
        Object[] objArr;
        kotlin.jvm.internal.j.e(array, "array");
        int length = array.length;
        int i = this.f6487d;
        if (length < i) {
            array = Arrays.copyOf(array, i);
            kotlin.jvm.internal.j.d(array, "copyOf(...)");
        }
        int i3 = this.f6487d;
        int i4 = this.f6486c;
        int i5 = 0;
        int i6 = 0;
        while (true) {
            objArr = this.f6484a;
            if (i6 >= i3 || i4 >= this.f6485b) {
                break;
            }
            array[i6] = objArr[i4];
            i6++;
            i4++;
        }
        while (i6 < i3) {
            array[i6] = objArr[i5];
            i6++;
            i5++;
        }
        if (i3 < array.length) {
            array[i3] = null;
        }
        return array;
    }
}
