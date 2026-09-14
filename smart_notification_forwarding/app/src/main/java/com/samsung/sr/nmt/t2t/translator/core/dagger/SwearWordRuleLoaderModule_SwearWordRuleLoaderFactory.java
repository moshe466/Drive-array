package com.samsung.sr.nmt.t2t.translator.core.dagger;

import com.samsung.sr.nmt.t2t.translator.core.pipeline.loader.SwearWordRuleLoader;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* loaded from: classes.dex */
public final class SwearWordRuleLoaderModule_SwearWordRuleLoaderFactory implements Factory<SwearWordRuleLoader> {
    private final SwearWordRuleLoaderModule module;

    public SwearWordRuleLoaderModule_SwearWordRuleLoaderFactory(SwearWordRuleLoaderModule swearWordRuleLoaderModule) {
        this.module = swearWordRuleLoaderModule;
    }

    @Override // javax.inject.Provider
    public SwearWordRuleLoader get() {
        return swearWordRuleLoader(this.module);
    }

    public static SwearWordRuleLoaderModule_SwearWordRuleLoaderFactory create(SwearWordRuleLoaderModule swearWordRuleLoaderModule) {
        return new SwearWordRuleLoaderModule_SwearWordRuleLoaderFactory(swearWordRuleLoaderModule);
    }

    public static SwearWordRuleLoader swearWordRuleLoader(SwearWordRuleLoaderModule swearWordRuleLoaderModule) {
        return (SwearWordRuleLoader) Preconditions.checkNotNullFromProvides(swearWordRuleLoaderModule.getSwearWordRuleLoader());
    }
}
