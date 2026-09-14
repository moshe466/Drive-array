package com.google.firebase.sessions.settings;

import R.InterfaceC0183h;
import com.google.firebase.sessions.dagger.internal.Factory;
import r2.InterfaceC0645a;

/* loaded from: classes.dex */
public final class SettingsCache_Factory implements Factory<SettingsCache> {
    private final InterfaceC0645a dataStoreProvider;

    public SettingsCache_Factory(InterfaceC0645a interfaceC0645a) {
        this.dataStoreProvider = interfaceC0645a;
    }

    public static SettingsCache_Factory create(InterfaceC0645a interfaceC0645a) {
        return new SettingsCache_Factory(interfaceC0645a);
    }

    public static SettingsCache newInstance(InterfaceC0183h interfaceC0183h) {
        return new SettingsCache(interfaceC0183h);
    }

    @Override // com.google.firebase.sessions.dagger.internal.Factory, r2.InterfaceC0645a
    public SettingsCache get() {
        return newInstance((InterfaceC0183h) this.dataStoreProvider.get());
    }
}
