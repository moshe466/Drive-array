package com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.vocab;

import com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.fileloader.FileLoader;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.vocab.endecoder.UnknownCharacterFilter;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.vocab.endecoder.resource.SentencePieceResourceReader;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.vocab.endecoder.resource.WordPieceResourceReader;
import com.samsung.sr.nmt.t2t.translator.core.utils.EnvironmentHelper;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class VocabFactory_Factory implements Factory<VocabFactory> {
    private final Provider<EnvironmentHelper> environmentHelperProvider;
    private final Provider<FileLoader> fileLoaderProvider;
    private final Provider<SentencePieceResourceReader> sentencePieceResourceReaderProvider;
    private final Provider<UnknownCharacterFilter> unknownCharacterFilterProvider;
    private final Provider<Float> unknownTokenRatioThresholdProvider;
    private final Provider<WordPieceResourceReader> wordPieceResourceReaderProvider;

    public VocabFactory_Factory(Provider<FileLoader> provider, Provider<Float> provider2, Provider<WordPieceResourceReader> provider3, Provider<SentencePieceResourceReader> provider4, Provider<UnknownCharacterFilter> provider5, Provider<EnvironmentHelper> provider6) {
        this.fileLoaderProvider = provider;
        this.unknownTokenRatioThresholdProvider = provider2;
        this.wordPieceResourceReaderProvider = provider3;
        this.sentencePieceResourceReaderProvider = provider4;
        this.unknownCharacterFilterProvider = provider5;
        this.environmentHelperProvider = provider6;
    }

    @Override // javax.inject.Provider
    public VocabFactory get() {
        return newInstance(this.fileLoaderProvider.get(), this.unknownTokenRatioThresholdProvider.get().floatValue(), this.wordPieceResourceReaderProvider.get(), this.sentencePieceResourceReaderProvider.get(), this.unknownCharacterFilterProvider.get(), this.environmentHelperProvider.get());
    }

    public static VocabFactory_Factory create(Provider<FileLoader> provider, Provider<Float> provider2, Provider<WordPieceResourceReader> provider3, Provider<SentencePieceResourceReader> provider4, Provider<UnknownCharacterFilter> provider5, Provider<EnvironmentHelper> provider6) {
        return new VocabFactory_Factory(provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static VocabFactory newInstance(FileLoader fileLoader, float f, WordPieceResourceReader wordPieceResourceReader, SentencePieceResourceReader sentencePieceResourceReader, UnknownCharacterFilter unknownCharacterFilter, EnvironmentHelper environmentHelper) {
        return new VocabFactory(fileLoader, f, wordPieceResourceReader, sentencePieceResourceReader, unknownCharacterFilter, environmentHelper);
    }
}
