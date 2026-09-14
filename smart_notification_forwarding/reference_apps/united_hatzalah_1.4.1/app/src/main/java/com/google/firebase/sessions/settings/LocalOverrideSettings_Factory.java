package com.google.firebase.sessions.settings;

import android.content.Context;
import com.google.firebase.sessions.dagger.internal.Factory;
import r2.InterfaceC0645a;

/* loaded from: classes.dex */
public final class LocalOverrideSettings_Factory implements Factory<LocalOverrideSettings> {
    private final InterfaceC0645a appContextProvider;

    public LocalOverrideSettings_Factory(InterfaceC0645a interfaceC0645a) {
        this.appContextProvider = interfaceC0645a;
    }

    public static LocalOverrideSettings_Factory create(InterfaceC0645a interfaceC0645a) {
        return new LocalOverrideSettings_Factory(interfaceC0645a);
    }

    public static LocalOverrideSettings newInstance(Context context) {
        return new LocalOverrideSettings(context);
    }

    @Override // com.google.firebase.sessions.dagger.internal.Factory, r2.InterfaceC0645a
    public LocalOverrideSettings get() {
        return newInstance((Context) this.appContextProvider.get());
    }
}
