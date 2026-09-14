package com.samsung.sr.nmt.t2t.translator.core.pipeline.processors;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.samsung.sr.nmt.t2t.translator.core.utils.LanguageDirection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ProcessorJob.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0018\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0080\b\u0018\u0000 ,2\u00020\u0001:\u0001,BC\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b¢\u0006\u0002\u0010\rJ\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\bHÆ\u0003J\t\u0010\u001d\u001a\u00020\bHÆ\u0003J\t\u0010\u001e\u001a\u00020\u000bHÆ\u0003J\t\u0010\u001f\u001a\u00020\u000bHÆ\u0003JK\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000bHÆ\u0001J\u0013\u0010!\u001a\u00020\b2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020$HÖ\u0001J\t\u0010%\u001a\u00020\u000bHÖ\u0001J-\u0010&\u001a\u0002H'\"\u0004\b\u0000\u0010'2\u0006\u0010(\u001a\u00020\u000b2\u0012\u0010)\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u0002H'0*¢\u0006\u0002\u0010+R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\t\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\f\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000fR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0011¨\u0006-"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/processors/ProcessorJob;", JsonProperty.USE_DEFAULT_NAME, "languageDirection", "Lcom/samsung/sr/nmt/t2t/translator/core/utils/LanguageDirection;", "tasks", JsonProperty.USE_DEFAULT_NAME, "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/processors/ProcessingTask;", "verbose", JsonProperty.USE_DEFAULT_NAME, "interrupted", "id", JsonProperty.USE_DEFAULT_NAME, "mode", "(Lcom/samsung/sr/nmt/t2t/translator/core/utils/LanguageDirection;Ljava/util/List;ZZLjava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getInterrupted", "()Z", "setInterrupted", "(Z)V", "getLanguageDirection", "()Lcom/samsung/sr/nmt/t2t/translator/core/utils/LanguageDirection;", "getMode", "getTasks", "()Ljava/util/List;", "getVerbose", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", JsonProperty.USE_DEFAULT_NAME, "toString", "withJob", "T", "processorName", "convert", "Lkotlin/Function1;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "Companion", "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final /* data */ class ProcessorJob {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String id;
    private boolean interrupted;
    private final LanguageDirection languageDirection;
    private final String mode;
    private final List<ProcessingTask> tasks;
    private final boolean verbose;

    public static /* synthetic */ ProcessorJob copy$default(ProcessorJob processorJob, LanguageDirection languageDirection, List list, boolean z, boolean z2, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            languageDirection = processorJob.languageDirection;
        }
        if ((i & 2) != 0) {
            list = processorJob.tasks;
        }
        List list2 = list;
        if ((i & 4) != 0) {
            z = processorJob.verbose;
        }
        boolean z3 = z;
        if ((i & 8) != 0) {
            z2 = processorJob.interrupted;
        }
        boolean z4 = z2;
        if ((i & 16) != 0) {
            str = processorJob.id;
        }
        String str3 = str;
        if ((i & 32) != 0) {
            str2 = processorJob.mode;
        }
        return processorJob.copy(languageDirection, list2, z3, z4, str3, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final LanguageDirection getLanguageDirection() {
        return this.languageDirection;
    }

    public final List<ProcessingTask> component2() {
        return this.tasks;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getVerbose() {
        return this.verbose;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getInterrupted() {
        return this.interrupted;
    }

    /* renamed from: component5, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component6, reason: from getter */
    public final String getMode() {
        return this.mode;
    }

    public final ProcessorJob copy(LanguageDirection languageDirection, List<ProcessingTask> tasks, boolean verbose, boolean interrupted, String id, String mode) {
        Intrinsics.checkNotNullParameter(languageDirection, "languageDirection");
        Intrinsics.checkNotNullParameter(tasks, "tasks");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(mode, "mode");
        return new ProcessorJob(languageDirection, tasks, verbose, interrupted, id, mode);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ProcessorJob)) {
            return false;
        }
        ProcessorJob processorJob = (ProcessorJob) other;
        return Intrinsics.areEqual(this.languageDirection, processorJob.languageDirection) && Intrinsics.areEqual(this.tasks, processorJob.tasks) && this.verbose == processorJob.verbose && this.interrupted == processorJob.interrupted && Intrinsics.areEqual(this.id, processorJob.id) && Intrinsics.areEqual(this.mode, processorJob.mode);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((this.languageDirection.hashCode() * 31) + this.tasks.hashCode()) * 31;
        boolean z = this.verbose;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        int i2 = (hashCode + i) * 31;
        boolean z2 = this.interrupted;
        return ((((i2 + (z2 ? 1 : z2 ? 1 : 0)) * 31) + this.id.hashCode()) * 31) + this.mode.hashCode();
    }

    public String toString() {
        return "ProcessorJob(languageDirection=" + this.languageDirection + ", tasks=" + this.tasks + ", verbose=" + this.verbose + ", interrupted=" + this.interrupted + ", id=" + this.id + ", mode=" + this.mode + ")";
    }

    public ProcessorJob(LanguageDirection languageDirection, List<ProcessingTask> tasks, boolean z, boolean z2, String id, String mode) {
        Intrinsics.checkNotNullParameter(languageDirection, "languageDirection");
        Intrinsics.checkNotNullParameter(tasks, "tasks");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(mode, "mode");
        this.languageDirection = languageDirection;
        this.tasks = tasks;
        this.verbose = z;
        this.interrupted = z2;
        this.id = id;
        this.mode = mode;
    }

    public final LanguageDirection getLanguageDirection() {
        return this.languageDirection;
    }

    public final List<ProcessingTask> getTasks() {
        return this.tasks;
    }

    public final boolean getVerbose() {
        return this.verbose;
    }

    public final boolean getInterrupted() {
        return this.interrupted;
    }

    public final void setInterrupted(boolean z) {
        this.interrupted = z;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ ProcessorJob(com.samsung.sr.nmt.t2t.translator.core.utils.LanguageDirection r10, java.util.List r11, boolean r12, boolean r13, java.lang.String r14, java.lang.String r15, int r16, kotlin.jvm.internal.DefaultConstructorMarker r17) {
        /*
            r9 = this;
            r0 = r16 & 4
            r1 = 0
            if (r0 == 0) goto L7
            r5 = r1
            goto L8
        L7:
            r5 = r12
        L8:
            r0 = r16 & 8
            if (r0 == 0) goto Le
            r6 = r1
            goto Lf
        Le:
            r6 = r13
        Lf:
            r0 = r16 & 16
            if (r0 == 0) goto L22
            java.util.UUID r0 = java.util.UUID.randomUUID()
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "toString(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            r7 = r0
            goto L23
        L22:
            r7 = r14
        L23:
            r0 = r16 & 32
            if (r0 == 0) goto L2b
            java.lang.String r0 = "plain"
            r8 = r0
            goto L2c
        L2b:
            r8 = r15
        L2c:
            r2 = r9
            r3 = r10
            r4 = r11
            r2.<init>(r3, r4, r5, r6, r7, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.ProcessorJob.<init>(com.samsung.sr.nmt.t2t.translator.core.utils.LanguageDirection, java.util.List, boolean, boolean, java.lang.String, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final String getId() {
        return this.id;
    }

    public final String getMode() {
        return this.mode;
    }

    public final <T> T withJob(String processorName, Function1<? super ProcessorJob, ? extends T> convert) {
        Intrinsics.checkNotNullParameter(processorName, "processorName");
        Intrinsics.checkNotNullParameter(convert, "convert");
        long currentTimeMillis = System.currentTimeMillis();
        T invoke = convert.invoke(this);
        if (this.verbose) {
            for (ProcessingTask processingTask : this.tasks) {
                if (processingTask.getRoot().getVerbose()) {
                    List<AtomicProcessingTask> leaves = processingTask.getLeaves();
                    ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(leaves, 10));
                    Iterator<T> it = leaves.iterator();
                    while (it.hasNext()) {
                        arrayList.add(((AtomicProcessingTask) it.next()).getCurrentText());
                    }
                    processingTask.addTrace(processorName, arrayList, System.currentTimeMillis() - currentTimeMillis);
                }
            }
        }
        return invoke;
    }

    /* compiled from: ProcessorJob.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¨\u0006\b"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/processors/ProcessorJob$Companion;", JsonProperty.USE_DEFAULT_NAME, "()V", "getJob", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/processors/ProcessorJob;", "taskList", JsonProperty.USE_DEFAULT_NAME, "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/processors/ProcessingTask;", "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ProcessorJob getJob(List<ProcessingTask> taskList) {
            Intrinsics.checkNotNullParameter(taskList, "taskList");
            if (!(!taskList.isEmpty())) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            AtomicProcessingTask root = ((ProcessingTask) CollectionsKt.first((List) taskList)).getRoot();
            return new ProcessorJob(new LanguageDirection(root.getSourceLanguage(), root.getTargetLanguage()), taskList, ((ProcessingTask) CollectionsKt.first((List) taskList)).getRoot().getVerbose(), false, null, null, 56, null);
        }
    }
}
