package io.reactivex.internal.operators.flowable;

import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.HalfSerializer;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class FlowableMergeWithCompletable<T> extends AbstractFlowableWithUpstream<T, T> {
    final CompletableSource c;

    /* loaded from: classes2.dex */
    static final class MergeWithSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = -4592979584110982903L;
        final Subscriber<? super T> a;
        final AtomicReference<Subscription> b = new AtomicReference<>();
        final OtherObserver c = new OtherObserver(this);
        final AtomicThrowable d = new AtomicThrowable();
        final AtomicLong e = new AtomicLong();
        volatile boolean f;
        volatile boolean g;

        /* loaded from: classes2.dex */
        static final class OtherObserver extends AtomicReference<Disposable> implements CompletableObserver {
            private static final long serialVersionUID = -2935427570954647017L;
            final MergeWithSubscriber<?> a;

            OtherObserver(MergeWithSubscriber<?> mergeWithSubscriber) {
                this.a = mergeWithSubscriber;
            }

            @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
            public void onComplete() {
                this.a.a();
            }

            @Override // io.reactivex.CompletableObserver
            public void onError(Throwable th) {
                this.a.a(th);
            }

            @Override // io.reactivex.CompletableObserver
            public void onSubscribe(Disposable disposable) {
                DisposableHelper.setOnce(this, disposable);
            }
        }

        MergeWithSubscriber(Subscriber<? super T> subscriber) {
            this.a = subscriber;
        }

        void a() {
            this.g = true;
            if (this.f) {
                HalfSerializer.onComplete(this.a, this, this.d);
            }
        }

        void a(Throwable th) {
            SubscriptionHelper.cancel(this.b);
            HalfSerializer.onError(this.a, th, this, this.d);
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            SubscriptionHelper.cancel(this.b);
            DisposableHelper.dispose(this.c);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.f = true;
            if (this.g) {
                HalfSerializer.onComplete(this.a, this, this.d);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            SubscriptionHelper.cancel(this.b);
            HalfSerializer.onError(this.a, th, this, this.d);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            HalfSerializer.onNext(this.a, t, this, this.d);
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            SubscriptionHelper.deferredSetOnce(this.b, this.e, subscription);
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            SubscriptionHelper.deferredRequest(this.b, this.e, j);
        }
    }

    public FlowableMergeWithCompletable(Flowable<T> flowable, CompletableSource completableSource) {
        super(flowable);
        this.c = completableSource;
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super T> subscriber) {
        MergeWithSubscriber mergeWithSubscriber = new MergeWithSubscriber(subscriber);
        subscriber.onSubscribe(mergeWithSubscriber);
        this.b.subscribe((FlowableSubscriber) mergeWithSubscriber);
        this.c.subscribe(mergeWithSubscriber.c);
    }
}
