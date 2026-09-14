package com.samsung.sr.nmt.t2t.translator.core.pipeline;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.PipelineSendableTask;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.Channel;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Pipeline.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", JsonProperty.USE_DEFAULT_NAME, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "com.samsung.sr.nmt.t2t.translator.core.pipeline.Pipeline$launchContinuousJob$1", f = "Pipeline.kt", i = {0, 0}, l = {173}, m = "invokeSuspend", n = {"baseTaskList", "countToRead"}, s = {"L$0", "I$0"})
/* loaded from: classes.dex */
public final class Pipeline$launchContinuousJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ AtomicBoolean $isCancelled;
    final /* synthetic */ Channel<PipelineSendableTask> $pipelineChannel;
    int I$0;
    Object L$0;
    int label;
    final /* synthetic */ Pipeline this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Pipeline$launchContinuousJob$1(Pipeline pipeline, AtomicBoolean atomicBoolean, Channel<PipelineSendableTask> channel, Continuation<? super Pipeline$launchContinuousJob$1> continuation) {
        super(2, continuation);
        this.this$0 = pipeline;
        this.$isCancelled = atomicBoolean;
        this.$pipelineChannel = channel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new Pipeline$launchContinuousJob$1(this.this$0, this.$isCancelled, this.$pipelineChannel, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((Pipeline$launchContinuousJob$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0042 A[LOOP:1: B:11:0x0042->B:15:0x0051, LOOP_START, PHI: r1
  0x0042: PHI (r1v8 int) = (r1v7 int), (r1v21 int) binds: [B:10:0x0040, B:15:0x0051] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0081  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x0075 -> B:5:0x0079). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r10) {
        /*
            r9 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r9.label
            r2 = 100
            r3 = 1
            if (r1 == 0) goto L22
            if (r1 != r3) goto L1a
            int r1 = r9.I$0
            java.lang.Object r4 = r9.L$0
            java.util.List r4 = (java.util.List) r4
            kotlin.ResultKt.throwOnFailure(r10)
            r5 = r1
            r1 = r0
            r0 = r9
            goto L79
        L1a:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L22:
            kotlin.ResultKt.throwOnFailure(r10)
            java.util.ArrayList r10 = new java.util.ArrayList
            r10.<init>()
            java.util.List r10 = (java.util.List) r10
            com.samsung.sr.nmt.t2t.translator.core.pipeline.Pipeline r1 = r9.this$0
            com.samsung.sr.nmt.t2t.translator.core.utils.SimpleLogger r1 = com.samsung.sr.nmt.t2t.translator.core.pipeline.Pipeline.access$getLogger$p(r1)
            java.lang.String r4 = "launchContinuousJob started"
            r1.debug(r4)
            r4 = r10
            r1 = r2
            r10 = r9
        L3a:
            java.util.concurrent.atomic.AtomicBoolean r5 = r10.$isCancelled
            boolean r5 = r5.get()
            if (r5 != 0) goto L9a
        L42:
            int r5 = r1 + (-1)
            if (r1 <= 0) goto L53
            com.samsung.sr.nmt.t2t.translator.core.pipeline.Pipeline r1 = r10.this$0
            kotlinx.coroutines.channels.Channel<com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.PipelineSendableTask> r6 = r10.$pipelineChannel
            boolean r1 = com.samsung.sr.nmt.t2t.translator.core.pipeline.Pipeline.access$tryReceiveNewTask(r1, r4, r6)
            if (r1 != 0) goto L51
            goto L53
        L51:
            r1 = r5
            goto L42
        L53:
            java.util.concurrent.atomic.AtomicBoolean r1 = r10.$isCancelled
            boolean r1 = r1.get()
            if (r1 != 0) goto L8a
            boolean r1 = r4.isEmpty()
            if (r1 == 0) goto L8a
            com.samsung.sr.nmt.t2t.translator.core.pipeline.Pipeline r1 = r10.this$0
            kotlinx.coroutines.channels.Channel<com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.PipelineSendableTask> r6 = r10.$pipelineChannel
            r7 = r10
            kotlin.coroutines.Continuation r7 = (kotlin.coroutines.Continuation) r7
            r10.L$0 = r4
            r10.I$0 = r5
            r10.label = r3
            java.lang.Object r1 = com.samsung.sr.nmt.t2t.translator.core.pipeline.Pipeline.access$receiveNewTask(r1, r4, r6, r7)
            if (r1 != r0) goto L75
            return r0
        L75:
            r8 = r0
            r0 = r10
            r10 = r1
            r1 = r8
        L79:
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            boolean r10 = r10.booleanValue()
            if (r10 == 0) goto L88
            int r10 = r5 + (-1)
            r8 = r1
            r1 = r10
            r10 = r0
            r0 = r8
            goto L3a
        L88:
            r10 = r0
            goto L9a
        L8a:
            java.util.concurrent.atomic.AtomicBoolean r1 = r10.$isCancelled
            boolean r1 = r1.get()
            if (r1 != 0) goto L9a
            com.samsung.sr.nmt.t2t.translator.core.pipeline.Pipeline r1 = r10.this$0
            java.util.List r4 = com.samsung.sr.nmt.t2t.translator.core.pipeline.Pipeline.access$runPipelineAndGetRestTaskList(r1, r4)
            r1 = r2
            goto L3a
        L9a:
            com.samsung.sr.nmt.t2t.translator.core.pipeline.Pipeline r0 = r10.this$0
            kotlinx.coroutines.channels.Channel<com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.PipelineSendableTask> r1 = r10.$pipelineChannel
            com.samsung.sr.nmt.t2t.translator.core.pipeline.Pipeline.access$sendCancellationToAllRemainingJobs(r0, r4, r1)
            kotlinx.coroutines.channels.Channel<com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.PipelineSendableTask> r0 = r10.$pipelineChannel
            kotlinx.coroutines.channels.SendChannel r0 = (kotlinx.coroutines.channels.SendChannel) r0
            r1 = 0
            kotlinx.coroutines.channels.SendChannel.DefaultImpls.close$default(r0, r1, r3, r1)
            com.samsung.sr.nmt.t2t.translator.core.pipeline.Pipeline r10 = r10.this$0
            com.samsung.sr.nmt.t2t.translator.core.utils.SimpleLogger r10 = com.samsung.sr.nmt.t2t.translator.core.pipeline.Pipeline.access$getLogger$p(r10)
            java.lang.String r0 = "[Clearing] launchContinuousJob done"
            r10.info(r0)
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.samsung.sr.nmt.t2t.translator.core.pipeline.Pipeline$launchContinuousJob$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
