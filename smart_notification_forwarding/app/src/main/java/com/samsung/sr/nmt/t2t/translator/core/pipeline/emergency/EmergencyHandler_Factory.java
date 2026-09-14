package com.samsung.sr.nmt.t2t.translator.core.pipeline.emergency;

import dagger.internal.Factory;

/* loaded from: classes.dex */
public final class EmergencyHandler_Factory implements Factory<EmergencyHandler> {
    @Override // javax.inject.Provider
    public EmergencyHandler get() {
        return newInstance();
    }

    public static EmergencyHandler_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static EmergencyHandler newInstance() {
        return new EmergencyHandler();
    }

    /* loaded from: classes.dex */
    private static final class InstanceHolder {
        private static final EmergencyHandler_Factory INSTANCE = new EmergencyHandler_Factory();

        private InstanceHolder() {
        }
    }
}
