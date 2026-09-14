package com.google.firebase.heartbeatinfo;

import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.components.Qualified;
import com.google.firebase.crashlytics.CrashlyticsRegistrar;
import com.google.firebase.remoteconfig.RemoteConfigRegistrar;

/* loaded from: classes.dex */
public final /* synthetic */ class b implements ComponentFactory {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4299a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f4300b;

    public /* synthetic */ b(Object obj, int i) {
        this.f4299a = i;
        this.f4300b = obj;
    }

    @Override // com.google.firebase.components.ComponentFactory
    public final Object create(ComponentContainer componentContainer) {
        DefaultHeartBeatController lambda$component$3;
        switch (this.f4299a) {
            case 0:
                lambda$component$3 = DefaultHeartBeatController.lambda$component$3((Qualified) this.f4300b, componentContainer);
                return lambda$component$3;
            case 1:
                return RemoteConfigRegistrar.a((Qualified) this.f4300b, componentContainer);
            default:
                return CrashlyticsRegistrar.a((CrashlyticsRegistrar) this.f4300b, componentContainer);
        }
    }
}
