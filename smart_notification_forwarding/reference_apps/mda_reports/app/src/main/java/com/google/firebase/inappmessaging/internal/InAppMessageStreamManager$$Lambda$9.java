package com.google.firebase.inappmessaging.internal;

import com.google.internal.firebase.inappmessaging.v1.CampaignProto;
import io.reactivex.functions.Predicate;

/* loaded from: classes2.dex */
public final /* synthetic */ class InAppMessageStreamManager$$Lambda$9 implements Predicate {
    private final InAppMessageStreamManager arg$1;

    private InAppMessageStreamManager$$Lambda$9(InAppMessageStreamManager inAppMessageStreamManager) {
        this.arg$1 = inAppMessageStreamManager;
    }

    public static Predicate lambdaFactory$(InAppMessageStreamManager inAppMessageStreamManager) {
        return new InAppMessageStreamManager$$Lambda$9(inAppMessageStreamManager);
    }

    @Override // io.reactivex.functions.Predicate
    public boolean test(Object obj) {
        return InAppMessageStreamManager.b(this.arg$1, (CampaignProto.ThickContent) obj);
    }
}
