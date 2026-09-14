package com.samsung.sr.nmt.t2t.translator.core.pipeline;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.exception.EngineInterruptedException;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.ContinuousJob;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.PipelineSendableTask;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.ProcessingTask;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.TaskResultHandler;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.TranslationErrorCode;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.TranslationException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Pipeline.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", JsonProperty.USE_DEFAULT_NAME, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "com.samsung.sr.nmt.t2t.translator.core.pipeline.Pipeline$submit$1", f = "Pipeline.kt", i = {}, l = {128}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes.dex */
public final class Pipeline$submit$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ProcessingTask $task;
    int label;
    final /* synthetic */ Pipeline this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Pipeline$submit$1(Pipeline pipeline, ProcessingTask processingTask, Continuation<? super Pipeline$submit$1> continuation) {
        super(2, continuation);
        this.this$0 = pipeline;
        this.$task = processingTask;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new Pipeline$submit$1(this.this$0, this.$task, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((Pipeline$submit$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        ReentrantLock reentrantLock;
        ContinuousJob continuousJob;
        ContinuousJob continuousJob2;
        Channel<PipelineSendableTask> channel;
        Job launchContinuousJob;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            reentrantLock = this.this$0.lock;
            ReentrantLock reentrantLock2 = reentrantLock;
            Pipeline pipeline = this.this$0;
            reentrantLock2.lock();
            try {
                continuousJob = pipeline.continuousJob;
                if (continuousJob == null) {
                    Channel Channel$default = ChannelKt.Channel$default(Pipeline.CHANNEL_BUFFER_SIZE, null, new Function1<PipelineSendableTask, Unit>() { // from class: com.samsung.sr.nmt.t2t.translator.core.pipeline.Pipeline$submit$1$1$pipelineChannel$1
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(PipelineSendableTask pipelineSendableTask) {
                            invoke2(pipelineSendableTask);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(PipelineSendableTask it) {
                            TaskResultHandler resultHandler;
                            Intrinsics.checkNotNullParameter(it, "it");
                            ProcessingTask processingTask = it.getProcessingTask();
                            if (processingTask == null || (resultHandler = processingTask.getResultHandler()) == null) {
                                return;
                            }
                            resultHandler.onFailure(new TranslationException(new EngineInterruptedException("Engine cleared while task was in queue"), TranslationErrorCode.INTERRUPTED));
                        }
                    }, 2, null);
                    AtomicBoolean atomicBoolean = new AtomicBoolean(false);
                    launchContinuousJob = pipeline.launchContinuousJob(Channel$default, atomicBoolean);
                    pipeline.continuousJob = new ContinuousJob(launchContinuousJob, Channel$default, atomicBoolean);
                }
                Unit unit = Unit.INSTANCE;
                reentrantLock2.unlock();
                continuousJob2 = this.this$0.continuousJob;
                if (continuousJob2 == null || (channel = continuousJob2.getChannel()) == null) {
                    TaskResultHandler resultHandler = this.$task.getResultHandler();
                    if (resultHandler == null) {
                        return null;
                    }
                    resultHandler.onFailure(new TranslationException(new EngineInterruptedException("continuousJob cleared and there is no channel to send"), TranslationErrorCode.INTERRUPTED));
                } else {
                    this.label = 1;
                    if (channel.send(new PipelineSendableTask(this.$task, false, 2, null), this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            } catch (Throwable th) {
                reentrantLock2.unlock();
                throw th;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}
