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
import com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.Processor;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.ProcessorJob;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.TaskResultHandler;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.TranslationErrorCode;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.TranslationException;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.TranslationProcessor;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.TranslationTask;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.spec.LanguageSpecFactory;
import com.samsung.sr.nmt.t2t.translator.core.utils.LanguageDirection;
import com.samsung.sr.nmt.t2t.translator.core.utils.LoggerFactory;
import com.samsung.sr.nmt.t2t.translator.core.utils.SimpleLogger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelResult;

/* compiled from: Pipeline.kt */
@Singleton
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\b\n\b\u0001\u0018\u0000 =2\u00020\u0001:\u0001=B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0016\u0010\u001c\u001a\u00020\u001d2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001fH\u0002J\u0006\u0010!\u001a\u00020\"J(\u0010#\u001a\b\u0012\u0004\u0012\u00020%0$2\u0006\u0010&\u001a\u00020\u001a2\u0006\u0010'\u001a\u00020\u001a2\b\b\u0002\u0010(\u001a\u00020\u001aH\u0002J\u001a\u0010)\u001a\u00020\"2\b\b\u0002\u0010*\u001a\u00020\t2\u0006\u0010+\u001a\u00020,H\u0002J\u001e\u0010-\u001a\u00020\u001d2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001f2\u0006\u0010.\u001a\u00020/H\u0002J\u0010\u00100\u001a\u00020\u001b2\u0006\u0010\u0012\u001a\u00020\u001bH\u0002J-\u00101\u001a\u0002022\f\u00103\u001a\b\u0012\u0004\u0012\u00020,042\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001fH\u0082@ø\u0001\u0000¢\u0006\u0002\u00105J\u001c\u00106\u001a\b\u0012\u0004\u0012\u00020,042\f\u00103\u001a\b\u0012\u0004\u0012\u00020,04H\u0002J$\u00107\u001a\u00020\"2\f\u00103\u001a\b\u0012\u0004\u0012\u00020,042\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001fH\u0002J\u0010\u00108\u001a\u00020\"2\u0006\u0010\u0012\u001a\u00020\u001bH\u0002J\u0015\u00109\u001a\u0004\u0018\u00010\"2\u0006\u0010:\u001a\u00020,¢\u0006\u0002\u0010;J$\u0010<\u001a\u0002022\f\u00103\u001a\b\u0012\u0004\u0012\u00020,042\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001fH\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001b0\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006>"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/Pipeline;", "Lkotlinx/coroutines/CoroutineScope;", "languageSpecFactory", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/spec/LanguageSpecFactory;", "translationProcessor", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/processors/TranslationProcessor;", "computationContext", "Lkotlin/coroutines/CoroutineContext;", "characterBatchSize", JsonProperty.USE_DEFAULT_NAME, "(Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/spec/LanguageSpecFactory;Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/processors/TranslationProcessor;Lkotlin/coroutines/CoroutineContext;I)V", "continuousJob", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/processors/ContinuousJob;", "coroutineContext", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "exceptionHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "job", "Lkotlinx/coroutines/CompletableJob;", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "logger", "Lcom/samsung/sr/nmt/t2t/translator/core/utils/SimpleLogger;", "runningJobs", "Ljava/util/concurrent/ConcurrentHashMap;", JsonProperty.USE_DEFAULT_NAME, "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/processors/ProcessorJob;", "cancelContinuousJob", "Lkotlinx/coroutines/Job;", "pipelineChannel", "Lkotlinx/coroutines/channels/Channel;", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/processors/PipelineSendableTask;", "clear", JsonProperty.USE_DEFAULT_NAME, "getNewPipeline", JsonProperty.USE_DEFAULT_NAME, "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/processors/Processor;", "sourceLanguage", "targetLanguage", "mode", "invokeCallback", "code", "processorTask", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/processors/ProcessingTask;", "launchContinuousJob", "isCancelled", "Ljava/util/concurrent/atomic/AtomicBoolean;", "processJob", "receiveNewTask", JsonProperty.USE_DEFAULT_NAME, "baseTaskList", JsonProperty.USE_DEFAULT_NAME, "(Ljava/util/List;Lkotlinx/coroutines/channels/Channel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "runPipelineAndGetRestTaskList", "sendCancellationToAllRemainingJobs", "sendFinishedJobResult", "submit", "task", "(Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/processors/ProcessingTask;)Lkotlin/Unit;", "tryReceiveNewTask", "Companion", "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class Pipeline implements CoroutineScope {
    public static final int CHANNEL_BUFFER_SIZE = 5000;
    public static final int READING_QUEUE_SIZE = 100;
    public static final int TRANSLATION_FAILURE = -1;
    public static final int TRANSLATION_SUCCESS = 0;
    private final int characterBatchSize;
    private final CoroutineContext computationContext;
    private ContinuousJob continuousJob;
    private final CoroutineExceptionHandler exceptionHandler;
    private final CompletableJob job;
    private final LanguageSpecFactory languageSpecFactory;
    private final ReentrantLock lock;
    private final SimpleLogger logger;
    private final ConcurrentHashMap<String, ProcessorJob> runningJobs;
    private final TranslationProcessor translationProcessor;

    @Inject
    public Pipeline(LanguageSpecFactory languageSpecFactory, TranslationProcessor translationProcessor, CoroutineContext computationContext, int i) {
        Intrinsics.checkNotNullParameter(languageSpecFactory, "languageSpecFactory");
        Intrinsics.checkNotNullParameter(translationProcessor, "translationProcessor");
        Intrinsics.checkNotNullParameter(computationContext, "computationContext");
        this.languageSpecFactory = languageSpecFactory;
        this.translationProcessor = translationProcessor;
        this.computationContext = computationContext;
        this.characterBatchSize = i;
        this.logger = LoggerFactory.INSTANCE.getLogger(getClass());
        this.job = SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null);
        this.runningJobs = new ConcurrentHashMap<>();
        this.exceptionHandler = new Pipeline$special$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.INSTANCE, this);
        this.lock = new ReentrantLock();
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public CoroutineContext getCoroutineContext() {
        return this.computationContext.plus(this.job);
    }

    public final Unit submit(ProcessingTask task) {
        Object runBlocking$default;
        Intrinsics.checkNotNullParameter(task, "task");
        runBlocking$default = BuildersKt__BuildersKt.runBlocking$default(null, new Pipeline$submit$1(this, task, null), 1, null);
        return (Unit) runBlocking$default;
    }

    public final void clear() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            Collection<ProcessorJob> values = this.runningJobs.values();
            Intrinsics.checkNotNullExpressionValue(values, "<get-values>(...)");
            for (ProcessorJob processorJob : values) {
                Iterator<T> it = processorJob.getTasks().iterator();
                while (it.hasNext()) {
                    TranslationTask translationTask = ((ProcessingTask) it.next()).getTranslationTask();
                    if (translationTask.getErrorCode() == TranslationErrorCode.NONE && translationTask.getThrowable() == null) {
                        translationTask.setErrorCode(TranslationErrorCode.INTERRUPTED);
                        translationTask.setThrowable(new EngineInterruptedException("Interrupted while in runningJobs"));
                    }
                }
                processorJob.setInterrupted(true);
            }
            ContinuousJob continuousJob = this.continuousJob;
            if (continuousJob != null) {
                continuousJob.getCancelled().set(true);
                cancelContinuousJob(continuousJob.getChannel());
            }
            this.continuousJob = null;
            Unit unit = Unit.INSTANCE;
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Job launchContinuousJob(Channel<PipelineSendableTask> pipelineChannel, AtomicBoolean isCancelled) {
        Job launch$default;
        launch$default = BuildersKt__Builders_commonKt.launch$default(this, this.exceptionHandler, null, new Pipeline$launchContinuousJob$1(this, isCancelled, pipelineChannel, null), 2, null);
        return launch$default;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void sendCancellationToAllRemainingJobs(List<ProcessingTask> baseTaskList, Channel<PipelineSendableTask> pipelineChannel) {
        do {
        } while (tryReceiveNewTask(baseTaskList, pipelineChannel));
        Iterator<T> it = baseTaskList.iterator();
        while (it.hasNext()) {
            TaskResultHandler resultHandler = ((ProcessingTask) it.next()).getResultHandler();
            if (resultHandler != null) {
                resultHandler.onFailure(new TranslationException(new EngineInterruptedException("Engine cleared while task was in queue"), TranslationErrorCode.INTERRUPTED));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean tryReceiveNewTask(List<ProcessingTask> baseTaskList, Channel<PipelineSendableTask> pipelineChannel) {
        PipelineSendableTask pipelineSendableTask = (PipelineSendableTask) ChannelResult.m1639getOrNullimpl(pipelineChannel.mo1628tryReceivePtdJZtk());
        if (pipelineSendableTask == null) {
            return false;
        }
        ProcessingTask processingTask = pipelineSendableTask.getProcessingTask();
        if (processingTask != null) {
            baseTaskList.add(processingTask);
        }
        return !pipelineSendableTask.isCancellation();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0053 A[Catch: ClosedReceiveChannelException -> 0x0061, TryCatch #1 {ClosedReceiveChannelException -> 0x0061, blocks: (B:11:0x002e, B:12:0x004b, B:14:0x0053, B:15:0x005a), top: B:10:0x002e }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object receiveNewTask(java.util.List<com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.ProcessingTask> r5, kotlinx.coroutines.channels.Channel<com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.PipelineSendableTask> r6, kotlin.coroutines.Continuation<? super java.lang.Boolean> r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof com.samsung.sr.nmt.t2t.translator.core.pipeline.Pipeline$receiveNewTask$1
            if (r0 == 0) goto L14
            r0 = r7
            com.samsung.sr.nmt.t2t.translator.core.pipeline.Pipeline$receiveNewTask$1 r0 = (com.samsung.sr.nmt.t2t.translator.core.pipeline.Pipeline$receiveNewTask$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L19
        L14:
            com.samsung.sr.nmt.t2t.translator.core.pipeline.Pipeline$receiveNewTask$1 r0 = new com.samsung.sr.nmt.t2t.translator.core.pipeline.Pipeline$receiveNewTask$1
            r0.<init>(r4, r7)
        L19:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3a
            if (r2 != r3) goto L32
            java.lang.Object r5 = r0.L$1
            java.util.List r5 = (java.util.List) r5
            java.lang.Object r6 = r0.L$0
            com.samsung.sr.nmt.t2t.translator.core.pipeline.Pipeline r6 = (com.samsung.sr.nmt.t2t.translator.core.pipeline.Pipeline) r6
            kotlin.ResultKt.throwOnFailure(r7)     // Catch: kotlinx.coroutines.channels.ClosedReceiveChannelException -> L61
            goto L4b
        L32:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L3a:
            kotlin.ResultKt.throwOnFailure(r7)
            r0.L$0 = r4     // Catch: kotlinx.coroutines.channels.ClosedReceiveChannelException -> L60
            r0.L$1 = r5     // Catch: kotlinx.coroutines.channels.ClosedReceiveChannelException -> L60
            r0.label = r3     // Catch: kotlinx.coroutines.channels.ClosedReceiveChannelException -> L60
            java.lang.Object r7 = r6.receive(r0)     // Catch: kotlinx.coroutines.channels.ClosedReceiveChannelException -> L60
            if (r7 != r1) goto L4a
            return r1
        L4a:
            r6 = r4
        L4b:
            com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.PipelineSendableTask r7 = (com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.PipelineSendableTask) r7     // Catch: kotlinx.coroutines.channels.ClosedReceiveChannelException -> L61
            com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.ProcessingTask r0 = r7.getProcessingTask()     // Catch: kotlinx.coroutines.channels.ClosedReceiveChannelException -> L61
            if (r0 == 0) goto L5a
            boolean r5 = r5.add(r0)     // Catch: kotlinx.coroutines.channels.ClosedReceiveChannelException -> L61
            kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r5)     // Catch: kotlinx.coroutines.channels.ClosedReceiveChannelException -> L61
        L5a:
            boolean r5 = r7.isCancellation()     // Catch: kotlinx.coroutines.channels.ClosedReceiveChannelException -> L61
            r5 = r5 ^ r3
            goto L69
        L60:
            r6 = r4
        L61:
            com.samsung.sr.nmt.t2t.translator.core.utils.SimpleLogger r5 = r6.logger
            java.lang.String r6 = "channel closed without cancellation signal"
            r5.info(r6)
            r5 = 0
        L69:
            java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.samsung.sr.nmt.t2t.translator.core.pipeline.Pipeline.receiveNewTask(java.util.List, kotlinx.coroutines.channels.Channel, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Job cancelContinuousJob(Channel<PipelineSendableTask> pipelineChannel) {
        Job launch$default;
        launch$default = BuildersKt__Builders_commonKt.launch$default(this, null, null, new Pipeline$cancelContinuousJob$1(pipelineChannel, this, null), 3, null);
        return launch$default;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final List<ProcessingTask> runPipelineAndGetRestTaskList(List<ProcessingTask> baseTaskList) {
        ArrayList arrayList = new ArrayList();
        String mode = ((ProcessingTask) CollectionsKt.first((List) baseTaskList)).getTranslationTask().getMode();
        String packageName = ((ProcessingTask) CollectionsKt.first((List) baseTaskList)).getTranslationTask().getPackageName();
        String sourceLanguageCode = ((ProcessingTask) CollectionsKt.first((List) baseTaskList)).getTranslationTask().getSourceLanguageCode();
        String targetLanguageCode = ((ProcessingTask) CollectionsKt.first((List) baseTaskList)).getTranslationTask().getTargetLanguageCode();
        int i = 0;
        List<ProcessingTask> mutableListOf = CollectionsKt.mutableListOf(CollectionsKt.first((List) baseTaskList));
        baseTaskList.remove(0);
        int length = StringsKt.trim((CharSequence) ((ProcessingTask) CollectionsKt.first(mutableListOf)).getTranslationTask().getSourceText()).toString().length();
        arrayList.clear();
        List<ProcessingTask> list = baseTaskList;
        for (ProcessingTask processingTask : list) {
            int length2 = StringsKt.trim((CharSequence) processingTask.getTranslationTask().getSourceText()).toString().length() + length;
            if (length2 < this.characterBatchSize && Intrinsics.areEqual(processingTask.getTranslationTask().getMode(), mode) && Intrinsics.areEqual(processingTask.getTranslationTask().getPackageName(), packageName) && Intrinsics.areEqual(processingTask.getTranslationTask().getSourceLanguageCode(), sourceLanguageCode) && Intrinsics.areEqual(processingTask.getTranslationTask().getTargetLanguageCode(), targetLanguageCode)) {
                mutableListOf.add(processingTask);
                arrayList.add(false);
                length = length2;
            } else {
                arrayList.add(true);
            }
        }
        this.logger.debug("Translate Tasks Count | " + mutableListOf.size() + " | Character Count | " + length);
        for (ProcessingTask processingTask2 : mutableListOf) {
            if (processingTask2.getTranslationTask().getVerbose()) {
                this.logger.debug("(SR Translation Task) Received task " + processingTask2.getTranslationTask().getId());
            }
        }
        TranslationTask translationTask = ((ProcessingTask) CollectionsKt.first(mutableListOf)).getTranslationTask();
        sendFinishedJobResult(processJob(new ProcessorJob(new LanguageDirection(translationTask.getSourceLanguageCode(), translationTask.getTargetLanguageCode()), mutableListOf, translationTask.getVerbose(), false, null, translationTask.getMode(), 24, null)));
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : list) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            if (((Boolean) arrayList.get(i)).booleanValue()) {
                arrayList2.add(obj);
            }
            i = i2;
        }
        return CollectionsKt.toMutableList((Collection) arrayList2);
    }

    private final ProcessorJob processJob(ProcessorJob job) {
        TranslationErrorCode translationErrorCode;
        this.runningJobs.put(job.getId(), job);
        try {
            Iterator<T> it = getNewPipeline(job.getLanguageDirection().getSrcLang(), job.getLanguageDirection().getTgtLang(), job.getMode()).iterator();
            while (it.hasNext()) {
                job = ((Processor) it.next()).run$translator_core(job);
            }
        } catch (Exception e) {
            Exception exc = e;
            this.logger.error("Uncatched exception within processor.run", exc);
            job.setInterrupted(true);
            for (ProcessingTask processingTask : job.getTasks()) {
                processingTask.getTranslationTask().setThrowable(exc);
                TranslationTask translationTask = processingTask.getTranslationTask();
                if (e instanceof ResourceAccessException) {
                    translationErrorCode = TranslationErrorCode.RESOURCE_ACCESS_ERROR;
                } else if (e instanceof UnauthorizedResourceException) {
                    translationErrorCode = TranslationErrorCode.UNAUTHORIZED_RESOURCE_ERROR;
                } else if (e instanceof IllegalResourceException) {
                    translationErrorCode = TranslationErrorCode.ILLEGAL_RESOURCE_ERROR;
                } else {
                    translationErrorCode = e instanceof EngineInterruptedException ? TranslationErrorCode.INTERRUPTED : TranslationErrorCode.COMPUTATION_ERROR;
                }
                translationTask.setErrorCode(translationErrorCode);
            }
        }
        if (job.getVerbose()) {
            for (ProcessingTask processingTask2 : job.getTasks()) {
                SimpleLogger simpleLogger = this.logger;
                StringBuilder sb = new StringBuilder();
                Iterator<T> it2 = processingTask2.getTraceList().iterator();
                while (it2.hasNext()) {
                    sb.append(((String) it2.next()) + "\n");
                }
                String sb2 = sb.toString();
                Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
                simpleLogger.debug(sb2);
            }
        }
        return job;
    }

    static /* synthetic */ List getNewPipeline$default(Pipeline pipeline, String str, String str2, String str3, int i, Object obj) {
        if ((i & 4) != 0) {
            str3 = "plain";
        }
        return pipeline.getNewPipeline(str, str2, str3);
    }

    private final List<Processor> getNewPipeline(String sourceLanguage, String targetLanguage, String mode) {
        return CollectionsKt.flatten(CollectionsKt.listOf((Object[]) new List[]{this.languageSpecFactory.create(sourceLanguage, mode).getPreProcessorList(), CollectionsKt.listOf(this.translationProcessor), this.languageSpecFactory.create(targetLanguage, mode).getPostProcessorList()}));
    }

    private final void sendFinishedJobResult(ProcessorJob job) {
        int i = job.getInterrupted() ? -1 : 0;
        for (ProcessingTask processingTask : job.getTasks()) {
            String currentText = job.getInterrupted() ? JsonProperty.USE_DEFAULT_NAME : processingTask.getRoot().getCurrentText();
            if (job.getVerbose()) {
                this.logger.debug("(SR Translation Engine) id: " + processingTask.getTranslationTask().getId() + " Code | " + i + " | Result | " + currentText);
            }
            processingTask.getTranslationTask().setTargetText(currentText);
            processingTask.getTranslationTask().setPivotResult(processingTask.getRoot().getPivotResult());
            processingTask.getTranslationTask().setThrowable(processingTask.getTranslationTask().getThrowable());
            Unit unit = Unit.INSTANCE;
            invokeCallback(i, processingTask);
        }
        this.runningJobs.remove(job.getId());
    }

    static /* synthetic */ void invokeCallback$default(Pipeline pipeline, int i, ProcessingTask processingTask, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        pipeline.invokeCallback(i, processingTask);
    }

    private final void invokeCallback(int code, ProcessingTask processorTask) {
        TranslationErrorCode translationErrorCode;
        if (code == 0) {
            TaskResultHandler resultHandler = processorTask.getResultHandler();
            if (resultHandler != null) {
                resultHandler.onSuccess(processorTask.getTranslationTask());
                return;
            }
            return;
        }
        TaskResultHandler resultHandler2 = processorTask.getResultHandler();
        if (resultHandler2 != null) {
            Exception throwable = processorTask.getTranslationTask().getThrowable();
            if (throwable == null) {
                throwable = new Exception("Exception occurs in pipeline");
            }
            Throwable throwable2 = processorTask.getTranslationTask().getThrowable();
            if (throwable2 instanceof ResourceAccessException) {
                translationErrorCode = TranslationErrorCode.RESOURCE_ACCESS_ERROR;
            } else if (throwable2 instanceof UnauthorizedResourceException) {
                translationErrorCode = TranslationErrorCode.UNAUTHORIZED_RESOURCE_ERROR;
            } else if (throwable2 instanceof IllegalResourceException) {
                translationErrorCode = TranslationErrorCode.ILLEGAL_RESOURCE_ERROR;
            } else {
                translationErrorCode = throwable2 instanceof EngineInterruptedException ? TranslationErrorCode.INTERRUPTED : TranslationErrorCode.COMPUTATION_ERROR;
            }
            resultHandler2.onFailure(new TranslationException(throwable, translationErrorCode));
        }
    }
}
