package io.reactivex.internal.operators.observable;

import io.reactivex.Emitter;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;

/* loaded from: classes3.dex */
public final class ObservableGenerate<T, S> extends Observable<T> {
    final Callable<S> a;
    final BiFunction<S, Emitter<T>, S> b;
    final Consumer<? super S> c;

    /* loaded from: classes3.dex */
    static final class GeneratorDisposable<T, S> implements Emitter<T>, Disposable {
        final Observer<? super T> a;
        final BiFunction<S, ? super Emitter<T>, S> b;
        final Consumer<? super S> c;
        S d;
        volatile boolean e;
        boolean f;
        boolean g;

        GeneratorDisposable(Observer<? super T> observer, BiFunction<S, ? super Emitter<T>, S> biFunction, Consumer<? super S> consumer, S s) {
            this.a = observer;
            this.b = biFunction;
            this.c = consumer;
            this.d = s;
        }

        private void dispose(S s) {
            try {
                this.c.accept(s);
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                RxJavaPlugins.onError(th);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.e = true;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.e;
        }

        @Override // io.reactivex.Emitter
        public void onComplete() {
            if (this.f) {
                return;
            }
            this.f = true;
            this.a.onComplete();
        }

        @Override // io.reactivex.Emitter
        public void onError(Throwable th) {
            if (this.f) {
                RxJavaPlugins.onError(th);
                return;
            }
            if (th == null) {
                th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            this.f = true;
            this.a.onError(th);
        }

        @Override // io.reactivex.Emitter
        public void onNext(T t) {
            Throwable nullPointerException;
            if (this.f) {
                return;
            }
            if (this.g) {
                nullPointerException = new IllegalStateException("onNext already called in this generate turn");
            } else {
                if (t != null) {
                    this.g = true;
                    this.a.onNext(t);
                    return;
                }
                nullPointerException = new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            onError(nullPointerException);
        }

        public void run() {
            S s = this.d;
            if (!this.e) {
                BiFunction<S, ? super Emitter<T>, S> biFunction = this.b;
                while (true) {
                    if (this.e) {
                        break;
                    }
                    this.g = false;
                    try {
                        s = biFunction.apply(s, this);
                        if (this.f) {
                            this.e = true;
                            break;
                        }
                    } catch (Throwable th) {
                        Exceptions.throwIfFatal(th);
                        this.d = null;
                        this.e = true;
                        onError(th);
                    }
                }
            }
            this.d = null;
            dispose(s);
        }
    }

    public ObservableGenerate(Callable<S> callable, BiFunction<S, Emitter<T>, S> biFunction, Consumer<? super S> consumer) {
        this.a = callable;
        this.b = biFunction;
        this.c = consumer;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> observer) {
        try {
            GeneratorDisposable generatorDisposable = new GeneratorDisposable(observer, this.b, this.c, this.a.call());
            observer.onSubscribe(generatorDisposable);
            generatorDisposable.run();
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            EmptyDisposable.error(th, observer);
        }
    }
}
