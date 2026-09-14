package com.samsung.sr.nmt.t2t.translator.core.dagger;

import com.samsung.sr.nmt.t2t.translator.core.pipeline.loader.CustomTranslationMemoryLoader;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.translationmemory.CustomTranslationMemory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class TranslationMemoryModule_ProvideCustomTranslationMemoryFactory implements Factory<CustomTranslationMemory> {
    private final Provider<CustomTranslationMemoryLoader> customTranslationMemoryLoaderProvider;
    private final TranslationMemoryModule module;

    public TranslationMemoryModule_ProvideCustomTranslationMemoryFactory(TranslationMemoryModule translationMemoryModule, Provider<CustomTranslationMemoryLoader> provider) {
        this.module = translationMemoryModule;
        this.customTranslationMemoryLoaderProvider = provider;
    }

    @Override // javax.inject.Provider
    public CustomTranslationMemory get() {
        return provideCustomTranslationMemory(this.module, this.customTranslationMemoryLoaderProvider.get());
    }

    public static TranslationMemoryModule_ProvideCustomTranslationMemoryFactory create(TranslationMemoryModule translationMemoryModule, Provider<CustomTranslationMemoryLoader> provider) {
        return new TranslationMemoryModule_ProvideCustomTranslationMemoryFactory(translationMemoryModule, provider);
    }

    public static CustomTranslationMemory provideCustomTranslationMemory(TranslationMemoryModule translationMemoryModule, CustomTranslationMemoryLoader customTranslationMemoryLoader) {
        return (CustomTranslationMemory) Preconditions.checkNotNullFromProvides(translationMemoryModule.provideCustomTranslationMemory(customTranslationMemoryLoader));
    }
}
