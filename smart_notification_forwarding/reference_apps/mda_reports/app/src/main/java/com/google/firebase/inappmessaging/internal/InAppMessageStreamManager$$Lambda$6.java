package com.google.firebase.inappmessaging.internal;

import io.reactivex.functions.Predicate;

/* loaded from: classes2.dex */
public final /* synthetic */ class InAppMessageStreamManager$$Lambda$6 implements Predicate {
    private static final InAppMessageStreamManager$$Lambda$6 instance = new InAppMessageStreamManager$$Lambda$6();

    private InAppMessageStreamManager$$Lambda$6() {
    }

    public static Predicate lambdaFactory$() {
        return instance;
    }

    @Override // io.reactivex.functions.Predicate
    public boolean test(Object obj) {
        return InAppMessageStreamManager.c((Boolean) obj);
    }
}
