package com.samsung.sr.nmt.t2t.translator.core.dagger;

import com.samsung.sr.nmt.t2t.translator.core.dataclass.TranslatorModuleBuilderParams;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.Pipeline;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.TranslationProcessor;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.spec.LanguageSpecFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.coroutines.CoroutineContext;

/* loaded from: classes.dex */
public final class PipelineModule_EnvironmentHelperFactory implements Factory<Pipeline> {
    private final Provider<CoroutineContext> computationContextProvider;
    private final Provider<LanguageSpecFactory> languageSpecFactoryProvider;
    private final PipelineModule module;
    private final Provider<TranslationProcessor> translationProcessorProvider;
    private final Provider<TranslatorModuleBuilderParams> translatorModuleBuilderParamsProvider;

    public PipelineModule_EnvironmentHelperFactory(PipelineModule pipelineModule, Provider<LanguageSpecFactory> provider, Provider<TranslationProcessor> provider2, Provider<CoroutineContext> provider3, Provider<TranslatorModuleBuilderParams> provider4) {
        this.module = pipelineModule;
        this.languageSpecFactoryProvider = provider;
        this.translationProcessorProvider = provider2;
        this.computationContextProvider = provider3;
        this.translatorModuleBuilderParamsProvider = provider4;
    }

    @Override // javax.inject.Provider
    public Pipeline get() {
        return environmentHelper(this.module, this.languageSpecFactoryProvider.get(), this.translationProcessorProvider.get(), this.computationContextProvider.get(), this.translatorModuleBuilderParamsProvider.get());
    }

    public static PipelineModule_EnvironmentHelperFactory create(PipelineModule pipelineModule, Provider<LanguageSpecFactory> provider, Provider<TranslationProcessor> provider2, Provider<CoroutineContext> provider3, Provider<TranslatorModuleBuilderParams> provider4) {
        return new PipelineModule_EnvironmentHelperFactory(pipelineModule, provider, provider2, provider3, provider4);
    }

    public static Pipeline environmentHelper(PipelineModule pipelineModule, LanguageSpecFactory languageSpecFactory, TranslationProcessor translationProcessor, CoroutineContext coroutineContext, TranslatorModuleBuilderParams translatorModuleBuilderParams) {
        return (Pipeline) Preconditions.checkNotNullFromProvides(pipelineModule.environmentHelper(languageSpecFactory, translationProcessor, coroutineContext, translatorModuleBuilderParams));
    }
}
