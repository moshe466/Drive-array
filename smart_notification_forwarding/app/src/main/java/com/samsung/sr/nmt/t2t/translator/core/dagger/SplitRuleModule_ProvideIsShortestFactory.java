package com.samsung.sr.nmt.t2t.translator.core.dagger;

import dagger.internal.Factory;

/* loaded from: classes.dex */
public final class SplitRuleModule_ProvideIsShortestFactory implements Factory<Boolean> {
    private final SplitRuleModule module;

    public SplitRuleModule_ProvideIsShortestFactory(SplitRuleModule splitRuleModule) {
        this.module = splitRuleModule;
    }

    @Override // javax.inject.Provider
    public Boolean get() {
        return Boolean.valueOf(provideIsShortest(this.module));
    }

    public static SplitRuleModule_ProvideIsShortestFactory create(SplitRuleModule splitRuleModule) {
        return new SplitRuleModule_ProvideIsShortestFactory(splitRuleModule);
    }

    public static boolean provideIsShortest(SplitRuleModule splitRuleModule) {
        return splitRuleModule.provideIsShortest();
    }
}
