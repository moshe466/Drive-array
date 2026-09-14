package com.google.firebase.inappmessaging.internal.injection.modules;

import com.google.firebase.inappmessaging.internal.ForegroundNotifier;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;

/* loaded from: classes2.dex */
public final /* synthetic */ class ForegroundFlowableModule$$Lambda$1 implements FlowableOnSubscribe {
    private final ForegroundNotifier arg$1;

    private ForegroundFlowableModule$$Lambda$1(ForegroundNotifier foregroundNotifier) {
        this.arg$1 = foregroundNotifier;
    }

    public static FlowableOnSubscribe lambdaFactory$(ForegroundNotifier foregroundNotifier) {
        return new ForegroundFlowableModule$$Lambda$1(foregroundNotifier);
    }

    @Override // io.reactivex.FlowableOnSubscribe
    public void subscribe(FlowableEmitter flowableEmitter) {
        this.arg$1.setListener(ForegroundFlowableModule$$Lambda$2.lambdaFactory$(flowableEmitter));
    }
}
