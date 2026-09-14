package com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.vocab.endecoder;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.vocab.endecoder.resource.VocabSpec;
import com.samsung.sr.nmt.t2t.translator.core.utils.LanguageDirection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VocabEncoder.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\b \u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J0\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH&J.\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u00122\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0014H\u0004¨\u0006\u0015"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/VocabEncoder;", JsonProperty.USE_DEFAULT_NAME, "()V", "encode", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/EncodingResult;", "inputSequence", JsonProperty.USE_DEFAULT_NAME, "directionToken", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/DirectionToken;", "honorificToken", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/HonorificToken;", "languageDirection", "Lcom/samsung/sr/nmt/t2t/translator/core/utils/LanguageDirection;", "verbose", JsonProperty.USE_DEFAULT_NAME, "getRejectWithLanguageIDs", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/RejectWithLanguageIDs;", "languageIds", JsonProperty.USE_DEFAULT_NAME, "spec", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/resource/VocabSpec;", "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public abstract class VocabEncoder {
    public abstract EncodingResult encode(String inputSequence, DirectionToken directionToken, HonorificToken honorificToken, LanguageDirection languageDirection, boolean verbose);

    /* JADX INFO: Access modifiers changed from: protected */
    public final RejectWithLanguageIDs<EncodingResult> getRejectWithLanguageIDs(List<String> languageIds, LanguageDirection languageDirection, VocabSpec spec) {
        Intrinsics.checkNotNullParameter(languageIds, "languageIds");
        Intrinsics.checkNotNullParameter(languageDirection, "languageDirection");
        Intrinsics.checkNotNullParameter(spec, "spec");
        if (!languageIds.isEmpty()) {
            return new RejectWithLanguageIDs<>(languageIds, languageDirection.getTgtLang(), spec.getInvalidLanguageIdRejectionRatioThreshold(), new Function1<EncodingResult, EncodingResult>() { // from class: com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.vocab.endecoder.VocabEncoder$getRejectWithLanguageIDs$1
                @Override // kotlin.jvm.functions.Function1
                public final EncodingResult invoke(EncodingResult it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    System.out.println((Object) "Rejected by Language IDs (Encode)");
                    return it.copy(CollectionsKt.emptyList(), true);
                }
            }, null, 16, null);
        }
        return null;
    }
}
