package com.samsung.sr.nmt.t2t.translator.core.dagger;

import com.samsung.sr.nmt.t2t.translator.core.utils.AssetLoader;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class TaggedSupportingInfoFactory_Factory implements Factory<TaggedSupportingInfoFactory> {
    private final Provider<AssetLoader> assetLoaderProvider;

    public TaggedSupportingInfoFactory_Factory(Provider<AssetLoader> provider) {
        this.assetLoaderProvider = provider;
    }

    @Override // javax.inject.Provider
    public TaggedSupportingInfoFactory get() {
        return newInstance(this.assetLoaderProvider.get());
    }

    public static TaggedSupportingInfoFactory_Factory create(Provider<AssetLoader> provider) {
        return new TaggedSupportingInfoFactory_Factory(provider);
    }

    public static TaggedSupportingInfoFactory newInstance(AssetLoader assetLoader) {
        return new TaggedSupportingInfoFactory(assetLoader);
    }
}
