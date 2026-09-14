package com.samsung.sr.nmt.t2t.translator.core.pipeline.engine;

import com.samsung.sr.nmt.t2t.translator.core.dataclass.TranslatorSpec;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.fileloader.FileLoader;
import com.samsung.sr.nmt.t2t.translator.core.utils.LanguageDirection;
import dagger.internal.Factory;
import java.util.Map;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class LanguageDirectionManager_Factory implements Factory<LanguageDirectionManager> {
    private final Provider<FileLoader> fileLoaderProvider;
    private final Provider<Map<LanguageDirection, String>> taggedSupportingInfoProvider;
    private final Provider<TranslatorSpec> translatorSpecProvider;

    public LanguageDirectionManager_Factory(Provider<TranslatorSpec> provider, Provider<FileLoader> provider2, Provider<Map<LanguageDirection, String>> provider3) {
        this.translatorSpecProvider = provider;
        this.fileLoaderProvider = provider2;
        this.taggedSupportingInfoProvider = provider3;
    }

    @Override // javax.inject.Provider
    public LanguageDirectionManager get() {
        return newInstance(this.translatorSpecProvider.get(), this.fileLoaderProvider.get(), this.taggedSupportingInfoProvider.get());
    }

    public static LanguageDirectionManager_Factory create(Provider<TranslatorSpec> provider, Provider<FileLoader> provider2, Provider<Map<LanguageDirection, String>> provider3) {
        return new LanguageDirectionManager_Factory(provider, provider2, provider3);
    }

    public static LanguageDirectionManager newInstance(TranslatorSpec translatorSpec, FileLoader fileLoader, Map<LanguageDirection, String> map) {
        return new LanguageDirectionManager(translatorSpec, fileLoader, map);
    }
}
