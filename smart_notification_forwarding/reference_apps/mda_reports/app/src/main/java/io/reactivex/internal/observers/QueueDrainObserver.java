package io.reactivex.internal.observers;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.util.ObservableQueueDrain;
import io.reactivex.internal.util.QueueDrainHelper;

/* loaded from: classes.dex */
public abstract class QueueDrainObserver<T, U, V> extends QueueDrainSubscriberPad2 implements Observer<T>, ObservableQueueDrain<U, V> {
    protected final Observer<? super V> b;
    protected final SimplePlainQueue<U> c;
    protected volatile boolean d;
    protected volatile boolean e;
    protected Throwable f;

    public QueueDrainObserver(Observer<? super V> observer, SimplePlainQueue<U> simplePlainQueue) {
        this.b = observer;
        this.c = simplePlainQueue;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(U u, boolean z, Disposable disposable) {
        Observer<? super V> observer = this.b;
        SimplePlainQueue<U> simplePlainQueue = this.c;
        if (this.a.get() == 0 && this.a.compareAndSet(0, 1)) {
            accept(observer, u);
            if (leave(-1) == 0) {
                return;
            }
        } else {
            simplePlainQueue.offer(u);
            if (!enter()) {
                return;
            }
        }
        QueueDrainHelper.drainLoop(simplePlainQueue, observer, z, disposable, this);
    }

    @Override // io.reactivex.internal.util.ObservableQueueDrain
    public void accept(Observer<? super V> observer, U u) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b(U u, boolean z, Disposable disposable) {
        Observer<? super V> observer = this.b;
        SimplePlainQueue<U> simplePlainQueue = this.c;
        if (this.a.get() != 0 || !this.a.compareAndSet(0, 1)) {
            simplePlainQueue.offer(u);
            if (!enter()) {
                return;
            }
        } else if (simplePlainQueue.isEmpty()) {
            accept(observer, u);
            if (leave(-1) == 0) {
                return;
            }
        } else {
            simplePlainQueue.offer(u);
        }
        QueueDrainHelper.drainLoop(simplePlainQueue, observer, z, disposable, this);
    }

    @Override // io.reactivex.internal.util.ObservableQueueDrain
    public final boolean cancelled() {
        return this.d;
    }

    @Override // io.reactivex.internal.util.ObservableQueueDrain
    public final boolean done() {
        return this.e;
    }

    @Override // io.reactivex.internal.util.ObservableQueueDrain
    public final boolean enter() {
        return this.a.getAndIncrement() == 0;
    }

    @Override // io.reactivex.internal.util.ObservableQueueDrain
    public final Throwable error() {
        return this.f;
    }

    public final boolean fastEnter() {
        return this.a.get() == 0 && this.a.compareAndSet(0, 1);
    }

    @Override // io.reactivex.internal.util.ObservableQueueDrain
    public final int leave(int i) {
        return this.a.addAndGet(i);
    }
}
