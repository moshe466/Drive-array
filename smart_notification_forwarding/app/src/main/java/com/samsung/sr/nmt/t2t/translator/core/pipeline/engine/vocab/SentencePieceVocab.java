package com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.vocab;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.exception.ResourceAccessException;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.fileloader.FileLoader;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.spec.EngineSpec;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.spec.PlaceholderSpec;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.vocab.endecoder.SentencePieceResourceSpec;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.vocab.endecoder.SentencePieceVocabDecoder;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.vocab.endecoder.SentencePieceVocabEncoder;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.vocab.endecoder.VocabDecoder;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.vocab.endecoder.VocabEncoder;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.vocab.endecoder.resource.SentencePieceResource;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.vocab.sentencepiece.SentencePieceVocabJni;
import com.samsung.sr.nmt.t2t.translator.core.utils.EnvironmentHelper;
import com.samsung.sr.nmt.t2t.translator.core.utils.RawFileDescriptor;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SentencePieceVocab.kt */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\b\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u001fH\u0016J\b\u0010 \u001a\u00020\u001dH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\u00020\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0011R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\u00020\u00158VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\u00198VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/SentencePieceVocab;", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/Vocab;", "vocabPath", JsonProperty.USE_DEFAULT_NAME, "engineSpec", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/spec/EngineSpec;", "fileLoader", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/fileloader/FileLoader;", "sentencePieceVocabJni", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/sentencepiece/SentencePieceVocabJni;", "environmentHelper", "Lcom/samsung/sr/nmt/t2t/translator/core/utils/EnvironmentHelper;", "sentencePieceResourceSpec", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/SentencePieceResourceSpec;", "(Ljava/lang/String;Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/spec/EngineSpec;Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/fileloader/FileLoader;Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/sentencepiece/SentencePieceVocabJni;Lcom/samsung/sr/nmt/t2t/translator/core/utils/EnvironmentHelper;Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/SentencePieceResourceSpec;)V", "isLoaded", JsonProperty.USE_DEFAULT_NAME, "()Z", "resource", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/resource/SentencePieceResource;", "vocabDecoder", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/VocabDecoder;", "getVocabDecoder", "()Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/VocabDecoder;", "vocabEncoder", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/VocabEncoder;", "getVocabEncoder", "()Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/VocabEncoder;", "clear", JsonProperty.USE_DEFAULT_NAME, "getPlaceholderSpec", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/spec/PlaceholderSpec;", "load", "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class SentencePieceVocab extends Vocab {
    private final EngineSpec engineSpec;
    private final EnvironmentHelper environmentHelper;
    private final FileLoader fileLoader;
    private SentencePieceResource resource;
    private final SentencePieceResourceSpec sentencePieceResourceSpec;
    private final SentencePieceVocabJni sentencePieceVocabJni;
    private final String vocabPath;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SentencePieceVocab(String vocabPath, EngineSpec engineSpec, FileLoader fileLoader, SentencePieceVocabJni sentencePieceVocabJni, EnvironmentHelper environmentHelper, SentencePieceResourceSpec sentencePieceResourceSpec) {
        super(engineSpec.getEosId());
        Intrinsics.checkNotNullParameter(vocabPath, "vocabPath");
        Intrinsics.checkNotNullParameter(engineSpec, "engineSpec");
        Intrinsics.checkNotNullParameter(fileLoader, "fileLoader");
        Intrinsics.checkNotNullParameter(sentencePieceVocabJni, "sentencePieceVocabJni");
        Intrinsics.checkNotNullParameter(environmentHelper, "environmentHelper");
        Intrinsics.checkNotNullParameter(sentencePieceResourceSpec, "sentencePieceResourceSpec");
        this.vocabPath = vocabPath;
        this.engineSpec = engineSpec;
        this.fileLoader = fileLoader;
        this.sentencePieceVocabJni = sentencePieceVocabJni;
        this.environmentHelper = environmentHelper;
        this.sentencePieceResourceSpec = sentencePieceResourceSpec;
    }

    @Override // com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.vocab.Vocab
    public void load() {
        RawFileDescriptor rawFileDescriptor;
        Unit unit = null;
        if (this.environmentHelper.getUsingInputStreamInsteadDescriptor()) {
            InputStream authorizedInputStream = this.fileLoader.getAuthorizedInputStream(this.engineSpec.getSourceLanguage(), this.engineSpec.getTargetLanguage(), this.vocabPath);
            if (authorizedInputStream != null) {
                rawFileDescriptor = authorizedInputStream;
                try {
                    SentencePieceVocabJni sentencePieceVocabJni = this.sentencePieceVocabJni;
                    byte[] readAllBytes = rawFileDescriptor.readAllBytes();
                    Intrinsics.checkNotNullExpressionValue(readAllBytes, "readAllBytes(...)");
                    sentencePieceVocabJni.load(readAllBytes);
                    Unit unit2 = Unit.INSTANCE;
                    CloseableKt.closeFinally(rawFileDescriptor, null);
                    unit = Unit.INSTANCE;
                } finally {
                }
            }
            if (unit == null) {
                throw new ResourceAccessException("Failed to access resource | " + this.vocabPath);
            }
        } else {
            RawFileDescriptor authorizedRawFileDescriptor = this.fileLoader.getAuthorizedRawFileDescriptor(this.engineSpec.getSourceLanguage(), this.engineSpec.getTargetLanguage(), this.vocabPath);
            if (authorizedRawFileDescriptor != null) {
                rawFileDescriptor = authorizedRawFileDescriptor;
                try {
                    RawFileDescriptor rawFileDescriptor2 = rawFileDescriptor;
                    this.sentencePieceVocabJni.load(rawFileDescriptor2.getFileDescriptorContainer().getFd(), rawFileDescriptor2.getOffSet(), rawFileDescriptor2.getLength());
                    Unit unit3 = Unit.INSTANCE;
                    CloseableKt.closeFinally(rawFileDescriptor, null);
                    unit = Unit.INSTANCE;
                } finally {
                    try {
                        throw th;
                    } finally {
                    }
                }
            }
            if (unit == null) {
                throw new ResourceAccessException("Failed to access resource | " + this.vocabPath);
            }
        }
        this.resource = this.sentencePieceResourceSpec.getVocabResourceReader().getResource(this.sentencePieceResourceSpec.getSpec());
    }

    @Override // com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.vocab.Vocab
    public boolean isLoaded() {
        return this.sentencePieceVocabJni.isLoaded();
    }

    @Override // com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.vocab.Vocab
    public VocabEncoder getVocabEncoder() {
        return new SentencePieceVocabEncoder(this.engineSpec, this.sentencePieceVocabJni, this.sentencePieceResourceSpec.getSpec(), this.sentencePieceResourceSpec.getUnknownCharacterFilter(), this.resource);
    }

    @Override // com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.vocab.Vocab
    public VocabDecoder getVocabDecoder() {
        return new SentencePieceVocabDecoder(this.engineSpec, this.sentencePieceVocabJni, this.resource);
    }

    @Override // com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.vocab.Vocab
    public PlaceholderSpec getPlaceholderSpec() {
        return new PlaceholderSpec(this.engineSpec.getProcessPlh(), this.engineSpec.getPlhTok(), this.engineSpec.getNumPlhTok(), this.engineSpec.getPreventPlhTokenSplits());
    }

    @Override // com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.vocab.Vocab
    public void clear() {
        this.sentencePieceVocabJni.clear();
    }
}
