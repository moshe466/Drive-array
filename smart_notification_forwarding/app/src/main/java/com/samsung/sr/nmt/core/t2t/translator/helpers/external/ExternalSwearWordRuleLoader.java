package com.samsung.sr.nmt.core.t2t.translator.helpers.external;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.samsung.sr.nmt.core.t2t.translator.helpers.db.cursor.CursorHelper;
import com.samsung.sr.nmt.core.t2t.translator.helpers.db.cursor.CursorParser;
import com.samsung.sr.nmt.core.t2t.translator.helpers.db.cursor.SwearWordRuleCursorParser;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.loader.SwearWordRuleLoader;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.swearword.SwearWordRule;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ExternalSwearWordRuleLoader.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/samsung/sr/nmt/core/t2t/translator/helpers/external/ExternalSwearWordRuleLoader;", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/loader/SwearWordRuleLoader;", "cursorHelper", "Lcom/samsung/sr/nmt/core/t2t/translator/helpers/db/cursor/CursorHelper;", "cursorParser", "Lcom/samsung/sr/nmt/core/t2t/translator/helpers/db/cursor/SwearWordRuleCursorParser;", "(Lcom/samsung/sr/nmt/core/t2t/translator/helpers/db/cursor/CursorHelper;Lcom/samsung/sr/nmt/core/t2t/translator/helpers/db/cursor/SwearWordRuleCursorParser;)V", "getAllRules", JsonProperty.USE_DEFAULT_NAME, "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/swearword/SwearWordRule;", "sourceLanguage", JsonProperty.USE_DEFAULT_NAME, "targetLanguage", "translator_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class ExternalSwearWordRuleLoader implements SwearWordRuleLoader {
    private final CursorHelper cursorHelper;
    private final SwearWordRuleCursorParser cursorParser;

    public ExternalSwearWordRuleLoader(CursorHelper cursorHelper, SwearWordRuleCursorParser cursorParser) {
        Intrinsics.checkNotNullParameter(cursorHelper, "cursorHelper");
        Intrinsics.checkNotNullParameter(cursorParser, "cursorParser");
        this.cursorHelper = cursorHelper;
        this.cursorParser = cursorParser;
    }

    @Override // com.samsung.sr.nmt.t2t.translator.core.pipeline.loader.SwearWordRuleLoader
    public List<SwearWordRule> getAllRules(String sourceLanguage, String targetLanguage) {
        Intrinsics.checkNotNullParameter(sourceLanguage, "sourceLanguage");
        Intrinsics.checkNotNullParameter(targetLanguage, "targetLanguage");
        return (List) CursorParser.parse$default(this.cursorParser, this.cursorHelper.getCursor(sourceLanguage, targetLanguage), 0, 2, null);
    }
}
