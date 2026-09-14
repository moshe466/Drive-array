package com.google.firebase.crashlytics.internal.common;

import java.lang.Thread;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
class q implements Thread.UncaughtExceptionHandler {

    /* renamed from: a, reason: collision with root package name */
    private final a f7227a;

    /* renamed from: b, reason: collision with root package name */
    private final f4.e f7228b;

    /* renamed from: c, reason: collision with root package name */
    private final Thread.UncaughtExceptionHandler f7229c;

    /* renamed from: d, reason: collision with root package name */
    private final AtomicBoolean f7230d = new AtomicBoolean(false);

    /* loaded from: classes.dex */
    interface a {
        void a(f4.e eVar, Thread thread, Throwable th);
    }

    public q(a aVar, f4.e eVar, Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.f7227a = aVar;
        this.f7228b = eVar;
        this.f7229c = uncaughtExceptionHandler;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a() {
        return this.f7230d.get();
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        s3.b f10;
        String str;
        this.f7230d.set(true);
        try {
            try {
            } catch (Exception e10) {
                s3.b.f().e("An error occurred in the uncaught exception handler", e10);
            }
            if (thread == null) {
                f10 = s3.b.f();
                str = "Could not handle uncaught exception; null thread";
            } else {
                if (th != null) {
                    this.f7227a.a(this.f7228b, thread, th);
                    s3.b.f().b("Crashlytics completed exception processing. Invoking default exception handler.");
                    this.f7229c.uncaughtException(thread, th);
                    this.f7230d.set(false);
                }
                f10 = s3.b.f();
                str = "Could not handle uncaught exception; null throwable";
            }
            f10.d(str);
            s3.b.f().b("Crashlytics completed exception processing. Invoking default exception handler.");
            this.f7229c.uncaughtException(thread, th);
            this.f7230d.set(false);
        } catch (Throwable th2) {
            s3.b.f().b("Crashlytics completed exception processing. Invoking default exception handler.");
            this.f7229c.uncaughtException(thread, th);
            this.f7230d.set(false);
            throw th2;
        }
    }
}
