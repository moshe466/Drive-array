package com.samsung.sr.nmt.t2t.translator.core.pipeline.processors;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.LanguageDirectionManager;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.normalizer.SymbolNormalizer;
import com.samsung.sr.nmt.t2t.translator.core.utils.LanguageDirection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NormalizeProcessor.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0007H\u0002J\u0010\u0010\r\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0007H\u0002J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u0007H\u0002J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0010\u001a\u00020\u000fH\u0014J\u0016\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/processors/NormalizeProcessor;", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/processors/Processor;", "languageDirectionManager", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/LanguageDirectionManager;", "(Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/LanguageDirectionManager;)V", "normalizeTargets", JsonProperty.USE_DEFAULT_NAME, "Lcom/samsung/sr/nmt/t2t/translator/core/utils/LanguageDirection;", "normalizer", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/normalizer/SymbolNormalizer;", "canNormalize", JsonProperty.USE_DEFAULT_NAME, "dir", "getFirstTarget", "normalize", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/processors/ProcessorJob;", "job", "process", JsonProperty.USE_DEFAULT_NAME, "processWithDir", "languageDirection", "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class NormalizeProcessor extends Processor {
    private final LanguageDirectionManager languageDirectionManager;
    private final Set<LanguageDirection> normalizeTargets;
    private final SymbolNormalizer normalizer;

    @Inject
    public NormalizeProcessor(LanguageDirectionManager languageDirectionManager) {
        Intrinsics.checkNotNullParameter(languageDirectionManager, "languageDirectionManager");
        this.languageDirectionManager = languageDirectionManager;
        this.normalizer = new SymbolNormalizer();
        this.normalizeTargets = SetsKt.setOf((Object[]) new LanguageDirection[]{new LanguageDirection("en", "ja"), new LanguageDirection("ja", "en"), new LanguageDirection("en", "ar"), new LanguageDirection("ar", "en"), new LanguageDirection("en", "de"), new LanguageDirection("de", "en"), new LanguageDirection("en", "es"), new LanguageDirection("es", "en"), new LanguageDirection("en", "esmx"), new LanguageDirection("esmx", "en"), new LanguageDirection("en", "esus"), new LanguageDirection("esus", "en"), new LanguageDirection("en", "fr"), new LanguageDirection("fr", "en"), new LanguageDirection("en", "frca"), new LanguageDirection("frca", "en"), new LanguageDirection("en", "hi"), new LanguageDirection("hi", "en"), new LanguageDirection("en", "it"), new LanguageDirection("it", "en"), new LanguageDirection("en", "pl"), new LanguageDirection("pl", "en"), new LanguageDirection("en", "ptbr"), new LanguageDirection("ptbr", "en")});
    }

    public final void processWithDir(ProcessorJob job, LanguageDirection languageDirection) {
        Intrinsics.checkNotNullParameter(job, "job");
        Intrinsics.checkNotNullParameter(languageDirection, "languageDirection");
        if (canNormalize(languageDirection)) {
            normalize(job, languageDirection);
        }
    }

    @Override // com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.Processor
    protected void process(ProcessorJob job) {
        Intrinsics.checkNotNullParameter(job, "job");
        processWithDir(job, getFirstTarget(job.getLanguageDirection()));
    }

    private final LanguageDirection getFirstTarget(LanguageDirection dir) {
        return (LanguageDirection) CollectionsKt.first(LanguageDirectionManager.getTranslationPath$default(this.languageDirectionManager, dir, false, 2, null));
    }

    private final boolean canNormalize(LanguageDirection dir) {
        return this.normalizeTargets.contains(dir);
    }

    private final ProcessorJob normalize(ProcessorJob job, final LanguageDirection dir) {
        String simpleName = getClass().getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName, "getSimpleName(...)");
        return (ProcessorJob) job.withJob(simpleName, new Function1<ProcessorJob, ProcessorJob>() { // from class: com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.NormalizeProcessor$normalize$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final ProcessorJob invoke(ProcessorJob currentJob) {
                SymbolNormalizer symbolNormalizer;
                Intrinsics.checkNotNullParameter(currentJob, "currentJob");
                List<ProcessingTask> tasks = currentJob.getTasks();
                LanguageDirection languageDirection = LanguageDirection.this;
                NormalizeProcessor normalizeProcessor = this;
                Iterator<T> it = tasks.iterator();
                while (it.hasNext()) {
                    for (AtomicProcessingTask atomicProcessingTask : ((ProcessingTask) it.next()).getLeaves()) {
                        if (!atomicProcessingTask.isFinished()) {
                            String srcLang = languageDirection.getSrcLang();
                            String tgtLang = languageDirection.getTgtLang();
                            symbolNormalizer = normalizeProcessor.normalizer;
                            atomicProcessingTask.setCurrentText(symbolNormalizer.normalize(srcLang, atomicProcessingTask.getCurrentText(), tgtLang));
                        }
                    }
                }
                return currentJob;
            }
        });
    }
}
