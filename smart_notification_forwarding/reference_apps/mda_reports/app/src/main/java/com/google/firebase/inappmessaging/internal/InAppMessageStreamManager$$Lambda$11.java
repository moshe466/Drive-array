package com.google.firebase.inappmessaging.internal;

import com.google.internal.firebase.inappmessaging.v1.CampaignProto;
import java.util.Comparator;

/* loaded from: classes2.dex */
public final /* synthetic */ class InAppMessageStreamManager$$Lambda$11 implements Comparator {
    private static final InAppMessageStreamManager$$Lambda$11 instance = new InAppMessageStreamManager$$Lambda$11();

    private InAppMessageStreamManager$$Lambda$11() {
    }

    public static Comparator lambdaFactory$() {
        return instance;
    }

    @Override // java.util.Comparator
    public int compare(Object obj, Object obj2) {
        int compareByPriority;
        compareByPriority = InAppMessageStreamManager.compareByPriority((CampaignProto.ThickContent) obj, (CampaignProto.ThickContent) obj2);
        return compareByPriority;
    }
}
