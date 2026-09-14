package com.samsung.sr.nmt.t2t.translator.core.pipeline.processors;

import dagger.internal.Factory;

/* loaded from: classes.dex */
public final class HonorificTagHandler_Factory implements Factory<HonorificTagHandler> {
    @Override // javax.inject.Provider
    public HonorificTagHandler get() {
        return newInstance();
    }

    public static HonorificTagHandler_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static HonorificTagHandler newInstance() {
        return new HonorificTagHandler();
    }

    /* loaded from: classes.dex */
    private static final class InstanceHolder {
        private static final HonorificTagHandler_Factory INSTANCE = new HonorificTagHandler_Factory();

        private InstanceHolder() {
        }
    }
}
