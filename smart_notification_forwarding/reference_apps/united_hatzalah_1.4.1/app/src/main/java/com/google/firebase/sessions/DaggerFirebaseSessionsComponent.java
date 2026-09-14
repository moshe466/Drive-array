package com.google.firebase.sessions;

import android.content.Context;
import com.google.firebase.FirebaseApp;
import com.google.firebase.inject.Provider;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.sessions.FirebaseSessionsComponent;
import com.google.firebase.sessions.dagger.internal.DoubleCheck;
import com.google.firebase.sessions.dagger.internal.Factory;
import com.google.firebase.sessions.dagger.internal.InstanceFactory;
import com.google.firebase.sessions.dagger.internal.Preconditions;
import com.google.firebase.sessions.settings.LocalOverrideSettings_Factory;
import com.google.firebase.sessions.settings.RemoteSettingsFetcher_Factory;
import com.google.firebase.sessions.settings.RemoteSettings_Factory;
import com.google.firebase.sessions.settings.SessionsSettings;
import com.google.firebase.sessions.settings.SessionsSettings_Factory;
import com.google.firebase.sessions.settings.SettingsCache_Factory;
import q1.g;
import r2.InterfaceC0645a;
import w2.InterfaceC0768i;

/* loaded from: classes.dex */
public final class DaggerFirebaseSessionsComponent {

    /* loaded from: classes.dex */
    public static final class Builder implements FirebaseSessionsComponent.Builder {
        private Context appContext;
        private InterfaceC0768i backgroundDispatcher;
        private InterfaceC0768i blockingDispatcher;
        private FirebaseApp firebaseApp;
        private FirebaseInstallationsApi firebaseInstallationsApi;
        private Provider<g> transportFactoryProvider;

        private Builder() {
        }

        @Override // com.google.firebase.sessions.FirebaseSessionsComponent.Builder
        public FirebaseSessionsComponent build() {
            Preconditions.checkBuilderRequirement(this.appContext, Context.class);
            Preconditions.checkBuilderRequirement(this.backgroundDispatcher, InterfaceC0768i.class);
            Preconditions.checkBuilderRequirement(this.blockingDispatcher, InterfaceC0768i.class);
            Preconditions.checkBuilderRequirement(this.firebaseApp, FirebaseApp.class);
            Preconditions.checkBuilderRequirement(this.firebaseInstallationsApi, FirebaseInstallationsApi.class);
            Preconditions.checkBuilderRequirement(this.transportFactoryProvider, Provider.class);
            return new FirebaseSessionsComponentImpl(this.appContext, this.backgroundDispatcher, this.blockingDispatcher, this.firebaseApp, this.firebaseInstallationsApi, this.transportFactoryProvider);
        }

        @Override // com.google.firebase.sessions.FirebaseSessionsComponent.Builder
        public /* bridge */ /* synthetic */ FirebaseSessionsComponent.Builder transportFactoryProvider(Provider provider) {
            return transportFactoryProvider((Provider<g>) provider);
        }

        @Override // com.google.firebase.sessions.FirebaseSessionsComponent.Builder
        public Builder appContext(Context context) {
            this.appContext = (Context) Preconditions.checkNotNull(context);
            return this;
        }

        @Override // com.google.firebase.sessions.FirebaseSessionsComponent.Builder
        public Builder backgroundDispatcher(InterfaceC0768i interfaceC0768i) {
            this.backgroundDispatcher = (InterfaceC0768i) Preconditions.checkNotNull(interfaceC0768i);
            return this;
        }

        @Override // com.google.firebase.sessions.FirebaseSessionsComponent.Builder
        public Builder blockingDispatcher(InterfaceC0768i interfaceC0768i) {
            this.blockingDispatcher = (InterfaceC0768i) Preconditions.checkNotNull(interfaceC0768i);
            return this;
        }

