package com.samsung.sr.nmt.t2t.translator.core;

import com.samsung.sr.nmt.t2t.translator.core.languagedetector.LanguageDetector;
import com.samsung.sr.nmt.t2t.translator.core.languagedetector.differentiator.DifferentiationManager;
import com.samsung.sr.nmt.t2t.translator.core.languagedetector.preprocessor.DetectionPreProcessor;
import dagger.internal.Factory;
import java.util.Map;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class LanguageDetectionServiceImpl_Factory implements Factory<LanguageDetectionServiceImpl> {
    private final Provider<DifferentiationManager> differentiationManagerProvider;
    private final Provider<LanguageDetector> languageDetectorProvider;
    private final Provider<Map<Class<?>, Provider<DetectionPreProcessor>>> preprocessorsProvider;

    public LanguageDetectionServiceImpl_Factory(Provider<LanguageDetector> provider, Provider<DifferentiationManager> provider2, Provider<Map<Class<?>, Provider<DetectionPreProcessor>>> provider3) {
        this.languageDetectorProvider = provider;
        this.differentiationManagerProvider = provider2;
        this.preprocessorsProvider = provider3;
    }

    @Override // javax.inject.Provider
    public LanguageDetectionServiceImpl get() {
        return newInstance(this.languageDetectorProvider.get(), this.differentiationManagerProvider.get(), this.preprocessorsProvider.get());
    }

    public static LanguageDetectionServiceImpl_Factory create(Provider<LanguageDetector> provider, Provider<DifferentiationManager> provider2, Provider<Map<Class<?>, Provider<DetectionPreProcessor>>> provider3) {
        return new LanguageDetectionServiceImpl_Factory(provider, provider2, provider3);
    }

    public static LanguageDetectionServiceImpl newInstance(LanguageDetector languageDetector, DifferentiationManager differentiationManager, Map<Class<?>, Provider<DetectionPreProcessor>> map) {
        return new LanguageDetectionServiceImpl(languageDetector, differentiationManager, map);
    }
}
