package com.samsung.sr.nmt.t2t.translator.core.dagger;

import com.samsung.sr.nmt.t2t.translator.core.pipeline.loader.CustomTranslationMemoryLoader;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* loaded from: classes.dex */
public final class TranslationMemoryLoaderModule_ProvideCustomTranslationMemoryLoaderFactory implements Factory<CustomTranslationMemoryLoader> {
    private final TranslationMemoryLoaderModule module;

    public TranslationMemoryLoaderModule_ProvideCustomTranslationMemoryLoaderFactory(TranslationMemoryLoaderModule translationMemoryLoaderModule) {
        this.module = translationMemoryLoaderModule;
    }

    @Override // javax.inject.Provider
    public CustomTranslationMemoryLoader get() {
        return provideCustomTranslationMemoryLoader(this.module);
    }

    public static TranslationMemoryLoaderModule_ProvideCustomTranslationMemoryLoaderFactory create(TranslationMemoryLoaderModule translationMemoryLoaderModule) {
        return new TranslationMemoryLoaderModule_ProvideCustomTranslationMemoryLoaderFactory(translationMemoryLoaderModule);
    }

    public static CustomTranslationMemoryLoader provideCustomTranslationMemoryLoader(TranslationMemoryLoaderModule translationMemoryLoaderModule) {
        return (CustomTranslationMemoryLoader) Preconditions.checkNotNullFromProvides(translationMemoryLoaderModule.getCustomTranslationMemoryLoader());
    }
}
