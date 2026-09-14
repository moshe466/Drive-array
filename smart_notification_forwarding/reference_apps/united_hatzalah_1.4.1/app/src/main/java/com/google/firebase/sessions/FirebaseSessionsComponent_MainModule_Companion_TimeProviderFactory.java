package com.google.firebase.sessions;

import com.google.firebase.sessions.FirebaseSessionsComponent;
import com.google.firebase.sessions.dagger.internal.Factory;
import com.google.firebase.sessions.dagger.internal.Preconditions;

/* loaded from: classes.dex */
public final class FirebaseSessionsComponent_MainModule_Companion_TimeProviderFactory implements Factory<TimeProvider> {

    /* loaded from: classes.dex */
    public static final class InstanceHolder {
        private static final FirebaseSessionsComponent_MainModule_Companion_TimeProviderFactory INSTANCE = new FirebaseSessionsComponent_MainModule_Companion_TimeProviderFactory();

        private InstanceHolder() {
        }
    }

    public static FirebaseSessionsComponent_MainModule_Companion_TimeProviderFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static TimeProvider timeProvider() {
        return (TimeProvider) Preconditions.checkNotNullFromProvides(FirebaseSessionsComponent.MainModule.Companion.timeProvider());
    }

    @Override // com.google.firebase.sessions.dagger.internal.Factory, r2.InterfaceC0645a
    public TimeProvider get() {
        return timeProvider();
    }
}
