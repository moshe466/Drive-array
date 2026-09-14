package io.reactivex.internal.subscribers;

import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.QueueDrain;
import io.reactivex.internal.util.QueueDrainHelper;
import org.reactivestreams.Subscriber;

/* loaded from: classes3.dex */
public abstract class QueueDrainSubscriber<T, U, V> extends QueueDrainSubscriberPad4 implements FlowableSubscriber<T>, QueueDrain<U, V> {
    protected final Subscriber<? super V> c;
    protected final SimplePlainQueue<U> d;
    protected volatile boolean e;
    protected volatile boolean f;
    protected Throwable g;

    public QueueDrainSubscriber(Subscriber<? super V> subscriber, SimplePlainQueue<U> simplePlainQueue) {
        this.c = subscriber;
        this.d = simplePlainQueue;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(U u, boolean z, Disposable disposable) {
        Subscriber<? super V> subscriber = this.c;
        SimplePlainQueue<U> simplePlainQueue = this.d;
        if (fastEnter()) {
            long j = this.b.get();
            if (j == 0) {
                disposable.dispose();
                subscriber.onError(new MissingBackpressureException("Could not emit buffer due to lack of requests"));
                return;
            } else {
                if (accept(subscriber, u) && j != Long.MAX_VALUE) {
                    produced(1L);
                }
                if (leave(-1) == 0) {
                    return;
                }
            }
        } else {
            simplePlainQueue.offer(u);
            if (!enter()) {
                return;
            }
        }
        QueueDrainHelper.drainMaxLoop(simplePlainQueue, subscriber, z, disposable, this);
    }

    public boolean accept(Subscriber<? super V> subscriber, U u) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b(U u, boolean z, Disposable disposable) {
        Subscriber<? super V> subscriber = this.c;
        SimplePlainQueue<U> simplePlainQueue = this.d;
        if (fastEnter()) {
            long j = this.b.get();
            if (j == 0) {
                this.e = true;
                disposable.dispose();
                subscriber.onError(new MissingBackpressureException("Could not emit buffer due to lack of requests"));
                return;
            } else if (simplePlainQueue.isEmpty()) {
                if (accept(subscriber, u) && j != Long.MAX_VALUE) {
                    produced(1L);
                }
                if (leave(-1) == 0) {
                    return;
                }
            } else {
                simplePlainQueue.offer(u);
            }
        } else {
            simplePlainQueue.offer(u);
            if (!enter()) {
                return;
            }
        }
        QueueDrainHelper.drainMaxLoop(simplePlainQueue, subscriber, z, disposable, this);
    }

    @Override // io.reactivex.internal.util.QueueDrain
    public final boolean cancelled() {
        return this.e;
    }

    @Override // io.reactivex.internal.util.QueueDrain
    public final boolean done() {
        return this.f;
    }

    @Override // io.reactivex.internal.util.QueueDrain
    public final boolean enter() {
        return this.a.getAndIncrement() == 0;
    }

    @Override // io.reactivex.internal.util.QueueDrain
    public final Throwable error() {
        return this.g;
    }

    public final boolean fastEnter() {
        return this.a.get() == 0 && this.a.compareAndSet(0, 1);
    }

    @Override // io.reactivex.internal.util.QueueDrain
    public final int leave(int i) {
        return this.a.addAndGet(i);
    }

    @Override // io.reactivex.internal.util.QueueDrain
    public final long produced(long j) {
        return this.b.addAndGet(-j);
    }

    @Override // io.reactivex.internal.util.QueueDrain
    public final long requested() {
        return this.b.get();
    }

    public final void requested(long j) {
        if (SubscriptionHelper.validate(j)) {
            BackpressureHelper.add(this.b, j);
        }
    }
}
