package com.samsung.sr.nmt.t2t.translator.core.pipeline.processors;

import dagger.internal.Factory;

/* loaded from: classes.dex */
public final class FormattingRestoreProcessor_Factory implements Factory<FormattingRestoreProcessor> {
    @Override // javax.inject.Provider
    public FormattingRestoreProcessor get() {
        return newInstance();
    }

    public static FormattingRestoreProcessor_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static FormattingRestoreProcessor newInstance() {
        return new FormattingRestoreProcessor();
    }

    /* loaded from: classes.dex */
    private static final class InstanceHolder {
        private static final FormattingRestoreProcessor_Factory INSTANCE = new FormattingRestoreProcessor_Factory();

        private InstanceHolder() {
        }
    }
}
