package com.google.firebase.inappmessaging.internal.injection.modules;

import com.google.firebase.inappmessaging.internal.ProgramaticContextualTriggers;
import io.reactivex.FlowableEmitter;

/* loaded from: classes2.dex */
public final /* synthetic */ class ProgrammaticContextualTriggerFlowableModule$$Lambda$2 implements ProgramaticContextualTriggers.Listener {
    private final FlowableEmitter arg$1;

    private ProgrammaticContextualTriggerFlowableModule$$Lambda$2(FlowableEmitter flowableEmitter) {
        this.arg$1 = flowableEmitter;
    }

    public static ProgramaticContextualTriggers.Listener lambdaFactory$(FlowableEmitter flowableEmitter) {
        return new ProgrammaticContextualTriggerFlowableModule$$Lambda$2(flowableEmitter);
    }

    @Override // com.google.firebase.inappmessaging.internal.ProgramaticContextualTriggers.Listener
    public void onEventTrigger(String str) {
        this.arg$1.onNext(str);
    }
}
