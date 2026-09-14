package com.samsung.sr.nmt.t2t.translator.core.dagger;

import com.samsung.sr.nmt.t2t.translator.core.utils.ActiveLanguageCodeChecker;
import com.samsung.sr.nmt.t2t.translator.core.utils.AssetLoader;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class TranslatorSpecFactory_Factory implements Factory<TranslatorSpecFactory> {
    private final Provider<ActiveLanguageCodeChecker> activeLanguageCodeCheckerProvider;
    private final Provider<AssetLoader> assetLoaderProvider;

    public TranslatorSpecFactory_Factory(Provider<AssetLoader> provider, Provider<ActiveLanguageCodeChecker> provider2) {
        this.assetLoaderProvider = provider;
        this.activeLanguageCodeCheckerProvider = provider2;
    }

    @Override // javax.inject.Provider
    public TranslatorSpecFactory get() {
        return newInstance(this.assetLoaderProvider.get(), this.activeLanguageCodeCheckerProvider.get());
    }

    public static TranslatorSpecFactory_Factory create(Provider<AssetLoader> provider, Provider<ActiveLanguageCodeChecker> provider2) {
        return new TranslatorSpecFactory_Factory(provider, provider2);
    }

    public static TranslatorSpecFactory newInstance(AssetLoader assetLoader, ActiveLanguageCodeChecker activeLanguageCodeChecker) {
        return new TranslatorSpecFactory(assetLoader, activeLanguageCodeChecker);
    }
}
