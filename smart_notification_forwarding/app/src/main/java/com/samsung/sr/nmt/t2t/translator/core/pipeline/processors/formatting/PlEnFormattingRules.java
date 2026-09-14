package com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.formatting;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.formatting.rule.AllUppercaseFormattingRule;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.formatting.rule.DotFormattingRule;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.formatting.rule.DoubleQuoteFormattingRule;
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
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* compiled from: PlEnFormattingRules.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/processors/formatting/PlEnFormattingRules;", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/processors/formatting/FormattingRules;", "()V", "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class PlEnFormattingRules extends FormattingRules {
    /* JADX WARN: Multi-variable type inference failed */
    public PlEnFormattingRules() {
        super(CollectionsKt.listOf((Object[]) new FormattingRule[]{new PunctuationInQuoteFormattingRule(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0), new AllUppercaseFormattingRule(), new FirstLetterUpperCaseFormattingRule(), new OrFormattingRule(new NoDoubleQuoteFormattingRule(), new DoubleQuoteFormattingRule(0 == true ? 1 : 0, 1, 0 == true ? 1 : 0)), new OrFormattingRule(new NoDotFormattingRule(), new DotFormattingRule()), new NoAnyExclamationMarkFormattingRule(), new NoCommaEndFormattingRule(), new NoSemicolonEndFormattingRule(), new NoColonEndFormattingRule()}));
    }
}
