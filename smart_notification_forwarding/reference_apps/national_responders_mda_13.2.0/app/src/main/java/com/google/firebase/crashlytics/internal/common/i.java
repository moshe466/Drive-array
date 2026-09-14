package com.google.firebase.crashlytics.internal.common;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i {

    /* renamed from: a, reason: collision with root package name */
    private final Executor f7096a;

    /* renamed from: b, reason: collision with root package name */
    private z2.l<Void> f7097b = z2.o.e(null);

    /* renamed from: c, reason: collision with root package name */
    private final Object f7098c = new Object();

    /* renamed from: d, reason: collision with root package name */
    private ThreadLocal<Boolean> f7099d = new ThreadLocal<>();

    /* loaded from: classes.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            i.this.f7099d.set(Boolean.TRUE);
        }
    }

    /* loaded from: classes.dex */
    class b implements Callable<Void> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Runnable f7101a;

        b(i iVar, Runnable runnable) {
            this.f7101a = runnable;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void call() {
            this.f7101a.run();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [T] */
    /* loaded from: classes.dex */
    public class c<T> implements z2.c<Void, T> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Callable f7102a;

        c(i iVar, Callable callable) {
            this.f7102a = callable;
        }

        @Override // z2.c
        public T a(z2.l<Void> lVar) {
            return (T) this.f7102a.call();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [T] */
    /* loaded from: classes.dex */
    public class d<T> implements z2.c<T, Void> {
        d(i iVar) {
        }

        @Override // z2.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Void a(z2.l<T> lVar) {
            return null;
        }
    }

    public i(Executor executor) {
        this.f7096a = executor;
        executor.execute(new a());
    }

    private <T> z2.l<Void> d(z2.l<T> lVar) {
        return lVar.h(this.f7096a, new d(this));
    }

    private boolean e() {
        return Boolean.TRUE.equals(this.f7099d.get());
    }

    private <T> z2.c<Void, T> f(Callable<T> callable) {
        return new c(this, callable);
    }

    public void b() {
        if (!e()) {
            throw new IllegalStateException("Not running on background worker thread as intended.");
        }
    }

    public Executor c() {
        return this.f7096a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public z2.l<Void> g(Runnable runnable) {
        return h(new b(this, runnable));
    }

    public <T> z2.l<T> h(Callable<T> callable) {
        z2.l<T> h10;
        synchronized (this.f7098c) {
            h10 = this.f7097b.h(this.f7096a, f(callable));
            this.f7097b = d(h10);
        }
        return h10;
    }

    public <T> z2.l<T> i(Callable<z2.l<T>> callable) {
        z2.l<T> j10;
        synchronized (this.f7098c) {
            j10 = this.f7097b.j(this.f7096a, f(callable));
            this.f7097b = d(j10);
        }
        return j10;
    }
}
