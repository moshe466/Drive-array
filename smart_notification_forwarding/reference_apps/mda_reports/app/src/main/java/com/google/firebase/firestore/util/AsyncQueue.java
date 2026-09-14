package com.google.firebase.firestore.util;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import javax.annotation.CheckReturnValue;

/* loaded from: classes.dex */
public class AsyncQueue {
    private final ArrayList<TimerId> timerIdsToSkip = new ArrayList<>();
    private final ArrayList<DelayedTask> delayedTasks = new ArrayList<>();
    private final SynchronizedShutdownAwareExecutor executor = new SynchronizedShutdownAwareExecutor();

    /* loaded from: classes2.dex */
    public class DelayedTask {
        private ScheduledFuture scheduledFuture;
        private final long targetTimeMs;
        private final Runnable task;
        private final TimerId timerId;

        private DelayedTask(TimerId timerId, long j, Runnable runnable) {
            this.timerId = timerId;
            this.targetTimeMs = j;
            this.task = runnable;
        }

        /* synthetic */ DelayedTask(AsyncQueue asyncQueue, TimerId timerId, long j, Runnable runnable, AnonymousClass1 anonymousClass1) {
            this(timerId, j, runnable);
        }

        public void handleDelayElapsed() {
            AsyncQueue.this.verifyIsCurrentThread();
            if (this.scheduledFuture != null) {
                markDone();
                this.task.run();
            }
        }

        private void markDone() {
            Assert.hardAssert(this.scheduledFuture != null, "Caller should have verified scheduledFuture is non-null.", new Object[0]);
            this.scheduledFuture = null;
            AsyncQueue.this.removeDelayedTask(this);
        }

        public void start(long j) {
            this.scheduledFuture = AsyncQueue.this.executor.schedule(AsyncQueue$DelayedTask$$Lambda$1.lambdaFactory$(this), j, TimeUnit.MILLISECONDS);
        }

        void a() {
            handleDelayElapsed();
        }

