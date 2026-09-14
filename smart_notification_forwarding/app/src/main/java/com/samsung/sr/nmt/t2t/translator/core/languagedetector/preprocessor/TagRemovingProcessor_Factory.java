package com.samsung.sr.nmt.t2t.translator.core.languagedetector.preprocessor;

import dagger.internal.Factory;

/* loaded from: classes.dex */
public final class TagRemovingProcessor_Factory implements Factory<TagRemovingProcessor> {
    @Override // javax.inject.Provider
    public TagRemovingProcessor get() {
        return newInstance();
    }

    public static TagRemovingProcessor_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static TagRemovingProcessor newInstance() {
        return new TagRemovingProcessor();
    }

    /* loaded from: classes.dex */
    private static final class InstanceHolder {
        private static final TagRemovingProcessor_Factory INSTANCE = new TagRemovingProcessor_Factory();

        private InstanceHolder() {
        }
    }
}
