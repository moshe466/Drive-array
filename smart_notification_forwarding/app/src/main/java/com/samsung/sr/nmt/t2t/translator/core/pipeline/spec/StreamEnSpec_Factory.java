package com.samsung.sr.nmt.t2t.translator.core.pipeline.spec;

import dagger.internal.Factory;

/* loaded from: classes.dex */
public final class StreamEnSpec_Factory implements Factory<StreamEnSpec> {
    @Override // javax.inject.Provider
    public StreamEnSpec get() {
        return newInstance();
    }

    public static StreamEnSpec_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static StreamEnSpec newInstance() {
        return new StreamEnSpec();
    }

    /* loaded from: classes.dex */
    private static final class InstanceHolder {
        private static final StreamEnSpec_Factory INSTANCE = new StreamEnSpec_Factory();

        private InstanceHolder() {
        }
    }
}
