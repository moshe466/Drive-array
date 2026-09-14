package com.samsung.sr.nmt.t2t.translator.core.pipeline.spec;

import com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.Processor;
import dagger.internal.Factory;
import java.util.Map;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class TaggedEnSpec_Factory implements Factory<TaggedEnSpec> {
    private final Provider<Map<Class<?>, Provider<Processor>>> processorMapProvider;

    public TaggedEnSpec_Factory(Provider<Map<Class<?>, Provider<Processor>>> provider) {
        this.processorMapProvider = provider;
    }

    @Override // javax.inject.Provider
    public TaggedEnSpec get() {
        return newInstance(this.processorMapProvider.get());
    }

    public static TaggedEnSpec_Factory create(Provider<Map<Class<?>, Provider<Processor>>> provider) {
        return new TaggedEnSpec_Factory(provider);
    }

    public static TaggedEnSpec newInstance(Map<Class<?>, Provider<Processor>> map) {
        return new TaggedEnSpec(map);
    }
}
