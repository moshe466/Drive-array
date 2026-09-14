package com.samsung.sr.nmt.t2t.translator.core.pipeline.replacepair;

import com.samsung.sr.nmt.t2t.translator.core.pipeline.loader.ReplacePairLoader;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class ReplacePairHandler_Factory implements Factory<ReplacePairHandler> {
    private final Provider<ReplacePairLoader> replacePairLoaderProvider;
    private final Provider<ReplacePairUnit> replacePairUnitProvider;

    public ReplacePairHandler_Factory(Provider<ReplacePairLoader> provider, Provider<ReplacePairUnit> provider2) {
        this.replacePairLoaderProvider = provider;
        this.replacePairUnitProvider = provider2;
    }

    @Override // javax.inject.Provider
    public ReplacePairHandler get() {
        return newInstance(this.replacePairLoaderProvider.get(), this.replacePairUnitProvider.get());
    }

    public static ReplacePairHandler_Factory create(Provider<ReplacePairLoader> provider, Provider<ReplacePairUnit> provider2) {
        return new ReplacePairHandler_Factory(provider, provider2);
    }

    public static ReplacePairHandler newInstance(ReplacePairLoader replacePairLoader, ReplacePairUnit replacePairUnit) {
        return new ReplacePairHandler(replacePairLoader, replacePairUnit);
    }
}
