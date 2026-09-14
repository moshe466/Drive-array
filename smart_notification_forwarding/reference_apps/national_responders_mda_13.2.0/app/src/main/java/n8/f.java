package n8;

import java.util.Collection;
import java.util.Iterator;
import y8.k;

/* loaded from: classes.dex */
public final class f<V> extends m8.c<V> {

    /* renamed from: f, reason: collision with root package name */
    private final c<?, V> f12260f;

    public f(c<?, V> cVar) {
        k.e(cVar, "backing");
        this.f12260f = cVar;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean add(V v10) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean addAll(Collection<? extends V> collection) {
        k.e(collection, "elements");
        throw new UnsupportedOperationException();
    }

    @Override // m8.c
    public int c() {
        return this.f12260f.size();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public void clear() {
        this.f12260f.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean contains(Object obj) {
        return this.f12260f.containsValue(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return this.f12260f.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<V> iterator() {
        return this.f12260f.N();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean remove(Object obj) {
        return this.f12260f.M(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean removeAll(Collection<? extends Object> collection) {
        k.e(collection, "elements");
        this.f12260f.k();
        return super.removeAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean retainAll(Collection<? extends Object> collection) {
        k.e(collection, "elements");
        this.f12260f.k();
        return super.retainAll(collection);
    }
}
