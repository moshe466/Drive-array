package com.samsung.sr.nmt.t2t.translator.core.pipeline.processors;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.placeholder.PlaceholderStorage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PlaceholderPostProcessor.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0014¨\u0006\u0007"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/processors/PlaceholderPostProcessor;", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/processors/Processor;", "()V", "process", JsonProperty.USE_DEFAULT_NAME, "job", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/processors/ProcessorJob;", "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class PlaceholderPostProcessor extends Processor {
    @Override // com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.Processor
    protected void process(ProcessorJob job) {
        Intrinsics.checkNotNullParameter(job, "job");
        String simpleName = getClass().getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName, "getSimpleName(...)");
        job.withJob(simpleName, new Function1<ProcessorJob, Unit>() { // from class: com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.PlaceholderPostProcessor$process$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ProcessorJob processorJob) {
                invoke2(processorJob);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ProcessorJob currentJob) {
                Unit unit;
                Intrinsics.checkNotNullParameter(currentJob, "currentJob");
                List<ProcessingTask> tasks = currentJob.getTasks();
                ArrayList arrayList = new ArrayList();
                for (Object obj : tasks) {
                    if (!((ProcessingTask) obj).getRoot().isFinished()) {
                        arrayList.add(obj);
                    }
                }
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    List<AtomicProcessingTask> leaves = ((ProcessingTask) it.next()).getLeaves();
                    ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(leaves, 10));
                    for (AtomicProcessingTask atomicProcessingTask : leaves) {
                        PlaceholderStorage placeholderStorage = atomicProcessingTask.getPlaceholderStorage();
                        if (placeholderStorage != null) {
                            atomicProcessingTask.setCurrentText(placeholderStorage.recover(atomicProcessingTask.getCurrentText()));
                            unit = Unit.INSTANCE;
                        } else {
                            unit = null;
                        }
                        arrayList2.add(unit);
                    }
                }
            }
        });
    }
}
