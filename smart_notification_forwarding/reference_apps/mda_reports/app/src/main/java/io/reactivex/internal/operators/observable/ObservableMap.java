package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.annotations.Nullable;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.observers.BasicFuseableObserver;

/* loaded from: classes3.dex */
public final class ObservableMap<T, U> extends AbstractObservableWithUpstream<T, U> {
    final Function<? super T, ? extends U> b;

    /* loaded from: classes3.dex */
    static final class MapObserver<T, U> extends BasicFuseableObserver<T, U> {
        final Function<? super T, ? extends U> f;

        MapObserver(Observer<? super U> observer, Function<? super T, ? extends U> function) {
            super(observer);
            this.f = function;
        }

        @Override // io.reactivex.Observer
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

    public ObservableMap(ObservableSource<T> observableSource, Function<? super T, ? extends U> function) {
        super(observableSource);
        this.b = function;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super U> observer) {
        this.a.subscribe(new MapObserver(observer, this.b));
    }
}
