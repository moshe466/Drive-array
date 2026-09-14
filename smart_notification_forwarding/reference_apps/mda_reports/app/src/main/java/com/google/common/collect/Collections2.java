package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.math.IntMath;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

@GwtCompatible
/* loaded from: classes2.dex */
public final class Collections2 {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class FilteredCollection<E> extends AbstractCollection<E> {
        final Collection<E> a;
        final Predicate<? super E> b;

        /* JADX INFO: Access modifiers changed from: package-private */
        public FilteredCollection(Collection<E> collection, Predicate<? super E> predicate) {
            this.a = collection;
            this.b = predicate;
        }

        FilteredCollection<E> a(Predicate<? super E> predicate) {
            return new FilteredCollection<>(this.a, Predicates.and(this.b, predicate));
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean add(E e) {
            Preconditions.checkArgument(this.b.apply(e));
            return this.a.add(e);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean addAll(Collection<? extends E> collection) {
            Iterator<? extends E> it = collection.iterator();
            while (it.hasNext()) {
                Preconditions.checkArgument(this.b.apply(it.next()));
            }
            return this.a.addAll(collection);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            Iterables.removeIf(this.a, this.b);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(@NullableDecl Object obj) {
            if (Collections2.a((Collection<?>) this.a, obj)) {
                return this.b.apply(obj);
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean containsAll(Collection<?> collection) {
            return Collections2.a((Collection<?>) this, collection);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return !Iterables.any(this.a, this.b);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<E> iterator() {
            return Iterators.filter(this.a.iterator(), this.b);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean remove(Object obj) {
            return contains(obj) && this.a.remove(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            Iterator<E> it = this.a.iterator();
            boolean z = false;
            while (it.hasNext()) {
                E next = it.next();
                if (this.b.apply(next) && collection.contains(next)) {
                    it.remove();
                    z = true;
                }
            }
            return z;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            Iterator<E> it = this.a.iterator();
            boolean z = false;
            while (it.hasNext()) {
                E next = it.next();
                if (this.b.apply(next) && !collection.contains(next)) {
                    it.remove();
                    z = true;
                }
            }
            return z;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            Iterator<E> it = this.a.iterator();
            int i = 0;
            while (it.hasNext()) {
                if (this.b.apply(it.next())) {
                    i++;
                }
            }
            return i;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public Object[] toArray() {
            return Lists.newArrayList(iterator()).toArray();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            return (T[]) Lists.newArrayList(iterator()).toArray(tArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class OrderedPermutationCollection<E> extends AbstractCollection<List<E>> {
        final ImmutableList<E> a;
        final Comparator<? super E> b;
        final int c;

        OrderedPermutationCollection(Iterable<E> iterable, Comparator<? super E> comparator) {
            this.a = ImmutableList.sortedCopyOf(comparator, iterable);
            this.b = comparator;
            this.c = calculateSize(this.a, comparator);
        }

        private static <E> int calculateSize(List<E> list, Comparator<? super E> comparator) {
            int i = 1;
            int i2 = 1;
            int i3 = 1;
            while (i < list.size()) {
                if (comparator.compare(list.get(i - 1), list.get(i)) < 0) {
                    i2 = IntMath.saturatedMultiply(i2, IntMath.binomial(i, i3));
                    i3 = 0;
                    if (i2 == Integer.MAX_VALUE) {
                        return Integer.MAX_VALUE;
                    }
                }
                i++;
                i3++;
            }
            return IntMath.saturatedMultiply(i2, IntMath.binomial(i, i3));
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(@NullableDecl Object obj) {
            if (!(obj instanceof List)) {
                return false;
            }
            return Collections2.isPermutation(this.a, (List) obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<List<E>> iterator() {
            return new OrderedPermutationIterator(this.a, this.b);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return this.c;
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            return "orderedPermutationCollection(" + this.a + ")";
        }
    }

    /* loaded from: classes2.dex */
    private static final class OrderedPermutationIterator<E> extends AbstractIterator<List<E>> {

        @NullableDecl
        List<E> a;
        final Comparator<? super E> b;

        OrderedPermutationIterator(List<E> list, Comparator<? super E> comparator) {
            this.a = Lists.newArrayList(list);
            this.b = comparator;
        }

        int a(int i) {
            E e = this.a.get(i);
            for (int size = this.a.size() - 1; size > i; size--) {
                if (this.b.compare(e, this.a.get(size)) < 0) {
                    return size;
                }
            }
            throw new AssertionError("this statement should be unreachable");
        }

        void b() {
            int c = c();
            if (c == -1) {
                this.a = null;
                return;
            }
            Collections.swap(this.a, c, a(c));
            Collections.reverse(this.a.subList(c + 1, this.a.size()));
        }

        int c() {
            for (int size = this.a.size() - 2; size >= 0; size--) {
                if (this.b.compare(this.a.get(size), this.a.get(size + 1)) < 0) {
                    return size;
                }
            }
            return -1;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.collect.AbstractIterator
        public List<E> computeNext() {
            List<E> list = this.a;
            if (list == null) {
                return a();
            }
            ImmutableList copyOf = ImmutableList.copyOf((Collection) list);
            b();
            return copyOf;
        }
    }

    /* loaded from: classes2.dex */
    private static final class PermutationCollection<E> extends AbstractCollection<List<E>> {
        final ImmutableList<E> a;

        PermutationCollection(ImmutableList<E> immutableList) {
            this.a = immutableList;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(@NullableDecl Object obj) {
            if (!(obj instanceof List)) {
                return false;
            }
            return Collections2.isPermutation(this.a, (List) obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<List<E>> iterator() {
            return new PermutationIterator(this.a);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return IntMath.factorial(this.a.size());
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            return "permutations(" + this.a + ")";
        }
    }

    /* loaded from: classes2.dex */
    private static class PermutationIterator<E> extends AbstractIterator<List<E>> {
        final List<E> a;
        final int[] b;
        final int[] c;
        int d;

        PermutationIterator(List<E> list) {
            this.a = new ArrayList(list);
            int size = list.size();
            this.b = new int[size];
            this.c = new int[size];
            Arrays.fill(this.b, 0);
            Arrays.fill(this.c, 1);
            this.d = Integer.MAX_VALUE;
        }

        void b() {
            this.d = this.a.size() - 1;
            if (this.d == -1) {
                return;
            }
            int i = 0;
            while (true) {
                int[] iArr = this.b;
                int i2 = this.d;
                int i3 = iArr[i2] + this.c[i2];
                if (i3 >= 0) {
                    if (i3 != i2 + 1) {
                        Collections.swap(this.a, (i2 - iArr[i2]) + i, (i2 - i3) + i);
                        this.b[this.d] = i3;
                        return;
                    } else if (i2 == 0) {
                        return;
                    } else {
                        i++;
                    }
                }
                c();
            }
        }

        void c() {
            int[] iArr = this.c;
            int i = this.d;
            iArr[i] = -iArr[i];
            this.d = i - 1;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.collect.AbstractIterator
        public List<E> computeNext() {
            if (this.d <= 0) {
                return a();
            }
            ImmutableList copyOf = ImmutableList.copyOf((Collection) this.a);
            b();
            return copyOf;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class TransformedCollection<F, T> extends AbstractCollection<T> {
        final Collection<F> a;
        final Function<? super F, ? extends T> b;

        TransformedCollection(Collection<F> collection, Function<? super F, ? extends T> function) {
            this.a = (Collection) Preconditions.checkNotNull(collection);
            this.b = (Function) Preconditions.checkNotNull(function);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            this.a.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return this.a.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<T> iterator() {
            return Iterators.transform(this.a.iterator(), this.b);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return this.a.size();
        }
    }

    private Collections2() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(Collection<?> collection) {
        StringBuilder a = a(collection.size());
        a.append('[');
        boolean z = true;
        for (Object obj : collection) {
            if (!z) {
                a.append(", ");
            }
            z = false;
            if (obj == collection) {
                a.append("(this Collection)");
            } else {
                a.append(obj);
            }
        }
        a.append(']');
        return a.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static StringBuilder a(int i) {
        CollectPreconditions.a(i, "size");
        return new StringBuilder((int) Math.min(i * 8, 1073741824L));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> Collection<T> a(Iterable<T> iterable) {
        return (Collection) iterable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(Collection<?> collection, @NullableDecl Object obj) {
        Preconditions.checkNotNull(collection);
        try {
            return collection.contains(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(Collection<?> collection, Collection<?> collection2) {
        Iterator<?> it = collection2.iterator();
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean b(Collection<?> collection, @NullableDecl Object obj) {
        Preconditions.checkNotNull(collection);
        try {
            return collection.remove(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }

    private static <E> ObjectCountHashMap<E> counts(Collection<E> collection) {
        ObjectCountHashMap<E> objectCountHashMap = new ObjectCountHashMap<>();
        for (E e : collection) {
            objectCountHashMap.put(e, objectCountHashMap.get(e) + 1);
        }
        return objectCountHashMap;
    }

    public static <E> Collection<E> filter(Collection<E> collection, Predicate<? super E> predicate) {
        return collection instanceof FilteredCollection ? ((FilteredCollection) collection).a(predicate) : new FilteredCollection((Collection) Preconditions.checkNotNull(collection), (Predicate) Preconditions.checkNotNull(predicate));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isPermutation(List<?> list, List<?> list2) {
        if (list.size() != list2.size()) {
            return false;
        }
        ObjectCountHashMap counts = counts(list);
        ObjectCountHashMap counts2 = counts(list2);
        if (list.size() != list2.size()) {
            return false;
        }
        for (int i = 0; i < list.size(); i++) {
            if (counts.d(i) != counts2.get(counts.c(i))) {
                return false;
            }
        }
        return true;
    }

    @Beta
    public static <E extends Comparable<? super E>> Collection<List<E>> orderedPermutations(Iterable<E> iterable) {
        return orderedPermutations(iterable, Ordering.natural());
    }

    @Beta
    public static <E> Collection<List<E>> orderedPermutations(Iterable<E> iterable, Comparator<? super E> comparator) {
        return new OrderedPermutationCollection(iterable, comparator);
    }

    @Beta
    public static <E> Collection<List<E>> permutations(Collection<E> collection) {
        return new PermutationCollection(ImmutableList.copyOf((Collection) collection));
    }

    public static <F, T> Collection<T> transform(Collection<F> collection, Function<? super F, T> function) {
        return new TransformedCollection(collection, function);
    }
}
