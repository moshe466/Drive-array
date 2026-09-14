package com.samsung.sr.nmt.t2t.translator.core.pipeline.util;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;

/* compiled from: DataRecover.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u0015\u0010\u0003\u001a\u00028\u00002\u0006\u0010\u0004\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/util/DataRecover;", "T", JsonProperty.USE_DEFAULT_NAME, "recover", "partialKeptData", "(Ljava/lang/Object;)Ljava/lang/Object;", "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public interface DataRecover<T> {
    T recover(T partialKeptData);
}
