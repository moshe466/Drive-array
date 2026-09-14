package com.samsung.sr.nmt.t2t.translator.core.dagger;

import com.samsung.sr.nmt.t2t.translator.core.pipeline.replacepair.CustomReplacePairHandler;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* loaded from: classes.dex */
public final class ReplacePairHandlerModule_ProvideCustomReplacePairHandlerFactory implements Factory<CustomReplacePairHandler> {
    private final ReplacePairHandlerModule module;

    public ReplacePairHandlerModule_ProvideCustomReplacePairHandlerFactory(ReplacePairHandlerModule replacePairHandlerModule) {
        this.module = replacePairHandlerModule;
    }

    @Override // javax.inject.Provider
    public CustomReplacePairHandler get() {
        return provideCustomReplacePairHandler(this.module);
    }

    public static ReplacePairHandlerModule_ProvideCustomReplacePairHandlerFactory create(ReplacePairHandlerModule replacePairHandlerModule) {
        return new ReplacePairHandlerModule_ProvideCustomReplacePairHandlerFactory(replacePairHandlerModule);
    }

    public static CustomReplacePairHandler provideCustomReplacePairHandler(ReplacePairHandlerModule replacePairHandlerModule) {
        return (CustomReplacePairHandler) Preconditions.checkNotNullFromProvides(replacePairHandlerModule.provideCustomReplacePairHandler());
    }
}
