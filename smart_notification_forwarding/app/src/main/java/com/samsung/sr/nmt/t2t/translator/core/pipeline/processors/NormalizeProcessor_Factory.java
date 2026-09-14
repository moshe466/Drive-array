package com.samsung.sr.nmt.t2t.translator.core.pipeline.processors;

import com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.LanguageDirectionManager;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class NormalizeProcessor_Factory implements Factory<NormalizeProcessor> {
    private final Provider<LanguageDirectionManager> languageDirectionManagerProvider;

    public NormalizeProcessor_Factory(Provider<LanguageDirectionManager> provider) {
        this.languageDirectionManagerProvider = provider;
    }

    @Override // javax.inject.Provider
    public NormalizeProcessor get() {
        return newInstance(this.languageDirectionManagerProvider.get());
    }

    public static NormalizeProcessor_Factory create(Provider<LanguageDirectionManager> provider) {
        return new NormalizeProcessor_Factory(provider);
    }

    public static NormalizeProcessor newInstance(LanguageDirectionManager languageDirectionManager) {
        return new NormalizeProcessor(languageDirectionManager);
    }
}
