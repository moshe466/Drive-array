package com.google.firebase.sessions;

import com.google.firebase.FirebaseApp;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.sessions.dagger.internal.Factory;
import com.google.firebase.sessions.settings.SessionsSettings;
import r2.InterfaceC0645a;
import w2.InterfaceC0768i;

/* loaded from: classes.dex */
public final class SessionFirelogPublisherImpl_Factory implements Factory<SessionFirelogPublisherImpl> {
    private final InterfaceC0645a backgroundDispatcherProvider;
    private final InterfaceC0645a eventGDTLoggerProvider;
    private final InterfaceC0645a firebaseAppProvider;
    private final InterfaceC0645a firebaseInstallationsProvider;
    private final InterfaceC0645a sessionSettingsProvider;

    public SessionFirelogPublisherImpl_Factory(InterfaceC0645a interfaceC0645a, InterfaceC0645a interfaceC0645a2, InterfaceC0645a interfaceC0645a3, InterfaceC0645a interfaceC0645a4, InterfaceC0645a interfaceC0645a5) {
        this.firebaseAppProvider = interfaceC0645a;
        this.firebaseInstallationsProvider = interfaceC0645a2;
        this.sessionSettingsProvider = interfaceC0645a3;
        this.eventGDTLoggerProvider = interfaceC0645a4;
        this.backgroundDispatcherProvider = interfaceC0645a5;
    }

    public static SessionFirelogPublisherImpl_Factory create(InterfaceC0645a interfaceC0645a, InterfaceC0645a interfaceC0645a2, InterfaceC0645a interfaceC0645a3, InterfaceC0645a interfaceC0645a4, InterfaceC0645a interfaceC0645a5) {
        return new SessionFirelogPublisherImpl_Factory(interfaceC0645a, interfaceC0645a2, interfaceC0645a3, interfaceC0645a4, interfaceC0645a5);
    }

    public static SessionFirelogPublisherImpl newInstance(FirebaseApp firebaseApp, FirebaseInstallationsApi firebaseInstallationsApi, SessionsSettings sessionsSettings, EventGDTLoggerInterface eventGDTLoggerInterface, InterfaceC0768i interfaceC0768i) {
        return new SessionFirelogPublisherImpl(firebaseApp, firebaseInstallationsApi, sessionsSettings, eventGDTLoggerInterface, interfaceC0768i);
    }

    @Override // com.google.firebase.sessions.dagger.internal.Factory, r2.InterfaceC0645a
    public SessionFirelogPublisherImpl get() {
        return newInstance((FirebaseApp) this.firebaseAppProvider.get(), (FirebaseInstallationsApi) this.firebaseInstallationsProvider.get(), (SessionsSettings) this.sessionSettingsProvider.get(), (EventGDTLoggerInterface) this.eventGDTLoggerProvider.get(), (InterfaceC0768i) this.backgroundDispatcherProvider.get());
    }
}
