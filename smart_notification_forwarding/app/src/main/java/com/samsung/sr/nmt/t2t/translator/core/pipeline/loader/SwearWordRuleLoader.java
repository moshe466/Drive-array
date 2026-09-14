package com.samsung.sr.nmt.t2t.translator.core.pipeline.loader;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.swearword.SwearWordRule;
import java.util.List;
import kotlin.Metadata;

/* compiled from: SwearWordRuleLoader.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H&¨\u0006\b"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/loader/SwearWordRuleLoader;", JsonProperty.USE_DEFAULT_NAME, "getAllRules", JsonProperty.USE_DEFAULT_NAME, "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/swearword/SwearWordRule;", "sourceLanguage", JsonProperty.USE_DEFAULT_NAME, "targetLanguage", "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public interface SwearWordRuleLoader {
    List<SwearWordRule> getAllRules(String sourceLanguage, String targetLanguage);
}
