package com.samsung.sr.nmt.core.t2t.translator.helpers.db.cursor;

import android.database.Cursor;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.samsung.sr.nmt.t2t.translator.core.utils.LanguageDirection;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

/* compiled from: TranslationMemoryCursorParser.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 \f2 \u0012\u001c\u0012\u001a\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00040\u00020\u0001:\u0001\fB\u0005¢\u0006\u0002\u0010\u0006J2\u0010\u0007\u001a\u001a\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00040\u00022\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\r"}, d2 = {"Lcom/samsung/sr/nmt/core/t2t/translator/helpers/db/cursor/TranslationMemoryCursorParser;", "Lcom/samsung/sr/nmt/core/t2t/translator/helpers/db/cursor/CursorParser;", JsonProperty.USE_DEFAULT_NAME, "Lcom/samsung/sr/nmt/t2t/translator/core/utils/LanguageDirection;", JsonProperty.USE_DEFAULT_NAME, JsonProperty.USE_DEFAULT_NAME, "()V", "parse", "cursor", "Landroid/database/Cursor;", "indexOffset", JsonProperty.USE_DEFAULT_NAME, "Companion", "translator_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class TranslationMemoryCursorParser implements CursorParser<Map<LanguageDirection, ? extends Map<String, String>>> {
    private static final int SOURCE_LANGUAGE_INDEX = 0;
    private static final int SOURCE_TEXT_INDEX = 2;
    private static final int TARGET_LANGUAGE_INDEX = 1;
    private static final int TARGET_TEXT_INDEX = 3;

    @Override // com.samsung.sr.nmt.core.t2t.translator.helpers.db.cursor.CursorParser
    public Map<LanguageDirection, ? extends Map<String, String>> parse(Cursor cursor, int indexOffset) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (cursor != null) {
            Cursor cursor2 = cursor;
            try {
                Cursor cursor3 = cursor2;
                cursor3.moveToFirst();
                int count = cursor.getCount();
                for (int i = 0; i < count; i++) {
                    String string = cursor3.getString(indexOffset + 0);
                    Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                    String string2 = cursor3.getString(indexOffset + 1);
                    Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                    LanguageDirection languageDirection = new LanguageDirection(string, string2);
                    LinkedHashMap linkedHashMap2 = (Map) linkedHashMap.get(languageDirection);
                    if (linkedHashMap2 == null) {
                        linkedHashMap2 = new LinkedHashMap();
                        linkedHashMap.put(languageDirection, linkedHashMap2);
                    }
                    String string3 = cursor3.getString(indexOffset + 2);
                    Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
                    String string4 = cursor3.getString(indexOffset + 3);
                    Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
                    linkedHashMap2.put(string3, string4);
                    cursor.moveToNext();
                }
                Timber.d(cursor.getCount() + " Translation Memory loaded", new Object[0]);
                CloseableKt.closeFinally(cursor2, null);
            } finally {
            }
        }
        return linkedHashMap;
    }
}
