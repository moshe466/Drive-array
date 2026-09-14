package t2;

import F0.AbstractC0008a;
import com.google.android.gms.common.api.Api;
import java.lang.reflect.Array;
import java.util.AbstractList;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* renamed from: t2.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0704f extends AbstractC0702d {

    /* renamed from: d, reason: collision with root package name */
    public static final Object[] f6469d = new Object[0];

    /* renamed from: a, reason: collision with root package name */
    public int f6470a;

    /* renamed from: b, reason: collision with root package name */
    public Object[] f6471b = f6469d;

    /* renamed from: c, reason: collision with root package name */
    public int f6472c;

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i, Object obj) {
        int i3;
        int i4 = this.f6472c;
        if (i < 0 || i > i4) {
            throw new IndexOutOfBoundsException(AbstractC0008a.k("index: ", i, i4, ", size: "));
        }
        if (i == i4) {
            addLast(obj);
            return;
        }
        if (i == 0) {
            addFirst(obj);
            return;
        }
        o();
        j(this.f6472c + 1);
        int n4 = n(this.f6470a + i);
        int i5 = this.f6472c;
        if (i < ((i5 + 1) >> 1)) {
            if (n4 == 0) {
                Object[] objArr = this.f6471b;
                kotlin.jvm.internal.j.e(objArr, "<this>");
                n4 = objArr.length;
            }
            int i6 = n4 - 1;
            int i7 = this.f6470a;
            if (i7 == 0) {
                Object[] objArr2 = this.f6471b;
                kotlin.jvm.internal.j.e(objArr2, "<this>");
                i3 = objArr2.length - 1;
            } else {
                i3 = i7 - 1;
            }
            int i8 = this.f6470a;
            if (i6 >= i8) {
                Object[] objArr3 = this.f6471b;
                objArr3[i3] = objArr3[i8];
                AbstractC0705g.E(objArr3, i8, objArr3, i8 + 1, i6 + 1);
            } else {
                Object[] objArr4 = this.f6471b;
                AbstractC0705g.E(objArr4, i8 - 1, objArr4, i8, objArr4.length);
                Object[] objArr5 = this.f6471b;
                objArr5[objArr5.length - 1] = objArr5[0];
                AbstractC0705g.E(objArr5, 0, objArr5, 1, i6 + 1);
            }
            this.f6471b[i6] = obj;
            this.f6470a = i3;
        } else {
            int n5 = n(i5 + this.f6470a);
            if (n4 < n5) {
                Object[] objArr6 = this.f6471b;
                AbstractC0705g.E(objArr6, n4 + 1, objArr6, n4, n5);
            } else {
                Object[] objArr7 = this.f6471b;
                AbstractC0705g.E(objArr7, 1, objArr7, 0, n5);
                Object[] objArr8 = this.f6471b;
                objArr8[0] = objArr8[objArr8.length - 1];
                AbstractC0705g.E(objArr8, n4 + 1, objArr8, n4, objArr8.length - 1);
            }
            this.f6471b[n4] = obj;
        }
        this.f6472c++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final boolean addAll(int i, Collection elements) {
        kotlin.jvm.internal.j.e(elements, "elements");
        int i3 = this.f6472c;
        if (i >= 0 && i <= i3) {
            if (elements.isEmpty()) {
                return false;
            }
            if (i == this.f6472c) {
                return addAll(elements);
            }
            o();
            j(elements.size() + this.f6472c);
            int n4 = n(this.f6472c + this.f6470a);
            int n5 = n(this.f6470a + i);
            int size = elements.size();
            if (i < ((this.f6472c + 1) >> 1)) {
                int i4 = this.f6470a;
                int i5 = i4 - size;
                if (n5 < i4) {
                    Object[] objArr = this.f6471b;
                    AbstractC0705g.E(objArr, i5, objArr, i4, objArr.length);
                    if (size >= n5) {
                        Object[] objArr2 = this.f6471b;
                        AbstractC0705g.E(objArr2, objArr2.length - size, objArr2, 0, n5);
                    } else {
                        Object[] objArr3 = this.f6471b;
                        AbstractC0705g.E(objArr3, objArr3.length - size, objArr3, 0, size);
                        Object[] objArr4 = this.f6471b;
                        AbstractC0705g.E(objArr4, 0, objArr4, size, n5);
                    }
                } else if (i5 >= 0) {
                    Object[] objArr5 = this.f6471b;
                    AbstractC0705g.E(objArr5, i5, objArr5, i4, n5);
                } else {
                    Object[] objArr6 = this.f6471b;
                    i5 += objArr6.length;
                    int i6 = n5 - i4;
                    int length = objArr6.length - i5;
                    if (length >= i6) {
                        AbstractC0705g.E(objArr6, i5, objArr6, i4, n5);
                    } else {
                        AbstractC0705g.E(objArr6, i5, objArr6, i4, i4 + length);
                        Object[] objArr7 = this.f6471b;
                        AbstractC0705g.E(objArr7, 0, objArr7, this.f6470a + length, n5);
                    }
                }
                this.f6470a = i5;
                i(l(n5 - size), elements);
                return true;
            }
            int i7 = n5 + size;
            if (n5 < n4) {
                int i8 = size + n4;
                Object[] objArr8 = this.f6471b;
                if (i8 <= objArr8.length) {
                    AbstractC0705g.E(objArr8, i7, objArr8, n5, n4);
                } else if (i7 >= objArr8.length) {
                    AbstractC0705g.E(objArr8, i7 - objArr8.length, objArr8, n5, n4);
                } else {
                    int length2 = n4 - (i8 - objArr8.length);
                    AbstractC0705g.E(objArr8, 0, objArr8, length2, n4);
                    Object[] objArr9 = this.f6471b;
                    AbstractC0705g.E(objArr9, i7, objArr9, n5, length2);
                }
            } else {
                Object[] objArr10 = this.f6471b;
                AbstractC0705g.E(objArr10, size, objArr10, 0, n4);
                Object[] objArr11 = this.f6471b;
                if (i7 >= objArr11.length) {
                    AbstractC0705g.E(objArr11, i7 - objArr11.length, objArr11, n5, objArr11.length);
                } else {
                    AbstractC0705g.E(objArr11, 0, objArr11, objArr11.length - size, objArr11.length);
                    Object[] objArr12 = this.f6471b;
                    AbstractC0705g.E(objArr12, i7, objArr12, n5, objArr12.length - size);
                }
            }
            i(n5, elements);
            return true;
        }
        throw new IndexOutOfBoundsException(AbstractC0008a.k("index: ", i, i3, ", size: "));
    }

    public final void addFirst(Object obj) {
        o();
        j(this.f6472c + 1);
        int i = this.f6470a;
        if (i == 0) {
            Object[] objArr = this.f6471b;
            kotlin.jvm.internal.j.e(objArr, "<this>");
            i = objArr.length;
        }
        int i3 = i - 1;
        this.f6470a = i3;
        this.f6471b[i3] = obj;
        this.f6472c++;
    }

    public final void addLast(Object obj) {
        o();
        j(g() + 1);
        this.f6471b[n(g() + this.f6470a)] = obj;
        this.f6472c = g() + 1;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        if (!isEmpty()) {
            o();
            m(this.f6470a, n(g() + this.f6470a));
        }
        this.f6470a = 0;
        this.f6472c = 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        if (indexOf(obj) != -1) {
            return true;
        }
        return false;
    }

    @Override // t2.AbstractC0702d
    public final int g() {
        return this.f6472c;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i) {
        int g3 = g();
        if (i >= 0 && i < g3) {
            return this.f6471b[n(this.f6470a + i)];
        }
        throw new IndexOutOfBoundsException(AbstractC0008a.k("index: ", i, g3, ", size: "));
    }

    @Override // t2.AbstractC0702d
    public final Object h(int i) {
        int i3 = this.f6472c;
        if (i >= 0 && i < i3) {
            if (i == size() - 1) {
                return removeLast();
            }
            if (i == 0) {
                return removeFirst();
            }
            o();
            int n4 = n(this.f6470a + i);
            Object[] objArr = this.f6471b;
            Object obj = objArr[n4];
            if (i < (this.f6472c >> 1)) {
                int i4 = this.f6470a;
                if (n4 >= i4) {
                    AbstractC0705g.E(objArr, i4 + 1, objArr, i4, n4);
                } else {
                    AbstractC0705g.E(objArr, 1, objArr, 0, n4);
                    Object[] objArr2 = this.f6471b;
                    objArr2[0] = objArr2[objArr2.length - 1];
                    int i5 = this.f6470a;
                    AbstractC0705g.E(objArr2, i5 + 1, objArr2, i5, objArr2.length - 1);
                }
                Object[] objArr3 = this.f6471b;
                int i6 = this.f6470a;
                objArr3[i6] = null;
                this.f6470a = k(i6);
            } else {
                int n5 = n((size() - 1) + this.f6470a);
                if (n4 <= n5) {
                    Object[] objArr4 = this.f6471b;
                    AbstractC0705g.E(objArr4, n4, objArr4, n4 + 1, n5 + 1);
                } else {
                    Object[] objArr5 = this.f6471b;
                    AbstractC0705g.E(objArr5, n4, objArr5, n4 + 1, objArr5.length);
                    Object[] objArr6 = this.f6471b;
                    objArr6[objArr6.length - 1] = objArr6[0];
                    AbstractC0705g.E(objArr6, 0, objArr6, 1, n5 + 1);
                }
                this.f6471b[n5] = null;
            }
            this.f6472c--;
            return obj;
        }
        throw new IndexOutOfBoundsException(AbstractC0008a.k("index: ", i, i3, ", size: "));
    }

    public final void i(int i, Collection collection) {
        Iterator it = collection.iterator();
        int length = this.f6471b.length;
        while (i < length && it.hasNext()) {
            this.f6471b[i] = it.next();
            i++;
        }
        int i3 = this.f6470a;
        for (int i4 = 0; i4 < i3 && it.hasNext(); i4++) {
            this.f6471b[i4] = it.next();
        }
        this.f6472c = collection.size() + this.f6472c;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        int i;
        int n4 = n(g() + this.f6470a);
        int i3 = this.f6470a;
        if (i3 < n4) {
            while (i3 < n4) {
                if (kotlin.jvm.internal.j.a(obj, this.f6471b[i3])) {
                    i = this.f6470a;
                } else {
                    i3++;
                }
            }
            return -1;
        }
        if (i3 >= n4) {
            int length = this.f6471b.length;
            while (true) {
                if (i3 < length) {
                    if (kotlin.jvm.internal.j.a(obj, this.f6471b[i3])) {
                        i = this.f6470a;
                        break;
                    }
                    i3++;
                } else {
                    for (int i4 = 0; i4 < n4; i4++) {
                        if (kotlin.jvm.internal.j.a(obj, this.f6471b[i4])) {
                            i3 = i4 + this.f6471b.length;
                            i = this.f6470a;
                        }
                    }
                    return -1;
                }
            }
        } else {
            return -1;
        }
        return i3 - i;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean isEmpty() {
        if (g() == 0) {
            return true;
        }
        return false;
    }

    public final void j(int i) {
        if (i >= 0) {
            Object[] objArr = this.f6471b;
            if (i <= objArr.length) {
                return;
            }
            if (objArr == f6469d) {
                if (i < 10) {
                    i = 10;
                }
                this.f6471b = new Object[i];
                return;
            }
            int length = objArr.length;
            int i3 = length + (length >> 1);
            if (i3 - i < 0) {
                i3 = i;
            }
            if (i3 - 2147483639 > 0) {
                if (i > 2147483639) {
                    i3 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                } else {
                    i3 = 2147483639;
                }
            }
            Object[] objArr2 = new Object[i3];
            AbstractC0705g.E(objArr, 0, objArr2, this.f6470a, objArr.length);
            Object[] objArr3 = this.f6471b;
            int length2 = objArr3.length;
            int i4 = this.f6470a;
            AbstractC0705g.E(objArr3, length2 - i4, objArr2, 0, i4);
            this.f6470a = 0;
            this.f6471b = objArr2;
            return;
        }
        throw new IllegalStateException("Deque is too big.");
    }

    public final int k(int i) {
        kotlin.jvm.internal.j.e(this.f6471b, "<this>");
        if (i == r0.length - 1) {
            return 0;
        }
        return i + 1;
    }

    public final int l(int i) {
        if (i < 0) {
            return i + this.f6471b.length;
        }
        return i;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int lastIndexOf(Object obj) {
        int length;
        int i;
        int n4 = n(this.f6472c + this.f6470a);
        int i3 = this.f6470a;
        if (i3 < n4) {
            length = n4 - 1;
            if (i3 <= length) {
                while (!kotlin.jvm.internal.j.a(obj, this.f6471b[length])) {
                    if (length != i3) {
                        length--;
                    }
                }
                i = this.f6470a;
                return length - i;
            }
            return -1;
        }
        if (i3 > n4) {
            int i4 = n4 - 1;
            while (true) {
                if (-1 < i4) {
                    if (kotlin.jvm.internal.j.a(obj, this.f6471b[i4])) {
                        length = i4 + this.f6471b.length;
                        i = this.f6470a;
                        break;
                    }
                    i4--;
                } else {
                    Object[] objArr = this.f6471b;
                    kotlin.jvm.internal.j.e(objArr, "<this>");
                    length = objArr.length - 1;
                    int i5 = this.f6470a;
                    if (i5 <= length) {
                        while (!kotlin.jvm.internal.j.a(obj, this.f6471b[length])) {
                            if (length != i5) {
                                length--;
                            }
                        }
                        i = this.f6470a;
                    }
                }
            }
        }
        return -1;
    }

    public final void m(int i, int i3) {
        if (i < i3) {
            AbstractC0705g.I(this.f6471b, i, i3);
            return;
        }
        Object[] objArr = this.f6471b;
        AbstractC0705g.I(objArr, i, objArr.length);
        AbstractC0705g.I(this.f6471b, 0, i3);
    }

    public final int n(int i) {
        Object[] objArr = this.f6471b;
        if (i >= objArr.length) {
            return i - objArr.length;
        }
        return i;
    }

    public final void o() {
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        int indexOf = indexOf(obj);
        if (indexOf == -1) {
            return false;
        }
        h(indexOf);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean removeAll(Collection elements) {
        int n4;
        kotlin.jvm.internal.j.e(elements, "elements");
        boolean z3 = false;
        z3 = false;
        z3 = false;
        if (!isEmpty() && this.f6471b.length != 0) {
            int n5 = n(this.f6472c + this.f6470a);
            int i = this.f6470a;
            if (i < n5) {
                n4 = i;
                while (i < n5) {
                    Object obj = this.f6471b[i];
                    if (!elements.contains(obj)) {
                        this.f6471b[n4] = obj;
                        n4++;
                    } else {
                        z3 = true;
                    }
                    i++;
                }
                AbstractC0705g.I(this.f6471b, n4, n5);
            } else {
                int length = this.f6471b.length;
                boolean z4 = false;
                int i3 = i;
                while (i < length) {
                    Object[] objArr = this.f6471b;
                    Object obj2 = objArr[i];
                    objArr[i] = null;
                    if (!elements.contains(obj2)) {
                        this.f6471b[i3] = obj2;
                        i3++;
                    } else {
                        z4 = true;
                    }
                    i++;
                }
                n4 = n(i3);
                for (int i4 = 0; i4 < n5; i4++) {
                    Object[] objArr2 = this.f6471b;
                    Object obj3 = objArr2[i4];
                    objArr2[i4] = null;
                    if (!elements.contains(obj3)) {
                        this.f6471b[n4] = obj3;
                        n4 = k(n4);
                    } else {
                        z4 = true;
                    }
                }
                z3 = z4;
            }
            if (z3) {
                o();
                this.f6472c = l(n4 - this.f6470a);
            }
        }
        return z3;
    }

    public final Object removeFirst() {
        if (!isEmpty()) {
            o();
            Object[] objArr = this.f6471b;
            int i = this.f6470a;
            Object obj = objArr[i];
            objArr[i] = null;
            this.f6470a = k(i);
            this.f6472c = g() - 1;
            return obj;
        }
        throw new NoSuchElementException("ArrayDeque is empty.");
    }

    public final Object removeLast() {
        if (!isEmpty()) {
            o();
            int n4 = n((size() - 1) + this.f6470a);
            Object[] objArr = this.f6471b;
            Object obj = objArr[n4];
            objArr[n4] = null;
            this.f6472c = g() - 1;
            return obj;
        }
        throw new NoSuchElementException("ArrayDeque is empty.");
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i, int i3) {
        p3.h.f(i, i3, this.f6472c);
        int i4 = i3 - i;
        if (i4 == 0) {
            return;
        }
        if (i4 == this.f6472c) {
            clear();
            return;
        }
        if (i4 == 1) {
            h(i);
            return;
        }
        o();
        if (i < this.f6472c - i3) {
            int n4 = n(this.f6470a + (i - 1));
            int n5 = n(this.f6470a + (i3 - 1));
            while (i > 0) {
                int i5 = n4 + 1;
                int min = Math.min(i, Math.min(i5, n5 + 1));
                Object[] objArr = this.f6471b;
                int i6 = n5 - min;
                int i7 = n4 - min;
                AbstractC0705g.E(objArr, i6 + 1, objArr, i7 + 1, i5);
                n4 = l(i7);
                n5 = l(i6);
                i -= min;
            }
            int n6 = n(this.f6470a + i4);
            m(this.f6470a, n6);
            this.f6470a = n6;
        } else {
            int n7 = n(this.f6470a + i3);
            int n8 = n(this.f6470a + i);
            int i8 = this.f6472c;
            while (true) {
                i8 -= i3;
                if (i8 <= 0) {
                    break;
                }
                Object[] objArr2 = this.f6471b;
                i3 = Math.min(i8, Math.min(objArr2.length - n7, objArr2.length - n8));
                Object[] objArr3 = this.f6471b;
                int i9 = n7 + i3;
                AbstractC0705g.E(objArr3, n8, objArr3, n7, i9);
                n7 = n(i9);
                n8 = n(n8 + i3);
            }
            int n9 = n(this.f6472c + this.f6470a);
            m(l(n9 - i4), n9);
        }
        this.f6472c -= i4;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean retainAll(Collection elements) {
        int n4;
        kotlin.jvm.internal.j.e(elements, "elements");
        boolean z3 = false;
        z3 = false;
        z3 = false;
        if (!isEmpty() && this.f6471b.length != 0) {
            int n5 = n(this.f6472c + this.f6470a);
            int i = this.f6470a;
            if (i < n5) {
                n4 = i;
                while (i < n5) {
                    Object obj = this.f6471b[i];
                    if (elements.contains(obj)) {
                        this.f6471b[n4] = obj;
                        n4++;
                    } else {
                        z3 = true;
                    }
                    i++;
                }
                AbstractC0705g.I(this.f6471b, n4, n5);
            } else {
                int length = this.f6471b.length;
                boolean z4 = false;
                int i3 = i;
                while (i < length) {
                    Object[] objArr = this.f6471b;
                    Object obj2 = objArr[i];
                    objArr[i] = null;
                    if (elements.contains(obj2)) {
                        this.f6471b[i3] = obj2;
                        i3++;
                    } else {
                        z4 = true;
                    }
                    i++;
                }
                n4 = n(i3);
                for (int i4 = 0; i4 < n5; i4++) {
                    Object[] objArr2 = this.f6471b;
                    Object obj3 = objArr2[i4];
                    objArr2[i4] = null;
                    if (elements.contains(obj3)) {
                        this.f6471b[n4] = obj3;
                        n4 = k(n4);
                    } else {
                        z4 = true;
                    }
                }
                z3 = z4;
            }
            if (z3) {
                o();
                this.f6472c = l(n4 - this.f6470a);
            }
        }
        return z3;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i, Object obj) {
        int g3 = g();
        if (i >= 0 && i < g3) {
            int n4 = n(this.f6470a + i);
            Object[] objArr = this.f6471b;
            Object obj2 = objArr[n4];
            objArr[n4] = obj;
            return obj2;
        }
        throw new IndexOutOfBoundsException(AbstractC0008a.k("index: ", i, g3, ", size: "));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final Object[] toArray() {
        return toArray(new Object[g()]);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final Object[] toArray(Object[] array) {
        kotlin.jvm.internal.j.e(array, "array");
        int length = array.length;
        int i = this.f6472c;
        if (length < i) {
            Object newInstance = Array.newInstance(array.getClass().getComponentType(), i);
            kotlin.jvm.internal.j.c(newInstance, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.arrayOfNulls>");
            array = (Object[]) newInstance;
        }
        int n4 = n(this.f6472c + this.f6470a);
        int i3 = this.f6470a;
        if (i3 < n4) {
            AbstractC0705g.F(this.f6471b, i3, array, n4, 2);
        } else if (!isEmpty()) {
            Object[] objArr = this.f6471b;
            AbstractC0705g.E(objArr, 0, array, this.f6470a, objArr.length);
            Object[] objArr2 = this.f6471b;
            AbstractC0705g.E(objArr2, objArr2.length - this.f6470a, array, 0, n4);
        }
        int i4 = this.f6472c;
        if (i4 < array.length) {
            array[i4] = null;
        }
        return array;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        addLast(obj);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection elements) {
        kotlin.jvm.internal.j.e(elements, "elements");
        if (elements.isEmpty()) {
            return false;
        }
        o();
        j(elements.size() + g());
        i(n(g() + this.f6470a), elements);
        return true;
    }
}
