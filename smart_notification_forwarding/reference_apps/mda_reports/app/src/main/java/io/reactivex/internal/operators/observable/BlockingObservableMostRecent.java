package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.observers.DefaultObserver;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes3.dex */
public final class BlockingObservableMostRecent<T> implements Iterable<T> {
    final ObservableSource<T> a;
    final T b;

    /* loaded from: classes3.dex */
    static final class MostRecentObserver<T> extends DefaultObserver<T> {
        volatile Object a;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes3.dex */
        public final class Iterator implements java.util.Iterator<T> {
            private Object buf;

            Iterator() {
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                this.buf = MostRecentObserver.this.a;
                return !NotificationLite.isComplete(this.buf);
            }

            @Override // java.util.Iterator
            public T next() {
                try {
                    if (this.buf == null) {
                        this.buf = MostRecentObserver.this.a;
                    }
                    if (NotificationLite.isComplete(this.buf)) {
                        throw new NoSuchElementException();
                    }
                    if (NotificationLite.isError(this.buf)) {
                        throw ExceptionHelper.wrapOrThrow(NotificationLite.getError(this.buf));
                    }
                    return (T) NotificationLite.getValue(this.buf);
                } finally {
                    this.buf = null;
                }
            }

            @Override // java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException("Read only iterator");
            }
        }

        MostRecentObserver(T t) {
            this.a = NotificationLite.next(t);
        }

        public MostRecentObserver<T>.Iterator getIterable() {
            return new Iterator();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.a = NotificationLite.complete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.a = NotificationLite.error(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            this.a = NotificationLite.next(t);
        }
    }

    public BlockingObservableMostRecent(ObservableSource<T> observableSource, T t) {
        this.a = observableSource;
        this.b = t;
    }

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        MostRecentObserver mostRecentObserver = new MostRecentObserver(this.b);
        this.a.subscribe(mostRecentObserver);
        return mostRecentObserver.getIterable();
    }
}
