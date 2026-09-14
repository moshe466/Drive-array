package com.samsung.sr.nmt.t2t.translator.core.languagedetector.preprocessor;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

/* compiled from: SpaceAndNewlineProcessor.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¨\u0006\u0006"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/languagedetector/preprocessor/SpaceAndNewlineProcessor;", "Lcom/samsung/sr/nmt/t2t/translator/core/languagedetector/preprocessor/DetectionPreProcessor;", "()V", "process", JsonProperty.USE_DEFAULT_NAME, "text", "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class SpaceAndNewlineProcessor implements DetectionPreProcessor {
    @Inject
    public SpaceAndNewlineProcessor() {
    }

    @Override // com.samsung.sr.nmt.t2t.translator.core.languagedetector.preprocessor.DetectionPreProcessor
    public String process(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        return new Regex("\\s{2,}").replace(new Regex("[\\n\\r]").replace(text, " "), " ");
    }
}
