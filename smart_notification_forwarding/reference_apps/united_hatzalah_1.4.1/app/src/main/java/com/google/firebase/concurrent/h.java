package com.google.firebase.concurrent;

import java.util.concurrent.Callable;

/* loaded from: classes.dex */
public final /* synthetic */ class h implements Callable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4202a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Runnable f4203b;

    public /* synthetic */ h(Runnable runnable, int i) {
        this.f4202a = i;
        this.f4203b = runnable;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        switch (this.f4202a) {
            case 0:
                return LimitedConcurrencyExecutorService.c(this.f4203b);
            default:
                return PausableExecutorServiceImpl.a(this.f4203b);
        }
    }
}
