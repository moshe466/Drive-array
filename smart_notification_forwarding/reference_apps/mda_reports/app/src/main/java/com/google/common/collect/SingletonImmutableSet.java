package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.concurrent.LazyInit;

/* JADX INFO: Access modifiers changed from: package-private */
@GwtCompatible(emulated = true, serializable = true)
/* loaded from: classes2.dex */
public final class SingletonImmutableSet<E> extends ImmutableSet<E> {
    final transient E a;

    @LazyInit
    private transient int cachedHashCode;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SingletonImmutableSet(E e) {
        this.a = (E) Preconditions.checkNotNull(e);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SingletonImmutableSet(E e, int i) {
        this.a = e;
        this.cachedHashCode = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableCollection
    public int a(Object[] objArr, int i) {
        objArr[i] = this.a;
        return i + 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableSet
    public ImmutableList<E> a() {
        return ImmutableList.of((Object) this.a);
    }

    @Override // com.google.common.collect.ImmutableSet
    boolean b() {
        return this.cachedHashCode != 0;
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return this.a.equals(obj);
    }

    @Override // com.google.common.collect.ImmutableSet, java.util.Collection, java.util.Set
    public final int hashCode() {
        int i = this.cachedHashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = this.a.hashCode();
        this.cachedHashCode = hashCode;
        return hashCode;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableCollection
    public boolean isPartialView() {
        return false;
    }

    @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet, com.google.common.collect.SortedIterable
    public UnmodifiableIterator<E> iterator() {
        return Iterators.singletonIterator(this.a);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return 1;
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        return '[' + this.a.toString() + ']';
    }
}
