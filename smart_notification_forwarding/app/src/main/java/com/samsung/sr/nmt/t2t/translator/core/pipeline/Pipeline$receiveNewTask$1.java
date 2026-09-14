package com.samsung.sr.nmt.t2t.translator.core.pipeline;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Pipeline.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "com.samsung.sr.nmt.t2t.translator.core.pipeline.Pipeline", f = "Pipeline.kt", i = {0, 0}, l = {227}, m = "receiveNewTask", n = {"this", "baseTaskList"}, s = {"L$0", "L$1"})
/* loaded from: classes.dex */
public final class Pipeline$receiveNewTask$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ Pipeline this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Pipeline$receiveNewTask$1(Pipeline pipeline, Continuation<? super Pipeline$receiveNewTask$1> continuation) {
        super(continuation);
        this.this$0 = pipeline;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object receiveNewTask;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        receiveNewTask = this.this$0.receiveNewTask(null, null, this);
        return receiveNewTask;
    }
}
