package com.samsung.sr.nmt.t2t.translator.core.pipeline.processors;

import com.samsung.sr.nmt.t2t.translator.core.pipeline.splitter.SplitterManager;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class SentenceSplitterProcessor_Factory implements Factory<SentenceSplitterProcessor> {
    private final Provider<SplitterManager> splitterManagerProvider;

    public SentenceSplitterProcessor_Factory(Provider<SplitterManager> provider) {
        this.splitterManagerProvider = provider;
    }

    @Override // javax.inject.Provider
    public SentenceSplitterProcessor get() {
        return newInstance(this.splitterManagerProvider.get());
    }

    public static SentenceSplitterProcessor_Factory create(Provider<SplitterManager> provider) {
        return new SentenceSplitterProcessor_Factory(provider);
    }

    public static SentenceSplitterProcessor newInstance(SplitterManager splitterManager) {
        return new SentenceSplitterProcessor(splitterManager);
    }
}
