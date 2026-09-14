package com.google.firebase.messaging;

import android.content.Context;
import android.content.SharedPreferences;
import java.lang.ref.WeakReference;
import java.util.concurrent.Executor;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class c0 {

    /* renamed from: d, reason: collision with root package name */
    private static WeakReference<c0> f7418d;

    /* renamed from: a, reason: collision with root package name */
    private final SharedPreferences f7419a;

    /* renamed from: b, reason: collision with root package name */
    private a0 f7420b;

    /* renamed from: c, reason: collision with root package name */
    private final Executor f7421c;

    private c0(SharedPreferences sharedPreferences, Executor executor) {
        this.f7421c = executor;
        this.f7419a = sharedPreferences;
    }

    public static synchronized c0 a(Context context, Executor executor) {
        synchronized (c0.class) {
            WeakReference<c0> weakReference = f7418d;
            c0 c0Var = weakReference != null ? weakReference.get() : null;
            if (c0Var != null) {
                return c0Var;
            }
            c0 c0Var2 = new c0(context.getSharedPreferences("com.google.android.gms.appid", 0), executor);
            c0Var2.c();
            f7418d = new WeakReference<>(c0Var2);
            return c0Var2;
        }
    }

    private synchronized void c() {
        this.f7420b = a0.c(this.f7419a, "topic_operation_queue", ",", this.f7421c);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized b0 b() {
        return b0.a(this.f7420b.e());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized boolean d(b0 b0Var) {
        return this.f7420b.f(b0Var.e());
    }
}
