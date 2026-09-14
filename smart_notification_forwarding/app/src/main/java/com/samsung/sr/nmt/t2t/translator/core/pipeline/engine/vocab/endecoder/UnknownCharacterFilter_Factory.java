package com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.vocab.endecoder;

import dagger.internal.Factory;

/* loaded from: classes.dex */
public final class UnknownCharacterFilter_Factory implements Factory<UnknownCharacterFilter> {
    @Override // javax.inject.Provider
    public UnknownCharacterFilter get() {
        return newInstance();
    }

    public static UnknownCharacterFilter_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static UnknownCharacterFilter newInstance() {
        return new UnknownCharacterFilter();
    }

    /* loaded from: classes.dex */
    private static final class InstanceHolder {
        private static final UnknownCharacterFilter_Factory INSTANCE = new UnknownCharacterFilter_Factory();

        private InstanceHolder() {
        }
    }
}
