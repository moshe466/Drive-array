package com.google.firebase.sessions.settings;

import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.sessions.ApplicationInfo;
import com.google.firebase.sessions.dagger.Lazy;
import com.google.firebase.sessions.dagger.internal.DoubleCheck;
import com.google.firebase.sessions.dagger.internal.Factory;
import r2.InterfaceC0645a;
import w2.InterfaceC0768i;

/* loaded from: classes.dex */
public final class RemoteSettings_Factory implements Factory<RemoteSettings> {
    private final InterfaceC0645a appInfoProvider;
    private final InterfaceC0645a backgroundDispatcherProvider;
    private final InterfaceC0645a configsFetcherProvider;
    private final InterfaceC0645a firebaseInstallationsApiProvider;
    private final InterfaceC0645a settingsCacheProvider;

    public RemoteSettings_Factory(InterfaceC0645a interfaceC0645a, InterfaceC0645a interfaceC0645a2, InterfaceC0645a interfaceC0645a3, InterfaceC0645a interfaceC0645a4, InterfaceC0645a interfaceC0645a5) {
        this.backgroundDispatcherProvider = interfaceC0645a;
        this.firebaseInstallationsApiProvider = interfaceC0645a2;
        this.appInfoProvider = interfaceC0645a3;
        this.configsFetcherProvider = interfaceC0645a4;
        this.settingsCacheProvider = interfaceC0645a5;
    }

    public static RemoteSettings_Factory create(InterfaceC0645a interfaceC0645a, InterfaceC0645a interfaceC0645a2, InterfaceC0645a interfaceC0645a3, InterfaceC0645a interfaceC0645a4, InterfaceC0645a interfaceC0645a5) {
        return new RemoteSettings_Factory(interfaceC0645a, interfaceC0645a2, interfaceC0645a3, interfaceC0645a4, interfaceC0645a5);
    }

    public static RemoteSettings newInstance(InterfaceC0768i interfaceC0768i, FirebaseInstallationsApi firebaseInstallationsApi, ApplicationInfo applicationInfo, CrashlyticsSettingsFetcher crashlyticsSettingsFetcher, Lazy<SettingsCache> lazy) {
        return new RemoteSettings(interfaceC0768i, firebaseInstallationsApi, applicationInfo, crashlyticsSettingsFetcher, lazy);
    }

    @Override // com.google.firebase.sessions.dagger.internal.Factory, r2.InterfaceC0645a
    public RemoteSettings get() {
        return newInstance((InterfaceC0768i) this.backgroundDispatcherProvider.get(), (FirebaseInstallationsApi) this.firebaseInstallationsApiProvider.get(), (ApplicationInfo) this.appInfoProvider.get(), (CrashlyticsSettingsFetcher) this.configsFetcherProvider.get(), DoubleCheck.lazy(this.settingsCacheProvider));
    }
}
