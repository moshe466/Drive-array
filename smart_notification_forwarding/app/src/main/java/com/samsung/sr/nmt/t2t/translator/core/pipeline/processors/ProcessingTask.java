package com.samsung.sr.nmt.t2t.translator.core.pipeline.processors;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ProcessingTask.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0002\u0010\fJ$\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u000b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00072\u0006\u0010\u001d\u001a\u00020\u001eJ\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000f\u0010!\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J\u000f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u000b0\nHÆ\u0003J?\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nHÆ\u0001J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010'\u001a\u00020(HÖ\u0001J\t\u0010)\u001a\u00020\u000bHÖ\u0001R \u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006*"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/processors/ProcessingTask;", JsonProperty.USE_DEFAULT_NAME, "translationTask", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/processors/TranslationTask;", "resultHandler", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/processors/TaskResultHandler;", "leaves", JsonProperty.USE_DEFAULT_NAME, "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/processors/AtomicProcessingTask;", "traceList", JsonProperty.USE_DEFAULT_NAME, JsonProperty.USE_DEFAULT_NAME, "(Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/processors/TranslationTask;Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/processors/TaskResultHandler;Ljava/util/List;Ljava/util/List;)V", "getLeaves", "()Ljava/util/List;", "setLeaves", "(Ljava/util/List;)V", "getResultHandler", "()Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/processors/TaskResultHandler;", "root", "getRoot", "()Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/processors/AtomicProcessingTask;", "getTraceList", "getTranslationTask", "()Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/processors/TranslationTask;", "addTrace", JsonProperty.USE_DEFAULT_NAME, "processorName", "processedTextList", "costTime", JsonProperty.USE_DEFAULT_NAME, "component1", "component2", "component3", "component4", "copy", "equals", JsonProperty.USE_DEFAULT_NAME, "other", "hashCode", JsonProperty.USE_DEFAULT_NAME, "toString", "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final /* data */ class ProcessingTask {
    private List<AtomicProcessingTask> leaves;
    private final TaskResultHandler resultHandler;
    private final AtomicProcessingTask root;
    private final List<String> traceList;
    private final TranslationTask translationTask;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ProcessingTask copy$default(ProcessingTask processingTask, TranslationTask translationTask, TaskResultHandler taskResultHandler, List list, List list2, int i, Object obj) {
        if ((i & 1) != 0) {
            translationTask = processingTask.translationTask;
        }
        if ((i & 2) != 0) {
            taskResultHandler = processingTask.resultHandler;
        }
        if ((i & 4) != 0) {
            list = processingTask.leaves;
        }
        if ((i & 8) != 0) {
            list2 = processingTask.traceList;
        }
        return processingTask.copy(translationTask, taskResultHandler, list, list2);
    }

    /* renamed from: component1, reason: from getter */
    public final TranslationTask getTranslationTask() {
        return this.translationTask;
    }

    /* renamed from: component2, reason: from getter */
    public final TaskResultHandler getResultHandler() {
        return this.resultHandler;
    }

    public final List<AtomicProcessingTask> component3() {
        return this.leaves;
    }

    public final List<String> component4() {
        return this.traceList;
    }

    public final ProcessingTask copy(TranslationTask translationTask, TaskResultHandler resultHandler, List<AtomicProcessingTask> leaves, List<String> traceList) {
        Intrinsics.checkNotNullParameter(translationTask, "translationTask");
        Intrinsics.checkNotNullParameter(leaves, "leaves");
        Intrinsics.checkNotNullParameter(traceList, "traceList");
        return new ProcessingTask(translationTask, resultHandler, leaves, traceList);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ProcessingTask)) {
            return false;
        }
        ProcessingTask processingTask = (ProcessingTask) other;
        return Intrinsics.areEqual(this.translationTask, processingTask.translationTask) && Intrinsics.areEqual(this.resultHandler, processingTask.resultHandler) && Intrinsics.areEqual(this.leaves, processingTask.leaves) && Intrinsics.areEqual(this.traceList, processingTask.traceList);
    }

    public int hashCode() {
        int hashCode = this.translationTask.hashCode() * 31;
        TaskResultHandler taskResultHandler = this.resultHandler;
        return ((((hashCode + (taskResultHandler == null ? 0 : taskResultHandler.hashCode())) * 31) + this.leaves.hashCode()) * 31) + this.traceList.hashCode();
    }

    public String toString() {
        return "ProcessingTask(translationTask=" + this.translationTask + ", resultHandler=" + this.resultHandler + ", leaves=" + this.leaves + ", traceList=" + this.traceList + ")";
    }

    public ProcessingTask(TranslationTask translationTask, TaskResultHandler taskResultHandler, List<AtomicProcessingTask> leaves, List<String> traceList) {
        Intrinsics.checkNotNullParameter(translationTask, "translationTask");
        Intrinsics.checkNotNullParameter(leaves, "leaves");
        Intrinsics.checkNotNullParameter(traceList, "traceList");
        this.translationTask = translationTask;
        this.resultHandler = taskResultHandler;
        this.leaves = leaves;
        this.traceList = traceList;
        AtomicProcessingTask atomicProcessingTask = new AtomicProcessingTask(translationTask.getSourceLanguageCode(), translationTask.getTargetLanguageCode(), translationTask.getSourceText(), translationTask.getVerbose(), false, null, null, null, null, null, null, null, null, null, null, 32752, null);
        this.root = atomicProcessingTask;
        if (this.leaves.isEmpty()) {
            this.leaves = CollectionsKt.listOf(atomicProcessingTask);
        }
    }

    public final TranslationTask getTranslationTask() {
        return this.translationTask;
    }

    public final TaskResultHandler getResultHandler() {
        return this.resultHandler;
    }

    public /* synthetic */ ProcessingTask(TranslationTask translationTask, TaskResultHandler taskResultHandler, List list, ArrayList arrayList, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(translationTask, (i & 2) != 0 ? null : taskResultHandler, (i & 4) != 0 ? CollectionsKt.emptyList() : list, (i & 8) != 0 ? new ArrayList() : arrayList);
    }

    public final List<AtomicProcessingTask> getLeaves() {
        return this.leaves;
    }

    public final void setLeaves(List<AtomicProcessingTask> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.leaves = list;
    }

    public final List<String> getTraceList() {
        return this.traceList;
    }

    public final AtomicProcessingTask getRoot() {
        return this.root;
    }

    public final void addTrace(String processorName, List<String> processedTextList, long costTime) {
        Intrinsics.checkNotNullParameter(processorName, "processorName");
        Intrinsics.checkNotNullParameter(processedTextList, "processedTextList");
        StringBuilder sb = new StringBuilder();
        sb.append("(SR Translation Engine) [" + processorName + " : " + costTime + "ms] (id: " + this.translationTask.getId() + ") ");
        int size = processedTextList.size();
        for (int i = 0; i < size; i++) {
            sb.append("[-] ");
        }
        List<String> list = this.traceList;
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
        list.add(sb2);
    }
}
