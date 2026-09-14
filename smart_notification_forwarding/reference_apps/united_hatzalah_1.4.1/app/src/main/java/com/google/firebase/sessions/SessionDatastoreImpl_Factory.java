package com.google.firebase.sessions;

import R.InterfaceC0183h;
import com.google.firebase.sessions.dagger.internal.Factory;
import r2.InterfaceC0645a;
import w2.InterfaceC0768i;

/* loaded from: classes.dex */
public final class SessionDatastoreImpl_Factory implements Factory<SessionDatastoreImpl> {
    private final InterfaceC0645a backgroundDispatcherProvider;
    private final InterfaceC0645a dataStoreProvider;

    public SessionDatastoreImpl_Factory(InterfaceC0645a interfaceC0645a, InterfaceC0645a interfaceC0645a2) {
        this.backgroundDispatcherProvider = interfaceC0645a;
        this.dataStoreProvider = interfaceC0645a2;
    }

    public static SessionDatastoreImpl_Factory create(InterfaceC0645a interfaceC0645a, InterfaceC0645a interfaceC0645a2) {
        return new SessionDatastoreImpl_Factory(interfaceC0645a, interfaceC0645a2);
    }

    public static SessionDatastoreImpl newInstance(InterfaceC0768i interfaceC0768i, InterfaceC0183h interfaceC0183h) {
        return new SessionDatastoreImpl(interfaceC0768i, interfaceC0183h);
    }

    @Override // com.google.firebase.sessions.dagger.internal.Factory, r2.InterfaceC0645a
    public SessionDatastoreImpl get() {
        return newInstance((InterfaceC0768i) this.backgroundDispatcherProvider.get(), (InterfaceC0183h) this.dataStoreProvider.get());
    }
}
