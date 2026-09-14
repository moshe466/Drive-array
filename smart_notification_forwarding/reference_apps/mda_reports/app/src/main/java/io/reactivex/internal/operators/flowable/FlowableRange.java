package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.annotations.Nullable;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.subscriptions.BasicQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import org.reactivestreams.Subscriber;

/* loaded from: classes2.dex */
public final class FlowableRange extends Flowable<Integer> {
    final int b;
    final int c;

    /* loaded from: classes2.dex */
    static abstract class BaseRangeSubscription extends BasicQueueSubscription<Integer> {
        private static final long serialVersionUID = -2252972430506210021L;
        final int a;
        int b;
        volatile boolean c;

        BaseRangeSubscription(int i, int i2) {
            this.b = i;
            this.a = i2;
        }

        abstract void a();

        abstract void a(long j);

        @Override // org.reactivestreams.Subscription
        public final void cancel() {
            this.c = true;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public final void clear() {
            this.b = this.a;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public final boolean isEmpty() {
            return this.b == this.a;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        @Nullable
        public final Integer poll() {
            int i = this.b;
            if (i == this.a) {
                return null;
            }
            this.b = i + 1;
            return Integer.valueOf(i);
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

    /* loaded from: classes2.dex */
    static final class RangeConditionalSubscription extends BaseRangeSubscription {
        private static final long serialVersionUID = 2587302975077663557L;
        final ConditionalSubscriber<? super Integer> d;

        RangeConditionalSubscription(ConditionalSubscriber<? super Integer> conditionalSubscriber, int i, int i2) {
            super(i, i2);
            this.d = conditionalSubscriber;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableRange.BaseRangeSubscription
        void a() {
            int i = this.a;
            ConditionalSubscriber<? super Integer> conditionalSubscriber = this.d;
            for (int i2 = this.b; i2 != i; i2++) {
                if (this.c) {
                    return;
                }
                conditionalSubscriber.tryOnNext(Integer.valueOf(i2));
            }
            if (this.c) {
                return;
            }
            conditionalSubscriber.onComplete();
        }

        /* JADX WARN: Code restructure failed: missing block: B:11:0x0037, code lost:
        
            r9.b = r1;
            r5 = addAndGet(-r10);
         */
        @Override // io.reactivex.internal.operators.flowable.FlowableRange.BaseRangeSubscription
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        void a(long r10) {
            /*
                r9 = this;
                int r0 = r9.a
                int r1 = r9.b
                io.reactivex.internal.fuseable.ConditionalSubscriber<? super java.lang.Integer> r2 = r9.d
                r3 = 0
                r5 = r10
            L9:
                r10 = r3
            La:
                int r7 = (r10 > r5 ? 1 : (r10 == r5 ? 0 : -1))
                if (r7 == 0) goto L25
                if (r1 == r0) goto L25
                boolean r7 = r9.c
                if (r7 == 0) goto L15
                return
            L15:
                java.lang.Integer r7 = java.lang.Integer.valueOf(r1)
                boolean r7 = r2.tryOnNext(r7)
                if (r7 == 0) goto L22
                r7 = 1
                long r10 = r10 + r7
            L22:
                int r1 = r1 + 1
                goto La
            L25:
                if (r1 != r0) goto L2f
                boolean r10 = r9.c
                if (r10 != 0) goto L2e
                r2.onComplete()
            L2e:
                return
            L2f:
                long r5 = r9.get()
                int r7 = (r10 > r5 ? 1 : (r10 == r5 ? 0 : -1))
                if (r7 != 0) goto La
                r9.b = r1
                long r10 = -r10
                long r5 = r9.addAndGet(r10)
                int r10 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
                if (r10 != 0) goto L9
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowableRange.RangeConditionalSubscription.a(long):void");
        }
    }

    /* loaded from: classes2.dex */
    static final class RangeSubscription extends BaseRangeSubscription {
        private static final long serialVersionUID = 2587302975077663557L;
        final Subscriber<? super Integer> d;

        RangeSubscription(Subscriber<? super Integer> subscriber, int i, int i2) {
            super(i, i2);
            this.d = subscriber;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableRange.BaseRangeSubscription
        void a() {
            int i = this.a;
            Subscriber<? super Integer> subscriber = this.d;
            for (int i2 = this.b; i2 != i; i2++) {
                if (this.c) {
                    return;
                }
                subscriber.onNext(Integer.valueOf(i2));
            }
            if (this.c) {
                return;
            }
            subscriber.onComplete();
        }

        /* JADX WARN: Code restructure failed: missing block: B:11:0x0034, code lost:
        
            r9.b = r1;
            r5 = addAndGet(-r10);
         */
        @Override // io.reactivex.internal.operators.flowable.FlowableRange.BaseRangeSubscription
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        void a(long r10) {
            /*
                r9 = this;
                int r0 = r9.a
                int r1 = r9.b
                org.reactivestreams.Subscriber<? super java.lang.Integer> r2 = r9.d
                r3 = 0
                r5 = r10
            L9:
                r10 = r3
            La:
                int r7 = (r10 > r5 ? 1 : (r10 == r5 ? 0 : -1))
                if (r7 == 0) goto L22
                if (r1 == r0) goto L22
                boolean r7 = r9.c
                if (r7 == 0) goto L15
                return
            L15:
                java.lang.Integer r7 = java.lang.Integer.valueOf(r1)
                r2.onNext(r7)
                r7 = 1
                long r10 = r10 + r7
                int r1 = r1 + 1
                goto La
            L22:
                if (r1 != r0) goto L2c
                boolean r10 = r9.c
                if (r10 != 0) goto L2b
                r2.onComplete()
            L2b:
                return
            L2c:
                long r5 = r9.get()
                int r7 = (r10 > r5 ? 1 : (r10 == r5 ? 0 : -1))
                if (r7 != 0) goto La
                r9.b = r1
                long r10 = -r10
                long r5 = r9.addAndGet(r10)
                int r10 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
                if (r10 != 0) goto L9
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowableRange.RangeSubscription.a(long):void");
        }
    }

    public FlowableRange(int i, int i2) {
        this.b = i;
        this.c = i + i2;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super Integer> subscriber) {
        subscriber.onSubscribe(subscriber instanceof ConditionalSubscriber ? new RangeConditionalSubscription((ConditionalSubscriber) subscriber, this.b, this.c) : new RangeSubscription(subscriber, this.b, this.c));
    }
}
