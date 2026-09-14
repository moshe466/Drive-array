package com.samsung.sr.nmt.t2t.translator.core.pipeline.processors;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.splitter.SplitRule;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.splitter.SplitterManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: SentenceSplitterProcessor.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0014J$\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\f\u001a\u00020\u000b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\nH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/processors/SentenceSplitterProcessor;", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/processors/Processor;", "splitterManager", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/splitter/SplitterManager;", "(Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/splitter/SplitterManager;)V", "process", JsonProperty.USE_DEFAULT_NAME, "job", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/processors/ProcessorJob;", "splitByRule", JsonProperty.USE_DEFAULT_NAME, "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/processors/AtomicProcessingTask;", "atomicProcessingTask", "splitRules", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/splitter/SplitRule;", "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class SentenceSplitterProcessor extends Processor {
    private final SplitterManager splitterManager;

    @Inject
    public SentenceSplitterProcessor(SplitterManager splitterManager) {
        Intrinsics.checkNotNullParameter(splitterManager, "splitterManager");
        this.splitterManager = splitterManager;
    }

    @Override // com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.Processor
    protected void process(ProcessorJob job) {
        Intrinsics.checkNotNullParameter(job, "job");
        String simpleName = getClass().getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName, "getSimpleName(...)");
        job.withJob(simpleName, new Function1<ProcessorJob, Unit>() { // from class: com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.SentenceSplitterProcessor$process$1
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
                SplitterManager splitterManager;
                List splitByRule;
                Intrinsics.checkNotNullParameter(currentJob, "currentJob");
                List<ProcessingTask> tasks = currentJob.getTasks();
                ArrayList<ProcessingTask> arrayList = new ArrayList();
                for (Object obj : tasks) {
                    if (!((ProcessingTask) obj).getRoot().isFinished()) {
                        arrayList.add(obj);
                    }
                }
                SentenceSplitterProcessor sentenceSplitterProcessor = SentenceSplitterProcessor.this;
                for (ProcessingTask processingTask : arrayList) {
                    boolean needSentenceSplit = processingTask.getTranslationTask().getNeedSentenceSplit();
                    List<AtomicProcessingTask> leaves = processingTask.getLeaves();
                    ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(leaves, 10));
                    for (AtomicProcessingTask atomicProcessingTask : leaves) {
                        splitterManager = sentenceSplitterProcessor.splitterManager;
                        splitByRule = sentenceSplitterProcessor.splitByRule(atomicProcessingTask, splitterManager.getSplitterList(atomicProcessingTask.getSourceLanguage(), needSentenceSplit));
                        arrayList2.add(splitByRule);
                    }
                    processingTask.setLeaves(CollectionsKt.flatten(arrayList2));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<AtomicProcessingTask> splitByRule(AtomicProcessingTask atomicProcessingTask, List<? extends SplitRule> splitRules) {
        List<AtomicProcessingTask> listOf = CollectionsKt.listOf(atomicProcessingTask);
        ArrayList arrayList = new ArrayList();
        for (SplitRule splitRule : splitRules) {
            ArrayList arrayList2 = new ArrayList();
            for (AtomicProcessingTask atomicProcessingTask2 : listOf) {
                atomicProcessingTask2.setDelimiter(splitRule.getDelimiter());
                Iterator<T> it = splitRule.split(atomicProcessingTask2.getCurrentText()).iterator();
                while (it.hasNext()) {
                    arrayList2.add(atomicProcessingTask2.createChild(StringsKt.trim((CharSequence) it.next()).toString()));
                }
                if (!r3.isEmpty()) {
                    atomicProcessingTask2.setCurrentText(JsonProperty.USE_DEFAULT_NAME);
                }
            }
            listOf = arrayList2;
            arrayList = listOf;
        }
        return arrayList;
    }
}
