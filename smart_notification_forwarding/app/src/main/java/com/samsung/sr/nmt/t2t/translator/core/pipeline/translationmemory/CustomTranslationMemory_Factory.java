package com.samsung.sr.nmt.t2t.translator.core.pipeline.translationmemory;

import com.samsung.sr.nmt.t2t.translator.core.pipeline.loader.CustomTranslationMemoryLoader;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class CustomTranslationMemory_Factory implements Factory<CustomTranslationMemory> {
    private final Provider<CustomTranslationMemoryLoader> customTranslationMemoryLoaderProvider;

    public CustomTranslationMemory_Factory(Provider<CustomTranslationMemoryLoader> provider) {
        this.customTranslationMemoryLoaderProvider = provider;
    }

    @Override // javax.inject.Provider
    public CustomTranslationMemory get() {
        return newInstance(this.customTranslationMemoryLoaderProvider.get());
    }

    public static CustomTranslationMemory_Factory create(Provider<CustomTranslationMemoryLoader> provider) {
        return new CustomTranslationMemory_Factory(provider);
    }

    public static CustomTranslationMemory newInstance(CustomTranslationMemoryLoader customTranslationMemoryLoader) {
        return new CustomTranslationMemory(customTranslationMemoryLoader);
    }
}
