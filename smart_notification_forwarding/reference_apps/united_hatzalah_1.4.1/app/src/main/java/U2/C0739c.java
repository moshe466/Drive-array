package u2;

import F0.AbstractC0008a;
import com.google.android.gms.common.api.Api;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import kotlin.jvm.internal.j;
import p3.h;
import t2.AbstractC0702d;
import t2.AbstractC0705g;

/* renamed from: u2.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0739c extends AbstractC0702d implements RandomAccess, Serializable {

    /* renamed from: d, reason: collision with root package name */
    public static final C0739c f6609d;

    /* renamed from: a, reason: collision with root package name */
    public Object[] f6610a;

    /* renamed from: b, reason: collision with root package name */
    public int f6611b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f6612c;

    static {
        C0739c c0739c = new C0739c(0);
        c0739c.f6612c = true;
        f6609d = c0739c;
    }

    public C0739c(int i) {
        if (i >= 0) {
            this.f6610a = new Object[i];
            return;
        }
        throw new IllegalArgumentException("capacity must be non-negative.");
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        l();
        int i = this.f6611b;
        ((AbstractList) this).modCount++;
        m(i, 1);
        this.f6610a[i] = obj;
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection elements) {
        j.e(elements, "elements");
        l();
        int size = elements.size();
        j(this.f6611b, elements, size);
        return size > 0;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        l();
        o(0, this.f6611b);
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (obj != this) {
            if (obj instanceof List) {
                List list = (List) obj;
                Object[] objArr = this.f6610a;
                int i = this.f6611b;
                if (i == list.size()) {
                    for (int i3 = 0; i3 < i; i3++) {
                        if (j.a(objArr[i3], list.get(i3))) {
                        }
                    }
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    @Override // t2.AbstractC0702d
    public final int g() {
        return this.f6611b;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i) {
        int i3 = this.f6611b;
        if (i >= 0 && i < i3) {
            return this.f6610a[i];
        }
        throw new IndexOutOfBoundsException(AbstractC0008a.k("index: ", i, i3, ", size: "));
    }

    @Override // t2.AbstractC0702d
    public final Object h(int i) {
        l();
        int i3 = this.f6611b;
        if (i >= 0 && i < i3) {
            return n(i);
        }
        throw new IndexOutOfBoundsException(AbstractC0008a.k("index: ", i, i3, ", size: "));
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i;
        Object[] objArr = this.f6610a;
        int i3 = this.f6611b;
        int i4 = 1;
        for (int i5 = 0; i5 < i3; i5++) {
            Object obj = objArr[i5];
            int i6 = i4 * 31;
            if (obj != null) {
                i = obj.hashCode();
            } else {
                i = 0;
            }
            i4 = i6 + i;
        }
        return i4;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        for (int i = 0; i < this.f6611b; i++) {
            if (j.a(this.f6610a[i], obj)) {
                return i;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean isEmpty() {
        if (this.f6611b == 0) {
            return true;
        }
        return false;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator iterator() {
        return listIterator(0);
    }

    public final void j(int i, Collection collection, int i3) {
        ((AbstractList) this).modCount++;
        m(i, i3);
        Iterator it = collection.iterator();
        for (int i4 = 0; i4 < i3; i4++) {
            this.f6610a[i + i4] = it.next();
        }
    }

    public final void k(int i, Object obj) {
        ((AbstractList) this).modCount++;
        m(i, 1);
        this.f6610a[i] = obj;
    }

    public final void l() {
        if (!this.f6612c) {
        } else {
            throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public final int lastIndexOf(Object obj) {
        for (int i = this.f6611b - 1; i >= 0; i--) {
            if (j.a(this.f6610a[i], obj)) {
                return i;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator listIterator() {
        return listIterator(0);
    }

    public final void m(int i, int i3) {
        int i4 = this.f6611b + i3;
        if (i4 >= 0) {
            Object[] objArr = this.f6610a;
            if (i4 > objArr.length) {
                int length = objArr.length;
                int i5 = length + (length >> 1);
                if (i5 - i4 < 0) {
                    i5 = i4;
                }
                if (i5 - 2147483639 > 0) {
                    if (i4 > 2147483639) {
                        i5 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                    } else {
                        i5 = 2147483639;
                    }
                }
                Object[] copyOf = Arrays.copyOf(objArr, i5);
                j.d(copyOf, "copyOf(...)");
                this.f6610a = copyOf;
            }
            Object[] objArr2 = this.f6610a;
            AbstractC0705g.E(objArr2, i + i3, objArr2, i, this.f6611b);
            this.f6611b += i3;
            return;
        }
        throw new OutOfMemoryError();
    }

    public final Object n(int i) {
        ((AbstractList) this).modCount++;
        Object[] objArr = this.f6610a;
        Object obj = objArr[i];
        AbstractC0705g.E(objArr, i, objArr, i + 1, this.f6611b);
        Object[] objArr2 = this.f6610a;
        int i3 = this.f6611b - 1;
        j.e(objArr2, "<this>");
        objArr2[i3] = null;
        this.f6611b--;
        return obj;
    }

    public final void o(int i, int i3) {
        if (i3 > 0) {
            ((AbstractList) this).modCount++;
        }
        Object[] objArr = this.f6610a;
        AbstractC0705g.E(objArr, i, objArr, i + i3, this.f6611b);
        Object[] objArr2 = this.f6610a;
        int i4 = this.f6611b;
        j.e(objArr2, "<this>");
        for (int i5 = i4 - i3; i5 < i4; i5++) {
            objArr2[i5] = null;
        }
        this.f6611b -= i3;
    }

    public final int p(int i, int i3, Collection collection, boolean z3) {
        int i4 = 0;
        int i5 = 0;
        while (i4 < i3) {
            int i6 = i + i4;
            if (collection.contains(this.f6610a[i6]) == z3) {
                Object[] objArr = this.f6610a;
                i4++;
                objArr[i5 + i] = objArr[i6];
                i5++;
            } else {
                i4++;
            }
        }
        int i7 = i3 - i5;
        Object[] objArr2 = this.f6610a;
        AbstractC0705g.E(objArr2, i + i5, objArr2, i3 + i, this.f6611b);
        Object[] objArr3 = this.f6610a;
        int i8 = this.f6611b;
        j.e(objArr3, "<this>");
        for (int i9 = i8 - i7; i9 < i8; i9++) {
            objArr3[i9] = null;
        }
        if (i7 > 0) {
            ((AbstractList) this).modCount++;
        }
        this.f6611b -= i7;
        return i7;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        l();
        int indexOf = indexOf(obj);
        if (indexOf >= 0) {
            h(indexOf);
        }
        if (indexOf >= 0) {
            return true;
        }
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean removeAll(Collection elements) {
        j.e(elements, "elements");
        l();
        if (p(0, this.f6611b, elements, false) <= 0) {
            return false;
        }
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean retainAll(Collection elements) {
        j.e(elements, "elements");
        l();
        if (p(0, this.f6611b, elements, true) <= 0) {
            return false;
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i, Object obj) {
        l();
        int i3 = this.f6611b;
        if (i >= 0 && i < i3) {
            Object[] objArr = this.f6610a;
            Object obj2 = objArr[i];
            objArr[i] = obj;
            return obj2;
        }
        throw new IndexOutOfBoundsException(AbstractC0008a.k("index: ", i, i3, ", size: "));
    }

    @Override // java.util.AbstractList, java.util.List
    public final List subList(int i, int i3) {
        h.f(i, i3, this.f6611b);
        return new C0738b(this.f6610a, i, i3 - i, null, this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final Object[] toArray(Object[] array) {
        j.e(array, "array");
        int length = array.length;
        int i = this.f6611b;
        if (length < i) {
            Object[] copyOfRange = Arrays.copyOfRange(this.f6610a, 0, i, array.getClass());
            j.d(copyOfRange, "copyOfRange(...)");
            return copyOfRange;
        }
        AbstractC0705g.E(this.f6610a, 0, array, 0, i);
        int i3 = this.f6611b;
        if (i3 < array.length) {
            array[i3] = null;
        }
        return array;
    }

    @Override // java.util.AbstractCollection
    public final String toString() {
        return T.b.b(this.f6610a, 0, this.f6611b, this);
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator listIterator(int i) {
        int i3 = this.f6611b;
        if (i >= 0 && i <= i3) {
            return new C0737a(this, i);
        }
        throw new IndexOutOfBoundsException(AbstractC0008a.k("index: ", i, i3, ", size: "));
    }

    @Override // java.util.AbstractList, java.util.List
    public final boolean addAll(int i, Collection elements) {
        j.e(elements, "elements");
        l();
        int i3 = this.f6611b;
        if (i >= 0 && i <= i3) {
            int size = elements.size();
            j(i, elements, size);
            return size > 0;
        }
        throw new IndexOutOfBoundsException(AbstractC0008a.k("index: ", i, i3, ", size: "));
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i, Object obj) {
        l();
        int i3 = this.f6611b;
        if (i >= 0 && i <= i3) {
            ((AbstractList) this).modCount++;
            m(i, 1);
            this.f6610a[i] = obj;
            return;
        }
        throw new IndexOutOfBoundsException(AbstractC0008a.k("index: ", i, i3, ", size: "));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final Object[] toArray() {
        return AbstractC0705g.H(this.f6610a, 0, this.f6611b);
    }
}
