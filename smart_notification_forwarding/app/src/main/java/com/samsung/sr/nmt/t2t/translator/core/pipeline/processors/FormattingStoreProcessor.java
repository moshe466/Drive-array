package com.samsung.sr.nmt.t2t.translator.core.pipeline.processors;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.formatting.EnPlFormattingRules;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.formatting.FormattingRules;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.formatting.NoopFormattingRules;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.formatting.PlEnFormattingRules;
import com.samsung.sr.nmt.t2t.translator.core.utils.LanguageDirection;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FormattingStoreProcessor.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0014J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0002¨\u0006\n"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/processors/FormattingStoreProcessor;", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/processors/Processor;", "()V", "getFormattingRules", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/processors/formatting/FormattingRules;", "job", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/processors/ProcessorJob;", "process", JsonProperty.USE_DEFAULT_NAME, "storeFormattingRules", "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class FormattingStoreProcessor extends Processor {
    @Inject
    public FormattingStoreProcessor() {
    }

    @Override // com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.Processor
    protected void process(ProcessorJob job) {
        Intrinsics.checkNotNullParameter(job, "job");
        storeFormattingRules(job);
    }

    private final void storeFormattingRules(ProcessorJob job) {
        String simpleName = getClass().getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName, "getSimpleName(...)");
        job.withJob(simpleName, new Function1<ProcessorJob, Unit>() { // from class: com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.FormattingStoreProcessor$storeFormattingRules$1
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
                FormattingRules formattingRules;
                Intrinsics.checkNotNullParameter(currentJob, "currentJob");
                List<ProcessingTask> tasks = currentJob.getTasks();
                FormattingStoreProcessor formattingStoreProcessor = FormattingStoreProcessor.this;
                Iterator<T> it = tasks.iterator();
                while (it.hasNext()) {
                    for (AtomicProcessingTask atomicProcessingTask : ((ProcessingTask) it.next()).getLeaves()) {
                        if (!atomicProcessingTask.isFinished()) {
                            formattingRules = formattingStoreProcessor.getFormattingRules(currentJob);
                            atomicProcessingTask.setCurrentText(formattingRules.apply(atomicProcessingTask.getCurrentText()));
                            atomicProcessingTask.getFormattingRules().add(formattingRules);
                        } else {
                            atomicProcessingTask.getFormattingRules().add(new NoopFormattingRules());
                        }
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FormattingRules getFormattingRules(ProcessorJob job) {
        LanguageDirection languageDirection = job.getLanguageDirection();
        return Intrinsics.areEqual(languageDirection, new LanguageDirection("en", "pl")) ? new EnPlFormattingRules() : Intrinsics.areEqual(languageDirection, new LanguageDirection("pl", "en")) ? new PlEnFormattingRules() : new NoopFormattingRules();
    }
}
