package com.google.firebase.sessions;

import com.google.firebase.FirebaseApp;
import com.google.firebase.sessions.FirebaseSessionsComponent;
import com.google.firebase.sessions.dagger.internal.Factory;
import com.google.firebase.sessions.dagger.internal.Preconditions;
import r2.InterfaceC0645a;

/* loaded from: classes.dex */
public final class FirebaseSessionsComponent_MainModule_Companion_ApplicationInfoFactory implements Factory<ApplicationInfo> {
    private final InterfaceC0645a firebaseAppProvider;

    public FirebaseSessionsComponent_MainModule_Companion_ApplicationInfoFactory(InterfaceC0645a interfaceC0645a) {
        this.firebaseAppProvider = interfaceC0645a;
    }

    public static ApplicationInfo applicationInfo(FirebaseApp firebaseApp) {
        return (ApplicationInfo) Preconditions.checkNotNullFromProvides(FirebaseSessionsComponent.MainModule.Companion.applicationInfo(firebaseApp));
    }

    public static FirebaseSessionsComponent_MainModule_Companion_ApplicationInfoFactory create(InterfaceC0645a interfaceC0645a) {
        return new FirebaseSessionsComponent_MainModule_Companion_ApplicationInfoFactory(interfaceC0645a);
    }

    @Override // com.google.firebase.sessions.dagger.internal.Factory, r2.InterfaceC0645a
    public ApplicationInfo get() {
        return applicationInfo((FirebaseApp) this.firebaseAppProvider.get());
    }
}
