package com.samsung.sr.nmt.t2t.translator.core.dagger;

import com.samsung.sr.nmt.t2t.translator.core.pipeline.symbols.SymbolRegex;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* loaded from: classes.dex */
public final class SymbolRegexModule_ProvideUnpairedTagsRegexFactory implements Factory<SymbolRegex> {
    private final SymbolRegexModule module;

    public SymbolRegexModule_ProvideUnpairedTagsRegexFactory(SymbolRegexModule symbolRegexModule) {
        this.module = symbolRegexModule;
    }

    @Override // javax.inject.Provider
    public SymbolRegex get() {
        return provideUnpairedTagsRegex(this.module);
    }

    public static SymbolRegexModule_ProvideUnpairedTagsRegexFactory create(SymbolRegexModule symbolRegexModule) {
        return new SymbolRegexModule_ProvideUnpairedTagsRegexFactory(symbolRegexModule);
    }

    public static SymbolRegex provideUnpairedTagsRegex(SymbolRegexModule symbolRegexModule) {
        return (SymbolRegex) Preconditions.checkNotNullFromProvides(symbolRegexModule.provideUnpairedTagsRegex());
    }
}
