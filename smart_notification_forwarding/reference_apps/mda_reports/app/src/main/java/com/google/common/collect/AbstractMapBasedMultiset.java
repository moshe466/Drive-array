package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.Multiset;
import com.google.common.primitives.Ints;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: Access modifiers changed from: package-private */
@GwtCompatible(emulated = true)
/* loaded from: classes2.dex */
public abstract class AbstractMapBasedMultiset<E> extends AbstractMultiset<E> implements Serializable {

    @GwtIncompatible
    private static final long serialVersionUID = 0;
    transient ObjectCountHashMap<E> a;
    transient long b;

    /* loaded from: classes2.dex */
    abstract class Itr<T> implements Iterator<T> {
        int a;
        int b = -1;
        int c;

        Itr() {
            this.a = AbstractMapBasedMultiset.this.a.a();
            this.c = AbstractMapBasedMultiset.this.a.d;
        }

        private void checkForConcurrentModification() {
            if (AbstractMapBasedMultiset.this.a.d != this.c) {
                throw new ConcurrentModificationException();
            }
        }

        abstract T a(int i);

        @Override // java.util.Iterator
        public boolean hasNext() {
            checkForConcurrentModification();
            return this.a >= 0;
        }

        @Override // java.util.Iterator
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T a = a(this.a);
            int i = this.a;
            this.b = i;
            this.a = AbstractMapBasedMultiset.this.a.f(i);
            return a;
        }

        @Override // java.util.Iterator
        public void remove() {
            checkForConcurrentModification();
            CollectPreconditions.a(this.b != -1);
            AbstractMapBasedMultiset.this.b -= r0.a.g(this.b);
            this.a = AbstractMapBasedMultiset.this.a.a(this.a, this.b);
            this.b = -1;
            this.c = AbstractMapBasedMultiset.this.a.d;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbstractMapBasedMultiset(int i) {
        a(i);
    }

    @GwtIncompatible
    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        int a = Serialization.a(objectInputStream);
        a(3);
        Serialization.a(this, objectInputStream, a);
    }

    @GwtIncompatible
    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        Serialization.a(this, objectOutputStream);
    }

    abstract void a(int i);

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Multiset<? super E> multiset) {
        Preconditions.checkNotNull(multiset);
        int a = this.a.a();
        while (a >= 0) {
            multiset.add(this.a.c(a), this.a.d(a));
            a = this.a.f(a);
        }
    }

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    @CanIgnoreReturnValue
    public final int add(@NullableDecl E e, int i) {
        if (i == 0) {
            return count(e);
        }
        Preconditions.checkArgument(i > 0, "occurrences cannot be negative: %s", i);
        int a = this.a.a(e);
        if (a == -1) {
            this.a.put(e, i);
            this.b += i;
            return 0;
        }
        int d = this.a.d(a);
        long j = i;
        long j2 = d + j;
        Preconditions.checkArgument(j2 <= 2147483647L, "too many occurrences: %s", j2);
        this.a.b(a, (int) j2);
        this.b += j;
        return d;
    }

    @Override // com.google.common.collect.AbstractMultiset
    final int b() {
        return this.a.b();
    }

    @Override // com.google.common.collect.AbstractMultiset
    final Iterator<E> c() {
        return new AbstractMapBasedMultiset<E>.Itr<E>() { // from class: com.google.common.collect.AbstractMapBasedMultiset.1
            @Override // com.google.common.collect.AbstractMapBasedMultiset.Itr
            E a(int i) {
                return AbstractMapBasedMultiset.this.a.c(i);
            }
        };
    }

    @Override // com.google.common.collect.AbstractMultiset, java.util.AbstractCollection, java.util.Collection
    public final void clear() {
        this.a.clear();
        this.b = 0L;
    }

    @Override // com.google.common.collect.Multiset
    public final int count(@NullableDecl Object obj) {
        return this.a.get(obj);
    }

    @Override // com.google.common.collect.AbstractMultiset
    final Iterator<Multiset.Entry<E>> d() {
        return new AbstractMapBasedMultiset<E>.Itr<Multiset.Entry<E>>() { // from class: com.google.common.collect.AbstractMapBasedMultiset.2
            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // com.google.common.collect.AbstractMapBasedMultiset.Itr
            public Multiset.Entry<E> a(int i) {
                return AbstractMapBasedMultiset.this.a.b(i);
            }
        };
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, com.google.common.collect.Multiset
    public final Iterator<E> iterator() {
        return Multisets.a((Multiset) this);
    }

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    @CanIgnoreReturnValue
    public final int remove(@NullableDecl Object obj, int i) {
        if (i == 0) {
            return count(obj);
        }
        Preconditions.checkArgument(i > 0, "occurrences cannot be negative: %s", i);
        int a = this.a.a(obj);
        if (a == -1) {
            return 0;
        }
        int d = this.a.d(a);
        if (d > i) {
            this.a.b(a, d - i);
        } else {
            this.a.g(a);
            i = d;
        }
        this.b -= i;
        return d;
    }

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    @CanIgnoreReturnValue
    public final int setCount(@NullableDecl E e, int i) {
        CollectPreconditions.a(i, "count");
        ObjectCountHashMap<E> objectCountHashMap = this.a;
        int remove = i == 0 ? objectCountHashMap.remove(e) : objectCountHashMap.put(e, i);
        this.b += i - remove;
        return remove;
    }

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    public final boolean setCount(@NullableDecl E e, int i, int i2) {
        long j;
        CollectPreconditions.a(i, "oldCount");
        CollectPreconditions.a(i2, "newCount");
        int a = this.a.a(e);
        if (a == -1) {
            if (i != 0) {
                return false;
            }
            if (i2 > 0) {
                this.a.put(e, i2);
                this.b += i2;
            }
            return true;
        }
        if (this.a.d(a) != i) {
            return false;
        }
        ObjectCountHashMap<E> objectCountHashMap = this.a;
        if (i2 == 0) {
            objectCountHashMap.g(a);
            j = this.b - i;
        } else {
            objectCountHashMap.b(a, i2);
            j = this.b + (i2 - i);
        }
        this.b = j;
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
    public final int size() {
        return Ints.saturatedCast(this.b);
    }
}
