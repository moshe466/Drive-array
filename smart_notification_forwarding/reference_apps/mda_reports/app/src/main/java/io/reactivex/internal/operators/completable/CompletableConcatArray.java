package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public final class CompletableConcatArray extends Completable {
    final CompletableSource[] a;

    /* loaded from: classes.dex */
    static final class ConcatInnerObserver extends AtomicInteger implements CompletableObserver {
        private static final long serialVersionUID = -7965400327305809232L;
        final CompletableObserver a;
        final CompletableSource[] b;
        int c;
        final SequentialDisposable d = new SequentialDisposable();

        ConcatInnerObserver(CompletableObserver completableObserver, CompletableSource[] completableSourceArr) {
            this.a = completableObserver;
            this.b = completableSourceArr;
        }

        void a() {
            if (!this.d.isDisposed() && getAndIncrement() == 0) {
                CompletableSource[] completableSourceArr = this.b;
                while (!this.d.isDisposed()) {
                    int i = this.c;
                    this.c = i + 1;
                    if (i == completableSourceArr.length) {
                        this.a.onComplete();
                        return;
                    } else {
                        completableSourceArr[i].subscribe(this);
                        if (decrementAndGet() == 0) {
                            return;
                        }
                    }
                }
            }
        }

        @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
        public void onComplete() {
            a();
        }

        @Override // io.reactivex.CompletableObserver
        public void onError(Throwable th) {
            this.a.onError(th);
        }

        @Override // io.reactivex.CompletableObserver
        public void onSubscribe(Disposable disposable) {
            this.d.replace(disposable);
        }
    }

    public CompletableConcatArray(CompletableSource[] completableSourceArr) {
        this.a = completableSourceArr;
    }

    @Override // io.reactivex.Completable
    public void subscribeActual(CompletableObserver completableObserver) {
        ConcatInnerObserver concatInnerObserver = new ConcatInnerObserver(completableObserver, this.a);
        completableObserver.onSubscribe(concatInnerObserver.d);
        concatInnerObserver.a();
    }
}
