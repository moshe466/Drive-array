package com.samsung.sr.nmt.t2t.translator.core.dagger;

import com.samsung.sr.nmt.t2t.translator.core.utils.AssetLoader;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.Set;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class AssetsModule_ProvideEnglishDictionaryFactory implements Factory<Set<String>> {
    private final Provider<AssetLoader> assetLoaderProvider;
    private final AssetsModule module;

    public AssetsModule_ProvideEnglishDictionaryFactory(AssetsModule assetsModule, Provider<AssetLoader> provider) {
        this.module = assetsModule;
        this.assetLoaderProvider = provider;
    }

    @Override // javax.inject.Provider
    public Set<String> get() {
        return provideEnglishDictionary(this.module, this.assetLoaderProvider.get());
    }

    public static AssetsModule_ProvideEnglishDictionaryFactory create(AssetsModule assetsModule, Provider<AssetLoader> provider) {
        return new AssetsModule_ProvideEnglishDictionaryFactory(assetsModule, provider);
    }

    public static Set<String> provideEnglishDictionary(AssetsModule assetsModule, AssetLoader assetLoader) {
        return (Set) Preconditions.checkNotNullFromProvides(assetsModule.provideEnglishDictionary(assetLoader));
    }
}
