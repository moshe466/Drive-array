package com.samsung.sr.nmt.t2t.translator.core.dagger;

import dagger.internal.Factory;

/* loaded from: classes.dex */
public final class BatchSizeModule_ProvideTokenBatchSizeFactory implements Factory<Integer> {
    private final BatchSizeModule module;

    public BatchSizeModule_ProvideTokenBatchSizeFactory(BatchSizeModule batchSizeModule) {
        this.module = batchSizeModule;
    }

    @Override // javax.inject.Provider
    public Integer get() {
        return Integer.valueOf(provideTokenBatchSize(this.module));
    }

    public static BatchSizeModule_ProvideTokenBatchSizeFactory create(BatchSizeModule batchSizeModule) {
        return new BatchSizeModule_ProvideTokenBatchSizeFactory(batchSizeModule);
    }

    public static int provideTokenBatchSize(BatchSizeModule batchSizeModule) {
        return batchSizeModule.getTokenBatchSize();
    }
}
