package u2;

import F0.AbstractC0008a;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import kotlin.jvm.internal.j;
import p3.h;
import t2.AbstractC0702d;
import t2.AbstractC0705g;

/* renamed from: u2.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0738b extends AbstractC0702d implements RandomAccess, Serializable {

    /* renamed from: a, reason: collision with root package name */
    public Object[] f6604a;

    /* renamed from: b, reason: collision with root package name */
    public final int f6605b;

    /* renamed from: c, reason: collision with root package name */
    public int f6606c;

    /* renamed from: d, reason: collision with root package name */
    public final C0738b f6607d;

    /* renamed from: e, reason: collision with root package name */
    public final C0739c f6608e;

    public C0738b(Object[] backing, int i, int i3, C0738b c0738b, C0739c root) {
        int i4;
        j.e(backing, "backing");
        j.e(root, "root");
        this.f6604a = backing;
        this.f6605b = i;
        this.f6606c = i3;
        this.f6607d = c0738b;
        this.f6608e = root;
        i4 = ((AbstractList) root).modCount;
        ((AbstractList) this).modCount = i4;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        m();
        l();
        k(this.f6605b + this.f6606c, obj);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection elements) {
        j.e(elements, "elements");
        m();
        l();
        int size = elements.size();
        j(this.f6605b + this.f6606c, elements, size);
        return size > 0;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        m();
        l();
        o(this.f6605b, this.f6606c);
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        l();
        if (obj != this) {
            if (obj instanceof List) {
                List list = (List) obj;
                Object[] objArr = this.f6604a;
                int i = this.f6606c;
                if (i == list.size()) {
                    for (int i3 = 0; i3 < i; i3++) {
                        if (j.a(objArr[this.f6605b + i3], list.get(i3))) {
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
        l();
        return this.f6606c;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i) {
        l();
        int i3 = this.f6606c;
        if (i >= 0 && i < i3) {
            return this.f6604a[this.f6605b + i];
        }
        throw new IndexOutOfBoundsException(AbstractC0008a.k("index: ", i, i3, ", size: "));
    }

    @Override // t2.AbstractC0702d
    public final Object h(int i) {
        m();
        l();
        int i3 = this.f6606c;
        if (i >= 0 && i < i3) {
            return n(this.f6605b + i);
        }
        throw new IndexOutOfBoundsException(AbstractC0008a.k("index: ", i, i3, ", size: "));
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i;
        l();
        Object[] objArr = this.f6604a;
        int i3 = this.f6606c;
        int i4 = 1;
        for (int i5 = 0; i5 < i3; i5++) {
            Object obj = objArr[this.f6605b + i5];
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
        l();
        for (int i = 0; i < this.f6606c; i++) {
            if (j.a(this.f6604a[this.f6605b + i], obj)) {
                return i;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean isEmpty() {
        l();
        if (this.f6606c == 0) {
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
        C0739c c0739c = this.f6608e;
        C0738b c0738b = this.f6607d;
        if (c0738b != null) {
            c0738b.j(i, collection, i3);
        } else {
            C0739c c0739c2 = C0739c.f6609d;
            c0739c.j(i, collection, i3);
        }
        this.f6604a = c0739c.f6610a;
        this.f6606c += i3;
    }

    public final void k(int i, Object obj) {
        ((AbstractList) this).modCount++;
        C0739c c0739c = this.f6608e;
        C0738b c0738b = this.f6607d;
        if (c0738b != null) {
            c0738b.k(i, obj);
        } else {
            C0739c c0739c2 = C0739c.f6609d;
            c0739c.k(i, obj);
        }
        this.f6604a = c0739c.f6610a;
        this.f6606c++;
    }

    public final void l() {
        int i;
        i = ((AbstractList) this.f6608e).modCount;
        if (i == ((AbstractList) this).modCount) {
        } else {
            throw new ConcurrentModificationException();
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public final int lastIndexOf(Object obj) {
        l();
        for (int i = this.f6606c - 1; i >= 0; i--) {
            if (j.a(this.f6604a[this.f6605b + i], obj)) {
                return i;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator listIterator() {
        return listIterator(0);
    }

    public final void m() {
        if (!this.f6608e.f6612c) {
        } else {
            throw new UnsupportedOperationException();
        }
    }

    public final Object n(int i) {
        Object n4;
        ((AbstractList) this).modCount++;
        C0738b c0738b = this.f6607d;
        if (c0738b != null) {
            n4 = c0738b.n(i);
        } else {
            C0739c c0739c = C0739c.f6609d;
            n4 = this.f6608e.n(i);
        }
        this.f6606c--;
        return n4;
    }

    public final void o(int i, int i3) {
        if (i3 > 0) {
            ((AbstractList) this).modCount++;
        }
        C0738b c0738b = this.f6607d;
        if (c0738b != null) {
            c0738b.o(i, i3);
        } else {
            C0739c c0739c = C0739c.f6609d;
            this.f6608e.o(i, i3);
        }
        this.f6606c -= i3;
    }

    public final int p(int i, int i3, Collection collection, boolean z3) {
        int p;
        C0738b c0738b = this.f6607d;
        if (c0738b != null) {
            p = c0738b.p(i, i3, collection, z3);
        } else {
            C0739c c0739c = C0739c.f6609d;
            p = this.f6608e.p(i, i3, collection, z3);
        }
        if (p > 0) {
            ((AbstractList) this).modCount++;
        }
        this.f6606c -= p;
        return p;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        m();
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
        m();
        l();
        if (p(this.f6605b, this.f6606c, elements, false) <= 0) {
            return false;
        }
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean retainAll(Collection elements) {
        j.e(elements, "elements");
        m();
        l();
        if (p(this.f6605b, this.f6606c, elements, true) > 0) {
            return true;
        }
        return false;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i, Object obj) {
        m();
        l();
        int i3 = this.f6606c;
        if (i >= 0 && i < i3) {
            Object[] objArr = this.f6604a;
            int i4 = this.f6605b;
            Object obj2 = objArr[i4 + i];
            objArr[i4 + i] = obj;
            return obj2;
        }
        throw new IndexOutOfBoundsException(AbstractC0008a.k("index: ", i, i3, ", size: "));
    }

    @Override // java.util.AbstractList, java.util.List
    public final List subList(int i, int i3) {
        h.f(i, i3, this.f6606c);
        return new C0738b(this.f6604a, this.f6605b + i, i3 - i, this, this.f6608e);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final Object[] toArray(Object[] array) {
        j.e(array, "array");
        l();
        int length = array.length;
        int i = this.f6606c;
        int i3 = this.f6605b;
        if (length < i) {
            Object[] copyOfRange = Arrays.copyOfRange(this.f6604a, i3, i + i3, array.getClass());
            j.d(copyOfRange, "copyOfRange(...)");
            return copyOfRange;
        }
        AbstractC0705g.E(this.f6604a, 0, array, i3, i + i3);
        int i4 = this.f6606c;
        if (i4 < array.length) {
            array[i4] = null;
        }
        return array;
    }

    @Override // java.util.AbstractCollection
    public final String toString() {
        l();
        return T.b.b(this.f6604a, this.f6605b, this.f6606c, this);
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator listIterator(int i) {
        l();
        int i3 = this.f6606c;
        if (i >= 0 && i <= i3) {
            return new C0737a(this, i);
        }
        throw new IndexOutOfBoundsException(AbstractC0008a.k("index: ", i, i3, ", size: "));
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i, Object obj) {
        m();
        l();
        int i3 = this.f6606c;
        if (i >= 0 && i <= i3) {
            k(this.f6605b + i, obj);
            return;
        }
        throw new IndexOutOfBoundsException(AbstractC0008a.k("index: ", i, i3, ", size: "));
    }

    @Override // java.util.AbstractList, java.util.List
    public final boolean addAll(int i, Collection elements) {
        j.e(elements, "elements");
        m();
        l();
        int i3 = this.f6606c;
        if (i >= 0 && i <= i3) {
            int size = elements.size();
            j(this.f6605b + i, elements, size);
            return size > 0;
        }
        throw new IndexOutOfBoundsException(AbstractC0008a.k("index: ", i, i3, ", size: "));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final Object[] toArray() {
        l();
        Object[] objArr = this.f6604a;
        int i = this.f6606c;
        int i3 = this.f6605b;
        return AbstractC0705g.H(objArr, i3, i + i3);
    }
}
