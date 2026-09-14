package com.samsung.sr.nmt.core.t2t.translator.helpers.external;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.samsung.sr.nmt.core.t2t.translator.helpers.db.cursor.CursorParser;
import com.samsung.sr.nmt.core.t2t.translator.helpers.db.cursor.ReplacePairCursorParser;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.loader.CustomReplacePairLoader;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.loader.ReplacePairLoader;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.replacepair.ReplacePair;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ExternalLanguagePackReplacePairLoader.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u001e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0016J&\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/samsung/sr/nmt/core/t2t/translator/helpers/external/ExternalLanguagePackReplacePairLoader;", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/loader/ReplacePairLoader;", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/loader/CustomReplacePairLoader;", "cursorHelper", "Lcom/samsung/sr/nmt/core/t2t/translator/helpers/external/ExternalLanguagePackCursorHelper;", "cursorParser", "Lcom/samsung/sr/nmt/core/t2t/translator/helpers/db/cursor/ReplacePairCursorParser;", "(Lcom/samsung/sr/nmt/core/t2t/translator/helpers/external/ExternalLanguagePackCursorHelper;Lcom/samsung/sr/nmt/core/t2t/translator/helpers/db/cursor/ReplacePairCursorParser;)V", "getReplacePairs", JsonProperty.USE_DEFAULT_NAME, "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/replacepair/ReplacePair;", "sourceLanguage", JsonProperty.USE_DEFAULT_NAME, "targetLanguage", "packageName", "translator_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class ExternalLanguagePackReplacePairLoader implements ReplacePairLoader, CustomReplacePairLoader {
    private final ExternalLanguagePackCursorHelper cursorHelper;
    private final ReplacePairCursorParser cursorParser;

    public ExternalLanguagePackReplacePairLoader(ExternalLanguagePackCursorHelper cursorHelper, ReplacePairCursorParser cursorParser) {
        Intrinsics.checkNotNullParameter(cursorHelper, "cursorHelper");
        Intrinsics.checkNotNullParameter(cursorParser, "cursorParser");
        this.cursorHelper = cursorHelper;
        this.cursorParser = cursorParser;
    }

    @Override // com.samsung.sr.nmt.t2t.translator.core.pipeline.loader.ReplacePairLoader
    public List<ReplacePair> getReplacePairs(String sourceLanguage, String targetLanguage) {
        Intrinsics.checkNotNullParameter(sourceLanguage, "sourceLanguage");
        Intrinsics.checkNotNullParameter(targetLanguage, "targetLanguage");
        return (List) CursorParser.parse$default(this.cursorParser, this.cursorHelper.getCursor(sourceLanguage, targetLanguage), 0, 2, null);
    }

    @Override // com.samsung.sr.nmt.t2t.translator.core.pipeline.loader.CustomReplacePairLoader
    public List<ReplacePair> getReplacePairs(String packageName, String sourceLanguage, String targetLanguage) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        Intrinsics.checkNotNullParameter(sourceLanguage, "sourceLanguage");
        Intrinsics.checkNotNullParameter(targetLanguage, "targetLanguage");
        return (List) CursorParser.parse$default(this.cursorParser, this.cursorHelper.getCustomDBCursor(sourceLanguage, targetLanguage, packageName), 0, 2, null);
    }
}
