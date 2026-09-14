package com.google.firebase.sessions;

import R.InterfaceC0183h;
import U.e;
import android.content.Context;
import com.google.firebase.FirebaseApp;
import com.google.firebase.annotations.concurrent.Background;
import com.google.firebase.annotations.concurrent.Blocking;
import com.google.firebase.inject.Provider;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.sessions.dagger.Binds;
import com.google.firebase.sessions.dagger.BindsInstance;
import com.google.firebase.sessions.dagger.Component;
import com.google.firebase.sessions.dagger.Module;
import com.google.firebase.sessions.dagger.Provides;
import com.google.firebase.sessions.settings.CrashlyticsSettingsFetcher;
import com.google.firebase.sessions.settings.LocalOverrideSettings;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.google.firebase.sessions.settings.RemoteSettingsFetcher;
import com.google.firebase.sessions.settings.SessionsSettings;
import com.google.firebase.sessions.settings.SettingsProvider;
import kotlin.jvm.internal.j;
import q1.g;
import w2.InterfaceC0768i;

@Component(modules = {MainModule.class})
/* loaded from: classes.dex */
public interface FirebaseSessionsComponent {

    @Component.Builder
    /* loaded from: classes.dex */
    public interface Builder {
        @BindsInstance
        Builder appContext(Context context);

        @BindsInstance
        Builder backgroundDispatcher(@Background InterfaceC0768i interfaceC0768i);

        @BindsInstance
        Builder blockingDispatcher(@Blocking InterfaceC0768i interfaceC0768i);

        FirebaseSessionsComponent build();

        @BindsInstance
        Builder firebaseApp(FirebaseApp firebaseApp);

        @BindsInstance
        Builder firebaseInstallationsApi(FirebaseInstallationsApi firebaseInstallationsApi);

        @BindsInstance
        Builder transportFactoryProvider(Provider<g> provider);
    }

    @Module
    /* loaded from: classes.dex */
    public interface MainModule {
        public static final Companion Companion = Companion.$$INSTANCE;

        /* loaded from: classes.dex */
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();
            private static final String TAG = "FirebaseSessions";

            private Companion() {
            }

            @Provides
            public final ApplicationInfo applicationInfo(FirebaseApp firebaseApp) {
                j.e(firebaseApp, "firebaseApp");
                return SessionEvents.INSTANCE.getApplicationInfo(firebaseApp);
            }

            @SessionConfigsDataStore
            @Provides
            public final InterfaceC0183h sessionConfigsDataStore(Context appContext) {
                j.e(appContext, "appContext");
                return e.a(new S.a(FirebaseSessionsComponent$MainModule$Companion$sessionConfigsDataStore$1.INSTANCE), new FirebaseSessionsComponent$MainModule$Companion$sessionConfigsDataStore$2(appContext));
            }

            @SessionDetailsDataStore
            @Provides
            public final InterfaceC0183h sessionDetailsDataStore(Context appContext) {
                j.e(appContext, "appContext");
                return e.a(new S.a(FirebaseSessionsComponent$MainModule$Companion$sessionDetailsDataStore$1.INSTANCE), new FirebaseSessionsComponent$MainModule$Companion$sessionDetailsDataStore$2(appContext));
            }

            @Provides
            public final TimeProvider timeProvider() {
                return TimeProviderImpl.INSTANCE;
            }

            @Provides
            public final UuidGenerator uuidGenerator() {
                return UuidGeneratorImpl.INSTANCE;
            }
        }

        @Binds
        CrashlyticsSettingsFetcher crashlyticsSettingsFetcher(RemoteSettingsFetcher remoteSettingsFetcher);

        @Binds
        EventGDTLoggerInterface eventGDTLoggerInterface(EventGDTLogger eventGDTLogger);

        @Binds
        @LocalOverrideSettingsProvider
        SettingsProvider localOverrideSettings(LocalOverrideSettings localOverrideSettings);

        @RemoteSettingsProvider
        @Binds
        SettingsProvider remoteSettings(RemoteSettings remoteSettings);

        @Binds
        SessionDatastore sessionDatastore(SessionDatastoreImpl sessionDatastoreImpl);

        @Binds
        SessionFirelogPublisher sessionFirelogPublisher(SessionFirelogPublisherImpl sessionFirelogPublisherImpl);

        @Binds
        SessionLifecycleServiceBinder sessionLifecycleServiceBinder(SessionLifecycleServiceBinderImpl sessionLifecycleServiceBinderImpl);
    }

    FirebaseSessions getFirebaseSessions();

    SessionDatastore getSessionDatastore();

    SessionFirelogPublisher getSessionFirelogPublisher();

    SessionGenerator getSessionGenerator();

    SessionsSettings getSessionsSettings();
}
