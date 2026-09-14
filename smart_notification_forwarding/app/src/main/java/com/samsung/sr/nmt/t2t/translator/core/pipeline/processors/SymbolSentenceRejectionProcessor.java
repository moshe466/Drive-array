package com.samsung.sr.nmt.t2t.translator.core.pipeline.processors;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.symbols.SymbolRegex;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchResult;
import kotlin.text.Regex;

/* compiled from: SymbolSentenceRejectionProcessor.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/processors/SymbolSentenceRejectionProcessor;", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/processors/Processor;", "rejectionSymbolRegex", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/symbols/SymbolRegex;", "(Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/symbols/SymbolRegex;)V", "process", JsonProperty.USE_DEFAULT_NAME, "job", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/processors/ProcessorJob;", "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class SymbolSentenceRejectionProcessor extends Processor {
    private final SymbolRegex rejectionSymbolRegex;

    @Inject
    public SymbolSentenceRejectionProcessor(@Named("RejectionSymbolRegex") SymbolRegex rejectionSymbolRegex) {
        Intrinsics.checkNotNullParameter(rejectionSymbolRegex, "rejectionSymbolRegex");
        this.rejectionSymbolRegex = rejectionSymbolRegex;
    }

    @Override // com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.Processor
    protected void process(final ProcessorJob job) {
        Intrinsics.checkNotNullParameter(job, "job");
        String simpleName = getClass().getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName, "getSimpleName(...)");
        job.withJob(simpleName, new Function1<ProcessorJob, Unit>() { // from class: com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.SymbolSentenceRejectionProcessor$process$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ProcessorJob processorJob) {
                invoke2(processorJob);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ProcessorJob it) {
                SymbolRegex symbolRegex;
                Intrinsics.checkNotNullParameter(it, "it");
                List<ProcessingTask> tasks = ProcessorJob.this.getTasks();
                SymbolSentenceRejectionProcessor symbolSentenceRejectionProcessor = this;
                Iterator<T> it2 = tasks.iterator();
                while (it2.hasNext()) {
                    for (AtomicProcessingTask atomicProcessingTask : ((ProcessingTask) it2.next()).getLeaves()) {
                        boolean z = false;
                        if (!(atomicProcessingTask.getCurrentText().length() == 0)) {
                            symbolRegex = symbolSentenceRejectionProcessor.rejectionSymbolRegex;
                            Iterator it3 = Regex.findAll$default(symbolRegex.getRegexCompiled(), atomicProcessingTask.getCurrentText(), 0, 2, null).iterator();
                            while (true) {
                                if (it3.hasNext()) {
                                    if (Intrinsics.areEqual(((MatchResult) it3.next()).getValue(), atomicProcessingTask.getCurrentText())) {
                                        z = true;
                                        break;
                                    }
                                } else {
                                    break;
                                }
                            }
                            if (z) {
                            }
                        }
                        atomicProcessingTask.setFinished(true);
                    }
                }
            }
        });
    }
}
