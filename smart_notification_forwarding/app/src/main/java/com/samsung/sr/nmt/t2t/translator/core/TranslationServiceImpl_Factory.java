package com.samsung.sr.nmt.t2t.translator.core;

import com.samsung.sr.nmt.t2t.translator.core.pipeline.Pipeline;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.EngineProvider;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.LanguageDirectionManager;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.translationmemory.TranslationMemory;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class TranslationServiceImpl_Factory implements Factory<TranslationServiceImpl> {
    private final Provider<EngineProvider> engineProvider;
    private final Provider<LanguageDirectionManager> languageDirectionManagerProvider;
    private final Provider<Pipeline> pipelineProvider;
    private final Provider<TranslationMemory> translationMemoryProvider;

    public TranslationServiceImpl_Factory(Provider<EngineProvider> provider, Provider<Pipeline> provider2, Provider<LanguageDirectionManager> provider3, Provider<TranslationMemory> provider4) {
        this.engineProvider = provider;
        this.pipelineProvider = provider2;
        this.languageDirectionManagerProvider = provider3;
        this.translationMemoryProvider = provider4;
    }

    @Override // javax.inject.Provider
    public TranslationServiceImpl get() {
        return newInstance(this.engineProvider.get(), this.pipelineProvider.get(), this.languageDirectionManagerProvider.get(), this.translationMemoryProvider.get());
    }

    public static TranslationServiceImpl_Factory create(Provider<EngineProvider> provider, Provider<Pipeline> provider2, Provider<LanguageDirectionManager> provider3, Provider<TranslationMemory> provider4) {
        return new TranslationServiceImpl_Factory(provider, provider2, provider3, provider4);
    }

    public static TranslationServiceImpl newInstance(EngineProvider engineProvider, Pipeline pipeline, LanguageDirectionManager languageDirectionManager, TranslationMemory translationMemory) {
        return new TranslationServiceImpl(engineProvider, pipeline, languageDirectionManager, translationMemory);
    }
}
