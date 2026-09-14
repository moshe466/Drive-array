package com.samsung.sr.nmt.t2t.translator.core.dagger;

import com.samsung.sr.nmt.t2t.translator.core.pipeline.loader.TranslationMemoryLoader;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.translationmemory.TranslationMemory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class TranslationMemoryModule_ProvideTranslationMemoryFactory implements Factory<TranslationMemory> {
    private final TranslationMemoryModule module;
    private final Provider<TranslationMemoryLoader> translationMemoryLoaderProvider;

    public TranslationMemoryModule_ProvideTranslationMemoryFactory(TranslationMemoryModule translationMemoryModule, Provider<TranslationMemoryLoader> provider) {
        this.module = translationMemoryModule;
        this.translationMemoryLoaderProvider = provider;
    }

    @Override // javax.inject.Provider
    public TranslationMemory get() {
        return provideTranslationMemory(this.module, this.translationMemoryLoaderProvider.get());
    }

    public static TranslationMemoryModule_ProvideTranslationMemoryFactory create(TranslationMemoryModule translationMemoryModule, Provider<TranslationMemoryLoader> provider) {
        return new TranslationMemoryModule_ProvideTranslationMemoryFactory(translationMemoryModule, provider);
    }

    public static TranslationMemory provideTranslationMemory(TranslationMemoryModule translationMemoryModule, TranslationMemoryLoader translationMemoryLoader) {
        return (TranslationMemory) Preconditions.checkNotNullFromProvides(translationMemoryModule.provideTranslationMemory(translationMemoryLoader));
    }
}
