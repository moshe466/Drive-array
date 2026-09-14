package io.reactivex.internal.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes3.dex */
public final class VolatileSizeArrayList<T> extends AtomicInteger implements List<T>, RandomAccess {
    private static final long serialVersionUID = 3972397474470203923L;
    final ArrayList<T> a;

    public VolatileSizeArrayList() {
        this.a = new ArrayList<>();
    }

    public VolatileSizeArrayList(int i) {
        this.a = new ArrayList<>(i);
    }

    @Override // java.util.List
    public void add(int i, T t) {
        this.a.add(i, t);
        lazySet(this.a.size());
    }

    @Override // java.util.List, java.util.Collection
    public boolean add(T t) {
        boolean add = this.a.add(t);
        lazySet(this.a.size());
        return add;
    }

    @Override // java.util.List
    public boolean addAll(int i, Collection<? extends T> collection) {
        boolean addAll = this.a.addAll(i, collection);
        lazySet(this.a.size());
        return addAll;
    }

    @Override // java.util.List, java.util.Collection
    public boolean addAll(Collection<? extends T> collection) {
        boolean addAll = this.a.addAll(collection);
        lazySet(this.a.size());
        return addAll;
    }

    @Override // java.util.List, java.util.Collection
    public void clear() {
        this.a.clear();
        lazySet(0);
    }

    @Override // java.util.List, java.util.Collection
    public boolean contains(Object obj) {
        return this.a.contains(obj);
    }

    @Override // java.util.List, java.util.Collection
    public boolean containsAll(Collection<?> collection) {
        return this.a.containsAll(collection);
    }

    @Override // java.util.List, java.util.Collection
    public boolean equals(Object obj) {
        ArrayList<T> arrayList;
        if (obj instanceof VolatileSizeArrayList) {
            arrayList = this.a;
            obj = ((VolatileSizeArrayList) obj).a;
        } else {
            arrayList = this.a;
        }
        return arrayList.equals(obj);
    }

    @Override // java.util.List
    public T get(int i) {
        return this.a.get(i);
    }

    @Override // java.util.List, java.util.Collection
    public int hashCode() {
        return this.a.hashCode();
    }

    @Override // java.util.List
    public int indexOf(Object obj) {
        return this.a.indexOf(obj);
    }

    @Override // java.util.List, java.util.Collection
    public boolean isEmpty() {
        return get() == 0;
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public Iterator<T> iterator() {
        return this.a.iterator();
    }

    @Override // java.util.List
    public int lastIndexOf(Object obj) {
        return this.a.lastIndexOf(obj);
    }

    @Override // java.util.List
    public ListIterator<T> listIterator() {
        return this.a.listIterator();
    }

    @Override // java.util.List
    public ListIterator<T> listIterator(int i) {
        return this.a.listIterator(i);
    }

    @Override // java.util.List
    public T remove(int i) {
        T remove = this.a.remove(i);
        lazySet(this.a.size());
        return remove;
    }

    @Override // java.util.List, java.util.Collection
    public boolean remove(Object obj) {
        boolean remove = this.a.remove(obj);
        lazySet(this.a.size());
        return remove;
    }

    @Override // java.util.List, java.util.Collection
    public boolean removeAll(Collection<?> collection) {
        boolean removeAll = this.a.removeAll(collection);
        lazySet(this.a.size());
        return removeAll;
    }

    @Override // java.util.List, java.util.Collection
    public boolean retainAll(Collection<?> collection) {
        boolean retainAll = this.a.retainAll(collection);
        lazySet(this.a.size());
        return retainAll;
    }

    @Override // java.util.List
    public T set(int i, T t) {
        return this.a.set(i, t);
    }

    @Override // java.util.List, java.util.Collection
    public int size() {
        return get();
    }

    @Override // java.util.List
    public List<T> subList(int i, int i2) {
        return this.a.subList(i, i2);
    }

    @Override // java.util.List, java.util.Collection
    public Object[] toArray() {
        return this.a.toArray();
    }

    @Override // java.util.List, java.util.Collection
    public <E> E[] toArray(E[] eArr) {
        return (E[]) this.a.toArray(eArr);
    }

    @Override // java.util.concurrent.atomic.AtomicInteger
    public String toString() {
        return this.a.toString();
    }
}
