package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Scheduler;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public final class CompletableTimeout extends Completable {
    final CompletableSource a;
    final long b;
    final TimeUnit c;
    final Scheduler d;
    final CompletableSource e;

    /* loaded from: classes.dex */
    final class DisposeTask implements Runnable {
        final CompositeDisposable a;
        final CompletableObserver b;
        private final AtomicBoolean once;

        /* loaded from: classes.dex */
        final class DisposeObserver implements CompletableObserver {
            DisposeObserver() {
            }

            @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
            public void onComplete() {
                DisposeTask.this.a.dispose();
                DisposeTask.this.b.onComplete();
            }

            @Override // io.reactivex.CompletableObserver
            public void onError(Throwable th) {
                DisposeTask.this.a.dispose();
                DisposeTask.this.b.onError(th);
            }

            @Override // io.reactivex.CompletableObserver
            public void onSubscribe(Disposable disposable) {
                DisposeTask.this.a.add(disposable);
            }
        }

        DisposeTask(AtomicBoolean atomicBoolean, CompositeDisposable compositeDisposable, CompletableObserver completableObserver) {
            this.once = atomicBoolean;
            this.a = compositeDisposable;
            this.b = completableObserver;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.once.compareAndSet(false, true)) {
                this.a.clear();
                CompletableSource completableSource = CompletableTimeout.this.e;
                if (completableSource == null) {
                    this.b.onError(new TimeoutException());
                } else {
                    completableSource.subscribe(new DisposeObserver());
                }
            }
        }
    }

    /* loaded from: classes.dex */
    static final class TimeOutObserver implements CompletableObserver {
        private final AtomicBoolean once;
        private final CompletableObserver s;
        private final CompositeDisposable set;

        TimeOutObserver(CompositeDisposable compositeDisposable, AtomicBoolean atomicBoolean, CompletableObserver completableObserver) {
            this.set = compositeDisposable;
            this.once = atomicBoolean;
            this.s = completableObserver;
        }

        @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
        public void onComplete() {
            if (this.once.compareAndSet(false, true)) {
                this.set.dispose();
                this.s.onComplete();
            }
        }

        @Override // io.reactivex.CompletableObserver
        public void onError(Throwable th) {
            if (!this.once.compareAndSet(false, true)) {
                RxJavaPlugins.onError(th);
            } else {
                this.set.dispose();
                this.s.onError(th);
            }
        }

        @Override // io.reactivex.CompletableObserver
        public void onSubscribe(Disposable disposable) {
            this.set.add(disposable);
        }
    }

    public CompletableTimeout(CompletableSource completableSource, long j, TimeUnit timeUnit, Scheduler scheduler, CompletableSource completableSource2) {
        this.a = completableSource;
        this.b = j;
        this.c = timeUnit;
        this.d = scheduler;
        this.e = completableSource2;
    }

    @Override // io.reactivex.Completable
    public void subscribeActual(CompletableObserver completableObserver) {
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        completableObserver.onSubscribe(compositeDisposable);
        AtomicBoolean atomicBoolean = new AtomicBoolean();
        compositeDisposable.add(this.d.scheduleDirect(new DisposeTask(atomicBoolean, compositeDisposable, completableObserver), this.b, this.c));
        this.a.subscribe(new TimeOutObserver(compositeDisposable, atomicBoolean, completableObserver));
    }
}
