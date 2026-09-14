package com.samsung.sr.nmt.t2t.translator.core.dagger;

import dagger.internal.Factory;

/* loaded from: classes.dex */
public final class LanguageDetectorThresholdModule_ProvideThresholdFactory implements Factory<Float> {
    private final LanguageDetectorThresholdModule module;

    public LanguageDetectorThresholdModule_ProvideThresholdFactory(LanguageDetectorThresholdModule languageDetectorThresholdModule) {
        this.module = languageDetectorThresholdModule;
    }

    @Override // javax.inject.Provider
    public Float get() {
        return Float.valueOf(provideThreshold(this.module));
    }

    public static LanguageDetectorThresholdModule_ProvideThresholdFactory create(LanguageDetectorThresholdModule languageDetectorThresholdModule) {
        return new LanguageDetectorThresholdModule_ProvideThresholdFactory(languageDetectorThresholdModule);
    }

    public static float provideThreshold(LanguageDetectorThresholdModule languageDetectorThresholdModule) {
        return languageDetectorThresholdModule.provideThreshold();
    }
}
