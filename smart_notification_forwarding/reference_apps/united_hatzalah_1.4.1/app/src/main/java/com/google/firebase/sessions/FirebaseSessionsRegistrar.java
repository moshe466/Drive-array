package com.google.firebase.sessions;

import F2.l;
import F2.r;
import P2.A;
import P2.E;
import T.d;
import android.content.Context;
import com.google.firebase.FirebaseApp;
import com.google.firebase.annotations.concurrent.Background;
import com.google.firebase.annotations.concurrent.Blocking;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import com.google.firebase.components.Qualified;
import com.google.firebase.inject.Provider;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.platforminfo.LibraryVersionComponent;
import com.google.firebase.sessions.FirebaseSessionsComponent;
import java.util.List;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.j;
import q1.g;
import t2.AbstractC0708j;
import w2.InterfaceC0768i;

/* loaded from: classes.dex */
public final class FirebaseSessionsRegistrar implements ComponentRegistrar {
    private static final Companion Companion = new Companion(null);

    @Deprecated
    public static final String LIBRARY_NAME = "fire-sessions";

    @Deprecated
    public static final String TAG = "FirebaseSessions";
    private static final Qualified<Context> appContext;
    private static final Qualified<A> backgroundDispatcher;
    private static final Qualified<A> blockingDispatcher;
    private static final Qualified<FirebaseApp> firebaseApp;
    private static final Qualified<FirebaseInstallationsApi> firebaseInstallationsApi;
    private static final Qualified<FirebaseSessionsComponent> firebaseSessionsComponent;
    private static final Qualified<g> transportFactory;

    /* loaded from: classes.dex */
    public static final class Companion {

        /* renamed from: com.google.firebase.sessions.FirebaseSessionsRegistrar$Companion$1, reason: invalid class name */
        /* loaded from: classes.dex */
        public /* synthetic */ class AnonymousClass1 extends i implements r {
            public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

            public AnonymousClass1() {
                super(4, T.b.class, "preferencesDataStore", "preferencesDataStore(Ljava/lang/String;Landroidx/datastore/core/handlers/ReplaceFileCorruptionHandler;Lkotlin/jvm/functions/Function1;Lkotlinx/coroutines/CoroutineScope;)Lkotlin/properties/ReadOnlyProperty;", 1);
            }

            public final H2.a invoke(String p02, S.a aVar, l p2, E p32) {
                j.e(p02, "p0");
                j.e(p2, "p2");
                j.e(p32, "p3");
                return new d(p02, aVar, p2, p32);
            }
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }

        public final Qualified<Context> getAppContext() {
            return FirebaseSessionsRegistrar.appContext;
        }

        public final Qualified<A> getBackgroundDispatcher() {
            return FirebaseSessionsRegistrar.backgroundDispatcher;
        }

        public final Qualified<A> getBlockingDispatcher() {
            return FirebaseSessionsRegistrar.blockingDispatcher;
        }

        public final Qualified<FirebaseApp> getFirebaseApp() {
            return FirebaseSessionsRegistrar.firebaseApp;
        }

        public final Qualified<FirebaseInstallationsApi> getFirebaseInstallationsApi() {
            return FirebaseSessionsRegistrar.firebaseInstallationsApi;
        }

        public final Qualified<FirebaseSessionsComponent> getFirebaseSessionsComponent() {
            return FirebaseSessionsRegistrar.firebaseSessionsComponent;
        }

        public final Qualified<g> getTransportFactory() {
            return FirebaseSessionsRegistrar.transportFactory;
        }

        private Companion() {
        }
    }

