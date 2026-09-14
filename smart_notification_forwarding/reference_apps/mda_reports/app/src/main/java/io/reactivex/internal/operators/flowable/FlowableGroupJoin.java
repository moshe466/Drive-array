package io.reactivex.internal.operators.flowable;

import android.R;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.processors.UnicastProcessor;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class FlowableGroupJoin<TLeft, TRight, TLeftEnd, TRightEnd, R> extends AbstractFlowableWithUpstream<TLeft, R> {
    final Publisher<? extends TRight> c;
    final Function<? super TLeft, ? extends Publisher<TLeftEnd>> d;
    final Function<? super TRight, ? extends Publisher<TRightEnd>> e;
    final BiFunction<? super TLeft, ? super Flowable<TRight>, ? extends R> f;

    /* loaded from: classes2.dex */
    static final class GroupJoinSubscription<TLeft, TRight, TLeftEnd, TRightEnd, R> extends AtomicInteger implements Subscription, JoinSupport {
        static final Integer o = 1;
        static final Integer p = 2;
        static final Integer q = 3;
        static final Integer r = 4;
        private static final long serialVersionUID = -6071216598687999801L;
        final Subscriber<? super R> a;
        final Function<? super TLeft, ? extends Publisher<TLeftEnd>> h;
        final Function<? super TRight, ? extends Publisher<TRightEnd>> i;
        final BiFunction<? super TLeft, ? super Flowable<TRight>, ? extends R> j;
        int l;
        int m;
        volatile boolean n;
        final AtomicLong b = new AtomicLong();
        final CompositeDisposable d = new CompositeDisposable();
        final SpscLinkedArrayQueue<Object> c = new SpscLinkedArrayQueue<>(Flowable.bufferSize());
        final Map<Integer, UnicastProcessor<TRight>> e = new LinkedHashMap();
        final Map<Integer, TRight> f = new LinkedHashMap();
        final AtomicReference<Throwable> g = new AtomicReference<>();
        final AtomicInteger k = new AtomicInteger(2);

        GroupJoinSubscription(Subscriber<? super R> subscriber, Function<? super TLeft, ? extends Publisher<TLeftEnd>> function, Function<? super TRight, ? extends Publisher<TRightEnd>> function2, BiFunction<? super TLeft, ? super Flowable<TRight>, ? extends R> biFunction) {
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
            Iterator<UnicastProcessor<TRight>> it = this.e.values().iterator();
            while (it.hasNext()) {
                it.next().onError(terminate);
            }
            this.e.clear();
            this.f.clear();
            subscriber.onError(terminate);
        }

        void b() {
            if (getAndIncrement() != 0) {
                return;
            }
            SpscLinkedArrayQueue<Object> spscLinkedArrayQueue = this.c;
            Subscriber<? super R> subscriber = this.a;
            int i = 1;
            while (!this.n) {
                if (this.g.get() != null) {
                    spscLinkedArrayQueue.clear();
                    a();
                    a(subscriber);
                    return;
                }
                boolean z = this.k.get() == 0;
                Integer num = (Integer) spscLinkedArrayQueue.poll();
                boolean z2 = num == null;
                if (z && z2) {
                    Iterator<UnicastProcessor<TRight>> it = this.e.values().iterator();
                    while (it.hasNext()) {
                        it.next().onComplete();
                    }
                    this.e.clear();
                    this.f.clear();
                    this.d.dispose();
                    subscriber.onComplete();
                    return;
                }
                if (z2) {
                    i = addAndGet(-i);
                    if (i == 0) {
                        return;
                    }
                } else {
                    Object poll = spscLinkedArrayQueue.poll();
                    if (num == o) {
                        UnicastProcessor create = UnicastProcessor.create();
                        int i2 = this.l;
                        this.l = i2 + 1;
                        this.e.put(Integer.valueOf(i2), create);
                        try {
                            Publisher publisher = (Publisher) ObjectHelper.requireNonNull(this.h.apply(poll), "The leftEnd returned a null Publisher");
                            LeftRightEndSubscriber leftRightEndSubscriber = new LeftRightEndSubscriber(this, true, i2);
                            this.d.add(leftRightEndSubscriber);
                            publisher.subscribe(leftRightEndSubscriber);
                            if (this.g.get() != null) {
                                spscLinkedArrayQueue.clear();
                                a();
                                a(subscriber);
                                return;
                            }
                            try {
                                R.bool boolVar = (Object) ObjectHelper.requireNonNull(this.j.apply(poll, create), "The resultSelector returned a null value");
                                if (this.b.get() == 0) {
                                    a(new MissingBackpressureException("Could not emit value due to lack of requests"), subscriber, spscLinkedArrayQueue);
                                    return;
                                }
                                subscriber.onNext(boolVar);
                                BackpressureHelper.produced(this.b, 1L);
                                Iterator<TRight> it2 = this.f.values().iterator();
                                while (it2.hasNext()) {
                                    create.onNext(it2.next());
                                }
                            } catch (Throwable th) {
                                a(th, subscriber, spscLinkedArrayQueue);
                                return;
                            }
                        } catch (Throwable th2) {
                            a(th2, subscriber, spscLinkedArrayQueue);
                            return;
                        }
                    } else if (num == p) {
                        int i3 = this.m;
                        this.m = i3 + 1;
                        this.f.put(Integer.valueOf(i3), poll);
                        try {
                            Publisher publisher2 = (Publisher) ObjectHelper.requireNonNull(this.i.apply(poll), "The rightEnd returned a null Publisher");
                            LeftRightEndSubscriber leftRightEndSubscriber2 = new LeftRightEndSubscriber(this, false, i3);
                            this.d.add(leftRightEndSubscriber2);
                            publisher2.subscribe(leftRightEndSubscriber2);
                            if (this.g.get() != null) {
                                spscLinkedArrayQueue.clear();
                                a();
                                a(subscriber);
                                return;
                            } else {
                                Iterator<UnicastProcessor<TRight>> it3 = this.e.values().iterator();
                                while (it3.hasNext()) {
                                    it3.next().onNext(poll);
                                }
                            }
                        } catch (Throwable th3) {
                            a(th3, subscriber, spscLinkedArrayQueue);
                            return;
                        }
                    } else if (num == q) {
                        LeftRightEndSubscriber leftRightEndSubscriber3 = (LeftRightEndSubscriber) poll;
                        UnicastProcessor<TRight> remove = this.e.remove(Integer.valueOf(leftRightEndSubscriber3.c));
                        this.d.remove(leftRightEndSubscriber3);
                        if (remove != null) {
                            remove.onComplete();
                        }
                    } else if (num == r) {
                        LeftRightEndSubscriber leftRightEndSubscriber4 = (LeftRightEndSubscriber) poll;
                        this.f.remove(Integer.valueOf(leftRightEndSubscriber4.c));
                        this.d.remove(leftRightEndSubscriber4);
                    }
                }
            }
            spscLinkedArrayQueue.clear();
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
        public void innerClose(boolean z, LeftRightEndSubscriber leftRightEndSubscriber) {
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
        public void innerComplete(LeftRightSubscriber leftRightSubscriber) {
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

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public interface JoinSupport {
        void innerClose(boolean z, LeftRightEndSubscriber leftRightEndSubscriber);

        void innerCloseError(Throwable th);

        void innerComplete(LeftRightSubscriber leftRightSubscriber);

        void innerError(Throwable th);

        void innerValue(boolean z, Object obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class LeftRightEndSubscriber extends AtomicReference<Subscription> implements FlowableSubscriber<Object>, Disposable {
        private static final long serialVersionUID = 1883890389173668373L;
        final JoinSupport a;
        final boolean b;
        final int c;

        /* JADX INFO: Access modifiers changed from: package-private */
        public LeftRightEndSubscriber(JoinSupport joinSupport, boolean z, int i) {
            this.a = joinSupport;
            this.b = z;
            this.c = i;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            SubscriptionHelper.cancel(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return SubscriptionHelper.isCancelled(get());
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.a.innerClose(this.b, this);
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.a.innerCloseError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(Object obj) {
            if (SubscriptionHelper.cancel(this)) {
                this.a.innerClose(this.b, this);
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            SubscriptionHelper.setOnce(this, subscription, Long.MAX_VALUE);
        }
    }

    /* loaded from: classes2.dex */
    static final class LeftRightSubscriber extends AtomicReference<Subscription> implements FlowableSubscriber<Object>, Disposable {
        private static final long serialVersionUID = 1883890389173668373L;
        final JoinSupport a;
        final boolean b;

        /* JADX INFO: Access modifiers changed from: package-private */
        public LeftRightSubscriber(JoinSupport joinSupport, boolean z) {
            this.a = joinSupport;
            this.b = z;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            SubscriptionHelper.cancel(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return SubscriptionHelper.isCancelled(get());
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.a.innerComplete(this);
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.a.innerError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(Object obj) {
            this.a.innerValue(this.b, obj);
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            SubscriptionHelper.setOnce(this, subscription, Long.MAX_VALUE);
        }
    }

    public FlowableGroupJoin(Flowable<TLeft> flowable, Publisher<? extends TRight> publisher, Function<? super TLeft, ? extends Publisher<TLeftEnd>> function, Function<? super TRight, ? extends Publisher<TRightEnd>> function2, BiFunction<? super TLeft, ? super Flowable<TRight>, ? extends R> biFunction) {
        super(flowable);
        this.c = publisher;
        this.d = function;
        this.e = function2;
        this.f = biFunction;
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super R> subscriber) {
        GroupJoinSubscription groupJoinSubscription = new GroupJoinSubscription(subscriber, this.d, this.e, this.f);
        subscriber.onSubscribe(groupJoinSubscription);
        LeftRightSubscriber leftRightSubscriber = new LeftRightSubscriber(groupJoinSubscription, true);
        groupJoinSubscription.d.add(leftRightSubscriber);
        LeftRightSubscriber leftRightSubscriber2 = new LeftRightSubscriber(groupJoinSubscription, false);
        groupJoinSubscription.d.add(leftRightSubscriber2);
        this.b.subscribe((FlowableSubscriber) leftRightSubscriber);
        this.c.subscribe(leftRightSubscriber2);
    }
}
