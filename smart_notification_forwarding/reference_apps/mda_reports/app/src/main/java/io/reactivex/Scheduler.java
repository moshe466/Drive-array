package io.reactivex;

import io.reactivex.annotations.NonNull;
import io.reactivex.annotations.Nullable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.schedulers.NewThreadWorker;
import io.reactivex.internal.schedulers.SchedulerWhen;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.SchedulerRunnableIntrospection;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public abstract class Scheduler {
    static final long a = TimeUnit.MINUTES.toNanos(Long.getLong("rx2.scheduler.drift-tolerance", 15).longValue());

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class DisposeTask implements Disposable, Runnable, SchedulerRunnableIntrospection {

        @NonNull
        final Runnable a;

        @NonNull
        final Worker b;

        @Nullable
        Thread c;

        DisposeTask(@NonNull Runnable runnable, @NonNull Worker worker) {
            this.a = runnable;
            this.b = worker;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (this.c == Thread.currentThread()) {
                Worker worker = this.b;
                if (worker instanceof NewThreadWorker) {
                    ((NewThreadWorker) worker).shutdown();
                    return;
                }
            }
            this.b.dispose();
        }

        @Override // io.reactivex.schedulers.SchedulerRunnableIntrospection
        public Runnable getWrappedRunnable() {
            return this.a;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.b.isDisposed();
        }

        @Override // java.lang.Runnable
        public void run() {
            this.c = Thread.currentThread();
            try {
                this.a.run();
            } finally {
                dispose();
                this.c = null;
            }
        }
    }

    /* loaded from: classes2.dex */
    static final class PeriodicDirectTask implements Disposable, Runnable, SchedulerRunnableIntrospection {

        @NonNull
        final Runnable a;

        @NonNull
        final Worker b;
        volatile boolean c;

        PeriodicDirectTask(@NonNull Runnable runnable, @NonNull Worker worker) {
            this.a = runnable;
            this.b = worker;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.c = true;
            this.b.dispose();
        }

        @Override // io.reactivex.schedulers.SchedulerRunnableIntrospection
        public Runnable getWrappedRunnable() {
            return this.a;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.c;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.c) {
                return;
            }
            try {
                this.a.run();
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                this.b.dispose();
                throw ExceptionHelper.wrapOrThrow(th);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static abstract class Worker implements Disposable {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes2.dex */
        public final class PeriodicTask implements Runnable, SchedulerRunnableIntrospection {

            @NonNull
            final Runnable a;

            @NonNull
            final SequentialDisposable b;
            final long c;
            long d;
            long e;
            long f;

            PeriodicTask(long j, @NonNull Runnable runnable, long j2, @NonNull SequentialDisposable sequentialDisposable, long j3) {
                this.a = runnable;
                this.b = sequentialDisposable;
                this.c = j3;
                this.e = j2;
                this.f = j;
            }

            @Override // io.reactivex.schedulers.SchedulerRunnableIntrospection
            public Runnable getWrappedRunnable() {
                return this.a;
            }

            @Override // java.lang.Runnable
            public void run() {
                long j;
                this.a.run();
                if (this.b.isDisposed()) {
                    return;
                }
                long now = Worker.this.now(TimeUnit.NANOSECONDS);
                long j2 = Scheduler.a;
                long j3 = now + j2;
                long j4 = this.e;
                if (j3 >= j4) {
                    long j5 = this.c;
                    if (now < j4 + j5 + j2) {
                        long j6 = this.f;
                        long j7 = this.d + 1;
                        this.d = j7;
                        j = j6 + (j7 * j5);
                        this.e = now;
                        this.b.replace(Worker.this.schedule(this, j - now, TimeUnit.NANOSECONDS));
                    }
                }
                long j8 = this.c;
                long j9 = now + j8;
                long j10 = this.d + 1;
                this.d = j10;
                this.f = j9 - (j8 * j10);
                j = j9;
                this.e = now;
                this.b.replace(Worker.this.schedule(this, j - now, TimeUnit.NANOSECONDS));
            }
        }

        public long now(@NonNull TimeUnit timeUnit) {
            return timeUnit.convert(System.currentTimeMillis(), TimeUnit.MILLISECONDS);
        }

        @NonNull
        public Disposable schedule(@NonNull Runnable runnable) {
            return schedule(runnable, 0L, TimeUnit.NANOSECONDS);
        }

        @NonNull
        public abstract Disposable schedule(@NonNull Runnable runnable, long j, @NonNull TimeUnit timeUnit);

        @NonNull
        public Disposable schedulePeriodically(@NonNull Runnable runnable, long j, long j2, @NonNull TimeUnit timeUnit) {
            SequentialDisposable sequentialDisposable = new SequentialDisposable();
            SequentialDisposable sequentialDisposable2 = new SequentialDisposable(sequentialDisposable);
            Runnable onSchedule = RxJavaPlugins.onSchedule(runnable);
            long nanos = timeUnit.toNanos(j2);
            long now = now(TimeUnit.NANOSECONDS);
            Disposable schedule = schedule(new PeriodicTask(now + timeUnit.toNanos(j), onSchedule, now, sequentialDisposable2, nanos), j, timeUnit);
            if (schedule == EmptyDisposable.INSTANCE) {
                return schedule;
            }
            sequentialDisposable.replace(schedule);
            return sequentialDisposable2;
        }
    }

    public static long clockDriftTolerance() {
        return a;
    }

    @NonNull
    public abstract Worker createWorker();

    public long now(@NonNull TimeUnit timeUnit) {
        return timeUnit.convert(System.currentTimeMillis(), TimeUnit.MILLISECONDS);
    }

    @NonNull
    public Disposable scheduleDirect(@NonNull Runnable runnable) {
        return scheduleDirect(runnable, 0L, TimeUnit.NANOSECONDS);
    }

    @NonNull
    public Disposable scheduleDirect(@NonNull Runnable runnable, long j, @NonNull TimeUnit timeUnit) {
        Worker createWorker = createWorker();
        DisposeTask disposeTask = new DisposeTask(RxJavaPlugins.onSchedule(runnable), createWorker);
        createWorker.schedule(disposeTask, j, timeUnit);
        return disposeTask;
    }

    @NonNull
    public Disposable schedulePeriodicallyDirect(@NonNull Runnable runnable, long j, long j2, @NonNull TimeUnit timeUnit) {
        Worker createWorker = createWorker();
        PeriodicDirectTask periodicDirectTask = new PeriodicDirectTask(RxJavaPlugins.onSchedule(runnable), createWorker);
        Disposable schedulePeriodically = createWorker.schedulePeriodically(periodicDirectTask, j, j2, timeUnit);
        return schedulePeriodically == EmptyDisposable.INSTANCE ? schedulePeriodically : periodicDirectTask;
    }

    public void shutdown() {
    }

    public void start() {
    }

    @NonNull
    public <S extends Scheduler & Disposable> S when(@NonNull Function<Flowable<Flowable<Completable>>, Completable> function) {
        return new SchedulerWhen(function, this);
    }
}
