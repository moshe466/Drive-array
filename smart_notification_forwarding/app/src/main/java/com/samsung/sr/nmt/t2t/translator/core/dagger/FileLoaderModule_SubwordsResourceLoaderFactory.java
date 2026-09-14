package com.samsung.sr.nmt.t2t.translator.core.dagger;

import com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.vocab.endecoder.resource.SubwordsResourceLoader;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* loaded from: classes.dex */
public final class FileLoaderModule_SubwordsResourceLoaderFactory implements Factory<SubwordsResourceLoader> {
    private final FileLoaderModule module;

    public FileLoaderModule_SubwordsResourceLoaderFactory(FileLoaderModule fileLoaderModule) {
        this.module = fileLoaderModule;
    }

    @Override // javax.inject.Provider
    public SubwordsResourceLoader get() {
        return subwordsResourceLoader(this.module);
    }

    public static FileLoaderModule_SubwordsResourceLoaderFactory create(FileLoaderModule fileLoaderModule) {
        return new FileLoaderModule_SubwordsResourceLoaderFactory(fileLoaderModule);
    }

    public static SubwordsResourceLoader subwordsResourceLoader(FileLoaderModule fileLoaderModule) {
        return (SubwordsResourceLoader) Preconditions.checkNotNullFromProvides(fileLoaderModule.subwordsResourceLoader());
    }
}
