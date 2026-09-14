package com.samsung.sr.nmt.t2t.translator.core.dagger;

import com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.vocab.endecoder.resource.LanguageIdsResourceLoader;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* loaded from: classes.dex */
public final class FileLoaderModule_LanguageIdsResourceLoaderFactory implements Factory<LanguageIdsResourceLoader> {
    private final FileLoaderModule module;

    public FileLoaderModule_LanguageIdsResourceLoaderFactory(FileLoaderModule fileLoaderModule) {
        this.module = fileLoaderModule;
    }

    @Override // javax.inject.Provider
    public LanguageIdsResourceLoader get() {
        return languageIdsResourceLoader(this.module);
    }

    public static FileLoaderModule_LanguageIdsResourceLoaderFactory create(FileLoaderModule fileLoaderModule) {
        return new FileLoaderModule_LanguageIdsResourceLoaderFactory(fileLoaderModule);
    }

    public static LanguageIdsResourceLoader languageIdsResourceLoader(FileLoaderModule fileLoaderModule) {
        return (LanguageIdsResourceLoader) Preconditions.checkNotNullFromProvides(fileLoaderModule.languageIdsResourceLoader());
    }
}