    static {
        Qualified<Context> unqualified = Qualified.unqualified(Context.class);
        j.d(unqualified, "unqualified(Context::class.java)");
        appContext = unqualified;
        Qualified<FirebaseApp> unqualified2 = Qualified.unqualified(FirebaseApp.class);
        j.d(unqualified2, "unqualified(FirebaseApp::class.java)");
        firebaseApp = unqualified2;
        Qualified<FirebaseInstallationsApi> unqualified3 = Qualified.unqualified(FirebaseInstallationsApi.class);
        j.d(unqualified3, "unqualified(FirebaseInstallationsApi::class.java)");
        firebaseInstallationsApi = unqualified3;
        Qualified<A> qualified = Qualified.qualified(Background.class, A.class);
        j.d(qualified, "qualified(Background::cl…neDispatcher::class.java)");
        backgroundDispatcher = qualified;
        Qualified<A> qualified2 = Qualified.qualified(Blocking.class, A.class);
        j.d(qualified2, "qualified(Blocking::clas…neDispatcher::class.java)");
        blockingDispatcher = qualified2;
        Qualified<g> unqualified4 = Qualified.unqualified(g.class);
        j.d(unqualified4, "unqualified(TransportFactory::class.java)");
        transportFactory = unqualified4;
        Qualified<FirebaseSessionsComponent> unqualified5 = Qualified.unqualified(FirebaseSessionsComponent.class);
        j.d(unqualified5, "unqualified(FirebaseSessionsComponent::class.java)");
        firebaseSessionsComponent = unqualified5;
        try {
            Companion.AnonymousClass1.INSTANCE.getClass();
        } catch (NoClassDefFoundError unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FirebaseSessions getComponents$lambda$0(ComponentContainer componentContainer) {
        return ((FirebaseSessionsComponent) componentContainer.get(firebaseSessionsComponent)).getFirebaseSessions();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FirebaseSessionsComponent getComponents$lambda$1(ComponentContainer componentContainer) {
        FirebaseSessionsComponent.Builder builder = DaggerFirebaseSessionsComponent.builder();
        Object obj = componentContainer.get(appContext);
        j.d(obj, "container[appContext]");
        FirebaseSessionsComponent.Builder appContext2 = builder.appContext((Context) obj);
        Object obj2 = componentContainer.get(backgroundDispatcher);
        j.d(obj2, "container[backgroundDispatcher]");
        FirebaseSessionsComponent.Builder backgroundDispatcher2 = appContext2.backgroundDispatcher((InterfaceC0768i) obj2);
        Object obj3 = componentContainer.get(blockingDispatcher);
        j.d(obj3, "container[blockingDispatcher]");
        FirebaseSessionsComponent.Builder blockingDispatcher2 = backgroundDispatcher2.blockingDispatcher((InterfaceC0768i) obj3);
        Object obj4 = componentContainer.get(firebaseApp);
        j.d(obj4, "container[firebaseApp]");
        FirebaseSessionsComponent.Builder firebaseApp2 = blockingDispatcher2.firebaseApp((FirebaseApp) obj4);
        Object obj5 = componentContainer.get(firebaseInstallationsApi);
        j.d(obj5, "container[firebaseInstallationsApi]");
        FirebaseSessionsComponent.Builder firebaseInstallationsApi2 = firebaseApp2.firebaseInstallationsApi((FirebaseInstallationsApi) obj5);
        Provider<g> provider = componentContainer.getProvider(transportFactory);
        j.d(provider, "container.getProvider(transportFactory)");
        return firebaseInstallationsApi2.transportFactoryProvider(provider).build();
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    public List<Component<? extends Object>> getComponents() {
        final int i = 0;
        final int i3 = 1;
        return AbstractC0708j.W(Component.builder(FirebaseSessions.class).name(LIBRARY_NAME).add(Dependency.required(firebaseSessionsComponent)).factory(new ComponentFactory() { // from class: com.google.firebase.sessions.b
            @Override // com.google.firebase.components.ComponentFactory
            public final Object create(ComponentContainer componentContainer) {
                FirebaseSessions components$lambda$0;
                FirebaseSessionsComponent components$lambda$1;
                switch (i) {
                    case 0:
                        components$lambda$0 = FirebaseSessionsRegistrar.getComponents$lambda$0(componentContainer);
                        return components$lambda$0;
                    default:
                        components$lambda$1 = FirebaseSessionsRegistrar.getComponents$lambda$1(componentContainer);
                        return components$lambda$1;
                }
            }
        }).eagerInDefaultApp().build(), Component.builder(FirebaseSessionsComponent.class).name("fire-sessions-component").add(Dependency.required(appContext)).add(Dependency.required(backgroundDispatcher)).add(Dependency.required(blockingDispatcher)).add(Dependency.required(firebaseApp)).add(Dependency.required(firebaseInstallationsApi)).add(Dependency.requiredProvider(transportFactory)).factory(new ComponentFactory() { // from class: com.google.firebase.sessions.b
            @Override // com.google.firebase.components.ComponentFactory
            public final Object create(ComponentContainer componentContainer) {
                FirebaseSessions components$lambda$0;
                FirebaseSessionsComponent components$lambda$1;
                switch (i3) {
                    case 0:
                        components$lambda$0 = FirebaseSessionsRegistrar.getComponents$lambda$0(componentContainer);
                        return components$lambda$0;
                    default:
                        components$lambda$1 = FirebaseSessionsRegistrar.getComponents$lambda$1(componentContainer);
                        return components$lambda$1;
                }
            }
        }).build(), LibraryVersionComponent.create(LIBRARY_NAME, BuildConfig.VERSION_NAME));
    }
}
