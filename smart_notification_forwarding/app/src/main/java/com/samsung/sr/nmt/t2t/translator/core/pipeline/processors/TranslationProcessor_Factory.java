package com.samsung.sr.nmt.t2t.translator.core.pipeline.processors;

import com.samsung.sr.nmt.t2t.translator.core.pipeline.emergency.EmergencyHandler;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.EngineProvider;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.replacepair.ReplacePairManager;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.translationmemory.TranslationMemory;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class TranslationProcessor_Factory implements Factory<TranslationProcessor> {
    private final Provider<Integer> batchSizeProvider;
    private final Provider<EmergencyHandler> emergencyHandlerProvider;
    private final Provider<EngineProvider> engineProvider;
    private final Provider<NormalizeProcessor> normalizeProcessorProvider;
    private final Provider<PlaceholderHandler> placeholderHandlerProvider;
    private final Provider<ReplacePairManager> replacePairManagerProvider;
    private final Provider<TranslationMemory> translationMemoryProvider;

    public TranslationProcessor_Factory(Provider<EngineProvider> provider, Provider<TranslationMemory> provider2, Provider<Integer> provider3, Provider<ReplacePairManager> provider4, Provider<PlaceholderHandler> provider5, Provider<EmergencyHandler> provider6, Provider<NormalizeProcessor> provider7) {
        this.engineProvider = provider;
        this.translationMemoryProvider = provider2;
        this.batchSizeProvider = provider3;
        this.replacePairManagerProvider = provider4;
        this.placeholderHandlerProvider = provider5;
        this.emergencyHandlerProvider = provider6;
        this.normalizeProcessorProvider = provider7;
    }

    @Override // javax.inject.Provider
    public TranslationProcessor get() {
        return newInstance(this.engineProvider.get(), this.translationMemoryProvider.get(), this.batchSizeProvider.get().intValue(), this.replacePairManagerProvider.get(), this.placeholderHandlerProvider.get(), this.emergencyHandlerProvider.get(), this.normalizeProcessorProvider.get());
    }

    public static TranslationProcessor_Factory create(Provider<EngineProvider> provider, Provider<TranslationMemory> provider2, Provider<Integer> provider3, Provider<ReplacePairManager> provider4, Provider<PlaceholderHandler> provider5, Provider<EmergencyHandler> provider6, Provider<NormalizeProcessor> provider7) {
        return new TranslationProcessor_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    public static TranslationProcessor newInstance(EngineProvider engineProvider, TranslationMemory translationMemory, int i, ReplacePairManager replacePairManager, PlaceholderHandler placeholderHandler, EmergencyHandler emergencyHandler, NormalizeProcessor normalizeProcessor) {
        return new TranslationProcessor(engineProvider, translationMemory, i, replacePairManager, placeholderHandler, emergencyHandler, normalizeProcessor);
    }
}
