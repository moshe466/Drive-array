package com.google.firebase.concurrent;

import com.google.firebase.concurrent.DelegatingScheduledFuture;

/* loaded from: classes.dex */
public final /* synthetic */ class c implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4185a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Runnable f4186b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ DelegatingScheduledFuture.Completer f4187c;

    public /* synthetic */ c(Runnable runnable, DelegatingScheduledFuture.Completer completer, int i) {
        this.f4185a = i;
        this.f4186b = runnable;
        this.f4187c = completer;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f4185a) {
            case 0:
                DelegatingScheduledExecutorService.h(this.f4186b, this.f4187c);
                return;
            case 1:
                DelegatingScheduledExecutorService.j(this.f4186b, this.f4187c);
                return;
            default:
                DelegatingScheduledExecutorService.e(this.f4186b, this.f4187c);
                return;
        }
    }
}
