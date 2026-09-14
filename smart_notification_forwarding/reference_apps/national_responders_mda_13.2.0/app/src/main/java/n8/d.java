package n8;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import y8.k;

/* loaded from: classes.dex */
public final class d<K, V> extends a<Map.Entry<K, V>, K, V> {

    /* renamed from: f, reason: collision with root package name */
    private final c<K, V> f12258f;

    public d(c<K, V> cVar) {
        k.e(cVar, "backing");
        this.f12258f = cVar;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean addAll(Collection<? extends Map.Entry<K, V>> collection) {
        k.e(collection, "elements");
        throw new UnsupportedOperationException();
    }

    @Override // m8.e
    public int c() {
        return this.f12258f.size();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        this.f12258f.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean containsAll(Collection<? extends Object> collection) {
        k.e(collection, "elements");
        return this.f12258f.n(collection);
    }

    @Override // n8.a
    public boolean g(Map.Entry<? extends K, ? extends V> entry) {
        k.e(entry, "element");
        return this.f12258f.o(entry);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.f12258f.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<Map.Entry<K, V>> iterator() {
        return this.f12258f.t();
    }

    @Override // n8.a
    public boolean j(Map.Entry entry) {
        k.e(entry, "element");
        return this.f12258f.I(entry);
    }

    @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean removeAll(Collection<? extends Object> collection) {
        k.e(collection, "elements");
        this.f12258f.k();
        return super.removeAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean retainAll(Collection<? extends Object> collection) {
        k.e(collection, "elements");
        this.f12258f.k();
        return super.retainAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public boolean add(Map.Entry<K, V> entry) {
        k.e(entry, "element");
        throw new UnsupportedOperationException();
    }
}
