package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class MaybeDelay<T> extends AbstractMaybeWithUpstream<T, T> {
    final long b;
    final TimeUnit c;
    final Scheduler d;

    /* loaded from: classes2.dex */
    static final class DelayMaybeObserver<T> extends AtomicReference<Disposable> implements MaybeObserver<T>, Disposable, Runnable {
        private static final long serialVersionUID = 5566860102500855068L;
        final MaybeObserver<? super T> a;
        final long b;
        final TimeUnit c;
        final Scheduler d;
        T e;
        Throwable f;

        DelayMaybeObserver(MaybeObserver<? super T> maybeObserver, long j, TimeUnit timeUnit, Scheduler scheduler) {
            this.a = maybeObserver;
            this.b = j;
            this.c = timeUnit;
            this.d = scheduler;
        }

        void a() {
            DisposableHelper.replace(this, this.d.scheduleDirect(this, this.b, this.c));
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // io.reactivex.MaybeObserver
        public void onComplete() {
            a();
        }

        @Override // io.reactivex.MaybeObserver
        public void onError(Throwable th) {
            this.f = th;
            a();
        }

        @Override // io.reactivex.MaybeObserver
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.setOnce(this, disposable)) {
                this.a.onSubscribe(this);
            }
        }

        @Override // io.reactivex.MaybeObserver
        public void onSuccess(T t) {
            this.e = t;
            a();
        }

        @Override // java.lang.Runnable
        public void run() {
            Throwable th = this.f;
            if (th != null) {
                this.a.onError(th);
                return;
            }
            T t = this.e;
            if (t != null) {
                this.a.onSuccess(t);
            } else {
                this.a.onComplete();
            }
        }
    }

    public MaybeDelay(MaybeSource<T> maybeSource, long j, TimeUnit timeUnit, Scheduler scheduler) {
        super(maybeSource);
        this.b = j;
        this.c = timeUnit;
        this.d = scheduler;
    }

    @Override // io.reactivex.Maybe
    protected void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        this.a.subscribe(new DelayMaybeObserver(maybeObserver, this.b, this.c, this.d));
    }
}
