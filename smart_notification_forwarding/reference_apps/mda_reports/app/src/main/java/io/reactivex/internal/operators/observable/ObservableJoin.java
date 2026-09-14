package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.observable.ObservableGroupJoin;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public final class ObservableJoin<TLeft, TRight, TLeftEnd, TRightEnd, R> extends AbstractObservableWithUpstream<TLeft, R> {
    final ObservableSource<? extends TRight> b;
    final Function<? super TLeft, ? extends ObservableSource<TLeftEnd>> c;
    final Function<? super TRight, ? extends ObservableSource<TRightEnd>> d;
    final BiFunction<? super TLeft, ? super TRight, ? extends R> e;

    /* loaded from: classes3.dex */
    static final class JoinDisposable<TLeft, TRight, TLeftEnd, TRightEnd, R> extends AtomicInteger implements Disposable, ObservableGroupJoin.JoinSupport {
        static final Integer n = 1;
        static final Integer o = 2;
        static final Integer p = 3;
        static final Integer q = 4;
        private static final long serialVersionUID = -6071216598687999801L;
        final Observer<? super R> a;
        final Function<? super TLeft, ? extends ObservableSource<TLeftEnd>> g;
        final Function<? super TRight, ? extends ObservableSource<TRightEnd>> h;
        final BiFunction<? super TLeft, ? super TRight, ? extends R> i;
        int k;
        int l;
        volatile boolean m;
        final CompositeDisposable c = new CompositeDisposable();
        final SpscLinkedArrayQueue<Object> b = new SpscLinkedArrayQueue<>(Observable.bufferSize());
        final Map<Integer, TLeft> d = new LinkedHashMap();
        final Map<Integer, TRight> e = new LinkedHashMap();
        final AtomicReference<Throwable> f = new AtomicReference<>();
        final AtomicInteger j = new AtomicInteger(2);

        JoinDisposable(Observer<? super R> observer, Function<? super TLeft, ? extends ObservableSource<TLeftEnd>> function, Function<? super TRight, ? extends ObservableSource<TRightEnd>> function2, BiFunction<? super TLeft, ? super TRight, ? extends R> biFunction) {
            this.a = observer;
            this.g = function;
            this.h = function2;
            this.i = biFunction;
        }

        void a() {
            this.c.dispose();
        }

        void a(Observer<?> observer) {
            Throwable terminate = ExceptionHelper.terminate(this.f);
            this.d.clear();
            this.e.clear();
            observer.onError(terminate);
        }

        void a(Throwable th, Observer<?> observer, SpscLinkedArrayQueue<?> spscLinkedArrayQueue) {
            Exceptions.throwIfFatal(th);
            ExceptionHelper.addThrowable(this.f, th);
            spscLinkedArrayQueue.clear();
            a();
            a(observer);
        }

        void b() {
            if (getAndIncrement() != 0) {
                return;
            }
            SpscLinkedArrayQueue<?> spscLinkedArrayQueue = this.b;
            Observer<? super R> observer = this.a;
            int i = 1;
            while (!this.m) {
                if (this.f.get() != null) {
                    spscLinkedArrayQueue.clear();
                    a();
                    a(observer);
                    return;
                }
                boolean z = this.j.get() == 0;
                Integer num = (Integer) spscLinkedArrayQueue.poll();
                boolean z2 = num == null;
                if (z && z2) {
                    this.d.clear();
                    this.e.clear();
                    this.c.dispose();
                    observer.onComplete();
                    return;
                }
                if (z2) {
                    i = addAndGet(-i);
                    if (i == 0) {
                        return;
                    }
                } else {
                    Object poll = spscLinkedArrayQueue.poll();
                    if (num == n) {
                        int i2 = this.k;
                        this.k = i2 + 1;
                        this.d.put(Integer.valueOf(i2), poll);
                        try {
                            ObservableSource observableSource = (ObservableSource) ObjectHelper.requireNonNull(this.g.apply(poll), "The leftEnd returned a null ObservableSource");
                            ObservableGroupJoin.LeftRightEndObserver leftRightEndObserver = new ObservableGroupJoin.LeftRightEndObserver(this, true, i2);
                            this.c.add(leftRightEndObserver);
                            observableSource.subscribe(leftRightEndObserver);
                            if (this.f.get() != null) {
                                spscLinkedArrayQueue.clear();
                                a();
                                a(observer);
                                return;
                            } else {
                                Iterator<TRight> it = this.e.values().iterator();
                                while (it.hasNext()) {
                                    try {
                                        observer.onNext((Object) ObjectHelper.requireNonNull(this.i.apply(poll, it.next()), "The resultSelector returned a null value"));
                                    } catch (Throwable th) {
                                        a(th, observer, spscLinkedArrayQueue);
                                        return;
                                    }
                                }
                            }
                        } catch (Throwable th2) {
                            a(th2, observer, spscLinkedArrayQueue);
                            return;
                        }
                    } else if (num == o) {
                        int i3 = this.l;
                        this.l = i3 + 1;
                        this.e.put(Integer.valueOf(i3), poll);
                        try {
                            ObservableSource observableSource2 = (ObservableSource) ObjectHelper.requireNonNull(this.h.apply(poll), "The rightEnd returned a null ObservableSource");
                            ObservableGroupJoin.LeftRightEndObserver leftRightEndObserver2 = new ObservableGroupJoin.LeftRightEndObserver(this, false, i3);
                            this.c.add(leftRightEndObserver2);
                            observableSource2.subscribe(leftRightEndObserver2);
                            if (this.f.get() != null) {
                                spscLinkedArrayQueue.clear();
                                a();
                                a(observer);
                                return;
                            } else {
                                Iterator<TLeft> it2 = this.d.values().iterator();
                                while (it2.hasNext()) {
                                    try {
                                        observer.onNext((Object) ObjectHelper.requireNonNull(this.i.apply(it2.next(), poll), "The resultSelector returned a null value"));
                                    } catch (Throwable th3) {
                                        a(th3, observer, spscLinkedArrayQueue);
                                        return;
                                    }
                                }
                            }
                        } catch (Throwable th4) {
                            a(th4, observer, spscLinkedArrayQueue);
                            return;
                        }
                    } else {
                        ObservableGroupJoin.LeftRightEndObserver leftRightEndObserver3 = (ObservableGroupJoin.LeftRightEndObserver) poll;
                        (num == p ? this.d : this.e).remove(Integer.valueOf(leftRightEndObserver3.c));
                        this.c.remove(leftRightEndObserver3);
                    }
                }
            }
            spscLinkedArrayQueue.clear();
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (this.m) {
                return;
            }
            this.m = true;
            a();
            if (getAndIncrement() == 0) {
                this.b.clear();
            }
        }

        @Override // io.reactivex.internal.operators.observable.ObservableGroupJoin.JoinSupport
        public void innerClose(boolean z, ObservableGroupJoin.LeftRightEndObserver leftRightEndObserver) {
            synchronized (this) {
                this.b.offer(z ? p : q, leftRightEndObserver);
            }
            b();
        }

        @Override // io.reactivex.internal.operators.observable.ObservableGroupJoin.JoinSupport
        public void innerCloseError(Throwable th) {
            if (ExceptionHelper.addThrowable(this.f, th)) {
                b();
            } else {
                RxJavaPlugins.onError(th);
            }
        }

        @Override // io.reactivex.internal.operators.observable.ObservableGroupJoin.JoinSupport
        public void innerComplete(ObservableGroupJoin.LeftRightObserver leftRightObserver) {
            this.c.delete(leftRightObserver);
            this.j.decrementAndGet();
            b();
        }

        @Override // io.reactivex.internal.operators.observable.ObservableGroupJoin.JoinSupport
        public void innerError(Throwable th) {
            if (!ExceptionHelper.addThrowable(this.f, th)) {
                RxJavaPlugins.onError(th);
            } else {
                this.j.decrementAndGet();
                b();
            }
        }

        @Override // io.reactivex.internal.operators.observable.ObservableGroupJoin.JoinSupport
        public void innerValue(boolean z, Object obj) {
            synchronized (this) {
                this.b.offer(z ? n : o, obj);
            }
            b();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.m;
        }
    }

    public ObservableJoin(ObservableSource<TLeft> observableSource, ObservableSource<? extends TRight> observableSource2, Function<? super TLeft, ? extends ObservableSource<TLeftEnd>> function, Function<? super TRight, ? extends ObservableSource<TRightEnd>> function2, BiFunction<? super TLeft, ? super TRight, ? extends R> biFunction) {
        super(observableSource);
        this.b = observableSource2;
        this.c = function;
        this.d = function2;
        this.e = biFunction;
    }

    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super R> observer) {
        JoinDisposable joinDisposable = new JoinDisposable(observer, this.c, this.d, this.e);
        observer.onSubscribe(joinDisposable);
        ObservableGroupJoin.LeftRightObserver leftRightObserver = new ObservableGroupJoin.LeftRightObserver(joinDisposable, true);
        joinDisposable.c.add(leftRightObserver);
        ObservableGroupJoin.LeftRightObserver leftRightObserver2 = new ObservableGroupJoin.LeftRightObserver(joinDisposable, false);
        joinDisposable.c.add(leftRightObserver2);
        this.a.subscribe(leftRightObserver);
        this.b.subscribe(leftRightObserver2);
    }
}
