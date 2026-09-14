package com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.vocab.endecoder.resource;

import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class WordPieceResourceReader_Factory implements Factory<WordPieceResourceReader> {
    private final Provider<AlphabetsResourceLoader> alphabetsResourceLoaderProvider;
    private final Provider<LanguageIdsResourceLoader> languageIdsResourceLoaderProvider;
    private final Provider<SubwordsResourceLoader> subwordsResourceLoaderProvider;

    public WordPieceResourceReader_Factory(Provider<LanguageIdsResourceLoader> provider, Provider<AlphabetsResourceLoader> provider2, Provider<SubwordsResourceLoader> provider3) {
        this.languageIdsResourceLoaderProvider = provider;
        this.alphabetsResourceLoaderProvider = provider2;
        this.subwordsResourceLoaderProvider = provider3;
    }

    @Override // javax.inject.Provider
    public WordPieceResourceReader get() {
        return newInstance(this.languageIdsResourceLoaderProvider.get(), this.alphabetsResourceLoaderProvider.get(), this.subwordsResourceLoaderProvider.get());
    }

    public static WordPieceResourceReader_Factory create(Provider<LanguageIdsResourceLoader> provider, Provider<AlphabetsResourceLoader> provider2, Provider<SubwordsResourceLoader> provider3) {
        return new WordPieceResourceReader_Factory(provider, provider2, provider3);
    }

    public static WordPieceResourceReader newInstance(LanguageIdsResourceLoader languageIdsResourceLoader, AlphabetsResourceLoader alphabetsResourceLoader, SubwordsResourceLoader subwordsResourceLoader) {
        return new WordPieceResourceReader(languageIdsResourceLoader, alphabetsResourceLoader, subwordsResourceLoader);
    }
}
