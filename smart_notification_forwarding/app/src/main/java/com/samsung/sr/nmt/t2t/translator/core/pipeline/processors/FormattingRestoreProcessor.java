package com.samsung.sr.nmt.t2t.translator.core.pipeline.processors;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.formatting.FormattingRules;
import java.util.Iterator;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FormattingRestoreProcessor.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0014J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002¨\u0006\b"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/processors/FormattingRestoreProcessor;", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/processors/Processor;", "()V", "process", JsonProperty.USE_DEFAULT_NAME, "job", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/processors/ProcessorJob;", "restoreFormattingRules", "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class FormattingRestoreProcessor extends Processor {
    @Inject
    public FormattingRestoreProcessor() {
    }

    @Override // com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.Processor
    protected void process(ProcessorJob job) {
        Intrinsics.checkNotNullParameter(job, "job");
        restoreFormattingRules(job);
    }

    private final void restoreFormattingRules(ProcessorJob job) {
        String simpleName = getClass().getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName, "getSimpleName(...)");
        job.withJob(simpleName, new Function1<ProcessorJob, Unit>() { // from class: com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.FormattingRestoreProcessor$restoreFormattingRules$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ProcessorJob processorJob) {
                invoke2(processorJob);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ProcessorJob currentJob) {
                Intrinsics.checkNotNullParameter(currentJob, "currentJob");
                for (ProcessingTask processingTask : currentJob.getTasks()) {
                    Iterator it = CollectionsKt.asReversed(processingTask.getLeaves()).iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        AtomicProcessingTask atomicProcessingTask = (AtomicProcessingTask) it.next();
                        if (!atomicProcessingTask.getFormattingRules().isEmpty()) {
                            if (processingTask.getRoot().getCurrentText().length() == 0) {
                                atomicProcessingTask.setCurrentText(((FormattingRules) CollectionsKt.removeLast(atomicProcessingTask.getFormattingRules())).restore(atomicProcessingTask.getCurrentText()));
                            }
                        }
                    }
                    AtomicProcessingTask root = processingTask.getRoot();
                    if ((root.getCurrentText().length() > 0) && (!root.getFormattingRules().isEmpty())) {
                        root.setCurrentText(((FormattingRules) CollectionsKt.removeLast(root.getFormattingRules())).restore(root.getCurrentText()));
                    }
                }
            }
        });
    }
}
