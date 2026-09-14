package com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.vocab.endecoder;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.vocab.endecoder.resource.VocabSpec;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RejectWithAlphabets.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\"\n\u0002\u0010\f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0003\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B=\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\r¢\u0006\u0002\u0010\u000eJ\u0016\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0014J\u0010\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0002H\u0014R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/RejectWithAlphabets;", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/VocabIDsConvertStepRejectable;", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/EncodingResult;", "inputSequence", JsonProperty.USE_DEFAULT_NAME, "alphabets", JsonProperty.USE_DEFAULT_NAME, JsonProperty.USE_DEFAULT_NAME, "spec", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/resource/VocabSpec;", "unknownCharacterFilter", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/UnknownCharacterFilter;", "nextConvertStep", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/VocabIDsConvertStep;", "(Ljava/lang/String;Ljava/util/Set;Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/resource/VocabSpec;Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/UnknownCharacterFilter;Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/VocabIDsConvertStep;)V", "isRejectable", JsonProperty.USE_DEFAULT_NAME, "ids", JsonProperty.USE_DEFAULT_NAME, JsonProperty.USE_DEFAULT_NAME, "resultWhenFail", "previousResult", "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class RejectWithAlphabets extends VocabIDsConvertStepRejectable<EncodingResult> {
    private final Set<Character> alphabets;
    private final String inputSequence;
    private final VocabSpec spec;
    private final UnknownCharacterFilter unknownCharacterFilter;

    public /* synthetic */ RejectWithAlphabets(String str, Set set, VocabSpec vocabSpec, UnknownCharacterFilter unknownCharacterFilter, VocabIDsConvertStep vocabIDsConvertStep, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, set, vocabSpec, unknownCharacterFilter, (i & 16) != 0 ? null : vocabIDsConvertStep);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RejectWithAlphabets(String inputSequence, Set<Character> alphabets, VocabSpec spec, UnknownCharacterFilter unknownCharacterFilter, VocabIDsConvertStep<EncodingResult> vocabIDsConvertStep) {
        super(vocabIDsConvertStep);
        Intrinsics.checkNotNullParameter(inputSequence, "inputSequence");
        Intrinsics.checkNotNullParameter(alphabets, "alphabets");
        Intrinsics.checkNotNullParameter(spec, "spec");
        Intrinsics.checkNotNullParameter(unknownCharacterFilter, "unknownCharacterFilter");
        this.inputSequence = inputSequence;
        this.alphabets = alphabets;
        this.spec = spec;
        this.unknownCharacterFilter = unknownCharacterFilter;
    }

    @Override // com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.vocab.endecoder.VocabIDsConvertStepRejectable
    protected boolean isRejectable(List<Integer> ids) {
        Intrinsics.checkNotNullParameter(ids, "ids");
        return this.unknownCharacterFilter.getUnknownCharsRatio(this.inputSequence, this.alphabets) > this.spec.getUnknownTokenRatioThreshold();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.vocab.endecoder.VocabIDsConvertStepRejectable
    public EncodingResult resultWhenFail(EncodingResult previousResult) {
        Intrinsics.checkNotNullParameter(previousResult, "previousResult");
        System.out.println((Object) "Rejected by Alphabets");
        return EncodingResult.copy$default(previousResult, null, true, 1, null);
    }
}
