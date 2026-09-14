package com.google.firebase.remoteconfig;

import R2.p;

/* loaded from: classes.dex */
public final /* synthetic */ class e implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4353a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ p f4354b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ConfigUpdate f4355c;

    public /* synthetic */ e(p pVar, ConfigUpdate configUpdate, int i) {
        this.f4353a = i;
        this.f4354b = pVar;
        this.f4355c = configUpdate;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f4353a) {
            case 0:
                RemoteConfigKt$configUpdates$1$registration$1.a(this.f4354b, this.f4355c);
                return;
            default:
                com.google.firebase.remoteconfig.ktx.RemoteConfigKt$configUpdates$1$registration$1.a(this.f4354b, this.f4355c);
                return;
        }
    }
}
