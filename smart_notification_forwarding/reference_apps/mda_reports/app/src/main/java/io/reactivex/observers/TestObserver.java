package io.reactivex.observers;

import io.reactivex.CompletableObserver;
import io.reactivex.MaybeObserver;
import io.reactivex.Observer;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.QueueDisposable;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public class TestObserver<T> extends BaseTestConsumer<T, TestObserver<T>> implements Observer<T>, Disposable, MaybeObserver<T>, SingleObserver<T>, CompletableObserver {
    private final Observer<? super T> actual;
    private QueueDisposable<T> qs;
    private final AtomicReference<Disposable> subscription;

    /* loaded from: classes3.dex */
    enum EmptyObserver implements Observer<Object> {
        INSTANCE;

        @Override // io.reactivex.Observer
        public void onComplete() {
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
        }

        @Override // io.reactivex.Observer
        public void onNext(Object obj) {
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
        }
    }

    public TestObserver() {
        this(EmptyObserver.INSTANCE);
    }

    public TestObserver(Observer<? super T> observer) {
        this.subscription = new AtomicReference<>();
        this.actual = observer;
    }

    public static <T> TestObserver<T> create() {
        return new TestObserver<>();
    }

    public static <T> TestObserver<T> create(Observer<? super T> observer) {
        return new TestObserver<>(observer);
    }

    @Override // io.reactivex.observers.BaseTestConsumer
    public final TestObserver<T> assertNotSubscribed() {
        if (this.subscription.get() != null) {
            throw a("Subscribed!");
        }
        if (this.c.isEmpty()) {
            return this;
        }
        throw a("Not subscribed but errors found");
    }

    public final TestObserver<T> assertOf(Consumer<? super TestObserver<T>> consumer) {
        try {
            consumer.accept(this);
            return this;
        } catch (Throwable th) {
            throw ExceptionHelper.wrapOrThrow(th);
        }
    }

    @Override // io.reactivex.observers.BaseTestConsumer
    public final TestObserver<T> assertSubscribed() {
        if (this.subscription.get() != null) {
            return this;
        }
        throw a("Not subscribed!");
    }

    public final void cancel() {
        dispose();
    }

    @Override // io.reactivex.disposables.Disposable
    public final void dispose() {
        DisposableHelper.dispose(this.subscription);
    }

    public final boolean hasSubscription() {
        return this.subscription.get() != null;
    }

    public final boolean isCancelled() {
        return isDisposed();
    }

    @Override // io.reactivex.disposables.Disposable
    public final boolean isDisposed() {
        return DisposableHelper.isDisposed(this.subscription.get());
    }

    @Override // io.reactivex.Observer
    public void onComplete() {
        if (!this.f) {
            this.f = true;
            if (this.subscription.get() == null) {
                this.c.add(new IllegalStateException("onSubscribe not called in proper order"));
            }
        }
        try {
            this.e = Thread.currentThread();
            this.d++;
            this.actual.onComplete();
        } finally {
            this.a.countDown();
        }
    }

    @Override // io.reactivex.Observer
    public void onError(Throwable th) {
        if (!this.f) {
            this.f = true;
            if (this.subscription.get() == null) {
                this.c.add(new IllegalStateException("onSubscribe not called in proper order"));
            }
        }
        try {
            this.e = Thread.currentThread();
            if (th == null) {
                this.c.add(new NullPointerException("onError received a null Throwable"));
            } else {
                this.c.add(th);
            }
            this.actual.onError(th);
        } finally {
            this.a.countDown();
        }
    }

    @Override // io.reactivex.Observer
    public void onNext(T t) {
        if (!this.f) {
            this.f = true;
            if (this.subscription.get() == null) {
                this.c.add(new IllegalStateException("onSubscribe not called in proper order"));
            }
        }
        this.e = Thread.currentThread();
        if (this.h != 2) {
            this.b.add(t);
            if (t == null) {
                this.c.add(new NullPointerException("onNext received a null value"));
            }
            this.actual.onNext(t);
            return;
        }
        while (true) {
            try {
                T poll = this.qs.poll();
                if (poll == null) {
                    return;
                } else {
                    this.b.add(poll);
                }
            } catch (Throwable th) {
                this.c.add(th);
                this.qs.dispose();
                return;
            }
        }
    }

    @Override // io.reactivex.Observer
    public void onSubscribe(Disposable disposable) {
        this.e = Thread.currentThread();
        if (disposable == null) {
            this.c.add(new NullPointerException("onSubscribe received a null Subscription"));
            return;
        }
        if (!this.subscription.compareAndSet(null, disposable)) {
            disposable.dispose();
            if (this.subscription.get() != DisposableHelper.DISPOSED) {
                this.c.add(new IllegalStateException("onSubscribe received multiple subscriptions: " + disposable));
                return;
            }
            return;
        }
        int i = this.g;
        if (i != 0 && (disposable instanceof QueueDisposable)) {
            this.qs = (QueueDisposable) disposable;
            int requestFusion = this.qs.requestFusion(i);
            this.h = requestFusion;
            if (requestFusion == 1) {
                this.f = true;
                this.e = Thread.currentThread();
                while (true) {
                    try {
                        T poll = this.qs.poll();
                        if (poll == null) {
                            this.d++;
                            this.subscription.lazySet(DisposableHelper.DISPOSED);
                            return;
                        }
                        this.b.add(poll);
                    } catch (Throwable th) {
                        this.c.add(th);
                        return;
                    }
                }
            }
        }
        this.actual.onSubscribe(disposable);
    }

    @Override // io.reactivex.MaybeObserver
    public void onSuccess(T t) {
        onNext(t);
        onComplete();
    }
}
