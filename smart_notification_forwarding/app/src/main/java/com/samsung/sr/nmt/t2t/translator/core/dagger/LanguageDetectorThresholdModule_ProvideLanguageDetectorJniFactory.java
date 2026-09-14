package com.samsung.sr.nmt.t2t.translator.core.dagger;

import com.samsung.sr.nmt.t2t.translator.core.languagedetector.LanguageDetectorJni;
import com.samsung.sr.nmt.t2t.translator.core.utils.AssetLoader;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class LanguageDetectorThresholdModule_ProvideLanguageDetectorJniFactory implements Factory<LanguageDetectorJni> {
    private final Provider<AssetLoader> assertLoaderProvider;
    private final LanguageDetectorThresholdModule module;

    public LanguageDetectorThresholdModule_ProvideLanguageDetectorJniFactory(LanguageDetectorThresholdModule languageDetectorThresholdModule, Provider<AssetLoader> provider) {
        this.module = languageDetectorThresholdModule;
        this.assertLoaderProvider = provider;
    }

    @Override // javax.inject.Provider
    public LanguageDetectorJni get() {
        return provideLanguageDetectorJni(this.module, this.assertLoaderProvider.get());
    }

    public static LanguageDetectorThresholdModule_ProvideLanguageDetectorJniFactory create(LanguageDetectorThresholdModule languageDetectorThresholdModule, Provider<AssetLoader> provider) {
        return new LanguageDetectorThresholdModule_ProvideLanguageDetectorJniFactory(languageDetectorThresholdModule, provider);
    }

    public static LanguageDetectorJni provideLanguageDetectorJni(LanguageDetectorThresholdModule languageDetectorThresholdModule, AssetLoader assetLoader) {
        return (LanguageDetectorJni) Preconditions.checkNotNullFromProvides(languageDetectorThresholdModule.provideLanguageDetectorJni(assetLoader));
    }
}
