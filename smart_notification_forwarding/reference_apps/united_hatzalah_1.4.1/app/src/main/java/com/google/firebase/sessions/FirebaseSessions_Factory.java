package com.google.firebase.sessions;

import com.google.firebase.FirebaseApp;
import com.google.firebase.sessions.dagger.internal.Factory;
import com.google.firebase.sessions.settings.SessionsSettings;
import r2.InterfaceC0645a;
import w2.InterfaceC0768i;

/* loaded from: classes.dex */
public final class FirebaseSessions_Factory implements Factory<FirebaseSessions> {
    private final InterfaceC0645a backgroundDispatcherProvider;
    private final InterfaceC0645a firebaseAppProvider;
    private final InterfaceC0645a lifecycleServiceBinderProvider;
    private final InterfaceC0645a settingsProvider;

    public FirebaseSessions_Factory(InterfaceC0645a interfaceC0645a, InterfaceC0645a interfaceC0645a2, InterfaceC0645a interfaceC0645a3, InterfaceC0645a interfaceC0645a4) {
        this.firebaseAppProvider = interfaceC0645a;
        this.settingsProvider = interfaceC0645a2;
        this.backgroundDispatcherProvider = interfaceC0645a3;
        this.lifecycleServiceBinderProvider = interfaceC0645a4;
    }

    public static FirebaseSessions_Factory create(InterfaceC0645a interfaceC0645a, InterfaceC0645a interfaceC0645a2, InterfaceC0645a interfaceC0645a3, InterfaceC0645a interfaceC0645a4) {
        return new FirebaseSessions_Factory(interfaceC0645a, interfaceC0645a2, interfaceC0645a3, interfaceC0645a4);
    }

    public static FirebaseSessions newInstance(FirebaseApp firebaseApp, SessionsSettings sessionsSettings, InterfaceC0768i interfaceC0768i, SessionLifecycleServiceBinder sessionLifecycleServiceBinder) {
        return new FirebaseSessions(firebaseApp, sessionsSettings, interfaceC0768i, sessionLifecycleServiceBinder);
    }

    @Override // com.google.firebase.sessions.dagger.internal.Factory, r2.InterfaceC0645a
    public FirebaseSessions get() {
        return newInstance((FirebaseApp) this.firebaseAppProvider.get(), (SessionsSettings) this.settingsProvider.get(), (InterfaceC0768i) this.backgroundDispatcherProvider.get(), (SessionLifecycleServiceBinder) this.lifecycleServiceBinderProvider.get());
    }
}
