package com.samsung.sr.nmt.t2t.translator.core.pipeline;

import com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.TranslationProcessor;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.spec.LanguageSpecFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
import kotlin.coroutines.CoroutineContext;

/* loaded from: classes.dex */
public final class Pipeline_Factory implements Factory<Pipeline> {
    private final Provider<Integer> characterBatchSizeProvider;
    private final Provider<CoroutineContext> computationContextProvider;
    private final Provider<LanguageSpecFactory> languageSpecFactoryProvider;
    private final Provider<TranslationProcessor> translationProcessorProvider;

    public Pipeline_Factory(Provider<LanguageSpecFactory> provider, Provider<TranslationProcessor> provider2, Provider<CoroutineContext> provider3, Provider<Integer> provider4) {
        this.languageSpecFactoryProvider = provider;
        this.translationProcessorProvider = provider2;
        this.computationContextProvider = provider3;
        this.characterBatchSizeProvider = provider4;
    }

    @Override // javax.inject.Provider
    public Pipeline get() {
        return newInstance(this.languageSpecFactoryProvider.get(), this.translationProcessorProvider.get(), this.computationContextProvider.get(), this.characterBatchSizeProvider.get().intValue());
    }

    public static Pipeline_Factory create(Provider<LanguageSpecFactory> provider, Provider<TranslationProcessor> provider2, Provider<CoroutineContext> provider3, Provider<Integer> provider4) {
        return new Pipeline_Factory(provider, provider2, provider3, provider4);
    }

    public static Pipeline newInstance(LanguageSpecFactory languageSpecFactory, TranslationProcessor translationProcessor, CoroutineContext coroutineContext, int i) {
        return new Pipeline(languageSpecFactory, translationProcessor, coroutineContext, i);
    }
}
