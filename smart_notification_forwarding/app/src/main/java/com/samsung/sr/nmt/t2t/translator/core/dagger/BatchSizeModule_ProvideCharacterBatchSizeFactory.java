package com.samsung.sr.nmt.t2t.translator.core.dagger;

import dagger.internal.Factory;

/* loaded from: classes.dex */
public final class BatchSizeModule_ProvideCharacterBatchSizeFactory implements Factory<Integer> {
    private final BatchSizeModule module;

    public BatchSizeModule_ProvideCharacterBatchSizeFactory(BatchSizeModule batchSizeModule) {
        this.module = batchSizeModule;
    }

    @Override // javax.inject.Provider
    public Integer get() {
        return Integer.valueOf(provideCharacterBatchSize(this.module));
    }

    public static BatchSizeModule_ProvideCharacterBatchSizeFactory create(BatchSizeModule batchSizeModule) {
        return new BatchSizeModule_ProvideCharacterBatchSizeFactory(batchSizeModule);
    }

    public static int provideCharacterBatchSize(BatchSizeModule batchSizeModule) {
        return batchSizeModule.getCharacterBatchSize();
    }
}
