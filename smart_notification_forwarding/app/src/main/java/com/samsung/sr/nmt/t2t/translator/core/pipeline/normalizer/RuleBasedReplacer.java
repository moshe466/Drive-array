package com.samsung.sr.nmt.t2t.translator.core.pipeline.normalizer;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RuleBasedReplacer.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/normalizer/RuleBasedReplacer;", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/normalizer/Replacer;", "rules", JsonProperty.USE_DEFAULT_NAME, "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/normalizer/ReplaceRule;", "(Ljava/util/List;)V", "replace", JsonProperty.USE_DEFAULT_NAME, "text", "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class RuleBasedReplacer implements Replacer {
    private final List<ReplaceRule> rules;

    /* JADX WARN: Multi-variable type inference failed */
    public RuleBasedReplacer(List<? extends ReplaceRule> rules) {
        Intrinsics.checkNotNullParameter(rules, "rules");
        this.rules = rules;
    }

    @Override // com.samsung.sr.nmt.t2t.translator.core.pipeline.normalizer.Replacer
    public String replace(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        Iterator<T> it = this.rules.iterator();
        while (it.hasNext()) {
            text = ((ReplaceRule) it.next()).replace(text);
        }
        return text;
    }
}
