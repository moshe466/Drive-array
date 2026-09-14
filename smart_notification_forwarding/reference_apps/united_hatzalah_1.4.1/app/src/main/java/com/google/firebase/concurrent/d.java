package com.google.firebase.concurrent;

import com.google.firebase.concurrent.DelegatingScheduledFuture;

/* loaded from: classes.dex */
public final /* synthetic */ class d implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4188a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ DelegatingScheduledExecutorService f4189b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Runnable f4190c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ DelegatingScheduledFuture.Completer f4191d;

    public /* synthetic */ d(DelegatingScheduledExecutorService delegatingScheduledExecutorService, Runnable runnable, DelegatingScheduledFuture.Completer completer, int i) {
        this.f4188a = i;
        this.f4189b = delegatingScheduledExecutorService;
        this.f4190c = runnable;
        this.f4191d = completer;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f4188a) {
            case 0:
                DelegatingScheduledExecutorService.k(this.f4189b, this.f4190c, this.f4191d);
                return;
            case 1:
                DelegatingScheduledExecutorService.f(this.f4189b, this.f4190c, this.f4191d);
                return;
            default:
                DelegatingScheduledExecutorService.i(this.f4189b, this.f4190c, this.f4191d);
                return;
        }
    }
}
