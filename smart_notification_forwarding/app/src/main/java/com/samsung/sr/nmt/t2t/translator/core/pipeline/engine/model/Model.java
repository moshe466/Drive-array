package com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.model;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import kotlin.Metadata;

/* compiled from: Model.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J&\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0005H&¨\u0006\u000e"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/model/Model;", JsonProperty.USE_DEFAULT_NAME, "clear", JsonProperty.USE_DEFAULT_NAME, "isLoaded", JsonProperty.USE_DEFAULT_NAME, "load", "translate", JsonProperty.USE_DEFAULT_NAME, "idList", JsonProperty.USE_DEFAULT_NAME, JsonProperty.USE_DEFAULT_NAME, "batchSize", "verbose", "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public interface Model {
    void clear();

    boolean isLoaded();

    void load();

    int[] translate(List<Integer> idList, int batchSize, boolean verbose);
}
