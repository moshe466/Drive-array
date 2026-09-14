package com.google.firebase.inappmessaging.internal.time;

import dagger.internal.Factory;

/* loaded from: classes2.dex */
public final class SystemClock_Factory implements Factory<SystemClock> {
    private static final SystemClock_Factory INSTANCE = new SystemClock_Factory();

    public static SystemClock_Factory create() {
        return INSTANCE;
    }

    public static SystemClock newInstance() {
        return new SystemClock();
    }

    @Override // javax.inject.Provider
    public SystemClock get() {
        return new SystemClock();
    }
}
