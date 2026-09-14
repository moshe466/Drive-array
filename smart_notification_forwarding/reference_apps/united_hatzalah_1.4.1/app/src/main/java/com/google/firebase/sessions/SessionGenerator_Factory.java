package com.google.firebase.sessions;

import com.google.firebase.sessions.dagger.internal.Factory;
import r2.InterfaceC0645a;

/* loaded from: classes.dex */
public final class SessionGenerator_Factory implements Factory<SessionGenerator> {
    private final InterfaceC0645a timeProvider;
    private final InterfaceC0645a uuidGeneratorProvider;

    public SessionGenerator_Factory(InterfaceC0645a interfaceC0645a, InterfaceC0645a interfaceC0645a2) {
        this.timeProvider = interfaceC0645a;
        this.uuidGeneratorProvider = interfaceC0645a2;
    }

    public static SessionGenerator_Factory create(InterfaceC0645a interfaceC0645a, InterfaceC0645a interfaceC0645a2) {
        return new SessionGenerator_Factory(interfaceC0645a, interfaceC0645a2);
    }

    public static SessionGenerator newInstance(TimeProvider timeProvider, UuidGenerator uuidGenerator) {
        return new SessionGenerator(timeProvider, uuidGenerator);
    }

    @Override // com.google.firebase.sessions.dagger.internal.Factory, r2.InterfaceC0645a
    public SessionGenerator get() {
        return newInstance((TimeProvider) this.timeProvider.get(), (UuidGenerator) this.uuidGeneratorProvider.get());
    }
}
