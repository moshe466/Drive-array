package com.samsung.sr.nmt.t2t.translator.core.dagger;

import com.samsung.sr.nmt.t2t.translator.core.pipeline.splitter.SplitRule;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.Set;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class SplitRuleModule_ProvideCharBasedSentenceSplitRuleFactory implements Factory<SplitRule> {
    private final Provider<Set<String>> abbreviationsProvider;
    private final Provider<Boolean> isShortestProvider;
    private final SplitRuleModule module;

    public SplitRuleModule_ProvideCharBasedSentenceSplitRuleFactory(SplitRuleModule splitRuleModule, Provider<Boolean> provider, Provider<Set<String>> provider2) {
        this.module = splitRuleModule;
        this.isShortestProvider = provider;
        this.abbreviationsProvider = provider2;
    }

    @Override // javax.inject.Provider
    public SplitRule get() {
        return provideCharBasedSentenceSplitRule(this.module, this.isShortestProvider.get().booleanValue(), this.abbreviationsProvider.get());
    }

    public static SplitRuleModule_ProvideCharBasedSentenceSplitRuleFactory create(SplitRuleModule splitRuleModule, Provider<Boolean> provider, Provider<Set<String>> provider2) {
        return new SplitRuleModule_ProvideCharBasedSentenceSplitRuleFactory(splitRuleModule, provider, provider2);
    }

    public static SplitRule provideCharBasedSentenceSplitRule(SplitRuleModule splitRuleModule, boolean z, Set<String> set) {
        return (SplitRule) Preconditions.checkNotNullFromProvides(splitRuleModule.provideCharBasedSentenceSplitRule(z, set));
    }
}
