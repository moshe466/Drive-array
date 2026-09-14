package com.samsung.sr.nmt.core.t2t.translator.helpers.db;

import android.content.Context;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.samsung.sr.nmt.core.t2t.translator.helpers.db.cursor.TranslationMemoryCursorParser;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.loader.CustomTranslationMemoryLoader;
import com.samsung.sr.nmt.t2t.translator.core.utils.LanguageDirection;
import java.io.File;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CustomTranslationMemoryLoaderImpl.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ8\u0010\r\u001a\u001a\u0012\u0004\u0012\u00020\u000f\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00110\u00100\u000e2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0011H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0015"}, d2 = {"Lcom/samsung/sr/nmt/core/t2t/translator/helpers/db/CustomTranslationMemoryLoaderImpl;", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/loader/CustomTranslationMemoryLoader;", "context", "Landroid/content/Context;", "directory", "Ljava/io/File;", "cursorParser", "Lcom/samsung/sr/nmt/core/t2t/translator/helpers/db/cursor/TranslationMemoryCursorParser;", "(Landroid/content/Context;Ljava/io/File;Lcom/samsung/sr/nmt/core/t2t/translator/helpers/db/cursor/TranslationMemoryCursorParser;)V", "getContext", "()Landroid/content/Context;", "getDirectory", "()Ljava/io/File;", "getAllMemories", JsonProperty.USE_DEFAULT_NAME, "Lcom/samsung/sr/nmt/t2t/translator/core/utils/LanguageDirection;", JsonProperty.USE_DEFAULT_NAME, JsonProperty.USE_DEFAULT_NAME, "packageName", "sourceLanguage", "targetLanguage", "translator_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class CustomTranslationMemoryLoaderImpl implements CustomTranslationMemoryLoader {
    private final Context context;
    private final TranslationMemoryCursorParser cursorParser;
    private final File directory;

    public CustomTranslationMemoryLoaderImpl(Context context, File directory, TranslationMemoryCursorParser cursorParser) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(cursorParser, "cursorParser");
        this.context = context;
        this.directory = directory;
        this.cursorParser = cursorParser;
    }

    public /* synthetic */ CustomTranslationMemoryLoaderImpl(Context context, File file, TranslationMemoryCursorParser translationMemoryCursorParser, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : file, translationMemoryCursorParser);
    }

    public final Context getContext() {
        return this.context;
    }

    public final File getDirectory() {
        return this.directory;
    }

    @Override // com.samsung.sr.nmt.t2t.translator.core.pipeline.loader.CustomTranslationMemoryLoader
    public Map<LanguageDirection, Map<String, String>> getAllMemories(String packageName, String sourceLanguage, String targetLanguage) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        Intrinsics.checkNotNullParameter(sourceLanguage, "sourceLanguage");
        Intrinsics.checkNotNullParameter(targetLanguage, "targetLanguage");
        return this.cursorParser.parse(CustomizationDataBase.INSTANCE.getInstance(this.context, this.directory).getCustomTranslationMemoryDao().find(packageName, sourceLanguage, targetLanguage), 1);
    }
}
