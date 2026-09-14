package io.reactivex.internal.schedulers;

import io.reactivex.Scheduler;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public final class IoScheduler extends Scheduler {
    private static final String EVICTOR_THREAD_NAME_PREFIX = "RxCachedWorkerPoolEvictor";
    private static final long KEEP_ALIVE_TIME = 60;
    private static final String KEY_IO_PRIORITY = "rx2.io-priority";
    private static final String WORKER_THREAD_NAME_PREFIX = "RxCachedThreadScheduler";
    static final RxThreadFactory d;
    static final RxThreadFactory e;
    static final CachedWorkerPool g;
    final ThreadFactory b;
    final AtomicReference<CachedWorkerPool> c;
    private static final TimeUnit KEEP_ALIVE_UNIT = TimeUnit.SECONDS;
    static final ThreadWorker f = new ThreadWorker(new RxThreadFactory("RxCachedThreadSchedulerShutdown"));

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class CachedWorkerPool implements Runnable {
        final CompositeDisposable a;
        private final ScheduledExecutorService evictorService;
        private final Future<?> evictorTask;
        private final ConcurrentLinkedQueue<ThreadWorker> expiringWorkerQueue;
        private final long keepAliveTime;
        private final ThreadFactory threadFactory;

        CachedWorkerPool(long j, TimeUnit timeUnit, ThreadFactory threadFactory) {
            ScheduledFuture<?> scheduledFuture;
            this.keepAliveTime = timeUnit != null ? timeUnit.toNanos(j) : 0L;
            this.expiringWorkerQueue = new ConcurrentLinkedQueue<>();
            this.a = new CompositeDisposable();
            this.threadFactory = threadFactory;
            ScheduledExecutorService scheduledExecutorService = null;
            if (timeUnit != null) {
                scheduledExecutorService = Executors.newScheduledThreadPool(1, IoScheduler.e);
                long j2 = this.keepAliveTime;
                scheduledFuture = scheduledExecutorService.scheduleWithFixedDelay(this, j2, j2, TimeUnit.NANOSECONDS);
            } else {
                scheduledFuture = null;
            }
            this.evictorService = scheduledExecutorService;
            this.evictorTask = scheduledFuture;
        }

        void a() {
            if (this.expiringWorkerQueue.isEmpty()) {
                return;
            }
            long c = c();
            Iterator<ThreadWorker> it = this.expiringWorkerQueue.iterator();
            while (it.hasNext()) {
                ThreadWorker next = it.next();
                if (next.getExpirationTime() > c) {
                    return;
                }
                if (this.expiringWorkerQueue.remove(next)) {
                    this.a.remove(next);
                }
            }
        }

        void a(ThreadWorker threadWorker) {
            threadWorker.setExpirationTime(c() + this.keepAliveTime);
            this.expiringWorkerQueue.offer(threadWorker);
        }

        ThreadWorker b() {
            if (this.a.isDisposed()) {
                return IoScheduler.f;
            }
            while (!this.expiringWorkerQueue.isEmpty()) {
                ThreadWorker poll = this.expiringWorkerQueue.poll();
                if (poll != null) {
                    return poll;
                }
            }
            ThreadWorker threadWorker = new ThreadWorker(this.threadFactory);
            this.a.add(threadWorker);
            return threadWorker;
        }

        long c() {
            return System.nanoTime();
        }

        void d() {
            this.a.dispose();
            Future<?> future = this.evictorTask;
            if (future != null) {
                future.cancel(true);
            }
            ScheduledExecutorService scheduledExecutorService = this.evictorService;
            if (scheduledExecutorService != null) {
                scheduledExecutorService.shutdownNow();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            a();
        }
    }

    /* loaded from: classes3.dex */
    static final class EventLoopWorker extends Scheduler.Worker {
        private final CachedWorkerPool pool;
        private final ThreadWorker threadWorker;
        final AtomicBoolean a = new AtomicBoolean();
        private final CompositeDisposable tasks = new CompositeDisposable();

        EventLoopWorker(CachedWorkerPool cachedWorkerPool) {
            this.pool = cachedWorkerPool;
            this.threadWorker = cachedWorkerPool.b();
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (this.a.compareAndSet(false, true)) {
                this.tasks.dispose();
                this.pool.a(this.threadWorker);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.a.get();
        }

        @Override // io.reactivex.Scheduler.Worker
        @NonNull
        public Disposable schedule(@NonNull Runnable runnable, long j, @NonNull TimeUnit timeUnit) {
            return this.tasks.isDisposed() ? EmptyDisposable.INSTANCE : this.threadWorker.scheduleActual(runnable, j, timeUnit, this.tasks);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class ThreadWorker extends NewThreadWorker {
        private long expirationTime;

        ThreadWorker(ThreadFactory threadFactory) {
            super(threadFactory);
            this.expirationTime = 0L;
        }

        public long getExpirationTime() {
            return this.expirationTime;
        }

        public void setExpirationTime(long j) {
            this.expirationTime = j;
        }
    }

    static {
        f.dispose();
        int max = Math.max(1, Math.min(10, Integer.getInteger(KEY_IO_PRIORITY, 5).intValue()));
        d = new RxThreadFactory(WORKER_THREAD_NAME_PREFIX, max);
        e = new RxThreadFactory(EVICTOR_THREAD_NAME_PREFIX, max);
        g = new CachedWorkerPool(0L, null, d);
        g.d();
    }

    public IoScheduler() {
        this(d);
    }

    public IoScheduler(ThreadFactory threadFactory) {
        this.b = threadFactory;
        this.c = new AtomicReference<>(g);
        start();
    }

    @Override // io.reactivex.Scheduler
    @NonNull
    public Scheduler.Worker createWorker() {
        return new EventLoopWorker(this.c.get());
    }

    @Override // io.reactivex.Scheduler
    public void shutdown() {
        CachedWorkerPool cachedWorkerPool;
        CachedWorkerPool cachedWorkerPool2;
        do {
            cachedWorkerPool = this.c.get();
            cachedWorkerPool2 = g;
            if (cachedWorkerPool == cachedWorkerPool2) {
                return;
            }
        } while (!this.c.compareAndSet(cachedWorkerPool, cachedWorkerPool2));
        cachedWorkerPool.d();
    }

    public int size() {
        return this.c.get().a.size();
    }

    @Override // io.reactivex.Scheduler
    public void start() {
        CachedWorkerPool cachedWorkerPool = new CachedWorkerPool(KEEP_ALIVE_TIME, KEEP_ALIVE_UNIT, this.b);
        if (this.c.compareAndSet(g, cachedWorkerPool)) {
            return;
        }
        cachedWorkerPool.d();
    }
}
