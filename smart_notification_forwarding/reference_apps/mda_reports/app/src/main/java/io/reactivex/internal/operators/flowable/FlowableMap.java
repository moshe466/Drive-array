package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.annotations.Nullable;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.subscribers.BasicFuseableConditionalSubscriber;
import io.reactivex.internal.subscribers.BasicFuseableSubscriber;
import org.reactivestreams.Subscriber;

/* loaded from: classes2.dex */
public final class FlowableMap<T, U> extends AbstractFlowableWithUpstream<T, U> {
    final Function<? super T, ? extends U> c;

    /* loaded from: classes2.dex */
    static final class MapConditionalSubscriber<T, U> extends BasicFuseableConditionalSubscriber<T, U> {
        final Function<? super T, ? extends U> f;

        MapConditionalSubscriber(ConditionalSubscriber<? super U> conditionalSubscriber, Function<? super T, ? extends U> function) {
            super(conditionalSubscriber);
            this.f = function;
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (this.d) {
                return;
            }
            if (this.e != 0) {
                this.a.onNext(null);
                return;
            }
            try {
                this.a.onNext(ObjectHelper.requireNonNull(this.f.apply(t), "The mapper function returned a null value."));
            } catch (Throwable th) {
                a(th);
            }
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        @Nullable
        public U poll() {
            T poll = this.c.poll();
            if (poll != null) {
                return (U) ObjectHelper.requireNonNull(this.f.apply(poll), "The mapper function returned a null value.");
            }
            return null;
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int requestFusion(int i) {
            return a(i);
        }

        @Override // io.reactivex.internal.fuseable.ConditionalSubscriber
        public boolean tryOnNext(T t) {
            if (this.d) {
                return false;
            }
            try {
                return this.a.tryOnNext(ObjectHelper.requireNonNull(this.f.apply(t), "The mapper function returned a null value."));
            } catch (Throwable th) {
                a(th);
                return true;
            }
        }
    }

    /* loaded from: classes2.dex */
    static final class MapSubscriber<T, U> extends BasicFuseableSubscriber<T, U> {
        final Function<? super T, ? extends U> f;

        /* JADX INFO: Access modifiers changed from: package-private */
        public MapSubscriber(Subscriber<? super U> subscriber, Function<? super T, ? extends U> function) {
            super(subscriber);
            this.f = function;
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (this.d) {
                return;
            }
            if (this.e != 0) {
                this.a.onNext(null);
                return;
            }
            try {
                this.a.onNext(ObjectHelper.requireNonNull(this.f.apply(t), "The mapper function returned a null value."));
            } catch (Throwable th) {
                a(th);
            }
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        @Nullable
        public U poll() {
            T poll = this.c.poll();
            if (poll != null) {
                return (U) ObjectHelper.requireNonNull(this.f.apply(poll), "The mapper function returned a null value.");
            }
            return null;
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int requestFusion(int i) {
            return a(i);
        }
    }

    public FlowableMap(Flowable<T> flowable, Function<? super T, ? extends U> function) {
        super(flowable);
        this.c = function;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super U> subscriber) {
        Flowable<T> flowable;
        FlowableSubscriber<? super T> mapSubscriber;
        if (subscriber instanceof ConditionalSubscriber) {
            flowable = this.b;
            mapSubscriber = new MapConditionalSubscriber<>((ConditionalSubscriber) subscriber, this.c);
        } else {
            flowable = this.b;
            mapSubscriber = new MapSubscriber<>(subscriber, this.c);
        }
        flowable.subscribe((FlowableSubscriber) mapSubscriber);
    }
}
