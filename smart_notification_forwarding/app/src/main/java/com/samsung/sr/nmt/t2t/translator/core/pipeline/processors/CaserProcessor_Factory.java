package com.samsung.sr.nmt.t2t.translator.core.pipeline.processors;

import dagger.internal.Factory;

/* loaded from: classes.dex */
public final class CaserProcessor_Factory implements Factory<CaserProcessor> {
    @Override // javax.inject.Provider
    public CaserProcessor get() {
        return newInstance();
    }

    public static CaserProcessor_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static CaserProcessor newInstance() {
        return new CaserProcessor();
    }

    /* loaded from: classes.dex */
    private static final class InstanceHolder {
        private static final CaserProcessor_Factory INSTANCE = new CaserProcessor_Factory();

        private InstanceHolder() {
        }
    }
}
