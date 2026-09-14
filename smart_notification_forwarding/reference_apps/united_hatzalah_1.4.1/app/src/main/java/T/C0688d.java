package t;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;

/* renamed from: t.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0688d implements Collection {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C0689e f6351a;

    public C0688d(C0689e c0689e) {
        this.f6351a = c0689e;
    }

    @Override // java.util.Collection
    public final boolean add(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public final boolean addAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public final void clear() {
        this.f6351a.clear();
    }

    @Override // java.util.Collection
    public final boolean contains(Object obj) {
        if (this.f6351a.a(obj) >= 0) {
            return true;
        }
        return false;
    }

    @Override // java.util.Collection
    public final boolean containsAll(Collection collection) {
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Collection
    public final boolean isEmpty() {
        return this.f6351a.isEmpty();
    }

    @Override // java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        return new C0685a(this.f6351a, 1);
    }

    @Override // java.util.Collection
    public final boolean remove(Object obj) {
        C0689e c0689e = this.f6351a;
        int a2 = c0689e.a(obj);
        if (a2 >= 0) {
            c0689e.g(a2);
            return true;
        }
        return false;
    }

    @Override // java.util.Collection
    public final boolean removeAll(Collection collection) {
        C0689e c0689e = this.f6351a;
        int i = c0689e.f6366c;
        int i3 = 0;
        boolean z3 = false;
        while (i3 < i) {
            if (collection.contains(c0689e.i(i3))) {
                c0689e.g(i3);
                i3--;
                i--;
                z3 = true;
            }
            i3++;
        }
        return z3;
    }

    @Override // java.util.Collection
    public final boolean retainAll(Collection collection) {
        C0689e c0689e = this.f6351a;
        int i = c0689e.f6366c;
        int i3 = 0;
        boolean z3 = false;
        while (i3 < i) {
            if (!collection.contains(c0689e.i(i3))) {
                c0689e.g(i3);
                i3--;
                i--;
                z3 = true;
            }
            i3++;
        }
        return z3;
    }

    @Override // java.util.Collection
    public final int size() {
        return this.f6351a.f6366c;
    }

    @Override // java.util.Collection
    public final Object[] toArray() {
        C0689e c0689e = this.f6351a;
        int i = c0689e.f6366c;
        Object[] objArr = new Object[i];
        for (int i3 = 0; i3 < i; i3++) {
            objArr[i3] = c0689e.i(i3);
        }
        return objArr;
    }

    @Override // java.util.Collection
    public final Object[] toArray(Object[] objArr) {
        C0689e c0689e = this.f6351a;
        int i = c0689e.f6366c;
        if (objArr.length < i) {
            objArr = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), i);
        }
        for (int i3 = 0; i3 < i; i3++) {
            objArr[i3] = c0689e.i(i3);
        }
        if (objArr.length > i) {
            objArr[i] = null;
        }
        return objArr;
    }
}
