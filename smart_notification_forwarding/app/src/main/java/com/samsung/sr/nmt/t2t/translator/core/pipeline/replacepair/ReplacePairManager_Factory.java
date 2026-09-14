package com.samsung.sr.nmt.t2t.translator.core.pipeline.replacepair;

import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class ReplacePairManager_Factory implements Factory<ReplacePairManager> {
    private final Provider<CustomReplacePairHandler> customReplacePairHandlerProvider;
    private final Provider<ReplacePairHandler> replacePairHandlerProvider;

    public ReplacePairManager_Factory(Provider<ReplacePairHandler> provider, Provider<CustomReplacePairHandler> provider2) {
        this.replacePairHandlerProvider = provider;
        this.customReplacePairHandlerProvider = provider2;
    }

    @Override // javax.inject.Provider
    public ReplacePairManager get() {
        return newInstance(this.replacePairHandlerProvider.get(), this.customReplacePairHandlerProvider.get());
    }

    public static ReplacePairManager_Factory create(Provider<ReplacePairHandler> provider, Provider<CustomReplacePairHandler> provider2) {
        return new ReplacePairManager_Factory(provider, provider2);
    }

    public static ReplacePairManager newInstance(ReplacePairHandler replacePairHandler, CustomReplacePairHandler customReplacePairHandler) {
        return new ReplacePairManager(replacePairHandler, customReplacePairHandler);
    }
}
