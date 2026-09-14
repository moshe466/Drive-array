package com.google.firebase.inappmessaging.internal.injection.modules;

import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;

/* loaded from: classes2.dex */
final /* synthetic */ class ProgrammaticContextualTriggerFlowableModule$$Lambda$1 implements FlowableOnSubscribe {
    private final ProgrammaticContextualTriggerFlowableModule arg$1;

    private ProgrammaticContextualTriggerFlowableModule$$Lambda$1(ProgrammaticContextualTriggerFlowableModule programmaticContextualTriggerFlowableModule) {
        this.arg$1 = programmaticContextualTriggerFlowableModule;
    }

    public static FlowableOnSubscribe lambdaFactory$(ProgrammaticContextualTriggerFlowableModule programmaticContextualTriggerFlowableModule) {
        return new ProgrammaticContextualTriggerFlowableModule$$Lambda$1(programmaticContextualTriggerFlowableModule);
    }

    @Override // io.reactivex.FlowableOnSubscribe
    public void subscribe(FlowableEmitter flowableEmitter) {
        ProgrammaticContextualTriggerFlowableModule.a(this.arg$1, flowableEmitter);
    }
}
