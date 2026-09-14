package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.annotations.Nullable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.subscriptions.BasicQueueSubscription;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import java.util.Iterator;
import org.reactivestreams.Subscriber;

/* loaded from: classes2.dex */
public final class FlowableFromIterable<T> extends Flowable<T> {
    final Iterable<? extends T> b;

    /* loaded from: classes2.dex */
    static abstract class BaseRangeSubscription<T> extends BasicQueueSubscription<T> {
        private static final long serialVersionUID = -2252972430506210021L;
        Iterator<? extends T> a;
        volatile boolean b;
        boolean c;

        BaseRangeSubscription(Iterator<? extends T> it) {
            this.a = it;
        }

        abstract void a();

        abstract void a(long j);

        @Override // org.reactivestreams.Subscription
        public final void cancel() {
            this.b = true;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public final void clear() {
            this.a = null;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public final boolean isEmpty() {
            Iterator<? extends T> it = this.a;
            return it == null || !it.hasNext();
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        @Nullable
        public final T poll() {
            Iterator<? extends T> it = this.a;
            if (it == null) {
                return null;
            }
            if (!this.c) {
                this.c = true;
            } else if (!it.hasNext()) {
                return null;
            }
            return (T) ObjectHelper.requireNonNull(this.a.next(), "Iterator.next() returned a null value");
        }

        @Override // org.reactivestreams.Subscription
        public final void request(long j) {
            if (SubscriptionHelper.validate(j) && BackpressureHelper.add(this, j) == 0) {
                if (j == Long.MAX_VALUE) {
                    a();
                } else {
                    a(j);
                }
            }
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public final int requestFusion(int i) {
            return i & 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class IteratorConditionalSubscription<T> extends BaseRangeSubscription<T> {
        private static final long serialVersionUID = -6022804456014692607L;
        final ConditionalSubscriber<? super T> d;

        IteratorConditionalSubscription(ConditionalSubscriber<? super T> conditionalSubscriber, Iterator<? extends T> it) {
            super(it);
            this.d = conditionalSubscriber;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableFromIterable.BaseRangeSubscription
        void a() {
            T next;
            Iterator<? extends T> it = this.a;
            ConditionalSubscriber<? super T> conditionalSubscriber = this.d;
            while (!this.b) {
                try {
                    next = it.next();
                } catch (Throwable th) {
                    th = th;
                    Exceptions.throwIfFatal(th);
                }
                if (this.b) {
                    return;
                }
                if (next == null) {
                    th = new NullPointerException("Iterator.next() returned a null value");
                    conditionalSubscriber.onError(th);
                    return;
                }
                conditionalSubscriber.tryOnNext(next);
                if (this.b) {
                    return;
                }
                if (!it.hasNext()) {
                    if (this.b) {
                        return;
                    }
                    conditionalSubscriber.onComplete();
                    return;
                }
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:9:0x0051, code lost:
        
            r4 = addAndGet(-r9);
         */
        @Override // io.reactivex.internal.operators.flowable.FlowableFromIterable.BaseRangeSubscription
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        void a(long r9) {
            /*
                r8 = this;
                java.util.Iterator<? extends T> r0 = r8.a
                io.reactivex.internal.fuseable.ConditionalSubscriber<? super T> r1 = r8.d
                r2 = 0
                r4 = r9
            L7:
                r9 = r2
            L8:
                int r6 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
                if (r6 == 0) goto L49
                boolean r6 = r8.b
                if (r6 == 0) goto L11
                return
            L11:
                java.lang.Object r6 = r0.next()     // Catch: java.lang.Throwable -> L44
                boolean r7 = r8.b
                if (r7 == 0) goto L1a
                return
            L1a:
                if (r6 != 0) goto L27
                java.lang.NullPointerException r9 = new java.lang.NullPointerException
                java.lang.String r10 = "Iterator.next() returned a null value"
                r9.<init>(r10)
            L23:
                r1.onError(r9)
                return
            L27:
                boolean r6 = r1.tryOnNext(r6)
                boolean r7 = r8.b
                if (r7 == 0) goto L30
                return
            L30:
                boolean r7 = r0.hasNext()     // Catch: java.lang.Throwable -> L44
                if (r7 != 0) goto L3e
                boolean r9 = r8.b
                if (r9 != 0) goto L3d
                r1.onComplete()
            L3d:
                return
            L3e:
                if (r6 == 0) goto L8
                r6 = 1
                long r9 = r9 + r6
                goto L8
            L44:
                r9 = move-exception
                io.reactivex.exceptions.Exceptions.throwIfFatal(r9)
                goto L23
            L49:
                long r4 = r8.get()
                int r6 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
                if (r6 != 0) goto L8
                long r9 = -r9
                long r4 = r8.addAndGet(r9)
                int r9 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
                if (r9 != 0) goto L7
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowableFromIterable.IteratorConditionalSubscription.a(long):void");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class IteratorSubscription<T> extends BaseRangeSubscription<T> {
        private static final long serialVersionUID = -6022804456014692607L;
        final Subscriber<? super T> d;

        IteratorSubscription(Subscriber<? super T> subscriber, Iterator<? extends T> it) {
            super(it);
            this.d = subscriber;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableFromIterable.BaseRangeSubscription
        void a() {
            T next;
            Iterator<? extends T> it = this.a;
            Subscriber<? super T> subscriber = this.d;
            while (!this.b) {
                try {
                    next = it.next();
                } catch (Throwable th) {
                    th = th;
                    Exceptions.throwIfFatal(th);
                }
                if (this.b) {
                    return;
                }
                if (next == null) {
                    th = new NullPointerException("Iterator.next() returned a null value");
                    subscriber.onError(th);
                    return;
                }
                subscriber.onNext(next);
                if (this.b) {
                    return;
                }
                if (!it.hasNext()) {
                    if (this.b) {
                        return;
                    }
                    subscriber.onComplete();
                    return;
                }
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:9:0x004e, code lost:
        
            r4 = addAndGet(-r9);
         */
        @Override // io.reactivex.internal.operators.flowable.FlowableFromIterable.BaseRangeSubscription
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        void a(long r9) {
            /*
                r8 = this;
                java.util.Iterator<? extends T> r0 = r8.a
                org.reactivestreams.Subscriber<? super T> r1 = r8.d
                r2 = 0
                r4 = r9
            L7:
                r9 = r2
            L8:
                int r6 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
                if (r6 == 0) goto L46
                boolean r6 = r8.b
                if (r6 == 0) goto L11
                return
            L11:
                java.lang.Object r6 = r0.next()     // Catch: java.lang.Throwable -> L41
                boolean r7 = r8.b
                if (r7 == 0) goto L1a
                return
            L1a:
                if (r6 != 0) goto L27
                java.lang.NullPointerException r9 = new java.lang.NullPointerException
                java.lang.String r10 = "Iterator.next() returned a null value"
                r9.<init>(r10)
            L23:
                r1.onError(r9)
                return
            L27:
                r1.onNext(r6)
                boolean r6 = r8.b
                if (r6 == 0) goto L2f
                return
            L2f:
                boolean r6 = r0.hasNext()     // Catch: java.lang.Throwable -> L41
                if (r6 != 0) goto L3d
                boolean r9 = r8.b
                if (r9 != 0) goto L3c
                r1.onComplete()
            L3c:
                return
            L3d:
                r6 = 1
                long r9 = r9 + r6
                goto L8
            L41:
                r9 = move-exception
                io.reactivex.exceptions.Exceptions.throwIfFatal(r9)
                goto L23
            L46:
                long r4 = r8.get()
                int r6 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
                if (r6 != 0) goto L8
                long r9 = -r9
                long r4 = r8.addAndGet(r9)
                int r9 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
                if (r9 != 0) goto L7
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowableFromIterable.IteratorSubscription.a(long):void");
        }
    }

    public FlowableFromIterable(Iterable<? extends T> iterable) {
        this.b = iterable;
    }

    public static <T> void subscribe(Subscriber<? super T> subscriber, Iterator<? extends T> it) {
        try {
            if (it.hasNext()) {
                subscriber.onSubscribe(subscriber instanceof ConditionalSubscriber ? new IteratorConditionalSubscription((ConditionalSubscriber) subscriber, it) : new IteratorSubscription(subscriber, it));
            } else {
                EmptySubscription.complete(subscriber);
            }
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            EmptySubscription.error(th, subscriber);
        }
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        try {
            subscribe(subscriber, this.b.iterator());
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            EmptySubscription.error(th, subscriber);
        }
    }
}
