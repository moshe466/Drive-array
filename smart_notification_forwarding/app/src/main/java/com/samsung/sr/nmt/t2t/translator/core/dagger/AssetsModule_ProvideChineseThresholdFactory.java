package com.samsung.sr.nmt.t2t.translator.core.dagger;

import dagger.internal.Factory;

/* loaded from: classes.dex */
public final class AssetsModule_ProvideChineseThresholdFactory implements Factory<Integer> {
    private final AssetsModule module;

    public AssetsModule_ProvideChineseThresholdFactory(AssetsModule assetsModule) {
        this.module = assetsModule;
    }

    @Override // javax.inject.Provider
    public Integer get() {
        return Integer.valueOf(provideChineseThreshold(this.module));
    }

    public static AssetsModule_ProvideChineseThresholdFactory create(AssetsModule assetsModule) {
        return new AssetsModule_ProvideChineseThresholdFactory(assetsModule);
    }

    public static int provideChineseThreshold(AssetsModule assetsModule) {
        return assetsModule.provideChineseThreshold();
    }
}
