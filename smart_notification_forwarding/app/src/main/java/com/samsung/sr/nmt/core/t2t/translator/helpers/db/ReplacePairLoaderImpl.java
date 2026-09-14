package com.samsung.sr.nmt.core.t2t.translator.helpers.db;

import android.content.Context;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.samsung.sr.nmt.core.t2t.translator.helpers.db.cursor.CursorParser;
import com.samsung.sr.nmt.core.t2t.translator.helpers.db.cursor.ReplacePairCursorParser;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.loader.ReplacePairLoader;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.replacepair.ReplacePair;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ReplacePairLoaderImpl.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/samsung/sr/nmt/core/t2t/translator/helpers/db/ReplacePairLoaderImpl;", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/loader/ReplacePairLoader;", "context", "Landroid/content/Context;", "cursorParser", "Lcom/samsung/sr/nmt/core/t2t/translator/helpers/db/cursor/ReplacePairCursorParser;", "(Landroid/content/Context;Lcom/samsung/sr/nmt/core/t2t/translator/helpers/db/cursor/ReplacePairCursorParser;)V", "getReplacePairs", JsonProperty.USE_DEFAULT_NAME, "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/replacepair/ReplacePair;", "sourceLanguage", JsonProperty.USE_DEFAULT_NAME, "targetLanguage", "translator_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class ReplacePairLoaderImpl implements ReplacePairLoader {
    private final Context context;
    private final ReplacePairCursorParser cursorParser;

    public ReplacePairLoaderImpl(Context context, ReplacePairCursorParser cursorParser) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(cursorParser, "cursorParser");
        this.context = context;
        this.cursorParser = cursorParser;
    }

    @Override // com.samsung.sr.nmt.t2t.translator.core.pipeline.loader.ReplacePairLoader
    public List<ReplacePair> getReplacePairs(String sourceLanguage, String targetLanguage) {
        Intrinsics.checkNotNullParameter(sourceLanguage, "sourceLanguage");
        Intrinsics.checkNotNullParameter(targetLanguage, "targetLanguage");
        return (List) CursorParser.parse$default(this.cursorParser, ReplacePairDataBase.INSTANCE.getInstance(this.context).getReplacePairDao().find(sourceLanguage, targetLanguage), 0, 2, null);
    }
}
