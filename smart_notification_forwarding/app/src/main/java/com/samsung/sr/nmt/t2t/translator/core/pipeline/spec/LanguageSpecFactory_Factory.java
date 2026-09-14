package com.samsung.sr.nmt.t2t.translator.core.pipeline.spec;

import dagger.internal.Factory;
import java.util.Map;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class LanguageSpecFactory_Factory implements Factory<LanguageSpecFactory> {
    private final Provider<Map<String, Provider<LanguageSpec>>> languageSpecMapProvider;

    public LanguageSpecFactory_Factory(Provider<Map<String, Provider<LanguageSpec>>> provider) {
        this.languageSpecMapProvider = provider;
    }

    @Override // javax.inject.Provider
    public LanguageSpecFactory get() {
        return newInstance(this.languageSpecMapProvider.get());
    }

    public static LanguageSpecFactory_Factory create(Provider<Map<String, Provider<LanguageSpec>>> provider) {
        return new LanguageSpecFactory_Factory(provider);
    }

    public static LanguageSpecFactory newInstance(Map<String, Provider<LanguageSpec>> map) {
        return new LanguageSpecFactory(map);
    }
}
