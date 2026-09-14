package com.samsung.sr.nmt.t2t.translator.core.pipeline.processors;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.Engine;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HonorificTagHandler.kt */
@Singleton
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/processors/HonorificTagHandler;", JsonProperty.USE_DEFAULT_NAME, "()V", "processHonorificTag", JsonProperty.USE_DEFAULT_NAME, "engine", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/Engine;", "job", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/processors/ProcessorJob;", "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class HonorificTagHandler {
    @Inject
    public HonorificTagHandler() {
    }

    public final void processHonorificTag(final Engine engine, ProcessorJob job) {
        Intrinsics.checkNotNullParameter(engine, "engine");
        Intrinsics.checkNotNullParameter(job, "job");
        if (engine.getTransformerSpec().getProcessHonorificTag()) {
            String simpleName = getClass().getSimpleName();
            Intrinsics.checkNotNullExpressionValue(simpleName, "getSimpleName(...)");
            job.withJob(simpleName, new Function1<ProcessorJob, Unit>() { // from class: com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.HonorificTagHandler$processHonorificTag$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(ProcessorJob processorJob) {
                    invoke2(processorJob);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(ProcessorJob currentJob) {
                    Intrinsics.checkNotNullParameter(currentJob, "currentJob");
                    List<ProcessingTask> tasks = currentJob.getTasks();
                    ArrayList arrayList = new ArrayList();
                    Iterator<T> it = tasks.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        Object next = it.next();
                        ProcessingTask processingTask = (ProcessingTask) next;
                        if (processingTask.getTranslationTask().getFormality() && Intrinsics.areEqual(processingTask.getTranslationTask().getTargetLanguageCode(), "ko")) {
                            arrayList.add(next);
                        }
                    }
                    Engine engine2 = Engine.this;
                    Iterator it2 = arrayList.iterator();
                    while (it2.hasNext()) {
                        List<AtomicProcessingTask> leaves = ((ProcessingTask) it2.next()).getLeaves();
                        ArrayList<AtomicProcessingTask> arrayList2 = new ArrayList();
                        for (Object obj : leaves) {
                            if (!((AtomicProcessingTask) obj).isFinished()) {
                                arrayList2.add(obj);
                            }
                        }
                        for (AtomicProcessingTask atomicProcessingTask : arrayList2) {
                            atomicProcessingTask.setCurrentText(engine2.getTransformerSpec().getHonorificTok() + " " + atomicProcessingTask.getCurrentText());
                        }
                    }
                }
            });
        }
    }
}
