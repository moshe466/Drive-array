package com.google.firebase.sessions.settings;

import com.google.firebase.sessions.dagger.internal.Factory;
import r2.InterfaceC0645a;

/* loaded from: classes.dex */
public final class SessionsSettings_Factory implements Factory<SessionsSettings> {
    private final InterfaceC0645a localOverrideSettingsProvider;
    private final InterfaceC0645a remoteSettingsProvider;

    public SessionsSettings_Factory(InterfaceC0645a interfaceC0645a, InterfaceC0645a interfaceC0645a2) {
        this.localOverrideSettingsProvider = interfaceC0645a;
        this.remoteSettingsProvider = interfaceC0645a2;
    }

    public static SessionsSettings_Factory create(InterfaceC0645a interfaceC0645a, InterfaceC0645a interfaceC0645a2) {
        return new SessionsSettings_Factory(interfaceC0645a, interfaceC0645a2);
    }

    public static SessionsSettings newInstance(SettingsProvider settingsProvider, SettingsProvider settingsProvider2) {
        return new SessionsSettings(settingsProvider, settingsProvider2);
    }

    @Override // com.google.firebase.sessions.dagger.internal.Factory, r2.InterfaceC0645a
    public SessionsSettings get() {
        return newInstance((SettingsProvider) this.localOverrideSettingsProvider.get(), (SettingsProvider) this.remoteSettingsProvider.get());
    }
}
