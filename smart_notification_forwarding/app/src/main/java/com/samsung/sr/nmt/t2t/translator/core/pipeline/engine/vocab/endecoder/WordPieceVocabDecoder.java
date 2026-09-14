package com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.vocab.endecoder;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.exception.ComputationException;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.vocab.endecoder.resource.VocabSpec;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.vocab.endecoder.resource.WordPieceResource;
import com.samsung.sr.nmt.t2t.translator.core.utils.LanguageDirection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WordPieceVocabDecoder.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\"\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/WordPieceVocabDecoder;", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/VocabDecoder;", "spec", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/resource/VocabSpec;", "resource", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/resource/WordPieceResource;", "(Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/resource/VocabSpec;Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/resource/WordPieceResource;)V", "decode", JsonProperty.USE_DEFAULT_NAME, "ids", JsonProperty.USE_DEFAULT_NAME, "languageDirection", "Lcom/samsung/sr/nmt/t2t/translator/core/utils/LanguageDirection;", "verbose", JsonProperty.USE_DEFAULT_NAME, "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class WordPieceVocabDecoder implements VocabDecoder {
    private final WordPieceResource resource;
    private final VocabSpec spec;

    public WordPieceVocabDecoder(VocabSpec spec, WordPieceResource wordPieceResource) {
        Intrinsics.checkNotNullParameter(spec, "spec");
        this.spec = spec;
        this.resource = wordPieceResource;
    }

    @Override // com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.vocab.endecoder.VocabDecoder
    public String decode(int[] ids, LanguageDirection languageDirection, boolean verbose) {
        UnescapeAndDecode unescapeAndDecode;
        Object m107constructorimpl;
        Intrinsics.checkNotNullParameter(ids, "ids");
        Intrinsics.checkNotNullParameter(languageDirection, "languageDirection");
        WordPieceResource wordPieceResource = this.resource;
        if (wordPieceResource == null) {
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        List<String> subwords = wordPieceResource.getSubwords();
        List<String> languageIds = this.resource.getLanguageIds();
        UnescapeAndDecode unescapeAndDecode2 = new UnescapeAndDecode(subwords, null, 2, null);
        if (!languageIds.isEmpty()) {
            unescapeAndDecode = new RejectWithLanguageIDs(languageIds, languageDirection.getSrcLang(), this.spec.getInvalidLanguageIdRejectionRatioThreshold(), new Function1<String, String>() { // from class: com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.vocab.endecoder.WordPieceVocabDecoder$decode$rejectWithLanguageIDs$1
                @Override // kotlin.jvm.functions.Function1
                public final String invoke(String str) {
                    System.out.println((Object) "Rejected by Language IDs (Decode)");
                    return null;
                }
            }, unescapeAndDecode2);
        } else {
            unescapeAndDecode = unescapeAndDecode2;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            m107constructorimpl = Result.m107constructorimpl((String) unescapeAndDecode.convert(ArraysKt.toMutableList(ids), JsonProperty.USE_DEFAULT_NAME));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            m107constructorimpl = Result.m107constructorimpl(ResultKt.createFailure(th));
        }
        Throwable m110exceptionOrNullimpl = Result.m110exceptionOrNullimpl(m107constructorimpl);
        if (m110exceptionOrNullimpl != null) {
            throw new ComputationException("Fail to decode | " + m110exceptionOrNullimpl.getMessage() + " | " + ids);
        }
        ResultKt.throwOnFailure(m107constructorimpl);
        return (String) m107constructorimpl;
    }
}
