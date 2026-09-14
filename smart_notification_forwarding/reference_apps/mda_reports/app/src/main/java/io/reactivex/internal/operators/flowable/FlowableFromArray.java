package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.annotations.Nullable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.subscriptions.BasicQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import org.reactivestreams.Subscriber;

/* loaded from: classes2.dex */
public final class FlowableFromArray<T> extends Flowable<T> {
    final T[] b;

    /* loaded from: classes2.dex */
    static final class ArrayConditionalSubscription<T> extends BaseArraySubscription<T> {
        private static final long serialVersionUID = 2587302975077663557L;
        final ConditionalSubscriber<? super T> d;

        ArrayConditionalSubscription(ConditionalSubscriber<? super T> conditionalSubscriber, T[] tArr) {
            super(tArr);
            this.d = conditionalSubscriber;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableFromArray.BaseArraySubscription
        void a() {
            T[] tArr = this.a;
            int length = tArr.length;
            ConditionalSubscriber<? super T> conditionalSubscriber = this.d;
            for (int i = this.b; i != length; i++) {
                if (this.c) {
                    return;
                }
                T t = tArr[i];
                if (t == null) {
                    conditionalSubscriber.onError(new NullPointerException("array element is null"));
                    return;
                }
                conditionalSubscriber.tryOnNext(t);
            }
            if (this.c) {
                return;
            }
            conditionalSubscriber.onComplete();
        }

        /* JADX WARN: Code restructure failed: missing block: B:11:0x0043, code lost:
        
            r10.b = r2;
            r6 = addAndGet(-r11);
         */
        @Override // io.reactivex.internal.operators.flowable.FlowableFromArray.BaseArraySubscription
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        void a(long r11) {
            /*
                r10 = this;
                T[] r0 = r10.a
                int r1 = r0.length
                int r2 = r10.b
                io.reactivex.internal.fuseable.ConditionalSubscriber<? super T> r3 = r10.d
                r4 = 0
                r6 = r11
            La:
                r11 = r4
            Lb:
                int r8 = (r11 > r6 ? 1 : (r11 == r6 ? 0 : -1))
                if (r8 == 0) goto L31
                if (r2 == r1) goto L31
                boolean r8 = r10.c
                if (r8 == 0) goto L16
                return
            L16:
                r8 = r0[r2]
                if (r8 != 0) goto L25
                java.lang.NullPointerException r11 = new java.lang.NullPointerException
                java.lang.String r12 = "array element is null"
                r11.<init>(r12)
                r3.onError(r11)
                return
            L25:
                boolean r8 = r3.tryOnNext(r8)
                if (r8 == 0) goto L2e
                r8 = 1
                long r11 = r11 + r8
            L2e:
                int r2 = r2 + 1
                goto Lb
            L31:
                if (r2 != r1) goto L3b
                boolean r11 = r10.c
                if (r11 != 0) goto L3a
                r3.onComplete()
            L3a:
                return
            L3b:
                long r6 = r10.get()
                int r8 = (r11 > r6 ? 1 : (r11 == r6 ? 0 : -1))
                if (r8 != 0) goto Lb
                r10.b = r2
                long r11 = -r11
                long r6 = r10.addAndGet(r11)
                int r11 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
                if (r11 != 0) goto La
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowableFromArray.ArrayConditionalSubscription.a(long):void");
        }
    }

    /* loaded from: classes2.dex */
    static final class ArraySubscription<T> extends BaseArraySubscription<T> {
        private static final long serialVersionUID = 2587302975077663557L;
        final Subscriber<? super T> d;

        ArraySubscription(Subscriber<? super T> subscriber, T[] tArr) {
            super(tArr);
            this.d = subscriber;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableFromArray.BaseArraySubscription
        void a() {
            T[] tArr = this.a;
            int length = tArr.length;
            Subscriber<? super T> subscriber = this.d;
            for (int i = this.b; i != length; i++) {
                if (this.c) {
                    return;
                }
                T t = tArr[i];
                if (t == null) {
                    subscriber.onError(new NullPointerException("array element is null"));
                    return;
                }
                subscriber.onNext(t);
            }
            if (this.c) {
                return;
            }
            subscriber.onComplete();
        }

        /* JADX WARN: Code restructure failed: missing block: B:11:0x0040, code lost:
        
            r10.b = r2;
            r6 = addAndGet(-r11);
         */
        @Override // io.reactivex.internal.operators.flowable.FlowableFromArray.BaseArraySubscription
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        void a(long r11) {
            /*
                r10 = this;
                T[] r0 = r10.a
                int r1 = r0.length
                int r2 = r10.b
                org.reactivestreams.Subscriber<? super T> r3 = r10.d
                r4 = 0
                r6 = r11
            La:
                r11 = r4
            Lb:
                int r8 = (r11 > r6 ? 1 : (r11 == r6 ? 0 : -1))
                if (r8 == 0) goto L2e
                if (r2 == r1) goto L2e
                boolean r8 = r10.c
                if (r8 == 0) goto L16
                return
            L16:
                r8 = r0[r2]
                if (r8 != 0) goto L25
                java.lang.NullPointerException r11 = new java.lang.NullPointerException
                java.lang.String r12 = "array element is null"
                r11.<init>(r12)
                r3.onError(r11)
                return
            L25:
                r3.onNext(r8)
                r8 = 1
                long r11 = r11 + r8
                int r2 = r2 + 1
                goto Lb
            L2e:
                if (r2 != r1) goto L38
                boolean r11 = r10.c
                if (r11 != 0) goto L37
                r3.onComplete()
            L37:
                return
            L38:
                long r6 = r10.get()
                int r8 = (r11 > r6 ? 1 : (r11 == r6 ? 0 : -1))
                if (r8 != 0) goto Lb
                r10.b = r2
                long r11 = -r11
                long r6 = r10.addAndGet(r11)
                int r11 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
                if (r11 != 0) goto La
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowableFromArray.ArraySubscription.a(long):void");
        }
    }

    /* loaded from: classes2.dex */
    static abstract class BaseArraySubscription<T> extends BasicQueueSubscription<T> {
        private static final long serialVersionUID = -2252972430506210021L;
        final T[] a;
        int b;
        volatile boolean c;

        BaseArraySubscription(T[] tArr) {
            this.a = tArr;
        }

        abstract void a();

        abstract void a(long j);

        @Override // org.reactivestreams.Subscription
        public final void cancel() {
            this.c = true;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public final void clear() {
            this.b = this.a.length;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public final boolean isEmpty() {
            return this.b == this.a.length;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        @Nullable
        public final T poll() {
            int i = this.b;
            T[] tArr = this.a;
            if (i == tArr.length) {
                return null;
            }
            this.b = i + 1;
            return (T) ObjectHelper.requireNonNull(tArr[i], "array element is null");
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

    public FlowableFromArray(T[] tArr) {
        this.b = tArr;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        subscriber.onSubscribe(subscriber instanceof ConditionalSubscriber ? new ArrayConditionalSubscription((ConditionalSubscriber) subscriber, this.b) : new ArraySubscription(subscriber, this.b));
    }
}
