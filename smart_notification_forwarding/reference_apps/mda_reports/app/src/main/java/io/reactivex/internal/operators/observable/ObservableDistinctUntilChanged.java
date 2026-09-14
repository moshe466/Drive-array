package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.annotations.Nullable;
import io.reactivex.functions.BiPredicate;
import io.reactivex.functions.Function;
import io.reactivex.internal.observers.BasicFuseableObserver;

/* loaded from: classes3.dex */
public final class ObservableDistinctUntilChanged<T, K> extends AbstractObservableWithUpstream<T, T> {
    final Function<? super T, K> b;
    final BiPredicate<? super K, ? super K> c;

    /* loaded from: classes3.dex */
    static final class DistinctUntilChangedObserver<T, K> extends BasicFuseableObserver<T, T> {
        final Function<? super T, K> f;
        final BiPredicate<? super K, ? super K> g;
        K h;
        boolean i;

        DistinctUntilChangedObserver(Observer<? super T> observer, Function<? super T, K> function, BiPredicate<? super K, ? super K> biPredicate) {
            super(observer);
            this.f = function;
            this.g = biPredicate;
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            if (this.d) {
                return;
            }
            if (this.e == 0) {
                try {
                    K apply = this.f.apply(t);
                    if (this.i) {
                        boolean test = this.g.test(this.h, apply);
                        this.h = apply;
                        if (test) {
                            return;
                        }
                    } else {
                        this.i = true;
                        this.h = apply;
                    }
                } catch (Throwable th) {
                    a(th);
                    return;
                }
            }
            this.a.onNext(t);
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        @Nullable
        public T poll() {
            T poll;
            boolean test;
            do {
                poll = this.c.poll();
                if (poll == null) {
                    return null;
                }
                K apply = this.f.apply(poll);
                if (!this.i) {
                    this.i = true;
                    this.h = apply;
                    return poll;
                }
                test = this.g.test(this.h, apply);
                this.h = apply;
            } while (test);
            return poll;
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int requestFusion(int i) {
            return a(i);
        }
    }

    public ObservableDistinctUntilChanged(ObservableSource<T> observableSource, Function<? super T, K> function, BiPredicate<? super K, ? super K> biPredicate) {
        super(observableSource);
        this.b = function;
        this.c = biPredicate;
    }

    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super T> observer) {
        this.a.subscribe(new DistinctUntilChangedObserver(observer, this.b, this.c));
    }
}
