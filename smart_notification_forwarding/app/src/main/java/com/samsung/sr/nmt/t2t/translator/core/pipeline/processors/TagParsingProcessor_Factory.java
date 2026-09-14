package com.samsung.sr.nmt.t2t.translator.core.pipeline.processors;

import com.samsung.sr.nmt.t2t.translator.core.pipeline.symbols.SymbolRegex;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class TagParsingProcessor_Factory implements Factory<TagParsingProcessor> {
    private final Provider<SymbolRegex> unpairedTagsRegexProvider;

    public TagParsingProcessor_Factory(Provider<SymbolRegex> provider) {
        this.unpairedTagsRegexProvider = provider;
    }

    @Override // javax.inject.Provider
    public TagParsingProcessor get() {
        return newInstance(this.unpairedTagsRegexProvider.get());
    }

    public static TagParsingProcessor_Factory create(Provider<SymbolRegex> provider) {
        return new TagParsingProcessor_Factory(provider);
    }

    public static TagParsingProcessor newInstance(SymbolRegex symbolRegex) {
        return new TagParsingProcessor(symbolRegex);
    }
}
