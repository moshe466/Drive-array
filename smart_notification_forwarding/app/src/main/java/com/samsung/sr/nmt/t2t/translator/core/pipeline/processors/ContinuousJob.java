package com.samsung.sr.nmt.t2t.translator.core.pipeline.processors;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.Channel;

/* compiled from: ContinuousJob.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\bHÆ\u0003J-\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/processors/ContinuousJob;", JsonProperty.USE_DEFAULT_NAME, "job", "Lkotlinx/coroutines/Job;", "channel", "Lkotlinx/coroutines/channels/Channel;", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/processors/PipelineSendableTask;", "cancelled", "Ljava/util/concurrent/atomic/AtomicBoolean;", "(Lkotlinx/coroutines/Job;Lkotlinx/coroutines/channels/Channel;Ljava/util/concurrent/atomic/AtomicBoolean;)V", "getCancelled", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "getChannel", "()Lkotlinx/coroutines/channels/Channel;", "getJob", "()Lkotlinx/coroutines/Job;", "component1", "component2", "component3", "copy", "equals", JsonProperty.USE_DEFAULT_NAME, "other", "hashCode", JsonProperty.USE_DEFAULT_NAME, "toString", JsonProperty.USE_DEFAULT_NAME, "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final /* data */ class ContinuousJob {
    private final AtomicBoolean cancelled;
    private final Channel<PipelineSendableTask> channel;
    private final Job job;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ContinuousJob copy$default(ContinuousJob continuousJob, Job job, Channel channel, AtomicBoolean atomicBoolean, int i, Object obj) {
        if ((i & 1) != 0) {
            job = continuousJob.job;
        }
        if ((i & 2) != 0) {
            channel = continuousJob.channel;
        }
        if ((i & 4) != 0) {
            atomicBoolean = continuousJob.cancelled;
        }
        return continuousJob.copy(job, channel, atomicBoolean);
    }

    /* renamed from: component1, reason: from getter */
    public final Job getJob() {
        return this.job;
    }

    public final Channel<PipelineSendableTask> component2() {
        return this.channel;
    }

    /* renamed from: component3, reason: from getter */
    public final AtomicBoolean getCancelled() {
        return this.cancelled;
    }

    public final ContinuousJob copy(Job job, Channel<PipelineSendableTask> channel, AtomicBoolean cancelled) {
        Intrinsics.checkNotNullParameter(job, "job");
        Intrinsics.checkNotNullParameter(channel, "channel");
        Intrinsics.checkNotNullParameter(cancelled, "cancelled");
        return new ContinuousJob(job, channel, cancelled);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ContinuousJob)) {
            return false;
        }
        ContinuousJob continuousJob = (ContinuousJob) other;
        return Intrinsics.areEqual(this.job, continuousJob.job) && Intrinsics.areEqual(this.channel, continuousJob.channel) && Intrinsics.areEqual(this.cancelled, continuousJob.cancelled);
    }

    public int hashCode() {
        return (((this.job.hashCode() * 31) + this.channel.hashCode()) * 31) + this.cancelled.hashCode();
    }

    public String toString() {
        return "ContinuousJob(job=" + this.job + ", channel=" + this.channel + ", cancelled=" + this.cancelled + ")";
    }

    public ContinuousJob(Job job, Channel<PipelineSendableTask> channel, AtomicBoolean cancelled) {
        Intrinsics.checkNotNullParameter(job, "job");
        Intrinsics.checkNotNullParameter(channel, "channel");
        Intrinsics.checkNotNullParameter(cancelled, "cancelled");
        this.job = job;
        this.channel = channel;
        this.cancelled = cancelled;
    }

    public final Job getJob() {
        return this.job;
    }

    public final Channel<PipelineSendableTask> getChannel() {
        return this.channel;
    }

    public final AtomicBoolean getCancelled() {
        return this.cancelled;
    }
}