        @Override // com.google.firebase.sessions.FirebaseSessionsComponent.Builder
        public Builder firebaseApp(FirebaseApp firebaseApp) {
            this.firebaseApp = (FirebaseApp) Preconditions.checkNotNull(firebaseApp);
            return this;
        }

        @Override // com.google.firebase.sessions.FirebaseSessionsComponent.Builder
        public Builder firebaseInstallationsApi(FirebaseInstallationsApi firebaseInstallationsApi) {
            this.firebaseInstallationsApi = (FirebaseInstallationsApi) Preconditions.checkNotNull(firebaseInstallationsApi);
            return this;
        }

        @Override // com.google.firebase.sessions.FirebaseSessionsComponent.Builder
        public Builder transportFactoryProvider(Provider<g> provider) {
            this.transportFactoryProvider = (Provider) Preconditions.checkNotNull(provider);
            return this;
        }
    }

    /* loaded from: classes.dex */
    public static final class FirebaseSessionsComponentImpl implements FirebaseSessionsComponent {
        private InterfaceC0645a appContextProvider;
        private InterfaceC0645a applicationInfoProvider;
        private InterfaceC0645a backgroundDispatcherProvider;
        private InterfaceC0645a eventGDTLoggerProvider;
        private InterfaceC0645a firebaseAppProvider;
        private InterfaceC0645a firebaseInstallationsApiProvider;
        private final FirebaseSessionsComponentImpl firebaseSessionsComponentImpl;
        private InterfaceC0645a firebaseSessionsProvider;
        private InterfaceC0645a localOverrideSettingsProvider;
        private InterfaceC0645a remoteSettingsFetcherProvider;
        private InterfaceC0645a remoteSettingsProvider;
        private InterfaceC0645a sessionConfigsDataStoreProvider;
        private InterfaceC0645a sessionDatastoreImplProvider;
        private InterfaceC0645a sessionDetailsDataStoreProvider;
        private InterfaceC0645a sessionFirelogPublisherImplProvider;
        private InterfaceC0645a sessionGeneratorProvider;
        private InterfaceC0645a sessionLifecycleServiceBinderImplProvider;
        private InterfaceC0645a sessionsSettingsProvider;
        private InterfaceC0645a settingsCacheProvider;
        private InterfaceC0645a timeProvider;
        private InterfaceC0645a transportFactoryProvider;
        private InterfaceC0645a uuidGeneratorProvider;

