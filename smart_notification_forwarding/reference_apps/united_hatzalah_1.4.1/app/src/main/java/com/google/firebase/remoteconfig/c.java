package com.google.firebase.remoteconfig;

import java.util.concurrent.Callable;

/* loaded from: classes.dex */
public final /* synthetic */ class c implements Callable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4350a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ FirebaseRemoteConfig f4351b;

    public /* synthetic */ c(FirebaseRemoteConfig firebaseRemoteConfig, int i) {
        this.f4350a = i;
        this.f4351b = firebaseRemoteConfig;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        switch (this.f4350a) {
            case 0:
                return FirebaseRemoteConfig.j(this.f4351b);
            default:
                return this.f4351b.getInfo();
        }
    }
}
