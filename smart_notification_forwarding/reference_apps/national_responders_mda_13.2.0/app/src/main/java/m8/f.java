package m8;

import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class f<T> implements Collection<T>, z8.a {

    /* renamed from: f, reason: collision with root package name */
    private final T[] f12038f;

    /* renamed from: g, reason: collision with root package name */
    private final boolean f12039g;

    public f(T[] tArr, boolean z10) {
        y8.k.e(tArr, "values");
        this.f12038f = tArr;
        this.f12039g = z10;
    }

    @Override // java.util.Collection
    public boolean add(T t10) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends T> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public int c() {
        return this.f12038f.length;
    }

    @Override // java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean contains(Object obj) {
        boolean m10;
        m10 = k.m(this.f12038f, obj);
        return m10;
    }

    @Override // java.util.Collection
    public boolean containsAll(Collection<? extends Object> collection) {
        y8.k.e(collection, "elements");
        if (collection.isEmpty()) {
            return true;
        }
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return this.f12038f.length == 0;
    }

    @Override // java.util.Collection, java.lang.Iterable
    public Iterator<T> iterator() {
        return y8.b.a(this.f12038f);
    }

    @Override // java.util.Collection
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean removeAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean retainAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final /* bridge */ int size() {
        return c();
    }

    @Override // java.util.Collection
    public final Object[] toArray() {
        return p.a(this.f12038f, this.f12039g);
    }

    @Override // java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        y8.k.e(tArr, "array");
        return (T[]) y8.f.b(this, tArr);
    }
}
