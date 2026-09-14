package com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.vocab.endecoder;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.vocab.endecoder.resource.WordPieceResource;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.vocab.endecoder.textsplitter.TextSplitter;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;

/* compiled from: EncodeTextWithoutPlh.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\b\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B9\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b¢\u0006\u0002\u0010\rJ\u001e\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u0013\u001a\u00020\u0005H\u0014R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/EncodeTextWithoutPlh;", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/EncodeTextToIDs;", "resource", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/resource/WordPieceResource;", "unknownCharacterFilteredText", JsonProperty.USE_DEFAULT_NAME, "textSplitter", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/textsplitter/TextSplitter;", "directionToken", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/DirectionToken;", "nextConvertStep", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/VocabIDsConvertStep;", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/EncodingResult;", "(Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/resource/WordPieceResource;Ljava/lang/String;Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/textsplitter/TextSplitter;Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/DirectionToken;Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/VocabIDsConvertStep;)V", "encodeDetails", JsonProperty.USE_DEFAULT_NAME, "ids", JsonProperty.USE_DEFAULT_NAME, JsonProperty.USE_DEFAULT_NAME, "text", "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class EncodeTextWithoutPlh extends EncodeTextToIDs {
    private final DirectionToken directionToken;
    private final TextSplitter textSplitter;

    public /* synthetic */ EncodeTextWithoutPlh(WordPieceResource wordPieceResource, String str, TextSplitter textSplitter, DirectionToken directionToken, VocabIDsConvertStep vocabIDsConvertStep, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(wordPieceResource, str, textSplitter, directionToken, (i & 16) != 0 ? null : vocabIDsConvertStep);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EncodeTextWithoutPlh(WordPieceResource wordPieceResource, String unknownCharacterFilteredText, TextSplitter textSplitter, DirectionToken directionToken, VocabIDsConvertStep<EncodingResult> vocabIDsConvertStep) {
        super(wordPieceResource, unknownCharacterFilteredText, vocabIDsConvertStep);
        Intrinsics.checkNotNullParameter(unknownCharacterFilteredText, "unknownCharacterFilteredText");
        Intrinsics.checkNotNullParameter(textSplitter, "textSplitter");
        Intrinsics.checkNotNullParameter(directionToken, "directionToken");
        this.textSplitter = textSplitter;
        this.directionToken = directionToken;
    }

    @Override // com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.vocab.endecoder.EncodeTextToIDs
    protected void encodeDetails(List<Integer> ids, String text) {
        Intrinsics.checkNotNullParameter(ids, "ids");
        Intrinsics.checkNotNullParameter(text, "text");
        ids.addAll(SequencesKt.toList(SequencesKt.flattenSequenceOfIterable(SequencesKt.map(SequencesKt.map(SequencesKt.filter(CollectionsKt.asSequence(this.textSplitter.split(text, this.directionToken.getPrependDirectionString())), new Function1<String, Boolean>() { // from class: com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.vocab.endecoder.EncodeTextWithoutPlh$encodeDetails$1
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(String it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return Boolean.valueOf(StringsKt.trim((CharSequence) it).toString().length() > 0);
            }
        }), new Function1<String, String>() { // from class: com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.vocab.endecoder.EncodeTextWithoutPlh$encodeDetails$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final String invoke(String it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return EncodeTextWithoutPlh.this.escapeToken(it);
            }
        }), new Function1<String, List<? extends Integer>>() { // from class: com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.vocab.endecoder.EncodeTextWithoutPlh$encodeDetails$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final List<Integer> invoke(String it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return EncodeTextWithoutPlh.this.convertToIds(it);
            }
        }))));
    }
}
