package com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.vocab.endecoder;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.samsung.sr.nmt.t2t.translator.core.utils.LanguageDirection;
import kotlin.Metadata;

/* compiled from: VocabDecoder.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&¨\u0006\n"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/VocabDecoder;", JsonProperty.USE_DEFAULT_NAME, "decode", JsonProperty.USE_DEFAULT_NAME, "ids", JsonProperty.USE_DEFAULT_NAME, "languageDirection", "Lcom/samsung/sr/nmt/t2t/translator/core/utils/LanguageDirection;", "verbose", JsonProperty.USE_DEFAULT_NAME, "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public interface VocabDecoder {
    String decode(int[] ids, LanguageDirection languageDirection, boolean verbose);
}
