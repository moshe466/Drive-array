package com.samsung.sr.nmt.t2t.translator.core.dagger;

import com.samsung.sr.nmt.t2t.translator.core.pipeline.replacepair.ReplacePairHandler;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* loaded from: classes.dex */
public final class ReplacePairHandlerModule_ProvideReplacePairHandlerFactory implements Factory<ReplacePairHandler> {
    private final ReplacePairHandlerModule module;

    public ReplacePairHandlerModule_ProvideReplacePairHandlerFactory(ReplacePairHandlerModule replacePairHandlerModule) {
        this.module = replacePairHandlerModule;
    }

    @Override // javax.inject.Provider
    public ReplacePairHandler get() {
        return provideReplacePairHandler(this.module);
    }

    public static ReplacePairHandlerModule_ProvideReplacePairHandlerFactory create(ReplacePairHandlerModule replacePairHandlerModule) {
        return new ReplacePairHandlerModule_ProvideReplacePairHandlerFactory(replacePairHandlerModule);
    }

    public static ReplacePairHandler provideReplacePairHandler(ReplacePairHandlerModule replacePairHandlerModule) {
        return (ReplacePairHandler) Preconditions.checkNotNullFromProvides(replacePairHandlerModule.provideReplacePairHandler());
    }
}
