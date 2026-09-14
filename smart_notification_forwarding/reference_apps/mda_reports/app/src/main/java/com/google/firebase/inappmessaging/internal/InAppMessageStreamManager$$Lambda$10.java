package com.google.firebase.inappmessaging.internal;

import com.google.internal.firebase.inappmessaging.v1.CampaignProto;
import io.reactivex.functions.Predicate;

/* loaded from: classes2.dex */
public final /* synthetic */ class InAppMessageStreamManager$$Lambda$10 implements Predicate {
    private final String arg$1;

    private InAppMessageStreamManager$$Lambda$10(String str) {
        this.arg$1 = str;
    }

    public static Predicate lambdaFactory$(String str) {
        return new InAppMessageStreamManager$$Lambda$10(str);
    }

    @Override // io.reactivex.functions.Predicate
    public boolean test(Object obj) {
        boolean containsTriggeringCondition;
        containsTriggeringCondition = InAppMessageStreamManager.containsTriggeringCondition(this.arg$1, (CampaignProto.ThickContent) obj);
        return containsTriggeringCondition;
    }
}
