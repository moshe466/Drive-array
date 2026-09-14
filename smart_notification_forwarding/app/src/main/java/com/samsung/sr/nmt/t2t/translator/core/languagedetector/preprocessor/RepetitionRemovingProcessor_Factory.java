package com.samsung.sr.nmt.t2t.translator.core.languagedetector.preprocessor;

import dagger.internal.Factory;

/* loaded from: classes.dex */
public final class RepetitionRemovingProcessor_Factory implements Factory<RepetitionRemovingProcessor> {
    @Override // javax.inject.Provider
    public RepetitionRemovingProcessor get() {
        return newInstance();
    }

    public static RepetitionRemovingProcessor_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static RepetitionRemovingProcessor newInstance() {
        return new RepetitionRemovingProcessor();
    }

    /* loaded from: classes.dex */
    private static final class InstanceHolder {
        private static final RepetitionRemovingProcessor_Factory INSTANCE = new RepetitionRemovingProcessor_Factory();

        private InstanceHolder() {
        }
    }
}
