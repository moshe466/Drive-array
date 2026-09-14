package com.samsung.sr.nmt.core.t2t.translator.helpers.external;

import android.net.Uri;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UriFactory.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/samsung/sr/nmt/core/t2t/translator/helpers/external/UriFactory;", JsonProperty.USE_DEFAULT_NAME, "()V", "parse", "Landroid/net/Uri;", ExternalLanguagePackAssetLoader.PATH_QUERY, JsonProperty.USE_DEFAULT_NAME, "translator_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class UriFactory {
    public final Uri parse(String path) {
        Intrinsics.checkNotNullParameter(path, "path");
        Uri parse = Uri.parse(path);
        Intrinsics.checkNotNullExpressionValue(parse, "parse(...)");
        return parse;
    }
}
