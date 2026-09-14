package io.reactivex.internal.operators.observable;

import io.reactivex.Notification;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.internal.util.BlockingHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public final class BlockingObservableLatest<T> implements Iterable<T> {
    final ObservableSource<T> a;

    /* loaded from: classes3.dex */
    static final class BlockingObservableLatestIterator<T> extends DisposableObserver<Notification<T>> implements Iterator<T> {
        Notification<T> b;
        final Semaphore c = new Semaphore(0);
        final AtomicReference<Notification<T>> d = new AtomicReference<>();

        BlockingObservableLatestIterator() {
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            Notification<T> notification = this.b;
            if (notification != null && notification.isOnError()) {
                throw ExceptionHelper.wrapOrThrow(this.b.getError());
            }
            if (this.b == null) {
                try {
                    BlockingHelper.verifyNonBlocking();
                    this.c.acquire();
                    Notification<T> andSet = this.d.getAndSet(null);
                    this.b = andSet;
                    if (andSet.isOnError()) {
                        throw ExceptionHelper.wrapOrThrow(andSet.getError());
                    }
                } catch (InterruptedException e) {
                    dispose();
                    this.b = Notification.createOnError(e);
                    throw ExceptionHelper.wrapOrThrow(e);
                }
            }
            return this.b.isOnNext();
        }

        @Override // java.util.Iterator
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T value = this.b.getValue();
            this.b = null;
            return value;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            RxJavaPlugins.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(Notification<T> notification) {
            if (this.d.getAndSet(notification) == null) {
                this.c.release();
            }
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Read-only iterator.");
        }
    }

    public BlockingObservableLatest(ObservableSource<T> observableSource) {
        this.a = observableSource;
    }

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        BlockingObservableLatestIterator blockingObservableLatestIterator = new BlockingObservableLatestIterator();
        Observable.wrap(this.a).materialize().subscribe(blockingObservableLatestIterator);
        return blockingObservableLatestIterator;
    }
}
