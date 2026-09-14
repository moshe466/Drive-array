package com.google.firebase.concurrent;

import com.google.firebase.concurrent.DelegatingScheduledFuture;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final /* synthetic */ class e implements DelegatingScheduledFuture.Resolver {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4192a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ DelegatingScheduledExecutorService f4193b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Runnable f4194c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ long f4195d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ long f4196e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ TimeUnit f4197f;

    public /* synthetic */ e(DelegatingScheduledExecutorService delegatingScheduledExecutorService, Runnable runnable, long j2, long j3, TimeUnit timeUnit, int i) {
        this.f4192a = i;
        this.f4193b = delegatingScheduledExecutorService;
        this.f4194c = runnable;
        this.f4195d = j2;
        this.f4196e = j3;
        this.f4197f = timeUnit;
    }

    @Override // com.google.firebase.concurrent.DelegatingScheduledFuture.Resolver
    public final ScheduledFuture addCompleter(DelegatingScheduledFuture.Completer completer) {
        switch (this.f4192a) {
            case 0:
                return DelegatingScheduledExecutorService.c(this.f4193b, this.f4194c, this.f4195d, this.f4196e, this.f4197f, completer);
            default:
                return DelegatingScheduledExecutorService.b(this.f4193b, this.f4194c, this.f4195d, this.f4196e, this.f4197f, completer);
        }
    }
}
