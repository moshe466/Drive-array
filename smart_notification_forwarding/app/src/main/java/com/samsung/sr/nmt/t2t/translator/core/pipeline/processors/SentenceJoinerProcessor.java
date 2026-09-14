package com.samsung.sr.nmt.t2t.translator.core.pipeline.processors;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SentenceJoinerProcessor.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0014¨\u0006\u0007"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/processors/SentenceJoinerProcessor;", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/processors/Processor;", "()V", "process", JsonProperty.USE_DEFAULT_NAME, "job", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/processors/ProcessorJob;", "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class SentenceJoinerProcessor extends Processor {
    @Inject
    public SentenceJoinerProcessor() {
    }

    @Override // com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.Processor
    protected void process(ProcessorJob job) {
        Intrinsics.checkNotNullParameter(job, "job");
        String simpleName = getClass().getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName, "getSimpleName(...)");
        job.withJob(simpleName, new Function1<ProcessorJob, Unit>() { // from class: com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.SentenceJoinerProcessor$process$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ProcessorJob processorJob) {
                invoke2(processorJob);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ProcessorJob it) {
                boolean z;
                Intrinsics.checkNotNullParameter(it, "it");
                for (ProcessingTask processingTask : it.getTasks()) {
                    Stack stack = new Stack();
                    stack.push(processingTask.getRoot());
                    while (true) {
                        boolean z2 = true;
                        if (!stack.isEmpty()) {
                            AtomicProcessingTask atomicProcessingTask = (AtomicProcessingTask) stack.pop();
                            if (!atomicProcessingTask.isLeaf()) {
                                List<AtomicProcessingTask> children = atomicProcessingTask.getChildren();
                                if (!(children instanceof Collection) || !children.isEmpty()) {
                                    Iterator<T> it2 = children.iterator();
                                    while (it2.hasNext()) {
                                        if (!((AtomicProcessingTask) it2.next()).isLeaf()) {
                                            z = false;
                                            break;
                                        }
                                    }
                                }
                                z = true;
                                if (z) {
                                    List<AtomicProcessingTask> children2 = atomicProcessingTask.getChildren();
                                    ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(children2, 10));
                                    Iterator<T> it3 = children2.iterator();
                                    while (it3.hasNext()) {
                                        arrayList.add(((AtomicProcessingTask) it3.next()).getCurrentText());
                                    }
                                    ArrayList arrayList2 = arrayList;
                                    List<AtomicProcessingTask> children3 = atomicProcessingTask.getChildren();
                                    ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(children3, 10));
                                    Iterator<T> it4 = children3.iterator();
                                    while (it4.hasNext()) {
                                        arrayList3.add(((AtomicProcessingTask) it4.next()).getPivotResult());
                                    }
                                    ArrayList arrayList4 = arrayList3;
                                    atomicProcessingTask.setCurrentText(CollectionsKt.joinToString$default(arrayList2, atomicProcessingTask.getDelimiter(), null, null, 0, null, null, 62, null));
                                    ArrayList arrayList5 = arrayList4;
                                    if (!(arrayList5 instanceof Collection) || !arrayList5.isEmpty()) {
                                        Iterator it5 = arrayList5.iterator();
                                        while (true) {
                                            if (!it5.hasNext()) {
                                                break;
                                            }
                                            if (!(((String) it5.next()) != null)) {
                                                z2 = false;
                                                break;
                                            }
                                        }
                                    }
                                    if (!Boolean.valueOf(z2).booleanValue()) {
                                        arrayList4 = null;
                                    }
                                    atomicProcessingTask.setPivotResult(arrayList4 != null ? CollectionsKt.joinToString$default(arrayList4, atomicProcessingTask.getDelimiter(), null, null, 0, null, null, 62, null) : null);
                                    atomicProcessingTask.getChildren().clear();
                                } else {
                                    stack.push(atomicProcessingTask);
                                    Iterator<T> it6 = atomicProcessingTask.getChildren().iterator();
                                    while (it6.hasNext()) {
                                        stack.push((AtomicProcessingTask) it6.next());
                                    }
                                }
                            }
                        }
                    }
                }
            }
        });
    }
}
