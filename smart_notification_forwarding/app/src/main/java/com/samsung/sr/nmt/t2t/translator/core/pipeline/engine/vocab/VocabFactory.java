package com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.vocab;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.fileloader.FileLoader;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.spec.EngineSpec;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.vocab.endecoder.SentencePieceResourceSpec;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.vocab.endecoder.UnknownCharacterFilter;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.vocab.endecoder.resource.SentencePieceResourceReader;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.vocab.endecoder.resource.VocabSpec;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.vocab.endecoder.resource.WordPieceResourceReader;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.vocab.sentencepiece.SentencePieceVocabJni;
import com.samsung.sr.nmt.t2t.translator.core.utils.EnvironmentHelper;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VocabFactory.kt */
@Singleton
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B9\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\u0006\u0010\u0013\u001a\u00020\u0014J(\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u0011J*\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u0011H\u0002R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/VocabFactory;", JsonProperty.USE_DEFAULT_NAME, "fileLoader", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/fileloader/FileLoader;", "unknownTokenRatioThreshold", JsonProperty.USE_DEFAULT_NAME, "wordPieceResourceReader", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/resource/WordPieceResourceReader;", "sentencePieceResourceReader", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/resource/SentencePieceResourceReader;", "unknownCharacterFilter", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/UnknownCharacterFilter;", "environmentHelper", "Lcom/samsung/sr/nmt/t2t/translator/core/utils/EnvironmentHelper;", "(Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/fileloader/FileLoader;FLcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/resource/WordPieceResourceReader;Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/resource/SentencePieceResourceReader;Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/UnknownCharacterFilter;Lcom/samsung/sr/nmt/t2t/translator/core/utils/EnvironmentHelper;)V", "vocabMap", JsonProperty.USE_DEFAULT_NAME, JsonProperty.USE_DEFAULT_NAME, "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/Vocab;", "clear", JsonProperty.USE_DEFAULT_NAME, "create", "vocabPath", "alphabetPath", "engineSpec", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/spec/EngineSpec;", "vocabLangIdPath", "getSpec", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/resource/VocabSpec;", "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class VocabFactory {
    private final EnvironmentHelper environmentHelper;
    private final FileLoader fileLoader;
    private final SentencePieceResourceReader sentencePieceResourceReader;
    private final UnknownCharacterFilter unknownCharacterFilter;
    private final float unknownTokenRatioThreshold;
    private final Map<String, Vocab> vocabMap;
    private final WordPieceResourceReader wordPieceResourceReader;

    @Inject
    public VocabFactory(FileLoader fileLoader, @Named("unknownTokenRatioThreshold") float f, WordPieceResourceReader wordPieceResourceReader, SentencePieceResourceReader sentencePieceResourceReader, UnknownCharacterFilter unknownCharacterFilter, EnvironmentHelper environmentHelper) {
        Intrinsics.checkNotNullParameter(fileLoader, "fileLoader");
        Intrinsics.checkNotNullParameter(wordPieceResourceReader, "wordPieceResourceReader");
        Intrinsics.checkNotNullParameter(sentencePieceResourceReader, "sentencePieceResourceReader");
        Intrinsics.checkNotNullParameter(unknownCharacterFilter, "unknownCharacterFilter");
        Intrinsics.checkNotNullParameter(environmentHelper, "environmentHelper");
        this.fileLoader = fileLoader;
        this.unknownTokenRatioThreshold = f;
        this.wordPieceResourceReader = wordPieceResourceReader;
        this.sentencePieceResourceReader = sentencePieceResourceReader;
        this.unknownCharacterFilter = unknownCharacterFilter;
        this.environmentHelper = environmentHelper;
        this.vocabMap = new LinkedHashMap();
    }

    public static /* synthetic */ Vocab create$default(VocabFactory vocabFactory, String str, String str2, EngineSpec engineSpec, String str3, int i, Object obj) {
        if ((i & 8) != 0) {
            str3 = JsonProperty.USE_DEFAULT_NAME;
        }
        return vocabFactory.create(str, str2, engineSpec, str3);
    }

    public final Vocab create(String vocabPath, String alphabetPath, EngineSpec engineSpec, String vocabLangIdPath) {
        Intrinsics.checkNotNullParameter(vocabPath, "vocabPath");
        Intrinsics.checkNotNullParameter(alphabetPath, "alphabetPath");
        Intrinsics.checkNotNullParameter(engineSpec, "engineSpec");
        Intrinsics.checkNotNullParameter(vocabLangIdPath, "vocabLangIdPath");
        String str = vocabPath + alphabetPath;
        WordPieceVocab wordPieceVocab = this.vocabMap.get(str);
        if (wordPieceVocab == null) {
            String vocabType = engineSpec.getVocabType();
            if (Intrinsics.areEqual(vocabType, "wordpiece")) {
                wordPieceVocab = new WordPieceVocab(getSpec(vocabPath, alphabetPath, engineSpec, vocabLangIdPath), this.wordPieceResourceReader, this.unknownCharacterFilter);
            } else if (Intrinsics.areEqual(vocabType, "sentencepiece")) {
                wordPieceVocab = new SentencePieceVocab(vocabPath, engineSpec, this.fileLoader, new SentencePieceVocabJni(), this.environmentHelper, new SentencePieceResourceSpec(getSpec(vocabPath, alphabetPath, engineSpec, vocabLangIdPath), this.sentencePieceResourceReader, this.unknownCharacterFilter));
            } else {
                throw new IllegalArgumentException(engineSpec.getVocabType() + " is not supported");
            }
            this.vocabMap.put(str, wordPieceVocab);
        }
        return wordPieceVocab;
    }

    public final void clear() {
        this.vocabMap.values().clear();
        this.vocabMap.clear();
    }

    static /* synthetic */ VocabSpec getSpec$default(VocabFactory vocabFactory, String str, String str2, EngineSpec engineSpec, String str3, int i, Object obj) {
        if ((i & 8) != 0) {
            str3 = JsonProperty.USE_DEFAULT_NAME;
        }
        return vocabFactory.getSpec(str, str2, engineSpec, str3);
    }

    private final VocabSpec getSpec(String vocabPath, String alphabetPath, EngineSpec engineSpec, String vocabLangIdPath) {
        String sourceLanguage = engineSpec.getSourceLanguage();
        String targetLanguage = engineSpec.getTargetLanguage();
        return new VocabSpec(vocabPath, engineSpec.getEosId(), alphabetPath, vocabLangIdPath, sourceLanguage, targetLanguage, this.unknownTokenRatioThreshold, engineSpec.getInvalidLanguageIdRejectionRatioThreshold(), engineSpec.getProcessPlh(), engineSpec.getPlhTok(), engineSpec.getNumPlhTok(), engineSpec.getPreventPlhTokenSplits(), engineSpec.isIndian());
    }
}
