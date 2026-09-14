package com.samsung.sr.nmt.t2t.translator.core.pipeline.replacepair;

import com.samsung.sr.nmt.t2t.translator.core.pipeline.loader.CustomReplacePairLoader;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class CustomReplacePairHandler_Factory implements Factory<CustomReplacePairHandler> {
    private final Provider<CustomReplacePairLoader> customReplacePairLoaderProvider;

    public CustomReplacePairHandler_Factory(Provider<CustomReplacePairLoader> provider) {
        this.customReplacePairLoaderProvider = provider;
    }

    @Override // javax.inject.Provider
    public CustomReplacePairHandler get() {
        return newInstance(this.customReplacePairLoaderProvider.get());
    }

    public static CustomReplacePairHandler_Factory create(Provider<CustomReplacePairLoader> provider) {
        return new CustomReplacePairHandler_Factory(provider);
    }

    public static CustomReplacePairHandler newInstance(CustomReplacePairLoader customReplacePairLoader) {
        return new CustomReplacePairHandler(customReplacePairLoader);
    }
}
