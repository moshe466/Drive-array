package io.reactivex.internal.queue;

import io.reactivex.annotations.Nullable;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.util.Pow2;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* loaded from: classes3.dex */
public final class SpscLinkedArrayQueue<T> implements SimplePlainQueue<T> {
    int b;
    long c;
    final int d;
    AtomicReferenceArray<Object> e;
    final int f;
    AtomicReferenceArray<Object> g;
    static final int i = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();
    private static final Object HAS_NEXT = new Object();
    final AtomicLong a = new AtomicLong();
    final AtomicLong h = new AtomicLong();

    public SpscLinkedArrayQueue(int i2) {
        int roundToPowerOfTwo = Pow2.roundToPowerOfTwo(Math.max(8, i2));
        int i3 = roundToPowerOfTwo - 1;
        AtomicReferenceArray<Object> atomicReferenceArray = new AtomicReferenceArray<>(roundToPowerOfTwo + 1);
        this.e = atomicReferenceArray;
        this.d = i3;
        adjustLookAheadStep(roundToPowerOfTwo);
        this.g = atomicReferenceArray;
        this.f = i3;
        this.c = i3 - 1;
        soProducerIndex(0L);
    }

    private void adjustLookAheadStep(int i2) {
        this.b = Math.min(i2 / 4, i);
    }

    private static int calcDirectOffset(int i2) {
        return i2;
    }

    private static int calcWrappedOffset(long j, int i2) {
        return calcDirectOffset(((int) j) & i2);
    }

    private long lpConsumerIndex() {
        return this.h.get();
    }

    private long lpProducerIndex() {
        return this.a.get();
    }

    private long lvConsumerIndex() {
        return this.h.get();
    }

    private static <E> Object lvElement(AtomicReferenceArray<Object> atomicReferenceArray, int i2) {
        return atomicReferenceArray.get(i2);
    }

    private AtomicReferenceArray<Object> lvNextBufferAndUnlink(AtomicReferenceArray<Object> atomicReferenceArray, int i2) {
        int calcDirectOffset = calcDirectOffset(i2);
        AtomicReferenceArray<Object> atomicReferenceArray2 = (AtomicReferenceArray) lvElement(atomicReferenceArray, calcDirectOffset);
        soElement(atomicReferenceArray, calcDirectOffset, null);
        return atomicReferenceArray2;
    }

    private long lvProducerIndex() {
        return this.a.get();
    }

    private T newBufferPeek(AtomicReferenceArray<Object> atomicReferenceArray, long j, int i2) {
        this.g = atomicReferenceArray;
        return (T) lvElement(atomicReferenceArray, calcWrappedOffset(j, i2));
    }

    private T newBufferPoll(AtomicReferenceArray<Object> atomicReferenceArray, long j, int i2) {
        this.g = atomicReferenceArray;
        int calcWrappedOffset = calcWrappedOffset(j, i2);
        T t = (T) lvElement(atomicReferenceArray, calcWrappedOffset);
        if (t != null) {
            soElement(atomicReferenceArray, calcWrappedOffset, null);
            soConsumerIndex(j + 1);
        }
        return t;
    }

    private void resize(AtomicReferenceArray<Object> atomicReferenceArray, long j, int i2, T t, long j2) {
        AtomicReferenceArray<Object> atomicReferenceArray2 = new AtomicReferenceArray<>(atomicReferenceArray.length());
        this.e = atomicReferenceArray2;
        this.c = (j2 + j) - 1;
        soElement(atomicReferenceArray2, i2, t);
        soNext(atomicReferenceArray, atomicReferenceArray2);
        soElement(atomicReferenceArray, i2, HAS_NEXT);
        soProducerIndex(j + 1);
    }

    private void soConsumerIndex(long j) {
        this.h.lazySet(j);
    }

    private static void soElement(AtomicReferenceArray<Object> atomicReferenceArray, int i2, Object obj) {
        atomicReferenceArray.lazySet(i2, obj);
    }

    private void soNext(AtomicReferenceArray<Object> atomicReferenceArray, AtomicReferenceArray<Object> atomicReferenceArray2) {
        soElement(atomicReferenceArray, calcDirectOffset(atomicReferenceArray.length() - 1), atomicReferenceArray2);
    }

    private void soProducerIndex(long j) {
        this.a.lazySet(j);
    }

