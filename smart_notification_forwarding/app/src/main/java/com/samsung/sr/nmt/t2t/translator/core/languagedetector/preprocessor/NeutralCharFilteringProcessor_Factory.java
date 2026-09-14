package com.samsung.sr.nmt.t2t.translator.core.languagedetector.preprocessor;

import dagger.internal.Factory;

/* loaded from: classes.dex */
public final class NeutralCharFilteringProcessor_Factory implements Factory<NeutralCharFilteringProcessor> {
    @Override // javax.inject.Provider
    public NeutralCharFilteringProcessor get() {
        return newInstance();
    }

    public static NeutralCharFilteringProcessor_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static NeutralCharFilteringProcessor newInstance() {
        return new NeutralCharFilteringProcessor();
    }

    /* loaded from: classes.dex */
    private static final class InstanceHolder {
        private static final NeutralCharFilteringProcessor_Factory INSTANCE = new NeutralCharFilteringProcessor_Factory();

        private InstanceHolder() {
        }
    }
}
