package com.samsung.sr.nmt.core.t2t.translator.helpers.db;

import android.content.Context;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.samsung.sr.nmt.core.t2t.translator.helpers.db.cursor.SwearWordRuleCursorParser;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.loader.CustomSwearWordRuleLoader;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.swearword.SwearWordRule;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CustomSwearWordRuleLoaderImpl.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ&\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/samsung/sr/nmt/core/t2t/translator/helpers/db/CustomSwearWordRuleLoaderImpl;", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/loader/CustomSwearWordRuleLoader;", "context", "Landroid/content/Context;", "directory", "Ljava/io/File;", "cursorParser", "Lcom/samsung/sr/nmt/core/t2t/translator/helpers/db/cursor/SwearWordRuleCursorParser;", "(Landroid/content/Context;Ljava/io/File;Lcom/samsung/sr/nmt/core/t2t/translator/helpers/db/cursor/SwearWordRuleCursorParser;)V", "getAllRules", JsonProperty.USE_DEFAULT_NAME, "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/swearword/SwearWordRule;", "packageName", JsonProperty.USE_DEFAULT_NAME, "sourceLanguage", "targetLanguage", "translator_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class CustomSwearWordRuleLoaderImpl implements CustomSwearWordRuleLoader {
    private final Context context;
    private final SwearWordRuleCursorParser cursorParser;
    private final File directory;

    public CustomSwearWordRuleLoaderImpl(Context context, File directory, SwearWordRuleCursorParser cursorParser) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(cursorParser, "cursorParser");
        this.context = context;
        this.directory = directory;
        this.cursorParser = cursorParser;
    }

    public /* synthetic */ CustomSwearWordRuleLoaderImpl(Context context, File file, SwearWordRuleCursorParser swearWordRuleCursorParser, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : file, swearWordRuleCursorParser);
    }

    @Override // com.samsung.sr.nmt.t2t.translator.core.pipeline.loader.CustomSwearWordRuleLoader
    public List<SwearWordRule> getAllRules(String packageName, String sourceLanguage, String targetLanguage) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        Intrinsics.checkNotNullParameter(sourceLanguage, "sourceLanguage");
        Intrinsics.checkNotNullParameter(targetLanguage, "targetLanguage");
        return this.cursorParser.parse(CustomizationDataBase.INSTANCE.getInstance(this.context, this.directory).getCustomSwearWordRuleDao().findAll(packageName), 1);
    }
}
