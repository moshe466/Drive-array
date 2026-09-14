package com.samsung.sr.nmt.t2t.translator.core.pipeline.processors;

import dagger.internal.Factory;

/* loaded from: classes.dex */
public final class TagClosingProcessor_Factory implements Factory<TagClosingProcessor> {
    @Override // javax.inject.Provider
    public TagClosingProcessor get() {
        return newInstance();
    }

    public static TagClosingProcessor_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static TagClosingProcessor newInstance() {
        return new TagClosingProcessor();
    }

    /* loaded from: classes.dex */
    private static final class InstanceHolder {
        private static final TagClosingProcessor_Factory INSTANCE = new TagClosingProcessor_Factory();

        private InstanceHolder() {
        }
    }
}
