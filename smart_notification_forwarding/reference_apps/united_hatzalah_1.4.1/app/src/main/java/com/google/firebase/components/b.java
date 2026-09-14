package com.google.firebase.components;

import com.google.firebase.FirebaseApp;
import com.google.firebase.inject.Provider;
import com.google.firebase.installations.FirebaseInstallations;
import com.google.firebase.installations.local.IidStore;

/* loaded from: classes.dex */
public final /* synthetic */ class b implements Provider {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4165a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f4166b;

    public /* synthetic */ b(Object obj, int i) {
        this.f4165a = i;
        this.f4166b = obj;
    }

    @Override // com.google.firebase.inject.Provider
    public final Object get() {
        ComponentRegistrar instantiate;
        IidStore lambda$new$0;
        switch (this.f4165a) {
            case 0:
                instantiate = ComponentDiscovery.instantiate((String) this.f4166b);
                return instantiate;
            default:
                lambda$new$0 = FirebaseInstallations.lambda$new$0((FirebaseApp) this.f4166b);
                return lambda$new$0;
        }
    }
}
