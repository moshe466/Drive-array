package com.samsung.sr.nmt.t2t.translator.core.dagger;

import com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.Processor;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* loaded from: classes.dex */
public final class PlaceholderModule_GetPlaceholderPreProcessorFactory implements Factory<Processor> {
    private final PlaceholderModule module;

    public PlaceholderModule_GetPlaceholderPreProcessorFactory(PlaceholderModule placeholderModule) {
        this.module = placeholderModule;
    }

    @Override // javax.inject.Provider
    public Processor get() {
        return getPlaceholderPreProcessor(this.module);
    }

    public static PlaceholderModule_GetPlaceholderPreProcessorFactory create(PlaceholderModule placeholderModule) {
        return new PlaceholderModule_GetPlaceholderPreProcessorFactory(placeholderModule);
    }

    public static Processor getPlaceholderPreProcessor(PlaceholderModule placeholderModule) {
        return (Processor) Preconditions.checkNotNullFromProvides(placeholderModule.getPlaceholderPreProcessor());
    }
}
