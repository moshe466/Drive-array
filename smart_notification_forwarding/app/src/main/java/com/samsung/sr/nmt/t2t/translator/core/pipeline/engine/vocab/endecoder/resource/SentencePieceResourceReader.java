package com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.vocab.endecoder.resource;

import androidx.constraintlayout.widget.ConstraintLayout;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SentencePieceResourceReader.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/resource/SentencePieceResourceReader;", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/resource/ResourceReader;", "languageIdsResourceLoader", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/resource/LanguageIdsResourceLoader;", "alphabetsResourceLoader", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/resource/AlphabetsResourceLoader;", "(Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/resource/LanguageIdsResourceLoader;Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/resource/AlphabetsResourceLoader;)V", "getResource", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/resource/SentencePieceResource;", "spec", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/resource/VocabSpec;", "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class SentencePieceResourceReader extends ResourceReader {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public SentencePieceResourceReader(LanguageIdsResourceLoader languageIdsResourceLoader, AlphabetsResourceLoader alphabetsResourceLoader) {
        super(languageIdsResourceLoader, alphabetsResourceLoader);
        Intrinsics.checkNotNullParameter(languageIdsResourceLoader, "languageIdsResourceLoader");
        Intrinsics.checkNotNullParameter(alphabetsResourceLoader, "alphabetsResourceLoader");
    }

    @Override // com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.vocab.endecoder.resource.ResourceReader
    public SentencePieceResource getResource(VocabSpec spec) {
        Intrinsics.checkNotNullParameter(spec, "spec");
        return new SentencePieceResource(getAlphabetsResourceLoader().load(spec.getSourceLanguage(), spec.getTargetLanguage(), spec.getAlphabetPath()), getLanguageIdsResourceLoader().load(spec.getSourceLanguage(), spec.getTargetLanguage(), spec.getVocabLangIdPath()));
    }
}
