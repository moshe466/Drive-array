package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.operators.flowable.FlowableGroupJoin;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class FlowableJoin<TLeft, TRight, TLeftEnd, TRightEnd, R> extends AbstractFlowableWithUpstream<TLeft, R> {
    final Publisher<? extends TRight> c;
    final Function<? super TLeft, ? extends Publisher<TLeftEnd>> d;
    final Function<? super TRight, ? extends Publisher<TRightEnd>> e;
    final BiFunction<? super TLeft, ? super TRight, ? extends R> f;

    /* loaded from: classes2.dex */
    static final class JoinSubscription<TLeft, TRight, TLeftEnd, TRightEnd, R> extends AtomicInteger implements Subscription, FlowableGroupJoin.JoinSupport {
        static final Integer o = 1;
        static final Integer p = 2;
        static final Integer q = 3;
        static final Integer r = 4;
        private static final long serialVersionUID = -6071216598687999801L;
        final Subscriber<? super R> a;
        final Function<? super TLeft, ? extends Publisher<TLeftEnd>> h;
        final Function<? super TRight, ? extends Publisher<TRightEnd>> i;
        final BiFunction<? super TLeft, ? super TRight, ? extends R> j;
        int l;
        int m;
        volatile boolean n;
        final AtomicLong b = new AtomicLong();
        final CompositeDisposable d = new CompositeDisposable();
        final SpscLinkedArrayQueue<Object> c = new SpscLinkedArrayQueue<>(Flowable.bufferSize());
        final Map<Integer, TLeft> e = new LinkedHashMap();
        final Map<Integer, TRight> f = new LinkedHashMap();
        final AtomicReference<Throwable> g = new AtomicReference<>();
        final AtomicInteger k = new AtomicInteger(2);

        JoinSubscription(Subscriber<? super R> subscriber, Function<? super TLeft, ? extends Publisher<TLeftEnd>> function, Function<? super TRight, ? extends Publisher<TRightEnd>> function2, BiFunction<? super TLeft, ? super TRight, ? extends R> biFunction) {
            this.a = subscriber;
            this.h = function;
            this.i = function2;
            this.j = biFunction;
        }

        void a() {
            this.d.dispose();
        }

        void a(Throwable th, Subscriber<?> subscriber, SimpleQueue<?> simpleQueue) {
            Exceptions.throwIfFatal(th);
            ExceptionHelper.addThrowable(this.g, th);
            simpleQueue.clear();
            a();
            a(subscriber);
        }

        void a(Subscriber<?> subscriber) {
            Throwable terminate = ExceptionHelper.terminate(this.g);
            this.e.clear();
            this.f.clear();
            subscriber.onError(terminate);
        }

        /* JADX WARN: Code restructure failed: missing block: B:48:0x00fc, code lost:
        
            if (r13 != 0) goto L53;
         */
        /* JADX WARN: Code restructure failed: missing block: B:49:0x00fe, code lost:
        
            io.reactivex.internal.util.BackpressureHelper.produced(r17.b, r13);
         */
        /* JADX WARN: Code restructure failed: missing block: B:85:0x0198, code lost:
        
            if (r13 != 0) goto L53;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        void b() {
            /*
                Method dump skipped, instructions count: 452
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowableJoin.JoinSubscription.b():void");
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (this.n) {
                return;
            }
            this.n = true;
            a();
            if (getAndIncrement() == 0) {
                this.c.clear();
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableGroupJoin.JoinSupport
        public void innerClose(boolean z, FlowableGroupJoin.LeftRightEndSubscriber leftRightEndSubscriber) {
            synchronized (this) {
                this.c.offer(z ? q : r, leftRightEndSubscriber);
            }
            b();
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableGroupJoin.JoinSupport
        public void innerCloseError(Throwable th) {
            if (ExceptionHelper.addThrowable(this.g, th)) {
                b();
            } else {
                RxJavaPlugins.onError(th);
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableGroupJoin.JoinSupport
        public void innerComplete(FlowableGroupJoin.LeftRightSubscriber leftRightSubscriber) {
            this.d.delete(leftRightSubscriber);
            this.k.decrementAndGet();
            b();
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableGroupJoin.JoinSupport
        public void innerError(Throwable th) {
            if (!ExceptionHelper.addThrowable(this.g, th)) {
                RxJavaPlugins.onError(th);
            } else {
                this.k.decrementAndGet();
                b();
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableGroupJoin.JoinSupport
        public void innerValue(boolean z, Object obj) {
            synchronized (this) {
                this.c.offer(z ? o : p, obj);
            }
            b();
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                BackpressureHelper.add(this.b, j);
            }
        }
    }

    public FlowableJoin(Flowable<TLeft> flowable, Publisher<? extends TRight> publisher, Function<? super TLeft, ? extends Publisher<TLeftEnd>> function, Function<? super TRight, ? extends Publisher<TRightEnd>> function2, BiFunction<? super TLeft, ? super TRight, ? extends R> biFunction) {
        super(flowable);
        this.c = publisher;
        this.d = function;
        this.e = function2;
        this.f = biFunction;
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super R> subscriber) {
        JoinSubscription joinSubscription = new JoinSubscription(subscriber, this.d, this.e, this.f);
        subscriber.onSubscribe(joinSubscription);
        FlowableGroupJoin.LeftRightSubscriber leftRightSubscriber = new FlowableGroupJoin.LeftRightSubscriber(joinSubscription, true);
        joinSubscription.d.add(leftRightSubscriber);
        FlowableGroupJoin.LeftRightSubscriber leftRightSubscriber2 = new FlowableGroupJoin.LeftRightSubscriber(joinSubscription, false);
        joinSubscription.d.add(leftRightSubscriber2);
        this.b.subscribe((FlowableSubscriber) leftRightSubscriber);
        this.c.subscribe(leftRightSubscriber2);
    }
}
