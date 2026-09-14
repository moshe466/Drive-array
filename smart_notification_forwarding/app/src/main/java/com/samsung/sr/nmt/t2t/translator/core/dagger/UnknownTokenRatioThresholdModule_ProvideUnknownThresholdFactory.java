package com.samsung.sr.nmt.t2t.translator.core.dagger;

import dagger.internal.Factory;

/* loaded from: classes.dex */
public final class UnknownTokenRatioThresholdModule_ProvideUnknownThresholdFactory implements Factory<Float> {
    private final UnknownTokenRatioThresholdModule module;

    public UnknownTokenRatioThresholdModule_ProvideUnknownThresholdFactory(UnknownTokenRatioThresholdModule unknownTokenRatioThresholdModule) {
        this.module = unknownTokenRatioThresholdModule;
    }

    @Override // javax.inject.Provider
    public Float get() {
        return Float.valueOf(provideUnknownThreshold(this.module));
    }

    public static UnknownTokenRatioThresholdModule_ProvideUnknownThresholdFactory create(UnknownTokenRatioThresholdModule unknownTokenRatioThresholdModule) {
        return new UnknownTokenRatioThresholdModule_ProvideUnknownThresholdFactory(unknownTokenRatioThresholdModule);
    }

    public static float provideUnknownThreshold(UnknownTokenRatioThresholdModule unknownTokenRatioThresholdModule) {
        return unknownTokenRatioThresholdModule.getThreshold();
    }
}
