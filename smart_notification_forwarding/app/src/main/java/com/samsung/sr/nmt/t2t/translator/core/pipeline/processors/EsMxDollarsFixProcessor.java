package com.samsung.sr.nmt.t2t.translator.core.pipeline.processors;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Iterator;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

/* compiled from: EsMxDollarsFixProcessor.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0007\b\u0007¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u0004H\u0014¨\u0006\t"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/processors/EsMxDollarsFixProcessor;", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/processors/Processor;", "()V", "fixDollars", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/processors/ProcessorJob;", "job", "process", JsonProperty.USE_DEFAULT_NAME, "Companion", "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class EsMxDollarsFixProcessor extends Processor {
    private static final Regex ONE_DOLLAR_RULE = new Regex("((?<=^|\\s)\\$1\\b)|(\\b1\\$(?!\\w))");
    private static final Regex DOLLAR_BEFORE_RULE = new Regex("(?<=^|\\s)\\$(?<count>\\d+)\\b");
    private static final Regex DOLLAR_AFTER_RULE = new Regex("\\b(?<count>\\d+)\\$(?!\\w)");

    @Inject
    public EsMxDollarsFixProcessor() {
    }

    @Override // com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.Processor
    protected void process(ProcessorJob job) {
        Intrinsics.checkNotNullParameter(job, "job");
        if (Intrinsics.areEqual(job.getLanguageDirection().getTgtLang(), "esmx")) {
            fixDollars(job);
        }
    }

    private final ProcessorJob fixDollars(ProcessorJob job) {
        String simpleName = getClass().getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName, "getSimpleName(...)");
        return (ProcessorJob) job.withJob(simpleName, new Function1<ProcessorJob, ProcessorJob>() { // from class: com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.EsMxDollarsFixProcessor$fixDollars$1
            @Override // kotlin.jvm.functions.Function1
            public final ProcessorJob invoke(ProcessorJob currentJob) {
                Regex regex;
                Regex regex2;
                Regex regex3;
                Intrinsics.checkNotNullParameter(currentJob, "currentJob");
                Iterator<T> it = currentJob.getTasks().iterator();
                while (it.hasNext()) {
                    for (AtomicProcessingTask atomicProcessingTask : ((ProcessingTask) it.next()).getLeaves()) {
                        if (!atomicProcessingTask.isFinished() && Intrinsics.areEqual(atomicProcessingTask.getTargetLanguage(), "esmx")) {
                            regex = EsMxDollarsFixProcessor.ONE_DOLLAR_RULE;
                            atomicProcessingTask.setCurrentText(regex.replace(atomicProcessingTask.getCurrentText(), "1 dólar"));
                            regex2 = EsMxDollarsFixProcessor.DOLLAR_BEFORE_RULE;
                            atomicProcessingTask.setCurrentText(regex2.replace(atomicProcessingTask.getCurrentText(), "$1 dólares"));
                            regex3 = EsMxDollarsFixProcessor.DOLLAR_AFTER_RULE;
                            atomicProcessingTask.setCurrentText(regex3.replace(atomicProcessingTask.getCurrentText(), "$1 dólares"));
                        }
                    }
                }
                return currentJob;
            }
        });
    }
}
