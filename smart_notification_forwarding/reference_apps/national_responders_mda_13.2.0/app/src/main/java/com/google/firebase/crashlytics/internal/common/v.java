package com.google.firebase.crashlytics.internal.common;

import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes.dex */
public final class v {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements ThreadFactory {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f7238a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ AtomicLong f7239b;

        /* renamed from: com.google.firebase.crashlytics.internal.common.v$a$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class C0091a extends d {

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ Runnable f7240f;

            C0091a(a aVar, Runnable runnable) {
                this.f7240f = runnable;
            }

            @Override // com.google.firebase.crashlytics.internal.common.d
            public void a() {
                this.f7240f.run();
            }
        }

        a(String str, AtomicLong atomicLong) {
            this.f7238a = str;
            this.f7239b = atomicLong;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread newThread = Executors.defaultThreadFactory().newThread(new C0091a(this, runnable));
            newThread.setName(this.f7238a + this.f7239b.getAndIncrement());
            return newThread;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b extends d {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f7241f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ ExecutorService f7242g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ long f7243h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ TimeUnit f7244i;

        b(String str, ExecutorService executorService, long j10, TimeUnit timeUnit) {
            this.f7241f = str;
            this.f7242g = executorService;
            this.f7243h = j10;
            this.f7244i = timeUnit;
        }

        @Override // com.google.firebase.crashlytics.internal.common.d
        public void a() {
            try {
                s3.b.f().b("Executing shutdown hook for " + this.f7241f);
                this.f7242g.shutdown();
                if (this.f7242g.awaitTermination(this.f7243h, this.f7244i)) {
                    return;
                }
                s3.b.f().b(this.f7241f + " did not shut down in the allocated time. Requesting immediate shutdown.");
                this.f7242g.shutdownNow();
            } catch (InterruptedException unused) {
                s3.b.f().b(String.format(Locale.US, "Interrupted while waiting for %s to shut down. Requesting immediate shutdown.", this.f7241f));
                this.f7242g.shutdownNow();
            }
        }
    }

    private static void a(String str, ExecutorService executorService) {
        b(str, executorService, 2L, TimeUnit.SECONDS);
    }

    private static void b(String str, ExecutorService executorService, long j10, TimeUnit timeUnit) {
        Runtime.getRuntime().addShutdownHook(new Thread(new b(str, executorService, j10, timeUnit), "Crashlytics Shutdown Hook for " + str));
    }

    public static ExecutorService c(String str) {
        ExecutorService e10 = e(d(str), new ThreadPoolExecutor.DiscardPolicy());
        a(str, e10);
        return e10;
    }

    public static final ThreadFactory d(String str) {
        return new a(str, new AtomicLong(1L));
    }

    private static ExecutorService e(ThreadFactory threadFactory, RejectedExecutionHandler rejectedExecutionHandler) {
        return Executors.unconfigurableExecutorService(new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), threadFactory, rejectedExecutionHandler));
    }
}
