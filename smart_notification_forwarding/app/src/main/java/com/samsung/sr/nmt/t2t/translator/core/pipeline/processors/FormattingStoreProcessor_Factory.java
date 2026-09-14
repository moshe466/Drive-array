package com.samsung.sr.nmt.t2t.translator.core.pipeline.processors;

import dagger.internal.Factory;

/* loaded from: classes.dex */
public final class FormattingStoreProcessor_Factory implements Factory<FormattingStoreProcessor> {
    @Override // javax.inject.Provider
    public FormattingStoreProcessor get() {
        return newInstance();
    }

    public static FormattingStoreProcessor_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static FormattingStoreProcessor newInstance() {
        return new FormattingStoreProcessor();
    }

    /* loaded from: classes.dex */
    private static final class InstanceHolder {
        private static final FormattingStoreProcessor_Factory INSTANCE = new FormattingStoreProcessor_Factory();

        private InstanceHolder() {
        }
    }
}
