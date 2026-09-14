package com.samsung.sr.nmt.t2t.translator.core.dagger;

import com.samsung.sr.nmt.t2t.translator.core.utils.AssetLoader;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.Set;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class AssetsModule_ProvideAbbreviationsFactory implements Factory<Set<String>> {
    private final Provider<AssetLoader> assetLoaderProvider;
    private final AssetsModule module;

    public AssetsModule_ProvideAbbreviationsFactory(AssetsModule assetsModule, Provider<AssetLoader> provider) {
        this.module = assetsModule;
        this.assetLoaderProvider = provider;
    }

    @Override // javax.inject.Provider
    public Set<String> get() {
        return provideAbbreviations(this.module, this.assetLoaderProvider.get());
    }

    public static AssetsModule_ProvideAbbreviationsFactory create(AssetsModule assetsModule, Provider<AssetLoader> provider) {
        return new AssetsModule_ProvideAbbreviationsFactory(assetsModule, provider);
    }

    public static Set<String> provideAbbreviations(AssetsModule assetsModule, AssetLoader assetLoader) {
        return (Set) Preconditions.checkNotNullFromProvides(assetsModule.provideAbbreviations(assetLoader));
    }
}
