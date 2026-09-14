package com.samsung.sr.nmt.t2t.translator.core.dagger;

import com.samsung.sr.nmt.t2t.translator.core.utils.ActiveLanguageCodeChecker;
import com.samsung.sr.nmt.t2t.translator.core.utils.AssetLoader;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class ActiveLanguageCodeCheckerModule_ProvideLanguageCodeCheckerFactory implements Factory<ActiveLanguageCodeChecker> {
    private final Provider<AssetLoader> assetLoaderProvider;
    private final ActiveLanguageCodeCheckerModule module;

    public ActiveLanguageCodeCheckerModule_ProvideLanguageCodeCheckerFactory(ActiveLanguageCodeCheckerModule activeLanguageCodeCheckerModule, Provider<AssetLoader> provider) {
        this.module = activeLanguageCodeCheckerModule;
        this.assetLoaderProvider = provider;
    }

    @Override // javax.inject.Provider
    public ActiveLanguageCodeChecker get() {
        return provideLanguageCodeChecker(this.module, this.assetLoaderProvider.get());
    }

    public static ActiveLanguageCodeCheckerModule_ProvideLanguageCodeCheckerFactory create(ActiveLanguageCodeCheckerModule activeLanguageCodeCheckerModule, Provider<AssetLoader> provider) {
        return new ActiveLanguageCodeCheckerModule_ProvideLanguageCodeCheckerFactory(activeLanguageCodeCheckerModule, provider);
    }

    public static ActiveLanguageCodeChecker provideLanguageCodeChecker(ActiveLanguageCodeCheckerModule activeLanguageCodeCheckerModule, AssetLoader assetLoader) {
        return (ActiveLanguageCodeChecker) Preconditions.checkNotNullFromProvides(activeLanguageCodeCheckerModule.provideLanguageCodeChecker(assetLoader));
    }
}
