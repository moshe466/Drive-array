package com.samsung.sr.nmt.t2t.translator.core.pipeline.engine;

import com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.model.ModelFactory;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.vocab.VocabFactory;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class EngineFactory_Factory implements Factory<EngineFactory> {
    private final Provider<ModelFactory> modelFactoryProvider;
    private final Provider<VocabFactory> vocabFactoryProvider;

    public EngineFactory_Factory(Provider<ModelFactory> provider, Provider<VocabFactory> provider2) {
        this.modelFactoryProvider = provider;
        this.vocabFactoryProvider = provider2;
    }

    @Override // javax.inject.Provider
    public EngineFactory get() {
        return newInstance(this.modelFactoryProvider.get(), this.vocabFactoryProvider.get());
    }

    public static EngineFactory_Factory create(Provider<ModelFactory> provider, Provider<VocabFactory> provider2) {
        return new EngineFactory_Factory(provider, provider2);
    }

    public static EngineFactory newInstance(ModelFactory modelFactory, VocabFactory vocabFactory) {
        return new EngineFactory(modelFactory, vocabFactory);
    }
}
