package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class FlowableOnErrorNext<T> extends AbstractFlowableWithUpstream<T, T> {
    final Function<? super Throwable, ? extends Publisher<? extends T>> c;
    final boolean d;

    /* loaded from: classes2.dex */
    static final class OnErrorNextSubscriber<T> implements FlowableSubscriber<T> {
        final Subscriber<? super T> a;
        final Function<? super Throwable, ? extends Publisher<? extends T>> b;
        final boolean c;
        final SubscriptionArbiter d = new SubscriptionArbiter();
        boolean e;
        boolean f;

        OnErrorNextSubscriber(Subscriber<? super T> subscriber, Function<? super Throwable, ? extends Publisher<? extends T>> function, boolean z) {
            this.a = subscriber;
            this.b = function;
            this.c = z;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.f) {
                return;
            }
            this.f = true;
            this.e = true;
            this.a.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.e) {
                if (this.f) {
                    RxJavaPlugins.onError(th);
                    return;
                } else {
                    this.a.onError(th);
                    return;
                }
            }
            this.e = true;
            if (this.c && !(th instanceof Exception)) {
                this.a.onError(th);
                return;
            }
            try {
                Publisher<? extends T> apply = this.b.apply(th);
                if (apply != null) {
                    apply.subscribe(this);
                    return;
                }
                NullPointerException nullPointerException = new NullPointerException("Publisher is null");
                nullPointerException.initCause(th);
                this.a.onError(nullPointerException);
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                this.a.onError(new CompositeException(th, th2));
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (this.f) {
                return;
            }
            this.a.onNext(t);
            if (this.e) {
                return;
            }
            this.d.produced(1L);
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            this.d.setSubscription(subscription);
        }
    }

    public FlowableOnErrorNext(Flowable<T> flowable, Function<? super Throwable, ? extends Publisher<? extends T>> function, boolean z) {
        super(flowable);
        this.c = function;
        this.d = z;
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super T> subscriber) {
        OnErrorNextSubscriber onErrorNextSubscriber = new OnErrorNextSubscriber(subscriber, this.c, this.d);
        subscriber.onSubscribe(onErrorNextSubscriber.d);
        this.b.subscribe((FlowableSubscriber) onErrorNextSubscriber);
    }
}
