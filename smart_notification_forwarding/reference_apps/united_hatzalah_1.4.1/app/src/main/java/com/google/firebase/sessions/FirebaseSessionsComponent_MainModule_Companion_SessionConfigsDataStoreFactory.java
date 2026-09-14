package com.google.firebase.sessions;

import R.InterfaceC0183h;
import android.content.Context;
import com.google.firebase.sessions.FirebaseSessionsComponent;
import com.google.firebase.sessions.dagger.internal.Factory;
import com.google.firebase.sessions.dagger.internal.Preconditions;
import r2.InterfaceC0645a;

/* loaded from: classes.dex */
public final class FirebaseSessionsComponent_MainModule_Companion_SessionConfigsDataStoreFactory implements Factory<InterfaceC0183h> {
    private final InterfaceC0645a appContextProvider;

    public FirebaseSessionsComponent_MainModule_Companion_SessionConfigsDataStoreFactory(InterfaceC0645a interfaceC0645a) {
        this.appContextProvider = interfaceC0645a;
    }

    public static FirebaseSessionsComponent_MainModule_Companion_SessionConfigsDataStoreFactory create(InterfaceC0645a interfaceC0645a) {
        return new FirebaseSessionsComponent_MainModule_Companion_SessionConfigsDataStoreFactory(interfaceC0645a);
    }

    public static InterfaceC0183h sessionConfigsDataStore(Context context) {
        return (InterfaceC0183h) Preconditions.checkNotNullFromProvides(FirebaseSessionsComponent.MainModule.Companion.sessionConfigsDataStore(context));
    }

    @Override // com.google.firebase.sessions.dagger.internal.Factory, r2.InterfaceC0645a
    public InterfaceC0183h get() {
        return sessionConfigsDataStore((Context) this.appContextProvider.get());
    }
}
