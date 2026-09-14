package com.google.firebase.database.collection;

import com.google.firebase.database.collection.ImmutableSortedMap;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public class ImmutableSortedSet<T> implements Iterable<T> {
    private final ImmutableSortedMap<T, Void> map;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class WrappedEntryIterator<T> implements Iterator<T> {
        final Iterator<Map.Entry<T, Void>> a;

        public WrappedEntryIterator(Iterator<Map.Entry<T, Void>> it) {
            this.a = it;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.a.hasNext();
        }

        @Override // java.util.Iterator
        public T next() {
            return this.a.next().getKey();
        }

        @Override // java.util.Iterator
        public void remove() {
            this.a.remove();
        }
    }

    private ImmutableSortedSet(ImmutableSortedMap<T, Void> immutableSortedMap) {
        this.map = immutableSortedMap;
    }

    public ImmutableSortedSet(List<T> list, Comparator<T> comparator) {
        this.map = ImmutableSortedMap.Builder.buildFrom(list, Collections.emptyMap(), ImmutableSortedMap.Builder.identityTranslator(), comparator);
    }

    public boolean contains(T t) {
        return this.map.containsKey(t);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ImmutableSortedSet) {
            return this.map.equals(((ImmutableSortedSet) obj).map);
        }
        return false;
    }

    public T getMaxEntry() {
        return this.map.getMaxKey();
    }

    public T getMinEntry() {
        return this.map.getMinKey();
    }

    public T getPredecessorEntry(T t) {
        return this.map.getPredecessorKey(t);
    }

    public int hashCode() {
        return this.map.hashCode();
    }

    public int indexOf(T t) {
        return this.map.indexOf(t);
    }

    public ImmutableSortedSet<T> insert(T t) {
        return new ImmutableSortedSet<>(this.map.insert(t, null));
    }

    public boolean isEmpty() {
        return this.map.isEmpty();
    }

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        return new WrappedEntryIterator(this.map.iterator());
    }

    public Iterator<T> iteratorFrom(T t) {
        return new WrappedEntryIterator(this.map.iteratorFrom(t));
    }

    public ImmutableSortedSet<T> remove(T t) {
        ImmutableSortedMap<T, Void> remove = this.map.remove(t);
        return remove == this.map ? this : new ImmutableSortedSet<>(remove);
    }

    public Iterator<T> reverseIterator() {
        return new WrappedEntryIterator(this.map.reverseIterator());
    }

    public Iterator<T> reverseIteratorFrom(T t) {
        return new WrappedEntryIterator(this.map.reverseIteratorFrom(t));
    }

    public int size() {
        return this.map.size();
    }
}
