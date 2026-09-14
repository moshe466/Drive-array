package com.google.firebase.inappmessaging.internal.injection.modules;

import com.google.firebase.inappmessaging.internal.ForegroundNotifier;
import io.reactivex.FlowableEmitter;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final /* synthetic */ class ForegroundFlowableModule$$Lambda$2 implements ForegroundNotifier.Listener {
    private final FlowableEmitter arg$1;

    private ForegroundFlowableModule$$Lambda$2(FlowableEmitter flowableEmitter) {
        this.arg$1 = flowableEmitter;
    }

    public static ForegroundNotifier.Listener lambdaFactory$(FlowableEmitter flowableEmitter) {
        return new ForegroundFlowableModule$$Lambda$2(flowableEmitter);
    }

    @Override // com.google.firebase.inappmessaging.internal.ForegroundNotifier.Listener
    public void onForeground() {
        ForegroundFlowableModule.a(this.arg$1);
    }
}
