package com.google.firebase.components;

import com.google.firebase.components.ComponentRuntime;
import com.google.firebase.inject.Provider;

/* loaded from: classes.dex */
public final /* synthetic */ class c implements Provider {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4167a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ComponentRegistrar f4168b;

    public /* synthetic */ c(ComponentRegistrar componentRegistrar, int i) {
        this.f4167a = i;
        this.f4168b = componentRegistrar;
    }

    @Override // com.google.firebase.inject.Provider
    public final Object get() {
        switch (this.f4167a) {
            case 0:
                return ComponentRuntime.c(this.f4168b);
            default:
                return ComponentRuntime.Builder.a(this.f4168b);
        }
    }
}
