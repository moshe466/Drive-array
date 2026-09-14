package com.samsung.sr.nmt.t2t.translator.core.languagedetector.preprocessor;

import com.samsung.sr.nmt.t2t.translator.core.pipeline.symbols.SymbolRegex;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class SymbolFilteringProcessor_Factory implements Factory<SymbolFilteringProcessor> {
    private final Provider<SymbolRegex> placeholderSymbolsProvider;

    public SymbolFilteringProcessor_Factory(Provider<SymbolRegex> provider) {
        this.placeholderSymbolsProvider = provider;
    }

    @Override // javax.inject.Provider
    public SymbolFilteringProcessor get() {
        return newInstance(this.placeholderSymbolsProvider.get());
    }

    public static SymbolFilteringProcessor_Factory create(Provider<SymbolRegex> provider) {
        return new SymbolFilteringProcessor_Factory(provider);
    }

    public static SymbolFilteringProcessor newInstance(SymbolRegex symbolRegex) {
        return new SymbolFilteringProcessor(symbolRegex);
    }
}
