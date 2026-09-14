package com.samsung.sr.nmt.t2t.translator.core.pipeline;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.PipelineSendableTask;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelResult;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Pipeline.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", JsonProperty.USE_DEFAULT_NAME, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "com.samsung.sr.nmt.t2t.translator.core.pipeline.Pipeline$cancelContinuousJob$1", f = "Pipeline.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes.dex */
public final class Pipeline$cancelContinuousJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Channel<PipelineSendableTask> $pipelineChannel;
    int label;
    final /* synthetic */ Pipeline this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Pipeline$cancelContinuousJob$1(Channel<PipelineSendableTask> channel, Pipeline pipeline, Continuation<? super Pipeline$cancelContinuousJob$1> continuation) {
        super(2, continuation);
        this.$pipelineChannel = channel;
        this.this$0 = pipeline;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new Pipeline$cancelContinuousJob$1(this.$pipelineChannel, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((Pipeline$cancelContinuousJob$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        while (true) {
            Object obj2 = this.$pipelineChannel.mo1629trySendJP2dKIU(new PipelineSendableTask(null, true));
            if (ChannelResult.m1644isSuccessimpl(obj2) || ChannelResult.m1642isClosedimpl(obj2)) {
                break;
            }
            this.this$0.sendCancellationToAllRemainingJobs(new ArrayList(), this.$pipelineChannel);
        }
        return Unit.INSTANCE;
    }
}
