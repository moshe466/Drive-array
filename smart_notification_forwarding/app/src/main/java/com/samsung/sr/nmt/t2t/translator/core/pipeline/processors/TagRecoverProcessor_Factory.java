package com.samsung.sr.nmt.t2t.translator.core.pipeline.processors;

import dagger.internal.Factory;

/* loaded from: classes.dex */
public final class TagRecoverProcessor_Factory implements Factory<TagRecoverProcessor> {
    @Override // javax.inject.Provider
    public TagRecoverProcessor get() {
        return newInstance();
    }

    public static TagRecoverProcessor_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static TagRecoverProcessor newInstance() {
        return new TagRecoverProcessor();
    }

    /* loaded from: classes.dex */
    private static final class InstanceHolder {
        private static final TagRecoverProcessor_Factory INSTANCE = new TagRecoverProcessor_Factory();

        private InstanceHolder() {
        }
    }
}
