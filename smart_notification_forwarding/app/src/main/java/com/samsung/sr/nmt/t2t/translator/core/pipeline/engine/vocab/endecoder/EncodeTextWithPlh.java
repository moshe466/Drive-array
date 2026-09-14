package com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.vocab.endecoder;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.vocab.endecoder.resource.WordPieceResource;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.vocab.endecoder.textsplitter.TextSplitter;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;

/* compiled from: EncodeTextWithPlh.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\b\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001BE\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005\u0012\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f¢\u0006\u0002\u0010\u000eJ\u001e\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010\u0014\u001a\u00020\u0005H\u0014R\u000e\u0010\n\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/EncodeTextWithPlh;", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/EncodeTextToIDs;", "resource", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/resource/WordPieceResource;", "unknownCharacterFilteredText", JsonProperty.USE_DEFAULT_NAME, "plhHandler", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/PlhHandler;", "textSplitter", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/textsplitter/TextSplitter;", "dirTok", "nextConvertStep", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/VocabIDsConvertStep;", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/EncodingResult;", "(Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/resource/WordPieceResource;Ljava/lang/String;Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/PlhHandler;Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/textsplitter/TextSplitter;Ljava/lang/String;Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/VocabIDsConvertStep;)V", "encodeDetails", JsonProperty.USE_DEFAULT_NAME, "ids", JsonProperty.USE_DEFAULT_NAME, JsonProperty.USE_DEFAULT_NAME, "text", "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class EncodeTextWithPlh extends EncodeTextToIDs {
    private final String dirTok;
    private final PlhHandler plhHandler;
    private final WordPieceResource resource;
    private final TextSplitter textSplitter;

    public /* synthetic */ EncodeTextWithPlh(WordPieceResource wordPieceResource, String str, PlhHandler plhHandler, TextSplitter textSplitter, String str2, VocabIDsConvertStep vocabIDsConvertStep, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(wordPieceResource, str, plhHandler, textSplitter, (i & 16) != 0 ? JsonProperty.USE_DEFAULT_NAME : str2, (i & 32) != 0 ? null : vocabIDsConvertStep);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EncodeTextWithPlh(WordPieceResource wordPieceResource, String unknownCharacterFilteredText, PlhHandler plhHandler, TextSplitter textSplitter, String dirTok, VocabIDsConvertStep<EncodingResult> vocabIDsConvertStep) {
        super(wordPieceResource, unknownCharacterFilteredText, vocabIDsConvertStep);
        Intrinsics.checkNotNullParameter(unknownCharacterFilteredText, "unknownCharacterFilteredText");
        Intrinsics.checkNotNullParameter(textSplitter, "textSplitter");
        Intrinsics.checkNotNullParameter(dirTok, "dirTok");
        this.resource = wordPieceResource;
        this.plhHandler = plhHandler;
        this.textSplitter = textSplitter;
        this.dirTok = dirTok;
    }

    @Override // com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.vocab.endecoder.EncodeTextToIDs
    protected void encodeDetails(List<Integer> ids, String text) {
        Intrinsics.checkNotNullParameter(ids, "ids");
        Intrinsics.checkNotNullParameter(text, "text");
        PlhHandler plhHandler = this.plhHandler;
        Intrinsics.checkNotNull(plhHandler);
        List<String> splitTextByPlh = plhHandler.splitTextByPlh(StringsKt.trim((CharSequence) text).toString());
        WordPieceResource wordPieceResource = this.resource;
        Intrinsics.checkNotNull(wordPieceResource);
        Map<String, Integer> subwordToIds = wordPieceResource.getSubwordToIds();
        int i = 0;
        for (String str : splitTextByPlh) {
            int i2 = i + 1;
            if (!(str.length() == 0)) {
                if (subwordToIds.containsKey(str + "_")) {
                    Integer num = subwordToIds.get(str + "_");
                    if (num == null) {
                        throw new IllegalStateException((str + " not in resource.subwordToIds").toString());
                    }
                    ids.add(Integer.valueOf(num.intValue()));
                } else if (subwordToIds.containsKey(str)) {
                    Integer num2 = subwordToIds.get(str);
                    if (num2 == null) {
                        throw new IllegalStateException((str + " not in resource.subwordToIds").toString());
                    }
                    ids.add(Integer.valueOf(num2.intValue()));
                } else {
                    ids.addAll(SequencesKt.toList(SequencesKt.flattenSequenceOfIterable(SequencesKt.map(SequencesKt.map(SequencesKt.filter(CollectionsKt.asSequence(this.textSplitter.split(str, i == 0 ? this.dirTok : JsonProperty.USE_DEFAULT_NAME)), new Function1<String, Boolean>() { // from class: com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.vocab.endecoder.EncodeTextWithPlh$encodeDetails$1
                        @Override // kotlin.jvm.functions.Function1
                        public final Boolean invoke(String it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                            return Boolean.valueOf(it.length() > 0);
                        }
                    }), new Function1<String, String>() { // from class: com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.vocab.endecoder.EncodeTextWithPlh$encodeDetails$2
                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final String invoke(String it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                            return EncodeTextWithPlh.this.escapeToken(it);
                        }
                    }), new Function1<String, List<? extends Integer>>() { // from class: com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.vocab.endecoder.EncodeTextWithPlh$encodeDetails$3
                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final List<Integer> invoke(String it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                            return EncodeTextWithPlh.this.convertToIds(it);
                        }
                    }))));
                }
            }
            i = i2;
        }
    }
}
