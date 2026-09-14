package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Scheduler;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final class CompletableDelay extends Completable {
    final CompletableSource a;
    final long b;
    final TimeUnit c;
    final Scheduler d;
    final boolean e;

    /* loaded from: classes.dex */
    final class Delay implements CompletableObserver {
        final CompletableObserver a;
        private final CompositeDisposable set;

        /* loaded from: classes.dex */
        final class OnComplete implements Runnable {
            OnComplete() {
            }

            @Override // java.lang.Runnable
            public void run() {
                Delay.this.a.onComplete();
            }
        }

        /* loaded from: classes.dex */
        final class OnError implements Runnable {
            private final Throwable e;

            OnError(Throwable th) {
                this.e = th;
            }

            @Override // java.lang.Runnable
            public void run() {
                Delay.this.a.onError(this.e);
            }
        }

        Delay(CompositeDisposable compositeDisposable, CompletableObserver completableObserver) {
            this.set = compositeDisposable;
            this.a = completableObserver;
        }

        @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
        public void onComplete() {
            CompositeDisposable compositeDisposable = this.set;
            Scheduler scheduler = CompletableDelay.this.d;
            OnComplete onComplete = new OnComplete();
            CompletableDelay completableDelay = CompletableDelay.this;
            compositeDisposable.add(scheduler.scheduleDirect(onComplete, completableDelay.b, completableDelay.c));
        }

        @Override // io.reactivex.CompletableObserver
        public void onError(Throwable th) {
            CompositeDisposable compositeDisposable = this.set;
            Scheduler scheduler = CompletableDelay.this.d;
            OnError onError = new OnError(th);
            CompletableDelay completableDelay = CompletableDelay.this;
            compositeDisposable.add(scheduler.scheduleDirect(onError, completableDelay.e ? completableDelay.b : 0L, CompletableDelay.this.c));
        }

        @Override // io.reactivex.CompletableObserver
        public void onSubscribe(Disposable disposable) {
            this.set.add(disposable);
            this.a.onSubscribe(this.set);
        }
    }

    public CompletableDelay(CompletableSource completableSource, long j, TimeUnit timeUnit, Scheduler scheduler, boolean z) {
        this.a = completableSource;
        this.b = j;
        this.c = timeUnit;
        this.d = scheduler;
        this.e = z;
    }

    @Override // io.reactivex.Completable
    protected void subscribeActual(CompletableObserver completableObserver) {
        this.a.subscribe(new Delay(new CompositeDisposable(), completableObserver));
    }
}
