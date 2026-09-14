package com.samsung.sr.nmt.t2t.translator.core.dagger;

import com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.fileloader.FileLoader;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* loaded from: classes.dex */
public final class FileLoaderModule_FileLoaderFactory implements Factory<FileLoader> {
    private final FileLoaderModule module;

    public FileLoaderModule_FileLoaderFactory(FileLoaderModule fileLoaderModule) {
        this.module = fileLoaderModule;
    }

    @Override // javax.inject.Provider
    public FileLoader get() {
        return fileLoader(this.module);
    }

    public static FileLoaderModule_FileLoaderFactory create(FileLoaderModule fileLoaderModule) {
        return new FileLoaderModule_FileLoaderFactory(fileLoaderModule);
    }

    public static FileLoader fileLoader(FileLoaderModule fileLoaderModule) {
        return (FileLoader) Preconditions.checkNotNullFromProvides(fileLoaderModule.getFileLoader());
    }
}
