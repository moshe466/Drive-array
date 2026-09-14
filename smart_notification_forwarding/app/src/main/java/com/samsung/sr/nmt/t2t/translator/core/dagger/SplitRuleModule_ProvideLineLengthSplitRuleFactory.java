package com.samsung.sr.nmt.t2t.translator.core.dagger;

import com.samsung.sr.nmt.t2t.translator.core.pipeline.splitter.SplitRule;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* loaded from: classes.dex */
public final class SplitRuleModule_ProvideLineLengthSplitRuleFactory implements Factory<SplitRule> {
    private final SplitRuleModule module;

    public SplitRuleModule_ProvideLineLengthSplitRuleFactory(SplitRuleModule splitRuleModule) {
        this.module = splitRuleModule;
    }

    @Override // javax.inject.Provider
    public SplitRule get() {
        return provideLineLengthSplitRule(this.module);
    }

    public static SplitRuleModule_ProvideLineLengthSplitRuleFactory create(SplitRuleModule splitRuleModule) {
        return new SplitRuleModule_ProvideLineLengthSplitRuleFactory(splitRuleModule);
    }

    public static SplitRule provideLineLengthSplitRule(SplitRuleModule splitRuleModule) {
        return (SplitRule) Preconditions.checkNotNullFromProvides(splitRuleModule.provideLineLengthSplitRule());
    }
}
