package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.util.BlockingHelper;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes3.dex */
public final class BlockingObservableIterable<T> implements Iterable<T> {
    final ObservableSource<? extends T> a;
    final int b;

    /* loaded from: classes3.dex */
    static final class BlockingObservableIterator<T> extends AtomicReference<Disposable> implements Observer<T>, Iterator<T>, Disposable {
        private static final long serialVersionUID = 6695226475494099826L;
        final SpscLinkedArrayQueue<T> a;
        final Lock b = new ReentrantLock();
        final Condition c = this.b.newCondition();
        volatile boolean d;
        Throwable e;

        BlockingObservableIterator(int i) {
            this.a = new SpscLinkedArrayQueue<>(i);
        }

        void a() {
            this.b.lock();
            try {
                this.c.signalAll();
            } finally {
                this.b.unlock();
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            while (true) {
                boolean z = this.d;
                boolean isEmpty = this.a.isEmpty();
                if (z) {
                    Throwable th = this.e;
                    if (th != null) {
                        throw ExceptionHelper.wrapOrThrow(th);
                    }
                    if (isEmpty) {
                        return false;
                    }
                }
                if (!isEmpty) {
                    return true;
                }
                try {
                    BlockingHelper.verifyNonBlocking();
                    this.b.lock();
                    while (!this.d && this.a.isEmpty()) {
                        try {
                            this.c.await();
                        } finally {
                        }
                    }
                    this.b.unlock();
                } catch (InterruptedException e) {
                    DisposableHelper.dispose(this);
                    a();
                    throw ExceptionHelper.wrapOrThrow(e);
                }
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // java.util.Iterator
        public T next() {
            if (hasNext()) {
                return this.a.poll();
            }
            throw new NoSuchElementException();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.d = true;
            a();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.e = th;
            this.d = true;
            a();
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            this.a.offer(t);
            a();
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this, disposable);
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("remove");
        }
    }

    public BlockingObservableIterable(ObservableSource<? extends T> observableSource, int i) {
        this.a = observableSource;
        this.b = i;
    }

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        BlockingObservableIterator blockingObservableIterator = new BlockingObservableIterator(this.b);
        this.a.subscribe(blockingObservableIterator);
        return blockingObservableIterator;
    }
}
