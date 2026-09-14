package com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.vocab.endecoder.resource;

import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class SentencePieceResourceReader_Factory implements Factory<SentencePieceResourceReader> {
    private final Provider<AlphabetsResourceLoader> alphabetsResourceLoaderProvider;
    private final Provider<LanguageIdsResourceLoader> languageIdsResourceLoaderProvider;

    public SentencePieceResourceReader_Factory(Provider<LanguageIdsResourceLoader> provider, Provider<AlphabetsResourceLoader> provider2) {
        this.languageIdsResourceLoaderProvider = provider;
        this.alphabetsResourceLoaderProvider = provider2;
    }

    @Override // javax.inject.Provider
    public SentencePieceResourceReader get() {
        return newInstance(this.languageIdsResourceLoaderProvider.get(), this.alphabetsResourceLoaderProvider.get());
    }

    public static SentencePieceResourceReader_Factory create(Provider<LanguageIdsResourceLoader> provider, Provider<AlphabetsResourceLoader> provider2) {
        return new SentencePieceResourceReader_Factory(provider, provider2);
    }

    public static SentencePieceResourceReader newInstance(LanguageIdsResourceLoader languageIdsResourceLoader, AlphabetsResourceLoader alphabetsResourceLoader) {
        return new SentencePieceResourceReader(languageIdsResourceLoader, alphabetsResourceLoader);
    }
}
