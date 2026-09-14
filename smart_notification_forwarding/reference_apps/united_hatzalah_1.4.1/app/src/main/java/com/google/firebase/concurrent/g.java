package com.google.firebase.concurrent;

import com.google.firebase.inject.Provider;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.remoteconfig.RemoteConfigComponent;

/* loaded from: classes.dex */
public final /* synthetic */ class g implements Provider {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4201a;

    public /* synthetic */ g(int i) {
        this.f4201a = i;
    }

    @Override // com.google.firebase.inject.Provider
    public final Object get() {
        switch (this.f4201a) {
            case 0:
                return ExecutorsRegistrar.f();
            case 1:
                return ExecutorsRegistrar.c();
            case 2:
                return ExecutorsRegistrar.h();
            case 3:
                return ExecutorsRegistrar.b();
            case 4:
                return FirebaseMessaging.k();
            case 5:
                return FirebaseMessaging.h();
            default:
                return RemoteConfigComponent.a();
        }
    }
}