        public void cancel() {
            AsyncQueue.this.verifyIsCurrentThread();
            ScheduledFuture scheduledFuture = this.scheduledFuture;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(false);
                markDone();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class SynchronizedShutdownAwareExecutor implements Executor {
        private final ScheduledThreadPoolExecutor internalExecutor;
        private boolean isShuttingDown;
        private final Thread thread;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.google.firebase.firestore.util.AsyncQueue$SynchronizedShutdownAwareExecutor$1 */
        /* loaded from: classes2.dex */
        public class AnonymousClass1 extends ScheduledThreadPoolExecutor {
            AnonymousClass1(int i, ThreadFactory threadFactory, AsyncQueue asyncQueue) {
                super(i, threadFactory);
            }

            @Override // java.util.concurrent.ThreadPoolExecutor
            protected void afterExecute(Runnable runnable, Throwable th) {
                super.afterExecute(runnable, th);
                if (th == null && (runnable instanceof Future)) {
                    Future future = (Future) runnable;
                    try {
                        if (future.isDone()) {
                            future.get();
                        }
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    } catch (CancellationException unused2) {
                    } catch (ExecutionException e) {
                        th = e.getCause();
                    }
                }
                if (th != null) {
                    AsyncQueue.this.panic(th);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes2.dex */
        public class DelayedStartFactory implements Runnable, ThreadFactory {
            private Runnable delegate;
            private final CountDownLatch latch;

            private DelayedStartFactory() {
                this.latch = new CountDownLatch(1);
            }

            /* synthetic */ DelayedStartFactory(SynchronizedShutdownAwareExecutor synchronizedShutdownAwareExecutor, AnonymousClass1 anonymousClass1) {
                this();
            }

            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(@NonNull Runnable runnable) {
                Assert.hardAssert(this.delegate == null, "Only one thread may be created in an AsyncQueue.", new Object[0]);
                this.delegate = runnable;
                this.latch.countDown();
                return SynchronizedShutdownAwareExecutor.this.thread;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    this.latch.await();
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                }
                this.delegate.run();
            }
        }

        SynchronizedShutdownAwareExecutor() {
            DelayedStartFactory delayedStartFactory = new DelayedStartFactory();
            this.thread = java.util.concurrent.Executors.defaultThreadFactory().newThread(delayedStartFactory);
            this.thread.setName("FirestoreWorker");
            this.thread.setDaemon(true);
            this.thread.setUncaughtExceptionHandler(AsyncQueue$SynchronizedShutdownAwareExecutor$$Lambda$1.lambdaFactory$(this));
            this.internalExecutor = new ScheduledThreadPoolExecutor(1, delayedStartFactory, AsyncQueue.this) { // from class: com.google.firebase.firestore.util.AsyncQueue.SynchronizedShutdownAwareExecutor.1
                AnonymousClass1(int i, ThreadFactory delayedStartFactory2, AsyncQueue asyncQueue) {
                    super(i, delayedStartFactory2);
                }

                @Override // java.util.concurrent.ThreadPoolExecutor
                protected void afterExecute(Runnable runnable, Throwable th) {
                    super.afterExecute(runnable, th);
                    if (th == null && (runnable instanceof Future)) {
                        Future future = (Future) runnable;
                        try {
                            if (future.isDone()) {
                                future.get();
                            }
                        } catch (InterruptedException unused) {
                            Thread.currentThread().interrupt();
                        } catch (CancellationException unused2) {
                        } catch (ExecutionException e) {
                            th = e.getCause();
                        }
                    }
                    if (th != null) {
                        AsyncQueue.this.panic(th);
                    }
                }
            };
            this.internalExecutor.setKeepAliveTime(3L, TimeUnit.SECONDS);
            this.isShuttingDown = false;
        }

        public static /* synthetic */ Void a(Runnable runnable) {
            runnable.run();
            return null;
        }

        public static /* synthetic */ void a(TaskCompletionSource taskCompletionSource, Callable callable) {
            try {
                taskCompletionSource.setResult(callable.call());
            } catch (Exception e) {
                taskCompletionSource.setException(e);
                throw new RuntimeException(e);
            }
        }

        public static /* synthetic */ void a(SynchronizedShutdownAwareExecutor synchronizedShutdownAwareExecutor, Thread thread, Throwable th) {
            AsyncQueue.this.panic(th);
        }

        public synchronized Task<Void> executeAndInitiateShutdown(Runnable runnable) {
            if (!isShuttingDown()) {
                Task<Void> executeAndReportResult = executeAndReportResult(AsyncQueue$SynchronizedShutdownAwareExecutor$$Lambda$3.lambdaFactory$(runnable));
                this.isShuttingDown = true;
                return executeAndReportResult;
            }
            TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
            taskCompletionSource.setResult(null);
            return taskCompletionSource.getTask();
        }

        public <T> Task<T> executeAndReportResult(Callable<T> callable) {
            TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
            try {
                execute(AsyncQueue$SynchronizedShutdownAwareExecutor$$Lambda$2.lambdaFactory$(taskCompletionSource, callable));
            } catch (RejectedExecutionException unused) {
                Logger.warn(AsyncQueue.class.getSimpleName(), "Refused to enqueue task after panic", new Object[0]);
            }
            return taskCompletionSource.getTask();
        }

        public synchronized boolean isShuttingDown() {
            return this.isShuttingDown;
        }

        public synchronized ScheduledFuture<?> schedule(Runnable runnable, long j, TimeUnit timeUnit) {
            if (this.isShuttingDown) {
                return null;
            }
            return this.internalExecutor.schedule(runnable, j, timeUnit);
        }

        public void setCorePoolSize(int i) {
            this.internalExecutor.setCorePoolSize(i);
        }

        public void shutdownNow() {
            this.internalExecutor.shutdownNow();
        }

        @Override // java.util.concurrent.Executor
        public synchronized void execute(Runnable runnable) {
            if (!this.isShuttingDown) {
                this.internalExecutor.execute(runnable);
            }
        }

        public void executeEvenAfterShutdown(Runnable runnable) {
            try {
                this.internalExecutor.execute(runnable);
            } catch (RejectedExecutionException unused) {
                Logger.warn(AsyncQueue.class.getSimpleName(), "Refused to enqueue task after panic", new Object[0]);
            }
        }
    }

    /* loaded from: classes2.dex */
    public enum TimerId {
        ALL,
        LISTEN_STREAM_IDLE,
        LISTEN_STREAM_CONNECTION_BACKOFF,
        WRITE_STREAM_IDLE,
        WRITE_STREAM_CONNECTION_BACKOFF,
        ONLINE_STATE_TIMEOUT,
        GARBAGE_COLLECTION,
        RETRY_TRANSACTION
    }

    public static /* synthetic */ int a(DelayedTask delayedTask, DelayedTask delayedTask2) {
        return (delayedTask.targetTimeMs > delayedTask2.targetTimeMs ? 1 : (delayedTask.targetTimeMs == delayedTask2.targetTimeMs ? 0 : -1));
    }

    public static /* synthetic */ Void a(TaskCompletionSource taskCompletionSource, Task task) {
        if (task.isSuccessful()) {
            taskCompletionSource.setResult(task.getResult());
            return null;
        }
        taskCompletionSource.setException(task.getException());
        return null;
    }

    public static /* synthetic */ Void a(Runnable runnable) {
        runnable.run();
        return null;
    }

    public static /* synthetic */ void a(AsyncQueue asyncQueue, TimerId timerId) {
        Comparator comparator;
        Assert.hardAssert(timerId == TimerId.ALL || asyncQueue.containsDelayedTask(timerId), "Attempted to run tasks until missing TimerId: %s", timerId);
        ArrayList<DelayedTask> arrayList = asyncQueue.delayedTasks;
        comparator = AsyncQueue$$Lambda$6.instance;
        Collections.sort(arrayList, comparator);
        Iterator it = new ArrayList(asyncQueue.delayedTasks).iterator();
        while (it.hasNext()) {
            DelayedTask delayedTask = (DelayedTask) it.next();
            delayedTask.a();
            if (timerId != TimerId.ALL && delayedTask.timerId == timerId) {
                return;
            }
        }
    }

    public static /* synthetic */ void a(Runnable runnable, Throwable[] thArr, Semaphore semaphore) {
        try {
            runnable.run();
        } catch (Throwable th) {
            thArr[0] = th;
        }
        semaphore.release();
    }

    public static /* synthetic */ void a(Throwable th) {
        if (!(th instanceof OutOfMemoryError)) {
            throw new RuntimeException("Internal error in Cloud Firestore (21.3.1).", th);
        }
        OutOfMemoryError outOfMemoryError = new OutOfMemoryError("Firestore (21.3.1) ran out of memory. Check your queries to make sure they are not loading an excessive amount of data.");
        outOfMemoryError.initCause(th);
        throw outOfMemoryError;
    }

    public static /* synthetic */ void a(Callable callable, Executor executor, TaskCompletionSource taskCompletionSource) {
        try {
            ((Task) callable.call()).continueWith(executor, AsyncQueue$$Lambda$7.lambdaFactory$(taskCompletionSource));
        } catch (Exception e) {
            taskCompletionSource.setException(e);
        } catch (Throwable th) {
            taskCompletionSource.setException(new IllegalStateException("Unhandled throwable in callTask.", th));
        }
    }

    public static <TResult> Task<TResult> callTask(Executor executor, Callable<Task<TResult>> callable) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        executor.execute(AsyncQueue$$Lambda$1.lambdaFactory$(callable, executor, taskCompletionSource));
        return taskCompletionSource.getTask();
    }

    private DelayedTask createAndScheduleDelayedTask(TimerId timerId, long j, Runnable runnable) {
        DelayedTask delayedTask = new DelayedTask(timerId, System.currentTimeMillis() + j, runnable);
        delayedTask.start(j);
        return delayedTask;
    }

    public void removeDelayedTask(DelayedTask delayedTask) {
        Assert.hardAssert(this.delayedTasks.remove(delayedTask), "Delayed task not found.", new Object[0]);
    }

    @VisibleForTesting
    public boolean containsDelayedTask(TimerId timerId) {
        Iterator<DelayedTask> it = this.delayedTasks.iterator();
        while (it.hasNext()) {
            if (it.next().timerId == timerId) {
                return true;
            }
        }
        return false;
    }

    @CheckReturnValue
    public Task<Void> enqueue(Runnable runnable) {
        return enqueue(AsyncQueue$$Lambda$2.lambdaFactory$(runnable));
    }

    @CheckReturnValue
    public <T> Task<T> enqueue(Callable<T> callable) {
        return this.executor.executeAndReportResult(callable);
    }

    public DelayedTask enqueueAfterDelay(TimerId timerId, long j, Runnable runnable) {
        if (this.timerIdsToSkip.contains(timerId)) {
            j = 0;
        }
        DelayedTask createAndScheduleDelayedTask = createAndScheduleDelayedTask(timerId, j, runnable);
        this.delayedTasks.add(createAndScheduleDelayedTask);
        return createAndScheduleDelayedTask;
    }

    public void enqueueAndForget(Runnable runnable) {
        enqueue(runnable);
    }

    public void enqueueAndForgetEvenAfterShutdown(Runnable runnable) {
        this.executor.executeEvenAfterShutdown(runnable);
    }

    public Task<Void> enqueueAndInitiateShutdown(Runnable runnable) {
        return this.executor.executeAndInitiateShutdown(runnable);
    }

    public Executor getExecutor() {
        return this.executor;
    }

    public boolean isShuttingDown() {
        return this.executor.isShuttingDown();
    }

    public void panic(Throwable th) {
        this.executor.shutdownNow();
        new Handler(Looper.getMainLooper()).post(AsyncQueue$$Lambda$3.lambdaFactory$(th));
    }

    @VisibleForTesting
    public void runDelayedTasksUntil(TimerId timerId) {
        runSync(AsyncQueue$$Lambda$5.lambdaFactory$(this, timerId));
    }

    @VisibleForTesting
    public void runSync(Runnable runnable) {
        Semaphore semaphore = new Semaphore(0);
        Throwable[] thArr = new Throwable[1];
        enqueueAndForget(AsyncQueue$$Lambda$4.lambdaFactory$(runnable, thArr, semaphore));
        semaphore.acquire(1);
        if (thArr[0] != null) {
            throw new RuntimeException("Synchronous task failed", thArr[0]);
        }
    }

    public void shutdown() {
        this.executor.setCorePoolSize(0);
    }

    @VisibleForTesting
    public void skipDelaysForTimerId(TimerId timerId) {
        this.timerIdsToSkip.add(timerId);
    }

    public void verifyIsCurrentThread() {
        Thread currentThread = Thread.currentThread();
        if (this.executor.thread != currentThread) {
            throw Assert.fail("We are running on the wrong thread. Expected to be on the AsyncQueue thread %s/%d but was %s/%d", this.executor.thread.getName(), Long.valueOf(this.executor.thread.getId()), currentThread.getName(), Long.valueOf(currentThread.getId()));
        }
    }
}
