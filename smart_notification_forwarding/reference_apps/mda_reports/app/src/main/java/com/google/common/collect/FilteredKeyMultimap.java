package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: Access modifiers changed from: package-private */
@GwtCompatible
/* loaded from: classes2.dex */
public class FilteredKeyMultimap<K, V> extends AbstractMultimap<K, V> implements FilteredMultimap<K, V> {
    final Multimap<K, V> a;
    final Predicate<? super K> b;

    /* loaded from: classes2.dex */
    static class AddRejectingList<K, V> extends ForwardingList<V> {
        final K a;

        AddRejectingList(K k) {
            this.a = k;
        }

        @Override // com.google.common.collect.ForwardingList, java.util.List
        public void add(int i, V v) {
            Preconditions.checkPositionIndex(i, 0);
            throw new IllegalArgumentException("Key does not satisfy predicate: " + this.a);
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Queue
        public boolean add(V v) {
            add(0, v);
            return true;
        }

        @Override // com.google.common.collect.ForwardingList, java.util.List
        @CanIgnoreReturnValue
        public boolean addAll(int i, Collection<? extends V> collection) {
            Preconditions.checkNotNull(collection);
            Preconditions.checkPositionIndex(i, 0);
            throw new IllegalArgumentException("Key does not satisfy predicate: " + this.a);
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection
        public boolean addAll(Collection<? extends V> collection) {
            addAll(0, collection);
            return true;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.collect.ForwardingList, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        public List<V> delegate() {
            return Collections.emptyList();
        }
    }

    /* loaded from: classes2.dex */
    static class AddRejectingSet<K, V> extends ForwardingSet<V> {
        final K a;

        AddRejectingSet(K k) {
            this.a = k;
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Queue
        public boolean add(V v) {
            throw new IllegalArgumentException("Key does not satisfy predicate: " + this.a);
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection
        public boolean addAll(Collection<? extends V> collection) {
            Preconditions.checkNotNull(collection);
            throw new IllegalArgumentException("Key does not satisfy predicate: " + this.a);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        public Set<V> delegate() {
            return Collections.emptySet();
        }
    }

    /* loaded from: classes2.dex */
    class Entries extends ForwardingCollection<Map.Entry<K, V>> {
        /* JADX INFO: Access modifiers changed from: package-private */
        public Entries() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        public Collection<Map.Entry<K, V>> delegate() {
            return Collections2.filter(FilteredKeyMultimap.this.a.entries(), FilteredKeyMultimap.this.entryPredicate());
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public boolean remove(@NullableDecl Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            if (FilteredKeyMultimap.this.a.containsKey(entry.getKey()) && FilteredKeyMultimap.this.b.apply((Object) entry.getKey())) {
                return FilteredKeyMultimap.this.a.remove(entry.getKey(), entry.getValue());
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FilteredKeyMultimap(Multimap<K, V> multimap, Predicate<? super K> predicate) {
        this.a = (Multimap) Preconditions.checkNotNull(multimap);
        this.b = (Predicate) Preconditions.checkNotNull(predicate);
    }

    @Override // com.google.common.collect.AbstractMultimap
    Map<K, Collection<V>> a() {
        return Maps.filterKeys(this.a.asMap(), this.b);
    }

    @Override // com.google.common.collect.AbstractMultimap
    Collection<Map.Entry<K, V>> b() {
        return new Entries();
    }

    @Override // com.google.common.collect.AbstractMultimap
    Set<K> c() {
        return Sets.filter(this.a.keySet(), this.b);
    }

    @Override // com.google.common.collect.Multimap
    public void clear() {
        keySet().clear();
    }

    @Override // com.google.common.collect.Multimap
    public boolean containsKey(@NullableDecl Object obj) {
        if (this.a.containsKey(obj)) {
            return this.b.apply(obj);
        }
        return false;
    }

    @Override // com.google.common.collect.AbstractMultimap
    Multiset<K> d() {
        return Multisets.filter(this.a.keys(), this.b);
    }

    @Override // com.google.common.collect.AbstractMultimap
    Collection<V> e() {
        return new FilteredMultimapValues(this);
    }

    @Override // com.google.common.collect.FilteredMultimap
    public Predicate<? super Map.Entry<K, V>> entryPredicate() {
        return Maps.a(this.b);
    }

    @Override // com.google.common.collect.AbstractMultimap
    Iterator<Map.Entry<K, V>> f() {
        throw new AssertionError("should never be called");
    }

    @Override // com.google.common.collect.Multimap
    public Collection<V> get(K k) {
        return this.b.apply(k) ? this.a.get(k) : this.a instanceof SetMultimap ? new AddRejectingSet(k) : new AddRejectingList(k);
    }

    Collection<V> h() {
        return this.a instanceof SetMultimap ? ImmutableSet.of() : ImmutableList.of();
    }

    @Override // com.google.common.collect.Multimap
    public Collection<V> removeAll(Object obj) {
        return containsKey(obj) ? this.a.removeAll(obj) : h();
    }

    @Override // com.google.common.collect.Multimap
    public int size() {
        Iterator<Collection<V>> it = asMap().values().iterator();
        int i = 0;
        while (it.hasNext()) {
            i += it.next().size();
        }
        return i;
    }

    public Multimap<K, V> unfiltered() {
        return this.a;
    }
}
