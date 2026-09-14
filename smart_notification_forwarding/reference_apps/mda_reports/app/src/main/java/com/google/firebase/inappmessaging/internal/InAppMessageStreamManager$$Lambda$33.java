package com.google.firebase.inappmessaging.internal;

import io.reactivex.Completable;
import io.reactivex.CompletableSource;
import io.reactivex.functions.Function;

/* loaded from: classes2.dex */
public final /* synthetic */ class InAppMessageStreamManager$$Lambda$33 implements Function {
    private static final InAppMessageStreamManager$$Lambda$33 instance = new InAppMessageStreamManager$$Lambda$33();

    private InAppMessageStreamManager$$Lambda$33() {
    }

    public static Function lambdaFactory$() {
        return instance;
    }

    @Override // io.reactivex.functions.Function
    public Object apply(Object obj) {
        CompletableSource complete;
        complete = Completable.complete();
        return complete;
    }
}
