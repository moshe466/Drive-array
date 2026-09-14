package com.google.firebase.sessions;

import com.google.firebase.inject.Provider;
import com.google.firebase.sessions.dagger.internal.Factory;
import q1.g;
import r2.InterfaceC0645a;

/* loaded from: classes.dex */
public final class EventGDTLogger_Factory implements Factory<EventGDTLogger> {
    private final InterfaceC0645a transportFactoryProvider;

    public EventGDTLogger_Factory(InterfaceC0645a interfaceC0645a) {
        this.transportFactoryProvider = interfaceC0645a;
    }

    public static EventGDTLogger_Factory create(InterfaceC0645a interfaceC0645a) {
        return new EventGDTLogger_Factory(interfaceC0645a);
    }

    public static EventGDTLogger newInstance(Provider<g> provider) {
        return new EventGDTLogger(provider);
    }

    @Override // com.google.firebase.sessions.dagger.internal.Factory, r2.InterfaceC0645a
    public EventGDTLogger get() {
        return newInstance((Provider) this.transportFactoryProvider.get());
    }
}
