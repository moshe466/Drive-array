package com.samsung.sr.nmt.t2t.translator.core.pipeline.processors;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.tagged.TagData;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.tagged.TagNode;
import java.util.Iterator;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TagClosingProcessor.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0014¨\u0006\u0007"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/processors/TagClosingProcessor;", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/processors/Processor;", "()V", "process", JsonProperty.USE_DEFAULT_NAME, "job", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/processors/ProcessorJob;", "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class TagClosingProcessor extends Processor {
    @Inject
    public TagClosingProcessor() {
    }

    @Override // com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.Processor
    protected void process(ProcessorJob job) {
        Intrinsics.checkNotNullParameter(job, "job");
        String simpleName = getClass().getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName, "getSimpleName(...)");
        job.withJob(simpleName, new Function1<ProcessorJob, Unit>() { // from class: com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.TagClosingProcessor$process$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ProcessorJob processorJob) {
                invoke2(processorJob);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ProcessorJob currentJob) {
                String str;
                Intrinsics.checkNotNullParameter(currentJob, "currentJob");
                for (ProcessingTask processingTask : currentJob.getTasks()) {
                    Iterator it = CollectionsKt.asReversedMutable(processingTask.getRoot().getEncloseTags()).iterator();
                    while (it.hasNext()) {
                        TagData tagData = ((TagNode) it.next()).getTagData();
                        if (tagData != null) {
                            if (!(tagData.getTagName().length() > 0)) {
                                tagData = null;
                            }
                            if (tagData != null) {
                                AtomicProcessingTask root = processingTask.getRoot();
                                String tagName = tagData.getTagName();
                                String attribute = tagData.getAttribute();
                                if (attribute == null || (str = " " + attribute) == null) {
                                    str = JsonProperty.USE_DEFAULT_NAME;
                                }
                                root.setCurrentText("<" + tagName + str + ">" + processingTask.getRoot().getCurrentText() + "</" + tagData.getTagName() + ">");
                            }
                        }
                    }
                }
            }
        });
    }
}
