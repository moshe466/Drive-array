package com.samsung.sr.nmt.t2t.translator.core;

import com.samsung.sr.nmt.t2t.translator.core.pipeline.splitter.SplitterManager;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class SegmentationServiceImpl_Factory implements Factory<SegmentationServiceImpl> {
    private final Provider<SplitterManager> splitterManagerProvider;

    public SegmentationServiceImpl_Factory(Provider<SplitterManager> provider) {
        this.splitterManagerProvider = provider;
    }

    @Override // javax.inject.Provider
    public SegmentationServiceImpl get() {
        return newInstance(this.splitterManagerProvider.get());
    }

    public static SegmentationServiceImpl_Factory create(Provider<SplitterManager> provider) {
        return new SegmentationServiceImpl_Factory(provider);
    }

    public static SegmentationServiceImpl newInstance(SplitterManager splitterManager) {
        return new SegmentationServiceImpl(splitterManager);
    }
}
