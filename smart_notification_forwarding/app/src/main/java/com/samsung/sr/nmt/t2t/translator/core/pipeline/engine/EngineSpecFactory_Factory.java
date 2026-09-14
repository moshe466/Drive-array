package com.samsung.sr.nmt.t2t.translator.core.pipeline.engine;

import com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.fileloader.FileLoader;
import com.samsung.sr.nmt.t2t.translator.core.utils.ActiveLanguageCodeChecker;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class EngineSpecFactory_Factory implements Factory<EngineSpecFactory> {
    private final Provider<ActiveLanguageCodeChecker> activeLanguageCodeCheckerProvider;
    private final Provider<FileLoader> fileLoaderProvider;

    public EngineSpecFactory_Factory(Provider<FileLoader> provider, Provider<ActiveLanguageCodeChecker> provider2) {
        this.fileLoaderProvider = provider;
        this.activeLanguageCodeCheckerProvider = provider2;
    }

    @Override // javax.inject.Provider
    public EngineSpecFactory get() {
        return newInstance(this.fileLoaderProvider.get(), this.activeLanguageCodeCheckerProvider.get());
    }

    public static EngineSpecFactory_Factory create(Provider<FileLoader> provider, Provider<ActiveLanguageCodeChecker> provider2) {
        return new EngineSpecFactory_Factory(provider, provider2);
    }

    public static EngineSpecFactory newInstance(FileLoader fileLoader, ActiveLanguageCodeChecker activeLanguageCodeChecker) {
        return new EngineSpecFactory(fileLoader, activeLanguageCodeChecker);
    }
}
