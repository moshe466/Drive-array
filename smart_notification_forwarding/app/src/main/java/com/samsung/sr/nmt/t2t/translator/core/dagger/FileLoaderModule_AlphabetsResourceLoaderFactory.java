package com.samsung.sr.nmt.t2t.translator.core.dagger;

import com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.vocab.endecoder.resource.AlphabetsResourceLoader;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* loaded from: classes.dex */
public final class FileLoaderModule_AlphabetsResourceLoaderFactory implements Factory<AlphabetsResourceLoader> {
    private final FileLoaderModule module;

    public FileLoaderModule_AlphabetsResourceLoaderFactory(FileLoaderModule fileLoaderModule) {
        this.module = fileLoaderModule;
    }

    @Override // javax.inject.Provider
    public AlphabetsResourceLoader get() {
        return alphabetsResourceLoader(this.module);
    }

    public static FileLoaderModule_AlphabetsResourceLoaderFactory create(FileLoaderModule fileLoaderModule) {
        return new FileLoaderModule_AlphabetsResourceLoaderFactory(fileLoaderModule);
    }

    public static AlphabetsResourceLoader alphabetsResourceLoader(FileLoaderModule fileLoaderModule) {
        return (AlphabetsResourceLoader) Preconditions.checkNotNullFromProvides(fileLoaderModule.alphabetsResourceLoader());
    }
}
