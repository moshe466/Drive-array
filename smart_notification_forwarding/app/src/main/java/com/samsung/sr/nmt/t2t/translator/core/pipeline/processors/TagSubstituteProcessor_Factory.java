package com.samsung.sr.nmt.t2t.translator.core.pipeline.processors;

import com.samsung.sr.nmt.t2t.translator.core.pipeline.splitter.SplitRule;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.symbols.SymbolRegex;
import dagger.internal.Factory;
import java.util.Map;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class TagSubstituteProcessor_Factory implements Factory<TagSubstituteProcessor> {
    private final Provider<Map<Class<?>, SplitRule>> splitterRuleMapProvider;
    private final Provider<SymbolRegex> unpairedTagsRegexProvider;

    public TagSubstituteProcessor_Factory(Provider<Map<Class<?>, SplitRule>> provider, Provider<SymbolRegex> provider2) {
        this.splitterRuleMapProvider = provider;
        this.unpairedTagsRegexProvider = provider2;
    }

    @Override // javax.inject.Provider
    public TagSubstituteProcessor get() {
        return newInstance(this.splitterRuleMapProvider.get(), this.unpairedTagsRegexProvider.get());
    }

    public static TagSubstituteProcessor_Factory create(Provider<Map<Class<?>, SplitRule>> provider, Provider<SymbolRegex> provider2) {
        return new TagSubstituteProcessor_Factory(provider, provider2);
    }

    public static TagSubstituteProcessor newInstance(Map<Class<?>, SplitRule> map, SymbolRegex symbolRegex) {
        return new TagSubstituteProcessor(map, symbolRegex);
    }
}
