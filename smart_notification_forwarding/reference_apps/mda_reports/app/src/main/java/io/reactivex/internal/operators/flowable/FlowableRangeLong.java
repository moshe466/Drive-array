package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.annotations.Nullable;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.subscriptions.BasicQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import org.reactivestreams.Subscriber;

/* loaded from: classes2.dex */
public final class FlowableRangeLong extends Flowable<Long> {
    final long b;
    final long c;

    /* loaded from: classes2.dex */
    static abstract class BaseRangeSubscription extends BasicQueueSubscription<Long> {
        private static final long serialVersionUID = -2252972430506210021L;
        final long a;
        long b;
        volatile boolean c;

        BaseRangeSubscription(long j, long j2) {
            this.b = j;
            this.a = j2;
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
        public final Long poll() {
            long j = this.b;
            if (j == this.a) {
                return null;
            }
            this.b = 1 + j;
            return Long.valueOf(j);
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
        final ConditionalSubscriber<? super Long> d;

        RangeConditionalSubscription(ConditionalSubscriber<? super Long> conditionalSubscriber, long j, long j2) {
            super(j, j2);
            this.d = conditionalSubscriber;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableRangeLong.BaseRangeSubscription
        void a() {
            long j = this.a;
            ConditionalSubscriber<? super Long> conditionalSubscriber = this.d;
            for (long j2 = this.b; j2 != j; j2++) {
                if (this.c) {
                    return;
                }
                conditionalSubscriber.tryOnNext(Long.valueOf(j2));
            }
            if (this.c) {
                return;
            }
            conditionalSubscriber.onComplete();
        }

        /* JADX WARN: Code restructure failed: missing block: B:13:0x003b, code lost:
        
            r12.b = r7;
            r2 = addAndGet(-r13);
         */
        @Override // io.reactivex.internal.operators.flowable.FlowableRangeLong.BaseRangeSubscription
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        void a(long r13) {
            /*
                r12 = this;
                long r0 = r12.a
                long r2 = r12.b
                io.reactivex.internal.fuseable.ConditionalSubscriber<? super java.lang.Long> r4 = r12.d
                r5 = 0
                r7 = r2
                r2 = r13
            La:
                r13 = r5
            Lb:
                int r9 = (r13 > r2 ? 1 : (r13 == r2 ? 0 : -1))
                if (r9 == 0) goto L27
                int r9 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
                if (r9 == 0) goto L27
                boolean r9 = r12.c
                if (r9 == 0) goto L18
                return
            L18:
                java.lang.Long r9 = java.lang.Long.valueOf(r7)
                boolean r9 = r4.tryOnNext(r9)
                r10 = 1
                if (r9 == 0) goto L25
                long r13 = r13 + r10
            L25:
                long r7 = r7 + r10
                goto Lb
            L27:
                int r2 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
                if (r2 != 0) goto L33
                boolean r13 = r12.c
                if (r13 != 0) goto L32
                r4.onComplete()
            L32:
                return
            L33:
                long r2 = r12.get()
                int r9 = (r13 > r2 ? 1 : (r13 == r2 ? 0 : -1))
                if (r9 != 0) goto Lb
                r12.b = r7
                long r13 = -r13
                long r2 = r12.addAndGet(r13)
                int r13 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
                if (r13 != 0) goto La
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowableRangeLong.RangeConditionalSubscription.a(long):void");
        }
    }

    /* loaded from: classes2.dex */
    static final class RangeSubscription extends BaseRangeSubscription {
        private static final long serialVersionUID = 2587302975077663557L;
        final Subscriber<? super Long> d;

        RangeSubscription(Subscriber<? super Long> subscriber, long j, long j2) {
            super(j, j2);
            this.d = subscriber;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableRangeLong.BaseRangeSubscription
        void a() {
            long j = this.a;
            Subscriber<? super Long> subscriber = this.d;
            for (long j2 = this.b; j2 != j; j2++) {
                if (this.c) {
                    return;
                }
                subscriber.onNext(Long.valueOf(j2));
            }
            if (this.c) {
                return;
            }
            subscriber.onComplete();
        }

        /* JADX WARN: Code restructure failed: missing block: B:13:0x0038, code lost:
        
            r11.b = r7;
            r2 = addAndGet(-r12);
         */
        @Override // io.reactivex.internal.operators.flowable.FlowableRangeLong.BaseRangeSubscription
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        void a(long r12) {
            /*
                r11 = this;
                long r0 = r11.a
                long r2 = r11.b
                org.reactivestreams.Subscriber<? super java.lang.Long> r4 = r11.d
                r5 = 0
                r7 = r2
                r2 = r12
            La:
                r12 = r5
            Lb:
                int r9 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
                if (r9 == 0) goto L24
                int r9 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
                if (r9 == 0) goto L24
                boolean r9 = r11.c
                if (r9 == 0) goto L18
                return
            L18:
                java.lang.Long r9 = java.lang.Long.valueOf(r7)
                r4.onNext(r9)
                r9 = 1
                long r12 = r12 + r9
                long r7 = r7 + r9
                goto Lb
            L24:
                int r2 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
                if (r2 != 0) goto L30
                boolean r12 = r11.c
                if (r12 != 0) goto L2f
                r4.onComplete()
            L2f:
                return
            L30:
                long r2 = r11.get()
                int r9 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
                if (r9 != 0) goto Lb
                r11.b = r7
                long r12 = -r12
                long r2 = r11.addAndGet(r12)
                int r12 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
                if (r12 != 0) goto La
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowableRangeLong.RangeSubscription.a(long):void");
        }
    }

    public FlowableRangeLong(long j, long j2) {
        this.b = j;
        this.c = j + j2;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super Long> subscriber) {
        subscriber.onSubscribe(subscriber instanceof ConditionalSubscriber ? new RangeConditionalSubscription((ConditionalSubscriber) subscriber, this.b, this.c) : new RangeSubscription(subscriber, this.b, this.c));
    }
}
