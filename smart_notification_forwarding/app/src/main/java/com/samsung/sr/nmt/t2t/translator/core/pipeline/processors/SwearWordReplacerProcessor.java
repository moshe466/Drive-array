package com.samsung.sr.nmt.t2t.translator.core.pipeline.processors;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.LanguageDirectionManager;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.swearword.SwearWordReplacer;
import com.samsung.sr.nmt.t2t.translator.core.utils.LanguageDirection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SwearWordReplacerProcessor.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/processors/SwearWordReplacerProcessor;", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/processors/Processor;", "swearWordReplacer", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/swearword/SwearWordReplacer;", "languageDirectionManager", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/LanguageDirectionManager;", "(Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/swearword/SwearWordReplacer;Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/LanguageDirectionManager;)V", "process", JsonProperty.USE_DEFAULT_NAME, "job", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/processors/ProcessorJob;", "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class SwearWordReplacerProcessor extends Processor {
    private final LanguageDirectionManager languageDirectionManager;
    private final SwearWordReplacer swearWordReplacer;

    @Inject
    public SwearWordReplacerProcessor(SwearWordReplacer swearWordReplacer, LanguageDirectionManager languageDirectionManager) {
        Intrinsics.checkNotNullParameter(swearWordReplacer, "swearWordReplacer");
        Intrinsics.checkNotNullParameter(languageDirectionManager, "languageDirectionManager");
        this.swearWordReplacer = swearWordReplacer;
        this.languageDirectionManager = languageDirectionManager;
    }

    @Override // com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.Processor
    protected void process(ProcessorJob job) {
        Intrinsics.checkNotNullParameter(job, "job");
        String simpleName = getClass().getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName, "getSimpleName(...)");
        job.withJob(simpleName, new Function1<ProcessorJob, Unit>() { // from class: com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.SwearWordReplacerProcessor$process$1
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
                LanguageDirectionManager languageDirectionManager;
                SwearWordReplacer swearWordReplacer;
                SwearWordReplacer swearWordReplacer2;
                SwearWordReplacer swearWordReplacer3;
                Intrinsics.checkNotNullParameter(currentJob, "currentJob");
                languageDirectionManager = SwearWordReplacerProcessor.this.languageDirectionManager;
                List<LanguageDirection> translationPath$default = LanguageDirectionManager.getTranslationPath$default(languageDirectionManager, currentJob.getLanguageDirection(), false, 2, null);
                SwearWordReplacerProcessor swearWordReplacerProcessor = SwearWordReplacerProcessor.this;
                for (LanguageDirection languageDirection : translationPath$default) {
                    swearWordReplacer2 = swearWordReplacerProcessor.swearWordReplacer;
                    if (!swearWordReplacer2.isLoaded(languageDirection)) {
                        swearWordReplacer3 = swearWordReplacerProcessor.swearWordReplacer;
                        swearWordReplacer3.load(languageDirection);
                    }
                }
                List<ProcessingTask> tasks = currentJob.getTasks();
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(tasks, 10));
                Iterator<T> it = tasks.iterator();
                while (it.hasNext()) {
                    arrayList.add(((ProcessingTask) it.next()).getLeaves());
                }
                List<AtomicProcessingTask> flatten = CollectionsKt.flatten(arrayList);
                SwearWordReplacerProcessor swearWordReplacerProcessor2 = SwearWordReplacerProcessor.this;
                for (AtomicProcessingTask atomicProcessingTask : flatten) {
                    swearWordReplacer = swearWordReplacerProcessor2.swearWordReplacer;
                    atomicProcessingTask.setCurrentText(swearWordReplacer.replace(currentJob.getLanguageDirection().getTgtLang(), atomicProcessingTask.getCurrentText()));
                }
            }
        });
    }
}
