package com.samsung.sr.nmt.t2t.translator.core.dagger;

import com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.Processor;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* loaded from: classes.dex */
public final class PlaceholderModule_GetPlaceholderPostProcessorFactory implements Factory<Processor> {
    private final PlaceholderModule module;

    public PlaceholderModule_GetPlaceholderPostProcessorFactory(PlaceholderModule placeholderModule) {
        this.module = placeholderModule;
    }

    @Override // javax.inject.Provider
    public Processor get() {
        return getPlaceholderPostProcessor(this.module);
    }

    public static PlaceholderModule_GetPlaceholderPostProcessorFactory create(PlaceholderModule placeholderModule) {
        return new PlaceholderModule_GetPlaceholderPostProcessorFactory(placeholderModule);
    }

    public static Processor getPlaceholderPostProcessor(PlaceholderModule placeholderModule) {
        return (Processor) Preconditions.checkNotNullFromProvides(placeholderModule.getPlaceholderPostProcessor());
    }
}
