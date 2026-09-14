package com.samsung.sr.nmt.t2t.translator.core.dagger;

import com.samsung.sr.nmt.t2t.translator.core.pipeline.splitter.SplitRule;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.Set;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class SplitRuleModule_ProvideEUSentenceSplitRuleFactory implements Factory<SplitRule> {
    private final Provider<Set<String>> abbreviationsProvider;
    private final SplitRuleModule module;

    public SplitRuleModule_ProvideEUSentenceSplitRuleFactory(SplitRuleModule splitRuleModule, Provider<Set<String>> provider) {
        this.module = splitRuleModule;
        this.abbreviationsProvider = provider;
    }

    @Override // javax.inject.Provider
    public SplitRule get() {
        return provideEUSentenceSplitRule(this.module, this.abbreviationsProvider.get());
    }

    public static SplitRuleModule_ProvideEUSentenceSplitRuleFactory create(SplitRuleModule splitRuleModule, Provider<Set<String>> provider) {
        return new SplitRuleModule_ProvideEUSentenceSplitRuleFactory(splitRuleModule, provider);
    }

    public static SplitRule provideEUSentenceSplitRule(SplitRuleModule splitRuleModule, Set<String> set) {
        return (SplitRule) Preconditions.checkNotNullFromProvides(splitRuleModule.provideEUSentenceSplitRule(set));
    }
}
