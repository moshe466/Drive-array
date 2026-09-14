package com.google.firebase.iid;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    private static final Executor f7296a = g.f7295f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Executor a() {
        return f7296a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ExecutorService b() {
        return new ThreadPoolExecutor(0, 1, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new h2.b("firebase-iid-executor"));
    }
}
