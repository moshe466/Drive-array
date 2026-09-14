package com.samsung.sr.nmt.t2t.translator.core.dagger;

import com.samsung.sr.nmt.t2t.translator.core.pipeline.recaser.RecaseRule;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* loaded from: classes.dex */
public final class RecaseRuleModule_ProvideFirstLetterUppercaseRuleFactory implements Factory<RecaseRule> {
    private final RecaseRuleModule module;

    public RecaseRuleModule_ProvideFirstLetterUppercaseRuleFactory(RecaseRuleModule recaseRuleModule) {
        this.module = recaseRuleModule;
    }

    @Override // javax.inject.Provider
    public RecaseRule get() {
        return provideFirstLetterUppercaseRule(this.module);
    }

    public static RecaseRuleModule_ProvideFirstLetterUppercaseRuleFactory create(RecaseRuleModule recaseRuleModule) {
        return new RecaseRuleModule_ProvideFirstLetterUppercaseRuleFactory(recaseRuleModule);
    }

    public static RecaseRule provideFirstLetterUppercaseRule(RecaseRuleModule recaseRuleModule) {
        return (RecaseRule) Preconditions.checkNotNullFromProvides(recaseRuleModule.provideFirstLetterUppercaseRule());
    }
}
