package com.samsung.sr.nmt.t2t.translator.core.dagger;

import com.samsung.sr.nmt.t2t.translator.core.utils.AssetLoader;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* loaded from: classes.dex */
public final class AssetLoaderModule_AssetLoaderFactory implements Factory<AssetLoader> {
    private final AssetLoaderModule module;

    public AssetLoaderModule_AssetLoaderFactory(AssetLoaderModule assetLoaderModule) {
        this.module = assetLoaderModule;
    }

    @Override // javax.inject.Provider
    public AssetLoader get() {
        return assetLoader(this.module);
    }

    public static AssetLoaderModule_AssetLoaderFactory create(AssetLoaderModule assetLoaderModule) {
        return new AssetLoaderModule_AssetLoaderFactory(assetLoaderModule);
    }

    public static AssetLoader assetLoader(AssetLoaderModule assetLoaderModule) {
        return (AssetLoader) Preconditions.checkNotNullFromProvides(assetLoaderModule.getAssetLoader());
    }
}
