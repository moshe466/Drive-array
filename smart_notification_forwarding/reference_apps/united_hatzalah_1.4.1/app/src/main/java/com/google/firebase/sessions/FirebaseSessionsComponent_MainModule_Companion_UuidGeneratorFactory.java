package com.google.firebase.sessions;

import com.google.firebase.sessions.FirebaseSessionsComponent;
import com.google.firebase.sessions.dagger.internal.Factory;
import com.google.firebase.sessions.dagger.internal.Preconditions;

/* loaded from: classes.dex */
public final class FirebaseSessionsComponent_MainModule_Companion_UuidGeneratorFactory implements Factory<UuidGenerator> {

    /* loaded from: classes.dex */
    public static final class InstanceHolder {
        private static final FirebaseSessionsComponent_MainModule_Companion_UuidGeneratorFactory INSTANCE = new FirebaseSessionsComponent_MainModule_Companion_UuidGeneratorFactory();

        private InstanceHolder() {
        }
    }

    public static FirebaseSessionsComponent_MainModule_Companion_UuidGeneratorFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static UuidGenerator uuidGenerator() {
        return (UuidGenerator) Preconditions.checkNotNullFromProvides(FirebaseSessionsComponent.MainModule.Companion.uuidGenerator());
    }

    @Override // com.google.firebase.sessions.dagger.internal.Factory, r2.InterfaceC0645a
    public UuidGenerator get() {
        return uuidGenerator();
    }
}
