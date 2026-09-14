package com.google.firebase.concurrent;

import com.google.firebase.concurrent.DelegatingScheduledFuture;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
public final /* synthetic */ class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4177a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f4178b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f4179c;

    public /* synthetic */ a(int i, Object obj, Object obj2) {
        this.f4177a = i;
        this.f4178b = obj;
        this.f4179c = obj2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f4177a) {
            case 0:
                ((CustomThreadFactory) this.f4178b).lambda$newThread$0((Runnable) this.f4179c);
                return;
            case 1:
                DelegatingScheduledExecutorService.d((Callable) this.f4178b, (DelegatingScheduledFuture.Completer) this.f4179c);
                return;
            default:
                LimitedConcurrencyExecutor.a((LimitedConcurrencyExecutor) this.f4178b, (Runnable) this.f4179c);
                return;
        }
    }
}
