package com.google.firebase.sessions;

import android.content.Context;
import com.google.firebase.sessions.dagger.internal.Factory;
import r2.InterfaceC0645a;

/* loaded from: classes.dex */
public final class SessionLifecycleServiceBinderImpl_Factory implements Factory<SessionLifecycleServiceBinderImpl> {
    private final InterfaceC0645a appContextProvider;

    public SessionLifecycleServiceBinderImpl_Factory(InterfaceC0645a interfaceC0645a) {
        this.appContextProvider = interfaceC0645a;
    }

    public static SessionLifecycleServiceBinderImpl_Factory create(InterfaceC0645a interfaceC0645a) {
        return new SessionLifecycleServiceBinderImpl_Factory(interfaceC0645a);
    }

    public static SessionLifecycleServiceBinderImpl newInstance(Context context) {
        return new SessionLifecycleServiceBinderImpl(context);
    }

    @Override // com.google.firebase.sessions.dagger.internal.Factory, r2.InterfaceC0645a
    public SessionLifecycleServiceBinderImpl get() {
        return newInstance((Context) this.appContextProvider.get());
    }
}
