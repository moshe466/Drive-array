package com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.model;

import com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.fileloader.FileLoader;
import com.samsung.sr.nmt.t2t.translator.core.utils.EnvironmentHelper;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class ModelFactory_Factory implements Factory<ModelFactory> {
    private final Provider<EnvironmentHelper> environmentHelperProvider;
    private final Provider<FileLoader> fileLoaderProvider;

    public ModelFactory_Factory(Provider<FileLoader> provider, Provider<EnvironmentHelper> provider2) {
        this.fileLoaderProvider = provider;
        this.environmentHelperProvider = provider2;
    }

    @Override // javax.inject.Provider
    public ModelFactory get() {
        return newInstance(this.fileLoaderProvider.get(), this.environmentHelperProvider.get());
    }

    public static ModelFactory_Factory create(Provider<FileLoader> provider, Provider<EnvironmentHelper> provider2) {
        return new ModelFactory_Factory(provider, provider2);
    }

    public static ModelFactory newInstance(FileLoader fileLoader, EnvironmentHelper environmentHelper) {
        return new ModelFactory(fileLoader, environmentHelper);
    }
}
