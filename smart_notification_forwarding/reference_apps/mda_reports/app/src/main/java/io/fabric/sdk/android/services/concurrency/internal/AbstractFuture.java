package io.fabric.sdk.android.services.concurrency.internal;

import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/* loaded from: classes2.dex */
public abstract class AbstractFuture<V> implements Future<V> {
    private final Sync<V> sync = new Sync<>();

    /* loaded from: classes2.dex */
    static final class Sync<V> extends AbstractQueuedSynchronizer {
        private static final long serialVersionUID = 0;
        private Throwable exception;
        private V value;

        Sync() {
        }

        private boolean complete(V v, Throwable th, int i) {
            boolean compareAndSetState = compareAndSetState(0, 1);
            if (compareAndSetState) {
                this.value = v;
                if ((i & 12) != 0) {
                    th = new CancellationException("Future.cancel() was called.");
                }
                this.exception = th;
                releaseShared(i);
            } else if (getState() == 1) {
                acquireShared(-1);
            }
            return compareAndSetState;
        }

        private V getValue() {
            int state = getState();
            if (state == 2) {
                Throwable th = this.exception;
                if (th == null) {
                    return this.value;
                }
                throw new ExecutionException(th);
            }
            if (state == 4 || state == 8) {
                throw AbstractFuture.a("Task was cancelled.", this.exception);
            }
            throw new IllegalStateException("Error, synchronizer in invalid state: " + state);
        }

        V a() {
            acquireSharedInterruptibly(-1);
            return getValue();
        }

        V a(long j) {
            if (tryAcquireSharedNanos(-1, j)) {
                return getValue();
            }
            throw new TimeoutException("Timeout waiting for task.");
        }

        boolean a(V v) {
            return complete(v, null, 2);
        }

        boolean a(Throwable th) {
            return complete(null, th, 2);
        }

        boolean a(boolean z) {
            return complete(null, null, z ? 8 : 4);
        }

        boolean b() {
            return (getState() & 12) != 0;
        }

        boolean c() {
            return (getState() & 14) != 0;
        }

        @Override // java.util.concurrent.locks.AbstractQueuedSynchronizer
        protected int tryAcquireShared(int i) {
            return c() ? 1 : -1;
        }

        @Override // java.util.concurrent.locks.AbstractQueuedSynchronizer
        protected boolean tryReleaseShared(int i) {
            setState(i);
            return true;
        }
    }

    static final CancellationException a(String str, Throwable th) {
        CancellationException cancellationException = new CancellationException(str);
        cancellationException.initCause(th);
        return cancellationException;
    }

    protected void a() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean a(V v) {
        return this.sync.a((Sync<V>) v);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean a(Throwable th) {
        if (th != null) {
            return this.sync.a(th);
        }
        throw new NullPointerException();
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        if (!this.sync.a(z)) {
            return false;
        }
        if (!z) {
            return true;
        }
        a();
        return true;
    }

    @Override // java.util.concurrent.Future
    public V get() {
        return this.sync.a();
    }

    @Override // java.util.concurrent.Future
    public V get(long j, TimeUnit timeUnit) {
        return this.sync.a(timeUnit.toNanos(j));
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return this.sync.b();
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return this.sync.c();
    }
}
