package com.google.firebase.crashlytics.internal.concurrency;

import android.os.Looper;
import com.google.firebase.crashlytics.internal.Logger;
import java.util.concurrent.ExecutorService;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.j;

/* loaded from: classes.dex */
public final class CrashlyticsWorkers {
    public static final Companion Companion = new Companion(null);
    private static boolean enforcement;
    public final CrashlyticsWorker common;
    public final CrashlyticsWorker dataCollect;
    public final CrashlyticsWorker diskWrite;
    public final CrashlyticsWorker network;

    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        private final void checkThread(F2.a aVar, F2.a aVar2) {
            if (!((Boolean) aVar.invoke()).booleanValue()) {
                Logger.getLogger().d((String) aVar2.invoke());
                getEnforcement();
            }
        }

        public static /* synthetic */ void getEnforcement$annotations() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String getThreadName() {
            return Thread.currentThread().getName();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean isBackgroundThread() {
            String threadName = getThreadName();
            j.d(threadName, "threadName");
            return N2.f.N(threadName, "Firebase Background Thread #", false);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean isBlockingThread() {
            String threadName = getThreadName();
            j.d(threadName, "threadName");
            return N2.f.N(threadName, "Firebase Blocking Thread #", false);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean isNotMainThread() {
            if (!Looper.getMainLooper().isCurrentThread()) {
                return true;
            }
            return false;
        }

        public final void checkBackgroundThread() {
            checkThread(new CrashlyticsWorkers$Companion$checkBackgroundThread$1(this), CrashlyticsWorkers$Companion$checkBackgroundThread$2.INSTANCE);
        }

        public final void checkBlockingThread() {
            checkThread(new CrashlyticsWorkers$Companion$checkBlockingThread$1(this), CrashlyticsWorkers$Companion$checkBlockingThread$2.INSTANCE);
        }

        public final void checkNotMainThread() {
            checkThread(new CrashlyticsWorkers$Companion$checkNotMainThread$1(this), CrashlyticsWorkers$Companion$checkNotMainThread$2.INSTANCE);
        }

        public final boolean getEnforcement() {
            return CrashlyticsWorkers.enforcement;
        }

        public final void setEnforcement(boolean z3) {
            CrashlyticsWorkers.enforcement = z3;
        }

        private Companion() {
        }
    }

    public CrashlyticsWorkers(ExecutorService backgroundExecutorService, ExecutorService blockingExecutorService) {
        j.e(backgroundExecutorService, "backgroundExecutorService");
        j.e(blockingExecutorService, "blockingExecutorService");
        this.common = new CrashlyticsWorker(backgroundExecutorService);
        this.diskWrite = new CrashlyticsWorker(backgroundExecutorService);
        this.dataCollect = new CrashlyticsWorker(backgroundExecutorService);
        this.network = new CrashlyticsWorker(blockingExecutorService);
    }

    public static final void checkBackgroundThread() {
        Companion.checkBackgroundThread();
    }

    public static final void checkBlockingThread() {
        Companion.checkBlockingThread();
    }

    public static final void checkNotMainThread() {
        Companion.checkNotMainThread();
    }

    public static final boolean getEnforcement() {
        return Companion.getEnforcement();
    }

    public static final void setEnforcement(boolean z3) {
        Companion.setEnforcement(z3);
    }
}
