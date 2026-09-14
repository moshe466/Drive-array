package com.samsung.sr.nmt.t2t.translator.core.dagger;

import com.samsung.sr.nmt.t2t.translator.core.pipeline.recaser.RecaseRule;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* loaded from: classes.dex */
public final class RecaseRuleModule_ProvideAllUppercaseWithWhitespacesRuleFactory implements Factory<RecaseRule> {
    private final RecaseRuleModule module;

    public RecaseRuleModule_ProvideAllUppercaseWithWhitespacesRuleFactory(RecaseRuleModule recaseRuleModule) {
        this.module = recaseRuleModule;
    }

    @Override // javax.inject.Provider
    public RecaseRule get() {
        return provideAllUppercaseWithWhitespacesRule(this.module);
    }

    public static RecaseRuleModule_ProvideAllUppercaseWithWhitespacesRuleFactory create(RecaseRuleModule recaseRuleModule) {
        return new RecaseRuleModule_ProvideAllUppercaseWithWhitespacesRuleFactory(recaseRuleModule);
    }

    public static RecaseRule provideAllUppercaseWithWhitespacesRule(RecaseRuleModule recaseRuleModule) {
        return (RecaseRule) Preconditions.checkNotNullFromProvides(recaseRuleModule.provideAllUppercaseWithWhitespacesRule());
    }
}
