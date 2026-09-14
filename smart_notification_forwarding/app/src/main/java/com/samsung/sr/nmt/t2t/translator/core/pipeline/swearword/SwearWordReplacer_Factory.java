package com.samsung.sr.nmt.t2t.translator.core.pipeline.swearword;

import com.samsung.sr.nmt.t2t.translator.core.pipeline.loader.SwearWordRuleLoader;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class SwearWordReplacer_Factory implements Factory<SwearWordReplacer> {
    private final Provider<SwearWordRuleLoader> swearWordRuleLoaderProvider;

    public SwearWordReplacer_Factory(Provider<SwearWordRuleLoader> provider) {
        this.swearWordRuleLoaderProvider = provider;
    }

    @Override // javax.inject.Provider
    public SwearWordReplacer get() {
        return newInstance(this.swearWordRuleLoaderProvider.get());
    }

    public static SwearWordReplacer_Factory create(Provider<SwearWordRuleLoader> provider) {
        return new SwearWordReplacer_Factory(provider);
    }

    public static SwearWordReplacer newInstance(SwearWordRuleLoader swearWordRuleLoader) {
        return new SwearWordReplacer(swearWordRuleLoader);
    }
}
