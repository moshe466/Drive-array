package w3;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* loaded from: classes.dex */
public final class w<E> implements List<E>, RandomAccess {

    /* renamed from: f, reason: collision with root package name */
    private final List<E> f15101f;

    private w(List<E> list) {
        this.f15101f = Collections.unmodifiableList(list);
    }

    public static <E> w<E> c(List<E> list) {
        return new w<>(list);
    }

    public static <E> w<E> f(E... eArr) {
        return new w<>(Arrays.asList(eArr));
    }

    @Override // java.util.List
    public void add(int i10, E e10) {
        this.f15101f.add(i10, e10);
    }

    @Override // java.util.List, java.util.Collection
    public boolean add(E e10) {
        return this.f15101f.add(e10);
    }

    @Override // java.util.List
    public boolean addAll(int i10, Collection<? extends E> collection) {
        return this.f15101f.addAll(i10, collection);
    }

    @Override // java.util.List, java.util.Collection
    public boolean addAll(Collection<? extends E> collection) {
        return this.f15101f.addAll(collection);
    }

    @Override // java.util.List, java.util.Collection
    public void clear() {
        this.f15101f.clear();
    }

    @Override // java.util.List, java.util.Collection
    public boolean contains(Object obj) {
        return this.f15101f.contains(obj);
    }

    @Override // java.util.List, java.util.Collection
    public boolean containsAll(Collection<?> collection) {
        return this.f15101f.containsAll(collection);
    }

    @Override // java.util.List, java.util.Collection
    public boolean equals(Object obj) {
        return this.f15101f.equals(obj);
    }

    @Override // java.util.List
    public E get(int i10) {
        return this.f15101f.get(i10);
    }

    @Override // java.util.List, java.util.Collection
    public int hashCode() {
        return this.f15101f.hashCode();
    }

    @Override // java.util.List
    public int indexOf(Object obj) {
        return this.f15101f.indexOf(obj);
    }

    @Override // java.util.List, java.util.Collection
    public boolean isEmpty() {
        return this.f15101f.isEmpty();
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        return this.f15101f.iterator();
    }

    @Override // java.util.List
    public int lastIndexOf(Object obj) {
        return this.f15101f.lastIndexOf(obj);
    }

    @Override // java.util.List
    public ListIterator<E> listIterator() {
        return this.f15101f.listIterator();
    }

    @Override // java.util.List
    public ListIterator<E> listIterator(int i10) {
        return this.f15101f.listIterator(i10);
    }

    @Override // java.util.List
    public E remove(int i10) {
        return this.f15101f.remove(i10);
    }

    @Override // java.util.List, java.util.Collection
    public boolean remove(Object obj) {
        return this.f15101f.remove(obj);
    }

    @Override // java.util.List, java.util.Collection
    public boolean removeAll(Collection<?> collection) {
        return this.f15101f.removeAll(collection);
    }

    @Override // java.util.List, java.util.Collection
    public boolean retainAll(Collection<?> collection) {
        return this.f15101f.retainAll(collection);
    }

    @Override // java.util.List
    public E set(int i10, E e10) {
        return this.f15101f.set(i10, e10);
    }

    @Override // java.util.List, java.util.Collection
    public int size() {
        return this.f15101f.size();
    }

    @Override // java.util.List
    public List<E> subList(int i10, int i11) {
        return this.f15101f.subList(i10, i11);
    }

    @Override // java.util.List, java.util.Collection
    public Object[] toArray() {
        return this.f15101f.toArray();
    }

    @Override // java.util.List, java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        return (T[]) this.f15101f.toArray(tArr);
    }
}
