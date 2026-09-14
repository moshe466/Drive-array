package com.samsung.sr.nmt.t2t.translator.core.pipeline.engine;

import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class EngineProvider_Factory implements Factory<EngineProvider> {
    private final Provider<EngineFactory> engineFactoryProvider;
    private final Provider<EngineSpecFactory> engineSpecFactoryProvider;
    private final Provider<LanguageDirectionManager> languageDirectionManagerProvider;

    public EngineProvider_Factory(Provider<EngineFactory> provider, Provider<EngineSpecFactory> provider2, Provider<LanguageDirectionManager> provider3) {
        this.engineFactoryProvider = provider;
        this.engineSpecFactoryProvider = provider2;
        this.languageDirectionManagerProvider = provider3;
    }

    @Override // javax.inject.Provider
    public EngineProvider get() {
        return newInstance(this.engineFactoryProvider.get(), this.engineSpecFactoryProvider.get(), this.languageDirectionManagerProvider.get());
    }

    public static EngineProvider_Factory create(Provider<EngineFactory> provider, Provider<EngineSpecFactory> provider2, Provider<LanguageDirectionManager> provider3) {
        return new EngineProvider_Factory(provider, provider2, provider3);
    }

    public static EngineProvider newInstance(EngineFactory engineFactory, EngineSpecFactory engineSpecFactory, LanguageDirectionManager languageDirectionManager) {
        return new EngineProvider(engineFactory, engineSpecFactory, languageDirectionManager);
    }
}
