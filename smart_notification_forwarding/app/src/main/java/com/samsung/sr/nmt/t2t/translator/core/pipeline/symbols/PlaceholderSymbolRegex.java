package com.samsung.sr.nmt.t2t.translator.core.pipeline.symbols;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

/* compiled from: PlaceholderSymbolRegex.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/symbols/PlaceholderSymbolRegex;", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/symbols/SymbolRegex;", "()V", "regexCompiled", "Lkotlin/text/Regex;", "regex", "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class PlaceholderSymbolRegex implements SymbolRegex {
    private final Regex regexCompiled = new Regex("((" + CollectionsKt.joinToString$default(PlaceholderSymbols.getEntries(), "|", null, null, 0, null, new Function1<PlaceholderSymbols, CharSequence>() { // from class: com.samsung.sr.nmt.t2t.translator.core.pipeline.symbols.PlaceholderSymbolRegex$regexCompiled$1
        @Override // kotlin.jvm.functions.Function1
        public final CharSequence invoke(PlaceholderSymbols it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return it.getRegex();
        }
    }, 30, null) + "|" + CollectionsKt.joinToString$default(EmojiSymbols.getEntries(), "|", null, null, 0, null, new Function1<EmojiSymbols, CharSequence>() { // from class: com.samsung.sr.nmt.t2t.translator.core.pipeline.symbols.PlaceholderSymbolRegex$regexCompiled$2
        @Override // kotlin.jvm.functions.Function1
        public final CharSequence invoke(EmojiSymbols it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return it.getRegex();
        }
    }, 30, null) + ")+)");

    @Override // com.samsung.sr.nmt.t2t.translator.core.pipeline.symbols.SymbolRegex
    /* renamed from: regex, reason: from getter */
    public Regex getRegexCompiled() {
        return this.regexCompiled;
    }
}
