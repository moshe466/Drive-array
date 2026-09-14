package com.google.firebase.sessions;

import R.InterfaceC0183h;
import android.content.Context;
import com.google.firebase.sessions.FirebaseSessionsComponent;
import com.google.firebase.sessions.dagger.internal.Factory;
import com.google.firebase.sessions.dagger.internal.Preconditions;
import r2.InterfaceC0645a;

/* loaded from: classes.dex */
public final class FirebaseSessionsComponent_MainModule_Companion_SessionDetailsDataStoreFactory implements Factory<InterfaceC0183h> {
    private final InterfaceC0645a appContextProvider;

    public FirebaseSessionsComponent_MainModule_Companion_SessionDetailsDataStoreFactory(InterfaceC0645a interfaceC0645a) {
        this.appContextProvider = interfaceC0645a;
    }

    public static FirebaseSessionsComponent_MainModule_Companion_SessionDetailsDataStoreFactory create(InterfaceC0645a interfaceC0645a) {
        return new FirebaseSessionsComponent_MainModule_Companion_SessionDetailsDataStoreFactory(interfaceC0645a);
    }

    public static InterfaceC0183h sessionDetailsDataStore(Context context) {
        return (InterfaceC0183h) Preconditions.checkNotNullFromProvides(FirebaseSessionsComponent.MainModule.Companion.sessionDetailsDataStore(context));
    }

    @Override // com.google.firebase.sessions.dagger.internal.Factory, r2.InterfaceC0645a
    public InterfaceC0183h get() {
        return sessionDetailsDataStore((Context) this.appContextProvider.get());
    }
}
