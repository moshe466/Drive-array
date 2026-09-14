package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BlockingHelper;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class BlockingFlowableIterable<T> implements Iterable<T> {
    final Flowable<T> a;
    final int b;

    /* loaded from: classes2.dex */
    static final class BlockingFlowableIterator<T> extends AtomicReference<Subscription> implements FlowableSubscriber<T>, Iterator<T>, Runnable, Disposable {
        private static final long serialVersionUID = 6695226475494099826L;
        final SpscArrayQueue<T> a;
        final long b;
        final long c;
        final Lock d = new ReentrantLock();
        final Condition e = this.d.newCondition();
        long f;
        volatile boolean g;
        Throwable h;

        BlockingFlowableIterator(int i) {
            this.a = new SpscArrayQueue<>(i);
            this.b = i;
            this.c = i - (i >> 2);
        }

        void a() {
            this.d.lock();
            try {
                this.e.signalAll();
            } finally {
                this.d.unlock();
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            SubscriptionHelper.cancel(this);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            while (true) {
                boolean z = this.g;
                boolean isEmpty = this.a.isEmpty();
                if (z) {
                    Throwable th = this.h;
                    if (th != null) {
                        throw ExceptionHelper.wrapOrThrow(th);
                    }
                    if (isEmpty) {
                        return false;
                    }
                }
                if (!isEmpty) {
                    return true;
                }
                BlockingHelper.verifyNonBlocking();
                this.d.lock();
                while (!this.g && this.a.isEmpty()) {
                    try {
                        try {
                            this.e.await();
                        } catch (InterruptedException e) {
                            run();
                            throw ExceptionHelper.wrapOrThrow(e);
                        }
                    } finally {
                        this.d.unlock();
                    }
                }
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return SubscriptionHelper.isCancelled(get());
        }

        @Override // java.util.Iterator
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T poll = this.a.poll();
            long j = this.f + 1;
            if (j == this.c) {
                this.f = 0L;
                get().request(j);
            } else {
                this.f = j;
            }
            return poll;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.g = true;
            a();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.h = th;
            this.g = true;
            a();
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (this.a.offer(t)) {
                a();
            } else {
                SubscriptionHelper.cancel(this);
                onError(new MissingBackpressureException("Queue full?!"));
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            SubscriptionHelper.setOnce(this, subscription, this.b);
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("remove");
        }

        @Override // java.lang.Runnable
        public void run() {
            SubscriptionHelper.cancel(this);
            a();
        }
    }

    public BlockingFlowableIterable(Flowable<T> flowable, int i) {
        this.a = flowable;
        this.b = i;
    }

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        BlockingFlowableIterator blockingFlowableIterator = new BlockingFlowableIterator(this.b);
        this.a.subscribe((FlowableSubscriber) blockingFlowableIterator);
        return blockingFlowableIterator;
    }
}
