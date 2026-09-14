package com.samsung.sr.nmt.t2t.translator.core.pipeline.translationmemory;

import com.samsung.sr.nmt.t2t.translator.core.pipeline.loader.TranslationMemoryLoader;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class TranslationMemory_Factory implements Factory<TranslationMemory> {
    private final Provider<TranslationMemoryLoader> translationMemoryLoaderProvider;
    private final Provider<TranslationMemoryUnit> translationMemoryUnitProvider;

    public TranslationMemory_Factory(Provider<TranslationMemoryLoader> provider, Provider<TranslationMemoryUnit> provider2) {
        this.translationMemoryLoaderProvider = provider;
        this.translationMemoryUnitProvider = provider2;
    }

    @Override // javax.inject.Provider
    public TranslationMemory get() {
        return newInstance(this.translationMemoryLoaderProvider.get(), this.translationMemoryUnitProvider.get());
    }

    public static TranslationMemory_Factory create(Provider<TranslationMemoryLoader> provider, Provider<TranslationMemoryUnit> provider2) {
        return new TranslationMemory_Factory(provider, provider2);
    }

    public static TranslationMemory newInstance(TranslationMemoryLoader translationMemoryLoader, TranslationMemoryUnit translationMemoryUnit) {
        return new TranslationMemory(translationMemoryLoader, translationMemoryUnit);
    }
}
