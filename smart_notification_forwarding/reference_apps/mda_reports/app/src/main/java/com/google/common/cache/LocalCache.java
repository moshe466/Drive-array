package com.google.common.cache;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Equivalence;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Stopwatch;
import com.google.common.base.Ticker;
import com.google.common.cache.AbstractCache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.collect.AbstractSequentialIterator;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterators;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.common.primitives.Ints;
import com.google.common.util.concurrent.ExecutionError;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.common.util.concurrent.SettableFuture;
import com.google.common.util.concurrent.UncheckedExecutionException;
import com.google.common.util.concurrent.Uninterruptibles;
import com.google.errorprone.annotations.concurrent.GuardedBy;
import com.google.j2objc.annotations.Weak;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractQueue;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: Access modifiers changed from: package-private */
@GwtCompatible(emulated = true)
/* loaded from: classes2.dex */
public class LocalCache<K, V> extends AbstractMap<K, V> implements ConcurrentMap<K, V> {
    static final Logger w = Logger.getLogger(LocalCache.class.getName());
    static final ValueReference<Object, Object> x = new ValueReference<Object, Object>() { // from class: com.google.common.cache.LocalCache.1
        @Override // com.google.common.cache.LocalCache.ValueReference
        public ValueReference<Object, Object> copyFor(ReferenceQueue<Object> referenceQueue, @NullableDecl Object obj, ReferenceEntry<Object, Object> referenceEntry) {
            return this;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public Object get() {
            return null;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public ReferenceEntry<Object, Object> getEntry() {
            return null;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public int getWeight() {
            return 0;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public boolean isActive() {
            return false;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public boolean isLoading() {
            return false;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public void notifyNewValue(Object obj) {
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public Object waitForValue() {
            return null;
        }
    };
    static final Queue<?> y = new AbstractQueue<Object>() { // from class: com.google.common.cache.LocalCache.2
        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<Object> iterator() {
            return ImmutableSet.of().iterator();
        }

        @Override // java.util.Queue
        public boolean offer(Object obj) {
            return true;
        }

        @Override // java.util.Queue
        public Object peek() {
            return null;
        }

        @Override // java.util.Queue
        public Object poll() {
            return null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return 0;
        }
    };
    final int a;
    final int b;
    final Segment<K, V>[] c;
    final int d;
    final Equivalence<Object> e;
    final Equivalence<Object> f;
    final Strength g;
    final Strength h;
    final long i;
    final Weigher<K, V> j;
    final long k;
    final long l;
    final long m;
    final Queue<RemovalNotification<K, V>> n;
    final RemovalListener<K, V> o;
    final Ticker p;
    final EntryFactory q;
    final AbstractCache.StatsCounter r;

    @NullableDecl
    final CacheLoader<? super K, V> s;

    @MonotonicNonNullDecl
    Set<K> t;

    @MonotonicNonNullDecl
    Collection<V> u;

    @MonotonicNonNullDecl
    Set<Map.Entry<K, V>> v;

    /* loaded from: classes2.dex */
    abstract class AbstractCacheSet<T> extends AbstractSet<T> {

        @Weak
        final ConcurrentMap<?, ?> a;

        AbstractCacheSet(LocalCache localCache, ConcurrentMap<?, ?> concurrentMap) {
            this.a = concurrentMap;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            this.a.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return this.a.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.a.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public Object[] toArray() {
            return LocalCache.toArrayList(this).toArray();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public <E> E[] toArray(E[] eArr) {
            return (E[]) LocalCache.toArrayList(this).toArray(eArr);
        }
    }

    /* loaded from: classes2.dex */
    static abstract class AbstractReferenceEntry<K, V> implements ReferenceEntry<K, V> {
        AbstractReferenceEntry() {
        }

        @Override // com.google.common.cache.ReferenceEntry
        public long getAccessTime() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public int getHash() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public K getKey() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public ReferenceEntry<K, V> getNext() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public ReferenceEntry<K, V> getNextInAccessQueue() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public ReferenceEntry<K, V> getNextInWriteQueue() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public ReferenceEntry<K, V> getPreviousInAccessQueue() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public ReferenceEntry<K, V> getPreviousInWriteQueue() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public ValueReference<K, V> getValueReference() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public long getWriteTime() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public void setAccessTime(long j) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public void setNextInAccessQueue(ReferenceEntry<K, V> referenceEntry) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public void setNextInWriteQueue(ReferenceEntry<K, V> referenceEntry) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public void setPreviousInAccessQueue(ReferenceEntry<K, V> referenceEntry) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public void setPreviousInWriteQueue(ReferenceEntry<K, V> referenceEntry) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public void setValueReference(ValueReference<K, V> valueReference) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public void setWriteTime(long j) {
            throw new UnsupportedOperationException();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class AccessQueue<K, V> extends AbstractQueue<ReferenceEntry<K, V>> {
        final ReferenceEntry<K, V> a = new AbstractReferenceEntry<K, V>(this) { // from class: com.google.common.cache.LocalCache.AccessQueue.1
            ReferenceEntry<K, V> a = this;
            ReferenceEntry<K, V> b = this;

            @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
            public long getAccessTime() {
                return Long.MAX_VALUE;
            }

            @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
            public ReferenceEntry<K, V> getNextInAccessQueue() {
                return this.a;
            }

            @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
            public ReferenceEntry<K, V> getPreviousInAccessQueue() {
                return this.b;
            }

            @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
            public void setAccessTime(long j) {
            }

            @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
            public void setNextInAccessQueue(ReferenceEntry<K, V> referenceEntry) {
                this.a = referenceEntry;
            }

            @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
            public void setPreviousInAccessQueue(ReferenceEntry<K, V> referenceEntry) {
                this.b = referenceEntry;
            }
        };

        AccessQueue() {
        }

        @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
        public void clear() {
            ReferenceEntry<K, V> nextInAccessQueue = this.a.getNextInAccessQueue();
            while (true) {
                ReferenceEntry<K, V> referenceEntry = this.a;
                if (nextInAccessQueue == referenceEntry) {
                    referenceEntry.setNextInAccessQueue(referenceEntry);
                    ReferenceEntry<K, V> referenceEntry2 = this.a;
                    referenceEntry2.setPreviousInAccessQueue(referenceEntry2);
                    return;
                } else {
                    ReferenceEntry<K, V> nextInAccessQueue2 = nextInAccessQueue.getNextInAccessQueue();
                    LocalCache.b((ReferenceEntry) nextInAccessQueue);
                    nextInAccessQueue = nextInAccessQueue2;
                }
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            return ((ReferenceEntry) obj).getNextInAccessQueue() != NullEntry.INSTANCE;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return this.a.getNextInAccessQueue() == this.a;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<ReferenceEntry<K, V>> iterator() {
            return new AbstractSequentialIterator<ReferenceEntry<K, V>>(peek()) { // from class: com.google.common.cache.LocalCache.AccessQueue.2
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.google.common.collect.AbstractSequentialIterator
                public ReferenceEntry<K, V> a(ReferenceEntry<K, V> referenceEntry) {
                    ReferenceEntry<K, V> nextInAccessQueue = referenceEntry.getNextInAccessQueue();
                    if (nextInAccessQueue == AccessQueue.this.a) {
                        return null;
                    }
                    return nextInAccessQueue;
                }
            };
        }

        @Override // java.util.Queue
        public boolean offer(ReferenceEntry<K, V> referenceEntry) {
            LocalCache.a(referenceEntry.getPreviousInAccessQueue(), referenceEntry.getNextInAccessQueue());
            LocalCache.a(this.a.getPreviousInAccessQueue(), referenceEntry);
            LocalCache.a(referenceEntry, this.a);
            return true;
        }

        @Override // java.util.Queue
        public ReferenceEntry<K, V> peek() {
            ReferenceEntry<K, V> nextInAccessQueue = this.a.getNextInAccessQueue();
            if (nextInAccessQueue == this.a) {
                return null;
            }
            return nextInAccessQueue;
        }

        @Override // java.util.Queue
        public ReferenceEntry<K, V> poll() {
            ReferenceEntry<K, V> nextInAccessQueue = this.a.getNextInAccessQueue();
            if (nextInAccessQueue == this.a) {
                return null;
            }
            remove(nextInAccessQueue);
            return nextInAccessQueue;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean remove(Object obj) {
            ReferenceEntry referenceEntry = (ReferenceEntry) obj;
            ReferenceEntry<K, V> previousInAccessQueue = referenceEntry.getPreviousInAccessQueue();
            ReferenceEntry<K, V> nextInAccessQueue = referenceEntry.getNextInAccessQueue();
            LocalCache.a(previousInAccessQueue, nextInAccessQueue);
            LocalCache.b(referenceEntry);
            return nextInAccessQueue != NullEntry.INSTANCE;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            int i = 0;
            for (ReferenceEntry<K, V> nextInAccessQueue = this.a.getNextInAccessQueue(); nextInAccessQueue != this.a; nextInAccessQueue = nextInAccessQueue.getNextInAccessQueue()) {
                i++;
            }
            return i;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public enum EntryFactory {
        STRONG { // from class: com.google.common.cache.LocalCache.EntryFactory.1
            @Override // com.google.common.cache.LocalCache.EntryFactory
            <K, V> ReferenceEntry<K, V> a(Segment<K, V> segment, K k, int i, @NullableDecl ReferenceEntry<K, V> referenceEntry) {
                return new StrongEntry(k, i, referenceEntry);
            }
        },
        STRONG_ACCESS { // from class: com.google.common.cache.LocalCache.EntryFactory.2
            @Override // com.google.common.cache.LocalCache.EntryFactory
            <K, V> ReferenceEntry<K, V> a(Segment<K, V> segment, ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
                ReferenceEntry<K, V> a = super.a(segment, referenceEntry, referenceEntry2);
                a(referenceEntry, a);
                return a;
            }

            @Override // com.google.common.cache.LocalCache.EntryFactory
            <K, V> ReferenceEntry<K, V> a(Segment<K, V> segment, K k, int i, @NullableDecl ReferenceEntry<K, V> referenceEntry) {
                return new StrongAccessEntry(k, i, referenceEntry);
            }
        },
        STRONG_WRITE { // from class: com.google.common.cache.LocalCache.EntryFactory.3
            @Override // com.google.common.cache.LocalCache.EntryFactory
            <K, V> ReferenceEntry<K, V> a(Segment<K, V> segment, ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
                ReferenceEntry<K, V> a = super.a(segment, referenceEntry, referenceEntry2);
                b(referenceEntry, a);
                return a;
            }

            @Override // com.google.common.cache.LocalCache.EntryFactory
            <K, V> ReferenceEntry<K, V> a(Segment<K, V> segment, K k, int i, @NullableDecl ReferenceEntry<K, V> referenceEntry) {
                return new StrongWriteEntry(k, i, referenceEntry);
            }
        },
        STRONG_ACCESS_WRITE { // from class: com.google.common.cache.LocalCache.EntryFactory.4
            @Override // com.google.common.cache.LocalCache.EntryFactory
            <K, V> ReferenceEntry<K, V> a(Segment<K, V> segment, ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
                ReferenceEntry<K, V> a = super.a(segment, referenceEntry, referenceEntry2);
                a(referenceEntry, a);
                b(referenceEntry, a);
                return a;
            }

            @Override // com.google.common.cache.LocalCache.EntryFactory
            <K, V> ReferenceEntry<K, V> a(Segment<K, V> segment, K k, int i, @NullableDecl ReferenceEntry<K, V> referenceEntry) {
                return new StrongAccessWriteEntry(k, i, referenceEntry);
            }
        },
        WEAK { // from class: com.google.common.cache.LocalCache.EntryFactory.5
            @Override // com.google.common.cache.LocalCache.EntryFactory
            <K, V> ReferenceEntry<K, V> a(Segment<K, V> segment, K k, int i, @NullableDecl ReferenceEntry<K, V> referenceEntry) {
                return new WeakEntry(segment.h, k, i, referenceEntry);
            }
        },
        WEAK_ACCESS { // from class: com.google.common.cache.LocalCache.EntryFactory.6
            @Override // com.google.common.cache.LocalCache.EntryFactory
            <K, V> ReferenceEntry<K, V> a(Segment<K, V> segment, ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
                ReferenceEntry<K, V> a = super.a(segment, referenceEntry, referenceEntry2);
                a(referenceEntry, a);
                return a;
            }

            @Override // com.google.common.cache.LocalCache.EntryFactory
            <K, V> ReferenceEntry<K, V> a(Segment<K, V> segment, K k, int i, @NullableDecl ReferenceEntry<K, V> referenceEntry) {
                return new WeakAccessEntry(segment.h, k, i, referenceEntry);
            }
        },
        WEAK_WRITE { // from class: com.google.common.cache.LocalCache.EntryFactory.7
            @Override // com.google.common.cache.LocalCache.EntryFactory
            <K, V> ReferenceEntry<K, V> a(Segment<K, V> segment, ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
                ReferenceEntry<K, V> a = super.a(segment, referenceEntry, referenceEntry2);
                b(referenceEntry, a);
                return a;
            }

            @Override // com.google.common.cache.LocalCache.EntryFactory
            <K, V> ReferenceEntry<K, V> a(Segment<K, V> segment, K k, int i, @NullableDecl ReferenceEntry<K, V> referenceEntry) {
                return new WeakWriteEntry(segment.h, k, i, referenceEntry);
            }
        },
        WEAK_ACCESS_WRITE { // from class: com.google.common.cache.LocalCache.EntryFactory.8
            @Override // com.google.common.cache.LocalCache.EntryFactory
            <K, V> ReferenceEntry<K, V> a(Segment<K, V> segment, ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
                ReferenceEntry<K, V> a = super.a(segment, referenceEntry, referenceEntry2);
                a(referenceEntry, a);
                b(referenceEntry, a);
                return a;
            }

            @Override // com.google.common.cache.LocalCache.EntryFactory
            <K, V> ReferenceEntry<K, V> a(Segment<K, V> segment, K k, int i, @NullableDecl ReferenceEntry<K, V> referenceEntry) {
                return new WeakAccessWriteEntry(segment.h, k, i, referenceEntry);
            }
        };

        static final EntryFactory[] a = {STRONG, STRONG_ACCESS, STRONG_WRITE, STRONG_ACCESS_WRITE, WEAK, WEAK_ACCESS, WEAK_WRITE, WEAK_ACCESS_WRITE};

        /* JADX WARN: Multi-variable type inference failed */
        static EntryFactory a(Strength strength, boolean z, boolean z2) {
            return a[(strength == Strength.WEAK ? (char) 4 : (char) 0) | (z ? 1 : 0) | (z2 ? 2 : 0)];
        }

        <K, V> ReferenceEntry<K, V> a(Segment<K, V> segment, ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
            return a(segment, referenceEntry.getKey(), referenceEntry.getHash(), referenceEntry2);
        }

        abstract <K, V> ReferenceEntry<K, V> a(Segment<K, V> segment, K k, int i, @NullableDecl ReferenceEntry<K, V> referenceEntry);

        <K, V> void a(ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
            referenceEntry2.setAccessTime(referenceEntry.getAccessTime());
            LocalCache.a(referenceEntry.getPreviousInAccessQueue(), referenceEntry2);
            LocalCache.a(referenceEntry2, referenceEntry.getNextInAccessQueue());
            LocalCache.b((ReferenceEntry) referenceEntry);
        }

        <K, V> void b(ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
            referenceEntry2.setWriteTime(referenceEntry.getWriteTime());
            LocalCache.b(referenceEntry.getPreviousInWriteQueue(), referenceEntry2);
            LocalCache.b(referenceEntry2, referenceEntry.getNextInWriteQueue());
            LocalCache.c((ReferenceEntry) referenceEntry);
        }
    }

    /* loaded from: classes2.dex */
    final class EntryIterator extends LocalCache<K, V>.HashIterator<Map.Entry<K, V>> {
        EntryIterator(LocalCache localCache) {
            super();
        }

        @Override // com.google.common.cache.LocalCache.HashIterator, java.util.Iterator
        public Map.Entry<K, V> next() {
            return b();
        }
    }

    /* loaded from: classes2.dex */
    final class EntrySet extends LocalCache<K, V>.AbstractCacheSet<Map.Entry<K, V>> {
        EntrySet(ConcurrentMap<?, ?> concurrentMap) {
            super(LocalCache.this, concurrentMap);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            Map.Entry entry;
            Object key;
            Object obj2;
            return (obj instanceof Map.Entry) && (key = (entry = (Map.Entry) obj).getKey()) != null && (obj2 = LocalCache.this.get(key)) != null && LocalCache.this.f.equivalent(entry.getValue(), obj2);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new EntryIterator(LocalCache.this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            Map.Entry entry;
            Object key;
            return (obj instanceof Map.Entry) && (key = (entry = (Map.Entry) obj).getKey()) != null && LocalCache.this.remove(key, entry.getValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public abstract class HashIterator<T> implements Iterator<T> {
        int a;
        int b = -1;

        @MonotonicNonNullDecl
        Segment<K, V> c;

        @MonotonicNonNullDecl
        AtomicReferenceArray<ReferenceEntry<K, V>> d;

        @NullableDecl
        ReferenceEntry<K, V> e;

        @NullableDecl
        LocalCache<K, V>.WriteThroughEntry f;

        @NullableDecl
        LocalCache<K, V>.WriteThroughEntry g;

        HashIterator() {
            this.a = LocalCache.this.c.length - 1;
            a();
        }

        final void a() {
            this.f = null;
            if (c() || d()) {
                return;
            }
            while (true) {
                int i = this.a;
                if (i < 0) {
                    return;
                }
                Segment<K, V>[] segmentArr = LocalCache.this.c;
                this.a = i - 1;
                this.c = segmentArr[i];
                if (this.c.b != 0) {
                    this.d = this.c.f;
                    this.b = this.d.length() - 1;
                    if (d()) {
                        return;
                    }
                }
            }
        }

        boolean a(ReferenceEntry<K, V> referenceEntry) {
            boolean z;
            try {
                long read = LocalCache.this.p.read();
                K key = referenceEntry.getKey();
                Object a = LocalCache.this.a(referenceEntry, read);
                if (a != null) {
                    this.f = new WriteThroughEntry(key, a);
                    z = true;
                } else {
                    z = false;
                }
                return z;
            } finally {
                this.c.l();
            }
        }

        LocalCache<K, V>.WriteThroughEntry b() {
            LocalCache<K, V>.WriteThroughEntry writeThroughEntry = this.f;
            if (writeThroughEntry == null) {
                throw new NoSuchElementException();
            }
            this.g = writeThroughEntry;
            a();
            return this.g;
        }

        boolean c() {
            ReferenceEntry<K, V> referenceEntry = this.e;
            if (referenceEntry == null) {
                return false;
            }
            while (true) {
                this.e = referenceEntry.getNext();
                ReferenceEntry<K, V> referenceEntry2 = this.e;
                if (referenceEntry2 == null) {
                    return false;
                }
                if (a(referenceEntry2)) {
                    return true;
                }
                referenceEntry = this.e;
            }
        }

        boolean d() {
            while (true) {
                int i = this.b;
                if (i < 0) {
                    return false;
                }
                AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = this.d;
                this.b = i - 1;
                ReferenceEntry<K, V> referenceEntry = atomicReferenceArray.get(i);
                this.e = referenceEntry;
                if (referenceEntry != null && (a(this.e) || c())) {
                    return true;
                }
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f != null;
        }

        @Override // java.util.Iterator
        public abstract T next();

        @Override // java.util.Iterator
        public void remove() {
            Preconditions.checkState(this.g != null);
            LocalCache.this.remove(this.g.getKey());
            this.g = null;
        }
    }

    /* loaded from: classes2.dex */
    final class KeyIterator extends LocalCache<K, V>.HashIterator<K> {
        KeyIterator(LocalCache localCache) {
            super();
        }

        @Override // com.google.common.cache.LocalCache.HashIterator, java.util.Iterator
        public K next() {
            return b().getKey();
        }
    }

    /* loaded from: classes2.dex */
    final class KeySet extends LocalCache<K, V>.AbstractCacheSet<K> {
        KeySet(ConcurrentMap<?, ?> concurrentMap) {
            super(LocalCache.this, concurrentMap);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return this.a.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return new KeyIterator(LocalCache.this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            return this.a.remove(obj) != null;
        }
    }

    /* loaded from: classes2.dex */
    static final class LoadingSerializationProxy<K, V> extends ManualSerializationProxy<K, V> implements LoadingCache<K, V>, Serializable {
        private static final long serialVersionUID = 1;

        @MonotonicNonNullDecl
        transient LoadingCache<K, V> n;

        private void readObject(ObjectInputStream objectInputStream) {
            objectInputStream.defaultReadObject();
            this.n = (LoadingCache<K, V>) a().build(this.l);
        }

        private Object readResolve() {
            return this.n;
        }

        @Override // com.google.common.cache.LoadingCache, com.google.common.base.Function
        public final V apply(K k) {
            return this.n.apply(k);
        }

        @Override // com.google.common.cache.LoadingCache
        public V get(K k) {
            return this.n.get(k);
        }

        @Override // com.google.common.cache.LoadingCache
        public ImmutableMap<K, V> getAll(Iterable<? extends K> iterable) {
            return this.n.getAll(iterable);
        }

        @Override // com.google.common.cache.LoadingCache
        public V getUnchecked(K k) {
            return this.n.getUnchecked(k);
        }

        @Override // com.google.common.cache.LoadingCache
        public void refresh(K k) {
            this.n.refresh(k);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class LoadingValueReference<K, V> implements ValueReference<K, V> {
        volatile ValueReference<K, V> a;
        final SettableFuture<V> b;
        final Stopwatch c;

        public LoadingValueReference() {
            this(LocalCache.s());
        }

        public LoadingValueReference(ValueReference<K, V> valueReference) {
            this.b = SettableFuture.create();
            this.c = Stopwatch.createUnstarted();
            this.a = valueReference;
        }

        private ListenableFuture<V> fullyFailedFuture(Throwable th) {
            return Futures.immediateFailedFuture(th);
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public ValueReference<K, V> copyFor(ReferenceQueue<V> referenceQueue, @NullableDecl V v, ReferenceEntry<K, V> referenceEntry) {
            return this;
        }

        public long elapsedNanos() {
            return this.c.elapsed(TimeUnit.NANOSECONDS);
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public V get() {
            return this.a.get();
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public ReferenceEntry<K, V> getEntry() {
            return null;
        }

        public ValueReference<K, V> getOldValue() {
            return this.a;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public int getWeight() {
            return this.a.getWeight();
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public boolean isActive() {
            return this.a.isActive();
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public boolean isLoading() {
            return true;
        }

        public ListenableFuture<V> loadFuture(K k, CacheLoader<? super K, V> cacheLoader) {
            try {
                this.c.start();
                V v = this.a.get();
                if (v == null) {
                    V load = cacheLoader.load(k);
                    return set(load) ? this.b : Futures.immediateFuture(load);
                }
                ListenableFuture<V> reload = cacheLoader.reload(k, v);
                return reload == null ? Futures.immediateFuture(null) : Futures.transform(reload, new Function<V, V>() { // from class: com.google.common.cache.LocalCache.LoadingValueReference.1
                    @Override // com.google.common.base.Function
                    public V apply(V v2) {
                        LoadingValueReference.this.set(v2);
                        return v2;
                    }
                }, MoreExecutors.directExecutor());
            } catch (Throwable th) {
                ListenableFuture<V> fullyFailedFuture = setException(th) ? this.b : fullyFailedFuture(th);
                if (th instanceof InterruptedException) {
                    Thread.currentThread().interrupt();
                }
                return fullyFailedFuture;
            }
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public void notifyNewValue(@NullableDecl V v) {
            if (v != null) {
                set(v);
            } else {
                this.a = LocalCache.s();
            }
        }

        public boolean set(@NullableDecl V v) {
            return this.b.set(v);
        }

        public boolean setException(Throwable th) {
            return this.b.setException(th);
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public V waitForValue() {
            return (V) Uninterruptibles.getUninterruptibly(this.b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class LocalLoadingCache<K, V> extends LocalManualCache<K, V> implements LoadingCache<K, V> {
        private static final long serialVersionUID = 1;

        /* JADX INFO: Access modifiers changed from: package-private */
        public LocalLoadingCache(CacheBuilder<? super K, ? super V> cacheBuilder, CacheLoader<? super K, V> cacheLoader) {
            super();
        }

        @Override // com.google.common.cache.LoadingCache, com.google.common.base.Function
        public final V apply(K k) {
            return getUnchecked(k);
        }

        @Override // com.google.common.cache.LoadingCache
        public V get(K k) {
            return this.a.a((LocalCache<K, V>) k);
        }

        @Override // com.google.common.cache.LoadingCache
        public ImmutableMap<K, V> getAll(Iterable<? extends K> iterable) {
            return this.a.a((Iterable) iterable);
        }

        @Override // com.google.common.cache.LoadingCache
        public V getUnchecked(K k) {
            try {
                return get(k);
            } catch (ExecutionException e) {
                throw new UncheckedExecutionException(e.getCause());
            }
        }

        @Override // com.google.common.cache.LoadingCache
        public void refresh(K k) {
            this.a.c((LocalCache<K, V>) k);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class LocalManualCache<K, V> implements Cache<K, V>, Serializable {
        private static final long serialVersionUID = 1;
        final LocalCache<K, V> a;

        /* JADX INFO: Access modifiers changed from: package-private */
        public LocalManualCache(CacheBuilder<? super K, ? super V> cacheBuilder) {
            this(new LocalCache(cacheBuilder, null));
        }

        private LocalManualCache(LocalCache<K, V> localCache) {
            this.a = localCache;
        }

        @Override // com.google.common.cache.Cache
        public ConcurrentMap<K, V> asMap() {
            return this.a;
        }

        @Override // com.google.common.cache.Cache
        public void cleanUp() {
            this.a.cleanUp();
        }

        @Override // com.google.common.cache.Cache
        public V get(K k, final Callable<? extends V> callable) {
            Preconditions.checkNotNull(callable);
            return this.a.a((LocalCache<K, V>) k, (CacheLoader<? super LocalCache<K, V>, V>) new CacheLoader<Object, V>(this) { // from class: com.google.common.cache.LocalCache.LocalManualCache.1
                @Override // com.google.common.cache.CacheLoader
                public V load(Object obj) {
                    return (V) callable.call();
                }
            });
        }

        @Override // com.google.common.cache.Cache
        public ImmutableMap<K, V> getAllPresent(Iterable<?> iterable) {
            return this.a.b(iterable);
        }

        @Override // com.google.common.cache.Cache
        @NullableDecl
        public V getIfPresent(Object obj) {
            return this.a.getIfPresent(obj);
        }

        @Override // com.google.common.cache.Cache
        public void invalidate(Object obj) {
            Preconditions.checkNotNull(obj);
            this.a.remove(obj);
        }

        @Override // com.google.common.cache.Cache
        public void invalidateAll() {
            this.a.clear();
        }

        @Override // com.google.common.cache.Cache
        public void invalidateAll(Iterable<?> iterable) {
            this.a.c(iterable);
        }

        @Override // com.google.common.cache.Cache
        public void put(K k, V v) {
            this.a.put(k, v);
        }

        @Override // com.google.common.cache.Cache
        public void putAll(Map<? extends K, ? extends V> map) {
            this.a.putAll(map);
        }

        @Override // com.google.common.cache.Cache
        public long size() {
            return this.a.e();
        }

        @Override // com.google.common.cache.Cache
        public CacheStats stats() {
            AbstractCache.SimpleStatsCounter simpleStatsCounter = new AbstractCache.SimpleStatsCounter();
            simpleStatsCounter.incrementBy(this.a.r);
            for (Segment<K, V> segment : this.a.c) {
                simpleStatsCounter.incrementBy(segment.n);
            }
            return simpleStatsCounter.snapshot();
        }
    }

    /* loaded from: classes2.dex */
    static class ManualSerializationProxy<K, V> extends ForwardingCache<K, V> implements Serializable {
        private static final long serialVersionUID = 1;
        final Strength a;
        final Strength b;
        final Equivalence<Object> c;
        final Equivalence<Object> d;
        final long e;
        final long f;
        final long g;
        final Weigher<K, V> h;
        final int i;
        final RemovalListener<? super K, ? super V> j;

        @NullableDecl
        final Ticker k;
        final CacheLoader<? super K, V> l;

        @MonotonicNonNullDecl
        transient Cache<K, V> m;

        private ManualSerializationProxy(Strength strength, Strength strength2, Equivalence<Object> equivalence, Equivalence<Object> equivalence2, long j, long j2, long j3, Weigher<K, V> weigher, int i, RemovalListener<? super K, ? super V> removalListener, Ticker ticker, CacheLoader<? super K, V> cacheLoader) {
            this.a = strength;
            this.b = strength2;
            this.c = equivalence;
            this.d = equivalence2;
            this.e = j;
            this.f = j2;
            this.g = j3;
            this.h = weigher;
            this.i = i;
            this.j = removalListener;
            this.k = (ticker == Ticker.systemTicker() || ticker == CacheBuilder.t) ? null : ticker;
            this.l = cacheLoader;
        }

        private void readObject(ObjectInputStream objectInputStream) {
            objectInputStream.defaultReadObject();
            this.m = (Cache<K, V>) a().build();
        }

        private Object readResolve() {
            return this.m;
        }

        CacheBuilder<K, V> a() {
            CacheBuilder<K, V> cacheBuilder = (CacheBuilder<K, V>) CacheBuilder.newBuilder().a(this.a).b(this.b).a(this.c).b(this.d).concurrencyLevel(this.i).removalListener(this.j);
            cacheBuilder.a = false;
            long j = this.e;
            if (j > 0) {
                cacheBuilder.expireAfterWrite(j, TimeUnit.NANOSECONDS);
            }
            long j2 = this.f;
            if (j2 > 0) {
                cacheBuilder.expireAfterAccess(j2, TimeUnit.NANOSECONDS);
            }
            Weigher weigher = this.h;
            if (weigher != CacheBuilder.OneWeigher.INSTANCE) {
                cacheBuilder.weigher(weigher);
                long j3 = this.g;
                if (j3 != -1) {
                    cacheBuilder.maximumWeight(j3);
                }
            } else {
                long j4 = this.g;
                if (j4 != -1) {
                    cacheBuilder.maximumSize(j4);
                }
            }
            Ticker ticker = this.k;
            if (ticker != null) {
                cacheBuilder.ticker(ticker);
            }
            return cacheBuilder;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.cache.ForwardingCache, com.google.common.collect.ForwardingObject
        public Cache<K, V> delegate() {
            return this.m;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public enum NullEntry implements ReferenceEntry<Object, Object> {
        INSTANCE;

        @Override // com.google.common.cache.ReferenceEntry
        public long getAccessTime() {
            return 0L;
        }

        @Override // com.google.common.cache.ReferenceEntry
        public int getHash() {
            return 0;
        }

        @Override // com.google.common.cache.ReferenceEntry
        public Object getKey() {
            return null;
        }

        @Override // com.google.common.cache.ReferenceEntry
        public ReferenceEntry<Object, Object> getNext() {
            return null;
        }

        @Override // com.google.common.cache.ReferenceEntry
        public ReferenceEntry<Object, Object> getNextInAccessQueue() {
            return this;
        }

        @Override // com.google.common.cache.ReferenceEntry
        public ReferenceEntry<Object, Object> getNextInWriteQueue() {
            return this;
        }

        @Override // com.google.common.cache.ReferenceEntry
        public ReferenceEntry<Object, Object> getPreviousInAccessQueue() {
            return this;
        }

        @Override // com.google.common.cache.ReferenceEntry
        public ReferenceEntry<Object, Object> getPreviousInWriteQueue() {
            return this;
        }

        @Override // com.google.common.cache.ReferenceEntry
        public ValueReference<Object, Object> getValueReference() {
            return null;
        }

        @Override // com.google.common.cache.ReferenceEntry
        public long getWriteTime() {
            return 0L;
        }

        @Override // com.google.common.cache.ReferenceEntry
        public void setAccessTime(long j) {
        }

        @Override // com.google.common.cache.ReferenceEntry
        public void setNextInAccessQueue(ReferenceEntry<Object, Object> referenceEntry) {
        }

        @Override // com.google.common.cache.ReferenceEntry
        public void setNextInWriteQueue(ReferenceEntry<Object, Object> referenceEntry) {
        }

        @Override // com.google.common.cache.ReferenceEntry
        public void setPreviousInAccessQueue(ReferenceEntry<Object, Object> referenceEntry) {
        }

        @Override // com.google.common.cache.ReferenceEntry
        public void setPreviousInWriteQueue(ReferenceEntry<Object, Object> referenceEntry) {
        }

        @Override // com.google.common.cache.ReferenceEntry
        public void setValueReference(ValueReference<Object, Object> valueReference) {
        }

        @Override // com.google.common.cache.ReferenceEntry
        public void setWriteTime(long j) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class Segment<K, V> extends ReentrantLock {

        @Weak
        final LocalCache<K, V> a;
        volatile int b;

        @GuardedBy("this")
        long c;
        int d;
        int e;

        @MonotonicNonNullDecl
        volatile AtomicReferenceArray<ReferenceEntry<K, V>> f;
        final long g;

        @NullableDecl
        final ReferenceQueue<K> h;

        @NullableDecl
        final ReferenceQueue<V> i;
        final Queue<ReferenceEntry<K, V>> j;
        final AtomicInteger k = new AtomicInteger();

        @GuardedBy("this")
        final Queue<ReferenceEntry<K, V>> l;

        @GuardedBy("this")
        final Queue<ReferenceEntry<K, V>> m;
        final AbstractCache.StatsCounter n;

        Segment(LocalCache<K, V> localCache, int i, long j, AbstractCache.StatsCounter statsCounter) {
            this.a = localCache;
            this.g = j;
            this.n = (AbstractCache.StatsCounter) Preconditions.checkNotNull(statsCounter);
            a(b(i));
            this.h = localCache.m() ? new ReferenceQueue<>() : null;
            this.i = localCache.n() ? new ReferenceQueue<>() : null;
            this.j = localCache.l() ? new ConcurrentLinkedQueue<>() : LocalCache.q();
            this.l = localCache.p() ? new WriteQueue<>() : LocalCache.q();
            this.m = localCache.l() ? new AccessQueue<>() : LocalCache.q();
        }

        @NullableDecl
        LoadingValueReference<K, V> a(K k, int i, boolean z) {
            lock();
            try {
                long read = this.a.p.read();
                b(read);
                AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = this.f;
                int length = (atomicReferenceArray.length() - 1) & i;
                ReferenceEntry<K, V> referenceEntry = (ReferenceEntry) atomicReferenceArray.get(length);
                for (ReferenceEntry referenceEntry2 = referenceEntry; referenceEntry2 != null; referenceEntry2 = referenceEntry2.getNext()) {
                    Object key = referenceEntry2.getKey();
                    if (referenceEntry2.getHash() == i && key != null && this.a.e.equivalent(k, key)) {
                        ValueReference<K, V> valueReference = referenceEntry2.getValueReference();
                        if (!valueReference.isLoading() && (!z || read - referenceEntry2.getWriteTime() >= this.a.m)) {
                            this.d++;
                            LoadingValueReference<K, V> loadingValueReference = new LoadingValueReference<>(valueReference);
                            referenceEntry2.setValueReference(loadingValueReference);
                            return loadingValueReference;
                        }
                        return null;
                    }
                }
                this.d++;
                LoadingValueReference<K, V> loadingValueReference2 = new LoadingValueReference<>();
                ReferenceEntry<K, V> a = a((Segment<K, V>) k, i, (ReferenceEntry<Segment<K, V>, V>) referenceEntry);
                a.setValueReference(loadingValueReference2);
                atomicReferenceArray.set(length, a);
                return loadingValueReference2;
            } finally {
                unlock();
                m();
            }
        }

        ReferenceEntry<K, V> a(int i) {
            return this.f.get(i & (r0.length() - 1));
        }

        @GuardedBy("this")
        ReferenceEntry<K, V> a(ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
            if (referenceEntry.getKey() == null) {
                return null;
            }
            ValueReference<K, V> valueReference = referenceEntry.getValueReference();
            V v = valueReference.get();
            if (v == null && valueReference.isActive()) {
                return null;
            }
            ReferenceEntry<K, V> a = this.a.q.a(this, referenceEntry, referenceEntry2);
            a.setValueReference(valueReference.copyFor(this.i, v, a));
            return a;
        }

        @NullableDecl
        @GuardedBy("this")
        ReferenceEntry<K, V> a(ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2, @NullableDecl K k, int i, V v, ValueReference<K, V> valueReference, RemovalCause removalCause) {
            a(k, i, v, valueReference.getWeight(), removalCause);
            this.l.remove(referenceEntry2);
            this.m.remove(referenceEntry2);
            if (!valueReference.isLoading()) {
                return b(referenceEntry, referenceEntry2);
            }
            valueReference.notifyNewValue(null);
            return referenceEntry;
        }

        @NullableDecl
        ReferenceEntry<K, V> a(Object obj, int i, long j) {
            ReferenceEntry<K, V> c = c(obj, i);
            if (c == null) {
                return null;
            }
            if (!this.a.b(c, j)) {
                return c;
            }
            d(j);
            return null;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @GuardedBy("this")
        ReferenceEntry<K, V> a(K k, int i, @NullableDecl ReferenceEntry<K, V> referenceEntry) {
            return this.a.q.a(this, Preconditions.checkNotNull(k), i, referenceEntry);
        }

        ListenableFuture<V> a(final K k, final int i, final LoadingValueReference<K, V> loadingValueReference, CacheLoader<? super K, V> cacheLoader) {
            final ListenableFuture<V> loadFuture = loadingValueReference.loadFuture(k, cacheLoader);
            loadFuture.addListener(new Runnable() { // from class: com.google.common.cache.LocalCache.Segment.1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        Segment.this.a((Segment) k, i, (LoadingValueReference<Segment, V>) loadingValueReference, loadFuture);
                    } catch (Throwable th) {
                        LocalCache.w.log(Level.WARNING, "Exception thrown during refresh", th);
                        loadingValueReference.setException(th);
                    }
                }
            }, MoreExecutors.directExecutor());
            return loadFuture;
        }

        V a(ReferenceEntry<K, V> referenceEntry, long j) {
            if (referenceEntry.getKey() == null) {
                o();
                return null;
            }
            V v = referenceEntry.getValueReference().get();
            if (v == null) {
                o();
                return null;
            }
            if (!this.a.b(referenceEntry, j)) {
                return v;
            }
            d(j);
            return null;
        }

        V a(ReferenceEntry<K, V> referenceEntry, K k, int i, V v, long j, CacheLoader<? super K, V> cacheLoader) {
            V a;
            return (!this.a.j() || j - referenceEntry.getWriteTime() <= this.a.m || referenceEntry.getValueReference().isLoading() || (a = a((Segment<K, V>) k, i, (CacheLoader<? super Segment<K, V>, V>) cacheLoader, true)) == null) ? v : a;
        }

        V a(ReferenceEntry<K, V> referenceEntry, K k, ValueReference<K, V> valueReference) {
            if (!valueReference.isLoading()) {
                throw new AssertionError();
            }
            Preconditions.checkState(!Thread.holdsLock(referenceEntry), "Recursive load of: %s", k);
            try {
                V waitForValue = valueReference.waitForValue();
                if (waitForValue != null) {
                    c(referenceEntry, this.a.p.read());
                    return waitForValue;
                }
                throw new CacheLoader.InvalidCacheLoadException("CacheLoader returned null for key " + k + ".");
            } finally {
                this.n.recordMisses(1);
            }
        }

        V a(K k, int i, CacheLoader<? super K, V> cacheLoader) {
            ReferenceEntry<K, V> c;
            Preconditions.checkNotNull(k);
            Preconditions.checkNotNull(cacheLoader);
            try {
                try {
                    if (this.b != 0 && (c = c(k, i)) != null) {
                        long read = this.a.p.read();
                        V a = a(c, read);
                        if (a != null) {
                            c(c, read);
                            this.n.recordHits(1);
                            return a(c, k, i, a, read, cacheLoader);
                        }
                        ValueReference<K, V> valueReference = c.getValueReference();
                        if (valueReference.isLoading()) {
                            return a((ReferenceEntry<ReferenceEntry<K, V>, V>) c, (ReferenceEntry<K, V>) k, (ValueReference<ReferenceEntry<K, V>, V>) valueReference);
                        }
                    }
                    return b((Segment<K, V>) k, i, (CacheLoader<? super Segment<K, V>, V>) cacheLoader);
                } catch (ExecutionException e) {
                    Throwable cause = e.getCause();
                    if (cause instanceof Error) {
                        throw new ExecutionError((Error) cause);
                    }
                    if (cause instanceof RuntimeException) {
                        throw new UncheckedExecutionException(cause);
                    }
                    throw e;
                }
            } finally {
                l();
            }
        }

        @NullableDecl
        V a(K k, int i, CacheLoader<? super K, V> cacheLoader, boolean z) {
            LoadingValueReference<K, V> a = a((Segment<K, V>) k, i, z);
            if (a == null) {
                return null;
            }
            ListenableFuture<V> a2 = a((Segment<K, V>) k, i, (LoadingValueReference<Segment<K, V>, V>) a, (CacheLoader<? super Segment<K, V>, V>) cacheLoader);
            if (a2.isDone()) {
                try {
                    return (V) Uninterruptibles.getUninterruptibly(a2);
                } catch (Throwable unused) {
                }
            }
            return null;
        }

        V a(K k, int i, LoadingValueReference<K, V> loadingValueReference, ListenableFuture<V> listenableFuture) {
            V v;
            try {
                v = (V) Uninterruptibles.getUninterruptibly(listenableFuture);
                try {
                    if (v == null) {
                        throw new CacheLoader.InvalidCacheLoadException("CacheLoader returned null for key " + k + ".");
                    }
                    this.n.recordLoadSuccess(loadingValueReference.elapsedNanos());
                    a((Segment<K, V>) k, i, (LoadingValueReference<Segment<K, V>, LoadingValueReference<K, V>>) loadingValueReference, (LoadingValueReference<K, V>) v);
                    if (v == null) {
                        this.n.recordLoadException(loadingValueReference.elapsedNanos());
                        a((Segment<K, V>) k, i, (LoadingValueReference<Segment<K, V>, V>) loadingValueReference);
                    }
                    return v;
                } catch (Throwable th) {
                    th = th;
                    if (v == null) {
                        this.n.recordLoadException(loadingValueReference.elapsedNanos());
                        a((Segment<K, V>) k, i, (LoadingValueReference<Segment<K, V>, V>) loadingValueReference);
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                v = null;
            }
        }

        @NullableDecl
        V a(K k, int i, V v, boolean z) {
            int i2;
            lock();
            try {
                long read = this.a.p.read();
                b(read);
                if (this.b + 1 > this.e) {
                    j();
                }
                AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = this.f;
                int length = i & (atomicReferenceArray.length() - 1);
                ReferenceEntry<K, V> referenceEntry = atomicReferenceArray.get(length);
                ReferenceEntry<K, V> referenceEntry2 = referenceEntry;
                while (true) {
                    if (referenceEntry2 == null) {
                        this.d++;
                        referenceEntry2 = a((Segment<K, V>) k, i, (ReferenceEntry<Segment<K, V>, V>) referenceEntry);
                        a((ReferenceEntry<ReferenceEntry<K, V>, K>) referenceEntry2, (ReferenceEntry<K, V>) k, (K) v, read);
                        atomicReferenceArray.set(length, referenceEntry2);
                        this.b++;
                        break;
                    }
                    K key = referenceEntry2.getKey();
                    if (referenceEntry2.getHash() == i && key != null && this.a.e.equivalent(k, key)) {
                        ValueReference<K, V> valueReference = referenceEntry2.getValueReference();
                        V v2 = valueReference.get();
                        if (v2 != null) {
                            if (z) {
                                b(referenceEntry2, read);
                            } else {
                                this.d++;
                                a(k, i, v2, valueReference.getWeight(), RemovalCause.REPLACED);
                                a((ReferenceEntry<ReferenceEntry<K, V>, K>) referenceEntry2, (ReferenceEntry<K, V>) k, (K) v, read);
                                a(referenceEntry2);
                            }
                            return v2;
                        }
                        this.d++;
                        if (valueReference.isActive()) {
                            a(k, i, v2, valueReference.getWeight(), RemovalCause.COLLECTED);
                            a((ReferenceEntry<ReferenceEntry<K, V>, K>) referenceEntry2, (ReferenceEntry<K, V>) k, (K) v, read);
                            i2 = this.b;
                        } else {
                            a((ReferenceEntry<ReferenceEntry<K, V>, K>) referenceEntry2, (ReferenceEntry<K, V>) k, (K) v, read);
                            i2 = this.b + 1;
                        }
                        this.b = i2;
                    } else {
                        referenceEntry2 = referenceEntry2.getNext();
                    }
                }
                a(referenceEntry2);
                return null;
            } finally {
                unlock();
                m();
            }
        }

        void a() {
            c(this.a.p.read());
            n();
        }

        @GuardedBy("this")
        void a(long j) {
            ReferenceEntry<K, V> peek;
            ReferenceEntry<K, V> peek2;
            g();
            do {
                peek = this.l.peek();
                if (peek == null || !this.a.b(peek, j)) {
                    do {
                        peek2 = this.m.peek();
                        if (peek2 == null || !this.a.b(peek2, j)) {
                            return;
                        }
                    } while (a((ReferenceEntry) peek2, peek2.getHash(), RemovalCause.EXPIRED));
                    throw new AssertionError();
                }
            } while (a((ReferenceEntry) peek, peek.getHash(), RemovalCause.EXPIRED));
            throw new AssertionError();
        }

        @GuardedBy("this")
        void a(ReferenceEntry<K, V> referenceEntry) {
            if (this.a.b()) {
                g();
                if (referenceEntry.getValueReference().getWeight() > this.g && !a((ReferenceEntry) referenceEntry, referenceEntry.getHash(), RemovalCause.SIZE)) {
                    throw new AssertionError();
                }
                while (this.c > this.g) {
                    ReferenceEntry<K, V> k = k();
                    if (!a((ReferenceEntry) k, k.getHash(), RemovalCause.SIZE)) {
                        throw new AssertionError();
                    }
                }
            }
        }

        @GuardedBy("this")
        void a(ReferenceEntry<K, V> referenceEntry, int i, long j) {
            g();
            this.c += i;
            if (this.a.g()) {
                referenceEntry.setAccessTime(j);
            }
            if (this.a.i()) {
                referenceEntry.setWriteTime(j);
            }
            this.m.add(referenceEntry);
            this.l.add(referenceEntry);
        }

        @GuardedBy("this")
        void a(ReferenceEntry<K, V> referenceEntry, K k, V v, long j) {
            ValueReference<K, V> valueReference = referenceEntry.getValueReference();
            int weigh = this.a.j.weigh(k, v);
            Preconditions.checkState(weigh >= 0, "Weights must be non-negative");
            referenceEntry.setValueReference(this.a.h.a(this, referenceEntry, v, weigh));
            a((ReferenceEntry) referenceEntry, weigh, j);
            valueReference.notifyNewValue(v);
        }

        @GuardedBy("this")
        void a(@NullableDecl K k, int i, @NullableDecl V v, int i2, RemovalCause removalCause) {
            this.c -= i2;
            if (removalCause.a()) {
                this.n.recordEviction();
            }
            if (this.a.n != LocalCache.y) {
                this.a.n.offer(RemovalNotification.create(k, v, removalCause));
            }
        }

        void a(AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray) {
            this.e = (atomicReferenceArray.length() * 3) / 4;
            if (!this.a.a()) {
                int i = this.e;
                if (i == this.g) {
                    this.e = i + 1;
                }
            }
            this.f = atomicReferenceArray;
        }

        boolean a(ReferenceEntry<K, V> referenceEntry, int i) {
            lock();
            try {
                AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = this.f;
                int length = (atomicReferenceArray.length() - 1) & i;
                ReferenceEntry<K, V> referenceEntry2 = atomicReferenceArray.get(length);
                for (ReferenceEntry<K, V> referenceEntry3 = referenceEntry2; referenceEntry3 != null; referenceEntry3 = referenceEntry3.getNext()) {
                    if (referenceEntry3 == referenceEntry) {
                        this.d++;
                        ReferenceEntry<K, V> a = a(referenceEntry2, referenceEntry3, referenceEntry3.getKey(), i, referenceEntry3.getValueReference().get(), referenceEntry3.getValueReference(), RemovalCause.COLLECTED);
                        int i2 = this.b - 1;
                        atomicReferenceArray.set(length, a);
                        this.b = i2;
                        return true;
                    }
                }
                return false;
            } finally {
                unlock();
                m();
            }
        }

        @VisibleForTesting
        @GuardedBy("this")
        boolean a(ReferenceEntry<K, V> referenceEntry, int i, RemovalCause removalCause) {
            AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = this.f;
            int length = (atomicReferenceArray.length() - 1) & i;
            ReferenceEntry<K, V> referenceEntry2 = atomicReferenceArray.get(length);
            for (ReferenceEntry<K, V> referenceEntry3 = referenceEntry2; referenceEntry3 != null; referenceEntry3 = referenceEntry3.getNext()) {
                if (referenceEntry3 == referenceEntry) {
                    this.d++;
                    ReferenceEntry<K, V> a = a(referenceEntry2, referenceEntry3, referenceEntry3.getKey(), i, referenceEntry3.getValueReference().get(), referenceEntry3.getValueReference(), removalCause);
                    int i2 = this.b - 1;
                    atomicReferenceArray.set(length, a);
                    this.b = i2;
                    return true;
                }
            }
            return false;
        }

        boolean a(Object obj, int i) {
            try {
                if (this.b == 0) {
                    return false;
                }
                ReferenceEntry<K, V> a = a(obj, i, this.a.p.read());
                if (a == null) {
                    return false;
                }
                return a.getValueReference().get() != null;
            } finally {
                l();
            }
        }

        boolean a(K k, int i, LoadingValueReference<K, V> loadingValueReference) {
            lock();
            try {
                AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = this.f;
                int length = (atomicReferenceArray.length() - 1) & i;
                ReferenceEntry<K, V> referenceEntry = atomicReferenceArray.get(length);
                ReferenceEntry<K, V> referenceEntry2 = referenceEntry;
                while (true) {
                    if (referenceEntry2 == null) {
                        break;
                    }
                    K key = referenceEntry2.getKey();
                    if (referenceEntry2.getHash() != i || key == null || !this.a.e.equivalent(k, key)) {
                        referenceEntry2 = referenceEntry2.getNext();
                    } else if (referenceEntry2.getValueReference() == loadingValueReference) {
                        if (loadingValueReference.isActive()) {
                            referenceEntry2.setValueReference(loadingValueReference.getOldValue());
                        } else {
                            atomicReferenceArray.set(length, b(referenceEntry, referenceEntry2));
                        }
                        return true;
                    }
                }
                return false;
            } finally {
                unlock();
                m();
            }
        }

        boolean a(K k, int i, LoadingValueReference<K, V> loadingValueReference, V v) {
            lock();
            try {
                long read = this.a.p.read();
                b(read);
                int i2 = this.b + 1;
                if (i2 > this.e) {
                    j();
                    i2 = this.b + 1;
                }
                int i3 = i2;
                AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = this.f;
                int length = i & (atomicReferenceArray.length() - 1);
                ReferenceEntry<K, V> referenceEntry = atomicReferenceArray.get(length);
                ReferenceEntry<K, V> referenceEntry2 = referenceEntry;
                while (true) {
                    if (referenceEntry2 == null) {
                        this.d++;
                        referenceEntry2 = a((Segment<K, V>) k, i, (ReferenceEntry<Segment<K, V>, V>) referenceEntry);
                        a((ReferenceEntry<ReferenceEntry<K, V>, K>) referenceEntry2, (ReferenceEntry<K, V>) k, (K) v, read);
                        atomicReferenceArray.set(length, referenceEntry2);
                        this.b = i3;
                        break;
                    }
                    K key = referenceEntry2.getKey();
                    if (referenceEntry2.getHash() == i && key != null && this.a.e.equivalent(k, key)) {
                        ValueReference<K, V> valueReference = referenceEntry2.getValueReference();
                        V v2 = valueReference.get();
                        if (loadingValueReference != valueReference && (v2 != null || valueReference == LocalCache.x)) {
                            a(k, i, v, 0, RemovalCause.REPLACED);
                            return false;
                        }
                        this.d++;
                        if (loadingValueReference.isActive()) {
                            a(k, i, v2, loadingValueReference.getWeight(), v2 == null ? RemovalCause.COLLECTED : RemovalCause.REPLACED);
                            i3--;
                        }
                        a((ReferenceEntry<ReferenceEntry<K, V>, K>) referenceEntry2, (ReferenceEntry<K, V>) k, (K) v, read);
                        this.b = i3;
                    } else {
                        referenceEntry2 = referenceEntry2.getNext();
                    }
                }
                a(referenceEntry2);
                return true;
            } finally {
                unlock();
                m();
            }
        }

        boolean a(K k, int i, ValueReference<K, V> valueReference) {
            lock();
            try {
                AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = this.f;
                int length = (atomicReferenceArray.length() - 1) & i;
                ReferenceEntry<K, V> referenceEntry = atomicReferenceArray.get(length);
                for (ReferenceEntry<K, V> referenceEntry2 = referenceEntry; referenceEntry2 != null; referenceEntry2 = referenceEntry2.getNext()) {
                    K key = referenceEntry2.getKey();
                    if (referenceEntry2.getHash() == i && key != null && this.a.e.equivalent(k, key)) {
                        if (referenceEntry2.getValueReference() != valueReference) {
                            unlock();
                            if (!isHeldByCurrentThread()) {
                                m();
                            }
                            return false;
                        }
                        this.d++;
                        ReferenceEntry<K, V> a = a(referenceEntry, referenceEntry2, key, i, valueReference.get(), valueReference, RemovalCause.COLLECTED);
                        int i2 = this.b - 1;
                        atomicReferenceArray.set(length, a);
                        this.b = i2;
                        return true;
                    }
                }
                unlock();
                if (!isHeldByCurrentThread()) {
                    m();
                }
                return false;
            } finally {
                unlock();
                if (!isHeldByCurrentThread()) {
                    m();
                }
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:12:0x0038, code lost:
        
            r10 = r6.getValueReference();
            r9 = r10.get();
         */
        /* JADX WARN: Code restructure failed: missing block: B:13:0x0048, code lost:
        
            if (r12.a.f.equivalent(r15, r9) == false) goto L14;
         */
        /* JADX WARN: Code restructure failed: missing block: B:14:0x004a, code lost:
        
            r13 = com.google.common.cache.RemovalCause.EXPLICIT;
         */
        /* JADX WARN: Code restructure failed: missing block: B:15:0x0057, code lost:
        
            r12.d++;
            r14 = a(r5, r6, r7, r14, r9, r10, r13);
            r15 = r12.b - 1;
            r0.set(r1, r14);
            r12.b = r15;
         */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x006d, code lost:
        
            if (r13 != com.google.common.cache.RemovalCause.EXPLICIT) goto L21;
         */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x0070, code lost:
        
            r2 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:19:0x0077, code lost:
        
            return r2;
         */
        /* JADX WARN: Code restructure failed: missing block: B:22:0x004d, code lost:
        
            if (r9 != null) goto L24;
         */
        /* JADX WARN: Code restructure failed: missing block: B:24:0x0053, code lost:
        
            if (r10.isActive() == false) goto L24;
         */
        /* JADX WARN: Code restructure failed: missing block: B:25:0x0055, code lost:
        
            r13 = com.google.common.cache.RemovalCause.COLLECTED;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        boolean a(java.lang.Object r13, int r14, java.lang.Object r15) {
            /*
                r12 = this;
                r12.lock()
                com.google.common.cache.LocalCache<K, V> r0 = r12.a     // Catch: java.lang.Throwable -> L84
                com.google.common.base.Ticker r0 = r0.p     // Catch: java.lang.Throwable -> L84
                long r0 = r0.read()     // Catch: java.lang.Throwable -> L84
                r12.b(r0)     // Catch: java.lang.Throwable -> L84
                java.util.concurrent.atomic.AtomicReferenceArray<com.google.common.cache.ReferenceEntry<K, V>> r0 = r12.f     // Catch: java.lang.Throwable -> L84
                int r1 = r0.length()     // Catch: java.lang.Throwable -> L84
                r2 = 1
                int r1 = r1 - r2
                r1 = r1 & r14
                java.lang.Object r3 = r0.get(r1)     // Catch: java.lang.Throwable -> L84
                r5 = r3
                com.google.common.cache.ReferenceEntry r5 = (com.google.common.cache.ReferenceEntry) r5     // Catch: java.lang.Throwable -> L84
                r6 = r5
            L1f:
                r3 = 0
                if (r6 == 0) goto L78
                java.lang.Object r7 = r6.getKey()     // Catch: java.lang.Throwable -> L84
                int r4 = r6.getHash()     // Catch: java.lang.Throwable -> L84
                if (r4 != r14) goto L7f
                if (r7 == 0) goto L7f
                com.google.common.cache.LocalCache<K, V> r4 = r12.a     // Catch: java.lang.Throwable -> L84
                com.google.common.base.Equivalence<java.lang.Object> r4 = r4.e     // Catch: java.lang.Throwable -> L84
                boolean r4 = r4.equivalent(r13, r7)     // Catch: java.lang.Throwable -> L84
                if (r4 == 0) goto L7f
                com.google.common.cache.LocalCache$ValueReference r10 = r6.getValueReference()     // Catch: java.lang.Throwable -> L84
                java.lang.Object r9 = r10.get()     // Catch: java.lang.Throwable -> L84
                com.google.common.cache.LocalCache<K, V> r13 = r12.a     // Catch: java.lang.Throwable -> L84
                com.google.common.base.Equivalence<java.lang.Object> r13 = r13.f     // Catch: java.lang.Throwable -> L84
                boolean r13 = r13.equivalent(r15, r9)     // Catch: java.lang.Throwable -> L84
                if (r13 == 0) goto L4d
                com.google.common.cache.RemovalCause r13 = com.google.common.cache.RemovalCause.EXPLICIT     // Catch: java.lang.Throwable -> L84
                goto L57
            L4d:
                if (r9 != 0) goto L78
                boolean r13 = r10.isActive()     // Catch: java.lang.Throwable -> L84
                if (r13 == 0) goto L78
                com.google.common.cache.RemovalCause r13 = com.google.common.cache.RemovalCause.COLLECTED     // Catch: java.lang.Throwable -> L84
            L57:
                int r15 = r12.d     // Catch: java.lang.Throwable -> L84
                int r15 = r15 + r2
                r12.d = r15     // Catch: java.lang.Throwable -> L84
                r4 = r12
                r8 = r14
                r11 = r13
                com.google.common.cache.ReferenceEntry r14 = r4.a(r5, r6, r7, r8, r9, r10, r11)     // Catch: java.lang.Throwable -> L84
                int r15 = r12.b     // Catch: java.lang.Throwable -> L84
                int r15 = r15 - r2
                r0.set(r1, r14)     // Catch: java.lang.Throwable -> L84
                r12.b = r15     // Catch: java.lang.Throwable -> L84
                com.google.common.cache.RemovalCause r14 = com.google.common.cache.RemovalCause.EXPLICIT     // Catch: java.lang.Throwable -> L84
                if (r13 != r14) goto L70
                goto L71
            L70:
                r2 = 0
            L71:
                r12.unlock()
                r12.m()
                return r2
            L78:
                r12.unlock()
                r12.m()
                return r3
            L7f:
                com.google.common.cache.ReferenceEntry r6 = r6.getNext()     // Catch: java.lang.Throwable -> L84
                goto L1f
            L84:
                r13 = move-exception
                r12.unlock()
                r12.m()
                goto L8d
            L8c:
                throw r13
            L8d:
                goto L8c
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.cache.LocalCache.Segment.a(java.lang.Object, int, java.lang.Object):boolean");
        }

        /* JADX WARN: Code restructure failed: missing block: B:18:0x006f, code lost:
        
            return false;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        boolean a(K r18, int r19, V r20, V r21) {
            /*
                r17 = this;
                r9 = r17
                r0 = r19
                r17.lock()
                com.google.common.cache.LocalCache<K, V> r1 = r9.a     // Catch: java.lang.Throwable -> Lb5
                com.google.common.base.Ticker r1 = r1.p     // Catch: java.lang.Throwable -> Lb5
                long r7 = r1.read()     // Catch: java.lang.Throwable -> Lb5
                r9.b(r7)     // Catch: java.lang.Throwable -> Lb5
                java.util.concurrent.atomic.AtomicReferenceArray<com.google.common.cache.ReferenceEntry<K, V>> r10 = r9.f     // Catch: java.lang.Throwable -> Lb5
                int r1 = r10.length()     // Catch: java.lang.Throwable -> Lb5
                r11 = 1
                int r1 = r1 - r11
                r12 = r0 & r1
                java.lang.Object r1 = r10.get(r12)     // Catch: java.lang.Throwable -> Lb5
                r2 = r1
                com.google.common.cache.ReferenceEntry r2 = (com.google.common.cache.ReferenceEntry) r2     // Catch: java.lang.Throwable -> Lb5
                r13 = r2
            L24:
                r14 = 0
                if (r13 == 0) goto L69
                java.lang.Object r4 = r13.getKey()     // Catch: java.lang.Throwable -> Lb5
                int r1 = r13.getHash()     // Catch: java.lang.Throwable -> Lb5
                if (r1 != r0) goto Lab
                if (r4 == 0) goto Lab
                com.google.common.cache.LocalCache<K, V> r1 = r9.a     // Catch: java.lang.Throwable -> Lb5
                com.google.common.base.Equivalence<java.lang.Object> r1 = r1.e     // Catch: java.lang.Throwable -> Lb5
                r15 = r18
                boolean r1 = r1.equivalent(r15, r4)     // Catch: java.lang.Throwable -> Lb5
                if (r1 == 0) goto Lad
                com.google.common.cache.LocalCache$ValueReference r16 = r13.getValueReference()     // Catch: java.lang.Throwable -> Lb5
                java.lang.Object r6 = r16.get()     // Catch: java.lang.Throwable -> Lb5
                if (r6 != 0) goto L70
                boolean r1 = r16.isActive()     // Catch: java.lang.Throwable -> Lb5
                if (r1 == 0) goto L69
                int r1 = r9.d     // Catch: java.lang.Throwable -> Lb5
                int r1 = r1 + r11
                r9.d = r1     // Catch: java.lang.Throwable -> Lb5
                com.google.common.cache.RemovalCause r8 = com.google.common.cache.RemovalCause.COLLECTED     // Catch: java.lang.Throwable -> Lb5
                r1 = r17
                r3 = r13
                r5 = r19
                r7 = r16
                com.google.common.cache.ReferenceEntry r0 = r1.a(r2, r3, r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> Lb5
                int r1 = r9.b     // Catch: java.lang.Throwable -> Lb5
                int r1 = r1 - r11
                r10.set(r12, r0)     // Catch: java.lang.Throwable -> Lb5
                r9.b = r1     // Catch: java.lang.Throwable -> Lb5
            L69:
                r17.unlock()
                r17.m()
                return r14
            L70:
                com.google.common.cache.LocalCache<K, V> r1 = r9.a     // Catch: java.lang.Throwable -> Lb5
                com.google.common.base.Equivalence<java.lang.Object> r1 = r1.f     // Catch: java.lang.Throwable -> Lb5
                r3 = r20
                boolean r1 = r1.equivalent(r3, r6)     // Catch: java.lang.Throwable -> Lb5
                if (r1 == 0) goto La7
                int r1 = r9.d     // Catch: java.lang.Throwable -> Lb5
                int r1 = r1 + r11
                r9.d = r1     // Catch: java.lang.Throwable -> Lb5
                int r5 = r16.getWeight()     // Catch: java.lang.Throwable -> Lb5
                com.google.common.cache.RemovalCause r10 = com.google.common.cache.RemovalCause.REPLACED     // Catch: java.lang.Throwable -> Lb5
                r1 = r17
                r2 = r18
                r3 = r19
                r4 = r6
                r6 = r10
                r1.a(r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> Lb5
                r1 = r17
                r2 = r13
                r3 = r18
                r4 = r21
                r5 = r7
                r1.a(r2, r3, r4, r5)     // Catch: java.lang.Throwable -> Lb5
                r9.a(r13)     // Catch: java.lang.Throwable -> Lb5
                r17.unlock()
                r17.m()
                return r11
            La7:
                r9.b(r13, r7)     // Catch: java.lang.Throwable -> Lb5
                goto L69
            Lab:
                r15 = r18
            Lad:
                r3 = r20
                com.google.common.cache.ReferenceEntry r13 = r13.getNext()     // Catch: java.lang.Throwable -> Lb5
                goto L24
            Lb5:
                r0 = move-exception
                r17.unlock()
                r17.m()
                goto Lbe
            Lbd:
                throw r0
            Lbe:
                goto Lbd
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.cache.LocalCache.Segment.a(java.lang.Object, int, java.lang.Object, java.lang.Object):boolean");
        }

        @NullableDecl
        @GuardedBy("this")
        ReferenceEntry<K, V> b(ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
            int i = this.b;
            ReferenceEntry<K, V> next = referenceEntry2.getNext();
            while (referenceEntry != referenceEntry2) {
                ReferenceEntry<K, V> a = a(referenceEntry, next);
                if (a != null) {
                    next = a;
                } else {
                    b(referenceEntry);
                    i--;
                }
                referenceEntry = referenceEntry.getNext();
            }
            this.b = i;
            return next;
        }

        @NullableDecl
        V b(Object obj, int i) {
            try {
                if (this.b != 0) {
                    long read = this.a.p.read();
                    ReferenceEntry<K, V> a = a(obj, i, read);
                    if (a == null) {
                        return null;
                    }
                    V v = a.getValueReference().get();
                    if (v != null) {
                        c(a, read);
                        return a(a, a.getKey(), i, v, read, this.a.s);
                    }
                    o();
                }
                return null;
            } finally {
                l();
            }
        }

        V b(K k, int i, CacheLoader<? super K, V> cacheLoader) {
            LoadingValueReference<K, V> loadingValueReference;
            ValueReference<K, V> valueReference;
            boolean z;
            V b;
            int weight;
            RemovalCause removalCause;
            lock();
            try {
                long read = this.a.p.read();
                b(read);
                int i2 = this.b - 1;
                AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = this.f;
                int length = i & (atomicReferenceArray.length() - 1);
                ReferenceEntry<K, V> referenceEntry = atomicReferenceArray.get(length);
                ReferenceEntry<K, V> referenceEntry2 = referenceEntry;
                while (true) {
                    loadingValueReference = null;
                    if (referenceEntry2 == null) {
                        valueReference = null;
                        break;
                    }
                    K key = referenceEntry2.getKey();
                    if (referenceEntry2.getHash() == i && key != null && this.a.e.equivalent(k, key)) {
                        ValueReference<K, V> valueReference2 = referenceEntry2.getValueReference();
                        if (valueReference2.isLoading()) {
                            z = false;
                            valueReference = valueReference2;
                        } else {
                            V v = valueReference2.get();
                            if (v == null) {
                                weight = valueReference2.getWeight();
                                removalCause = RemovalCause.COLLECTED;
                            } else {
                                if (!this.a.b(referenceEntry2, read)) {
                                    b(referenceEntry2, read);
                                    this.n.recordHits(1);
                                    return v;
                                }
                                weight = valueReference2.getWeight();
                                removalCause = RemovalCause.EXPIRED;
                            }
                            a(key, i, v, weight, removalCause);
                            this.l.remove(referenceEntry2);
                            this.m.remove(referenceEntry2);
                            this.b = i2;
                            valueReference = valueReference2;
                        }
                    } else {
                        referenceEntry2 = referenceEntry2.getNext();
                    }
                }
                z = true;
                if (z) {
                    loadingValueReference = new LoadingValueReference<>();
                    if (referenceEntry2 == null) {
                        referenceEntry2 = a((Segment<K, V>) k, i, (ReferenceEntry<Segment<K, V>, V>) referenceEntry);
                        referenceEntry2.setValueReference(loadingValueReference);
                        atomicReferenceArray.set(length, referenceEntry2);
                    } else {
                        referenceEntry2.setValueReference(loadingValueReference);
                    }
                }
                if (!z) {
                    return a((ReferenceEntry<ReferenceEntry<K, V>, V>) referenceEntry2, (ReferenceEntry<K, V>) k, (ValueReference<ReferenceEntry<K, V>, V>) valueReference);
                }
                try {
                    synchronized (referenceEntry2) {
                        b = b(k, i, loadingValueReference, cacheLoader);
                    }
                    return b;
                } finally {
                    this.n.recordMisses(1);
                }
            } finally {
                unlock();
                m();
            }
        }

        V b(K k, int i, LoadingValueReference<K, V> loadingValueReference, CacheLoader<? super K, V> cacheLoader) {
            return a((Segment<K, V>) k, i, (LoadingValueReference<Segment<K, V>, V>) loadingValueReference, (ListenableFuture) loadingValueReference.loadFuture(k, cacheLoader));
        }

        /* JADX WARN: Code restructure failed: missing block: B:18:0x0072, code lost:
        
            return null;
         */
        @org.checkerframework.checker.nullness.compatqual.NullableDecl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        V b(K r18, int r19, V r20) {
            /*
                r17 = this;
                r9 = r17
                r0 = r19
                r17.lock()
                com.google.common.cache.LocalCache<K, V> r1 = r9.a     // Catch: java.lang.Throwable -> La7
                com.google.common.base.Ticker r1 = r1.p     // Catch: java.lang.Throwable -> La7
                long r7 = r1.read()     // Catch: java.lang.Throwable -> La7
                r9.b(r7)     // Catch: java.lang.Throwable -> La7
                java.util.concurrent.atomic.AtomicReferenceArray<com.google.common.cache.ReferenceEntry<K, V>> r10 = r9.f     // Catch: java.lang.Throwable -> La7
                int r1 = r10.length()     // Catch: java.lang.Throwable -> La7
                int r1 = r1 + (-1)
                r11 = r0 & r1
                java.lang.Object r1 = r10.get(r11)     // Catch: java.lang.Throwable -> La7
                r2 = r1
                com.google.common.cache.ReferenceEntry r2 = (com.google.common.cache.ReferenceEntry) r2     // Catch: java.lang.Throwable -> La7
                r12 = r2
            L24:
                r13 = 0
                if (r12 == 0) goto L6c
                java.lang.Object r4 = r12.getKey()     // Catch: java.lang.Throwable -> La7
                int r1 = r12.getHash()     // Catch: java.lang.Throwable -> La7
                if (r1 != r0) goto L9f
                if (r4 == 0) goto L9f
                com.google.common.cache.LocalCache<K, V> r1 = r9.a     // Catch: java.lang.Throwable -> La7
                com.google.common.base.Equivalence<java.lang.Object> r1 = r1.e     // Catch: java.lang.Throwable -> La7
                r14 = r18
                boolean r1 = r1.equivalent(r14, r4)     // Catch: java.lang.Throwable -> La7
                if (r1 == 0) goto La1
                com.google.common.cache.LocalCache$ValueReference r15 = r12.getValueReference()     // Catch: java.lang.Throwable -> La7
                java.lang.Object r16 = r15.get()     // Catch: java.lang.Throwable -> La7
                if (r16 != 0) goto L73
                boolean r1 = r15.isActive()     // Catch: java.lang.Throwable -> La7
                if (r1 == 0) goto L6c
                int r1 = r9.d     // Catch: java.lang.Throwable -> La7
                int r1 = r1 + 1
                r9.d = r1     // Catch: java.lang.Throwable -> La7
                com.google.common.cache.RemovalCause r8 = com.google.common.cache.RemovalCause.COLLECTED     // Catch: java.lang.Throwable -> La7
                r1 = r17
                r3 = r12
                r5 = r19
                r6 = r16
                r7 = r15
                com.google.common.cache.ReferenceEntry r0 = r1.a(r2, r3, r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> La7
                int r1 = r9.b     // Catch: java.lang.Throwable -> La7
                int r1 = r1 + (-1)
                r10.set(r11, r0)     // Catch: java.lang.Throwable -> La7
                r9.b = r1     // Catch: java.lang.Throwable -> La7
            L6c:
                r17.unlock()
                r17.m()
                return r13
            L73:
                int r1 = r9.d     // Catch: java.lang.Throwable -> La7
                int r1 = r1 + 1
                r9.d = r1     // Catch: java.lang.Throwable -> La7
                int r5 = r15.getWeight()     // Catch: java.lang.Throwable -> La7
                com.google.common.cache.RemovalCause r6 = com.google.common.cache.RemovalCause.REPLACED     // Catch: java.lang.Throwable -> La7
                r1 = r17
                r2 = r18
                r3 = r19
                r4 = r16
                r1.a(r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> La7
                r1 = r17
                r2 = r12
                r3 = r18
                r4 = r20
                r5 = r7
                r1.a(r2, r3, r4, r5)     // Catch: java.lang.Throwable -> La7
                r9.a(r12)     // Catch: java.lang.Throwable -> La7
                r17.unlock()
                r17.m()
                return r16
            L9f:
                r14 = r18
            La1:
                com.google.common.cache.ReferenceEntry r12 = r12.getNext()     // Catch: java.lang.Throwable -> La7
                goto L24
            La7:
                r0 = move-exception
                r17.unlock()
                r17.m()
                goto Lb0
            Laf:
                throw r0
            Lb0:
                goto Laf
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.cache.LocalCache.Segment.b(java.lang.Object, int, java.lang.Object):java.lang.Object");
        }

        AtomicReferenceArray<ReferenceEntry<K, V>> b(int i) {
            return new AtomicReferenceArray<>(i);
        }

        void b() {
            RemovalCause removalCause;
            if (this.b != 0) {
                lock();
                try {
                    b(this.a.p.read());
                    AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = this.f;
                    for (int i = 0; i < atomicReferenceArray.length(); i++) {
                        for (ReferenceEntry<K, V> referenceEntry = atomicReferenceArray.get(i); referenceEntry != null; referenceEntry = referenceEntry.getNext()) {
                            if (referenceEntry.getValueReference().isActive()) {
                                K key = referenceEntry.getKey();
                                V v = referenceEntry.getValueReference().get();
                                if (key != null && v != null) {
                                    removalCause = RemovalCause.EXPLICIT;
                                    a(key, referenceEntry.getHash(), v, referenceEntry.getValueReference().getWeight(), removalCause);
                                }
                                removalCause = RemovalCause.COLLECTED;
                                a(key, referenceEntry.getHash(), v, referenceEntry.getValueReference().getWeight(), removalCause);
                            }
                        }
                    }
                    for (int i2 = 0; i2 < atomicReferenceArray.length(); i2++) {
                        atomicReferenceArray.set(i2, null);
                    }
                    d();
                    this.l.clear();
                    this.m.clear();
                    this.k.set(0);
                    this.d++;
                    this.b = 0;
                } finally {
                    unlock();
                    m();
                }
            }
        }

        @GuardedBy("this")
        void b(long j) {
            c(j);
        }

        @GuardedBy("this")
        void b(ReferenceEntry<K, V> referenceEntry) {
            a(referenceEntry.getKey(), referenceEntry.getHash(), referenceEntry.getValueReference().get(), referenceEntry.getValueReference().getWeight(), RemovalCause.COLLECTED);
            this.l.remove(referenceEntry);
            this.m.remove(referenceEntry);
        }

        @GuardedBy("this")
        void b(ReferenceEntry<K, V> referenceEntry, long j) {
            if (this.a.g()) {
                referenceEntry.setAccessTime(j);
            }
            this.m.add(referenceEntry);
        }

        @NullableDecl
        ReferenceEntry<K, V> c(Object obj, int i) {
            for (ReferenceEntry<K, V> a = a(i); a != null; a = a.getNext()) {
                if (a.getHash() == i) {
                    K key = a.getKey();
                    if (key == null) {
                        o();
                    } else if (this.a.e.equivalent(obj, key)) {
                        return a;
                    }
                }
            }
            return null;
        }

        void c() {
            do {
            } while (this.h.poll() != null);
        }

        void c(long j) {
            if (tryLock()) {
                try {
                    h();
                    a(j);
                    this.k.set(0);
                } finally {
                    unlock();
                }
            }
        }

        void c(ReferenceEntry<K, V> referenceEntry, long j) {
            if (this.a.g()) {
                referenceEntry.setAccessTime(j);
            }
            this.j.add(referenceEntry);
        }

        /* JADX WARN: Code restructure failed: missing block: B:12:0x0038, code lost:
        
            r9 = r5.getValueReference();
            r12 = r9.get();
         */
        /* JADX WARN: Code restructure failed: missing block: B:13:0x0040, code lost:
        
            if (r12 == null) goto L15;
         */
        /* JADX WARN: Code restructure failed: missing block: B:14:0x0042, code lost:
        
            r2 = com.google.common.cache.RemovalCause.EXPLICIT;
         */
        /* JADX WARN: Code restructure failed: missing block: B:15:0x0044, code lost:
        
            r10 = r2;
         */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x004f, code lost:
        
            r11.d++;
            r13 = a(r4, r5, r6, r13, r12, r9, r10);
            r2 = r11.b - 1;
            r0.set(r1, r13);
            r11.b = r2;
         */
        /* JADX WARN: Code restructure failed: missing block: B:18:0x006b, code lost:
        
            return r12;
         */
        /* JADX WARN: Code restructure failed: missing block: B:22:0x004a, code lost:
        
            if (r9.isActive() == false) goto L21;
         */
        /* JADX WARN: Code restructure failed: missing block: B:23:0x004c, code lost:
        
            r2 = com.google.common.cache.RemovalCause.COLLECTED;
         */
        @org.checkerframework.checker.nullness.compatqual.NullableDecl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        V d(java.lang.Object r12, int r13) {
            /*
                r11 = this;
                r11.lock()
                com.google.common.cache.LocalCache<K, V> r0 = r11.a     // Catch: java.lang.Throwable -> L78
                com.google.common.base.Ticker r0 = r0.p     // Catch: java.lang.Throwable -> L78
                long r0 = r0.read()     // Catch: java.lang.Throwable -> L78
                r11.b(r0)     // Catch: java.lang.Throwable -> L78
                java.util.concurrent.atomic.AtomicReferenceArray<com.google.common.cache.ReferenceEntry<K, V>> r0 = r11.f     // Catch: java.lang.Throwable -> L78
                int r1 = r0.length()     // Catch: java.lang.Throwable -> L78
                int r1 = r1 + (-1)
                r1 = r1 & r13
                java.lang.Object r2 = r0.get(r1)     // Catch: java.lang.Throwable -> L78
                r4 = r2
                com.google.common.cache.ReferenceEntry r4 = (com.google.common.cache.ReferenceEntry) r4     // Catch: java.lang.Throwable -> L78
                r5 = r4
            L1f:
                r2 = 0
                if (r5 == 0) goto L6c
                java.lang.Object r6 = r5.getKey()     // Catch: java.lang.Throwable -> L78
                int r3 = r5.getHash()     // Catch: java.lang.Throwable -> L78
                if (r3 != r13) goto L73
                if (r6 == 0) goto L73
                com.google.common.cache.LocalCache<K, V> r3 = r11.a     // Catch: java.lang.Throwable -> L78
                com.google.common.base.Equivalence<java.lang.Object> r3 = r3.e     // Catch: java.lang.Throwable -> L78
                boolean r3 = r3.equivalent(r12, r6)     // Catch: java.lang.Throwable -> L78
                if (r3 == 0) goto L73
                com.google.common.cache.LocalCache$ValueReference r9 = r5.getValueReference()     // Catch: java.lang.Throwable -> L78
                java.lang.Object r12 = r9.get()     // Catch: java.lang.Throwable -> L78
                if (r12 == 0) goto L46
                com.google.common.cache.RemovalCause r2 = com.google.common.cache.RemovalCause.EXPLICIT     // Catch: java.lang.Throwable -> L78
            L44:
                r10 = r2
                goto L4f
            L46:
                boolean r3 = r9.isActive()     // Catch: java.lang.Throwable -> L78
                if (r3 == 0) goto L6c
                com.google.common.cache.RemovalCause r2 = com.google.common.cache.RemovalCause.COLLECTED     // Catch: java.lang.Throwable -> L78
                goto L44
            L4f:
                int r2 = r11.d     // Catch: java.lang.Throwable -> L78
                int r2 = r2 + 1
                r11.d = r2     // Catch: java.lang.Throwable -> L78
                r3 = r11
                r7 = r13
                r8 = r12
                com.google.common.cache.ReferenceEntry r13 = r3.a(r4, r5, r6, r7, r8, r9, r10)     // Catch: java.lang.Throwable -> L78
                int r2 = r11.b     // Catch: java.lang.Throwable -> L78
                int r2 = r2 + (-1)
                r0.set(r1, r13)     // Catch: java.lang.Throwable -> L78
                r11.b = r2     // Catch: java.lang.Throwable -> L78
                r11.unlock()
                r11.m()
                return r12
            L6c:
                r11.unlock()
                r11.m()
                return r2
            L73:
                com.google.common.cache.ReferenceEntry r5 = r5.getNext()     // Catch: java.lang.Throwable -> L78
                goto L1f
            L78:
                r12 = move-exception
                r11.unlock()
                r11.m()
                goto L81
            L80:
                throw r12
            L81:
                goto L80
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.cache.LocalCache.Segment.d(java.lang.Object, int):java.lang.Object");
        }

        void d() {
            if (this.a.m()) {
                c();
            }
            if (this.a.n()) {
                e();
            }
        }

        void d(long j) {
            if (tryLock()) {
                try {
                    a(j);
                } finally {
                    unlock();
                }
            }
        }

        void e() {
            do {
            } while (this.i.poll() != null);
        }

        @GuardedBy("this")
        void f() {
            int i = 0;
            do {
                Reference<? extends K> poll = this.h.poll();
                if (poll == null) {
                    return;
                }
                this.a.a((ReferenceEntry) poll);
                i++;
            } while (i != 16);
        }

        @GuardedBy("this")
        void g() {
            while (true) {
                ReferenceEntry<K, V> poll = this.j.poll();
                if (poll == null) {
                    return;
                }
                if (this.m.contains(poll)) {
                    this.m.add(poll);
                }
            }
        }

        @GuardedBy("this")
        void h() {
            if (this.a.m()) {
                f();
            }
            if (this.a.n()) {
                i();
            }
        }

        @GuardedBy("this")
        void i() {
            int i = 0;
            do {
                Reference<? extends V> poll = this.i.poll();
                if (poll == null) {
                    return;
                }
                this.a.a((ValueReference) poll);
                i++;
            } while (i != 16);
        }

        @GuardedBy("this")
        void j() {
            AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = this.f;
            int length = atomicReferenceArray.length();
            if (length >= 1073741824) {
                return;
            }
            int i = this.b;
            AtomicReferenceArray<ReferenceEntry<K, V>> b = b(length << 1);
            this.e = (b.length() * 3) / 4;
            int length2 = b.length() - 1;
            for (int i2 = 0; i2 < length; i2++) {
                ReferenceEntry<K, V> referenceEntry = atomicReferenceArray.get(i2);
                if (referenceEntry != null) {
                    ReferenceEntry<K, V> next = referenceEntry.getNext();
                    int hash = referenceEntry.getHash() & length2;
                    if (next == null) {
                        b.set(hash, referenceEntry);
                    } else {
                        ReferenceEntry<K, V> referenceEntry2 = referenceEntry;
                        while (next != null) {
                            int hash2 = next.getHash() & length2;
                            if (hash2 != hash) {
                                referenceEntry2 = next;
                                hash = hash2;
                            }
                            next = next.getNext();
                        }
                        b.set(hash, referenceEntry2);
                        while (referenceEntry != referenceEntry2) {
                            int hash3 = referenceEntry.getHash() & length2;
                            ReferenceEntry<K, V> a = a(referenceEntry, b.get(hash3));
                            if (a != null) {
                                b.set(hash3, a);
                            } else {
                                b(referenceEntry);
                                i--;
                            }
                            referenceEntry = referenceEntry.getNext();
                        }
                    }
                }
            }
            this.f = b;
            this.b = i;
        }

        @GuardedBy("this")
        ReferenceEntry<K, V> k() {
            for (ReferenceEntry<K, V> referenceEntry : this.m) {
                if (referenceEntry.getValueReference().getWeight() > 0) {
                    return referenceEntry;
                }
            }
            throw new AssertionError();
        }

        void l() {
            if ((this.k.incrementAndGet() & 63) == 0) {
                a();
            }
        }

        void m() {
            n();
        }

        void n() {
            if (isHeldByCurrentThread()) {
                return;
            }
            this.a.f();
        }

        void o() {
            if (tryLock()) {
                try {
                    h();
                } finally {
                    unlock();
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    static class SoftValueReference<K, V> extends SoftReference<V> implements ValueReference<K, V> {
        final ReferenceEntry<K, V> a;

        SoftValueReference(ReferenceQueue<V> referenceQueue, V v, ReferenceEntry<K, V> referenceEntry) {
            super(v, referenceQueue);
            this.a = referenceEntry;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public ValueReference<K, V> copyFor(ReferenceQueue<V> referenceQueue, V v, ReferenceEntry<K, V> referenceEntry) {
            return new SoftValueReference(referenceQueue, v, referenceEntry);
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public ReferenceEntry<K, V> getEntry() {
            return this.a;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public int getWeight() {
            return 1;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public boolean isActive() {
            return true;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public boolean isLoading() {
            return false;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public void notifyNewValue(V v) {
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public V waitForValue() {
            return get();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public enum Strength {
        STRONG { // from class: com.google.common.cache.LocalCache.Strength.1
            @Override // com.google.common.cache.LocalCache.Strength
            Equivalence<Object> a() {
                return Equivalence.equals();
            }

            @Override // com.google.common.cache.LocalCache.Strength
            <K, V> ValueReference<K, V> a(Segment<K, V> segment, ReferenceEntry<K, V> referenceEntry, V v, int i) {
                return i == 1 ? new StrongValueReference(v) : new WeightedStrongValueReference(v, i);
            }
        },
        SOFT { // from class: com.google.common.cache.LocalCache.Strength.2
            @Override // com.google.common.cache.LocalCache.Strength
            Equivalence<Object> a() {
                return Equivalence.identity();
            }

            @Override // com.google.common.cache.LocalCache.Strength
            <K, V> ValueReference<K, V> a(Segment<K, V> segment, ReferenceEntry<K, V> referenceEntry, V v, int i) {
                return i == 1 ? new SoftValueReference(segment.i, v, referenceEntry) : new WeightedSoftValueReference(segment.i, v, referenceEntry, i);
            }
        },
        WEAK { // from class: com.google.common.cache.LocalCache.Strength.3
            @Override // com.google.common.cache.LocalCache.Strength
            Equivalence<Object> a() {
                return Equivalence.identity();
            }

            @Override // com.google.common.cache.LocalCache.Strength
            <K, V> ValueReference<K, V> a(Segment<K, V> segment, ReferenceEntry<K, V> referenceEntry, V v, int i) {
                return i == 1 ? new WeakValueReference(segment.i, v, referenceEntry) : new WeightedWeakValueReference(segment.i, v, referenceEntry, i);
            }
        };

        /* JADX INFO: Access modifiers changed from: package-private */
        public abstract Equivalence<Object> a();

        abstract <K, V> ValueReference<K, V> a(Segment<K, V> segment, ReferenceEntry<K, V> referenceEntry, V v, int i);
    }

    /* loaded from: classes2.dex */
    static final class StrongAccessEntry<K, V> extends StrongEntry<K, V> {
        volatile long e;
        ReferenceEntry<K, V> f;
        ReferenceEntry<K, V> g;

        StrongAccessEntry(K k, int i, @NullableDecl ReferenceEntry<K, V> referenceEntry) {
            super(k, i, referenceEntry);
            this.e = Long.MAX_VALUE;
            this.f = LocalCache.r();
            this.g = LocalCache.r();
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public long getAccessTime() {
            return this.e;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public ReferenceEntry<K, V> getNextInAccessQueue() {
            return this.f;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public ReferenceEntry<K, V> getPreviousInAccessQueue() {
            return this.g;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public void setAccessTime(long j) {
            this.e = j;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public void setNextInAccessQueue(ReferenceEntry<K, V> referenceEntry) {
            this.f = referenceEntry;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public void setPreviousInAccessQueue(ReferenceEntry<K, V> referenceEntry) {
            this.g = referenceEntry;
        }
    }

    /* loaded from: classes2.dex */
    static final class StrongAccessWriteEntry<K, V> extends StrongEntry<K, V> {
        volatile long e;
        ReferenceEntry<K, V> f;
        ReferenceEntry<K, V> g;
        volatile long h;
        ReferenceEntry<K, V> i;
        ReferenceEntry<K, V> j;

        StrongAccessWriteEntry(K k, int i, @NullableDecl ReferenceEntry<K, V> referenceEntry) {
            super(k, i, referenceEntry);
            this.e = Long.MAX_VALUE;
            this.f = LocalCache.r();
            this.g = LocalCache.r();
            this.h = Long.MAX_VALUE;
            this.i = LocalCache.r();
            this.j = LocalCache.r();
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public long getAccessTime() {
            return this.e;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public ReferenceEntry<K, V> getNextInAccessQueue() {
            return this.f;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public ReferenceEntry<K, V> getNextInWriteQueue() {
            return this.i;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public ReferenceEntry<K, V> getPreviousInAccessQueue() {
            return this.g;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public ReferenceEntry<K, V> getPreviousInWriteQueue() {
            return this.j;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public long getWriteTime() {
            return this.h;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public void setAccessTime(long j) {
            this.e = j;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public void setNextInAccessQueue(ReferenceEntry<K, V> referenceEntry) {
            this.f = referenceEntry;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public void setNextInWriteQueue(ReferenceEntry<K, V> referenceEntry) {
            this.i = referenceEntry;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public void setPreviousInAccessQueue(ReferenceEntry<K, V> referenceEntry) {
            this.g = referenceEntry;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public void setPreviousInWriteQueue(ReferenceEntry<K, V> referenceEntry) {
            this.j = referenceEntry;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public void setWriteTime(long j) {
            this.h = j;
        }
    }

    /* loaded from: classes2.dex */
    static class StrongEntry<K, V> extends AbstractReferenceEntry<K, V> {
        final K a;
        final int b;

        @NullableDecl
        final ReferenceEntry<K, V> c;
        volatile ValueReference<K, V> d = LocalCache.s();

        StrongEntry(K k, int i, @NullableDecl ReferenceEntry<K, V> referenceEntry) {
            this.a = k;
            this.b = i;
            this.c = referenceEntry;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public int getHash() {
            return this.b;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public K getKey() {
            return this.a;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public ReferenceEntry<K, V> getNext() {
            return this.c;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public ValueReference<K, V> getValueReference() {
            return this.d;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public void setValueReference(ValueReference<K, V> valueReference) {
            this.d = valueReference;
        }
    }

    /* loaded from: classes2.dex */
    static class StrongValueReference<K, V> implements ValueReference<K, V> {
        final V a;

        StrongValueReference(V v) {
            this.a = v;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public ValueReference<K, V> copyFor(ReferenceQueue<V> referenceQueue, V v, ReferenceEntry<K, V> referenceEntry) {
            return this;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public V get() {
            return this.a;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public ReferenceEntry<K, V> getEntry() {
            return null;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public int getWeight() {
            return 1;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public boolean isActive() {
            return true;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public boolean isLoading() {
            return false;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public void notifyNewValue(V v) {
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public V waitForValue() {
            return get();
        }
    }

    /* loaded from: classes2.dex */
    static final class StrongWriteEntry<K, V> extends StrongEntry<K, V> {
        volatile long e;
        ReferenceEntry<K, V> f;
        ReferenceEntry<K, V> g;

        StrongWriteEntry(K k, int i, @NullableDecl ReferenceEntry<K, V> referenceEntry) {
            super(k, i, referenceEntry);
            this.e = Long.MAX_VALUE;
            this.f = LocalCache.r();
            this.g = LocalCache.r();
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public ReferenceEntry<K, V> getNextInWriteQueue() {
            return this.f;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public ReferenceEntry<K, V> getPreviousInWriteQueue() {
            return this.g;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public long getWriteTime() {
            return this.e;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public void setNextInWriteQueue(ReferenceEntry<K, V> referenceEntry) {
            this.f = referenceEntry;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public void setPreviousInWriteQueue(ReferenceEntry<K, V> referenceEntry) {
            this.g = referenceEntry;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public void setWriteTime(long j) {
            this.e = j;
        }
    }

    /* loaded from: classes2.dex */
    final class ValueIterator extends LocalCache<K, V>.HashIterator<V> {
        ValueIterator(LocalCache localCache) {
            super();
        }

        @Override // com.google.common.cache.LocalCache.HashIterator, java.util.Iterator
        public V next() {
            return b().getValue();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public interface ValueReference<K, V> {
        ValueReference<K, V> copyFor(ReferenceQueue<V> referenceQueue, @NullableDecl V v, ReferenceEntry<K, V> referenceEntry);

        @NullableDecl
        V get();

        @NullableDecl
        ReferenceEntry<K, V> getEntry();

        int getWeight();

        boolean isActive();

        boolean isLoading();

        void notifyNewValue(@NullableDecl V v);

        V waitForValue();
    }

    /* loaded from: classes2.dex */
    final class Values extends AbstractCollection<V> {
        private final ConcurrentMap<?, ?> map;

        Values(ConcurrentMap<?, ?> concurrentMap) {
            this.map = concurrentMap;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            this.map.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            return this.map.containsValue(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return this.map.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return new ValueIterator(LocalCache.this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return this.map.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public Object[] toArray() {
            return LocalCache.toArrayList(this).toArray();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public <E> E[] toArray(E[] eArr) {
            return (E[]) LocalCache.toArrayList(this).toArray(eArr);
        }
    }

    /* loaded from: classes2.dex */
    static final class WeakAccessEntry<K, V> extends WeakEntry<K, V> {
        volatile long d;
        ReferenceEntry<K, V> e;
        ReferenceEntry<K, V> f;

        WeakAccessEntry(ReferenceQueue<K> referenceQueue, K k, int i, @NullableDecl ReferenceEntry<K, V> referenceEntry) {
            super(referenceQueue, k, i, referenceEntry);
            this.d = Long.MAX_VALUE;
            this.e = LocalCache.r();
            this.f = LocalCache.r();
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public long getAccessTime() {
            return this.d;
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public ReferenceEntry<K, V> getNextInAccessQueue() {
            return this.e;
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public ReferenceEntry<K, V> getPreviousInAccessQueue() {
            return this.f;
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public void setAccessTime(long j) {
            this.d = j;
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public void setNextInAccessQueue(ReferenceEntry<K, V> referenceEntry) {
            this.e = referenceEntry;
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public void setPreviousInAccessQueue(ReferenceEntry<K, V> referenceEntry) {
            this.f = referenceEntry;
        }
    }

    /* loaded from: classes2.dex */
    static final class WeakAccessWriteEntry<K, V> extends WeakEntry<K, V> {
        volatile long d;
        ReferenceEntry<K, V> e;
        ReferenceEntry<K, V> f;
        volatile long g;
        ReferenceEntry<K, V> h;
        ReferenceEntry<K, V> i;

        WeakAccessWriteEntry(ReferenceQueue<K> referenceQueue, K k, int i, @NullableDecl ReferenceEntry<K, V> referenceEntry) {
            super(referenceQueue, k, i, referenceEntry);
            this.d = Long.MAX_VALUE;
            this.e = LocalCache.r();
            this.f = LocalCache.r();
            this.g = Long.MAX_VALUE;
            this.h = LocalCache.r();
            this.i = LocalCache.r();
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public long getAccessTime() {
            return this.d;
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public ReferenceEntry<K, V> getNextInAccessQueue() {
            return this.e;
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public ReferenceEntry<K, V> getNextInWriteQueue() {
            return this.h;
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public ReferenceEntry<K, V> getPreviousInAccessQueue() {
            return this.f;
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public ReferenceEntry<K, V> getPreviousInWriteQueue() {
            return this.i;
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public long getWriteTime() {
            return this.g;
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public void setAccessTime(long j) {
            this.d = j;
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public void setNextInAccessQueue(ReferenceEntry<K, V> referenceEntry) {
            this.e = referenceEntry;
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public void setNextInWriteQueue(ReferenceEntry<K, V> referenceEntry) {
            this.h = referenceEntry;
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public void setPreviousInAccessQueue(ReferenceEntry<K, V> referenceEntry) {
            this.f = referenceEntry;
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public void setPreviousInWriteQueue(ReferenceEntry<K, V> referenceEntry) {
            this.i = referenceEntry;
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public void setWriteTime(long j) {
            this.g = j;
        }
    }

    /* loaded from: classes2.dex */
    static class WeakEntry<K, V> extends WeakReference<K> implements ReferenceEntry<K, V> {
        final int a;

        @NullableDecl
        final ReferenceEntry<K, V> b;
        volatile ValueReference<K, V> c;

        WeakEntry(ReferenceQueue<K> referenceQueue, K k, int i, @NullableDecl ReferenceEntry<K, V> referenceEntry) {
            super(k, referenceQueue);
            this.c = LocalCache.s();
            this.a = i;
            this.b = referenceEntry;
        }

        public long getAccessTime() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public int getHash() {
            return this.a;
        }

        @Override // com.google.common.cache.ReferenceEntry
        public K getKey() {
            return get();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public ReferenceEntry<K, V> getNext() {
            return this.b;
        }

        public ReferenceEntry<K, V> getNextInAccessQueue() {
            throw new UnsupportedOperationException();
        }

        public ReferenceEntry<K, V> getNextInWriteQueue() {
            throw new UnsupportedOperationException();
        }

        public ReferenceEntry<K, V> getPreviousInAccessQueue() {
            throw new UnsupportedOperationException();
        }

        public ReferenceEntry<K, V> getPreviousInWriteQueue() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public ValueReference<K, V> getValueReference() {
            return this.c;
        }

        public long getWriteTime() {
            throw new UnsupportedOperationException();
        }

        public void setAccessTime(long j) {
            throw new UnsupportedOperationException();
        }

        public void setNextInAccessQueue(ReferenceEntry<K, V> referenceEntry) {
            throw new UnsupportedOperationException();
        }

        public void setNextInWriteQueue(ReferenceEntry<K, V> referenceEntry) {
            throw new UnsupportedOperationException();
        }

        public void setPreviousInAccessQueue(ReferenceEntry<K, V> referenceEntry) {
            throw new UnsupportedOperationException();
        }

        public void setPreviousInWriteQueue(ReferenceEntry<K, V> referenceEntry) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public void setValueReference(ValueReference<K, V> valueReference) {
            this.c = valueReference;
        }

        public void setWriteTime(long j) {
            throw new UnsupportedOperationException();
        }
    }

    /* loaded from: classes2.dex */
    static class WeakValueReference<K, V> extends WeakReference<V> implements ValueReference<K, V> {
        final ReferenceEntry<K, V> a;

        WeakValueReference(ReferenceQueue<V> referenceQueue, V v, ReferenceEntry<K, V> referenceEntry) {
            super(v, referenceQueue);
            this.a = referenceEntry;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public ValueReference<K, V> copyFor(ReferenceQueue<V> referenceQueue, V v, ReferenceEntry<K, V> referenceEntry) {
            return new WeakValueReference(referenceQueue, v, referenceEntry);
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public ReferenceEntry<K, V> getEntry() {
            return this.a;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public int getWeight() {
            return 1;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public boolean isActive() {
            return true;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public boolean isLoading() {
            return false;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public void notifyNewValue(V v) {
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public V waitForValue() {
            return get();
        }
    }

    /* loaded from: classes2.dex */
    static final class WeakWriteEntry<K, V> extends WeakEntry<K, V> {
        volatile long d;
        ReferenceEntry<K, V> e;
        ReferenceEntry<K, V> f;

        WeakWriteEntry(ReferenceQueue<K> referenceQueue, K k, int i, @NullableDecl ReferenceEntry<K, V> referenceEntry) {
            super(referenceQueue, k, i, referenceEntry);
            this.d = Long.MAX_VALUE;
            this.e = LocalCache.r();
            this.f = LocalCache.r();
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public ReferenceEntry<K, V> getNextInWriteQueue() {
            return this.e;
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public ReferenceEntry<K, V> getPreviousInWriteQueue() {
            return this.f;
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public long getWriteTime() {
            return this.d;
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public void setNextInWriteQueue(ReferenceEntry<K, V> referenceEntry) {
            this.e = referenceEntry;
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public void setPreviousInWriteQueue(ReferenceEntry<K, V> referenceEntry) {
            this.f = referenceEntry;
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public void setWriteTime(long j) {
            this.d = j;
        }
    }

    /* loaded from: classes2.dex */
    static final class WeightedSoftValueReference<K, V> extends SoftValueReference<K, V> {
        final int b;

        WeightedSoftValueReference(ReferenceQueue<V> referenceQueue, V v, ReferenceEntry<K, V> referenceEntry, int i) {
            super(referenceQueue, v, referenceEntry);
            this.b = i;
        }

        @Override // com.google.common.cache.LocalCache.SoftValueReference, com.google.common.cache.LocalCache.ValueReference
        public ValueReference<K, V> copyFor(ReferenceQueue<V> referenceQueue, V v, ReferenceEntry<K, V> referenceEntry) {
            return new WeightedSoftValueReference(referenceQueue, v, referenceEntry, this.b);
        }

        @Override // com.google.common.cache.LocalCache.SoftValueReference, com.google.common.cache.LocalCache.ValueReference
        public int getWeight() {
            return this.b;
        }
    }

    /* loaded from: classes2.dex */
    static final class WeightedStrongValueReference<K, V> extends StrongValueReference<K, V> {
        final int b;

        WeightedStrongValueReference(V v, int i) {
            super(v);
            this.b = i;
        }

        @Override // com.google.common.cache.LocalCache.StrongValueReference, com.google.common.cache.LocalCache.ValueReference
        public int getWeight() {
            return this.b;
        }
    }

    /* loaded from: classes2.dex */
    static final class WeightedWeakValueReference<K, V> extends WeakValueReference<K, V> {
        final int b;

        WeightedWeakValueReference(ReferenceQueue<V> referenceQueue, V v, ReferenceEntry<K, V> referenceEntry, int i) {
            super(referenceQueue, v, referenceEntry);
            this.b = i;
        }

        @Override // com.google.common.cache.LocalCache.WeakValueReference, com.google.common.cache.LocalCache.ValueReference
        public ValueReference<K, V> copyFor(ReferenceQueue<V> referenceQueue, V v, ReferenceEntry<K, V> referenceEntry) {
            return new WeightedWeakValueReference(referenceQueue, v, referenceEntry, this.b);
        }

        @Override // com.google.common.cache.LocalCache.WeakValueReference, com.google.common.cache.LocalCache.ValueReference
        public int getWeight() {
            return this.b;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class WriteQueue<K, V> extends AbstractQueue<ReferenceEntry<K, V>> {
        final ReferenceEntry<K, V> a = new AbstractReferenceEntry<K, V>(this) { // from class: com.google.common.cache.LocalCache.WriteQueue.1
            ReferenceEntry<K, V> a = this;
            ReferenceEntry<K, V> b = this;

            @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
            public ReferenceEntry<K, V> getNextInWriteQueue() {
                return this.a;
            }

            @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
            public ReferenceEntry<K, V> getPreviousInWriteQueue() {
                return this.b;
            }

            @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
            public long getWriteTime() {
                return Long.MAX_VALUE;
            }

            @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
            public void setNextInWriteQueue(ReferenceEntry<K, V> referenceEntry) {
                this.a = referenceEntry;
            }

            @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
            public void setPreviousInWriteQueue(ReferenceEntry<K, V> referenceEntry) {
                this.b = referenceEntry;
            }

            @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
            public void setWriteTime(long j) {
            }
        };

        WriteQueue() {
        }

        @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
        public void clear() {
            ReferenceEntry<K, V> nextInWriteQueue = this.a.getNextInWriteQueue();
            while (true) {
                ReferenceEntry<K, V> referenceEntry = this.a;
                if (nextInWriteQueue == referenceEntry) {
                    referenceEntry.setNextInWriteQueue(referenceEntry);
                    ReferenceEntry<K, V> referenceEntry2 = this.a;
                    referenceEntry2.setPreviousInWriteQueue(referenceEntry2);
                    return;
                } else {
                    ReferenceEntry<K, V> nextInWriteQueue2 = nextInWriteQueue.getNextInWriteQueue();
                    LocalCache.c((ReferenceEntry) nextInWriteQueue);
                    nextInWriteQueue = nextInWriteQueue2;
                }
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            return ((ReferenceEntry) obj).getNextInWriteQueue() != NullEntry.INSTANCE;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return this.a.getNextInWriteQueue() == this.a;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<ReferenceEntry<K, V>> iterator() {
            return new AbstractSequentialIterator<ReferenceEntry<K, V>>(peek()) { // from class: com.google.common.cache.LocalCache.WriteQueue.2
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.google.common.collect.AbstractSequentialIterator
                public ReferenceEntry<K, V> a(ReferenceEntry<K, V> referenceEntry) {
                    ReferenceEntry<K, V> nextInWriteQueue = referenceEntry.getNextInWriteQueue();
                    if (nextInWriteQueue == WriteQueue.this.a) {
                        return null;
                    }
                    return nextInWriteQueue;
                }
            };
        }

        @Override // java.util.Queue
        public boolean offer(ReferenceEntry<K, V> referenceEntry) {
            LocalCache.b(referenceEntry.getPreviousInWriteQueue(), referenceEntry.getNextInWriteQueue());
            LocalCache.b(this.a.getPreviousInWriteQueue(), referenceEntry);
            LocalCache.b(referenceEntry, this.a);
            return true;
        }

        @Override // java.util.Queue
        public ReferenceEntry<K, V> peek() {
            ReferenceEntry<K, V> nextInWriteQueue = this.a.getNextInWriteQueue();
            if (nextInWriteQueue == this.a) {
                return null;
            }
            return nextInWriteQueue;
        }

        @Override // java.util.Queue
        public ReferenceEntry<K, V> poll() {
            ReferenceEntry<K, V> nextInWriteQueue = this.a.getNextInWriteQueue();
            if (nextInWriteQueue == this.a) {
                return null;
            }
            remove(nextInWriteQueue);
            return nextInWriteQueue;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean remove(Object obj) {
            ReferenceEntry referenceEntry = (ReferenceEntry) obj;
            ReferenceEntry<K, V> previousInWriteQueue = referenceEntry.getPreviousInWriteQueue();
            ReferenceEntry<K, V> nextInWriteQueue = referenceEntry.getNextInWriteQueue();
            LocalCache.b(previousInWriteQueue, nextInWriteQueue);
            LocalCache.c(referenceEntry);
            return nextInWriteQueue != NullEntry.INSTANCE;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            int i = 0;
            for (ReferenceEntry<K, V> nextInWriteQueue = this.a.getNextInWriteQueue(); nextInWriteQueue != this.a; nextInWriteQueue = nextInWriteQueue.getNextInWriteQueue()) {
                i++;
            }
            return i;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public final class WriteThroughEntry implements Map.Entry<K, V> {
        final K a;
        V b;

        WriteThroughEntry(K k, V v) {
            this.a = k;
            this.b = v;
        }

        @Override // java.util.Map.Entry
        public boolean equals(@NullableDecl Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return this.a.equals(entry.getKey()) && this.b.equals(entry.getValue());
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.a;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.b;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            return this.a.hashCode() ^ this.b.hashCode();
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            V v2 = (V) LocalCache.this.put(this.a, v);
            this.b = v;
            return v2;
        }

        public String toString() {
            return getKey() + "=" + getValue();
        }
    }

    LocalCache(CacheBuilder<? super K, ? super V> cacheBuilder, @NullableDecl CacheLoader<? super K, V> cacheLoader) {
        this.d = Math.min(cacheBuilder.a(), 65536);
        this.g = cacheBuilder.f();
        this.h = cacheBuilder.l();
        this.e = cacheBuilder.e();
        this.f = cacheBuilder.k();
        this.i = cacheBuilder.g();
        this.j = (Weigher<K, V>) cacheBuilder.m();
        this.k = cacheBuilder.b();
        this.l = cacheBuilder.c();
        this.m = cacheBuilder.h();
        this.o = (RemovalListener<K, V>) cacheBuilder.i();
        this.n = this.o == CacheBuilder.NullListener.INSTANCE ? q() : new ConcurrentLinkedQueue<>();
        this.p = cacheBuilder.a(h());
        this.q = EntryFactory.a(this.g, k(), o());
        this.r = cacheBuilder.j().get();
        this.s = cacheLoader;
        int min = Math.min(cacheBuilder.d(), Ints.MAX_POWER_OF_TWO);
        if (b() && !a()) {
            min = (int) Math.min(min, this.i);
        }
        int i = 0;
        int i2 = 1;
        int i3 = 1;
        int i4 = 0;
        while (i3 < this.d && (!b() || i3 * 20 <= this.i)) {
            i4++;
            i3 <<= 1;
        }
        this.b = 32 - i4;
        this.a = i3 - 1;
        this.c = a(i3);
        int i5 = min / i3;
        while (i2 < (i5 * i3 < min ? i5 + 1 : i5)) {
            i2 <<= 1;
        }
        if (b()) {
            long j = this.i;
            long j2 = i3;
            long j3 = (j / j2) + 1;
            long j4 = j % j2;
            while (i < this.c.length) {
                if (i == j4) {
                    j3--;
                }
                this.c[i] = a(i2, j3, cacheBuilder.j().get());
                i++;
            }
            return;
        }
        while (true) {
            Segment<K, V>[] segmentArr = this.c;
            if (i >= segmentArr.length) {
                return;
            }
            segmentArr[i] = a(i2, -1L, cacheBuilder.j().get());
            i++;
        }
    }

    static <K, V> void a(ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
        referenceEntry.setNextInAccessQueue(referenceEntry2);
        referenceEntry2.setPreviousInAccessQueue(referenceEntry);
    }

    static <K, V> void b(ReferenceEntry<K, V> referenceEntry) {
        ReferenceEntry<K, V> r = r();
        referenceEntry.setNextInAccessQueue(r);
        referenceEntry.setPreviousInAccessQueue(r);
    }

    static <K, V> void b(ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
        referenceEntry.setNextInWriteQueue(referenceEntry2);
        referenceEntry2.setPreviousInWriteQueue(referenceEntry);
    }

    static int c(int i) {
        int i2 = i + ((i << 15) ^ (-12931));
        int i3 = i2 ^ (i2 >>> 10);
        int i4 = i3 + (i3 << 3);
        int i5 = i4 ^ (i4 >>> 6);
        int i6 = i5 + (i5 << 2) + (i5 << 14);
        return i6 ^ (i6 >>> 16);
    }

    static <K, V> void c(ReferenceEntry<K, V> referenceEntry) {
        ReferenceEntry<K, V> r = r();
        referenceEntry.setNextInWriteQueue(r);
        referenceEntry.setPreviousInWriteQueue(r);
    }

    static <E> Queue<E> q() {
        return (Queue<E>) y;
    }

    static <K, V> ReferenceEntry<K, V> r() {
        return NullEntry.INSTANCE;
    }

    static <K, V> ValueReference<K, V> s() {
        return (ValueReference<K, V>) x;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <E> ArrayList<E> toArrayList(Collection<E> collection) {
        ArrayList<E> arrayList = new ArrayList<>(collection.size());
        Iterators.addAll(arrayList, collection.iterator());
        return arrayList;
    }

    Segment<K, V> a(int i, long j, AbstractCache.StatsCounter statsCounter) {
        return new Segment<>(this, i, j, statsCounter);
    }

    /* JADX WARN: Multi-variable type inference failed */
    ImmutableMap<K, V> a(Iterable<? extends K> iterable) {
        LinkedHashMap newLinkedHashMap = Maps.newLinkedHashMap();
        LinkedHashSet newLinkedHashSet = Sets.newLinkedHashSet();
        int i = 0;
        int i2 = 0;
        for (K k : iterable) {
            Object obj = get(k);
            if (!newLinkedHashMap.containsKey(k)) {
                newLinkedHashMap.put(k, obj);
                if (obj == null) {
                    i2++;
                    newLinkedHashSet.add(k);
                } else {
                    i++;
                }
            }
        }
        try {
            if (!newLinkedHashSet.isEmpty()) {
                try {
                    Map a = a((Set) newLinkedHashSet, (CacheLoader) this.s);
                    for (Object obj2 : newLinkedHashSet) {
                        Object obj3 = a.get(obj2);
                        if (obj3 == null) {
                            throw new CacheLoader.InvalidCacheLoadException("loadAll failed to return a value for " + obj2);
                        }
                        newLinkedHashMap.put(obj2, obj3);
                    }
                } catch (CacheLoader.UnsupportedLoadingOperationException unused) {
                    for (Object obj4 : newLinkedHashSet) {
                        i2--;
                        newLinkedHashMap.put(obj4, a((LocalCache<K, V>) obj4, (CacheLoader<? super LocalCache<K, V>, V>) this.s));
                    }
                }
            }
            return ImmutableMap.copyOf((Map) newLinkedHashMap);
        } finally {
            this.r.recordHits(i);
            this.r.recordMisses(i2);
        }
    }

    @NullableDecl
    V a(ReferenceEntry<K, V> referenceEntry, long j) {
        V v;
        if (referenceEntry.getKey() == null || (v = referenceEntry.getValueReference().get()) == null || b(referenceEntry, j)) {
            return null;
        }
        return v;
    }

    V a(K k) {
        return a((LocalCache<K, V>) k, (CacheLoader<? super LocalCache<K, V>, V>) this.s);
    }

    V a(K k, CacheLoader<? super K, V> cacheLoader) {
        int b = b(Preconditions.checkNotNull(k));
        return b(b).a((Segment<K, V>) k, b, (CacheLoader<? super Segment<K, V>, V>) cacheLoader);
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00b9  */
    @org.checkerframework.checker.nullness.compatqual.NullableDecl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    java.util.Map<K, V> a(java.util.Set<? extends K> r7, com.google.common.cache.CacheLoader<? super K, V> r8) {
        /*
            r6 = this;
            com.google.common.base.Preconditions.checkNotNull(r8)
            com.google.common.base.Preconditions.checkNotNull(r7)
            com.google.common.base.Stopwatch r0 = com.google.common.base.Stopwatch.createStarted()
            r1 = 1
            r2 = 0
            java.util.Map r7 = r8.loadAll(r7)     // Catch: java.lang.Throwable -> L8e java.lang.Error -> L90 java.lang.Exception -> L97 java.lang.RuntimeException -> L9e java.lang.InterruptedException -> La5 com.google.common.cache.CacheLoader.UnsupportedLoadingOperationException -> Lb3
            if (r7 == 0) goto L6c
            r0.stop()
            java.util.Set r3 = r7.entrySet()
            java.util.Iterator r3 = r3.iterator()
        L1d:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L3c
            java.lang.Object r4 = r3.next()
            java.util.Map$Entry r4 = (java.util.Map.Entry) r4
            java.lang.Object r5 = r4.getKey()
            java.lang.Object r4 = r4.getValue()
            if (r5 == 0) goto L3a
            if (r4 != 0) goto L36
            goto L3a
        L36:
            r6.put(r5, r4)
            goto L1d
        L3a:
            r2 = 1
            goto L1d
        L3c:
            if (r2 != 0) goto L4a
            com.google.common.cache.AbstractCache$StatsCounter r8 = r6.r
            java.util.concurrent.TimeUnit r1 = java.util.concurrent.TimeUnit.NANOSECONDS
            long r0 = r0.elapsed(r1)
            r8.recordLoadSuccess(r0)
            return r7
        L4a:
            com.google.common.cache.AbstractCache$StatsCounter r7 = r6.r
            java.util.concurrent.TimeUnit r1 = java.util.concurrent.TimeUnit.NANOSECONDS
            long r0 = r0.elapsed(r1)
            r7.recordLoadException(r0)
            com.google.common.cache.CacheLoader$InvalidCacheLoadException r7 = new com.google.common.cache.CacheLoader$InvalidCacheLoadException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r8)
            java.lang.String r8 = " returned null keys or values from loadAll"
            r0.append(r8)
            java.lang.String r8 = r0.toString()
            r7.<init>(r8)
            throw r7
        L6c:
            com.google.common.cache.AbstractCache$StatsCounter r7 = r6.r
            java.util.concurrent.TimeUnit r1 = java.util.concurrent.TimeUnit.NANOSECONDS
            long r0 = r0.elapsed(r1)
            r7.recordLoadException(r0)
            com.google.common.cache.CacheLoader$InvalidCacheLoadException r7 = new com.google.common.cache.CacheLoader$InvalidCacheLoadException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r8)
            java.lang.String r8 = " returned null map from loadAll"
            r0.append(r8)
            java.lang.String r8 = r0.toString()
            r7.<init>(r8)
            throw r7
        L8e:
            r7 = move-exception
            goto Lb7
        L90:
            r7 = move-exception
            com.google.common.util.concurrent.ExecutionError r8 = new com.google.common.util.concurrent.ExecutionError     // Catch: java.lang.Throwable -> L8e
            r8.<init>(r7)     // Catch: java.lang.Throwable -> L8e
            throw r8     // Catch: java.lang.Throwable -> L8e
        L97:
            r7 = move-exception
            java.util.concurrent.ExecutionException r8 = new java.util.concurrent.ExecutionException     // Catch: java.lang.Throwable -> L8e
            r8.<init>(r7)     // Catch: java.lang.Throwable -> L8e
            throw r8     // Catch: java.lang.Throwable -> L8e
        L9e:
            r7 = move-exception
            com.google.common.util.concurrent.UncheckedExecutionException r8 = new com.google.common.util.concurrent.UncheckedExecutionException     // Catch: java.lang.Throwable -> L8e
            r8.<init>(r7)     // Catch: java.lang.Throwable -> L8e
            throw r8     // Catch: java.lang.Throwable -> L8e
        La5:
            r7 = move-exception
            java.lang.Thread r8 = java.lang.Thread.currentThread()     // Catch: java.lang.Throwable -> L8e
            r8.interrupt()     // Catch: java.lang.Throwable -> L8e
            java.util.concurrent.ExecutionException r8 = new java.util.concurrent.ExecutionException     // Catch: java.lang.Throwable -> L8e
            r8.<init>(r7)     // Catch: java.lang.Throwable -> L8e
            throw r8     // Catch: java.lang.Throwable -> L8e
        Lb3:
            r7 = move-exception
            throw r7     // Catch: java.lang.Throwable -> Lb5
        Lb5:
            r7 = move-exception
            r2 = 1
        Lb7:
            if (r2 != 0) goto Lc4
            com.google.common.cache.AbstractCache$StatsCounter r8 = r6.r
            java.util.concurrent.TimeUnit r1 = java.util.concurrent.TimeUnit.NANOSECONDS
            long r0 = r0.elapsed(r1)
            r8.recordLoadException(r0)
        Lc4:
            goto Lc6
        Lc5:
            throw r7
        Lc6:
            goto Lc5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.cache.LocalCache.a(java.util.Set, com.google.common.cache.CacheLoader):java.util.Map");
    }

    void a(ValueReference<K, V> valueReference) {
        ReferenceEntry<K, V> entry = valueReference.getEntry();
        int hash = entry.getHash();
        b(hash).a((Segment<K, V>) entry.getKey(), hash, (ValueReference<Segment<K, V>, V>) valueReference);
    }

    void a(ReferenceEntry<K, V> referenceEntry) {
        int hash = referenceEntry.getHash();
        b(hash).a((ReferenceEntry) referenceEntry, hash);
    }

    boolean a() {
        return this.j != CacheBuilder.OneWeigher.INSTANCE;
    }

    final Segment<K, V>[] a(int i) {
        return new Segment[i];
    }

    int b(@NullableDecl Object obj) {
        return c(this.e.hash(obj));
    }

    Segment<K, V> b(int i) {
        return this.c[(i >>> this.b) & this.a];
    }

    /* JADX WARN: Multi-variable type inference failed */
    ImmutableMap<K, V> b(Iterable<?> iterable) {
        LinkedHashMap newLinkedHashMap = Maps.newLinkedHashMap();
        int i = 0;
        int i2 = 0;
        for (Object obj : iterable) {
            V v = get(obj);
            if (v == null) {
                i2++;
            } else {
                newLinkedHashMap.put(obj, v);
                i++;
            }
        }
        this.r.recordHits(i);
        this.r.recordMisses(i2);
        return ImmutableMap.copyOf((Map) newLinkedHashMap);
    }

    boolean b() {
        return this.i >= 0;
    }

    boolean b(ReferenceEntry<K, V> referenceEntry, long j) {
        Preconditions.checkNotNull(referenceEntry);
        if (!c() || j - referenceEntry.getAccessTime() < this.k) {
            return d() && j - referenceEntry.getWriteTime() >= this.l;
        }
        return true;
    }

    void c(Iterable<?> iterable) {
        Iterator<?> it = iterable.iterator();
        while (it.hasNext()) {
            remove(it.next());
        }
    }

    void c(K k) {
        int b = b(Preconditions.checkNotNull(k));
        b(b).a((Segment<K, V>) k, b, (CacheLoader<? super Segment<K, V>, V>) this.s, false);
    }

    boolean c() {
        return this.k > 0;
    }

    public void cleanUp() {
        for (Segment<K, V> segment : this.c) {
            segment.a();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        for (Segment<K, V> segment : this.c) {
            segment.b();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(@NullableDecl Object obj) {
        if (obj == null) {
            return false;
        }
        int b = b(obj);
        return b(b).a(obj, b);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(@NullableDecl Object obj) {
        if (obj == null) {
            return false;
        }
        long read = this.p.read();
        Segment<K, V>[] segmentArr = this.c;
        long j = -1;
        int i = 0;
        while (i < 3) {
            int length = segmentArr.length;
            long j2 = 0;
            int i2 = 0;
            while (i2 < length) {
                Segment<K, V> segment = segmentArr[i2];
                int i3 = segment.b;
                AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = segment.f;
                for (int i4 = 0; i4 < atomicReferenceArray.length(); i4++) {
                    ReferenceEntry<K, V> referenceEntry = atomicReferenceArray.get(i4);
                    while (referenceEntry != null) {
                        Segment<K, V>[] segmentArr2 = segmentArr;
                        V a = segment.a(referenceEntry, read);
                        long j3 = read;
                        if (a != null && this.f.equivalent(obj, a)) {
                            return true;
                        }
                        referenceEntry = referenceEntry.getNext();
                        segmentArr = segmentArr2;
                        read = j3;
                    }
                }
                j2 += segment.d;
                i2++;
                read = read;
            }
            long j4 = read;
            Segment<K, V>[] segmentArr3 = segmentArr;
            if (j2 == j) {
                return false;
            }
            i++;
            j = j2;
            segmentArr = segmentArr3;
            read = j4;
        }
        return false;
    }

    boolean d() {
        return this.l > 0;
    }

    long e() {
        long j = 0;
        for (int i = 0; i < this.c.length; i++) {
            j += Math.max(0, r0[i].b);
        }
        return j;
    }

    @Override // java.util.AbstractMap, java.util.Map
    @GwtIncompatible
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = this.v;
        if (set != null) {
            return set;
        }
        EntrySet entrySet = new EntrySet(this);
        this.v = entrySet;
        return entrySet;
    }

    void f() {
        while (true) {
            RemovalNotification<K, V> poll = this.n.poll();
            if (poll == null) {
                return;
            }
            try {
                this.o.onRemoval(poll);
            } catch (Throwable th) {
                w.log(Level.WARNING, "Exception thrown by removal listener", th);
            }
        }
    }

    boolean g() {
        return c();
    }

    @Override // java.util.AbstractMap, java.util.Map
    @NullableDecl
    public V get(@NullableDecl Object obj) {
        if (obj == null) {
            return null;
        }
        int b = b(obj);
        return b(b).b(obj, b);
    }

    @NullableDecl
    public V getIfPresent(Object obj) {
        int b = b(Preconditions.checkNotNull(obj));
        V b2 = b(b).b(obj, b);
        AbstractCache.StatsCounter statsCounter = this.r;
        if (b2 == null) {
            statsCounter.recordMisses(1);
        } else {
            statsCounter.recordHits(1);
        }
        return b2;
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    @NullableDecl
    public V getOrDefault(@NullableDecl Object obj, @NullableDecl V v) {
        V v2 = get(obj);
        return v2 != null ? v2 : v;
    }

    boolean h() {
        return i() || g();
    }

    boolean i() {
        return d() || j();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean isEmpty() {
        Segment<K, V>[] segmentArr = this.c;
        long j = 0;
        for (int i = 0; i < segmentArr.length; i++) {
            if (segmentArr[i].b != 0) {
                return false;
            }
            j += segmentArr[i].d;
        }
        if (j == 0) {
            return true;
        }
        for (int i2 = 0; i2 < segmentArr.length; i2++) {
            if (segmentArr[i2].b != 0) {
                return false;
            }
            j -= segmentArr[i2].d;
        }
        return j == 0;
    }

    boolean j() {
        return this.m > 0;
    }

    boolean k() {
        return l() || g();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        Set<K> set = this.t;
        if (set != null) {
            return set;
        }
        KeySet keySet = new KeySet(this);
        this.t = keySet;
        return keySet;
    }

    boolean l() {
        return c() || b();
    }

    boolean m() {
        return this.g != Strength.STRONG;
    }

    boolean n() {
        return this.h != Strength.STRONG;
    }

    boolean o() {
        return p() || i();
    }

    boolean p() {
        return d();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V put(K k, V v) {
        Preconditions.checkNotNull(k);
        Preconditions.checkNotNull(v);
        int b = b(k);
        return b(b).a((Segment<K, V>) k, b, (int) v, false);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public V putIfAbsent(K k, V v) {
        Preconditions.checkNotNull(k);
        Preconditions.checkNotNull(v);
        int b = b(k);
        return b(b).a((Segment<K, V>) k, b, (int) v, true);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(@NullableDecl Object obj) {
        if (obj == null) {
            return null;
        }
        int b = b(obj);
        return b(b).d(obj, b);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public boolean remove(@NullableDecl Object obj, @NullableDecl Object obj2) {
        if (obj == null || obj2 == null) {
            return false;
        }
        int b = b(obj);
        return b(b).a(obj, b, obj2);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public V replace(K k, V v) {
        Preconditions.checkNotNull(k);
        Preconditions.checkNotNull(v);
        int b = b(k);
        return b(b).b((Segment<K, V>) k, b, (int) v);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public boolean replace(K k, @NullableDecl V v, V v2) {
        Preconditions.checkNotNull(k);
        Preconditions.checkNotNull(v2);
        if (v == null) {
            return false;
        }
        int b = b(k);
        return b(b).a((Segment<K, V>) k, b, v, v2);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return Ints.saturatedCast(e());
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Collection<V> values() {
        Collection<V> collection = this.u;
        if (collection != null) {
            return collection;
        }
        Values values = new Values(this);
        this.u = values;
        return values;
    }
}
