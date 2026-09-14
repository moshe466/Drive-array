package com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.formatting;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.formatting.rule.FormattingRule;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FormattingRules.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tJ\u000e\u0010\u000b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tR\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/processors/formatting/FormattingRules;", JsonProperty.USE_DEFAULT_NAME, "rules", JsonProperty.USE_DEFAULT_NAME, "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/processors/formatting/rule/FormattingRule;", "(Ljava/util/List;)V", "appliedRules", JsonProperty.USE_DEFAULT_NAME, "apply", JsonProperty.USE_DEFAULT_NAME, "text", "restore", "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public class FormattingRules {
    private final List<FormattingRule> appliedRules;
    private final List<FormattingRule> rules;

    /* JADX WARN: Multi-variable type inference failed */
    public FormattingRules(List<? extends FormattingRule> rules) {
        Intrinsics.checkNotNullParameter(rules, "rules");
        this.rules = rules;
        this.appliedRules = new ArrayList();
    }

    public final String apply(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        List<FormattingRule> list = this.rules;
        ArrayList<FormattingRule> arrayList = new ArrayList();
        for (Object obj : list) {
            if (((FormattingRule) obj).applicable(text)) {
                arrayList.add(obj);
            }
        }
        for (FormattingRule formattingRule : arrayList) {
            this.appliedRules.add(formattingRule);
            text = formattingRule.store(text);
        }
        return text;
    }

    public final String restore(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        Iterator it = CollectionsKt.reversed(this.appliedRules).iterator();
        while (it.hasNext()) {
            text = ((FormattingRule) it.next()).restore(text);
        }
        this.appliedRules.clear();
        return text;
    }
}
