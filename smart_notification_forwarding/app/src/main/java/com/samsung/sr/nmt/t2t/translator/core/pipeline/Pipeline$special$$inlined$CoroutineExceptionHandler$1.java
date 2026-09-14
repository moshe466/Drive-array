package com.samsung.sr.nmt.t2t.translator.core.pipeline;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.exception.EngineInterruptedException;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.exception.IllegalResourceException;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.exception.ResourceAccessException;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.exception.UnauthorizedResourceException;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.ContinuousJob;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.PipelineSendableTask;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.ProcessingTask;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.ProcessorJob;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.TaskResultHandler;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.TranslationErrorCode;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.TranslationException;
import com.samsung.sr.nmt.t2t.translator.core.utils.SimpleLogger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.SendChannel;

/* compiled from: CoroutineExceptionHandler.kt */
@Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "handleException", JsonProperty.USE_DEFAULT_NAME, "context", "Lkotlin/coroutines/CoroutineContext;", "exception", JsonProperty.USE_DEFAULT_NAME, "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class Pipeline$special$$inlined$CoroutineExceptionHandler$1 extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {
    final /* synthetic */ Pipeline this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Pipeline$special$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.Companion companion, Pipeline pipeline) {
        super(companion);
        this.this$0 = pipeline;
    }

    @Override // kotlinx.coroutines.CoroutineExceptionHandler
    public void handleException(CoroutineContext context, Throwable exception) {
        ConcurrentHashMap concurrentHashMap;
        ReentrantLock reentrantLock;
        ContinuousJob continuousJob;
        SimpleLogger simpleLogger;
        Channel<PipelineSendableTask> channel;
        ConcurrentHashMap concurrentHashMap2;
        TranslationErrorCode translationErrorCode;
        concurrentHashMap = this.this$0.runningJobs;
        Collection<ProcessorJob> values = concurrentHashMap.values();
        Intrinsics.checkNotNullExpressionValue(values, "<get-values>(...)");
        for (ProcessorJob processorJob : values) {
            Iterator<T> it = processorJob.getTasks().iterator();
            while (it.hasNext()) {
                TaskResultHandler resultHandler = ((ProcessingTask) it.next()).getResultHandler();
                if (resultHandler != null) {
                    if (exception instanceof ResourceAccessException) {
                        translationErrorCode = TranslationErrorCode.RESOURCE_ACCESS_ERROR;
                    } else if (exception instanceof UnauthorizedResourceException) {
                        translationErrorCode = TranslationErrorCode.UNAUTHORIZED_RESOURCE_ERROR;
                    } else if (exception instanceof IllegalResourceException) {
                        translationErrorCode = TranslationErrorCode.ILLEGAL_RESOURCE_ERROR;
                    } else {
                        translationErrorCode = exception instanceof EngineInterruptedException ? TranslationErrorCode.INTERRUPTED : TranslationErrorCode.COMPUTATION_ERROR;
                    }
                    resultHandler.onFailure(new TranslationException(exception, translationErrorCode));
                }
            }
            concurrentHashMap2 = this.this$0.runningJobs;
            concurrentHashMap2.remove(processorJob.getId());
        }
        reentrantLock = this.this$0.lock;
        ReentrantLock reentrantLock2 = reentrantLock;
        reentrantLock2.lock();
        try {
            continuousJob = this.this$0.continuousJob;
            if (continuousJob != null && (channel = continuousJob.getChannel()) != null) {
                this.this$0.cancelContinuousJob(channel);
                this.this$0.sendCancellationToAllRemainingJobs(new ArrayList(), channel);
                SendChannel.DefaultImpls.close$default(channel, null, 1, null);
            }
            this.this$0.continuousJob = null;
            Unit unit = Unit.INSTANCE;
            reentrantLock2.unlock();
            simpleLogger = this.this$0.logger;
            simpleLogger.error("[Coroutine Exception]", exception);
        } catch (Throwable th) {
            reentrantLock2.unlock();
            throw th;
        }
    }
}
