package com.samsung.sr.nmt.t2t.translator.core.pipeline.processors;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.exception.EngineInterruptedException;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.exception.IllegalResourceException;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.exception.ProcessorException;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.exception.ResourceAccessException;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.exception.UnauthorizedResourceException;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Processor.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000e\n\u0000\b \u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H$J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006H\u0000¢\u0006\u0002\b\bJ\u001e\u0010\t\u001a\u00020\u0004*\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0002¨\u0006\u000f"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/processors/Processor;", JsonProperty.USE_DEFAULT_NAME, "()V", "process", JsonProperty.USE_DEFAULT_NAME, "job", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/processors/ProcessorJob;", "run", "run$translator_core", "storeThrowable", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/processors/TranslationTask;", "throwable", JsonProperty.USE_DEFAULT_NAME, "fromClass", JsonProperty.USE_DEFAULT_NAME, "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public abstract class Processor {
    protected abstract void process(ProcessorJob job) throws Exception;

    /* JADX WARN: Multi-variable type inference failed */
    public final ProcessorJob run$translator_core(ProcessorJob job) {
        ProcessorJob processorJob;
        Intrinsics.checkNotNullParameter(job, "job");
        try {
            Result.Companion companion = Result.INSTANCE;
            Processor processor = this;
            if (!job.getInterrupted()) {
                process(job);
            }
            processorJob = Result.m107constructorimpl(job);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            processorJob = Result.m107constructorimpl(ResultKt.createFailure(th));
        }
        Throwable m110exceptionOrNullimpl = Result.m110exceptionOrNullimpl(processorJob);
        if (m110exceptionOrNullimpl == null) {
            job = processorJob;
        } else {
            String simpleName = getClass().getSimpleName();
            job.setInterrupted(true);
            Iterator<T> it = job.getTasks().iterator();
            while (it.hasNext()) {
                TranslationTask translationTask = ((ProcessingTask) it.next()).getTranslationTask();
                Intrinsics.checkNotNull(simpleName);
                storeThrowable(translationTask, m110exceptionOrNullimpl, simpleName);
            }
        }
        return job;
    }

    static /* synthetic */ void storeThrowable$default(Processor processor, TranslationTask translationTask, Throwable th, String str, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: storeThrowable");
        }
        if ((i & 2) != 0) {
            str = JsonProperty.USE_DEFAULT_NAME;
        }
        processor.storeThrowable(translationTask, th, str);
    }

    private final void storeThrowable(TranslationTask translationTask, Throwable th, String str) {
        TranslationErrorCode translationErrorCode;
        boolean z = th instanceof ResourceAccessException;
        if (z) {
            translationErrorCode = TranslationErrorCode.RESOURCE_ACCESS_ERROR;
        } else if (th instanceof UnauthorizedResourceException) {
            translationErrorCode = TranslationErrorCode.UNAUTHORIZED_RESOURCE_ERROR;
        } else if (th instanceof IllegalResourceException) {
            translationErrorCode = TranslationErrorCode.ILLEGAL_RESOURCE_ERROR;
        } else {
            translationErrorCode = th instanceof EngineInterruptedException ? TranslationErrorCode.INTERRUPTED : TranslationErrorCode.COMPUTATION_ERROR;
        }
        translationTask.setErrorCode(translationErrorCode);
        if (!z && !(th instanceof UnauthorizedResourceException) && !(th instanceof IllegalResourceException) && !(th instanceof EngineInterruptedException)) {
            th = new ProcessorException("[" + str + "] " + th.getClass().getName() + ": " + th.getMessage(), th);
        }
        translationTask.setThrowable(th);
    }
}
