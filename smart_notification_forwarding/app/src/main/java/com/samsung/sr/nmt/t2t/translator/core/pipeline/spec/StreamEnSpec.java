package com.samsung.sr.nmt.t2t.translator.core.pipeline.spec;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.Processor;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* compiled from: StreamEnSpec.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/spec/StreamEnSpec;", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/spec/LanguageSpec;", "()V", "postProcessorList", JsonProperty.USE_DEFAULT_NAME, "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/processors/Processor;", "getPostProcessorList", "()Ljava/util/List;", "preProcessorList", "getPreProcessorList", "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class StreamEnSpec implements LanguageSpec {
    @Inject
    public StreamEnSpec() {
    }

    @Override // com.samsung.sr.nmt.t2t.translator.core.pipeline.spec.LanguageSpec
    public List<Processor> getPreProcessorList() {
        return CollectionsKt.emptyList();
    }

    @Override // com.samsung.sr.nmt.t2t.translator.core.pipeline.spec.LanguageSpec
    public List<Processor> getPostProcessorList() {
        return CollectionsKt.emptyList();
    }
}
