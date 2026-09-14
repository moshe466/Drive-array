package com.google.firebase.messaging;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
class h {
    private static Executor a(String str) {
        return new ThreadPoolExecutor(0, 1, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new h2.b("Firebase-Messaging-Trigger-Topics-Io"));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ScheduledExecutorService b() {
        return new ScheduledThreadPoolExecutor(1, new h2.b("Firebase-Messaging-Init"));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ExecutorService c() {
        p2.d.a();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new h2.b("Firebase-Messaging-Intent-Handle"));
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return Executors.unconfigurableExecutorService(threadPoolExecutor);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ExecutorService d() {
        return Executors.newSingleThreadExecutor(new h2.b("Firebase-Messaging-Network-Io"));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ScheduledExecutorService e() {
        return new ScheduledThreadPoolExecutor(1, new h2.b("Firebase-Messaging-Topics-Io"));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Executor f() {
        return a("Firebase-Messaging-Trigger-Topics-Io");
    }
}
