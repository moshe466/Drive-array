package com.google.firebase.heartbeatinfo;

import java.util.concurrent.Callable;

/* loaded from: classes.dex */
public final /* synthetic */ class a implements Callable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4297a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ DefaultHeartBeatController f4298b;

    public /* synthetic */ a(DefaultHeartBeatController defaultHeartBeatController, int i) {
        this.f4297a = i;
        this.f4298b = defaultHeartBeatController;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        switch (this.f4297a) {
            case 0:
                return DefaultHeartBeatController.a(this.f4298b);
            default:
                return DefaultHeartBeatController.d(this.f4298b);
        }
    }
}
