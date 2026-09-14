package com.google.firebase.inappmessaging.display.internal;

import dagger.internal.Factory;

/* loaded from: classes2.dex */
public final class FiamWindowManager_Factory implements Factory<FiamWindowManager> {
    private static final FiamWindowManager_Factory INSTANCE = new FiamWindowManager_Factory();

    public static FiamWindowManager_Factory create() {
        return INSTANCE;
    }

    public static FiamWindowManager newInstance() {
        return new FiamWindowManager();
    }

    @Override // javax.inject.Provider
    public FiamWindowManager get() {
        return new FiamWindowManager();
    }
}
