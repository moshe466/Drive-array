package com.samsung.sr.nmt.t2t.translator.core.dagger;

import com.samsung.sr.nmt.t2t.translator.core.pipeline.recaser.RecaseRule;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* loaded from: classes.dex */
public final class RecaseRuleModule_ProvideAllUppercaseRuleFactory implements Factory<RecaseRule> {
    private final RecaseRuleModule module;

    public RecaseRuleModule_ProvideAllUppercaseRuleFactory(RecaseRuleModule recaseRuleModule) {
        this.module = recaseRuleModule;
    }

    @Override // javax.inject.Provider
    public RecaseRule get() {
        return provideAllUppercaseRule(this.module);
    }

    public static RecaseRuleModule_ProvideAllUppercaseRuleFactory create(RecaseRuleModule recaseRuleModule) {
        return new RecaseRuleModule_ProvideAllUppercaseRuleFactory(recaseRuleModule);
    }

    public static RecaseRule provideAllUppercaseRule(RecaseRuleModule recaseRuleModule) {
        return (RecaseRule) Preconditions.checkNotNullFromProvides(recaseRuleModule.provideAllUppercaseRule());
    }
}
