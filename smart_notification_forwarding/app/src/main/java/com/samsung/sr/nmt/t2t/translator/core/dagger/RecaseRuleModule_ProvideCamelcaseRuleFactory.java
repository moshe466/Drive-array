package com.samsung.sr.nmt.t2t.translator.core.dagger;

import com.samsung.sr.nmt.t2t.translator.core.pipeline.recaser.RecaseRule;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* loaded from: classes.dex */
public final class RecaseRuleModule_ProvideCamelcaseRuleFactory implements Factory<RecaseRule> {
    private final RecaseRuleModule module;

    public RecaseRuleModule_ProvideCamelcaseRuleFactory(RecaseRuleModule recaseRuleModule) {
        this.module = recaseRuleModule;
    }

    @Override // javax.inject.Provider
    public RecaseRule get() {
        return provideCamelcaseRule(this.module);
    }

    public static RecaseRuleModule_ProvideCamelcaseRuleFactory create(RecaseRuleModule recaseRuleModule) {
        return new RecaseRuleModule_ProvideCamelcaseRuleFactory(recaseRuleModule);
    }

    public static RecaseRule provideCamelcaseRule(RecaseRuleModule recaseRuleModule) {
        return (RecaseRule) Preconditions.checkNotNullFromProvides(recaseRuleModule.provideCamelcaseRule());
    }
}
