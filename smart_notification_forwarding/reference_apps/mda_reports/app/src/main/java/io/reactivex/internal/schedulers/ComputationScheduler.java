package io.reactivex.internal.schedulers;

import io.reactivex.Scheduler;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.disposables.ListCompositeDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.schedulers.SchedulerMultiWorkerSupport;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public final class ComputationScheduler extends Scheduler implements SchedulerMultiWorkerSupport {
    private static final String KEY_COMPUTATION_PRIORITY = "rx2.computation-priority";
    private static final String THREAD_NAME_PREFIX = "RxComputationThreadPool";
    static final FixedSchedulerPool d;
    static final RxThreadFactory e;
    static final int f = a(Runtime.getRuntime().availableProcessors(), Integer.getInteger("rx2.computation-threads", 0).intValue());
    static final PoolWorker g = new PoolWorker(new RxThreadFactory("RxComputationShutdown"));
    final ThreadFactory b;
    final AtomicReference<FixedSchedulerPool> c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class EventLoopWorker extends Scheduler.Worker {
        volatile boolean a;
        private final PoolWorker poolWorker;
        private final ListCompositeDisposable serial = new ListCompositeDisposable();
        private final CompositeDisposable timed = new CompositeDisposable();
        private final ListCompositeDisposable both = new ListCompositeDisposable();

        EventLoopWorker(PoolWorker poolWorker) {
            this.poolWorker = poolWorker;
            this.both.add(this.serial);
            this.both.add(this.timed);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (this.a) {
                return;
            }
            this.a = true;
            this.both.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.a;
        }

        @Override // io.reactivex.Scheduler.Worker
        @NonNull
        public Disposable schedule(@NonNull Runnable runnable) {
            return this.a ? EmptyDisposable.INSTANCE : this.poolWorker.scheduleActual(runnable, 0L, TimeUnit.MILLISECONDS, this.serial);
        }

        @Override // io.reactivex.Scheduler.Worker
        @NonNull
        public Disposable schedule(@NonNull Runnable runnable, long j, @NonNull TimeUnit timeUnit) {
            return this.a ? EmptyDisposable.INSTANCE : this.poolWorker.scheduleActual(runnable, j, timeUnit, this.timed);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class FixedSchedulerPool implements SchedulerMultiWorkerSupport {
        final int a;
        final PoolWorker[] b;
        long c;

        FixedSchedulerPool(int i, ThreadFactory threadFactory) {
            this.a = i;
            this.b = new PoolWorker[i];
            for (int i2 = 0; i2 < i; i2++) {
                this.b[i2] = new PoolWorker(threadFactory);
            }
        }

        @Override // io.reactivex.internal.schedulers.SchedulerMultiWorkerSupport
        public void createWorkers(int i, SchedulerMultiWorkerSupport.WorkerCallback workerCallback) {
            int i2 = this.a;
            if (i2 == 0) {
                for (int i3 = 0; i3 < i; i3++) {
                    workerCallback.onWorker(i3, ComputationScheduler.g);
                }
                return;
            }
            int i4 = ((int) this.c) % i2;
            for (int i5 = 0; i5 < i; i5++) {
                workerCallback.onWorker(i5, new EventLoopWorker(this.b[i4]));
                i4++;
                if (i4 == i2) {
                    i4 = 0;
                }
            }
            this.c = i4;
        }

        public PoolWorker getEventLoop() {
            int i = this.a;
            if (i == 0) {
                return ComputationScheduler.g;
            }
            PoolWorker[] poolWorkerArr = this.b;
            long j = this.c;
            this.c = 1 + j;
            return poolWorkerArr[(int) (j % i)];
        }

        public void shutdown() {
            for (PoolWorker poolWorker : this.b) {
                poolWorker.dispose();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class PoolWorker extends NewThreadWorker {
        PoolWorker(ThreadFactory threadFactory) {
            super(threadFactory);
        }
    }

    static {
        g.dispose();
        e = new RxThreadFactory(THREAD_NAME_PREFIX, Math.max(1, Math.min(10, Integer.getInteger(KEY_COMPUTATION_PRIORITY, 5).intValue())), true);
        d = new FixedSchedulerPool(0, e);
        d.shutdown();
    }

    public ComputationScheduler() {
        this(e);
    }

    public ComputationScheduler(ThreadFactory threadFactory) {
        this.b = threadFactory;
        this.c = new AtomicReference<>(d);
        start();
    }

    static int a(int i, int i2) {
        return (i2 <= 0 || i2 > i) ? i : i2;
    }

    @Override // io.reactivex.Scheduler
    @NonNull
    public Scheduler.Worker createWorker() {
        return new EventLoopWorker(this.c.get().getEventLoop());
    }

    @Override // io.reactivex.internal.schedulers.SchedulerMultiWorkerSupport
    public void createWorkers(int i, SchedulerMultiWorkerSupport.WorkerCallback workerCallback) {
        ObjectHelper.verifyPositive(i, "number > 0 required");
        this.c.get().createWorkers(i, workerCallback);
    }

    @Override // io.reactivex.Scheduler
    @NonNull
    public Disposable scheduleDirect(@NonNull Runnable runnable, long j, TimeUnit timeUnit) {
        return this.c.get().getEventLoop().scheduleDirect(runnable, j, timeUnit);
    }

    @Override // io.reactivex.Scheduler
    @NonNull
    public Disposable schedulePeriodicallyDirect(@NonNull Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        return this.c.get().getEventLoop().schedulePeriodicallyDirect(runnable, j, j2, timeUnit);
    }

    @Override // io.reactivex.Scheduler
    public void shutdown() {
        FixedSchedulerPool fixedSchedulerPool;
        FixedSchedulerPool fixedSchedulerPool2;
        do {
            fixedSchedulerPool = this.c.get();
            fixedSchedulerPool2 = d;
            if (fixedSchedulerPool == fixedSchedulerPool2) {
                return;
            }
        } while (!this.c.compareAndSet(fixedSchedulerPool, fixedSchedulerPool2));
        fixedSchedulerPool.shutdown();
    }

    @Override // io.reactivex.Scheduler
    public void start() {
        FixedSchedulerPool fixedSchedulerPool = new FixedSchedulerPool(f, this.b);
        if (this.c.compareAndSet(d, fixedSchedulerPool)) {
            return;
        }
        fixedSchedulerPool.shutdown();
    }
}
