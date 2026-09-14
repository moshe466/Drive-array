package t;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/* renamed from: t.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0686b implements Set {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C0689e f6346a;

    public C0686b(C0689e c0689e) {
        this.f6346a = c0689e;
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean add(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean addAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Set, java.util.Collection
    public final void clear() {
        this.f6346a.clear();
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean contains(Object obj) {
        return this.f6346a.containsKey(obj);
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean containsAll(Collection collection) {
        return this.f6346a.j(collection);
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean equals(Object obj) {
        C0689e c0689e = this.f6346a;
        if (this != obj) {
            if (obj instanceof Set) {
                Set set = (Set) obj;
                try {
                    if (c0689e.f6366c == set.size()) {
                        if (c0689e.j(set)) {
                            return true;
                        }
                        return false;
                    }
                    return false;
                } catch (ClassCastException | NullPointerException unused) {
                    return false;
                }
            }
            return false;
        }
        return true;
    }

    @Override // java.util.Set, java.util.Collection
    public final int hashCode() {
        int hashCode;
        C0689e c0689e = this.f6346a;
        int i = 0;
        for (int i3 = c0689e.f6366c - 1; i3 >= 0; i3--) {
            Object f4 = c0689e.f(i3);
            if (f4 == null) {
                hashCode = 0;
            } else {
                hashCode = f4.hashCode();
            }
            i += hashCode;
        }
        return i;
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean isEmpty() {
        return this.f6346a.isEmpty();
    }

    @Override // java.util.Set, java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        return new C0685a(this.f6346a, 0);
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean remove(Object obj) {
        C0689e c0689e = this.f6346a;
        int d2 = c0689e.d(obj);
        if (d2 >= 0) {
            c0689e.g(d2);
            return true;
        }
        return false;
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean removeAll(Collection collection) {
        return this.f6346a.k(collection);
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean retainAll(Collection collection) {
        return this.f6346a.l(collection);
    }

    @Override // java.util.Set, java.util.Collection
    public final int size() {
        return this.f6346a.f6366c;
    }

    @Override // java.util.Set, java.util.Collection
    public final Object[] toArray() {
        C0689e c0689e = this.f6346a;
        int i = c0689e.f6366c;
        Object[] objArr = new Object[i];
        for (int i3 = 0; i3 < i; i3++) {
            objArr[i3] = c0689e.f(i3);
        }
        return objArr;
    }

    @Override // java.util.Set, java.util.Collection
    public final Object[] toArray(Object[] objArr) {
        C0689e c0689e = this.f6346a;
        int i = c0689e.f6366c;
        if (objArr.length < i) {
            objArr = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), i);
        }
        for (int i3 = 0; i3 < i; i3++) {
            objArr[i3] = c0689e.f(i3);
        }
        if (objArr.length > i) {
            objArr[i] = null;
        }
        return objArr;
    }
}
