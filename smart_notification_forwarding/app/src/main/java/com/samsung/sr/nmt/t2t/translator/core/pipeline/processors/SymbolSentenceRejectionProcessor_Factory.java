package com.samsung.sr.nmt.t2t.translator.core.pipeline.processors;

import com.samsung.sr.nmt.t2t.translator.core.pipeline.symbols.SymbolRegex;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class SymbolSentenceRejectionProcessor_Factory implements Factory<SymbolSentenceRejectionProcessor> {
    private final Provider<SymbolRegex> rejectionSymbolRegexProvider;

    public SymbolSentenceRejectionProcessor_Factory(Provider<SymbolRegex> provider) {
        this.rejectionSymbolRegexProvider = provider;
    }

    @Override // javax.inject.Provider
    public SymbolSentenceRejectionProcessor get() {
        return newInstance(this.rejectionSymbolRegexProvider.get());
    }

    public static SymbolSentenceRejectionProcessor_Factory create(Provider<SymbolRegex> provider) {
        return new SymbolSentenceRejectionProcessor_Factory(provider);
    }

    public static SymbolSentenceRejectionProcessor newInstance(SymbolRegex symbolRegex) {
        return new SymbolSentenceRejectionProcessor(symbolRegex);
    }
}
