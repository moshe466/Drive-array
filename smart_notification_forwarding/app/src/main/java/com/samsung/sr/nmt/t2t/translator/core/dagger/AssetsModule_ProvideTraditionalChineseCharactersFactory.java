package com.samsung.sr.nmt.t2t.translator.core.dagger;

import com.samsung.sr.nmt.t2t.translator.core.utils.AssetLoader;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.Set;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class AssetsModule_ProvideTraditionalChineseCharactersFactory implements Factory<Set<String>> {
    private final Provider<AssetLoader> assetLoaderProvider;
    private final AssetsModule module;

    public AssetsModule_ProvideTraditionalChineseCharactersFactory(AssetsModule assetsModule, Provider<AssetLoader> provider) {
        this.module = assetsModule;
        this.assetLoaderProvider = provider;
    }

    @Override // javax.inject.Provider
    public Set<String> get() {
        return provideTraditionalChineseCharacters(this.module, this.assetLoaderProvider.get());
    }

    public static AssetsModule_ProvideTraditionalChineseCharactersFactory create(AssetsModule assetsModule, Provider<AssetLoader> provider) {
        return new AssetsModule_ProvideTraditionalChineseCharactersFactory(assetsModule, provider);
    }

    public static Set<String> provideTraditionalChineseCharacters(AssetsModule assetsModule, AssetLoader assetLoader) {
        return (Set) Preconditions.checkNotNullFromProvides(assetsModule.provideTraditionalChineseCharacters(assetLoader));
    }
}
