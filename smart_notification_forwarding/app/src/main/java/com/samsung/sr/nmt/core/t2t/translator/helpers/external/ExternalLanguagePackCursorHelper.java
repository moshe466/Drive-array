package com.samsung.sr.nmt.core.t2t.translator.helpers.external;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonPointer;
import com.samsung.sr.nmt.core.t2t.translator.helpers.db.cursor.CursorHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ExternalLanguagePackCursorHelper.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u001a\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0005H\u0016J\"\u0010\u0011\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0005H\u0016R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/samsung/sr/nmt/core/t2t/translator/helpers/external/ExternalLanguagePackCursorHelper;", "Lcom/samsung/sr/nmt/core/t2t/translator/helpers/db/cursor/CursorHelper;", "languagePackManager", "Lcom/samsung/sr/nmt/core/t2t/translator/helpers/external/LanguagePackManager;", "tableName", JsonProperty.USE_DEFAULT_NAME, "contextExtension", "Lcom/samsung/sr/nmt/core/t2t/translator/helpers/external/ContextExtension;", "uriFactory", "Lcom/samsung/sr/nmt/core/t2t/translator/helpers/external/UriFactory;", "(Lcom/samsung/sr/nmt/core/t2t/translator/helpers/external/LanguagePackManager;Ljava/lang/String;Lcom/samsung/sr/nmt/core/t2t/translator/helpers/external/ContextExtension;Lcom/samsung/sr/nmt/core/t2t/translator/helpers/external/UriFactory;)V", "contentResolver", "Landroid/content/ContentResolver;", "getCursor", "Landroid/database/Cursor;", "sourceLanguage", "targetLanguage", "getCustomDBCursor", "packageName", "translator_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class ExternalLanguagePackCursorHelper implements CursorHelper {
    private final ContentResolver contentResolver;
    private final LanguagePackManager languagePackManager;
    private final String tableName;
    private final UriFactory uriFactory;

    public ExternalLanguagePackCursorHelper(LanguagePackManager languagePackManager, String tableName, ContextExtension contextExtension, UriFactory uriFactory) {
        Intrinsics.checkNotNullParameter(languagePackManager, "languagePackManager");
        Intrinsics.checkNotNullParameter(tableName, "tableName");
        Intrinsics.checkNotNullParameter(contextExtension, "contextExtension");
        Intrinsics.checkNotNullParameter(uriFactory, "uriFactory");
        this.languagePackManager = languagePackManager;
        this.tableName = tableName;
        this.uriFactory = uriFactory;
        this.contentResolver = contextExtension.getContentResolver();
    }

    @Override // com.samsung.sr.nmt.core.t2t.translator.helpers.db.cursor.CursorHelper
    public Cursor getCursor(String sourceLanguage, String targetLanguage) {
        Intrinsics.checkNotNullParameter(sourceLanguage, "sourceLanguage");
        Intrinsics.checkNotNullParameter(targetLanguage, "targetLanguage");
        ContentResolver contentResolver = this.contentResolver;
        if (contentResolver == null) {
            return null;
        }
        return contentResolver.query(this.uriFactory.parse("content://" + this.languagePackManager.getAuthority(sourceLanguage, targetLanguage) + JsonPointer.SEPARATOR + this.tableName), null, null, null, null);
    }

    @Override // com.samsung.sr.nmt.core.t2t.translator.helpers.db.cursor.CursorHelper
    public Cursor getCustomDBCursor(String sourceLanguage, String targetLanguage, String packageName) {
        Intrinsics.checkNotNullParameter(sourceLanguage, "sourceLanguage");
        Intrinsics.checkNotNullParameter(targetLanguage, "targetLanguage");
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        ContentResolver contentResolver = this.contentResolver;
        if (contentResolver != null) {
            return contentResolver.query(new Uri.Builder().scheme("content").authority(this.languagePackManager.getAuthority(sourceLanguage, targetLanguage)).path(this.tableName).appendQueryParameter("packageName", packageName).build(), null, null, null, null);
        }
        return null;
    }
}
