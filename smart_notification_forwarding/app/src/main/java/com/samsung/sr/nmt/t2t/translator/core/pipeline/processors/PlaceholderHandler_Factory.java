package com.samsung.sr.nmt.t2t.translator.core.pipeline.processors;

import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class PlaceholderHandler_Factory implements Factory<PlaceholderHandler> {
    private final Provider<Processor> placeholderPostProcessorProvider;
    private final Provider<Processor> placeholderPreProcessorProvider;

    public PlaceholderHandler_Factory(Provider<Processor> provider, Provider<Processor> provider2) {
        this.placeholderPreProcessorProvider = provider;
        this.placeholderPostProcessorProvider = provider2;
    }

    @Override // javax.inject.Provider
    public PlaceholderHandler get() {
        return newInstance(this.placeholderPreProcessorProvider.get(), this.placeholderPostProcessorProvider.get());
    }

    public static PlaceholderHandler_Factory create(Provider<Processor> provider, Provider<Processor> provider2) {
        return new PlaceholderHandler_Factory(provider, provider2);
    }

    public static PlaceholderHandler newInstance(Processor processor, Processor processor2) {
        return new PlaceholderHandler(processor, processor2);
    }
}
