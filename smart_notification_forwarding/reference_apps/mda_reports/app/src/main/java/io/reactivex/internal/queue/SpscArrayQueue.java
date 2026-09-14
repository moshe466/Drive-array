package io.reactivex.internal.queue;

import io.reactivex.annotations.Nullable;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.util.Pow2;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* loaded from: classes3.dex */
public final class SpscArrayQueue<E> extends AtomicReferenceArray<E> implements SimplePlainQueue<E> {
    private static final Integer MAX_LOOK_AHEAD_STEP = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096);
    private static final long serialVersionUID = -1296597691183856449L;
    final int a;
    final AtomicLong b;
    long c;
    final AtomicLong d;
    final int e;

    public SpscArrayQueue(int i) {
        super(Pow2.roundToPowerOfTwo(i));
        this.a = length() - 1;
        this.b = new AtomicLong();
        this.d = new AtomicLong();
        this.e = Math.min(i / 4, MAX_LOOK_AHEAD_STEP.intValue());
    }

    int a(long j) {
        return this.a & ((int) j);
    }

    int a(long j, int i) {
        return ((int) j) & i;
    }

    E a(int i) {
        return get(i);
    }

    void a(int i, E e) {
        lazySet(i, e);
    }

    void b(long j) {
        this.d.lazySet(j);
    }

    void c(long j) {
        this.b.lazySet(j);
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
        return this.b.get() == this.d.get();
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public boolean offer(E e) {
        if (e == null) {
            throw new NullPointerException("Null is not a valid element");
        }
        int i = this.a;
        long j = this.b.get();
        int a = a(j, i);
        if (j >= this.c) {
            long j2 = this.e + j;
            if (a(a(j2, i)) == null) {
                this.c = j2;
            } else if (a(a) != null) {
                return false;
            }
        }
        a(a, (int) e);
        c(j + 1);
        return true;
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public boolean offer(E e, E e2) {
        return offer(e) && offer(e2);
    }

    @Override // io.reactivex.internal.fuseable.SimplePlainQueue, io.reactivex.internal.fuseable.SimpleQueue
    @Nullable
    public E poll() {
        long j = this.d.get();
        int a = a(j);
        E a2 = a(a);
        if (a2 == null) {
            return null;
        }
        b(j + 1);
        a(a, (int) null);
        return a2;
    }
}
