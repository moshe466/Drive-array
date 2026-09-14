package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class FlowableConcatArray<T> extends Flowable<T> {
    final Publisher<? extends T>[] b;
    final boolean c;

    /* loaded from: classes2.dex */
    static final class ConcatArraySubscriber<T> extends SubscriptionArbiter implements FlowableSubscriber<T> {
        private static final long serialVersionUID = -8158322871608889516L;
        final Subscriber<? super T> h;
        final Publisher<? extends T>[] i;
        final boolean j;
        final AtomicInteger k = new AtomicInteger();
        int l;
        List<Throwable> m;
        long n;

        ConcatArraySubscriber(Publisher<? extends T>[] publisherArr, boolean z, Subscriber<? super T> subscriber) {
            this.h = subscriber;
            this.i = publisherArr;
            this.j = z;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.k.getAndIncrement() == 0) {
                Publisher<? extends T>[] publisherArr = this.i;
                int length = publisherArr.length;
                int i = this.l;
                while (i != length) {
                    Publisher<? extends T> publisher = publisherArr[i];
                    if (publisher == null) {
                        NullPointerException nullPointerException = new NullPointerException("A Publisher entry is null");
                        if (!this.j) {
                            this.h.onError(nullPointerException);
                            return;
                        }
                        List list = this.m;
                        if (list == null) {
                            list = new ArrayList((length - i) + 1);
                            this.m = list;
                        }
                        list.add(nullPointerException);
                        i++;
                    } else {
                        long j = this.n;
                        if (j != 0) {
                            this.n = 0L;
                            produced(j);
                        }
                        publisher.subscribe(this);
                        i++;
                        this.l = i;
                        if (this.k.decrementAndGet() == 0) {
                            return;
                        }
                    }
                }
                List<Throwable> list2 = this.m;
                if (list2 == null) {
                    this.h.onComplete();
                } else if (list2.size() == 1) {
                    this.h.onError(list2.get(0));
                } else {
                    this.h.onError(new CompositeException(list2));
                }
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (!this.j) {
                this.h.onError(th);
                return;
            }
            List list = this.m;
            if (list == null) {
                list = new ArrayList((this.i.length - this.l) + 1);
                this.m = list;
            }
            list.add(th);
            onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            this.n++;
            this.h.onNext(t);
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            setSubscription(subscription);
        }
    }

    public FlowableConcatArray(Publisher<? extends T>[] publisherArr, boolean z) {
        this.b = publisherArr;
        this.c = z;
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super T> subscriber) {
        ConcatArraySubscriber concatArraySubscriber = new ConcatArraySubscriber(this.b, this.c, subscriber);
        subscriber.onSubscribe(concatArraySubscriber);
        concatArraySubscriber.onComplete();
    }
}
