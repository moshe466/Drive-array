package com.samsung.sr.nmt.t2t.translator.core.dagger;

import com.samsung.sr.nmt.t2t.translator.core.languagedetector.LanguageDetector;
import com.samsung.sr.nmt.t2t.translator.core.languagedetector.LanguageDetectorJni;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.Map;
import java.util.Set;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class LanguageDetectorThresholdModule_ProvideLanguageDetectorFactory implements Factory<LanguageDetector> {
    private final Provider<Set<String>> englishDictionaryProvider;
    private final Provider<Map<String, String>> languageDetectorDictionaryProvider;
    private final Provider<LanguageDetectorJni> languageDetectorJniProvider;
    private final LanguageDetectorThresholdModule module;

    public LanguageDetectorThresholdModule_ProvideLanguageDetectorFactory(LanguageDetectorThresholdModule languageDetectorThresholdModule, Provider<LanguageDetectorJni> provider, Provider<Set<String>> provider2, Provider<Map<String, String>> provider3) {
        this.module = languageDetectorThresholdModule;
        this.languageDetectorJniProvider = provider;
        this.englishDictionaryProvider = provider2;
        this.languageDetectorDictionaryProvider = provider3;
    }

    @Override // javax.inject.Provider
    public LanguageDetector get() {
        return provideLanguageDetector(this.module, this.languageDetectorJniProvider.get(), this.englishDictionaryProvider.get(), this.languageDetectorDictionaryProvider.get());
    }

    public static LanguageDetectorThresholdModule_ProvideLanguageDetectorFactory create(LanguageDetectorThresholdModule languageDetectorThresholdModule, Provider<LanguageDetectorJni> provider, Provider<Set<String>> provider2, Provider<Map<String, String>> provider3) {
        return new LanguageDetectorThresholdModule_ProvideLanguageDetectorFactory(languageDetectorThresholdModule, provider, provider2, provider3);
    }

    public static LanguageDetector provideLanguageDetector(LanguageDetectorThresholdModule languageDetectorThresholdModule, LanguageDetectorJni languageDetectorJni, Set<String> set, Map<String, String> map) {
        return (LanguageDetector) Preconditions.checkNotNullFromProvides(languageDetectorThresholdModule.provideLanguageDetector(languageDetectorJni, set, map));
    }
}
