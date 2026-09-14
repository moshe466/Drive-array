package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.annotations.Experimental;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;

@Experimental
/* loaded from: classes3.dex */
public final class SingleDetach<T> extends Single<T> {
    final SingleSource<T> a;

    /* loaded from: classes3.dex */
    static final class DetachSingleObserver<T> implements SingleObserver<T>, Disposable {
        SingleObserver<? super T> a;
        Disposable b;

        DetachSingleObserver(SingleObserver<? super T> singleObserver) {
            this.a = singleObserver;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.a = null;
            this.b.dispose();
            this.b = DisposableHelper.DISPOSED;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.b.isDisposed();
        }

        @Override // io.reactivex.SingleObserver
        public void onError(Throwable th) {
            this.b = DisposableHelper.DISPOSED;
            SingleObserver<? super T> singleObserver = this.a;
            if (singleObserver != null) {
                this.a = null;
                singleObserver.onError(th);
            }
        }

        @Override // io.reactivex.SingleObserver
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.b, disposable)) {
                this.b = disposable;
                this.a.onSubscribe(this);
            }
        }

        @Override // io.reactivex.SingleObserver
        public void onSuccess(T t) {
            this.b = DisposableHelper.DISPOSED;
            SingleObserver<? super T> singleObserver = this.a;
            if (singleObserver != null) {
                this.a = null;
                singleObserver.onSuccess(t);
            }
        }
    }

    public SingleDetach(SingleSource<T> singleSource) {
        this.a = singleSource;
    }

    @Override // io.reactivex.Single
    protected void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.a.subscribe(new DetachSingleObserver(singleObserver));
    }
}
