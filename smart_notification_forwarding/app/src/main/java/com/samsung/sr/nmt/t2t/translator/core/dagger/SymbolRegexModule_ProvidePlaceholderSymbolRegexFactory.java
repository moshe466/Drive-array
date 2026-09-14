package com.samsung.sr.nmt.t2t.translator.core.dagger;

import com.samsung.sr.nmt.t2t.translator.core.pipeline.symbols.SymbolRegex;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* loaded from: classes.dex */
public final class SymbolRegexModule_ProvidePlaceholderSymbolRegexFactory implements Factory<SymbolRegex> {
    private final SymbolRegexModule module;

    public SymbolRegexModule_ProvidePlaceholderSymbolRegexFactory(SymbolRegexModule symbolRegexModule) {
        this.module = symbolRegexModule;
    }

    @Override // javax.inject.Provider
    public SymbolRegex get() {
        return providePlaceholderSymbolRegex(this.module);
    }

    public static SymbolRegexModule_ProvidePlaceholderSymbolRegexFactory create(SymbolRegexModule symbolRegexModule) {
        return new SymbolRegexModule_ProvidePlaceholderSymbolRegexFactory(symbolRegexModule);
    }

    public static SymbolRegex providePlaceholderSymbolRegex(SymbolRegexModule symbolRegexModule) {
        return (SymbolRegex) Preconditions.checkNotNullFromProvides(symbolRegexModule.providePlaceholderSymbolRegex());
    }
}