        private void initialize(Context context, InterfaceC0768i interfaceC0768i, InterfaceC0768i interfaceC0768i2, FirebaseApp firebaseApp, FirebaseInstallationsApi firebaseInstallationsApi, Provider<g> provider) {
            this.firebaseAppProvider = InstanceFactory.create(firebaseApp);
            Factory create = InstanceFactory.create(context);
            this.appContextProvider = create;
            this.localOverrideSettingsProvider = DoubleCheck.provider(LocalOverrideSettings_Factory.create(create));
            this.backgroundDispatcherProvider = InstanceFactory.create(interfaceC0768i);
            this.firebaseInstallationsApiProvider = InstanceFactory.create(firebaseInstallationsApi);
            InterfaceC0645a provider2 = DoubleCheck.provider(FirebaseSessionsComponent_MainModule_Companion_ApplicationInfoFactory.create(this.firebaseAppProvider));
            this.applicationInfoProvider = provider2;
            this.remoteSettingsFetcherProvider = DoubleCheck.provider(RemoteSettingsFetcher_Factory.create(provider2, this.backgroundDispatcherProvider));
            InterfaceC0645a provider3 = DoubleCheck.provider(FirebaseSessionsComponent_MainModule_Companion_SessionConfigsDataStoreFactory.create(this.appContextProvider));
            this.sessionConfigsDataStoreProvider = provider3;
            InterfaceC0645a provider4 = DoubleCheck.provider(SettingsCache_Factory.create(provider3));
            this.settingsCacheProvider = provider4;
            InterfaceC0645a provider5 = DoubleCheck.provider(RemoteSettings_Factory.create(this.backgroundDispatcherProvider, this.firebaseInstallationsApiProvider, this.applicationInfoProvider, this.remoteSettingsFetcherProvider, provider4));
            this.remoteSettingsProvider = provider5;
            this.sessionsSettingsProvider = DoubleCheck.provider(SessionsSettings_Factory.create(this.localOverrideSettingsProvider, provider5));
            InterfaceC0645a provider6 = DoubleCheck.provider(SessionLifecycleServiceBinderImpl_Factory.create(this.appContextProvider));
            this.sessionLifecycleServiceBinderImplProvider = provider6;
            this.firebaseSessionsProvider = DoubleCheck.provider(FirebaseSessions_Factory.create(this.firebaseAppProvider, this.sessionsSettingsProvider, this.backgroundDispatcherProvider, provider6));
            InterfaceC0645a provider7 = DoubleCheck.provider(FirebaseSessionsComponent_MainModule_Companion_SessionDetailsDataStoreFactory.create(this.appContextProvider));
            this.sessionDetailsDataStoreProvider = provider7;
            this.sessionDatastoreImplProvider = DoubleCheck.provider(SessionDatastoreImpl_Factory.create(this.backgroundDispatcherProvider, provider7));
            Factory create2 = InstanceFactory.create(provider);
            this.transportFactoryProvider = create2;
            InterfaceC0645a provider8 = DoubleCheck.provider(EventGDTLogger_Factory.create(create2));
            this.eventGDTLoggerProvider = provider8;
            this.sessionFirelogPublisherImplProvider = DoubleCheck.provider(SessionFirelogPublisherImpl_Factory.create(this.firebaseAppProvider, this.firebaseInstallationsApiProvider, this.sessionsSettingsProvider, provider8, this.backgroundDispatcherProvider));
            this.timeProvider = DoubleCheck.provider(FirebaseSessionsComponent_MainModule_Companion_TimeProviderFactory.create());
            InterfaceC0645a provider9 = DoubleCheck.provider(FirebaseSessionsComponent_MainModule_Companion_UuidGeneratorFactory.create());
            this.uuidGeneratorProvider = provider9;
            this.sessionGeneratorProvider = DoubleCheck.provider(SessionGenerator_Factory.create(this.timeProvider, provider9));
        }

        @Override // com.google.firebase.sessions.FirebaseSessionsComponent
        public FirebaseSessions getFirebaseSessions() {
            return (FirebaseSessions) this.firebaseSessionsProvider.get();
        }

        @Override // com.google.firebase.sessions.FirebaseSessionsComponent
        public SessionDatastore getSessionDatastore() {
            return (SessionDatastore) this.sessionDatastoreImplProvider.get();
        }

        @Override // com.google.firebase.sessions.FirebaseSessionsComponent
        public SessionFirelogPublisher getSessionFirelogPublisher() {
            return (SessionFirelogPublisher) this.sessionFirelogPublisherImplProvider.get();
        }

        @Override // com.google.firebase.sessions.FirebaseSessionsComponent
        public SessionGenerator getSessionGenerator() {
            return (SessionGenerator) this.sessionGeneratorProvider.get();
        }

        @Override // com.google.firebase.sessions.FirebaseSessionsComponent
        public SessionsSettings getSessionsSettings() {
            return (SessionsSettings) this.sessionsSettingsProvider.get();
        }

        private FirebaseSessionsComponentImpl(Context context, InterfaceC0768i interfaceC0768i, InterfaceC0768i interfaceC0768i2, FirebaseApp firebaseApp, FirebaseInstallationsApi firebaseInstallationsApi, Provider<g> provider) {
            this.firebaseSessionsComponentImpl = this;
            initialize(context, interfaceC0768i, interfaceC0768i2, firebaseApp, firebaseInstallationsApi, provider);
        }
    }

    private DaggerFirebaseSessionsComponent() {
    }

    public static FirebaseSessionsComponent.Builder builder() {
        return new Builder();
    }
}
