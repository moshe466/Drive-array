package com.samsung.sr.nmt.t2t.translator.core.pipeline.processors;

import com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.LanguageDirectionManager;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.translationmemory.CustomTranslationMemory;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.translationmemory.TranslationMemory;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class TMProcessor_Factory implements Factory<TMProcessor> {
    private final Provider<CustomTranslationMemory> customTranslationMemoryProvider;
    private final Provider<LanguageDirectionManager> languageDirectionManagerProvider;
    private final Provider<TranslationMemory> translationMemoryProvider;

    public TMProcessor_Factory(Provider<TranslationMemory> provider, Provider<CustomTranslationMemory> provider2, Provider<LanguageDirectionManager> provider3) {
        this.translationMemoryProvider = provider;
        this.customTranslationMemoryProvider = provider2;
        this.languageDirectionManagerProvider = provider3;
    }

    @Override // javax.inject.Provider
    public TMProcessor get() {
        return newInstance(this.translationMemoryProvider.get(), this.customTranslationMemoryProvider.get(), this.languageDirectionManagerProvider.get());
    }

    public static TMProcessor_Factory create(Provider<TranslationMemory> provider, Provider<CustomTranslationMemory> provider2, Provider<LanguageDirectionManager> provider3) {
        return new TMProcessor_Factory(provider, provider2, provider3);
    }

    public static TMProcessor newInstance(TranslationMemory translationMemory, CustomTranslationMemory customTranslationMemory, LanguageDirectionManager languageDirectionManager) {
        return new TMProcessor(translationMemory, customTranslationMemory, languageDirectionManager);
    }
}
