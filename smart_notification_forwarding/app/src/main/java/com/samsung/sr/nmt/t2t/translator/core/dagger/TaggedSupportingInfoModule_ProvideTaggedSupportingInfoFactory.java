package com.samsung.sr.nmt.t2t.translator.core.dagger;

import com.samsung.sr.nmt.t2t.translator.core.utils.LanguageDirection;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.Map;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class TaggedSupportingInfoModule_ProvideTaggedSupportingInfoFactory implements Factory<Map<LanguageDirection, String>> {
    private final TaggedSupportingInfoModule module;
    private final Provider<TaggedSupportingInfoFactory> taggedSupportingInfoFactoryProvider;

    public TaggedSupportingInfoModule_ProvideTaggedSupportingInfoFactory(TaggedSupportingInfoModule taggedSupportingInfoModule, Provider<TaggedSupportingInfoFactory> provider) {
        this.module = taggedSupportingInfoModule;
        this.taggedSupportingInfoFactoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public Map<LanguageDirection, String> get() {
        return provideTaggedSupportingInfo(this.module, this.taggedSupportingInfoFactoryProvider.get());
    }

    public static TaggedSupportingInfoModule_ProvideTaggedSupportingInfoFactory create(TaggedSupportingInfoModule taggedSupportingInfoModule, Provider<TaggedSupportingInfoFactory> provider) {
        return new TaggedSupportingInfoModule_ProvideTaggedSupportingInfoFactory(taggedSupportingInfoModule, provider);
    }

    public static Map<LanguageDirection, String> provideTaggedSupportingInfo(TaggedSupportingInfoModule taggedSupportingInfoModule, TaggedSupportingInfoFactory taggedSupportingInfoFactory) {
        return (Map) Preconditions.checkNotNullFromProvides(taggedSupportingInfoModule.provideTaggedSupportingInfo(taggedSupportingInfoFactory));
    }
}
