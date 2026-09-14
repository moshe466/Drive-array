package com.google.firebase.concurrent;

import com.google.firebase.concurrent.DelegatingScheduledFuture;
import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final /* synthetic */ class b implements DelegatingScheduledFuture.Resolver {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4180a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ DelegatingScheduledExecutorService f4181b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f4182c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ TimeUnit f4183d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Object f4184e;

    public /* synthetic */ b(DelegatingScheduledExecutorService delegatingScheduledExecutorService, Object obj, long j2, TimeUnit timeUnit, int i) {
        this.f4180a = i;
        this.f4181b = delegatingScheduledExecutorService;
        this.f4184e = obj;
        this.f4182c = j2;
        this.f4183d = timeUnit;
    }

    @Override // com.google.firebase.concurrent.DelegatingScheduledFuture.Resolver
    public final ScheduledFuture addCompleter(DelegatingScheduledFuture.Completer completer) {
        switch (this.f4180a) {
            case 0:
                return DelegatingScheduledExecutorService.l(this.f4181b, (Runnable) this.f4184e, this.f4182c, this.f4183d, completer);
            default:
                return DelegatingScheduledExecutorService.a(this.f4181b, (Callable) this.f4184e, this.f4182c, this.f4183d, completer);
        }
    }
}
