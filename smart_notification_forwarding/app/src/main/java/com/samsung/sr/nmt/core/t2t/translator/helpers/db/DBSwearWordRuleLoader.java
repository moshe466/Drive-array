package com.samsung.sr.nmt.core.t2t.translator.helpers.db;

import android.content.Context;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.samsung.sr.nmt.core.t2t.translator.helpers.db.cursor.CursorParser;
import com.samsung.sr.nmt.core.t2t.translator.helpers.db.cursor.SwearWordRuleCursorParser;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.loader.SwearWordRuleLoader;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.swearword.SwearWordRule;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DBSwearWordRuleLoader.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u001e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0011"}, d2 = {"Lcom/samsung/sr/nmt/core/t2t/translator/helpers/db/DBSwearWordRuleLoader;", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/loader/SwearWordRuleLoader;", "context", "Landroid/content/Context;", "directory", "Ljava/io/File;", "cursorParser", "Lcom/samsung/sr/nmt/core/t2t/translator/helpers/db/cursor/SwearWordRuleCursorParser;", "(Landroid/content/Context;Ljava/io/File;Lcom/samsung/sr/nmt/core/t2t/translator/helpers/db/cursor/SwearWordRuleCursorParser;)V", "getDirectory", "()Ljava/io/File;", "getAllRules", JsonProperty.USE_DEFAULT_NAME, "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/swearword/SwearWordRule;", "sourceLanguage", JsonProperty.USE_DEFAULT_NAME, "targetLanguage", "translator_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class DBSwearWordRuleLoader implements SwearWordRuleLoader {
    private final Context context;
    private final SwearWordRuleCursorParser cursorParser;
    private final File directory;

    public DBSwearWordRuleLoader(Context context, File directory, SwearWordRuleCursorParser cursorParser) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(cursorParser, "cursorParser");
        this.context = context;
        this.directory = directory;
        this.cursorParser = cursorParser;
    }

    public /* synthetic */ DBSwearWordRuleLoader(Context context, File file, SwearWordRuleCursorParser swearWordRuleCursorParser, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : file, swearWordRuleCursorParser);
    }

    public final File getDirectory() {
        return this.directory;
    }

    @Override // com.samsung.sr.nmt.t2t.translator.core.pipeline.loader.SwearWordRuleLoader
    public List<SwearWordRule> getAllRules(String sourceLanguage, String targetLanguage) {
        Intrinsics.checkNotNullParameter(sourceLanguage, "sourceLanguage");
        Intrinsics.checkNotNullParameter(targetLanguage, "targetLanguage");
        return (List) CursorParser.parse$default(this.cursorParser, TranslationMemoryDataBase.INSTANCE.getInstance(this.context, this.directory).getSwearWordRuleDao().findAll(), 0, 2, null);
    }
}
