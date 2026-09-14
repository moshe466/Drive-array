package com.samsung.sr.nmt.t2t.translator.core.pipeline.processors;

import dagger.internal.Factory;

/* loaded from: classes.dex */
public final class EsMxDollarsFixProcessor_Factory implements Factory<EsMxDollarsFixProcessor> {
    @Override // javax.inject.Provider
    public EsMxDollarsFixProcessor get() {
        return newInstance();
    }

    public static EsMxDollarsFixProcessor_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static EsMxDollarsFixProcessor newInstance() {
        return new EsMxDollarsFixProcessor();
    }

    /* loaded from: classes.dex */
    private static final class InstanceHolder {
        private static final EsMxDollarsFixProcessor_Factory INSTANCE = new EsMxDollarsFixProcessor_Factory();

        private InstanceHolder() {
        }
    }
}
