package com.samsung.sr.nmt.t2t.translator.core.dagger;

import com.samsung.sr.nmt.t2t.translator.core.pipeline.symbols.SymbolRegex;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* loaded from: classes.dex */
public final class SymbolRegexModule_ProvideRejectionSymbolRegexFactory implements Factory<SymbolRegex> {
    private final SymbolRegexModule module;

    public SymbolRegexModule_ProvideRejectionSymbolRegexFactory(SymbolRegexModule symbolRegexModule) {
        this.module = symbolRegexModule;
    }

    @Override // javax.inject.Provider
    public SymbolRegex get() {
        return provideRejectionSymbolRegex(this.module);
    }

    public static SymbolRegexModule_ProvideRejectionSymbolRegexFactory create(SymbolRegexModule symbolRegexModule) {
        return new SymbolRegexModule_ProvideRejectionSymbolRegexFactory(symbolRegexModule);
    }

    public static SymbolRegex provideRejectionSymbolRegex(SymbolRegexModule symbolRegexModule) {
        return (SymbolRegex) Preconditions.checkNotNullFromProvides(symbolRegexModule.provideRejectionSymbolRegex());
    }
}
