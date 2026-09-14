package com.google.firebase.sessions.settings;

import com.google.firebase.sessions.ApplicationInfo;
import com.google.firebase.sessions.dagger.internal.Factory;
import r2.InterfaceC0645a;
import w2.InterfaceC0768i;

/* loaded from: classes.dex */
public final class RemoteSettingsFetcher_Factory implements Factory<RemoteSettingsFetcher> {
    private final InterfaceC0645a appInfoProvider;
    private final InterfaceC0645a blockingDispatcherProvider;

    public RemoteSettingsFetcher_Factory(InterfaceC0645a interfaceC0645a, InterfaceC0645a interfaceC0645a2) {
        this.appInfoProvider = interfaceC0645a;
        this.blockingDispatcherProvider = interfaceC0645a2;
    }

    public static RemoteSettingsFetcher_Factory create(InterfaceC0645a interfaceC0645a, InterfaceC0645a interfaceC0645a2) {
        return new RemoteSettingsFetcher_Factory(interfaceC0645a, interfaceC0645a2);
    }

    public static RemoteSettingsFetcher newInstance(ApplicationInfo applicationInfo, InterfaceC0768i interfaceC0768i) {
        return new RemoteSettingsFetcher(applicationInfo, interfaceC0768i);
    }

    @Override // com.google.firebase.sessions.dagger.internal.Factory, r2.InterfaceC0645a
    public RemoteSettingsFetcher get() {
        return newInstance((ApplicationInfo) this.appInfoProvider.get(), (InterfaceC0768i) this.blockingDispatcherProvider.get());
    }
}
