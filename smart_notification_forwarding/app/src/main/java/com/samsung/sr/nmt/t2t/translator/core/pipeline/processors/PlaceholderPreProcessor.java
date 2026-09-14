package com.samsung.sr.nmt.t2t.translator.core.pipeline.processors;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.placeholder.PlaceholderStorage;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.symbols.SymbolRegex;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* compiled from: PlaceholderPreProcessor.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/processors/PlaceholderPreProcessor;", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/processors/Processor;", "placeholderSymbolRegex", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/symbols/SymbolRegex;", "(Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/symbols/SymbolRegex;)V", "process", JsonProperty.USE_DEFAULT_NAME, "job", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/processors/ProcessorJob;", "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class PlaceholderPreProcessor extends Processor {
    private final SymbolRegex placeholderSymbolRegex;

    public PlaceholderPreProcessor(SymbolRegex placeholderSymbolRegex) {
        Intrinsics.checkNotNullParameter(placeholderSymbolRegex, "placeholderSymbolRegex");
        this.placeholderSymbolRegex = placeholderSymbolRegex;
    }

    @Override // com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.Processor
    protected void process(ProcessorJob job) {
        Intrinsics.checkNotNullParameter(job, "job");
        String simpleName = getClass().getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName, "getSimpleName(...)");
        job.withJob(simpleName, new Function1<ProcessorJob, Unit>() { // from class: com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.PlaceholderPreProcessor$process$1
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
                SymbolRegex symbolRegex;
                Intrinsics.checkNotNullParameter(currentJob, "currentJob");
                List<ProcessingTask> tasks = currentJob.getTasks();
                ArrayList arrayList = new ArrayList();
                for (Object obj : tasks) {
                    if (!((ProcessingTask) obj).getRoot().isFinished()) {
                        arrayList.add(obj);
                    }
                }
                PlaceholderPreProcessor placeholderPreProcessor = PlaceholderPreProcessor.this;
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    List<AtomicProcessingTask> leaves = ((ProcessingTask) it.next()).getLeaves();
                    ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(leaves, 10));
                    for (AtomicProcessingTask atomicProcessingTask : leaves) {
                        symbolRegex = placeholderPreProcessor.placeholderSymbolRegex;
                        for (MatchResult matchResult : Regex.findAll$default(symbolRegex.getRegexCompiled(), atomicProcessingTask.getCurrentText(), 0, 2, null)) {
                            PlaceholderStorage placeholderStorage = atomicProcessingTask.getPlaceholderStorage();
                            if (placeholderStorage != null) {
                                atomicProcessingTask.setCurrentText(StringsKt.replaceFirst$default(atomicProcessingTask.getCurrentText(), matchResult.getGroupValues().get(0), placeholderStorage.keep(matchResult.getGroupValues().get(0)), false, 4, (Object) null));
                            }
                        }
                        arrayList2.add(Unit.INSTANCE);
                    }
                }
            }
        });
    }
}
