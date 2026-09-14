package com.samsung.sr.nmt.core.t2t.translator.helpers.db;

import android.content.Context;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.samsung.sr.nmt.core.t2t.translator.helpers.db.cursor.CursorParser;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.loader.TranslationMemoryLoader;
import com.samsung.sr.nmt.t2t.translator.core.utils.LanguageDirection;
import java.io.File;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DBTranslationMemoryLoader.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012$\u0010\u0006\u001a \u0012\u001c\u0012\u001a\u0012\u0004\u0012\u00020\t\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\n0\b0\u0007¢\u0006\u0002\u0010\fJ0\u0010\u0011\u001a\u001a\u0012\u0004\u0012\u00020\t\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\n0\b2\u0006\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u000bH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR,\u0010\u0006\u001a \u0012\u001c\u0012\u001a\u0012\u0004\u0012\u00020\t\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\n0\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, d2 = {"Lcom/samsung/sr/nmt/core/t2t/translator/helpers/db/DBTranslationMemoryLoader;", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/loader/TranslationMemoryLoader;", "context", "Landroid/content/Context;", "directory", "Ljava/io/File;", "cursorParser", "Lcom/samsung/sr/nmt/core/t2t/translator/helpers/db/cursor/CursorParser;", JsonProperty.USE_DEFAULT_NAME, "Lcom/samsung/sr/nmt/t2t/translator/core/utils/LanguageDirection;", JsonProperty.USE_DEFAULT_NAME, JsonProperty.USE_DEFAULT_NAME, "(Landroid/content/Context;Ljava/io/File;Lcom/samsung/sr/nmt/core/t2t/translator/helpers/db/cursor/CursorParser;)V", "getContext", "()Landroid/content/Context;", "getDirectory", "()Ljava/io/File;", "getAllMemories", "sourceLanguage", "targetLanguage", "translator_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class DBTranslationMemoryLoader implements TranslationMemoryLoader {
    private final Context context;
    private final CursorParser<Map<LanguageDirection, Map<String, String>>> cursorParser;
    private final File directory;

    public DBTranslationMemoryLoader(Context context, File directory, CursorParser<Map<LanguageDirection, Map<String, String>>> cursorParser) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(cursorParser, "cursorParser");
        this.context = context;
        this.directory = directory;
        this.cursorParser = cursorParser;
    }

    public /* synthetic */ DBTranslationMemoryLoader(Context context, File file, CursorParser cursorParser, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : file, cursorParser);
    }

    public final Context getContext() {
        return this.context;
    }

    public final File getDirectory() {
        return this.directory;
    }

    @Override // com.samsung.sr.nmt.t2t.translator.core.pipeline.loader.TranslationMemoryLoader
    public Map<LanguageDirection, Map<String, String>> getAllMemories(String sourceLanguage, String targetLanguage) {
        Intrinsics.checkNotNullParameter(sourceLanguage, "sourceLanguage");
        Intrinsics.checkNotNullParameter(targetLanguage, "targetLanguage");
        return (Map) CursorParser.parse$default(this.cursorParser, TranslationMemoryDataBase.INSTANCE.getInstance(this.context, this.directory).getTranslationMemoryDao().findAll(), 0, 2, null);
    }
}
