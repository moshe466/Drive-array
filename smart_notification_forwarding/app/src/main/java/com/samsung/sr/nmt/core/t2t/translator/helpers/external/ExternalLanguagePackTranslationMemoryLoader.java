package com.samsung.sr.nmt.core.t2t.translator.helpers.external;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.samsung.sr.nmt.core.t2t.translator.helpers.db.cursor.CursorHelper;
import com.samsung.sr.nmt.core.t2t.translator.helpers.db.cursor.CursorParser;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.loader.CustomTranslationMemoryLoader;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.loader.TranslationMemoryLoader;
import com.samsung.sr.nmt.t2t.translator.core.utils.LanguageDirection;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ExternalLanguagePackTranslationMemoryLoader.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B3\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012$\u0010\u0005\u001a \u0012\u001c\u0012\u001a\u0012\u0004\u0012\u00020\b\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\t0\u00070\u0006¢\u0006\u0002\u0010\u000bJ0\u0010\f\u001a\u001a\u0012\u0004\u0012\u00020\b\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\t0\u00072\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\nH\u0016J8\u0010\f\u001a\u001a\u0012\u0004\u0012\u00020\b\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\t0\u00072\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\nH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R,\u0010\u0005\u001a \u0012\u001c\u0012\u001a\u0012\u0004\u0012\u00020\b\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\t0\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/samsung/sr/nmt/core/t2t/translator/helpers/external/ExternalLanguagePackTranslationMemoryLoader;", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/loader/TranslationMemoryLoader;", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/loader/CustomTranslationMemoryLoader;", "cursorHelper", "Lcom/samsung/sr/nmt/core/t2t/translator/helpers/db/cursor/CursorHelper;", "cursorParser", "Lcom/samsung/sr/nmt/core/t2t/translator/helpers/db/cursor/CursorParser;", JsonProperty.USE_DEFAULT_NAME, "Lcom/samsung/sr/nmt/t2t/translator/core/utils/LanguageDirection;", JsonProperty.USE_DEFAULT_NAME, JsonProperty.USE_DEFAULT_NAME, "(Lcom/samsung/sr/nmt/core/t2t/translator/helpers/db/cursor/CursorHelper;Lcom/samsung/sr/nmt/core/t2t/translator/helpers/db/cursor/CursorParser;)V", "getAllMemories", "sourceLanguage", "targetLanguage", "packageName", "translator_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class ExternalLanguagePackTranslationMemoryLoader implements TranslationMemoryLoader, CustomTranslationMemoryLoader {
    private final CursorHelper cursorHelper;
    private final CursorParser<Map<LanguageDirection, Map<String, String>>> cursorParser;

    public ExternalLanguagePackTranslationMemoryLoader(CursorHelper cursorHelper, CursorParser<Map<LanguageDirection, Map<String, String>>> cursorParser) {
        Intrinsics.checkNotNullParameter(cursorHelper, "cursorHelper");
        Intrinsics.checkNotNullParameter(cursorParser, "cursorParser");
        this.cursorHelper = cursorHelper;
        this.cursorParser = cursorParser;
    }

    @Override // com.samsung.sr.nmt.t2t.translator.core.pipeline.loader.TranslationMemoryLoader
    public Map<LanguageDirection, Map<String, String>> getAllMemories(String sourceLanguage, String targetLanguage) {
        Intrinsics.checkNotNullParameter(sourceLanguage, "sourceLanguage");
        Intrinsics.checkNotNullParameter(targetLanguage, "targetLanguage");
        return (Map) CursorParser.parse$default(this.cursorParser, this.cursorHelper.getCursor(sourceLanguage, targetLanguage), 0, 2, null);
    }

    @Override // com.samsung.sr.nmt.t2t.translator.core.pipeline.loader.CustomTranslationMemoryLoader
    public Map<LanguageDirection, Map<String, String>> getAllMemories(String packageName, String sourceLanguage, String targetLanguage) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        Intrinsics.checkNotNullParameter(sourceLanguage, "sourceLanguage");
        Intrinsics.checkNotNullParameter(targetLanguage, "targetLanguage");
        return (Map) CursorParser.parse$default(this.cursorParser, this.cursorHelper.getCustomDBCursor(sourceLanguage, targetLanguage, packageName), 0, 2, null);
    }
}
