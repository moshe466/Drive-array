package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.annotations.Nullable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.subscribers.BasicFuseableConditionalSubscriber;
import io.reactivex.internal.subscribers.BasicFuseableSubscriber;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;

/* loaded from: classes2.dex */
public final class FlowableDoOnEach<T> extends AbstractFlowableWithUpstream<T, T> {
    final Consumer<? super T> c;
    final Consumer<? super Throwable> d;
    final Action e;
    final Action f;

    /* loaded from: classes2.dex */
    static final class DoOnEachConditionalSubscriber<T> extends BasicFuseableConditionalSubscriber<T, T> {
        final Consumer<? super T> f;
        final Consumer<? super Throwable> g;
        final Action h;
        final Action i;

        DoOnEachConditionalSubscriber(ConditionalSubscriber<? super T> conditionalSubscriber, Consumer<? super T> consumer, Consumer<? super Throwable> consumer2, Action action, Action action2) {
            super(conditionalSubscriber);
            this.f = consumer;
            this.g = consumer2;
            this.h = action;
            this.i = action2;
        }

        @Override // io.reactivex.internal.subscribers.BasicFuseableConditionalSubscriber, org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.d) {
                return;
            }
            try {
                this.h.run();
                this.d = true;
                this.a.onComplete();
                try {
                    this.i.run();
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    RxJavaPlugins.onError(th);
                }
            } catch (Throwable th2) {
                a(th2);
            }
        }

        @Override // io.reactivex.internal.subscribers.BasicFuseableConditionalSubscriber, org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.d) {
                RxJavaPlugins.onError(th);
                return;
            }
            boolean z = true;
            this.d = true;
            try {
                this.g.accept(th);
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                this.a.onError(new CompositeException(th, th2));
                z = false;
            }
            if (z) {
                this.a.onError(th);
            }
            try {
                this.i.run();
            } catch (Throwable th3) {
                Exceptions.throwIfFatal(th3);
                RxJavaPlugins.onError(th3);
            }
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
                this.f.accept(t);
                this.a.onNext(t);
            } catch (Throwable th) {
                a(th);
            }
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        @Nullable
        public T poll() {
            try {
                T poll = this.c.poll();
                if (poll == null) {
                    if (this.e == 1) {
                        this.h.run();
                    }
                    return poll;
                }
                try {
                    this.f.accept(poll);
                } catch (Throwable th) {
                    try {
                        Exceptions.throwIfFatal(th);
                        try {
                            this.g.accept(th);
                            throw ExceptionHelper.throwIfThrowable(th);
                        } catch (Throwable th2) {
                            throw new CompositeException(th, th2);
                        }
                    } finally {
                        this.i.run();
                    }
                }
                return poll;
            } catch (Throwable th3) {
                Exceptions.throwIfFatal(th3);
                try {
                    this.g.accept(th3);
                    throw ExceptionHelper.throwIfThrowable(th3);
                } catch (Throwable th4) {
                    throw new CompositeException(th3, th4);
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
            try {
                this.f.accept(t);
                return this.a.tryOnNext(t);
            } catch (Throwable th) {
                a(th);
                return false;
            }
        }
    }

    /* loaded from: classes2.dex */
    static final class DoOnEachSubscriber<T> extends BasicFuseableSubscriber<T, T> {
        final Consumer<? super T> f;
        final Consumer<? super Throwable> g;
        final Action h;
        final Action i;

        DoOnEachSubscriber(Subscriber<? super T> subscriber, Consumer<? super T> consumer, Consumer<? super Throwable> consumer2, Action action, Action action2) {
            super(subscriber);
            this.f = consumer;
            this.g = consumer2;
            this.h = action;
            this.i = action2;
        }

        @Override // io.reactivex.internal.subscribers.BasicFuseableSubscriber, org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.d) {
                return;
            }
            try {
                this.h.run();
                this.d = true;
                this.a.onComplete();
                try {
                    this.i.run();
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    RxJavaPlugins.onError(th);
                }
            } catch (Throwable th2) {
                a(th2);
            }
        }

        @Override // io.reactivex.internal.subscribers.BasicFuseableSubscriber, org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.d) {
                RxJavaPlugins.onError(th);
                return;
            }
            boolean z = true;
            this.d = true;
            try {
                this.g.accept(th);
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                this.a.onError(new CompositeException(th, th2));
                z = false;
            }
            if (z) {
                this.a.onError(th);
            }
            try {
                this.i.run();
            } catch (Throwable th3) {
                Exceptions.throwIfFatal(th3);
                RxJavaPlugins.onError(th3);
            }
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
                this.f.accept(t);
                this.a.onNext(t);
            } catch (Throwable th) {
                a(th);
            }
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        @Nullable
        public T poll() {
            try {
                T poll = this.c.poll();
                if (poll == null) {
                    if (this.e == 1) {
                        this.h.run();
                    }
                    return poll;
                }
                try {
                    this.f.accept(poll);
                } catch (Throwable th) {
                    try {
                        Exceptions.throwIfFatal(th);
                        try {
                            this.g.accept(th);
                            throw ExceptionHelper.throwIfThrowable(th);
                        } catch (Throwable th2) {
                            throw new CompositeException(th, th2);
                        }
                    } finally {
                        this.i.run();
                    }
                }
                return poll;
            } catch (Throwable th3) {
                Exceptions.throwIfFatal(th3);
                try {
                    this.g.accept(th3);
                    throw ExceptionHelper.throwIfThrowable(th3);
                } catch (Throwable th4) {
                    throw new CompositeException(th3, th4);
                }
            }
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int requestFusion(int i) {
            return a(i);
        }
    }

    public FlowableDoOnEach(Flowable<T> flowable, Consumer<? super T> consumer, Consumer<? super Throwable> consumer2, Action action, Action action2) {
        super(flowable);
        this.c = consumer;
        this.d = consumer2;
        this.e = action;
        this.f = action2;
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super T> subscriber) {
        Flowable<T> flowable;
        FlowableSubscriber<? super T> doOnEachSubscriber;
        if (subscriber instanceof ConditionalSubscriber) {
            flowable = this.b;
            doOnEachSubscriber = new DoOnEachConditionalSubscriber<>((ConditionalSubscriber) subscriber, this.c, this.d, this.e, this.f);
        } else {
            flowable = this.b;
            doOnEachSubscriber = new DoOnEachSubscriber<>(subscriber, this.c, this.d, this.e, this.f);
        }
        flowable.subscribe((FlowableSubscriber) doOnEachSubscriber);
    }
}
