package com.samsung.sr.nmt.t2t.translator.core.pipeline.processors;

import dagger.internal.Factory;

/* loaded from: classes.dex */
public final class SentenceJoinerProcessor_Factory implements Factory<SentenceJoinerProcessor> {
    @Override // javax.inject.Provider
    public SentenceJoinerProcessor get() {
        return newInstance();
    }

    public static SentenceJoinerProcessor_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static SentenceJoinerProcessor newInstance() {
        return new SentenceJoinerProcessor();
    }

    /* loaded from: classes.dex */
    private static final class InstanceHolder {
        private static final SentenceJoinerProcessor_Factory INSTANCE = new SentenceJoinerProcessor_Factory();

        private InstanceHolder() {
        }
    }
}
