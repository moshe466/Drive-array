package com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.formatting.rule;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OrFormattingRule.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001b\b\u0016\u0012\u0012\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0003\"\u00020\u0001¢\u0006\u0002\u0010\u0004B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\r\u001a\u00020\u000bH\u0016J\u0010\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/processors/formatting/rule/OrFormattingRule;", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/processors/formatting/rule/FormattingRule;", "rules", JsonProperty.USE_DEFAULT_NAME, "([Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/processors/formatting/rule/FormattingRule;)V", JsonProperty.USE_DEFAULT_NAME, "(Ljava/util/List;)V", "appliedRule", "applicable", JsonProperty.USE_DEFAULT_NAME, "text", JsonProperty.USE_DEFAULT_NAME, "restore", "ruleName", "store", "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class OrFormattingRule implements FormattingRule {
    private FormattingRule appliedRule;
    private final List<FormattingRule> rules;

    /* JADX WARN: Multi-variable type inference failed */
    public OrFormattingRule(List<? extends FormattingRule> rules) {
        Intrinsics.checkNotNullParameter(rules, "rules");
        this.rules = rules;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public OrFormattingRule(FormattingRule... rules) {
        this((List<? extends FormattingRule>) ArraysKt.asList(rules));
        Intrinsics.checkNotNullParameter(rules, "rules");
    }

    @Override // com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.formatting.rule.FormattingRule
    public boolean applicable(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        List<FormattingRule> list = this.rules;
        if ((list instanceof Collection) && list.isEmpty()) {
            return false;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            if (((FormattingRule) it.next()).applicable(text)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.formatting.rule.FormattingRule
    public String store(String text) {
        String store;
        Intrinsics.checkNotNullParameter(text, "text");
        List<FormattingRule> list = this.rules;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (((FormattingRule) obj).applicable(text)) {
                arrayList.add(obj);
            }
        }
        FormattingRule formattingRule = (FormattingRule) CollectionsKt.firstOrNull((List) arrayList);
        this.appliedRule = formattingRule;
        return (formattingRule == null || (store = formattingRule.store(text)) == null) ? text : store;
    }

    @Override // com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.formatting.rule.FormattingRule
    public String restore(String text) {
        String restore;
        Intrinsics.checkNotNullParameter(text, "text");
        FormattingRule formattingRule = this.appliedRule;
        if (formattingRule != null && (restore = formattingRule.restore(text)) != null) {
            text = restore;
        }
        this.appliedRule = null;
        return text;
    }

    @Override // com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.formatting.rule.FormattingRule
    public String ruleName() {
        List<FormattingRule> list = this.rules;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((FormattingRule) it.next()).getClass().getSimpleName());
        }
        return "Or(" + arrayList + ")";
    }
}
