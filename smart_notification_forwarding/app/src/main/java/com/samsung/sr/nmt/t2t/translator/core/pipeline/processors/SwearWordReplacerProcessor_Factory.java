package com.samsung.sr.nmt.t2t.translator.core.pipeline.processors;

import com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.LanguageDirectionManager;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.swearword.SwearWordReplacer;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class SwearWordReplacerProcessor_Factory implements Factory<SwearWordReplacerProcessor> {
    private final Provider<LanguageDirectionManager> languageDirectionManagerProvider;
    private final Provider<SwearWordReplacer> swearWordReplacerProvider;

    public SwearWordReplacerProcessor_Factory(Provider<SwearWordReplacer> provider, Provider<LanguageDirectionManager> provider2) {
        this.swearWordReplacerProvider = provider;
        this.languageDirectionManagerProvider = provider2;
    }

    @Override // javax.inject.Provider
    public SwearWordReplacerProcessor get() {
        return newInstance(this.swearWordReplacerProvider.get(), this.languageDirectionManagerProvider.get());
    }

    public static SwearWordReplacerProcessor_Factory create(Provider<SwearWordReplacer> provider, Provider<LanguageDirectionManager> provider2) {
        return new SwearWordReplacerProcessor_Factory(provider, provider2);
    }

    public static SwearWordReplacerProcessor newInstance(SwearWordReplacer swearWordReplacer, LanguageDirectionManager languageDirectionManager) {
        return new SwearWordReplacerProcessor(swearWordReplacer, languageDirectionManager);
    }
}
