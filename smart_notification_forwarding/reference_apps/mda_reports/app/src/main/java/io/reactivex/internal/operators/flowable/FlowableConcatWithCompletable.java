package io.reactivex.internal.operators.flowable;

import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class FlowableConcatWithCompletable<T> extends AbstractFlowableWithUpstream<T, T> {
    final CompletableSource c;

    /* loaded from: classes2.dex */
    static final class ConcatWithSubscriber<T> extends AtomicReference<Disposable> implements FlowableSubscriber<T>, CompletableObserver, Subscription {
        private static final long serialVersionUID = -7346385463600070225L;
        final Subscriber<? super T> a;
        Subscription b;
        CompletableSource c;
        boolean d;

        ConcatWithSubscriber(Subscriber<? super T> subscriber, CompletableSource completableSource) {
            this.a = subscriber;
            this.c = completableSource;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.b.cancel();
            DisposableHelper.dispose(this);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.d) {
                this.a.onComplete();
                return;
            }
            this.d = true;
            this.b = SubscriptionHelper.CANCELLED;
            CompletableSource completableSource = this.c;
            this.c = null;
            completableSource.subscribe(this);
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.a.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            this.a.onNext(t);
        }

        @Override // io.reactivex.CompletableObserver
        public void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this, disposable);
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.b, subscription)) {
                this.b = subscription;
                this.a.onSubscribe(this);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            this.b.request(j);
        }
    }

    public FlowableConcatWithCompletable(Flowable<T> flowable, CompletableSource completableSource) {
        super(flowable);
        this.c = completableSource;
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super T> subscriber) {
        this.b.subscribe((FlowableSubscriber) new ConcatWithSubscriber(subscriber, this.c));
    }
}
