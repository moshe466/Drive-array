package com.google.firebase.concurrent;

import java.util.concurrent.Callable;

/* loaded from: classes.dex */
public final /* synthetic */ class i implements Callable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4204a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Runnable f4205b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f4206c;

    public /* synthetic */ i(Runnable runnable, Object obj, int i) {
        this.f4204a = i;
        this.f4205b = runnable;
        this.f4206c = obj;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        switch (this.f4204a) {
            case 0:
                return LimitedConcurrencyExecutorService.b(this.f4205b, this.f4206c);
            default:
                return PausableExecutorServiceImpl.b(this.f4205b, this.f4206c);
        }
    }
}
