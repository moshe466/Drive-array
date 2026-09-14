package io.reactivex.schedulers;

import io.reactivex.Scheduler;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.Queue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public final class TestScheduler extends Scheduler {
    final Queue<TimedRunnable> b = new PriorityBlockingQueue(11);
    long c;
    volatile long d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public final class TestWorker extends Scheduler.Worker {
        volatile boolean a;

        /* loaded from: classes3.dex */
        final class QueueRemove implements Runnable {
            final TimedRunnable a;

            QueueRemove(TimedRunnable timedRunnable) {
                this.a = timedRunnable;
            }

            @Override // java.lang.Runnable
            public void run() {
                TestScheduler.this.b.remove(this.a);
            }
        }

        TestWorker() {
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.a = true;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.a;
        }

        @Override // io.reactivex.Scheduler.Worker
        public long now(@NonNull TimeUnit timeUnit) {
            return TestScheduler.this.now(timeUnit);
        }

        @Override // io.reactivex.Scheduler.Worker
        @NonNull
        public Disposable schedule(@NonNull Runnable runnable) {
            if (this.a) {
                return EmptyDisposable.INSTANCE;
            }
            TestScheduler testScheduler = TestScheduler.this;
            long j = testScheduler.c;
            testScheduler.c = 1 + j;
            TimedRunnable timedRunnable = new TimedRunnable(this, 0L, runnable, j);
            TestScheduler.this.b.add(timedRunnable);
            return Disposables.fromRunnable(new QueueRemove(timedRunnable));
        }

        @Override // io.reactivex.Scheduler.Worker
        @NonNull
        public Disposable schedule(@NonNull Runnable runnable, long j, @NonNull TimeUnit timeUnit) {
            if (this.a) {
                return EmptyDisposable.INSTANCE;
            }
            long nanos = TestScheduler.this.d + timeUnit.toNanos(j);
            TestScheduler testScheduler = TestScheduler.this;
            long j2 = testScheduler.c;
            testScheduler.c = 1 + j2;
            TimedRunnable timedRunnable = new TimedRunnable(this, nanos, runnable, j2);
            TestScheduler.this.b.add(timedRunnable);
            return Disposables.fromRunnable(new QueueRemove(timedRunnable));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class TimedRunnable implements Comparable<TimedRunnable> {
        final long a;
        final Runnable b;
        final TestWorker c;
        final long d;

        TimedRunnable(TestWorker testWorker, long j, Runnable runnable, long j2) {
            this.a = j;
            this.b = runnable;
            this.c = testWorker;
            this.d = j2;
        }

        @Override // java.lang.Comparable
        public int compareTo(TimedRunnable timedRunnable) {
            long j = this.a;
            long j2 = timedRunnable.a;
            return j == j2 ? ObjectHelper.compare(this.d, timedRunnable.d) : ObjectHelper.compare(j, j2);
        }

        public String toString() {
            return String.format("TimedRunnable(time = %d, run = %s)", Long.valueOf(this.a), this.b.toString());
        }
    }

    public TestScheduler() {
    }

    public TestScheduler(long j, TimeUnit timeUnit) {
        this.d = timeUnit.toNanos(j);
    }

    private void triggerActions(long j) {
        while (true) {
            TimedRunnable peek = this.b.peek();
            if (peek == null) {
                break;
            }
            long j2 = peek.a;
            if (j2 > j) {
                break;
            }
            if (j2 == 0) {
                j2 = this.d;
            }
            this.d = j2;
            this.b.remove(peek);
            if (!peek.c.a) {
                peek.b.run();
            }
        }
        this.d = j;
    }

    public void advanceTimeBy(long j, TimeUnit timeUnit) {
        advanceTimeTo(this.d + timeUnit.toNanos(j), TimeUnit.NANOSECONDS);
    }

    public void advanceTimeTo(long j, TimeUnit timeUnit) {
        triggerActions(timeUnit.toNanos(j));
    }

    @Override // io.reactivex.Scheduler
    @NonNull
    public Scheduler.Worker createWorker() {
        return new TestWorker();
    }

    @Override // io.reactivex.Scheduler
    public long now(@NonNull TimeUnit timeUnit) {
        return timeUnit.convert(this.d, TimeUnit.NANOSECONDS);
    }

    public void triggerActions() {
        triggerActions(this.d);
    }
}