    private boolean writeToQueue(AtomicReferenceArray<Object> atomicReferenceArray, T t, long j, int i2) {
        soElement(atomicReferenceArray, i2, t);
        soProducerIndex(j + 1);
        return true;
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public void clear() {
        while (true) {
            if (poll() == null && isEmpty()) {
                return;
            }
        }
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public boolean isEmpty() {
        return lvProducerIndex() == lvConsumerIndex();
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public boolean offer(T t) {
        if (t == null) {
            throw new NullPointerException("Null is not a valid element");
        }
        AtomicReferenceArray<Object> atomicReferenceArray = this.e;
        long lpProducerIndex = lpProducerIndex();
        int i2 = this.d;
        int calcWrappedOffset = calcWrappedOffset(lpProducerIndex, i2);
        if (lpProducerIndex < this.c) {
            return writeToQueue(atomicReferenceArray, t, lpProducerIndex, calcWrappedOffset);
        }
        long j = this.b + lpProducerIndex;
        if (lvElement(atomicReferenceArray, calcWrappedOffset(j, i2)) == null) {
            this.c = j - 1;
            return writeToQueue(atomicReferenceArray, t, lpProducerIndex, calcWrappedOffset);
        }
        if (lvElement(atomicReferenceArray, calcWrappedOffset(1 + lpProducerIndex, i2)) == null) {
            return writeToQueue(atomicReferenceArray, t, lpProducerIndex, calcWrappedOffset);
        }
        resize(atomicReferenceArray, lpProducerIndex, calcWrappedOffset, t, i2);
        return true;
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public boolean offer(T t, T t2) {
        int calcWrappedOffset;
        AtomicReferenceArray<Object> atomicReferenceArray = this.e;
        long lvProducerIndex = lvProducerIndex();
        int i2 = this.d;
        long j = 2 + lvProducerIndex;
        if (lvElement(atomicReferenceArray, calcWrappedOffset(j, i2)) == null) {
            calcWrappedOffset = calcWrappedOffset(lvProducerIndex, i2);
            soElement(atomicReferenceArray, calcWrappedOffset + 1, t2);
        } else {
            AtomicReferenceArray<Object> atomicReferenceArray2 = new AtomicReferenceArray<>(atomicReferenceArray.length());
            this.e = atomicReferenceArray2;
            calcWrappedOffset = calcWrappedOffset(lvProducerIndex, i2);
            soElement(atomicReferenceArray2, calcWrappedOffset + 1, t2);
            soElement(atomicReferenceArray2, calcWrappedOffset, t);
            soNext(atomicReferenceArray, atomicReferenceArray2);
            t = (T) HAS_NEXT;
        }
        soElement(atomicReferenceArray, calcWrappedOffset, t);
        soProducerIndex(j);
        return true;
    }

    public T peek() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.g;
        long lpConsumerIndex = lpConsumerIndex();
        int i2 = this.f;
        T t = (T) lvElement(atomicReferenceArray, calcWrappedOffset(lpConsumerIndex, i2));
        return t == HAS_NEXT ? newBufferPeek(lvNextBufferAndUnlink(atomicReferenceArray, i2 + 1), lpConsumerIndex, i2) : t;
    }

    @Override // io.reactivex.internal.fuseable.SimplePlainQueue, io.reactivex.internal.fuseable.SimpleQueue
    @Nullable
    public T poll() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.g;
        long lpConsumerIndex = lpConsumerIndex();
        int i2 = this.f;
        int calcWrappedOffset = calcWrappedOffset(lpConsumerIndex, i2);
        T t = (T) lvElement(atomicReferenceArray, calcWrappedOffset);
        boolean z = t == HAS_NEXT;
        if (t == null || z) {
            if (z) {
                return newBufferPoll(lvNextBufferAndUnlink(atomicReferenceArray, i2 + 1), lpConsumerIndex, i2);
            }
            return null;
        }
        soElement(atomicReferenceArray, calcWrappedOffset, null);
        soConsumerIndex(lpConsumerIndex + 1);
        return t;
    }

    public int size() {
        long lvConsumerIndex = lvConsumerIndex();
        while (true) {
            long lvProducerIndex = lvProducerIndex();
            long lvConsumerIndex2 = lvConsumerIndex();
            if (lvConsumerIndex == lvConsumerIndex2) {
                return (int) (lvProducerIndex - lvConsumerIndex2);
            }
            lvConsumerIndex = lvConsumerIndex2;
        }
    }
}
