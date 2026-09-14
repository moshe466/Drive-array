package com.samsung.sr.nmt.t2t.translator.core.dagger;

import com.samsung.sr.nmt.t2t.translator.core.utils.AssetLoader;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.Map;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class AssetsModule_ProvideLanguageDetectorDictionaryFactory implements Factory<Map<String, String>> {
    private final Provider<AssetLoader> assetLoaderProvider;
    private final AssetsModule module;

    public AssetsModule_ProvideLanguageDetectorDictionaryFactory(AssetsModule assetsModule, Provider<AssetLoader> provider) {
        this.module = assetsModule;
        this.assetLoaderProvider = provider;
    }

    @Override // javax.inject.Provider
    public Map<String, String> get() {
        return provideLanguageDetectorDictionary(this.module, this.assetLoaderProvider.get());
    }

    public static AssetsModule_ProvideLanguageDetectorDictionaryFactory create(AssetsModule assetsModule, Provider<AssetLoader> provider) {
        return new AssetsModule_ProvideLanguageDetectorDictionaryFactory(assetsModule, provider);
    }

    public static Map<String, String> provideLanguageDetectorDictionary(AssetsModule assetsModule, AssetLoader assetLoader) {
        return (Map) Preconditions.checkNotNullFromProvides(assetsModule.provideLanguageDetectorDictionary(assetLoader));
    }
}
