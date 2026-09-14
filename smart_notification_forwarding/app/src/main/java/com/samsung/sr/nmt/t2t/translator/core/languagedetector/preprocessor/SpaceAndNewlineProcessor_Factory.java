package com.samsung.sr.nmt.t2t.translator.core.languagedetector.preprocessor;

import dagger.internal.Factory;

/* loaded from: classes.dex */
public final class SpaceAndNewlineProcessor_Factory implements Factory<SpaceAndNewlineProcessor> {
    @Override // javax.inject.Provider
    public SpaceAndNewlineProcessor get() {
        return newInstance();
    }

    public static SpaceAndNewlineProcessor_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static SpaceAndNewlineProcessor newInstance() {
        return new SpaceAndNewlineProcessor();
    }

    /* loaded from: classes.dex */
    private static final class InstanceHolder {
        private static final SpaceAndNewlineProcessor_Factory INSTANCE = new SpaceAndNewlineProcessor_Factory();

        private InstanceHolder() {
        }
    }
}
