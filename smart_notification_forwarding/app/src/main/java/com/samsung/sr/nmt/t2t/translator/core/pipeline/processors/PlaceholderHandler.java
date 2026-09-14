package com.samsung.sr.nmt.t2t.translator.core.pipeline.processors;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.Engine;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.spec.PlaceholderSpec;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.placeholder.PlaceholderStorage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PlaceholderHandler.kt */
@Singleton
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u001b\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J \u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000b\u001a\u00020\fJ \u0010\r\u001a\u00020\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\t2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fJ\u0018\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/processors/PlaceholderHandler;", JsonProperty.USE_DEFAULT_NAME, "placeholderPreProcessor", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/processors/Processor;", "placeholderPostProcessor", "(Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/processors/Processor;Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/processors/Processor;)V", "postProcessPlaceholder", JsonProperty.USE_DEFAULT_NAME, "currentEngine", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/Engine;", "nextEngine", "job", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/processors/ProcessorJob;", "preProcessPlaceholder", "oldEngine", "setUpPlaceholderStorage", "placeholderSpec", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/spec/PlaceholderSpec;", "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class PlaceholderHandler {
    private final Processor placeholderPostProcessor;
    private final Processor placeholderPreProcessor;

    @Inject
    public PlaceholderHandler(@Named("PlaceholderPreProcessor") Processor placeholderPreProcessor, @Named("PlaceholderPostProcessor") Processor placeholderPostProcessor) {
        Intrinsics.checkNotNullParameter(placeholderPreProcessor, "placeholderPreProcessor");
        Intrinsics.checkNotNullParameter(placeholderPostProcessor, "placeholderPostProcessor");
        this.placeholderPreProcessor = placeholderPreProcessor;
        this.placeholderPostProcessor = placeholderPostProcessor;
    }

    private final void setUpPlaceholderStorage(ProcessorJob job, final PlaceholderSpec placeholderSpec) {
        String simpleName = getClass().getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName, "getSimpleName(...)");
        job.withJob(simpleName, new Function1<ProcessorJob, Unit>() { // from class: com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.PlaceholderHandler$setUpPlaceholderStorage$1
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
                for (Object obj : tasks) {
                    if (!((ProcessingTask) obj).getRoot().isFinished()) {
                        arrayList.add(obj);
                    }
                }
                PlaceholderSpec placeholderSpec2 = PlaceholderSpec.this;
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    List<AtomicProcessingTask> leaves = ((ProcessingTask) it.next()).getLeaves();
                    ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(leaves, 10));
                    Iterator<T> it2 = leaves.iterator();
                    while (it2.hasNext()) {
                        ((AtomicProcessingTask) it2.next()).setPlaceholderStorage(new PlaceholderStorage(placeholderSpec2.getPlhTok(), placeholderSpec2.getNumPlhTok()));
                        arrayList2.add(Unit.INSTANCE);
                    }
                }
            }
        });
    }

    public final void preProcessPlaceholder(Engine oldEngine, Engine currentEngine, ProcessorJob job) {
        Unit unit;
        Intrinsics.checkNotNullParameter(currentEngine, "currentEngine");
        Intrinsics.checkNotNullParameter(job, "job");
        if (oldEngine != null) {
            if (oldEngine.getPlaceholderSpec().getProcessPlh() && !Intrinsics.areEqual(oldEngine.getPlaceholderSpec(), currentEngine.getPlaceholderSpec())) {
                this.placeholderPostProcessor.run$translator_core(job);
            }
            if (!Intrinsics.areEqual(oldEngine.getPlaceholderSpec(), currentEngine.getPlaceholderSpec()) && currentEngine.getPlaceholderSpec().getProcessPlh()) {
                setUpPlaceholderStorage(job, currentEngine.getPlaceholderSpec());
                this.placeholderPreProcessor.run$translator_core(job);
            }
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null && currentEngine.getPlaceholderSpec().getProcessPlh()) {
            setUpPlaceholderStorage(job, currentEngine.getPlaceholderSpec());
            this.placeholderPreProcessor.run$translator_core(job);
        }
    }

    public final void postProcessPlaceholder(Engine currentEngine, Engine nextEngine, ProcessorJob job) {
        Intrinsics.checkNotNullParameter(currentEngine, "currentEngine");
        Intrinsics.checkNotNullParameter(job, "job");
        if (nextEngine == null) {
            if (currentEngine.getPlaceholderSpec().getProcessPlh()) {
                this.placeholderPostProcessor.run$translator_core(job);
            }
            Unit unit = Unit.INSTANCE;
        }
    }
}
