package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.plugins.RxJavaPlugins;

/* loaded from: classes2.dex */
public final class MaybePeek<T> extends AbstractMaybeWithUpstream<T, T> {
    final Consumer<? super Disposable> b;
    final Consumer<? super T> c;
    final Consumer<? super Throwable> d;
    final Action e;
    final Action f;
    final Action g;

    /* loaded from: classes2.dex */
    static final class MaybePeekObserver<T> implements MaybeObserver<T>, Disposable {
        final MaybeObserver<? super T> a;
        final MaybePeek<T> b;
        Disposable c;

        MaybePeekObserver(MaybeObserver<? super T> maybeObserver, MaybePeek<T> maybePeek) {
            this.a = maybeObserver;
            this.b = maybePeek;
        }

        void a() {
            try {
                this.b.f.run();
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                RxJavaPlugins.onError(th);
            }
        }

        void a(Throwable th) {
            try {
                this.b.d.accept(th);
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                th = new CompositeException(th, th2);
            }
            this.c = DisposableHelper.DISPOSED;
            this.a.onError(th);
            a();
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            try {
                this.b.g.run();
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                RxJavaPlugins.onError(th);
            }
            this.c.dispose();
            this.c = DisposableHelper.DISPOSED;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.c.isDisposed();
        }

        @Override // io.reactivex.MaybeObserver
        public void onComplete() {
            if (this.c == DisposableHelper.DISPOSED) {
                return;
            }
            try {
                this.b.e.run();
                this.c = DisposableHelper.DISPOSED;
                this.a.onComplete();
                a();
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                a(th);
            }
        }

        @Override // io.reactivex.MaybeObserver
        public void onError(Throwable th) {
            if (this.c == DisposableHelper.DISPOSED) {
                RxJavaPlugins.onError(th);
            } else {
                a(th);
            }
        }

        @Override // io.reactivex.MaybeObserver
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.c, disposable)) {
                try {
                    this.b.b.accept(disposable);
                    this.c = disposable;
                    this.a.onSubscribe(this);
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    disposable.dispose();
                    this.c = DisposableHelper.DISPOSED;
                    EmptyDisposable.error(th, this.a);
                }
            }
        }

        @Override // io.reactivex.MaybeObserver
        public void onSuccess(T t) {
            if (this.c == DisposableHelper.DISPOSED) {
                return;
            }
            try {
                this.b.c.accept(t);
                this.c = DisposableHelper.DISPOSED;
                this.a.onSuccess(t);
                a();
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                a(th);
            }
        }
    }

    public MaybePeek(MaybeSource<T> maybeSource, Consumer<? super Disposable> consumer, Consumer<? super T> consumer2, Consumer<? super Throwable> consumer3, Action action, Action action2, Action action3) {
        super(maybeSource);
        this.b = consumer;
        this.c = consumer2;
        this.d = consumer3;
        this.e = action;
        this.f = action2;
        this.g = action3;
    }

    @Override // io.reactivex.Maybe
    protected void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        this.a.subscribe(new MaybePeekObserver(maybeObserver, this));
    }
}
