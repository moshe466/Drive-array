package com.samsung.sr.nmt.t2t.translator.core.pipeline.processors;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.emergency.EmergencyHandler;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.Engine;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.EngineProvider;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.EngineTranslationResult;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.replacepair.ReplacePairManager;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.translationmemory.TranslationMemory;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* compiled from: TranslationProcessor.kt */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0000\u0018\u0000 !2\u00020\u0001:\u0001!BA\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\u0016\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\u0010\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0013\u001a\u00020\u0012H\u0014J&\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u00162\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u0015H\u0002J\f\u0010\u001e\u001a\u00020\u001f*\u00020\u001fH\u0002J\f\u0010 \u001a\u00020\u001f*\u00020\u001fH\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/processors/TranslationProcessor;", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/processors/Processor;", "engineProvider", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/EngineProvider;", "translationMemory", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/translationmemory/TranslationMemory;", "batchSize", JsonProperty.USE_DEFAULT_NAME, "replacePairManager", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/replacepair/ReplacePairManager;", "placeholderHandler", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/processors/PlaceholderHandler;", "emergencyHandler", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/emergency/EmergencyHandler;", "normalizeProcessor", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/processors/NormalizeProcessor;", "(Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/EngineProvider;Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/translationmemory/TranslationMemory;ILcom/samsung/sr/nmt/t2t/translator/core/pipeline/replacepair/ReplacePairManager;Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/processors/PlaceholderHandler;Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/emergency/EmergencyHandler;Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/processors/NormalizeProcessor;)V", "filterText", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/processors/ProcessorJob;", "job", "getLoadedEngines", JsonProperty.USE_DEFAULT_NAME, "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/Engine;", "keepPivotResult", JsonProperty.USE_DEFAULT_NAME, "process", "translateAndUpdate", "engine", "formalitySettings", JsonProperty.USE_DEFAULT_NAME, "filterHTMLUnities", JsonProperty.USE_DEFAULT_NAME, "filterUnicode", "Companion", "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class TranslationProcessor extends Processor {
    private static final String FILTER = "TranslationProcessor FILTER";
    private static final String MODEL_LOAD = "TranslationProcessor MODEL_LOAD";
    private static final String TRANSLATION = "TranslationProcessor TRANSLATION";
    private final int batchSize;
    private final EmergencyHandler emergencyHandler;
    private final EngineProvider engineProvider;
    private final NormalizeProcessor normalizeProcessor;
    private final PlaceholderHandler placeholderHandler;
    private final ReplacePairManager replacePairManager;
    private final TranslationMemory translationMemory;
    private static final Regex nonUnicodePlane0FilterRegex = new Regex("[^\u0000-\uffff]");

    @Inject
    public TranslationProcessor(EngineProvider engineProvider, TranslationMemory translationMemory, @Named("tokenBatchSize") int i, ReplacePairManager replacePairManager, PlaceholderHandler placeholderHandler, EmergencyHandler emergencyHandler, NormalizeProcessor normalizeProcessor) {
        Intrinsics.checkNotNullParameter(engineProvider, "engineProvider");
        Intrinsics.checkNotNullParameter(translationMemory, "translationMemory");
        Intrinsics.checkNotNullParameter(replacePairManager, "replacePairManager");
        Intrinsics.checkNotNullParameter(placeholderHandler, "placeholderHandler");
        Intrinsics.checkNotNullParameter(emergencyHandler, "emergencyHandler");
        Intrinsics.checkNotNullParameter(normalizeProcessor, "normalizeProcessor");
        this.engineProvider = engineProvider;
        this.translationMemory = translationMemory;
        this.batchSize = i;
        this.replacePairManager = replacePairManager;
        this.placeholderHandler = placeholderHandler;
        this.emergencyHandler = emergencyHandler;
        this.normalizeProcessor = normalizeProcessor;
    }

    @Override // com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.Processor
    protected void process(ProcessorJob job) {
        Intrinsics.checkNotNullParameter(job, "job");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (ProcessingTask processingTask : job.getTasks()) {
            boolean formality = processingTask.getTranslationTask().getFormality();
            Iterator<T> it = processingTask.getLeaves().iterator();
            while (it.hasNext()) {
                arrayList.add(((AtomicProcessingTask) it.next()).getCurrentText());
                arrayList2.add(Boolean.valueOf(formality));
            }
        }
        List<Engine> loadedEngines = getLoadedEngines(job);
        int i = 0;
        int i2 = 0;
        for (Object obj : loadedEngines) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            Engine engine = (Engine) obj;
            this.placeholderHandler.preProcessPlaceholder((Engine) CollectionsKt.getOrNull(loadedEngines, i2 - 1), engine, job);
            this.normalizeProcessor.processWithDir(job, engine.getLanguageDirection());
            translateAndUpdate(filterText(job), engine, arrayList2);
            this.placeholderHandler.postProcessPlaceholder(engine, (Engine) CollectionsKt.getOrNull(loadedEngines, i3), job);
            if (loadedEngines.size() > 1 && i2 == 0) {
                keepPivotResult(job);
            }
            i2 = i3;
        }
        if (loadedEngines.size() > 1) {
            List<ProcessingTask> tasks = job.getTasks();
            ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(tasks, 10));
            Iterator<T> it2 = tasks.iterator();
            while (it2.hasNext()) {
                arrayList3.add(((ProcessingTask) it2.next()).getLeaves());
            }
            List flatten = CollectionsKt.flatten(arrayList3);
            for (Object obj2 : arrayList) {
                int i4 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                String str = (String) obj2;
                if (!((AtomicProcessingTask) flatten.get(i)).isFinished()) {
                    this.translationMemory.addMemory(arrayList2.get(i).booleanValue(), job.getLanguageDirection(), str, ((AtomicProcessingTask) flatten.get(i)).getCurrentText());
                }
                i = i4;
            }
        }
    }

    private final void translateAndUpdate(final ProcessorJob job, final Engine engine, final List<Boolean> formalitySettings) {
        job.withJob(TRANSLATION, new Function1<ProcessorJob, Unit>() { // from class: com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.TranslationProcessor$translateAndUpdate$1
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
                ReplacePairManager replacePairManager;
                int i;
                TranslationMemory translationMemory;
                EmergencyHandler emergencyHandler;
                ReplacePairManager replacePairManager2;
                Intrinsics.checkNotNullParameter(currentJob, "currentJob");
                List<ProcessingTask> tasks = currentJob.getTasks();
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(tasks, 10));
                Iterator<T> it = tasks.iterator();
                while (it.hasNext()) {
                    arrayList.add(((ProcessingTask) it.next()).getLeaves());
                }
                List flatten = CollectionsKt.flatten(arrayList);
                ArrayList arrayList2 = new ArrayList();
                ArrayList arrayList3 = new ArrayList();
                ArrayList arrayList4 = new ArrayList();
                List<Boolean> list = formalitySettings;
                int i2 = 0;
                for (Object obj : flatten) {
                    int i3 = i2 + 1;
                    if (i2 < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    AtomicProcessingTask atomicProcessingTask = (AtomicProcessingTask) obj;
                    if (!atomicProcessingTask.isFinished()) {
                        arrayList2.add(atomicProcessingTask.getCurrentText());
                        arrayList3.add(list.get(i2));
                        arrayList4.add(Integer.valueOf(i2));
                    }
                    i2 = i3;
                }
                replacePairManager = TranslationProcessor.this.replacePairManager;
                replacePairManager.load(((ProcessingTask) CollectionsKt.first((List) job.getTasks())).getTranslationTask().getPackageName(), engine.getLanguageDirection());
                if (!arrayList2.isEmpty()) {
                    Engine engine2 = engine;
                    List<ProcessingTask> tasks2 = job.getTasks();
                    ArrayList arrayList5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(tasks2, 10));
                    Iterator<T> it2 = tasks2.iterator();
                    while (it2.hasNext()) {
                        arrayList5.add(((ProcessingTask) it2.next()).getTranslationTask().getId());
                    }
                    List<String> list2 = CollectionsKt.toList(CollectionsKt.toHashSet(arrayList5));
                    boolean verbose = currentJob.getVerbose();
                    i = TranslationProcessor.this.batchSize;
                    List<EngineTranslationResult> translate = engine2.translate(arrayList2, arrayList3, list2, verbose, i);
                    List<EngineTranslationResult> list3 = translate;
                    TranslationProcessor translationProcessor = TranslationProcessor.this;
                    ProcessorJob processorJob = job;
                    Engine engine3 = engine;
                    ArrayList arrayList6 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list3, 10));
                    int i4 = 0;
                    for (Object obj2 : list3) {
                        int i5 = i4 + 1;
                        if (i4 < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        replacePairManager2 = translationProcessor.replacePairManager;
                        arrayList6.add(replacePairManager2.replace(((ProcessingTask) CollectionsKt.first((List) processorJob.getTasks())).getTranslationTask().getPackageName(), engine3.getLanguageDirection(), (String) arrayList2.get(i4), ((EngineTranslationResult) obj2).getText()));
                        i4 = i5;
                    }
                    ArrayList arrayList7 = arrayList6;
                    TranslationProcessor translationProcessor2 = TranslationProcessor.this;
                    Engine engine4 = engine;
                    ProcessorJob processorJob2 = job;
                    ArrayList arrayList8 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList7, 10));
                    int i6 = 0;
                    for (Object obj3 : arrayList7) {
                        int i7 = i6 + 1;
                        if (i6 < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        emergencyHandler = translationProcessor2.emergencyHandler;
                        arrayList8.add(emergencyHandler.processEmergency(engine4.getLanguageDirection(), (String) arrayList2.get(i6), (String) obj3, processorJob2.getMode()));
                        i6 = i7;
                        translationProcessor2 = translationProcessor2;
                    }
                    ArrayList arrayList9 = arrayList8;
                    int size = arrayList9.size();
                    for (int i8 = 0; i8 < size; i8++) {
                        if (((CharSequence) arrayList9.get(i8)).length() > 0) {
                            translationMemory = TranslationProcessor.this.translationMemory;
                            translationMemory.addMemory(((Boolean) arrayList3.get(i8)).booleanValue(), engine.getLanguageDirection(), (String) arrayList2.get(i8), (String) arrayList9.get(i8));
                        }
                        ((AtomicProcessingTask) flatten.get(((Number) arrayList4.get(i8)).intValue())).setCurrentText((String) arrayList9.get(i8));
                        ((AtomicProcessingTask) flatten.get(((Number) arrayList4.get(i8)).intValue())).setFinished(translate.get(i8).getRejected());
                    }
                }
            }
        });
    }

    private final List<Engine> getLoadedEngines(final ProcessorJob job) {
        return (List) job.withJob(MODEL_LOAD, new Function1<ProcessorJob, List<? extends Engine>>() { // from class: com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.TranslationProcessor$getLoadedEngines$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final List<Engine> invoke(ProcessorJob it) {
                EngineProvider engineProvider;
                Intrinsics.checkNotNullParameter(it, "it");
                engineProvider = TranslationProcessor.this.engineProvider;
                return engineProvider.getLoadedEngines(it.getLanguageDirection().getSrcLang(), it.getLanguageDirection().getTgtLang(), ((ProcessingTask) CollectionsKt.first((List) job.getTasks())).getTranslationTask().getForcePivot());
            }
        });
    }

    private final ProcessorJob filterText(ProcessorJob job) {
        return (ProcessorJob) job.withJob(FILTER, new Function1<ProcessorJob, ProcessorJob>() { // from class: com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.TranslationProcessor$filterText$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final ProcessorJob invoke(ProcessorJob it) {
                String filterUnicode;
                String filterHTMLUnities;
                Intrinsics.checkNotNullParameter(it, "it");
                List<ProcessingTask> tasks = it.getTasks();
                TranslationProcessor translationProcessor = TranslationProcessor.this;
                Iterator<T> it2 = tasks.iterator();
                while (it2.hasNext()) {
                    for (AtomicProcessingTask atomicProcessingTask : ((ProcessingTask) it2.next()).getLeaves()) {
                        if (!atomicProcessingTask.isFinished()) {
                            filterUnicode = translationProcessor.filterUnicode(atomicProcessingTask.getCurrentText());
                            filterHTMLUnities = translationProcessor.filterHTMLUnities(filterUnicode);
                            atomicProcessingTask.setCurrentText(filterHTMLUnities);
                        }
                    }
                }
                return it;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String filterUnicode(String str) {
        return nonUnicodePlane0FilterRegex.replace(str, JsonProperty.USE_DEFAULT_NAME);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String filterHTMLUnities(String str) {
        return StringsKt.replace$default(StringsKt.replace$default(str, "&nbsp;", " ", false, 4, (Object) null), "&ZeroWidthSpace;", JsonProperty.USE_DEFAULT_NAME, false, 4, (Object) null);
    }

    private final void keepPivotResult(ProcessorJob job) {
        Iterator<T> it = job.getTasks().iterator();
        while (it.hasNext()) {
            List<AtomicProcessingTask> leaves = ((ProcessingTask) it.next()).getLeaves();
            ArrayList<AtomicProcessingTask> arrayList = new ArrayList();
            for (Object obj : leaves) {
                if (!((AtomicProcessingTask) obj).isFinished()) {
                    arrayList.add(obj);
                }
            }
            for (AtomicProcessingTask atomicProcessingTask : arrayList) {
                atomicProcessingTask.setPivotResult(atomicProcessingTask.getCurrentText());
            }
        }
    }
}
