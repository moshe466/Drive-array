package com.samsung.sr.nmt.t2t.translator.core.languagedetector.preprocessor;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.symbols.SymbolRegex;
import javax.inject.Inject;
import javax.inject.Named;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: SymbolFilteringProcessor.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/languagedetector/preprocessor/SymbolFilteringProcessor;", "Lcom/samsung/sr/nmt/t2t/translator/core/languagedetector/preprocessor/DetectionPreProcessor;", "placeholderSymbols", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/symbols/SymbolRegex;", "(Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/symbols/SymbolRegex;)V", "process", JsonProperty.USE_DEFAULT_NAME, "text", "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class SymbolFilteringProcessor implements DetectionPreProcessor {
    private final SymbolRegex placeholderSymbols;

    @Inject
    public SymbolFilteringProcessor(@Named("PlaceholderSymbolRegex") SymbolRegex placeholderSymbols) {
        Intrinsics.checkNotNullParameter(placeholderSymbols, "placeholderSymbols");
        this.placeholderSymbols = placeholderSymbols;
    }

    @Override // com.samsung.sr.nmt.t2t.translator.core.languagedetector.preprocessor.DetectionPreProcessor
    public String process(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        return StringsKt.trim((CharSequence) this.placeholderSymbols.getRegexCompiled().replace(text, JsonProperty.USE_DEFAULT_NAME)).toString();
    }
}
