package com.samsung.sr.nmt.t2t.translator.core.pipeline.processors;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PipelineSendableTask.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0005HÆ\u0003J\u001f\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\r\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0007R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0013"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/processors/PipelineSendableTask;", JsonProperty.USE_DEFAULT_NAME, "processingTask", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/processors/ProcessingTask;", "isCancellation", JsonProperty.USE_DEFAULT_NAME, "(Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/processors/ProcessingTask;Z)V", "()Z", "getProcessingTask", "()Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/processors/ProcessingTask;", "component1", "component2", "copy", "equals", "other", "hashCode", JsonProperty.USE_DEFAULT_NAME, "toString", JsonProperty.USE_DEFAULT_NAME, "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final /* data */ class PipelineSendableTask {
    private final boolean isCancellation;
    private final ProcessingTask processingTask;

    public static /* synthetic */ PipelineSendableTask copy$default(PipelineSendableTask pipelineSendableTask, ProcessingTask processingTask, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            processingTask = pipelineSendableTask.processingTask;
        }
        if ((i & 2) != 0) {
            z = pipelineSendableTask.isCancellation;
        }
        return pipelineSendableTask.copy(processingTask, z);
    }

    /* renamed from: component1, reason: from getter */
    public final ProcessingTask getProcessingTask() {
        return this.processingTask;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getIsCancellation() {
        return this.isCancellation;
    }

    public final PipelineSendableTask copy(ProcessingTask processingTask, boolean isCancellation) {
        return new PipelineSendableTask(processingTask, isCancellation);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PipelineSendableTask)) {
            return false;
        }
        PipelineSendableTask pipelineSendableTask = (PipelineSendableTask) other;
        return Intrinsics.areEqual(this.processingTask, pipelineSendableTask.processingTask) && this.isCancellation == pipelineSendableTask.isCancellation;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        ProcessingTask processingTask = this.processingTask;
        int hashCode = (processingTask == null ? 0 : processingTask.hashCode()) * 31;
        boolean z = this.isCancellation;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return hashCode + i;
    }

    public String toString() {
        return "PipelineSendableTask(processingTask=" + this.processingTask + ", isCancellation=" + this.isCancellation + ")";
    }

    public PipelineSendableTask(ProcessingTask processingTask, boolean z) {
        this.processingTask = processingTask;
        this.isCancellation = z;
    }

    public /* synthetic */ PipelineSendableTask(ProcessingTask processingTask, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(processingTask, (i & 2) != 0 ? false : z);
    }

    public final ProcessingTask getProcessingTask() {
        return this.processingTask;
    }

    public final boolean isCancellation() {
        return this.isCancellation;
    }
}
