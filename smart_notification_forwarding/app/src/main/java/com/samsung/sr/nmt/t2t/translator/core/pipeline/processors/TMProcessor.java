package com.samsung.sr.nmt.t2t.translator.core.pipeline.processors;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.LanguageDirectionManager;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.translationmemory.CustomTranslationMemory;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.translationmemory.TranslationMemory;
import com.samsung.sr.nmt.t2t.translator.core.utils.LanguageDirection;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TMProcessor.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/processors/TMProcessor;", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/processors/Processor;", "translationMemory", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/translationmemory/TranslationMemory;", "customTranslationMemory", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/translationmemory/CustomTranslationMemory;", "languageDirectionManager", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/LanguageDirectionManager;", "(Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/translationmemory/TranslationMemory;Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/translationmemory/CustomTranslationMemory;Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/LanguageDirectionManager;)V", "process", JsonProperty.USE_DEFAULT_NAME, "job", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/processors/ProcessorJob;", "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class TMProcessor extends Processor {
    private final CustomTranslationMemory customTranslationMemory;
    private final LanguageDirectionManager languageDirectionManager;
    private final TranslationMemory translationMemory;

    @Inject
    public TMProcessor(TranslationMemory translationMemory, CustomTranslationMemory customTranslationMemory, LanguageDirectionManager languageDirectionManager) {
        Intrinsics.checkNotNullParameter(translationMemory, "translationMemory");
        Intrinsics.checkNotNullParameter(customTranslationMemory, "customTranslationMemory");
        Intrinsics.checkNotNullParameter(languageDirectionManager, "languageDirectionManager");
        this.translationMemory = translationMemory;
        this.customTranslationMemory = customTranslationMemory;
        this.languageDirectionManager = languageDirectionManager;
    }

    @Override // com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.Processor
    protected void process(final ProcessorJob job) {
        Intrinsics.checkNotNullParameter(job, "job");
        String simpleName = getClass().getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName, "getSimpleName(...)");
        job.withJob(simpleName, new Function1<ProcessorJob, Unit>() { // from class: com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.TMProcessor$process$1
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
            public final void invoke2(ProcessorJob currentJob) {
                LanguageDirectionManager languageDirectionManager;
                CustomTranslationMemory customTranslationMemory;
                TranslationMemory translationMemory;
                TranslationMemory translationMemory2;
                CustomTranslationMemory customTranslationMemory2;
                CustomTranslationMemory customTranslationMemory3;
                TranslationMemory translationMemory3;
                Intrinsics.checkNotNullParameter(currentJob, "currentJob");
                String packageName = ((ProcessingTask) CollectionsKt.first((List) ProcessorJob.this.getTasks())).getTranslationTask().getPackageName();
                languageDirectionManager = this.languageDirectionManager;
                List<LanguageDirection> translationPath$default = LanguageDirectionManager.getTranslationPath$default(languageDirectionManager, currentJob.getLanguageDirection(), false, 2, null);
                TMProcessor tMProcessor = this;
                for (LanguageDirection languageDirection : translationPath$default) {
                    translationMemory2 = tMProcessor.translationMemory;
                    if (!translationMemory2.isLoaded(languageDirection)) {
                        translationMemory3 = tMProcessor.translationMemory;
                        translationMemory3.loadMemory(languageDirection);
                    }
                    customTranslationMemory2 = tMProcessor.customTranslationMemory;
                    if (!customTranslationMemory2.isLoaded(packageName, languageDirection)) {
                        customTranslationMemory3 = tMProcessor.customTranslationMemory;
                        customTranslationMemory3.loadMemory(packageName, languageDirection);
                    }
                }
                List<ProcessingTask> tasks = currentJob.getTasks();
                TMProcessor tMProcessor2 = this;
                ProcessorJob processorJob = ProcessorJob.this;
                for (ProcessingTask processingTask : tasks) {
                    boolean formality = processingTask.getTranslationTask().getFormality();
                    for (AtomicProcessingTask atomicProcessingTask : processingTask.getLeaves()) {
                        customTranslationMemory = tMProcessor2.customTranslationMemory;
                        String memory = customTranslationMemory.getMemory(packageName, processorJob.getLanguageDirection(), atomicProcessingTask.getCurrentText());
                        if (memory == null) {
                            translationMemory = tMProcessor2.translationMemory;
                            String memory2 = translationMemory.getMemory(formality, processorJob.getLanguageDirection(), atomicProcessingTask.getCurrentText());
                            if (memory2 != null) {
                                atomicProcessingTask.setCurrentText(memory2);
                                atomicProcessingTask.setFinished(true);
                            }
                        } else {
                            atomicProcessingTask.setCurrentText(memory);
                            atomicProcessingTask.setFinished(true);
                        }
                    }
                }
            }
        });
    }
}
