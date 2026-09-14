package com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.formatting;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.formatting.rule.AllUppercaseFormattingRule;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.formatting.rule.DotFormattingRule;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.formatting.rule.DoubleQuoteFormattingRule;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.formatting.rule.DoubleQuoteStyle;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.formatting.rule.FirstLetterUpperCaseFormattingRule;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.formatting.rule.FormattingRule;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.formatting.rule.NoAnyExclamationMarkFormattingRule;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.formatting.rule.NoColonEndFormattingRule;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.formatting.rule.NoCommaEndFormattingRule;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.formatting.rule.NoDotFormattingRule;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.formatting.rule.NoDoubleQuoteFormattingRule;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.formatting.rule.NoSemicolonEndFormattingRule;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.formatting.rule.OrFormattingRule;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.formatting.rule.PunctuationInQuoteFormattingRule;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.formatting.rule.PunctuationQuoteStyle;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* compiled from: EnPlFormattingRules.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/processors/formatting/EnPlFormattingRules;", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/processors/formatting/FormattingRules;", "()V", "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class EnPlFormattingRules extends FormattingRules {
    public EnPlFormattingRules() {
        super(CollectionsKt.listOf((Object[]) new FormattingRule[]{new PunctuationInQuoteFormattingRule(DoubleQuoteStyle.PL, PunctuationQuoteStyle.PL), new AllUppercaseFormattingRule(), new FirstLetterUpperCaseFormattingRule(), new OrFormattingRule(new NoDoubleQuoteFormattingRule(), new DoubleQuoteFormattingRule(DoubleQuoteStyle.PL)), new OrFormattingRule(new NoDotFormattingRule(), new DotFormattingRule()), new NoAnyExclamationMarkFormattingRule(), new NoCommaEndFormattingRule(), new NoSemicolonEndFormattingRule(), new NoColonEndFormattingRule()}));
    }
}
