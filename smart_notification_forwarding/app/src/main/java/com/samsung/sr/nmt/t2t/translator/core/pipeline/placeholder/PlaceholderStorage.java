package com.samsung.sr.nmt.t2t.translator.core.pipeline.placeholder;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.util.DataExchanger;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: PlaceholderStorage.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0005H\u0014J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0002H\u0016J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0002H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0002X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/placeholder/PlaceholderStorage;", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/util/DataExchanger;", JsonProperty.USE_DEFAULT_NAME, "placeholderToken", "limit", JsonProperty.USE_DEFAULT_NAME, "(Ljava/lang/String;I)V", "generateDataTag", "currentDataCount", "keep", "data", "recover", "partialKeptData", "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class PlaceholderStorage extends DataExchanger<String, String> {
    private final int limit;
    private final String placeholderToken;

    public PlaceholderStorage(String placeholderToken, int i) {
        Intrinsics.checkNotNullParameter(placeholderToken, "placeholderToken");
        this.placeholderToken = placeholderToken;
        this.limit = i;
    }

    @Override // com.samsung.sr.nmt.t2t.translator.core.pipeline.util.DataExchanger, com.samsung.sr.nmt.t2t.translator.core.pipeline.util.DataKeeper
    public String keep(String data) {
        Intrinsics.checkNotNullParameter(data, "data");
        return this.limit > getDataCounter() ? super.keep((PlaceholderStorage) data) : data;
    }

    @Override // com.samsung.sr.nmt.t2t.translator.core.pipeline.util.DataRecover
    public String recover(String partialKeptData) {
        Intrinsics.checkNotNullParameter(partialKeptData, "partialKeptData");
        int i = 0;
        String str = partialKeptData;
        for (String str2 : getStorageStream()) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            str = StringsKt.replace$default(str, generateDataTag(i), str2, false, 4, (Object) null);
            i = i2;
        }
        return str;
    }

    @Override // com.samsung.sr.nmt.t2t.translator.core.pipeline.util.DataExchanger
    protected String generateDataTag(int currentDataCount) {
        return StringsKt.replace$default(this.placeholderToken, "?", String.valueOf(currentDataCount), false, 4, (Object) null);
    }
}
