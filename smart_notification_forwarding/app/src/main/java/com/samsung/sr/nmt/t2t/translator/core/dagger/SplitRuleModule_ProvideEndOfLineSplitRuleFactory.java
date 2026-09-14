package com.samsung.sr.nmt.t2t.translator.core.dagger;

import com.samsung.sr.nmt.t2t.translator.core.pipeline.splitter.SplitRule;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* loaded from: classes.dex */
public final class SplitRuleModule_ProvideEndOfLineSplitRuleFactory implements Factory<SplitRule> {
    private final SplitRuleModule module;

    public SplitRuleModule_ProvideEndOfLineSplitRuleFactory(SplitRuleModule splitRuleModule) {
        this.module = splitRuleModule;
    }

    @Override // javax.inject.Provider
    public SplitRule get() {
        return provideEndOfLineSplitRule(this.module);
    }

    public static SplitRuleModule_ProvideEndOfLineSplitRuleFactory create(SplitRuleModule splitRuleModule) {
        return new SplitRuleModule_ProvideEndOfLineSplitRuleFactory(splitRuleModule);
    }

    public static SplitRule provideEndOfLineSplitRule(SplitRuleModule splitRuleModule) {
        return (SplitRule) Preconditions.checkNotNullFromProvides(splitRuleModule.provideEndOfLineSplitRule());
    }
}
