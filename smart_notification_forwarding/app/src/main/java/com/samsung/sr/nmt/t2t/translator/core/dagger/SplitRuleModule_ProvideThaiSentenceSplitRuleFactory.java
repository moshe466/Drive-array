package com.samsung.sr.nmt.t2t.translator.core.dagger;

import com.samsung.sr.nmt.t2t.translator.core.pipeline.splitter.SplitRule;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* loaded from: classes.dex */
public final class SplitRuleModule_ProvideThaiSentenceSplitRuleFactory implements Factory<SplitRule> {
    private final SplitRuleModule module;

    public SplitRuleModule_ProvideThaiSentenceSplitRuleFactory(SplitRuleModule splitRuleModule) {
        this.module = splitRuleModule;
    }

    @Override // javax.inject.Provider
    public SplitRule get() {
        return provideThaiSentenceSplitRule(this.module);
    }

    public static SplitRuleModule_ProvideThaiSentenceSplitRuleFactory create(SplitRuleModule splitRuleModule) {
        return new SplitRuleModule_ProvideThaiSentenceSplitRuleFactory(splitRuleModule);
    }

    public static SplitRule provideThaiSentenceSplitRule(SplitRuleModule splitRuleModule) {
        return (SplitRule) Preconditions.checkNotNullFromProvides(splitRuleModule.provideThaiSentenceSplitRule());
    }
}
