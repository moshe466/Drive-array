package io.reactivex.schedulers;

import io.reactivex.Scheduler;
import io.reactivex.annotations.NonNull;
import io.reactivex.internal.schedulers.ComputationScheduler;
import io.reactivex.internal.schedulers.ExecutorScheduler;
import io.reactivex.internal.schedulers.IoScheduler;
import io.reactivex.internal.schedulers.NewThreadScheduler;
import io.reactivex.internal.schedulers.SchedulerPoolFactory;
import io.reactivex.internal.schedulers.SingleScheduler;
import io.reactivex.internal.schedulers.TrampolineScheduler;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* loaded from: classes3.dex */
public final class Schedulers {

    @NonNull
    static final Scheduler a = RxJavaPlugins.initSingleScheduler(new SingleTask());

    @NonNull
    static final Scheduler b = RxJavaPlugins.initComputationScheduler(new ComputationTask());

    @NonNull
    static final Scheduler c = RxJavaPlugins.initIoScheduler(new IOTask());

    @NonNull
    static final Scheduler d = TrampolineScheduler.instance();

    @NonNull
    static final Scheduler e = RxJavaPlugins.initNewThreadScheduler(new NewThreadTask());

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class ComputationHolder {
        static final Scheduler a = new ComputationScheduler();

        ComputationHolder() {
        }
    }

    /* loaded from: classes3.dex */
    static final class ComputationTask implements Callable<Scheduler> {
        ComputationTask() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public Scheduler call() {
            return ComputationHolder.a;
        }
    }

    /* loaded from: classes3.dex */
    static final class IOTask implements Callable<Scheduler> {
        IOTask() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public Scheduler call() {
            return IoHolder.a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class IoHolder {
        static final Scheduler a = new IoScheduler();

        IoHolder() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class NewThreadHolder {
        static final Scheduler a = new NewThreadScheduler();

        NewThreadHolder() {
        }
    }

    /* loaded from: classes3.dex */
    static final class NewThreadTask implements Callable<Scheduler> {
        NewThreadTask() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public Scheduler call() {
            return NewThreadHolder.a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class SingleHolder {
        static final Scheduler a = new SingleScheduler();

        SingleHolder() {
        }
    }

    /* loaded from: classes3.dex */
    static final class SingleTask implements Callable<Scheduler> {
        SingleTask() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public Scheduler call() {
            return SingleHolder.a;
        }
    }

    private Schedulers() {
        throw new IllegalStateException("No instances!");
    }

    @NonNull
    public static Scheduler computation() {
        return RxJavaPlugins.onComputationScheduler(b);
    }

    @NonNull
    public static Scheduler from(@NonNull Executor executor) {
        return new ExecutorScheduler(executor);
    }

    @NonNull
    public static Scheduler io() {
        return RxJavaPlugins.onIoScheduler(c);
    }

    @NonNull
    public static Scheduler newThread() {
        return RxJavaPlugins.onNewThreadScheduler(e);
    }

    public static void shutdown() {
        computation().shutdown();
        io().shutdown();
        newThread().shutdown();
        single().shutdown();
        trampoline().shutdown();
        SchedulerPoolFactory.shutdown();
    }

    @NonNull
    public static Scheduler single() {
        return RxJavaPlugins.onSingleScheduler(a);
    }

    public static void start() {
        computation().start();
        io().start();
        newThread().start();
        single().start();
        trampoline().start();
        SchedulerPoolFactory.start();
    }

    @NonNull
    public static Scheduler trampoline() {
        return d;
    }
}
