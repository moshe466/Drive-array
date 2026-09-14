package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.math.IntMath;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.j2objc.annotations.Weak;
import java.util.AbstractQueue;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Queue;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

@Beta
@GwtCompatible
/* loaded from: classes2.dex */
public final class MinMaxPriorityQueue<E> extends AbstractQueue<E> {
    private static final int DEFAULT_CAPACITY = 11;
    private static final int EVEN_POWERS_OF_TWO = 1431655765;
    private static final int ODD_POWERS_OF_TWO = -1431655766;

    @VisibleForTesting
    final int a;
    private final MinMaxPriorityQueue<E>.Heap maxHeap;
    private final MinMaxPriorityQueue<E>.Heap minHeap;
    private int modCount;
    private Object[] queue;
    private int size;

    @Beta
    /* loaded from: classes2.dex */
    public static final class Builder<B> {
        private static final int UNSET_EXPECTED_SIZE = -1;
        private final Comparator<B> comparator;
        private int expectedSize;
        private int maximumSize;

        private Builder(Comparator<B> comparator) {
            this.expectedSize = -1;
            this.maximumSize = Integer.MAX_VALUE;
            this.comparator = (Comparator) Preconditions.checkNotNull(comparator);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public <T extends B> Ordering<T> ordering() {
            return Ordering.from(this.comparator);
        }

        public <T extends B> MinMaxPriorityQueue<T> create() {
            return create(Collections.emptySet());
        }

        public <T extends B> MinMaxPriorityQueue<T> create(Iterable<? extends T> iterable) {
            MinMaxPriorityQueue<T> minMaxPriorityQueue = new MinMaxPriorityQueue<>(this, MinMaxPriorityQueue.a(this.expectedSize, this.maximumSize, iterable));
            Iterator<? extends T> it = iterable.iterator();
            while (it.hasNext()) {
                minMaxPriorityQueue.offer(it.next());
            }
            return minMaxPriorityQueue;
        }

        @CanIgnoreReturnValue
        public Builder<B> expectedSize(int i) {
            Preconditions.checkArgument(i >= 0);
            this.expectedSize = i;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder<B> maximumSize(int i) {
            Preconditions.checkArgument(i > 0);
            this.maximumSize = i;
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class Heap {
        final Ordering<E> a;

        @Weak
        @MonotonicNonNullDecl
        MinMaxPriorityQueue<E>.Heap b;

        Heap(Ordering<E> ordering) {
            this.a = ordering;
        }

        private int getGrandparentIndex(int i) {
            return getParentIndex(getParentIndex(i));
        }

        private int getLeftChildIndex(int i) {
            return (i * 2) + 1;
        }

        private int getParentIndex(int i) {
            return (i - 1) / 2;
        }

        private int getRightChildIndex(int i) {
            return (i * 2) + 2;
        }

        private boolean verifyIndex(int i) {
            if (getLeftChildIndex(i) < MinMaxPriorityQueue.this.size && a(i, getLeftChildIndex(i)) > 0) {
                return false;
            }
            if (getRightChildIndex(i) < MinMaxPriorityQueue.this.size && a(i, getRightChildIndex(i)) > 0) {
                return false;
            }
            if (i <= 0 || a(i, getParentIndex(i)) <= 0) {
                return i <= 2 || a(getGrandparentIndex(i), i) <= 0;
            }
            return false;
        }

        int a(int i) {
            while (true) {
                int c = c(i);
                if (c <= 0) {
                    return i;
                }
                MinMaxPriorityQueue.this.queue[i] = MinMaxPriorityQueue.this.a(c);
                i = c;
            }
        }

        int a(int i, int i2) {
            return this.a.compare(MinMaxPriorityQueue.this.a(i), MinMaxPriorityQueue.this.a(i2));
        }

        int a(E e) {
            int rightChildIndex;
            int parentIndex = getParentIndex(MinMaxPriorityQueue.this.size);
            if (parentIndex != 0 && (rightChildIndex = getRightChildIndex(getParentIndex(parentIndex))) != parentIndex && getLeftChildIndex(rightChildIndex) >= MinMaxPriorityQueue.this.size) {
                Object a = MinMaxPriorityQueue.this.a(rightChildIndex);
                if (this.a.compare(a, e) < 0) {
                    MinMaxPriorityQueue.this.queue[rightChildIndex] = e;
                    MinMaxPriorityQueue.this.queue[MinMaxPriorityQueue.this.size] = a;
                    return rightChildIndex;
                }
            }
            return MinMaxPriorityQueue.this.size;
        }

        MoveDesc<E> a(int i, int i2, E e) {
            int c = c(i2, e);
            if (c == i2) {
                return null;
            }
            MinMaxPriorityQueue minMaxPriorityQueue = MinMaxPriorityQueue.this;
            Object a = c < i ? minMaxPriorityQueue.a(i) : minMaxPriorityQueue.a(getParentIndex(i));
            if (this.b.b(c, (int) e) < i) {
                return new MoveDesc<>(e, a);
            }
            return null;
        }

        void a(int i, E e) {
            Heap heap;
            int d = d(i, e);
            if (d == i) {
                d = i;
                heap = this;
            } else {
                heap = this.b;
            }
            heap.b(d, (int) e);
        }

        int b(int i) {
            return b(getLeftChildIndex(i), 2);
        }

        int b(int i, int i2) {
            if (i >= MinMaxPriorityQueue.this.size) {
                return -1;
            }
            Preconditions.checkState(i > 0);
            int min = Math.min(i, MinMaxPriorityQueue.this.size - i2) + i2;
            for (int i3 = i + 1; i3 < min; i3++) {
                if (a(i3, i) < 0) {
                    i = i3;
                }
            }
            return i;
        }

        @CanIgnoreReturnValue
        int b(int i, E e) {
            while (i > 2) {
                int grandparentIndex = getGrandparentIndex(i);
                Object a = MinMaxPriorityQueue.this.a(grandparentIndex);
                if (this.a.compare(a, e) <= 0) {
                    break;
                }
                MinMaxPriorityQueue.this.queue[i] = a;
                i = grandparentIndex;
            }
            MinMaxPriorityQueue.this.queue[i] = e;
            return i;
        }

        int c(int i) {
            int leftChildIndex = getLeftChildIndex(i);
            if (leftChildIndex < 0) {
                return -1;
            }
            return b(getLeftChildIndex(leftChildIndex), 4);
        }

        int c(int i, E e) {
            int b = b(i);
            if (b <= 0 || this.a.compare(MinMaxPriorityQueue.this.a(b), e) >= 0) {
                return d(i, e);
            }
            MinMaxPriorityQueue.this.queue[i] = MinMaxPriorityQueue.this.a(b);
            MinMaxPriorityQueue.this.queue[b] = e;
            return b;
        }

        int d(int i, E e) {
            int rightChildIndex;
            if (i == 0) {
                MinMaxPriorityQueue.this.queue[0] = e;
                return 0;
            }
            int parentIndex = getParentIndex(i);
            Object a = MinMaxPriorityQueue.this.a(parentIndex);
            if (parentIndex != 0 && (rightChildIndex = getRightChildIndex(getParentIndex(parentIndex))) != parentIndex && getLeftChildIndex(rightChildIndex) >= MinMaxPriorityQueue.this.size) {
                Object a2 = MinMaxPriorityQueue.this.a(rightChildIndex);
                if (this.a.compare(a2, a) < 0) {
                    parentIndex = rightChildIndex;
                    a = a2;
                }
            }
            if (this.a.compare(a, e) >= 0) {
                MinMaxPriorityQueue.this.queue[i] = e;
                return i;
            }
            MinMaxPriorityQueue.this.queue[i] = a;
            MinMaxPriorityQueue.this.queue[parentIndex] = e;
            return parentIndex;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class MoveDesc<E> {
        final E a;
        final E b;

        MoveDesc(E e, E e2) {
            this.a = e;
            this.b = e2;
        }
    }

    /* loaded from: classes2.dex */
    private class QueueIterator implements Iterator<E> {
        private boolean canRemove;
        private int cursor;
        private int expectedModCount;

        @MonotonicNonNullDecl
        private Queue<E> forgetMeNot;

        @NullableDecl
        private E lastFromForgetMeNot;
        private int nextCursor;

        @MonotonicNonNullDecl
        private List<E> skipMe;

        private QueueIterator() {
            this.cursor = -1;
            this.nextCursor = -1;
            this.expectedModCount = MinMaxPriorityQueue.this.modCount;
        }

        private void checkModCount() {
            if (MinMaxPriorityQueue.this.modCount != this.expectedModCount) {
                throw new ConcurrentModificationException();
            }
        }

        private boolean foundAndRemovedExactReference(Iterable<E> iterable, E e) {
            Iterator<E> it = iterable.iterator();
            while (it.hasNext()) {
                if (it.next() == e) {
                    it.remove();
                    return true;
                }
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        private void nextNotInSkipMe(int i) {
            if (this.nextCursor < i) {
                if (this.skipMe != null) {
                    while (i < MinMaxPriorityQueue.this.size() && foundAndRemovedExactReference(this.skipMe, MinMaxPriorityQueue.this.a(i))) {
                        i++;
                    }
                }
                this.nextCursor = i;
            }
        }

        private boolean removeExact(Object obj) {
            for (int i = 0; i < MinMaxPriorityQueue.this.size; i++) {
                if (MinMaxPriorityQueue.this.queue[i] == obj) {
                    MinMaxPriorityQueue.this.b(i);
                    return true;
                }
            }
            return false;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            checkModCount();
            nextNotInSkipMe(this.cursor + 1);
            if (this.nextCursor < MinMaxPriorityQueue.this.size()) {
                return true;
            }
            Queue<E> queue = this.forgetMeNot;
            return (queue == null || queue.isEmpty()) ? false : true;
        }

        @Override // java.util.Iterator
        public E next() {
            checkModCount();
            nextNotInSkipMe(this.cursor + 1);
            if (this.nextCursor < MinMaxPriorityQueue.this.size()) {
                this.cursor = this.nextCursor;
                this.canRemove = true;
                return (E) MinMaxPriorityQueue.this.a(this.cursor);
            }
            if (this.forgetMeNot != null) {
                this.cursor = MinMaxPriorityQueue.this.size();
                this.lastFromForgetMeNot = this.forgetMeNot.poll();
                E e = this.lastFromForgetMeNot;
                if (e != null) {
                    this.canRemove = true;
                    return e;
                }
            }
            throw new NoSuchElementException("iterator moved past last element in queue.");
        }

        @Override // java.util.Iterator
        public void remove() {
            CollectPreconditions.a(this.canRemove);
            checkModCount();
            this.canRemove = false;
            this.expectedModCount++;
            if (this.cursor >= MinMaxPriorityQueue.this.size()) {
                Preconditions.checkState(removeExact(this.lastFromForgetMeNot));
                this.lastFromForgetMeNot = null;
                return;
            }
            MoveDesc<E> b = MinMaxPriorityQueue.this.b(this.cursor);
            if (b != null) {
                if (this.forgetMeNot == null) {
                    this.forgetMeNot = new ArrayDeque();
                    this.skipMe = new ArrayList(3);
                }
                if (!foundAndRemovedExactReference(this.skipMe, b.a)) {
                    this.forgetMeNot.add(b.a);
                }
                if (!foundAndRemovedExactReference(this.forgetMeNot, b.b)) {
                    this.skipMe.add(b.b);
                }
            }
            this.cursor--;
            this.nextCursor--;
        }
    }

    private MinMaxPriorityQueue(Builder<? super E> builder, int i) {
        Ordering ordering = builder.ordering();
        this.minHeap = new Heap(ordering);
        this.maxHeap = new Heap(ordering.reverse());
        MinMaxPriorityQueue<E>.Heap heap = this.minHeap;
        MinMaxPriorityQueue<E>.Heap heap2 = this.maxHeap;
        heap.b = heap2;
        heap2.b = heap;
        this.a = ((Builder) builder).maximumSize;
        this.queue = new Object[i];
    }

    @VisibleForTesting
    static int a(int i, int i2, Iterable<?> iterable) {
        if (i == -1) {
            i = 11;
        }
        if (iterable instanceof Collection) {
            i = Math.max(i, ((Collection) iterable).size());
        }
        return capAtMaximumSize(i, i2);
    }

    @VisibleForTesting
    static boolean c(int i) {
        int i2 = ((i + 1) ^ (-1)) ^ (-1);
        Preconditions.checkState(i2 > 0, "negative index");
        return (EVEN_POWERS_OF_TWO & i2) > (i2 & ODD_POWERS_OF_TWO);
    }

    private int calculateNewCapacity() {
        int length = this.queue.length;
        return capAtMaximumSize(length < 64 ? (length + 1) * 2 : IntMath.checkedMultiply(length / 2, 3), this.a);
    }

    private static int capAtMaximumSize(int i, int i2) {
        return Math.min(i - 1, i2) + 1;
    }

    public static <E extends Comparable<E>> MinMaxPriorityQueue<E> create() {
        return new Builder(Ordering.natural()).create();
    }

    public static <E extends Comparable<E>> MinMaxPriorityQueue<E> create(Iterable<? extends E> iterable) {
        return new Builder(Ordering.natural()).create(iterable);
    }

    public static Builder<Comparable> expectedSize(int i) {
        return new Builder(Ordering.natural()).expectedSize(i);
    }

    private MoveDesc<E> fillHole(int i, E e) {
        MinMaxPriorityQueue<E>.Heap heapForIndex = heapForIndex(i);
        int a = heapForIndex.a(i);
        int b = heapForIndex.b(a, (int) e);
        if (b == a) {
            return heapForIndex.a(i, a, e);
        }
        if (b < i) {
            return new MoveDesc<>(e, a(i));
        }
        return null;
    }

    private int getMaxElementIndex() {
        int i = this.size;
        if (i != 1) {
            return (i == 2 || this.maxHeap.a(1, 2) <= 0) ? 1 : 2;
        }
        return 0;
    }

    private void growIfNeeded() {
        if (this.size > this.queue.length) {
            Object[] objArr = new Object[calculateNewCapacity()];
            Object[] objArr2 = this.queue;
            System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
            this.queue = objArr;
        }
    }

    private MinMaxPriorityQueue<E>.Heap heapForIndex(int i) {
        return c(i) ? this.minHeap : this.maxHeap;
    }

    public static Builder<Comparable> maximumSize(int i) {
        return new Builder(Ordering.natural()).maximumSize(i);
    }

    public static <B> Builder<B> orderedBy(Comparator<B> comparator) {
        return new Builder<>(comparator);
    }

    private E removeAndGet(int i) {
        E a = a(i);
        b(i);
        return a;
    }

    E a(int i) {
        return (E) this.queue[i];
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection, java.util.Queue
    @CanIgnoreReturnValue
    public boolean add(E e) {
        offer(e);
        return true;
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
    @CanIgnoreReturnValue
    public boolean addAll(Collection<? extends E> collection) {
        Iterator<? extends E> it = collection.iterator();
        boolean z = false;
        while (it.hasNext()) {
            offer(it.next());
            z = true;
        }
        return z;
    }

    @VisibleForTesting
    @CanIgnoreReturnValue
    MoveDesc<E> b(int i) {
        Preconditions.checkPositionIndex(i, this.size);
        this.modCount++;
        this.size--;
        int i2 = this.size;
        if (i2 == i) {
            this.queue[i2] = null;
            return null;
        }
        E a = a(i2);
        int a2 = heapForIndex(this.size).a((MinMaxPriorityQueue<E>.Heap) a);
        if (a2 == i) {
            this.queue[this.size] = null;
            return null;
        }
        E a3 = a(this.size);
        this.queue[this.size] = null;
        MoveDesc<E> fillHole = fillHole(i, a3);
        return a2 < i ? fillHole == null ? new MoveDesc<>(a, a3) : new MoveDesc<>(a, fillHole.b) : fillHole;
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
    public void clear() {
        for (int i = 0; i < this.size; i++) {
            this.queue[i] = null;
        }
        this.size = 0;
    }

    public Comparator<? super E> comparator() {
        return this.minHeap.a;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        return new QueueIterator();
    }

    @Override // java.util.Queue
    @CanIgnoreReturnValue
    public boolean offer(E e) {
        Preconditions.checkNotNull(e);
        this.modCount++;
        int i = this.size;
        this.size = i + 1;
        growIfNeeded();
        heapForIndex(i).a(i, (int) e);
        return this.size <= this.a || pollLast() != e;
    }

    @Override // java.util.Queue
    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return a(0);
    }

    public E peekFirst() {
        return peek();
    }

    public E peekLast() {
        if (isEmpty()) {
            return null;
        }
        return a(getMaxElementIndex());
    }

    @Override // java.util.Queue
    @CanIgnoreReturnValue
    public E poll() {
        if (isEmpty()) {
            return null;
        }
        return removeAndGet(0);
    }

    @CanIgnoreReturnValue
    public E pollFirst() {
        return poll();
    }

    @CanIgnoreReturnValue
    public E pollLast() {
        if (isEmpty()) {
            return null;
        }
        return removeAndGet(getMaxElementIndex());
    }

    @CanIgnoreReturnValue
    public E removeFirst() {
        return remove();
    }

    @CanIgnoreReturnValue
    public E removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return removeAndGet(getMaxElementIndex());
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        return this.size;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public Object[] toArray() {
        int i = this.size;
        Object[] objArr = new Object[i];
        System.arraycopy(this.queue, 0, objArr, 0, i);
        return objArr;
    }
}
