package com.samsung.sr.nmt.t2t.translator.core.utils;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LanguagePackKey.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004¨\u0006\u0007"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/utils/LanguagePackKey;", JsonProperty.USE_DEFAULT_NAME, "()V", "get", JsonProperty.USE_DEFAULT_NAME, "sourceLanguage", "targetLanguage", "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class LanguagePackKey {
    public static final LanguagePackKey INSTANCE = new LanguagePackKey();

    private LanguagePackKey() {
    }

    public final String get(String sourceLanguage, String targetLanguage) {
        Intrinsics.checkNotNullParameter(sourceLanguage, "sourceLanguage");
        Intrinsics.checkNotNullParameter(targetLanguage, "targetLanguage");
        List listOf = CollectionsKt.listOf((Object[]) new String[]{sourceLanguage, targetLanguage});
        return Intrinsics.areEqual(sourceLanguage, "en") ? CollectionsKt.joinToString$default(listOf, JsonProperty.USE_DEFAULT_NAME, null, null, 0, null, null, 62, null) : Intrinsics.areEqual(targetLanguage, "en") ? CollectionsKt.joinToString$default(CollectionsKt.reversed(listOf), JsonProperty.USE_DEFAULT_NAME, null, null, 0, null, null, 62, null) : Intrinsics.areEqual(sourceLanguage, "ko") ? CollectionsKt.joinToString$default(listOf, JsonProperty.USE_DEFAULT_NAME, null, null, 0, null, null, 62, null) : Intrinsics.areEqual(targetLanguage, "ko") ? CollectionsKt.joinToString$default(CollectionsKt.reversed(listOf), JsonProperty.USE_DEFAULT_NAME, null, null, 0, null, null, 62, null) : CollectionsKt.joinToString$default(CollectionsKt.sorted(listOf), JsonProperty.USE_DEFAULT_NAME, null, null, 0, null, null, 62, null);
    }
}
