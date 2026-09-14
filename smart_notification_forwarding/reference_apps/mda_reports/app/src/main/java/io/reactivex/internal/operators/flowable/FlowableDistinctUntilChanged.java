package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.annotations.Nullable;
import io.reactivex.functions.BiPredicate;
import io.reactivex.functions.Function;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.subscribers.BasicFuseableConditionalSubscriber;
import io.reactivex.internal.subscribers.BasicFuseableSubscriber;
import org.reactivestreams.Subscriber;

/* loaded from: classes2.dex */
public final class FlowableDistinctUntilChanged<T, K> extends AbstractFlowableWithUpstream<T, T> {
    final Function<? super T, K> c;
    final BiPredicate<? super K, ? super K> d;

    /* loaded from: classes2.dex */
    static final class DistinctUntilChangedConditionalSubscriber<T, K> extends BasicFuseableConditionalSubscriber<T, T> {
        final Function<? super T, K> f;
        final BiPredicate<? super K, ? super K> g;
        K h;
        boolean i;

        DistinctUntilChangedConditionalSubscriber(ConditionalSubscriber<? super T> conditionalSubscriber, Function<? super T, K> function, BiPredicate<? super K, ? super K> biPredicate) {
            super(conditionalSubscriber);
            this.f = function;
            this.g = biPredicate;
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (tryOnNext(t)) {
                return;
            }
            this.b.request(1L);
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        @Nullable
        public T poll() {
            while (true) {
                T poll = this.c.poll();
                if (poll == null) {
                    return null;
                }
                K apply = this.f.apply(poll);
                if (!this.i) {
                    this.i = true;
                    this.h = apply;
                    return poll;
                }
                boolean test = this.g.test(this.h, apply);
                this.h = apply;
                if (!test) {
                    return poll;
                }
                if (this.e != 1) {
                    this.b.request(1L);
                }
            }
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
            if (this.e != 0) {
                return this.a.tryOnNext(t);
            }
            try {
                K apply = this.f.apply(t);
                if (this.i) {
                    boolean test = this.g.test(this.h, apply);
                    this.h = apply;
                    if (test) {
                        return false;
                    }
                } else {
                    this.i = true;
                    this.h = apply;
                }
                this.a.onNext(t);
                return true;
            } catch (Throwable th) {
                a(th);
                return true;
            }
        }
    }

    /* loaded from: classes2.dex */
    static final class DistinctUntilChangedSubscriber<T, K> extends BasicFuseableSubscriber<T, T> implements ConditionalSubscriber<T> {
        final Function<? super T, K> f;
        final BiPredicate<? super K, ? super K> g;
        K h;
        boolean i;

        DistinctUntilChangedSubscriber(Subscriber<? super T> subscriber, Function<? super T, K> function, BiPredicate<? super K, ? super K> biPredicate) {
            super(subscriber);
            this.f = function;
            this.g = biPredicate;
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (tryOnNext(t)) {
                return;
            }
            this.b.request(1L);
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        @Nullable
        public T poll() {
            while (true) {
                T poll = this.c.poll();
                if (poll == null) {
                    return null;
                }
                K apply = this.f.apply(poll);
                if (!this.i) {
                    this.i = true;
                    this.h = apply;
                    return poll;
                }
                boolean test = this.g.test(this.h, apply);
                this.h = apply;
                if (!test) {
                    return poll;
                }
                if (this.e != 1) {
                    this.b.request(1L);
                }
            }
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
            if (this.e == 0) {
                try {
                    K apply = this.f.apply(t);
                    if (this.i) {
                        boolean test = this.g.test(this.h, apply);
                        this.h = apply;
                        if (test) {
                            return false;
                        }
                    } else {
                        this.i = true;
                        this.h = apply;
                    }
                } catch (Throwable th) {
                    a(th);
                    return true;
                }
            }
            this.a.onNext(t);
            return true;
        }
    }

    public FlowableDistinctUntilChanged(Flowable<T> flowable, Function<? super T, K> function, BiPredicate<? super K, ? super K> biPredicate) {
        super(flowable);
        this.c = function;
        this.d = biPredicate;
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super T> subscriber) {
        Flowable<T> flowable;
        FlowableSubscriber<? super T> distinctUntilChangedSubscriber;
        if (subscriber instanceof ConditionalSubscriber) {
            flowable = this.b;
            distinctUntilChangedSubscriber = new DistinctUntilChangedConditionalSubscriber<>((ConditionalSubscriber) subscriber, this.c, this.d);
        } else {
            flowable = this.b;
            distinctUntilChangedSubscriber = new DistinctUntilChangedSubscriber<>(subscriber, this.c, this.d);
        }
        flowable.subscribe((FlowableSubscriber) distinctUntilChangedSubscriber);
    }
}
