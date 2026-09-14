package com.samsung.sr.nmt.t2t.translator.core.dagger;

import com.samsung.sr.nmt.t2t.translator.core.pipeline.loader.TranslationMemoryLoader;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* loaded from: classes.dex */
public final class TranslationMemoryLoaderModule_ProvideTranslationMemoryFactory implements Factory<TranslationMemoryLoader> {
    private final TranslationMemoryLoaderModule module;

    public TranslationMemoryLoaderModule_ProvideTranslationMemoryFactory(TranslationMemoryLoaderModule translationMemoryLoaderModule) {
        this.module = translationMemoryLoaderModule;
    }

    @Override // javax.inject.Provider
    public TranslationMemoryLoader get() {
        return provideTranslationMemory(this.module);
    }

    public static TranslationMemoryLoaderModule_ProvideTranslationMemoryFactory create(TranslationMemoryLoaderModule translationMemoryLoaderModule) {
        return new TranslationMemoryLoaderModule_ProvideTranslationMemoryFactory(translationMemoryLoaderModule);
    }

    public static TranslationMemoryLoader provideTranslationMemory(TranslationMemoryLoaderModule translationMemoryLoaderModule) {
        return (TranslationMemoryLoader) Preconditions.checkNotNullFromProvides(translationMemoryLoaderModule.getTranslationMemoryLoader());
    }
}
