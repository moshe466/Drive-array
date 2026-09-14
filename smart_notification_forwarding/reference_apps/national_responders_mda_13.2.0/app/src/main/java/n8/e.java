package n8;

import java.util.Collection;
import java.util.Iterator;
import y8.k;

/* loaded from: classes.dex */
public final class e<E> extends m8.e<E> {

    /* renamed from: f, reason: collision with root package name */
    private final c<E, ?> f12259f;

    public e(c<E, ?> cVar) {
        k.e(cVar, "backing");
        this.f12259f = cVar;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean add(E e10) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean addAll(Collection<? extends E> collection) {
        k.e(collection, "elements");
        throw new UnsupportedOperationException();
    }

    @Override // m8.e
    public int c() {
        return this.f12259f.size();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        this.f12259f.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return this.f12259f.containsKey(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.f12259f.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<E> iterator() {
        return this.f12259f.D();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        return this.f12259f.K(obj) >= 0;
    }

    @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean removeAll(Collection<? extends Object> collection) {
        k.e(collection, "elements");
        this.f12259f.k();
        return super.removeAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean retainAll(Collection<? extends Object> collection) {
        k.e(collection, "elements");
        this.f12259f.k();
        return super.retainAll(collection);
    }
}
