package t;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Set;
import t2.AbstractC0705g;
import t2.AbstractC0707i;
import u.AbstractC0717a;

/* renamed from: t.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0690f implements Collection, Set, G2.a {

    /* renamed from: a, reason: collision with root package name */
    public int[] f6355a = AbstractC0717a.f6499a;

    /* renamed from: b, reason: collision with root package name */
    public Object[] f6356b = AbstractC0717a.f6500b;

    /* renamed from: c, reason: collision with root package name */
    public int f6357c;

    public C0690f(int i) {
        if (i > 0) {
            AbstractC0692h.a(this, i);
        }
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean add(Object obj) {
        int i;
        int b4;
        int i3 = this.f6357c;
        if (obj == null) {
            b4 = AbstractC0692h.b(this, null, 0);
            i = 0;
        } else {
            int hashCode = obj.hashCode();
            i = hashCode;
            b4 = AbstractC0692h.b(this, obj, hashCode);
        }
        if (b4 >= 0) {
            return false;
        }
        int i4 = ~b4;
        int[] iArr = this.f6355a;
        if (i3 >= iArr.length) {
            int i5 = 8;
            if (i3 >= 8) {
                i5 = (i3 >> 1) + i3;
            } else if (i3 < 4) {
                i5 = 4;
            }
            Object[] objArr = this.f6356b;
            int[] iArr2 = new int[i5];
            this.f6355a = iArr2;
            this.f6356b = new Object[i5];
            if (i3 == this.f6357c) {
                if (iArr2.length != 0) {
                    AbstractC0705g.D(0, 0, iArr, iArr2, iArr.length);
                    AbstractC0705g.F(objArr, 0, this.f6356b, objArr.length, 6);
                }
            } else {
                throw new ConcurrentModificationException();
            }
        }
        if (i4 < i3) {
            int[] iArr3 = this.f6355a;
            int i6 = i4 + 1;
            AbstractC0705g.D(i6, i4, iArr3, iArr3, i3);
            Object[] objArr2 = this.f6356b;
            AbstractC0705g.E(objArr2, i6, objArr2, i4, i3);
        }
        int i7 = this.f6357c;
        if (i3 == i7) {
            int[] iArr4 = this.f6355a;
            if (i4 < iArr4.length) {
                iArr4[i4] = i;
                this.f6356b[i4] = obj;
                this.f6357c = i7 + 1;
                return true;
            }
        }
        throw new ConcurrentModificationException();
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean addAll(Collection elements) {
        kotlin.jvm.internal.j.e(elements, "elements");
        int size = elements.size() + this.f6357c;
        int i = this.f6357c;
        int[] iArr = this.f6355a;
        boolean z3 = false;
        if (iArr.length < size) {
            Object[] objArr = this.f6356b;
            int[] iArr2 = new int[size];
            this.f6355a = iArr2;
            this.f6356b = new Object[size];
            if (i > 0) {
                AbstractC0705g.D(0, 0, iArr, iArr2, i);
                AbstractC0705g.F(objArr, 0, this.f6356b, this.f6357c, 6);
            }
        }
        if (this.f6357c == i) {
            Iterator it = elements.iterator();
            while (it.hasNext()) {
                z3 |= add(it.next());
            }
            return z3;
        }
        throw new ConcurrentModificationException();
    }

    @Override // java.util.Collection, java.util.Set
    public final void clear() {
        if (this.f6357c != 0) {
            this.f6355a = AbstractC0717a.f6499a;
            this.f6356b = AbstractC0717a.f6500b;
            this.f6357c = 0;
        }
        if (this.f6357c == 0) {
        } else {
            throw new ConcurrentModificationException();
        }
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        int b4;
        if (obj == null) {
            b4 = AbstractC0692h.b(this, null, 0);
        } else {
            b4 = AbstractC0692h.b(this, obj, obj.hashCode());
        }
        if (b4 < 0) {
            return false;
        }
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean containsAll(Collection elements) {
        kotlin.jvm.internal.j.e(elements, "elements");
        Iterator it = elements.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    public final Object d(int i) {
        int i3 = this.f6357c;
        Object[] objArr = this.f6356b;
        Object obj = objArr[i];
        if (i3 <= 1) {
            clear();
            return obj;
        }
        int i4 = i3 - 1;
        int[] iArr = this.f6355a;
        int i5 = 8;
        if (iArr.length > 8 && i3 < iArr.length / 3) {
            if (i3 > 8) {
                i5 = i3 + (i3 >> 1);
            }
            int[] iArr2 = new int[i5];
            this.f6355a = iArr2;
            this.f6356b = new Object[i5];
            if (i > 0) {
                AbstractC0705g.D(0, 0, iArr, iArr2, i);
                AbstractC0705g.F(objArr, 0, this.f6356b, i, 6);
            }
            if (i < i4) {
                int i6 = i + 1;
                AbstractC0705g.D(i, i6, iArr, this.f6355a, i3);
                AbstractC0705g.E(objArr, i, this.f6356b, i6, i3);
            }
        } else {
            if (i < i4) {
                int i7 = i + 1;
                AbstractC0705g.D(i, i7, iArr, iArr, i3);
                Object[] objArr2 = this.f6356b;
                AbstractC0705g.E(objArr2, i, objArr2, i7, i3);
            }
            this.f6356b[i4] = null;
        }
        if (i3 == this.f6357c) {
            this.f6357c = i4;
            return obj;
        }
        throw new ConcurrentModificationException();
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Set) || this.f6357c != ((Set) obj).size()) {
            return false;
        }
        try {
            int i = this.f6357c;
            for (int i3 = 0; i3 < i; i3++) {
                if (!((Set) obj).contains(this.f6356b[i3])) {
                    return false;
                }
            }
            return true;
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }

    @Override // java.util.Collection, java.util.Set
    public final int hashCode() {
        int[] iArr = this.f6355a;
        int i = this.f6357c;
        int i3 = 0;
        for (int i4 = 0; i4 < i; i4++) {
            i3 += iArr[i4];
        }
        return i3;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean isEmpty() {
        if (this.f6357c <= 0) {
            return true;
        }
        return false;
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        return new C0685a(this);
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        int b4;
        if (obj == null) {
            b4 = AbstractC0692h.b(this, null, 0);
        } else {
            b4 = AbstractC0692h.b(this, obj, obj.hashCode());
        }
        if (b4 < 0) {
            return false;
        }
        d(b4);
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean removeAll(Collection elements) {
        kotlin.jvm.internal.j.e(elements, "elements");
        Iterator it = elements.iterator();
        boolean z3 = false;
        while (it.hasNext()) {
            z3 |= remove(it.next());
        }
        return z3;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean retainAll(Collection elements) {
        kotlin.jvm.internal.j.e(elements, "elements");
        boolean z3 = false;
        for (int i = this.f6357c - 1; -1 < i; i--) {
            if (!AbstractC0707i.b0(elements, this.f6356b[i])) {
                d(i);
                z3 = true;
            }
        }
        return z3;
    }

    @Override // java.util.Collection, java.util.Set
    public final int size() {
        return this.f6357c;
    }

    @Override // java.util.Collection, java.util.Set
    public final Object[] toArray() {
        return AbstractC0705g.H(this.f6356b, 0, this.f6357c);
    }

    public final String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f6357c * 14);
        sb.append('{');
        int i = this.f6357c;
        for (int i3 = 0; i3 < i; i3++) {
            if (i3 > 0) {
                sb.append(", ");
            }
            Object obj = this.f6356b[i3];
            if (obj != this) {
                sb.append(obj);
            } else {
                sb.append("(this Set)");
            }
        }
        sb.append('}');
        String sb2 = sb.toString();
        kotlin.jvm.internal.j.d(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    @Override // java.util.Collection, java.util.Set
    public final Object[] toArray(Object[] array) {
        kotlin.jvm.internal.j.e(array, "array");
        int i = this.f6357c;
        if (array.length < i) {
            array = (Object[]) Array.newInstance(array.getClass().getComponentType(), i);
        } else if (array.length > i) {
            array[i] = null;
        }
        AbstractC0705g.E(this.f6356b, 0, array, 0, this.f6357c);
        return array;
    }
}
